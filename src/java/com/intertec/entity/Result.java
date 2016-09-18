package com.intertec.entity;

import java.util.List;

public class Result {
    private Boolean isValid;
    private List<String> validNames;

    public Result() {
    }

    public Result(Boolean isValid, List<String> validNames) {
        this.isValid = isValid;
        this.validNames = validNames;
    }

    public List<String> getValidNames() {
        return validNames;
    }

    public void setValidNames(List<String> validNames) {
        this.validNames = validNames;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }
        
}
