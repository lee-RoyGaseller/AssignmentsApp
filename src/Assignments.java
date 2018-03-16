import java.time.LocalDateTime;

public class Assignments {
    public enum Course{DATASTRUCTURES,CALCULUS,SPEECH,TENNIS,FRESHMAN_SEMINAR,ENGLISH}
    public enum Category {PAPER,ONLINE}
    public enum Priority{LOW,MEDIUM,HIGH}
    private LocalDateTime dueDate;

    public Assignments(LocalDateTime dueDate, Course course, Category category, Priority priority) {
        this.dueDate = dueDate;
        course=course;
        category=category;
        priority=priority;


    }
}
