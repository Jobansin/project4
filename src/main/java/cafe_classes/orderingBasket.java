package cafe_classes;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class orderingBasket {

    /** When there are no items in order **/
    //public static final int EMPTY = 0;

    /** Sales tax amount. **/
    private static final double SET_SALES_TAX = 0.06625;

    /** When an order is empty. **/
    private static final double EMPTY_ORDER = 0.00;

    /** List of items with the order. **/
    private ArrayList<Items> items;

    /** The dollar format. **/
    private static final String FORMAT = "##,##0.00";

    /** Formatter that formats a number to the dollar format. **/
    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat(FORMAT);

    /** Current price of order. **/
    private double currentPrice;


    public orderingBasket() {
        this.items = new ArrayList<>();
        this.currentPrice = EMPTY_ORDER;
    }

    /**
     * Gets the items in the order.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Item item : items) {
            sb.append(item.toString()).append("\n");
        }
        sb.append("Amount of donuts and coffee: ").append(items.size()).append("\n");
        sb.append("Subtotal: $").append(getSubtotal()).append("\t Sales Tax: $").append(getTax()).append("\n");
        sb.append("Total: $").append(getFinalPrice()).append("\n");
        return sb.toString();
    }

    /**
     * Adds food or drink to the order.
     */
    public void additem(Item item) {
        items.add(item);
        currentPrice += item.price();
    }

    /**
     * Remove food or drink from the order.
     */
    public void removeItem(int i) {
        Item removed = items.remove(i);
        currentPrice -= removed.price();
        if(currentPrice < 0){
            currentPrice = 0;
        }
    }

    /**
     * Calculates the total of the order with tax.
     */
    public String getFinalPrice() {
        return DECIMAL_FORMAT.format(currentPrice + currentPrice * SET_SALES_TAX);
    }

    /**
     * Get the subtotal of order.
     */
    public String getSubtotal(){
        return DECIMAL_FORMAT.format(currentPrice);
    }

    /**
     * Get the sales tax total of order.
     */
    public String getTax(){
        return DECIMAL_FORMAT.format(currentPrice * SET_SALES_TAX);
    }

    /**
     * Get the list of donuts and coffee from order.
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * Get the amount of donuts and coffee in order.
     */
    public int size(){
        return items.size();
    }
}
