package com.java4h.ilcarro.business.config;
/*
 * Created by "Mark Tsimerman" on 5/24/2020
 */

public class FieldsConfiguration {
    public static final int CAR_ID_MIN_LENGTH = 7;
    public static final int CAR_ID_MAX_LENGTH = 9;
    public static final String CAR_ID_ERROR_MSG =
            "Local registration number must be " + CAR_ID_MIN_LENGTH + "-" + CAR_ID_MAX_LENGTH + " characters long";
    public static final String LOCAL_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String LOCAL_DATE_FORMAT = "yyyy-MM-dd";
    public static final int CAR_YEAR_VALID_MIN = 1885;      // Actually first modern car was made
    public static final int CAR_YEAR_VALID_MAX = 2100;
    public static final int MAX_FUTURE_MODEL_YEAR = 1;      // + number of years from the current

}
