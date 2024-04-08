package Working.Decompiled;

// Source code is decompiled from a .class file using FernFlower decompiler.
public class GroceryList {
    private static final int MAX_ITEMS = 10;
    private GroceryItemOrder[] items = new GroceryItemOrder[10];
    private int itemCount = 0;
 
    public GroceryList() {
    }
 
    public void add(GroceryItemOrder item) {
       if (this.itemCount < 10) {
          this.items[this.itemCount++] = item;
       } else {
          System.out.println("Grocery list is full. Cannot add more items.");
       }
 
    }
 
    public double getTotalCost() {
       double totalCost = 0.0;
 
       for(int i = 0; i < this.itemCount; ++i) {
          totalCost += this.items[i].getCost();
       }
 
       return totalCost;
    }
 
    public String toString() {
       StringBuilder sb = new StringBuilder("Grocery List:\n");
 
       for(int i = 0; i < this.itemCount; ++i) {
          sb.append(this.items[i].toString()).append("\n");
       }
 
       sb.append("Total Cost: $").append(String.format("%.2f", this.getTotalCost()));
       return sb.toString();
    }
 }
 