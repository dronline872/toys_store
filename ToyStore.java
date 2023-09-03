import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyStore {
    private List<Toy> toys = new ArrayList<>();

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void updateToyFrequency(int id, double frequency) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setFrequency(frequency);
                break;
            }
        }
    }

    public Toy choosePrizeToy() {
        Random random = new Random();
        double totalFrequency = toys.stream().mapToDouble(Toy::getFrequency).sum();
        double randomValue = random.nextDouble() * totalFrequency;

        for (Toy toy : toys) {
            randomValue -= toy.getFrequency();
            if (randomValue <= 0) {
                Toy prizeToy = toy;
                toy.decreaseQuantity();
                return prizeToy;
            }
        }

        return null;
    }

    public void writeToTextFile(Toy prizeToy, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write("Призовая игрушка: " + prizeToy.getType() + " - " + prizeToy.getName() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();
  
        toyStore.addToy(new Doll(1, "Barbie", 10, 10));
        toyStore.addToy(new Car(2, "Tesla", 15, 10));
        toyStore.addToy(new Ball(3, "Adidas", 20, 50));

        toyStore.updateToyFrequency(2, 80.0);

        Toy prizeToy = toyStore.choosePrizeToy();
        if (prizeToy != null) {
            toyStore.writeToTextFile(prizeToy, "призы.txt");
        }
    }
}