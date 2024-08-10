package com.cablecash.api.config.converter;

import com.cablecash.api.enums.EnumTipoConta;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class EnumTipoContaConverter implements AttributeConverter<EnumTipoConta, String> {

    @Override
    public String convertToDatabaseColumn(EnumTipoConta enumTipoConta) {
        return enumTipoConta.getTipoConta();
    }

    @Override
    public EnumTipoConta convertToEntityAttribute(String tipoConta) {
        return EnumTipoConta.fromString(tipoConta);
    }

}
