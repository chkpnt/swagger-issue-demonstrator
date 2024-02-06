package org.example.applicationapi.model;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.applicationapi.JSON;
import org.junit.jupiter.api.Test;

class PassierscheinA38Test {

    @Test
    void testSerialization() throws JsonProcessingException {
        var application = new PassierscheinA38();
        application.setApplicationType(ApplicationType.PASSIERSCHEINA38);
        application.setApplicationDescription("New Passierschein A38");
        application.setApplicant("Obelix");

        var objectMapper = new JSON().getContext(null);
        var actualJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(application);
        System.out.println(actualJson);

        var expectedJson = "{\n" + "  \"application_type\" : \"PassierscheinA38\",\n"
                + "  \"application_description\" : \"New Passierschein A38\",\n"
                + "  \"applicant\" : \"Obelix\"\n"
                + "}";
        assertEquals(expectedJson, actualJson);
    }
}
