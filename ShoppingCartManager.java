package cs141.landon;

import java.util.Scanner;

public class ShoppingCartManager {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
//        Gets the users name and stores it to name
        System.out.print("What is your name? ");
        String name = input.next();

//        Gets today's date and stores it to date
        System.out.print("What is today's date? ");
        String date = input.next();

//        Defines the menu, descriptions, and prices arrays, so we can pass them to ShoppingCart
        String[] menu = {"Coffee", "Tea", "Microwave Pizza"};
        String[] descriptions = {"Energizing drink from Starbucks",
                "Energizing Drink from Britain", "Fueling snack"};
        double[] prices = {3.50, 2.00, 5.00};

//        Creates the ShoppingCart object, naming it cart
        ShoppingCart cart = new ShoppingCart(name, date, menu, descriptions, prices);
        System.out.println("\nWelcome to the Selection Screen \n------------------");
        while (getUserAction(cart));
        cart.printCart("final");
        System.out.println("Come again!");


    }
    public static boolean getUserAction(ShoppingCart cart) {
        System.out.println("Press 1 to add an item to your cart");
        System.out.println("Press 2 to remove an item from your cart");
        System.out.println("Press 3 to change item quantity");
        System.out.println("Press 4 to display item name and description");
        System.out.println("Press 5 to display cart contents");
        System.out.println("Press 6 to quit and view your final cart");
        System.out.print("Select option now: ");

        switch (input.nextInt()) {
            case 1:
                cart.printMenu();
                System.out.print("What item do you want to add? (Enter the items number) ");
                cart.addItem(input.nextInt() - 1);
                cart.printCart("new");
                break;
            case 2:
                cart.printCart("current");
                System.out.print("What item do you want to remove? (Enter the items number) ");
                cart.removeItem(input.nextInt() - 1);
                cart.printCart("new");
                break;
            case 3:
                cart.printMenu();
                cart.printCart("current");
                System.out.print("What item do you want to change? (Enter the items number) ");
                int itemNum = input.nextInt() - 1;
                System.out.print("How many do you want instead? (Enter the items number) ");
                cart.changeQuantity(input.nextInt(), itemNum);
                cart.printCart("new");
                break;
            case 4:
                cart.printMenu();
                break;
            case 5:
                cart.printCart("current");
                break;
            case 6:
                return false;
        }
        return true;
    }
}
