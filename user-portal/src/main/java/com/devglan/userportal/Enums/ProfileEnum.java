package com.devglan.userportal.Enums;

public enum ProfileEnum {
    CHEFE_DEPART,
    FUNCIONARIO,
    GERAL;

    public static ProfileEnum getProfile(String profile) {
        switch (profile) {
            case "Chefe de departamento": return CHEFE_DEPART;
            case "Funcionário": return FUNCIONARIO;
            case "Geral": return GERAL;
            default: return GERAL;
        }
    }
}