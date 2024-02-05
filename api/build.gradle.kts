import org.hidetake.gradle.swagger.generator.GenerateSwaggerCode
import org.hidetake.gradle.swagger.generator.ResolveSwaggerTemplate

plugins {
    id("buildlogic.java-library-conventions")
    id("org.hidetake.swagger.generator") version "2.19.2"
}

dependencies {
    "swaggerUI"("org.webjars:swagger-ui:5.10.3")
    "swaggerCodegen"("io.swagger.codegen.v3:swagger-codegen-cli:3.0.46")
    "swaggerTemplate"("io.swagger.codegen.v3:swagger-codegen-generators:1.0.46")

    val jerseyVersion = "2.35"
    runtimeOnly("org.glassfish.jersey.inject:jersey-hk2:$jerseyVersion")
    implementation("org.glassfish.jersey.core:jersey-client:$jerseyVersion")
    implementation("org.glassfish.jersey.media:jersey-media-multipart:$jerseyVersion")
    implementation("org.glassfish.jersey.media:jersey-media-json-jackson:$jerseyVersion")
    implementation("org.glassfish.jersey.connectors:jersey-apache-connector:$jerseyVersion")

    val jacksonVersion = "2.13.5"
    implementation("com.fasterxml.jackson.core:jackson-core:$jacksonVersion")
    implementation("com.fasterxml.jackson.core:jackson-annotations:$jacksonVersion")
    implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:$jacksonVersion")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonVersion")

    implementation("io.swagger.core.v3:swagger-annotations:2.2.20")
}

sourceSets {
    main {
        java.srcDir("src/generated/java")
    }
}

val ospLbsApiSpecificationFile = "src/main/specs/application-api.yml"

swaggerSources {
    create("apiClient") {
        setInputFile(file(ospLbsApiSpecificationFile))
        code(closureOf<GenerateSwaggerCode> {
            language = "java"
            additionalProperties = mapOf(
                "library" to "jersey2",
                "modelPackage" to "org.example.applicationapi.model",
                "apiPackage" to "org.example.applicationapi.api",
                "invokerPackage" to "org.example.applicationapi",
                "hideGenerationTimestamp" to "true",
                "dateLibrary" to "java8",
                "java8" to "true"
            )
            outputs.upToDateWhen { false }
            templateDir = file("template")
        })
    }
}

val updateGeneratedApiClient by tasks.registering(Sync::class) {
    group = BasePlugin.BUILD_GROUP
    description = "Aktualisiert src/generated/java auf Basis von $ospLbsApiSpecificationFile"
    from(layout.buildDirectory.dir("swagger-code-apiClient/src/main/java"))
    into("src/generated/java")
    dependsOn("generateSwaggerCode")
    finalizedBy("spotlessJava", "spotlessApply")
}

val resolveSwaggerTemplate by tasks.existing(ResolveSwaggerTemplate::class);

// Manuell
val updateSwaggerTemplate by tasks.registering(Copy::class) {
    group = BasePlugin.BUILD_GROUP
    description = "Aktualisiert template mit dem von swagger-codegen-cli genutzten Standard-Template"
    from("${resolveSwaggerTemplate.get().destinationDir}/handlebars/Java")
    into("template")
    dependsOn(resolveSwaggerTemplate)
}