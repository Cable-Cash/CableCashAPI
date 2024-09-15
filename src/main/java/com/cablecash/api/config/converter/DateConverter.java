//package com.cablecash.api.config.converter;
//
//import jakarta.persistence.AttributeConverter;
//import jakarta.persistence.Converter;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//@Converter(autoApply = true)
//public class DateConverter implements AttributeConverter<Date, String> {
//
//    private static final String DATE_FORMAT = "dd/MM/yyyy";
//    private static final SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
//
//    @Override
//    public String convertToDatabaseColumn(Date date) {
//        return date != null ? formatter.format(date) : null;
//    }
//
//    @Override
//    public Date convertToEntityAttribute(String dbData) {
//        try {
//            return dbData != null ? formatter.parse(dbData) : null;
//        } catch (ParseException e) {
//            throw new RuntimeException("Erro ao converter data: " + dbData, e);
//        }
//    }
//}