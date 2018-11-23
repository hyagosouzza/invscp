package com.devglan.userportal.Enums;

public enum GrupoMaterialEnum {
    ELETRO,
    INFORMATICA,
    DIDATICO,
    MOVEIS;

    public static GrupoMaterialEnum getGrupoMaterial(String grupoMaterial) {
        switch (grupoMaterial) {
            case "Eletrodoméstico": return ELETRO;
            case "Informática": return INFORMATICA;
            case "Didático": return DIDATICO;
            case "Móveis": return MOVEIS;
            default: return MOVEIS;
        }
    }
}
