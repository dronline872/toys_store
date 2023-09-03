class Doll extends Toy {
    public Doll(int id, String name, int quantity, double frequency) {
        super(id, name, quantity, frequency);
    }

    @Override
    public String getType() {
        return "Кукла";
    }
}