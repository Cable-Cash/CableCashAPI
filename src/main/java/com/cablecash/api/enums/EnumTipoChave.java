package com.cablecash.api.enums;

import lombok.Getter;

@Getter
public enum EnumTipoChave {

    CPF("CPF"),

    CNPJ("CNPJ"),

    TELEFONE("Telefone"),

    EMAIL("E-mail"),

    CHAVE_ALEATORIA("Chave aleatória");

    private final String tipoChave;

    EnumTipoChave(String tipoChave) {
        this.tipoChave = tipoChave;
    }

    public static EnumTipoChave fromString(String tipoChave) {
        for (EnumTipoChave enumTipoChave : EnumTipoChave.values()) {
            if (enumTipoChave.getTipoChave().equals(tipoChave)) {
                return enumTipoChave;
            }
        }
        throw new IllegalArgumentException("Tipo de chave não encontrado: " + tipoChave);
    }

    @Override
    public String toString() {
        return tipoChave;
    }
}
