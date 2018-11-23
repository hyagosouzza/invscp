package com.devglan.userportal.Enums;

public enum CatDepre {
    PERMANENTE,
    CONSUMO;

    public static CatDepre getCatDepre(String categoria) {
        switch (categoria) {
            case "Bem Permanente": return PERMANENTE;
            case "Bem de Consumo": return CONSUMO;
            default: return PERMANENTE;
        }
    }
}
