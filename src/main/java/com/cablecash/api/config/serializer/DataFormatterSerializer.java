package com.cablecash.api.config.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataFormatterSerializer extends JsonSerializer<Date> {
    private static final SimpleDateFormat dataFormatter = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void serialize(Date date, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        String dataFormatada = dataFormatter.format(date);
        gen.writeString(dataFormatada);
    }
}
