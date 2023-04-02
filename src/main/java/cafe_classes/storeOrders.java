package cafe_classes;

import java.io.*;
import java.util.ArrayList;

public class StoreOrders {
    /** The list of orders. **/
    private ArrayList<orderingItems> orders;

    /** Empty list of orders **/
    //public static final int EMPTY = 0;

    /**
     * Adds an order to the list of orders.
     */
    public void addOrder(Order order) {
        orders.add(order);
    }

    /**
     * This method returns the ArrayList of orders.
     */
    public ArrayList<Order> getOrders() {
        return orders;
    }

    /**
     * This method removes an order from the list of orders.
     */
    public void removeOrder(int index) {
        orders.remove(index);
    }

    /**
     * Constructor for the StoreOrders class.
     */
    public StoreOrders() {
        orders = new ArrayList<>();
    }

    /**
     * This method returns all of the orders placed to a string which is separated by new lines.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Order order : orders) {
            sb.append(order.toString()).append("\n");
        }
        return sb.toString();
    }

    /**
     * This method saves the orders at the given file destination.
     */
    public void export(File file) {
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Order order : orders) {
                bw.write(order.toString());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get order at a given index.
     */
    public Order getOrder(int index){
        return orders.get(index);
    }

    /**
     * Get the amount of orders that are currently placed.
     */
    public int getSize(){
        return orders.size();
    }
}
