package com.devglan.userportal.Enums;

public enum GrupoMaterialEnum {
    ELETRO,
    INFORMATICA,
    DIDATICO,
    MOVEIS,
    FERRAMENTA,
    EQUIPAMENTO_INDUSTRIAL,
    VEICULO_LEVE,
    VEICULO_PESADO;

    public static GrupoMaterialEnum getGrupoMaterial(String grupoMaterial) {
        switch (grupoMaterial) {
            case "Eletrodoméstico": return ELETRO;
            case "Informática": return INFORMATICA;
            case "Didático": return DIDATICO;
            case "Móveis": return MOVEIS;
            case "Ferramenta": return FERRAMENTA;
            case "Máquina ou equipamento industrial": return EQUIPAMENTO_INDUSTRIAL;
            case "Veículo leve": return VEICULO_LEVE;
            case "Veículo Pesado": return VEICULO_PESADO;
            default: return MOVEIS;
        }
    }
}
