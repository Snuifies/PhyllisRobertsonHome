
package com.bmw.flexapp.rest.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "queue"
})
public class ErrorResponse {

    @JsonProperty("exceptionmessage")
    private String exceptionmessage;
    
    @JsonProperty("exceptionmessage")
    public String getMessage() {
        return exceptionmessage;
    }

    @JsonProperty("exceptionmessage")
    public void setMessage(String exceptionmessage) {
        this.exceptionmessage = exceptionmessage;
    }

}
