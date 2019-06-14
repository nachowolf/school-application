package cafeteria;

public enum Menu {
    Breakfast(4, "Breakfast"),
    Lunch(6, "Lunch"),
    Snack(3, "Snack"),
    Drink(2, "Drink");

        private final int value;
    private final String description;

    Menu(int value, String description) {

           this.value = value;
           this.description = description;
        }
    public int getPrice() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("%s costing %d tokens", description, getPrice());
    }
}
