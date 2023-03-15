package com.oracle.conversor.api;

import java.util.HashMap;
import java.util.Map;

public class ListReponse {
    private boolean success;
    private Map<String, String> currencies = new HashMap<>();

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Map<String, String> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Map<String, String> currencies) {
        this.currencies = currencies;
    }
}
