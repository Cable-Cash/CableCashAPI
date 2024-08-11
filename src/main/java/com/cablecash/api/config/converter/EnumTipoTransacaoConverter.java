package com.cablecash.api.config.converter;

import com.cablecash.api.enums.EnumTipoTransacao;
import jakarta.persistence.AttributeConverter;

public class EnumTipoTransacaoConverter implements AttributeConverter<EnumTipoTransacao, String> {

    @Override
    public String convertToDatabaseColumn(EnumTipoTransacao attribute) {
        return attribute.getTipoTransacao();
    }

    @Override
    public EnumTipoTransacao convertToEntityAttribute(String dbData) {
        return EnumTipoTransacao.valueOf(dbData);
    }
}
