package assignmentmanager;

import java.time.LocalDateTime;

public class Assignment {
    private LocalDateTime deadline;
    private String subject;
    private String task;
    private int page;

    // Constructor
    public Assignment(LocalDateTime deadline, String subject, String task, int page) {
        this.deadline = deadline;
        this.subject = subject;
        this.task = task;
        this.page = page;
    }

    // Getters
    public LocalDateTime getDeadline() {
        return deadline;
    }
    public String getSubject() {
        return subject;
    }
    public String getTask() {
        return task;
    }
    public int getPage() {
        return page;
    }
}
