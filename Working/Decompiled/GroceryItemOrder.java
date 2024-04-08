package Working.Decompiled;

// Source code is decompiled from a .class file using FernFlower decompiler.
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
       return (double)this.quantity * this.pricePerUnit;
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
       this.quantity = quantity;
    }
 
    public String toString() {
       return String.format("%s: %d units at $%.2f each. Total: $%.2f", this.name, this.quantity, this.pricePerUnit, this.getCost());
    }
 }
 