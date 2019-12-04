package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	//将日期字符串转换成Date类型
	public static Date stringToDate(String str) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(str);
		return date;   
	}
	//将Date类型转换成Calendar类型
	public static Calendar datetocalendar(Date date)  {
       Calendar calendar = Calendar.getInstance();
       calendar.setTime(date);
       return calendar;
       
	}
	
	//将Date类型转换成Calendar类型
	public static Calendar dateToCalendar(Date date){
		Calendar instance = Calendar.getInstance();
		instance.setTime(date);
		return instance;
	}
	//将日期字符串转换成Calendar类型
	public static Calendar stringToCalendar(String str) throws ParseException{
		 Date date = stringToDate(str);
		 return datetocalendar(date);
	}
	
	//根据日期算年龄
	//字符创类型的日期
	public static int getAge(String birthday) throws ParseException{
		Calendar calendar = stringToCalendar(birthday);
		calendar.setTime(stringToDate(birthday));
		int age = calendar.get(Calendar.YEAR);
		Calendar instance = Calendar.getInstance();
		int age2 = instance.get(Calendar.YEAR);
		return age2-age;
	}
	//判断到未来需要的天数
	public static int getFutureDays(String future) throws ParseException{
		Date date = new Date();
		long time = date.getTime();
		
		Date toDate = stringToDate(future);
		long time2 = toDate.getTime();
		long dt=time2-time;
		int day=(int)(dt/1000/60/60/24);
		return day;
	}
	//日期比较
	public static boolean compareTo(Date date,Date date2){
		long time = date.getTime();
		long time2 = date.getTime();
		return time-time2>0?true:false;
	}
	
	//判断给定日期是否是当天
	public static boolean isToday(String str) throws ParseException{
		Calendar instance = Calendar.getInstance();
		instance.setTime(new Date());
		instance.get(Calendar.YEAR);
		instance.get(Calendar.MONTH);
		instance.get(Calendar.DAY_OF_MONTH);
		
		int futureDays = getFutureDays(str);
		if(futureDays==0){
			return true;
		}
		return false;
	}
	
	
	//判断当前给定的日期是否在本周之内
	public static boolean isDayInWeek(String date) throws ParseException{
		Calendar instance = Calendar.getInstance();
		instance.setTime(new Date());
		int year = instance.get(Calendar.YEAR);
		int month = instance.get(Calendar.MONTH);
		int dayOfWeek = instance.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		System.out.println(year);
		System.out.println(month);
		System.out.println(dayOfWeek);
		Date stringToDate = stringToDate(date);
		Calendar dateToCalendar = dateToCalendar(stringToDate);
		int year1 = dateToCalendar.get(Calendar.YEAR);
		int month1 = dateToCalendar.get(Calendar.MONTH);
		int dayOfWeek1 = dateToCalendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		System.out.println(year1);
		System.out.println(month1);
		System.out.println(dayOfWeek1);
		if(year==year1&&month==month1&&dayOfWeek==dayOfWeek1) {
			return true;
		}
		 else{
		  return false;
		 }
		}
	
	//给定时间对象，初始化到该年初的1月1日0时0分0秒0毫秒
	public static void setInitDate(String str) throws ParseException{
		Date date = stringToDate(str);
		Calendar calendar = datetocalendar(date);
		calendar.set(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_YEAR, 1);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		System.out.println(calendar.getTime());
	}
	
	   //方法二
	public static Date getDateByMonthInit(Date date){
		Calendar instance = Calendar.getInstance();
		instance.setTime(date);
		int year = instance.get(Calendar.YEAR);
		int month = instance.get(Calendar.MONTH);
		instance.clear();
		instance.set(Calendar.YEAR, year);
		instance.set(Calendar.MONTH, month);
		instance.set(Calendar.HOUR, 0);
		return instance.getTime();
	}
    public static void main(String[] args) throws ParseException {	
		
		
		
		boolean b = isDayInWeek("2019-12-9");
		System.out.println(b);
	}
}
