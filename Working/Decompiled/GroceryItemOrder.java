// package Working.Decompiled;

// // Source code is decompiled from a .class file using FernFlower decompiler.
// public class GroceryItemOrder {
//     private String name;
//     private int quantity;
//     private double pricePerUnit;
 
//     public GroceryItemOrder(String name, int quantity, double pricePerUnit) {
//        this.name = name;
//        this.quantity = quantity;
//        this.pricePerUnit = pricePerUnit;
//     }
 
//     public double getCost() {
//        return (double)this.quantity * this.pricePerUnit;
//     }
 
//     public String getName() {
//        return this.name;
//     }
 
//     public int getQuantity() {
//        return this.quantity;
//     }
 
//     public double getPricePerUnit() {
//        return this.pricePerUnit;
//     }
 
//     public void setQuantity(int quantity) {
//        this.quantity = quantity;
//     }
 
//     public String toString() {
//        return String.format("%s: %d units at $%.2f each. Total: $%.2f", this.name, this.quantity, this.pricePerUnit, this.getCost());
//     }
//  }
 

package Working.Decompiled;

public class GroceryItemOrder {
    private String name;
    private int quantity;
    private double pricePerUnit;

    public GroceryItemOrder(String name, int quantity, double pricePerUnit) {
        this.name = name;
        setQuantity(quantity); // Use setter to apply validation
        setPricePerUnit(pricePerUnit); // Use setter to apply validation
    }

    public double getCost() {
        // Apply any discounts or promotions here if necessary
        return (double) this.quantity * this.pricePerUnit;
    }

    public String getName() {
        return this.name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public double getPricePerUnit() {
        return this.pricePerUnit;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) throw new IllegalArgumentException("Quantity cannot be negative.");
        this.quantity = quantity;
    }

    public void setPricePerUnit(double pricePerUnit) {
        if (pricePerUnit < 0) throw new IllegalArgumentException("Price per unit cannot be negative.");
        this.pricePerUnit = pricePerUnit;
    }

    @Override
    public String toString() {
        return String.format("%s: %d units at $%.2f each. Total: $%.2f", this.name, this.quantity, this.pricePerUnit, this.getCost());
    }
}



// Changes Made:
// Validation in Setters: Ensures that neither negative quantities nor negative prices can be set, protecting the integrity of the data.
// Flexibility: By using setters within the constructor, any adjustments to the validation logic only need to be made in one place in the future.
// Extensibility for Discounts: While not implemented here, the getCost() method's comment suggests where you might implement discount logic in the future.