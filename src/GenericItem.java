public class GenericItem {
    private String name;
    private boolean completed;

    public GenericItem (String name, boolean completed) {
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
}
