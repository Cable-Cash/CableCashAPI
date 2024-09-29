package com.cablecash.api.enums;

import lombok.Getter;

@Getter
public enum EnumTipoConta {

    CONTA_CORRENTE("Conta Corrente"),

    CONTA_POUPANCA("Conta Poupança"),

    CONTA_SALARIO("Conta Salário"),

    CONTA_CONJUNTA("Conta Conjunta"),

    CONTA_UNIVERSITARIA("Conta Universitária");

    private final String tipoConta;

    EnumTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public static EnumTipoConta fromString(String tipoConta) {
        for (EnumTipoConta enumTipoConta : EnumTipoConta.values()) {
            if (enumTipoConta.getTipoConta().equals(tipoConta)) {
                return enumTipoConta;
            }
        }
        throw new IllegalArgumentException("Tipo de conta não encontrado: " + tipoConta);
    }

    @Override
    public String toString() {
        return tipoConta;
    }

}
