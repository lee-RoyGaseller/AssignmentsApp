import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

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
        System.out.println("the earlier date is: " + earlierDate.format(formatter));

        //Create a file with 100 random "month/day/year  hour:minutes" (in that format) on each line.
        addRandomDatesToFile("random.txt",100);



        //Store data from the file into an ArrayList of LocalDateTime objects.
        ArrayList<LocalDateTime> randomDates = new ArrayList<>();
        addFileDatesToList("random.txt", randomDates);
        System.out.println("list of random dates: "+ randomDates);

        //Output the number of stored dates in the year [Y]
        outPutOfDesiredYear(randomDates, 1981);

        //Count the number of stored dates in the current year.
        outPutOfDesiredYear(randomDates, today.getYear());

        //Count the number of duplicates.
        Set<LocalDateTime> randomUniqueDates = new HashSet<>();
        System.out.println("number of Duplicates " + countNumDuplicates(randomDates,randomUniqueDates));

        //Sort the dates in chronological order.
        ArrayList<LocalDateTime> sortedDates = new ArrayList<>();
        randomDatesInOrder(randomDates,sortedDates);
        System.out.println("sorted dates: "+ sortedDates);

        //Count the number of duplicates in a sorted list without using a Java Set.
        System.out.println("num of dupes without using a set: "+ countNumDuplicatesWithoutSet(randomDates));

        //Count the number of evening (after 6pm) dates.
        System.out.println("evening dates: "+ numOfDatesAfterSpecifiedHour(randomDates,06));

        //Count the number of dates in each of the individual 12 months without using a Java Map.
        ArrayList<Integer> months = new ArrayList<>();
        for (int i = 1; i <=12 ; i++) {
            months.add(i);
        }
        ArrayList<Integer>numOfDatesInMonthArrayList = new ArrayList<>();
        System.out.println("dates in each month: " +numOfDatesInMonth(randomDates,months,numOfDatesInMonthArrayList));

        //Count the number of dates in each of the individual 12 months using a Java Map.
        System.out.println("dates in each month with map:"+ numOfDatesInMonthWithMap(randomDates,numOfDatesInMonthArrayList));


        //Determine the index of the latest LocalDateTime.








    }

    private static Map<Integer, Integer> numOfDatesInMonthWithMap(ArrayList<LocalDateTime> randomDates, ArrayList<Integer> numOfDatesInMonthArrayList) {
        Map<Integer,Integer> numOfDatesInMonthMap = new HashMap<>();
        for (int i = 0; i <numOfDatesInMonthArrayList.size() ; i++) {
            numOfDatesInMonthMap.put(i+1,numOfDatesInMonthArrayList.get(i));
        }
        return numOfDatesInMonthMap;
    }

    private static ArrayList<Integer> numOfDatesInMonth(ArrayList<LocalDateTime> randomDates, ArrayList<Integer> months, ArrayList<Integer> numOfDatesInMonthArrayList) {
        for (int i = 0; i <months.size() ; i++) {
            int num=0;
            for (int j = 0; j <randomDates.size() ; j++) {
                if (randomDates.get(j).getMonthValue() ==months.get(i)){
                    num++;
                }

            }
            numOfDatesInMonthArrayList.add(num);
            
        }
        return numOfDatesInMonthArrayList;
    }

    private static int numOfDatesAfterSpecifiedHour(ArrayList<LocalDateTime> randomDates, int time) {
        int datesAfterYourTime = 0;
        for (int i = 0; i <randomDates.size() ; i++) {
            if(randomDates.get(i).getHour() >= time){
                datesAfterYourTime++;
            }
        }
        return datesAfterYourTime;
    }

    private static int countNumDuplicatesWithoutSet(ArrayList<LocalDateTime> randomDates) {
        int duplicates = 0;
        for (int i = 0; i <randomDates.size() ; i++) {
            for (int j = i+1; j <randomDates.size() ; j++) {
                if (randomDates.get(i).isEqual(randomDates.get(j))){
                    duplicates++;
                }

            }

        }
        return duplicates;
    }

    private static void randomDatesInOrder(ArrayList<LocalDateTime> randomDates, ArrayList<LocalDateTime> sortedDates) {
        Collections.sort(randomDates);
        for (int i = 0; i <randomDates.size() ; i++) {
            sortedDates.add(randomDates.get(i));
        }
    }

    private static int countNumDuplicates(ArrayList<LocalDateTime> randomDates, Set<LocalDateTime> randomUniqueDates) {
        for (int i = 0; i <randomDates.size() ; i++) {
            randomUniqueDates.add(randomDates.get(i));

        }
        int dif = randomDates.size() - randomUniqueDates.size();
        return dif;
    }


    private static void outPutOfDesiredYear(ArrayList<LocalDateTime> randomDates, int year) {
        for (int i = 0; i <randomDates.size() ; i++) {
            if (randomDates.get(i).getYear() == year){
                System.out.println("desired year " + randomDates.get(i));
            }

        }
    }

    private static ArrayList<LocalDateTime> addFileDatesToList(String fileName, ArrayList<LocalDateTime> randomDates) {
        File infile = new File(fileName);
        if( ! infile.exists() ) {
            System.out.println( "Oh no, you can't read from a file that doesn't exist!" );
        } else {
            try( Scanner scan = new Scanner( infile ) ) {
                while( scan.hasNext() ) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-yyyy-dd HH:mm");
                    LocalDateTime date = LocalDateTime.parse(scan.nextLine(),formatter);
                    randomDates.add(date);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return randomDates;
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
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-yyyy-dd HH:mm");
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
