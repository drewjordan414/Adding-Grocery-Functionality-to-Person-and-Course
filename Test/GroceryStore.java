import java.util.HashMap;
import java.util.Map;

public class GroceryStore {
    private String name;
    private Map<String, Double> inventory; // Maps item name to price

    public GroceryStore(String name) {
        this.name = name;
        this.inventory = new HashMap<>();
    }

    public void addItem(String itemName, double pricePerUnit) {
        inventory.put(itemName, pricePerUnit);
    }

    public double getPrice(String itemName) {
        return inventory.getOrDefault(itemName, 0.0);
    }

    // Method to get a GroceryItemOrder by name and quantity
    // Useful for adding items to a GroceryList by the person
    public GroceryItemOrder getOrder(String itemName, int quantity) {
        if (inventory.containsKey(itemName)) {
            return new GroceryItemOrder(itemName, quantity, inventory.get(itemName));
        } else {
            System.out.println("Item not found in inventory.");
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Inventory of " + name + ":\n");
        inventory.forEach((item, price) -> sb.append(item).append(": $").append(String.format("%.2f", price)).append("\n"));
        return sb.toString();
    }
}
