import java.util.List;

public interface Shopper {

    /**
     * Creates a new grocery list for the shopper.
     */
    void createGroceryList();

    /**
     * Attempts to add an item to the grocery list.
     *
     * @param itemName The name of the item to add.
     * @param quantity The quantity of the item to add.
     * @param store    The grocery store where the item is sourced.
     * @return true if the item was successfully added, false otherwise (e.g., item not found).
     */
    boolean addItemToGroceryList(String itemName, int quantity, GroceryStore store);

    /**
     * Views the contents of the grocery list.
     */
    void viewGroceryList();

    /**
     * Attempts to remove an item from the grocery list.
     *
     * @param itemName The name of the item to remove.
     * @return true if the item was successfully removed, false if the item was not found.
     */
    boolean removeItemFromGroceryList(String itemName);

    /**
     * Gets a list of all items in the grocery list.
     *
     * @return A list of all grocery item orders.
     */
    List<GroceryItemOrder> getGroceryListItems();

    /**
     * Calculates the total cost of all items in the grocery list.
     *
     * @return The total cost.
     */
    double getTotalGroceryListCost();
}
