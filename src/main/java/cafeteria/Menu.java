package cafeteria;

public enum Menu {
    Breakfast(4),
    Lunch(6),
    Snack(3),
    Drink(2);

        private final int value;

       Menu(int value) {
            this.value = value;
        }
    public int getPrice() {
        return value;
    }

}
