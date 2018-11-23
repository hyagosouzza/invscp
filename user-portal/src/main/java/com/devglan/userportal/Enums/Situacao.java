package com.devglan.userportal.Enums;

public enum Situacao {
    BAIXADO,
    INCORPORADO,
    EM_CONSERTO;

    public static Situacao getSituacao(String situacao) {
        switch (situacao) {
            case "Baixado": return BAIXADO;
            case "Incorporado": return INCORPORADO;
            case "Em conserto": return EM_CONSERTO;
            default: return BAIXADO;
        }
    }
}
