// import java.util.HashMap;
// import java.util.Map;

// public class GroceryStore {
//     private String name;
//     private Map<String, GroceryItem> inventory; // Map of item names to GroceryItem objects

//     public GroceryStore(String name) {
//         this.name = name;
//         this.inventory = new HashMap<>();
//     }

//     // Adds a new item to the store
//     public void addItem(GroceryItem item) {
//         this.inventory.put(item.getName(), item);
//     }

//     // Removes an item from the store
//     public void removeItem(String itemName) {
//         this.inventory.remove(itemName);
//     }

//     // Updates the price of an item in the store
//     public void updatePrice(String itemName, double newPrice) {
//         GroceryItem item = this.inventory.get(itemName);
//         if (item != null) {
//             item.setPricePerUnit(newPrice);
//         }
//     }

//     // Retrieves the price of an item
//     public double getPrice(String itemName) {
//         GroceryItem item = this.inventory.get(itemName);
//         return (item != null) ? item.getPricePerUnit() : 0.0;
//     }

//     // Generates an order for a given quantity of an item
//     public GroceryItemOrder getOrder(String itemName, int quantity) {
//         GroceryItem item = this.inventory.get(itemName);
//         if (item != null) {
//             return new GroceryItemOrder(item, quantity);
//         } else {
//             System.out.println("Item not found in inventory: " + itemName);
//             return null;
//         }
//     }

//     // Prints out the inventory of the store
//     @Override
//     public String toString() {
//         StringBuilder sb = new StringBuilder("Inventory of " + this.name + ":\n");
//         this.inventory.forEach((name, item) -> {
//             sb.append(item.toString()).append("\n");
//         });
//         return sb.toString();
//     }
// }


import java.util.HashMap;
import java.util.Map;

public class GroceryStore {
    private String name;
    private Map<String, GroceryItem> inventory;

    public GroceryStore(String name) {
        this.name = name;
        this.inventory = new HashMap<>();
    }

    public void addItem(GroceryItem item) {
        this.inventory.put(item.getName(), item);
    }

    public void removeItem(String itemName) {
        this.inventory.remove(itemName);
    }

    public void updatePrice(String itemName, double newPrice) {
        GroceryItem item = this.inventory.get(itemName);
        if (item != null) {
            item.setPricePerUnit(newPrice);
        }
    }

    public double getPrice(String itemName) {
        GroceryItem item = this.inventory.get(itemName);
        return item != null ? item.getPricePerUnit() : 0.0;
    }

    public GroceryItemOrder getOrder(String itemName, int quantity) {
        GroceryItem item = this.inventory.get(itemName);
        if (item != null) {
            return new GroceryItemOrder(item, quantity);
        } else {
            System.out.println("Item not found in inventory: " + itemName);
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Inventory of " + this.name + ":\n");
        this.inventory.forEach((key, item) -> {
            sb.append(item.getName()).append(": $").append(String.format("%.2f", item.getPricePerUnit())).append("\n");
        });
        return sb.toString();
    }
}

