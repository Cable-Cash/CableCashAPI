package com.cablecash.api.enums;

import lombok.Getter;

@Getter
public enum EnumTipoTransacao {

    TRANSFERENCIA("Transferência"),
    PIX("PIX"),
    TED("TED"),
    DOC("DOC"),
    CARTAO_CREDITO("Cartão Crédito"),
    CARTAO_DEBITO("Cartão Débito"),
    BOLETO("Boleto"),
    CREDITO_CONSIGNADO("Crédito Consignado"),
    DEPOSITO("Depósito"),
    SAQUE("Saque");

    private final String tipoTransacao;

    EnumTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public static EnumTipoTransacao fromString(String tipoTransacao) {
        for (EnumTipoTransacao enumTipoTransacao : EnumTipoTransacao.values()) {
            if (enumTipoTransacao.getTipoTransacao().equals(tipoTransacao)) {
                return enumTipoTransacao;
            }
        }
        throw new IllegalArgumentException("Tipo de transação não encontrado: " + tipoTransacao);
    }

    @Override
    public String toString() {
        return tipoTransacao;
    }
}
