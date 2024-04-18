public interface Shopper {
    void createGroceryList();
    /**
     * Attempts to add an item to the grocery list.
     * @param itemName The name of the item to add.
     * @param quantity The quantity of the item to add.
     * @param store The grocery store where the item is sourced.
     * @return true if the item was successfully added, false otherwise (e.g., item not found).
     */
    boolean addItemToGroceryList(String itemName, int quantity, GroceryStore store);
    void viewGroceryList();
    /**
     * Removes an item from the grocery list.
     * @param itemName The name of the item to remove.
     * @return true if the item was successfully removed, false if the item was not found.
     */
    boolean removeItemFromGroceryList(String itemName);
}

