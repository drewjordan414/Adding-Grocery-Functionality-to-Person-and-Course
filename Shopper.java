
public interface Shopper {
    void createGroceryList();
    void addItemToGroceryList(String itemName, int quantity, GroceryStore store);
    void viewGroceryList();
}