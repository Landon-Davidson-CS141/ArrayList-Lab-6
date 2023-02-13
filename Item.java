package cs141.landon;

public class Item {
//    Initialize name, description, and price variables, which are all defined in the constructor
    private final String name;
    private final String description;
    private final double price;
//    Constructor to assign passed arguments to instance variables
    public Item(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
//    Prints the name, price, and quantity of the item. The quantity is passed as an argument
//    since the quantity is stored in ShoppingCart's cart ArrayList
    public void printCost(int quantity) {
        System.out.format("%d %s @ $%.2f = $%.2f\n", quantity, name, price, price * quantity);
    }
//    These three are just basic getters for name, description, and price
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
}
