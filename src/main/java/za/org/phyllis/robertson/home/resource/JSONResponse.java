
package com.bmw.flexapp.rest.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "queue"
})
public class JSONResponse {

    @JsonProperty("exceptions")
    private List<ErrorResponse> exceptions;
    @JsonProperty("result")
    private StandardResponse result;

    @JsonProperty("exceptions")
    public List<ErrorResponse> getExceptions() {
        return exceptions;
    }

    @JsonProperty("exceptions")
    public void setExceptions(List<ErrorResponse> exceptions) {
        this.exceptions = exceptions;
    }
    
    public void addError(ErrorResponse errorResponse){
    	if(null == exceptions){
    		exceptions = new ArrayList<ErrorResponse>();
    	}
    	exceptions.add(errorResponse);
    }

    @JsonProperty("result")
    public StandardResponse getResult() {
        return result;
    }

    @JsonProperty("result")
    public void setResult(StandardResponse result) {
        this.result = result;
    }

}
