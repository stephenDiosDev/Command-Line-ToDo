package items;

import java.time.LocalDate;

public class DeadlineItem extends GenericItem{
    private LocalDate deadline;
    private String description;
    public final int type = 3;

    public DeadlineItem() {
        super();
        this.description = "EMPTY";
    }

    public DeadlineItem(String name, boolean completed, String desc, LocalDate due) {
        super(name, completed);
        this.description = desc;
        this.deadline = due;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getDescription() {
        return this.description;
    }

    public LocalDate getDeadline() {
        return this.deadline;
    }

    @Override
    public String toString() {
        return super.toString() + " Desc: " + this.description + " Due Date: " + deadline.toString();
    }
}
