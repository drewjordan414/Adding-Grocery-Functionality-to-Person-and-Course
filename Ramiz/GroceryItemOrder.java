public class GroceryItemOrder {
    private GroceryItem item;
    private int quantity;

    public GroceryItemOrder(GroceryItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public GroceryItem getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getName() {
        return item.getName(); // the getName call contained GroceryItem
    }

    public double getCost() {
        return item.getPricePerUnit() * quantity;
    }

    @Override
    public String toString() {
        return item.toString() + ", Quantity: " + quantity;
    }
}

