import java.time.LocalDateTime;

public class Assignments {
    public enum Course{DATASTRUCTURES,CALCULUS,SPEECH,TENNIS,FRESHMAN_SEMINAR,ENGLISH}
    public enum Category {PAPER,ONLINE}
    public enum Priority{LOW,MEDIUM,HIGH}
    private LocalDateTime dueDate;
    private Course course;
    private Category category;
    private Priority priority;

    public Assignments(LocalDateTime dueDate, Course course, Category category, Priority priority) {
        this.dueDate = dueDate;
        this.course=course;
        this.category=category;
       this.priority=priority;


    }
    @Override
    public boolean equals(Object assign1) {
        Assignments assign= (Assignments)assign1;
        if (assign.getDueDate().equals(this.getDueDate())&& assign.getCourse().equals(this.getCourse())&& assign.getCategory().equals(this.getCategory())&& assign.getPriority().equals(this.getPriority())){
            return true;
        }
        else{
            return false;
        }
    }

    public Assignments() {
    }

    @Override
    public String toString() {
        return "Assignments{" + "dueDate=" + dueDate + ", course=" + course + ", category=" + category + ", priority=" + priority + '}';
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public Course getCourse() {
        return course;
    }

    public Category getCategory() {
        return category;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
