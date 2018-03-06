import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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



    }



}
