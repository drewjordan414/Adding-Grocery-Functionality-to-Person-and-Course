public class GroceryItem {
    private String name;
    private double pricePerUnit;

    public GroceryItem(String name, double pricePerUnit) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
    }

    public String getName() {
        return name;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public void setPricePerUnit(double pricePerUnit) {
        if (pricePerUnit < 0) {
            throw new IllegalArgumentException("Price per unit cannot be negative");
        }
        this.pricePerUnit = pricePerUnit;
    }

    @Override
    public String toString() {
        return name + " @ $" + String.format("%.2f", pricePerUnit) + " per unit";
    }
}

