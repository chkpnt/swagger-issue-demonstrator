/*
 * application-api
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 1.0
 *
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package org.example.applicationapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * RequestErrorInfo
 */
public class RequestErrorInfo {
    @JsonProperty("status")
    private String status = null;

    @JsonProperty("code")
    private String code = null;

    @JsonProperty("messages")
    private List<String> messages = null;

    public RequestErrorInfo status(String status) {
        this.status = status;
        return this;
    }

    /**
     * Get status
     * @return status
     **/
    @Schema(description = "")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RequestErrorInfo code(String code) {
        this.code = code;
        return this;
    }

    /**
     * The HTTP response code.
     * @return code
     **/
    @Schema(description = "The HTTP response code.")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public RequestErrorInfo messages(List<String> messages) {
        this.messages = messages;
        return this;
    }

    public RequestErrorInfo addMessagesItem(String messagesItem) {
        if (this.messages == null) {
            this.messages = new ArrayList<>();
        }
        this.messages.add(messagesItem);
        return this;
    }

    /**
     * Get messages
     * @return messages
     **/
    @Schema(description = "")
    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RequestErrorInfo requestErrorInfo = (RequestErrorInfo) o;
        return Objects.equals(this.status, requestErrorInfo.status)
                && Objects.equals(this.code, requestErrorInfo.code)
                && Objects.equals(this.messages, requestErrorInfo.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, code, messages);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RequestErrorInfo {\n");

        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    code: ").append(toIndentedString(code)).append("\n");
        sb.append("    messages: ").append(toIndentedString(messages)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
