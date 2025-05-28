public class Item {
    private String description;
    private boolean isDone;
    private String isDoneMark;

    public Item(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
        markAsDone();
    }

    private void markAsDone() {
        if (isDone) {
            isDoneMark = "Done";
        }
        else {
            isDoneMark = "Not Done";
        }
    }

    @Override
    public String toString(){
        return description + ", " + isDoneMark;
    }
}