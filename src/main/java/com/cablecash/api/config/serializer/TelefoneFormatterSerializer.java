package com.cablecash.api.config.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class TelefoneFormatterSerializer extends JsonSerializer<String> {
    @Override
    public void serialize(String telefone, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (telefone != null) {
            String telefoneFormatter;
            if (telefone.length() == 10) {
                telefoneFormatter = String.format("(%s) %s-%s",
                        telefone.substring(0, 2),
                        telefone.substring(2, 6),
                        telefone.substring(6, 10));
            } else if (telefone.length() == 11) {
                telefoneFormatter = String.format("(%s) %s-%s",
                        telefone.substring(0, 2),
                        telefone.substring(2, 7),
                        telefone.substring(7, 11));
            } else {
                telefoneFormatter = telefone;
            }
            gen.writeString(telefoneFormatter);
        } else {
            gen.writeString(telefone);
        }
    }
}
