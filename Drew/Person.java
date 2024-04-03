package Drew;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import Shopper;

public class Person implements Comparable<Person>, Shopper {
    private String familyName;
    private String givenNames;
    private final LocalDate dob;
    private List<Person> children;
    private GroceryList myGroceryList;

    public Person(String familyName, String givenNames, int day, int month, int year) {
        this.familyName = familyName.toUpperCase();
        this.givenNames = givenNames;
        this.dob = LocalDate.of(year, month, day);
        this.children = new ArrayList<>();
        this.myGroceryList = new GroceryList();
    }

    @Override
    public void createGroceryList() {
        this.myGroceryList = new GroceryList();
    }

    @Override
    public void addItemToGroceryList(String itemName, int quantity, GroceryStore store) {
        GroceryItemOrder item = store.getOrder(itemName, quantity);
        if (item != null) {
            this.myGroceryList.add(item);
        }
    }

    @Override
    public void viewGroceryList() {
        System.out.println(this.myGroceryList);
    }

    @Override
    public int compareTo(Person o) {
        int familyNameComparison = this.familyName.compareTo(o.familyName);
        if (familyNameComparison != 0) return familyNameComparison;

        int givenNamesComparison = this.givenNames.compareTo(o.givenNames);
        if (givenNamesComparison != 0) return givenNamesComparison;

        return this.dob.compareTo(o.dob);
    }

    // Getters and Setters
    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName.toUpperCase(); 
    }

    public String getGivenNames() {
        return givenNames;
    }

    public void setGivenNames(String givenNames) {
        this.givenNames = givenNames;
    }

    public LocalDate getDob() {
        return dob;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        this.children.add(child);
    }

    public GroceryList getMyGroceryList() {
        return myGroceryList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return familyName.equals(person.familyName) &&
                givenNames.equals(person.givenNames) &&
                dob.equals(person.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(familyName, givenNames, dob);
    }

    @Override
    public String toString() {
        return "Person{" +
                "familyName='" + familyName + '\'' +
                ", givenNames='" + givenNames + '\'' +
                ", dob=" + dob +
                ", children count=" + children.size() +
                '}';
    }
}