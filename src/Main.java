import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n\nHello, AssignmentsApp!\n");
        //Output the current date-time.
        LocalDateTime today = LocalDateTime.now();
        System.out.println("today is "+ today);

        //Output tomorrow's date using a formatter.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");
        String formatDateTime = today.plusDays(1).format(formatter);
        System.out.println("formatted tomorrows date is " +formatDateTime);

        //Add 5 weeks to today's LocalDateTime.
        LocalDateTime fiveWeeksInTheFutureToday = today.plusWeeks(5);
        System.out.println("five weeks from now: " + fiveWeeksInTheFutureToday);

        //Initialize a LocalDateTime object to your birthdate and the time 12:35 PM.
       LocalDateTime birthday = LocalDateTime.of(1999,07,10,12,35);
        System.out.println("my birthday is: " + birthday);

        //Output the day of the week (Sunday-Saturday) that you were born.
        DayOfWeek dayIwasBorn = birthday.getDayOfWeek();
        System.out.println("the day I was born was "+ dayIwasBorn);

        //Output the number of days you've been alive.
        int daysIveBeenAlive = (int) ChronoUnit.DAYS.between(birthday,today);
        System.out.println("I've been alive for "+ daysIveBeenAlive + " days");

        //Output the number of days between two dates.
        long daysBetween = daysBetweenTwoDates(birthday,today);
        System.out.println("daysBetween method test: " + daysBetween + " days");



    }

    private static long daysBetweenTwoDates(LocalDateTime date1, LocalDateTime date2) {
        long daysBetween = ChronoUnit.DAYS.between(date1,date2);
        return daysBetween;
    }


}
