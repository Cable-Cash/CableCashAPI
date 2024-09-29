package com.cablecash.api.config.converter;

import com.cablecash.api.enums.EnumTipoChave;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class EnumTipoChaveConverter implements AttributeConverter<EnumTipoChave, String> {

    @Override
    public String convertToDatabaseColumn(EnumTipoChave enumTipoChave) {
        return enumTipoChave.getTipoChave();
    }

    @Override
    public EnumTipoChave convertToEntityAttribute(String tipoChave) {
        return EnumTipoChave.fromString(tipoChave);
    }
}
