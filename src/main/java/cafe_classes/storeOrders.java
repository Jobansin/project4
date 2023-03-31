package cafe_classes;

import java.io.*;
import java.util.ArrayList;

public class StoreOrders {
    /** The list of orders. **/
    private ArrayList<orderingDonuts> orders;
    /** Empty list of orders **/
    public static final int EMPTY = 0;

    /**
     * Constructor for the StoreOrders class.
     */
    public StoreOrders() {
        orders = new ArrayList<>();
    }

    /**
     * Adds an order to the list of orders.
     * @param order The order to be added.
     */
    public void addOrder(Order order) {
        orders.add(order);
    }

    /**
     * This method removes an order from the list of orders.
     * @param index The order to be removed.
     */
    public void removeOrder(int index) {
        orders.remove(index);
    }

    /**
     * This method returns the ArrayList of orders.
     * @return the ArrayList of orders.
     */
    public ArrayList<Order> getOrders() {
        return orders;
    }

    /**
     * This method returns all the orders to a string separated by new lines.
     * @return String with all the orders separated by new lines.
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
     * This method saves the orders at the given file location.
     * @param file the file to be edited
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
     * @param index index value
     * @return Order object at index
     */
    public Order getOrder(int index){
        return orders.get(index);
    }

    /**
     * Get amount of orders currently placed.
     * @return amount of orders
     */
    public int getSize(){
        return orders.size();
    }
}
