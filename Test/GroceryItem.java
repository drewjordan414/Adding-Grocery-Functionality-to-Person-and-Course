public class GroceryItem {
    private String name;
    private double pricePerUnit;

    public GroceryItem(String name, double pricePerUnit) {
        setName(name);
        setPricePerUnit(pricePerUnit);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Item name cannot be null or empty.");
        }
        this.name = name;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        if (pricePerUnit < 0) {
            throw new IllegalArgumentException("Price per unit cannot be negative.");
        }
        this.pricePerUnit = pricePerUnit;
    }

    @Override
    public String toString() {
        return String.format("Item: %s, Price per unit: $%.2f", name, pricePerUnit);
    }

    // Implement equals and hashCode if GroceryItem needs to be used in collections that rely on object equality.
}
