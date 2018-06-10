package com.InterviewProject.InterviewProject.infra;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;

import java.sql.Date;
import java.util.Locale;

public class DateUtils {

    public static final Locale LOCALE_PT_BR = new Locale("pt", "BR");
    public static final String PATTERN_DATABASE =  "yyyy-MM-dd";


    private DateUtils() {
        throw new AssertionError("Não instanciável!");
    }

    public static final String getDataFormatadaUsandoPattern(String pattern, LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern(pattern).withLocale(LOCALE_PT_BR);

        return formatter.print(date);
    }

    public static final LocalDate getDataAtual() {
        return LocalDate.now();
    }
    public static final DateTime getDataHoraAtual() {
        return DateTime.now();
    }
    public static final Date getDateFromLocalDate(LocalDate data) {
        return Date.valueOf(data.toString());
    }

    public static LocalDate converterStringParaLocalDate(String valor, String padraoData) {
        LocalDate data = null;
        if (org.apache.commons.lang3.StringUtils.isNotBlank(valor)) {
            DateTimeFormatter formatador = getFormatadorData(padraoData);
            data = formatador.parseDateTime(valor.trim()).toLocalDate();
        }
        return data;
    }

    private static DateTimeFormatter getFormatadorData(String padraoData) {
        return new DateTimeFormatterBuilder().appendPattern(padraoData).toFormatter()
                .withLocale(LOCALE_PT_BR);
    }
}
