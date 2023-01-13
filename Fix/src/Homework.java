import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.GregorianCalendar;

public class Homework {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Date date = new Date(91, 8, 20);
        Date nowDate = new Date();
        long diffDate = Math.abs(nowDate.getTime() - date.getTime());
        System.out.println(new SimpleDateFormat("dd-MM-yyyy").format(date));
        System.out.println(new SimpleDateFormat("GG-dd-MM-D-yyyy").format(date));
        System.out.println(new SimpleDateFormat("GG-dd-mm-w-yyyy").format(date));
        System.out.println(new SimpleDateFormat("GG-dd-MM-u-yyyy").format(date));
        System.out.println(new SimpleDateFormat("GG-dd-W-MM-E").format(date));
        System.out.println(diffDate);
        long dateRun = System.currentTimeMillis();
        System.out.println("Date running: " + (dateRun - start));


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("GG-dd-MM-D-yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("W-dd-MM-w-yyyy");
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("D-dd-MM-w-yyyy");
        DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("E-dd-MM-w-yyyy");
        LocalDate localDate = LocalDate.of(1991, 9, 20);
        System.out.println("Формат 1: " + formatter.format(localDate));
        System.out.println("Формат 2: " + formatter1.format(localDate));
        System.out.println("Формат 3: " + formatter2.format(localDate));
        System.out.println("Формат 4: " + formatter3.format(localDate));
        System.out.println("Формат 5: " + formatter4.format(localDate));
        LocalDate nowLocalDate = LocalDate.now();
        long diffLocalDate = Math.abs(nowLocalDate.toEpochDay() - localDate.toEpochDay());
        Period period = Period.between(localDate, nowLocalDate);//добавил период чисто для пробы
        System.out.println(diffLocalDate);
        System.out.println(period);
        long localDateRun = System.currentTimeMillis();
        System.out.println("LocalDate running: " + (localDateRun - dateRun));

        LocalDateTime localDateTime = LocalDateTime.of(1991, 9, 20, 14, 33);
        System.out.println("Формат 1: " + formatter.format(localDateTime));
        System.out.println("Формат 2: " + formatter1.format(localDateTime));
        System.out.println("Формат 3: " + formatter2.format(localDateTime));
        System.out.println("Формат 4: " + formatter3.format(localDateTime));
        System.out.println("Формат 5: " + formatter4.format(localDateTime));
        LocalDateTime nowLocalDateTime = LocalDateTime.now();
        long diffLocalDateTime = Math.abs(localDateTime.toLocalDate().toEpochDay() - nowLocalDateTime.toLocalDate().toEpochDay());
        System.out.println(diffLocalDateTime);
        long localDateTimeRun = System.nanoTime();
        System.out.println("LocalDateTime running: " + (localDateTimeRun - localDateRun));


        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("Asia/Kolkata"));
        System.out.println("Формат 1: " + formatter.format(zonedDateTime));
        System.out.println("Формат 2: " + formatter1.format(zonedDateTime));
        System.out.println("Формат 3: " + formatter2.format(zonedDateTime));
        System.out.println("Формат 4: " + formatter3.format(zonedDateTime));
        System.out.println("Формат 5: " + formatter4.format(zonedDateTime));
        ZonedDateTime nowZonedDateTime = ZonedDateTime.of(nowLocalDateTime, ZoneId.of("Asia/Kolkata"));
        long diffZonedDateTime = Math.abs(zonedDateTime.toLocalDate().toEpochDay() - nowZonedDateTime.toLocalDate().toEpochDay());
        System.out.println(diffZonedDateTime);
        long zonedDateTimeRun = System.nanoTime();
        System.out.println("ZonedDateTime running: " + (zonedDateTimeRun - localDateTimeRun));

        GregorianCalendar gregorianCalendar = new GregorianCalendar(1991, 8, 20);
        Calendar nowGregorianCalendar = GregorianCalendar.getInstance();
        long diffCalendar = Math.abs(gregorianCalendar.toInstant().getEpochSecond() - nowGregorianCalendar.toInstant().getEpochSecond());
        System.out.println(gregorianCalendar.getTime());
        System.out.println(gregorianCalendar.toZonedDateTime().format(formatter));
        System.out.println(gregorianCalendar.toZonedDateTime().format(formatter1));
        System.out.println(gregorianCalendar.toZonedDateTime().format(formatter2));
        System.out.println(gregorianCalendar.toZonedDateTime().format(formatter3));
        System.out.println(gregorianCalendar.toZonedDateTime().format(formatter4));
        System.out.println(diffCalendar);
        long calendarRun = System.nanoTime();
        System.out.println("GregorianCalendar running: " + (calendarRun - zonedDateTimeRun));
        long end = System.currentTimeMillis();
        System.out.println("Overall : " + (end - start));
    }
}
