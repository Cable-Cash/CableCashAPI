package com.cablecash.api.config.serializer;

import com.cablecash.api.enums.EnumTipoChave;
import com.cablecash.api.model.dto.ChavePIXDTO;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class PIXFormatterSerializer extends JsonSerializer<ChavePIXDTO> {

    @Override
    public void serialize(ChavePIXDTO chavePIXDTO, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("id", chavePIXDTO.getId());
        gen.writeStringField("tipoChave", chavePIXDTO.getTipoChave());

        if (EnumTipoChave.CPF.getTipoChave().equals(chavePIXDTO.getTipoChave())) {
            gen.writeFieldName("valorChave");
            new CpfFormatterSerializer().serialize(chavePIXDTO.getValorChave(), gen, serializers);
        } else if (EnumTipoChave.TELEFONE.getTipoChave().equals(chavePIXDTO.getTipoChave())) {
            gen.writeFieldName("valorChave");
            new TelefoneFormatterSerializer().serialize(chavePIXDTO.getValorChave(), gen, serializers);
        } else {
            gen.writeStringField("valorChave", chavePIXDTO.getValorChave());
        }

        gen.writeStringField("dataCriacao", String.valueOf(chavePIXDTO.getDataCriacao()));
        gen.writeNumberField("cliente", chavePIXDTO.getCliente());
        gen.writeNumberField("conta", chavePIXDTO.getConta());
        gen.writeEndObject();
    }
}
