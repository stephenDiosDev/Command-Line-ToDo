package items;

public class WorkItem extends GenericItem {
    private String description;
    public final int type = 2;

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

    @Override
    public String toString() {
        return super.toString() + "\nDesc: " + this.description;
    }
}
