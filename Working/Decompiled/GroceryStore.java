package Working.Decompiled;

// Source code is decompiled from a .class file using FernFlower decompiler.
import java.util.HashMap;
import java.util.Map;

public class GroceryStore {
   private String name;
   private Map<String, Double> inventory;

   public GroceryStore(String name) {
      this.name = name;
      this.inventory = new HashMap();
   }

   public void addItem(String itemName, double pricePerUnit) {
      this.inventory.put(itemName, pricePerUnit);
   }

   public double getPrice(String itemName) {
      return (Double)this.inventory.getOrDefault(itemName, 0.0);
   }

   public GroceryItemOrder getOrder(String itemName, int quantity) {
      if (this.inventory.containsKey(itemName)) {
         return new GroceryItemOrder(itemName, quantity, (Double)this.inventory.get(itemName));
      } else {
         System.out.println("Item not found in inventory.");
         return null;
      }
   }

   public String toString() {
      StringBuilder sb = new StringBuilder("Inventory of " + this.name + ":\n");
      this.inventory.forEach((item, price) -> {
         sb.append(item).append(": $").append(String.format("%.2f", price)).append("\n");
      });
      return sb.toString();
   }
}
