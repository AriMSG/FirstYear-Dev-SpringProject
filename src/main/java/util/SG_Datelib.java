package util;

import java.util.*;

public class SG_Datelib {
	
	Calendar cal = Calendar.getInstance();
	Date d = new Date(cal.getTimeInMillis());
	public static void DateSet() {
		
	}

	public static Date DateTypeChange(Calendar cal) {
		// Calendar => Date
		Date date = new Date(cal.getTimeInMillis());
		return date;
	}
	public static Calendar DateTypeChange(Date date) {
		// Date => Calendar
		Calendar result = Calendar.getInstance();
		result.setTime(date);
		return result;
	}
	public static void TestCode() {
		Calendar cal1 = Calendar.getInstance();
		System.out.println("이해의 년도 		: 	" + cal1.get(Calendar.YEAR));
		System.out.println("월 (0~11, 0:1월) 	:	" + cal1.get(Calendar.MONTH));
		System.out.println("이 해의 몇 째 주 		:	" + cal1.get(Calendar.WEEK_OF_YEAR));
		System.out.println("이 달의 몇 째 주 		:	" + cal1.get(Calendar.WEEK_OF_MONTH));
		System.out.println("이 달의 몇 일 		:	" + cal1.get(Calendar.DATE));
		System.out.println("이 달의 몇 일 		:	" + cal1.get(Calendar.DAY_OF_MONTH));
		System.out.println("이 해의 몇 일 		:	" + cal1.get(Calendar.DAY_OF_YEAR));
		System.out.println("요일(1~7, 1:일요일)	:	" + cal1.get(Calendar.DAY_OF_WEEK));
		System.out.println("이 달의 몇 째 요일		:	" + cal1.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		System.out.println("0:오전 1:오후		:	" + cal1.get(Calendar.AM_PM));
		System.out.println("시간(0~11)		:	" + cal1.get(Calendar.HOUR));
		System.out.println("시간(0~23)		:	" + cal1.get(Calendar.HOUR_OF_DAY));
		System.out.println("분(0~59)			:	" + cal1.get(Calendar.MINUTE));
		System.out.println("초(0~59)			:	" + cal1.get(Calendar.SECOND));
		System.out.println("1000분의 1초(0~999)	:	" + cal1.get(Calendar.MILLISECOND));
		System.out.println("TimeZone(-12~+12)	:	" + (cal1.get(Calendar.ZONE_OFFSET)/(60*60*1000)));
		System.out.println("이 달의 마지막 날		:	" + cal1.getActualMaximum(Calendar.DATE));
		
		Calendar cal2 = Calendar.getInstance();  // getInstance() 오늘의 날짜를 가져옴.
		cal1.set(2019, 7,15);
	}
}
