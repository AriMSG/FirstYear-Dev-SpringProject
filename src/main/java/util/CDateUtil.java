
package util;

import java.util.Date;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @version 1.0
 * 클래스 설명<br>
 * Date관련 각종 기능성 Method를 제공하는 Util Class<br>
 */
public class CDateUtil
{
    public static final long MILLISECONDS_IN_HOUR = 60L * 60L * 1000L;
    
    private static final MessageFormat sDashForm = new MessageFormat("{0}-{1}-{2}");
    private static final MessageFormat sCommaForm = new MessageFormat("{0}.{1}.{2}");
    private static final MessageFormat sSlashForm = new MessageFormat("{0}/{1}/{2}");
    private static final MessageFormat sBlankForm = new MessageFormat("{0}{1}{2}");

    private static final SimpleDateFormat dDashForm = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat dCommaForm = new SimpleDateFormat("yyyy.MM.dd");
    private static final SimpleDateFormat dSlashForm = new SimpleDateFormat("yyyy/MM/dd");
    private static final SimpleDateFormat dBlankForm = new SimpleDateFormat("yyyyMMdd");
    private static final SimpleDateFormat dSecondForm = new SimpleDateFormat("yyyy-MM-dd H:m:s");
        
    public static Calendar getCurrentCalendar()
    {
        return Calendar.getInstance();
    }

    
    
    /**
     * 현재 일자을 YYYYMMDD 형식으로 반환한다.
     * @return 현재일자(YYYMMDD)
     */
    public static String getCurrentDate()
    {
        Calendar cal = getCurrentCalendar();

        String currentYear = String.valueOf(cal.get(Calendar.YEAR));
        String currentMonth = String.valueOf((cal.get(Calendar.MONTH) + 1));
        String currentDay = String.valueOf(cal.get(Calendar.DATE));

        if (Integer.parseInt(currentMonth) < 10) currentMonth = "0"
                + currentMonth;

        if (Integer.parseInt(currentDay) < 10) currentDay = "0" + currentDay;

        String vCurrentDate = currentYear + currentMonth + currentDay;

        return vCurrentDate;
    }
    
    /**
     * 현재 일자에 일정 Day를 합한 일자를 YYYYMMDD 형식으로 반환한다.
     * @param day 추가할 일자
     * @return day가 추가된 일자(YYYYMMDD)
     */
    public static String addDay(int day)
    {
        Calendar cal = getCurrentCalendar();
        cal.add(Calendar.DATE, day);

        Date tmpDate = new Date(cal.getTimeInMillis());
        return date2Str(tmpDate, ' ');
    }
    
    /**
     * 현재 일자에 일정 Day를 뺀 일자를 YYYYMMDD 형식으로 반환한다.
     * @param day 뺄 일자
     * @return day가 빠진 일자(YYYYMMDD)
     */
    public static String minusDay(int day)
    {
        return addDay(-1 * day);
    }
    
    /**
     * 기준 일자에 일정 Day를 합한 일자를 YYYYMMDD 형식으로 반환한다.
     * @param targetDate 기준일자
     * @param day 추가할 일자
     * @return 기준일자에 day가 추가된 일자(YYYYMMDD)
     */
    public static String addDay(String targetDate, int day)
    {
        Calendar cal = str2Calendar(targetDate);
        cal.add(Calendar.DATE, day);

        Date tmpDate = new Date(cal.getTimeInMillis());

        if(targetDate.indexOf('-') != -1)
            return date2Str(tmpDate, '-');
        else if(targetDate.indexOf('.') != -1)
            return date2Str(tmpDate, '.');
        else if(targetDate.indexOf('/') != -1)
            return date2Str(tmpDate, '/');
        else
            return date2Str(tmpDate, ' ');
    }

    /**
     * 기준 일자에 일정 Day를 뺀 일자를 YYYYMMDD 형식으로 반환한다.
     * @param targetDate 기준일자
     * @param day 뺄 일자
     * @return 기준일자에 day가 빠진 일자(YYYYMMDD)
     */
    public static String minusDay(String targetDate, int day)
    {
        Calendar cal = str2Calendar(targetDate);
        cal.add(Calendar.DATE, -1 * day);

        Date tmpDate = new Date(cal.getTimeInMillis());

        if(targetDate.indexOf('-') != -1)
            return date2Str(tmpDate, '-');
        else if(targetDate.indexOf('.') != -1)
            return date2Str(tmpDate, '.');
        else if(targetDate.indexOf('/') != -1)
            return date2Str(tmpDate, '/');
        else
            return date2Str(tmpDate, ' ');
    }
    
    /**
     * 날짜 Format을 변경기능을 제공
     * maskType으로 '-', '.', '/', ''의 Format을 지원
     * @param cToStr Format을 변경코저하는 일자 String
     * @param maskType 변경코저 하는 maskType 
     * @return 변환된 String
     */
    
    /* 
		작성일		:	2019-04-18
		작성자		:	민순기 
		수정사항	:	1. 관련코드 추가
						1-1 코드간의 결합성을 낮추기 위한 작업
		수정 코드	:	CDateUtil.java
		코드검색	:	190418으로 검색
	*/
    
    /* 190418 S A */
    public static String str2Str(String cToStr, char maskType)
    {
    	String returnString = "";
    	
    	if (cToStr != null && !cToStr.equals(""))
    	{
    		if(cToStr.length() > 8)
    		{
    			cToStr = CDateUtil.deleteChar(cToStr, '-');
    			cToStr = CDateUtil.deleteChar(cToStr, '.');
    			cToStr = CDateUtil.deleteChar(cToStr, '/');
    		}
    		
    		String[] tmpStrings = {cToStr.substring(0, 4),cToStr.substring(4, 6),cToStr.substring(6, 8)};
    
    		switch(maskType)
    		{
    			case '-' :
    				returnString = sDashForm.format(tmpStrings);
    				break;
    				
    			case '.' :
    				returnString = sCommaForm.format(tmpStrings);
    				break;
    
    			case '/' :
    				returnString = sSlashForm.format(tmpStrings);
    				break;
    				
    			default :
    				returnString = sBlankForm.format(tmpStrings);
    				break;
    		}
    	}
    
    	return returnString;
    }
    
	public static String deleteChar(String strString, char strChar)
	{
    	if ( isBlank(strString) )
    		return "";
    
    	strString = strString.trim();
    	byte[] source = strString.getBytes();
    	byte[] result = new byte[source.length];
    	int j = 0;
    	for (int i = 0; i < source.length; i++)
    	{
    		if (source[i] == (byte)strChar )
    			i++;

    		result[j++] = source[i];
    	}

    	return new String(result).trim();
	}
	
	public static boolean isBlank(String tmpString)
	{
		if(isNull(tmpString))
			return true;

        if(tmpString.equals(""))
        	return true;

        return false;
	}

    /**
     * 날짜 String을 java.sql.Date 형식으로 변환하는 기능 제공
     * @param cToStr Date형으로 변환할 날짜 String
     * @return Date Object
     */
    public static Date str2Date(String cToStr)
    {
    	if ( !CDateUtil.isBlank(cToStr) )
    	{
    		String cTemp = str2Str(cToStr, '-');
//    		Date cToDate = Date.valueOf(cTemp);
    		java.sql.Date cToDate = java.sql.Date.valueOf(cTemp);
    		return cToDate;
    	}
    
    	return null;
    }


    /* 190418 S E */
    
    
    /**
     * 날짜 String을 Calendar 형식으로 변환하는 기능을 제공
     * @param cToStr Date형으로 변환할 날짜 String
     * @return 변환된 Calendar
     */
    public static Calendar str2Calendar(String cToStr)
    {
        Date tmpDate = str2Date(cToStr);
        
        if( !CDateUtil.isNull(tmpDate) )
        {
            Calendar tmpCalendar = Calendar.getInstance();
            tmpCalendar.setTime(tmpDate);
            
            return tmpCalendar;
        }
        
        return null;
    }
    
	public static boolean isNull(Object tmpObject)
	{
		if(tmpObject == null)
			return true;

        return false;
	}

    /**
     * java.sqlDate를 날짜 String으로 변환하는 기능 제공
     * maskType으로 '-', '.', '/', ''의 Format을 지원 (':'일시에는 시:분:초 포함) 
     * @param cToDate 날짜 String으로 변경코저하는 Date Object
     * @param maskType 변경코저 하는 maskType
     * @return 날짜 String
     */
    public static String date2Str(Date cToDate, char maskType)
    {
    	String returnString = "";
    	
    	if (cToDate != null)
    	{
    		switch(maskType)
    		{
    			case '-' :
    				returnString = dDashForm.format(cToDate);
    				break;
    				
    			case '.' :
    				returnString = dCommaForm.format(cToDate);
    				break;
    
    			case '/' :
    				returnString = dSlashForm.format(cToDate);
    				break;
    				
    			case ':' :
    			    returnString = dSecondForm.format(cToDate);
    			    break;
    				
    			default :
    				returnString = dBlankForm.format(cToDate);
    				break;
    		}
    	}
    
    	return returnString;
    }


    /**
     * Date를 Calendar로 변환한다.
     * Date(yyyy-mm-dd) -> Calendar
     * @param cToDate Date
     * @return 변환된 Calendar
     */
    public static final Calendar date2Calendar(Date cToDate)
    {
    	if (cToDate != null)
    	{
    		java.util.Calendar dateToCal = java.util.Calendar.getInstance();
    		dateToCal.setTime(cToDate);
    		dateToCal.add(java.util.Calendar.DATE, 0);
    		return dateToCal;
    	}
    	return null;
    }


    /**
     * Date를 TimeStamp로 변환한다.
     * Date(yyyy-mm-dd) -> TimeStamp
     * @param cToDate Date
     * @return Timestamp
     */
    public static final Timestamp date2Timestamp(Date cToDate)
    {
    	if (cToDate != null)
    	{
    		Timestamp tsDate = new Timestamp(cToDate.getTime());
    		return tsDate;
    	}
    	return null;
    }


    /**
     * 시작일자와 종료일자 사이의 일수를 구한다.<BR>
     * 일자 형식은 "YYYYMMDD"로 한다.<BR>
     * 예를 들어 20020501 ~ 20020510 = 9 <BR>
     * @param   sFromDate    : 시작일 YYYYMMDD<BR>
     * @param   sToDate      : 종료일 YYYYMMDD<BR>
     * @return  long         : 일수간격<BR>
     */
    public static long daysBetween(String sFromDate, String sToDate)
    {
        Date fDate = str2Date(sFromDate);
        Date tDate = str2Date(sToDate);
        
        return daysBetween(fDate, tDate);
    }
    
    /**
     * 시작일자와 종료일자 사이의 일수를 구한다.
     * @param d1 시작일자
     * @param d2 종료일자
     * @return 시작일자와 종료일자 사이 일수
     */
    public static long daysBetween(Date d1, Date d2)
    {
        return ((d2.getTime() - d1.getTime() + MILLISECONDS_IN_HOUR) / (MILLISECONDS_IN_HOUR * 24));
    }   
    
    
    /**
     * 두개의 날짜를 String으로 입력받아 비교하는 메소드
     * stdDate > compDate : true, stdDate <= compDate : false;
     * @param stdDate 기준Date
     * @param compDate 비교Date
     * @return boolean (stdDate > compDate : true, stdDate <= compDate : false)
     */
    public static boolean compareDate(String stdDate, String compDate)
    {
       Calendar cd1 = str2Calendar(stdDate);
       Calendar cd2 = str2Calendar(compDate);
       
       if (cd1.after(cd2))
          return true;
       
       return false;
    } 
    
    /**
     * Timestampe를 String으로 변환한다.
     * @param tmValue
     * @return "yyyy-MM-dd HH:mm:ss"
     */
    public static String timestamp2Str(Timestamp tmValue)
    {
    	SimpleDateFormat timeKeyFormat  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	return timeKeyFormat.format( tmValue);
    }

    /**
     * 회사 설립일 부터 현재년 +5년 까지의 select박스를 만드는 함수 
     */
    public static String getSelectYear(String name) {
    	int year = Calendar.getInstance().get(Calendar.YEAR);
    	
    	String select = "<select name='"+name+"' id='"+name+"'>";
    	for(int i = 1990; i < year+5; i++)
    	{
    		if(year != i)
    			select += "<option value='"+i+"'>"+i+"년"+"</option>";
    		else
    			select += "<option value='"+i+"' selected='selected'>"+i+"년"+"</option>";
    	}
    	select += "</select>";	
    	
    	return  select;
    }
    
    /**
     * 회사 설립일 부터 현재년 +5년 까지의 select박스를 만드는 함수 (onchange 추가)
     */
    public static String getSelectYearOnchange(String name) {
    	int year = Calendar.getInstance().get(Calendar.YEAR);
    	
    	String select = "<select name='"+name+"' id='"+name+"' onchange=changeSelectBox();>";
    	for(int i = 1990; i < year+5; i++)
    	{
    		if(year != i)
    			select += "<option value='"+i+"'>"+i+"년"+"</option>";
    		else
    			select += "<option value='"+i+"' selected='selected'>"+i+"년"+"</option>";
    	}
    	select += "</select>";	
    	
    	return  select;
    }

}