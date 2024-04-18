public class Person implements Shopper {
    private String firstName;
    private String lastName;
    private GroceryList groceryList;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    @Override
    public void createGroceryList() {
        this.groceryList = new GroceryList(this);
    }

    @Override
    public boolean addItemToGroceryList(String itemName, int quantity, GroceryStore store) {
        GroceryItemOrder itemOrder = store.getOrder(itemName, quantity);
        if (itemOrder != null) {
            this.groceryList.add(itemOrder);
            return true; // Successfully added item
        } else {
            System.out.println("Item " + itemName + " could not be added to the list (not found in store).");
            return false; // Failed to add item
        }
    }

    @Override
    public void viewGroceryList() {
        System.out.println("Grocery List for " + this.getFullName() + ":\n" + this.groceryList);
    }

    @Override
    public boolean removeItemFromGroceryList(String itemName) {
        // This assumes the GroceryList class has a method 'removeItem' that removes an item by name.
        return this.groceryList.removeItem(itemName);
    }
    public String toString() {
        return "Name: " + getFullName();
    }
}
