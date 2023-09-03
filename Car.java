class Car extends Toy {
    public Car(int id, String name, int quantity, double frequency) {
        super(id, name, quantity, frequency);
    }

    @Override
    public String getType() {
        return "Машинка";
    }
}