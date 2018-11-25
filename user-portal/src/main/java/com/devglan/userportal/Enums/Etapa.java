package com.devglan.userportal.Enums;

public enum Etapa {
    AC_ENTRADA,
    AC_SAIDA,
    FINALIZADA,
    CANCELADA;

    public static Etapa getEtapa(String etapa) {
        switch (etapa) {
            case "Aceite de entrada": return AC_ENTRADA;
            case "Aceite de saída": return AC_SAIDA;
            case "Finalizada": return FINALIZADA;
            case "Cancelada": return CANCELADA;
            default: return AC_ENTRADA;
        }
    }
}
