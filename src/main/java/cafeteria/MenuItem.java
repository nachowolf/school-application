package cafeteria;

public enum MenuItem {
    Breakfast(4, "Breakfast"),
    Lunch(6, "Lunch"),
    Snack(3, "Snack"),
    Drink(2, "Drink");

        private final int value;
    private final String description;

    MenuItem(int value, String description) {

           this.value = value;
           this.description = description;
        }
    public int getPrice() {
        return value;
    }

    public String getItem(){
        return description;
    }

    @Override
    public String toString() {
        return String.format("%s costing %d tokens", description, getPrice());
    }
}
