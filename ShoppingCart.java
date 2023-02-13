package cs141.landon;

import java.util.ArrayList;

public class ShoppingCart {
//    Initialize name and date, defined in the constructor
    private final String name;
    private final String date;
//    Creates an ArrayList object named cart that stores what items teh user has in their cart,
//    in the form of that items index in the items array.
    private final ArrayList<Integer> cart = new ArrayList();
//    Stores one object for each menu item which can be referenced for its methods using its index
    private final Item[] items;
    public ShoppingCart(String name, String date, String[] menu,
                        String[] descriptions, double[] prices) {
        this.name = name;
        this.date = date;

//        The for loop goes through each item in the menu array and creates an Item object for
//        each one, using the element at the same index within menu, descriptions, and prices
//        as the arguments for the constructor.
        items = new Item[menu.length];
        for (int i = 0; i < menu.length; i++) {
            items[i] = new Item(menu[i], descriptions[i], prices[i]);
        }
    }
//    Adds the Integer itemNum to the cart arrayList and gives a confirmation for the user.
//    itemNum is a user input from ShoppingCartManager.
    public void addItem(Integer itemNum) {
        cart.add(itemNum);
        System.out.format("Adding one %s to your cart\n", items[itemNum].getName());
    }
//    Same as addItem but removing instead
    public void removeItem(Integer itemNum) {
        cart.remove(itemNum);
        System.out.format("Removing one %s from your cart\n", items[itemNum].getName());
    }
//    Uses a for loop to loop through each Item object in items
//    and prints the name, price, and description.
    public void printMenu() {
        System.out.println("\nThis is the menu for " + date + ":");
        for (int i = 0; i < items.length; i++) {
            System.out.format("%d. %s for $%.2f: %s\n", i + 1,
                    items[i].getName(), items[i].getPrice(), items[i].getDescription());
        }
        System.out.println();
    }
    public void printCart(String state) {
        System.out.format("\n%s, this is your %s cart:\n", name, state);
        double total = 0;
        int[] quantities = new int[items.length];
//        Loops through the ArrayList cart and counts how much of each number
//        (representing items in the cart) is in it, adding it to the quantities array.
//        The loop also adds the cost of each item in the cart to total, which is printed later.
        for (Integer item : cart) {
            quantities[item]++;
            total += items[item].getPrice();
        }
//        Now that we have the quantity of each item, we can loop through the items array
//        and pass the quantity to the printCost method, along with the items number so
//        the user can remove items later
        for (int i = 0; i < items.length; i++) {
            if (quantities[i] > 0) {
                System.out.print(i + 1 + ". ");
                items[i].printCost(quantities[i]);
            }
        }
        System.out.println("--------------");
//        Prints the total cost from earlier
        System.out.format("Total : $%.2f\n\n", total);
    }
    public void changeQuantity(int target, int itemNum) {
        int[] quantities = new int[items.length];
        for (Integer item : cart) {
            quantities[item]++;
        }
        if (quantities[itemNum] < target) {
            for (int i = 0; i < target - quantities[itemNum]; i++) {
                cart.add(itemNum);
            }
        } else if (quantities[itemNum] > target) {
            for (int i = 0; i < quantities[itemNum] - target; i++) {
                cart.remove(itemNum);
            }
        }
    }
}
