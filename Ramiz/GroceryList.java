public class GroceryList {
    private static final int MAX_ITEMS = 10; // Maximum number of items the list can hold
    private GroceryItemOrder[] items = new GroceryItemOrder[MAX_ITEMS]; // Array to store grocery items
    private int itemCount = 0; // Counter to track the number of items in the list
    private Person owner;
    
    public GroceryList(Person owner) {
        this.owner = owner;
    }

    // Method to add a grocery item to the list
    public void add(GroceryItemOrder item) {
        if (itemCount < MAX_ITEMS) {
            items[itemCount++] = item; // Add item if there is space
        } else {
            System.out.println("Grocery list is full. Cannot add more items."); // Notify when list is full
        }
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
        for (GroceryItemOrder item : items) {
            totalCost += item.getCost();
        }
        if (owner instanceof Professor) {
            totalCost *= 0.95; // Apply a 5% discount for professors
        } else if (owner instanceof Graduate) {
            totalCost *= 0.90; // Apply a 10% discount for graduate students
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
