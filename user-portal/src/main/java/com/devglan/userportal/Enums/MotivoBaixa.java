package com.devglan.userportal.Enums;

public enum MotivoBaixa {
    INSERVIVEL,
    QUEBRA_DESGASTE_AVARIA,
    VENDA_EXERC_ANTERIORES,
    EXTRAVIO,
    FURTO_ROUBO,
    VENDA_LEILAO;

    public static MotivoBaixa getMotivoBaixa(String motivo) {
        switch (motivo) {
            case "Por inservível": return INSERVIVEL;
            case "Por quebra, desgaste ou avaria": return QUEBRA_DESGASTE_AVARIA;
            case "Por venda em exercícios anteriores": return VENDA_EXERC_ANTERIORES;
            case "Por extravio": return EXTRAVIO;
            case "Por venda direta ou leilão": return FURTO_ROUBO;
            case "Por furto/roubo": return VENDA_LEILAO;
            default: return QUEBRA_DESGASTE_AVARIA;
        }
    }
}
