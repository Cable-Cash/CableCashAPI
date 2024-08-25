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
            if (telefone.length() == 13) {
                telefoneFormatter = String.format("+%s (%s) %s-%s",
                        telefone.substring(0, 2),
                        telefone.substring(2, 4),
                        telefone.substring(4, 9),
                        telefone.substring(9, 13));
            } else if (telefone.length() == 12) {
                telefoneFormatter = String.format("+%s (%s) %s-%s",
                        telefone.substring(0, 2),
                        telefone.substring(2, 4),
                        telefone.substring(4, 8),
                        telefone.substring(8, 12));
            } else {
                telefoneFormatter = telefone;
            }
            gen.writeString(telefoneFormatter);
        } else {
            gen.writeString(telefone);
        }
    }
}
