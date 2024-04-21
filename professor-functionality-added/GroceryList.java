import java.util.ArrayList;
import java.util.List;

// public class GroceryList {
//     private List<GroceryItemOrder> items; // List to store grocery items

//     public GroceryList() {
//         this.items = new ArrayList<>();
//     }

//     public List<GroceryItemOrder> getItems() {
//         // Assuming you want to return a List instead of an array for easier use
//         List<GroceryItemOrder> itemList = new ArrayList<>();
//         for (GroceryItemOrder item : items) { // Assuming 'items' is an array or a collection
//             if (item != null) {
//                 itemList.add(item);
//             }
//         }
//         return itemList;
//     }
//     // Method to add a grocery item to the list
//     public void add(GroceryItemOrder item) {
//         // Check if item already exists
//         for (GroceryItemOrder order : items) {
//             if (order.getItem().getName().equalsIgnoreCase(item.getItem().getName())) {
//                 order.setQuantity(order.getQuantity() + item.getQuantity());
//                 return;
//             }
//         }
//         // If item doesn't exist, add new item
//         items.add(item);
//     }

//     // Method to remove a specific item from the list by its name
//     public boolean removeItem(String itemName) {
//         return items.removeIf(order -> order.getItem().getName().equalsIgnoreCase(itemName));
//     }

//     // Method to calculate the total cost of all items in the list
//     public double getTotalCost() {
//         return items.stream().mapToDouble(GroceryItemOrder::getCost).sum();
//     }

//     @Override
//     public String toString() {
//         StringBuilder sb = new StringBuilder("Grocery List:\n");
//         for (GroceryItemOrder order : items) {
//             sb.append(order).append("\n"); // Append each item's string representation
//         }
//         sb.append("Total Cost: $").append(String.format("%.2f", getTotalCost())); // Append total cost
//         return sb.toString();
//     }
// }



public class GroceryList {
    private static final int MAX_ITEMS = 10; // Maximum number of items the list can hold
    private GroceryItemOrder[] items = new GroceryItemOrder[MAX_ITEMS]; // Array to store grocery items
    private int itemCount = 0; // Counter to track the number of items in the list

    public GroceryList() {
    }

    // Method to add a grocery item to the list
    public void add(GroceryItemOrder item) {
        if (itemCount < MAX_ITEMS) {
            items[itemCount++] = item; // Add item if there is space
        } else {
            System.out.println("Grocery list is full. Cannot add more items."); // Notify when list is full
        }
    }

    public List<GroceryItemOrder> getItems() {
        // Convert the array to a list for easier handling
        List<GroceryItemOrder> itemList = new ArrayList<>();
        for (int i = 0; i < itemCount; i++) {
            if (items[i] != null) {
                itemList.add(items[i]);
            }
        }
        return itemList;
    }

    // Method to remove a specific item from the list
    public void remove(GroceryItemOrder item) {
        for (int i = 0; i < itemCount; i++) {
            if (items[i].equals(item)) {
                System.arraycopy(items, i + 1, items, i, itemCount - i - 1); // Shift items left
                items[--itemCount] = null; // Nullify the last element and decrement count
                return;
            }
        }
    }

    public boolean removeItem(String itemName) {
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getName().equals(itemName)) {
                // Shift the array to fill the removed item's position
                for (int j = i; j < itemCount - 1; j++) {
                    items[j] = items[j + 1];
                }
                items[itemCount - 1] = null; // Nullify the last element
                itemCount--;
                return true; // Successfully removed the item
            }
        }
        return false; // Item was not found
    }


    // Method to calculate the total cost of all items in the list
    public double getTotalCost() {
        double totalCost = 0.0;
        for (int i = 0; i < itemCount; i++) {
            totalCost += items[i].getCost(); // Sum up the cost of each item
        }
        return totalCost;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Grocery List:\n");
        for (int i = 0; i < itemCount; i++) {
            sb.append(items[i]).append("\n"); // Append each item's string representation
        }
        sb.append("Total Cost: $").append(String.format("%.2f", getTotalCost())); // Append total cost
        return sb.toString();
    }
}
