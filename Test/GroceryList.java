public class GroceryList {
    private static final int MAX_ITEMS = 10;
    private GroceryItemOrder[] items;
    private int itemCount;

    public GroceryList() {
        items = new GroceryItemOrder[MAX_ITEMS];
        itemCount = 0;
    }

    public void add(GroceryItemOrder item) {
        if (itemCount < MAX_ITEMS) {
            items[itemCount++] = item;
        } else {
            System.out.println("Grocery list is full. Cannot add more items.");
        }
    }

    public double getTotalCost() {
        double totalCost = 0;
        for (int i = 0; i < itemCount; i++) {
            totalCost += items[i].getCost();
        }
        return totalCost;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Grocery List:\n");
        for (int i = 0; i < itemCount; i++) {
            sb.append(items[i].toString()).append("\n");
        }
        sb.append("Total Cost: $").append(String.format("%.2f", getTotalCost()));
        return sb.toString();
    }
}
