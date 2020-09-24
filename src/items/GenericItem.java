package items;

public class GenericItem {
    private String name;
    private boolean completed;
    public int type = 1;

    public GenericItem() {
        this.name = "EMPTY";
        this.completed = false;
    }

    public GenericItem(String name, boolean completed) {
        this.name = name;
        this.completed = completed;
    }

    public String getName() {
        return this.name;
    }

    public boolean isCompleted() {
        return this.completed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "\nName: " + this.name + "\nStatus: " + this.completed;
    }
}
