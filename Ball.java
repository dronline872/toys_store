class Ball extends Toy {
    public Ball(int id, String name, int quantity, double frequency) {
        super(id, name, quantity, frequency);
    }

    @Override
    public String getType() {
        return "Мяч";
    }
}