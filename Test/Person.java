import java.util.ArrayList;
import java.util.List;

// Person now implements the Shopper interface
public class Person implements Shopper {
    private String firstName;
    private String lastName;
    private GroceryList groceryList; // Each person has a grocery list
    private String role; // Can be "Student", "Professor", "Undergraduate", or "Graduate"

    public Person(String firstName, String lastName, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.groceryList = new GroceryList(); // Initialize the grocery list for every person
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public GroceryList getGroceryList() {
        return this.groceryList;
    }

    @Override
    public void createGroceryList() {
        this.groceryList = new GroceryList(); // Reset the grocery list
    }

    @Override
    public boolean addItemToGroceryList(String itemName, int quantity, GroceryStore store) {
        GroceryItemOrder itemOrder = store.getOrder(itemName, quantity);
        if (itemOrder != null) {
            this.groceryList.add(itemOrder);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeItemFromGroceryList(String itemName) {
        return this.groceryList.removeItem(itemName);
    }

    @Override
    public void viewGroceryList() {
        System.out.println(this.groceryList);
    }

    @Override
    public List<GroceryItemOrder> getGroceryListItems() {
        return this.groceryList.getItems(); // Assuming GroceryList has a getItems method
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    @Override
    public double getTotalGroceryListCost() {
        return this.groceryList.getTotalCost();
    }

    @Override
    public String toString() {
        return "Name: " + this.getFullName() + " | Role: " + this.role;
    }
}

// Role Management: Added a role field to differentiate between students
// (undergraduate/graduate) and professors.
// Shopper Implementation: Each person can now manage a grocery list, add items
// to it, remove them, and view the list. This is directly aligned with your
// system's requirements.
// Grocery List: Incorporated a GroceryList object for every person as part of
// their attributes. This list gets initialized when the person is created.