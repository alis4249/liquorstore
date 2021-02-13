package com.sundar.liquorstore.ServerResponse;

public class cartResponse {
    private String status;

    public cartResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
