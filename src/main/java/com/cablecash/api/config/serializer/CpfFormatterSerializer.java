package com.cablecash.api.config.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class CpfFormatterSerializer extends JsonSerializer<String> {
    @Override
    public void serialize(String cpf, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (cpf != null) {
            String cpfFormatter =
                    String.format("%s.%s.%s-%s",
                    cpf.substring(0, 3),
                    cpf.substring(3, 6),
                    cpf.substring(6, 9),
                    cpf.substring(9, 11));
            gen.writeString(cpfFormatter);
        } else {
            gen.writeString(cpf);
        }
    }
}
