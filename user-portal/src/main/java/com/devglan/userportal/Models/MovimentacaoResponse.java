package com.devglan.userportal.Models;

public class MovimentacaoResponse {
    private boolean crossCity = false;
    private boolean success;
    private String html;

    public boolean isCrossCity() {
        return crossCity;
    }

    public void setCrossCity(boolean crossCity) {
        this.crossCity = crossCity;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }
}
