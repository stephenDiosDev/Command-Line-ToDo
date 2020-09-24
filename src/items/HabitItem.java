package items;

public class HabitItem extends GenericItem {
    private String description;
    private int spaceBetweenDays;
    public final int type = 4;

    public HabitItem() {
        super();
        this.description = "EMPTY";
        this.spaceBetweenDays = 0;
    }

    public HabitItem(String name, boolean completed, String desc, int sbd) {
        super(name, completed);
        this.description = desc;
        this.spaceBetweenDays = sbd;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSpaceBetweenDays(int spaceBetweenDays) {
        this.spaceBetweenDays = spaceBetweenDays;
    }

    public String getDescription() {
        return this.description;
    }

    public int getSpaceBetweenDays() {
        return this.spaceBetweenDays;
    }

    @Override
    public String toString() {
        return super.toString() + "\nDesc: " + this.description + "\nRepeat every " + spaceBetweenDays + " day(s)";
    }
}
