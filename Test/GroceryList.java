import java.util.ArrayList;
import java.util.List;

public class GroceryList {
    private List<GroceryItemOrder> items; // List to store grocery items

    public GroceryList() {
        this.items = new ArrayList<>();
    }
    
    public List<GroceryItemOrder> getItems() {
        // Assuming you want to return a List instead of an array for easier use
        List<GroceryItemOrder> itemList = new ArrayList<>();
        for (GroceryItemOrder item : items) { // Assuming 'items' is an array or a collection
            if (item != null) {
                itemList.add(item);
            }
        }
        return itemList;
    }
    // Method to add a grocery item to the list
    public void add(GroceryItemOrder item) {
        // Check if item already exists
        for (GroceryItemOrder order : items) {
            if (order.getItem().getName().equalsIgnoreCase(item.getItem().getName())) {
                order.setQuantity(order.getQuantity() + item.getQuantity());
                return;
            }
        }
        // If item doesn't exist, add new item
        items.add(item);
    }

    // Method to remove a specific item from the list by its name
    public boolean removeItem(String itemName) {
        return items.removeIf(order -> order.getItem().getName().equalsIgnoreCase(itemName));
    }

    // Method to calculate the total cost of all items in the list
    public double getTotalCost() {
        return items.stream().mapToDouble(GroceryItemOrder::getCost).sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Grocery List:\n");
        for (GroceryItemOrder order : items) {
            sb.append(order).append("\n"); // Append each item's string representation
        }
        sb.append("Total Cost: $").append(String.format("%.2f", getTotalCost())); // Append total cost
        return sb.toString();
    }
}
