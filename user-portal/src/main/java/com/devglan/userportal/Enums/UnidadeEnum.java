package com.devglan.userportal.Enums;

public enum UnidadeEnum {

    REGIONAL_CATALAO,
    REGIONAL_JATAI,
    REGIONAL_GOIAS,
    CAMPUS_COLEMAR,
    CAMPUS_SAMAMBAIA,
    CAMPUS_APAREC_GNA;

    public static UnidadeEnum getUnidadeAdm(String unidade) {
        switch (unidade) {
            case "Regional Catalão": return REGIONAL_CATALAO;
            case "Regional Jataí": return REGIONAL_JATAI;
            case "Regional Goiás": return REGIONAL_GOIAS;
            case "Câmpus Colemar Natal e Silva": return CAMPUS_COLEMAR;
            case "Regional Samambaia": return CAMPUS_SAMAMBAIA;
            case "Regional Aparecida de Goiânia": return CAMPUS_APAREC_GNA;
            default: return CAMPUS_SAMAMBAIA;
        }
    }

}