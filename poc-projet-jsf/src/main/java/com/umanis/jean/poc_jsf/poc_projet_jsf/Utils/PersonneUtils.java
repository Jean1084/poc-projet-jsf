package com.umanis.jean.poc_jsf.poc_projet_jsf.Utils;


import java.time.*;
import java.time.format.*;
import java.util.Date;

/**
 *
 * @author Jean
 */
public class PersonneUtils {
    private static final String DATE_PATTERN = "dd/MM/yyyy";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);

    /**
     * @param word
     * @return word <==> Word
     */
    public static String capitalize(String word) {
        if (!isNullOrWithSpace(word)) {
            return Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
        } else {
            return null;
        }
    }

    /**
     *
     * @param localDate
     * @return LocalDate ==> Date
     */
    public static Date asDate(LocalDate localDate) {
        Instant instant = localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    /**
     *
     * @param date
     * @return Date ==> LocalDate
     */
    public static LocalDate asLocalDate(Date date) {
        Instant instant = date.toInstant();
        return instant.atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     *
     * @param dateString
     * @return String ==> LocalDate
     */
    public static LocalDate parse(String dateString) {
        try {
            return LocalDate.parse(dateString, DATE_FORMATTER);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    /**
     *
     * @param dateString
     * @return
     */
    public static boolean validDate(String dateString) {
        return parse(dateString) != null;
    }

    /**
     *
     * @param date
     * @return LocalDate ==> String
     */
    public static String format(LocalDate date) {
        if (date == null) {
            return null;
        }
        return DATE_FORMATTER.format(date);
    }

    /**
     * Calcule un age
     *
     * @param ddn
     * @return
     */
    public static int calculAge(Date ddn) {
        LocalDate naissance = asLocalDate(ddn);
        LocalDate maintenant = LocalDate.now();
        Period period = Period.between(naissance, maintenant);
        return period.getYears();
    }
    
    public static int calculAge(LocalDate ddn) {
        LocalDate maintenant = LocalDate.now();
        Period period = Period.between(ddn, maintenant);
        return period.getYears();
    }

//    /**
//     * Hash un mot de passe
//     *
//     * @param mdp
//     * @return
//     */
//    public static String hashGuava(String mdp) {
//        return Hashing.sha512().hashString(mdp, StandardCharsets.UTF_8).toString();
//    }

    /**
     *
     * @param mot
     * @return
     */
    public static boolean isNullOrWithSpace(String mot) {
        return mot == null || mot.trim().length() == 0;
    }
}