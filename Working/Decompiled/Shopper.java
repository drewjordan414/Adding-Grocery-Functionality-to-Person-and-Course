// package Working.Decompiled;

// // Source code is decompiled from a .class file using FernFlower decompiler.
// public interface Shopper {
//     void createGroceryList();
 
//     void addItemToGroceryList(String var1, int var2, GroceryStore var3);
 
//     void viewGroceryList();
//  }
 

package Working.Decompiled;

public interface Shopper {
    /**
     * Creates a new grocery list. This might replace any existing list.
     */
    void createGroceryList();

    /**
     * Attempts to add an item to the grocery list.
     * @param itemName The name of the item to add.
     * @param quantity The quantity of the item to add.
     * @param store The grocery store where the item is sourced.
     * @return true if the item was successfully added, false otherwise (e.g., item not found).
     */
    boolean addItemToGroceryList(String itemName, int quantity, GroceryStore store);

    /**
     * Displays the contents of the grocery list.
     */
    void viewGroceryList();

    /**
     * Removes an item from the grocery list.
     * @param itemName The name of the item to remove.
     * @return true if the item was successfully removed, false if the item was not found.
     */
    boolean removeItemFromGroceryList(String itemName);
}



// Modifications:
// Return Types: Changed the return type of addItemToGroceryList and added removeItemFromGroceryList with a boolean return type to indicate whether the operation was successful.
// Error Handling: The boolean return values enable simple error handling without throwing exceptions, making the interface easier to implement in various contexts.

