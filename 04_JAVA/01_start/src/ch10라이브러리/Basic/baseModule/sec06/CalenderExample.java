package ch10라이브러리.Basic.baseModule.sec06;

import java.util.Calendar;

public class CalenderExample {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int day = calendar.get(Calendar.DATE);
        System.out.println(year+"년 "+month+"월 "+day+"일");

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        String strDay="";

        switch(dayOfWeek) {
            case Calendar.MONDAY: strDay="월"; break;
            case Calendar.TUESDAY: strDay="화"; break;
            case Calendar.WEDNESDAY: strDay="수"; break;
            case Calendar.THURSDAY: strDay="목"; break;
            case Calendar.FRIDAY: strDay="금"; break;
            case Calendar.SATURDAY: strDay="토"; break;
            case Calendar.SUNDAY: strDay="일"; break;
        }

        int amPm = calendar.get(Calendar.AM_PM);
        String strAmPm=(amPm==Calendar.AM)?"오전":"오후";
        System.out.println(strDay+"요일 "+strAmPm);

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        System.out.println(hour+"시 "+minute+"분 "+second+"초");

    }
}
