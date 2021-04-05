package com.ittraining.utils.session;

import java.text.ParseException;
import java.util.Date;

import com.ittraining.utils.ConvertionDate;

public class VerifyDateSession {
	
	public static Boolean isDateAfterToday(Date dateInput) throws ParseException {
        Date today = new Date();
        String todayStr = ConvertionDate.convertDateToString(today);
        Date todayDate = ConvertionDate.convertStringToDate(todayStr);
        return todayDate.before(dateInput);
	}
	
	public static Boolean isDateBeginBeforeDateEnd(Date dateDebut, Date dateFin) {
		return dateDebut.before(dateFin);
	}
	
	public static Boolean isDateBeginAfterDateEndOtherSession(Date dateDebut, Date dateFin) {
		return dateDebut.after(dateFin);
	}
}
	
