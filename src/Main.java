import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("\n\nHello, AssignmentsApp!\n");
        //Output the current date-time.
        LocalDateTime today = LocalDateTime.now();
        System.out.println("today is " + today);

        //Output tomorrow's date using a formatter.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");
        String formatDateTime = today.plusDays(1).format(formatter);
        System.out.println("formatted tomorrows date is " + formatDateTime);

        //Add 5 weeks to today's LocalDateTime.
        LocalDateTime fiveWeeksInTheFutureToday = today.plusWeeks(5);
        System.out.println("five weeks from now: " + fiveWeeksInTheFutureToday);

        //Initialize a LocalDateTime object to your birthdate and the time 12:35 PM.
        LocalDateTime birthday = LocalDateTime.of(1999, 07, 10, 12, 35);
        System.out.println("my birthday is: " + birthday);

        //Output the day of the week (Sunday-Saturday) that you were born.
        DayOfWeek dayIwasBorn = birthday.getDayOfWeek();
        System.out.println("the day I was born was " + dayIwasBorn);

        //Output the number of days you've been alive.
        int daysIveBeenAlive = (int) ChronoUnit.DAYS.between(birthday, today);
        System.out.println("I've been alive for " + daysIveBeenAlive + " days");

        //Output the number of days between two dates.
        long daysBetween = daysBetweenTwoDates(birthday, today);
        System.out.println("daysBetween method test: " + daysBetween + " days");

        //Output the number of days between two dates.
        LocalDateTime earlierDate = earlierDate(birthday, today);
        System.out.println("the earlier date is: " + earlierDate);

        //Create a file with 100 random "month/day/year  hour:minutes" (in that format) on each line.
        addRandomDatesToFile("random.txt",100);


    }

    private static void addRandomDatesToFile(String filename, int datesNum) throws FileNotFoundException {
        File file = new File(filename);
        if (file.exists()) {
            System.out.println("Oh no, you're going to overwrite the data in the file!");
        }
       LocalDateTime today = LocalDateTime.now();
        Random seconds = new Random();
        try(PrintWriter pw = new PrintWriter(file)){
            for (int i = 0; i < datesNum; i++) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                pw.println(today.minusSeconds(seconds.nextInt()).format(formatter));
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }



    }

    private static LocalDateTime earlierDate(LocalDateTime date1, LocalDateTime date2) {
        LocalDateTime earlierDate;
        if (date1.isBefore(date2)) {
            earlierDate = date1;
        } else {
            earlierDate = date2;
        }
        return earlierDate;
    }

    private static long daysBetweenTwoDates(LocalDateTime date1, LocalDateTime date2) {
        long daysBetween = ChronoUnit.DAYS.between(date1, date2);
        return daysBetween;
    }


}
