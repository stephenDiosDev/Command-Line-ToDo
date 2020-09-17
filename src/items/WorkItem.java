package items;

public class WorkItem extends GenericItem{
    private String description;

    public WorkItem() {
        super();
    }

    public WorkItem(String name, boolean completed, String desc) {
        super(name, completed);
        this.description = desc;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
