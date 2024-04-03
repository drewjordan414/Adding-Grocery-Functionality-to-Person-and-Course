package Drew;
public class GroceryItemOrder {
    private String name;
    private int quantity;
    private double pricePerUnit;

    public GroceryItemOrder(String name, int quantity, double pricePerUnit) {
        this.name = name;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    public double getCost() {
        return quantity * pricePerUnit;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    // Setters if necessary
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("%s: %d units at $%.2f each. Total: $%.2f", name, quantity, pricePerUnit, getCost());
    }
}
