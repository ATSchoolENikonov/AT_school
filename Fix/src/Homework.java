import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Homework {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Date date = new Date(91, 8, 20);
        Date nowDate = new Date();
        long diffDate = Math.abs(nowDate.getTime() - date.getTime());
        System.out.println(new SimpleDateFormat("dd-MM-yyyy").format(date));
        System.out.println(diffDate);
        long dateRun = System.currentTimeMillis();
        System.out.println("Date running: " + (dateRun - start));

        LocalDate localDate = LocalDate.of(1991, 9, 20);
        LocalDate nowLocalDate = LocalDate.now();
        long diffLocalDate = Math.abs(nowLocalDate.toEpochDay() - localDate.toEpochDay());
        Period period = Period.between(localDate, nowLocalDate);//добавил период чисто для пробы
        System.out.println(localDate);
        System.out.println(diffLocalDate);
        System.out.println(period);
        long localDateRun = System.currentTimeMillis();
        System.out.println("LocalDate running: " + (localDateRun - dateRun));

        LocalDateTime localDateTime = LocalDateTime.of(1991, 9, 20, 14, 33);
        LocalDateTime nowLocalDateTime = LocalDateTime.now();
        long diffLocalDateTime = Math.abs(localDateTime.toLocalDate().toEpochDay() - nowLocalDateTime.toLocalDate().toEpochDay());
        System.out.println(localDateTime);
        System.out.println(diffLocalDateTime);
        long localDateTimeRun = System.currentTimeMillis();
        System.out.println("LocalDateTime running: " + (localDateTimeRun - localDateRun));

        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("Asia/Kolkata"));
        ZonedDateTime nowZonedDateTime = ZonedDateTime.of(nowLocalDateTime, ZoneId.of("Asia/Kolkata"));
        long diffZonedDateTime = Math.abs(zonedDateTime.toLocalDate().toEpochDay() - nowZonedDateTime.toLocalDate().toEpochDay());
        System.out.println(zonedDateTime);
        System.out.println(diffZonedDateTime);
        long zonedDateTimeRun = System.currentTimeMillis();
        System.out.println("ZonedDateTime running: " + (zonedDateTimeRun - localDateTimeRun));

        GregorianCalendar gregorianCalendar = new GregorianCalendar(1991, 8, 20);
        Calendar nowGregorianCalendar = GregorianCalendar.getInstance();
        long diffCalendar = Math.abs(gregorianCalendar.toInstant().getEpochSecond() - nowGregorianCalendar.toInstant().getEpochSecond());
        System.out.println(gregorianCalendar.getTime());
        System.out.println(diffCalendar);
        long calendarRun = System.currentTimeMillis();
        System.out.println("GregorianCalendar running: " + (calendarRun - zonedDateTimeRun));
        long end = System.currentTimeMillis();
        System.out.println("Overall : " + (end - start));
    }
}
