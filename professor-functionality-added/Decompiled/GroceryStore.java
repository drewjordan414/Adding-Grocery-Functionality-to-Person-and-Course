package Working.Decompiled;

import java.util.HashMap;
import java.util.Map;

public class GroceryStore {
    private String name;
    private Map<String, Double> inventory;

    public GroceryStore(String name) {
        this.name = name;
        this.inventory = new HashMap<>();
    }

    public void addItem(String itemName, double pricePerUnit) {
        this.inventory.put(itemName, pricePerUnit);
    }

    public void removeItem(String itemName) {
        this.inventory.remove(itemName);
    }

    public void updatePrice(String itemName, double newPrice) {
        if (this.inventory.containsKey(itemName)) {
            this.inventory.put(itemName, newPrice);
        }
    }

    public double getPrice(String itemName) {
        return this.inventory.getOrDefault(itemName, 0.0);
    }

    public GroceryItemOrder getOrder(String itemName, int quantity) {
        Double price = this.inventory.get(itemName);
        if (price != null) {
            return new GroceryItemOrder(itemName, quantity, price);
        } else {
            System.out.println("Item not found in inventory: " + itemName);
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Inventory of " + this.name + ":\n");
        this.inventory.forEach((item, price) -> {
            sb.append(item).append(": $").append(String.format("%.2f", price)).append("\n");
        });
        return sb.toString();
    }
}


// Changes Made:
// Error Handling: Modified the getOrder method to handle null values more appropriately by checking if the price is null before attempting to create a new GroceryItemOrder.
// Inventory Management: Added methods to remove an item and update the price of an item in the inventory, allowing for more flexible management of the store's offerings.
// Data Handling Improvements: Ensured that the operations on the map are safe and check for the existence of keys before performing updates.
