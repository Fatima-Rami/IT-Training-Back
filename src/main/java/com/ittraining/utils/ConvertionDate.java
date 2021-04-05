package com.ittraining.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertionDate {
	
	public static String convertDateToString(Date inputDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(inputDate);
	}
	
    public static Date convertStringToDate(String inputStringDate) throws ParseException {
        return new SimpleDateFormat("dd/MM/yyyy").parse(inputStringDate);
    }

}
