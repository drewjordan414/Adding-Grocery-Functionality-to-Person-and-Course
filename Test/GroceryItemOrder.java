public class GroceryItemOrder {
    private GroceryItem item; // Assuming there is a GroceryItem class
    private int quantity;

    public GroceryItemOrder(GroceryItem item, int quantity) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null.");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
        this.item = item;
        this.quantity = quantity;
    }

    public double getCost() {
        // If there's a discount applicable, it should be applied here
        return quantity * item.getPricePerUnit();
    }

    public GroceryItem getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("%s: %d units at $%.2f each. Total: $%.2f",
                             item.getName(), quantity, item.getPricePerUnit(), getCost());
    }
}
