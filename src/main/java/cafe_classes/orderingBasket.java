package cafe_classes;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class orderingBasket {

    /** When there are no items in order **/
    public static final int EMPTY = 0;
    /** The dollar format. **/
    private static final String FORMAT = "##,##0.00";
    /** Formatter that formats a number to the dollar format. **/
    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat(FORMAT);
    /** Sales tax amount. **/
    private static final double SALES_TAX = 0.06625;
    /** When an order is empty. **/
    private static final double EMPTY_ORDER_TOTAL = 0.00;
    /** List of items with the order. **/
    private ArrayList<Items> items;
    /** Current price of order. **/
    private double currentPrice;


    public orderingBasket() {
        this.items = new ArrayList<>();
        this.currentPrice = EMPTY_ORDER_TOTAL;
    }

    /**
     * Gets the items in the order.
     * @return The items in the order.
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
     * @return The total of the order with tax applied.
     */
    public String getFinalPrice() {
        return DECIMAL_FORMAT.format(currentPrice + currentPrice * SALES_TAX);
    }

    /**
     * Get the subtotal of order.
     * @return subtotal
     */
    public String getSubtotal(){
        return DECIMAL_FORMAT.format(currentPrice);
    }

    /**
     * Get the sales tax total of order.
     * @return amount of sales tax
     */
    public String getTax(){
        return DECIMAL_FORMAT.format(currentPrice * SALES_TAX);
    }

    /**
     * Get the list of donuts and coffee from order.
     * @return list of donuts and coffee
     */
    public ArrayList<Item> getPizzas() {
        return items;
    }

    /**
     * Get the amount of donuts and coffee in order.
     * @return amount of items
     */
    public int size(){
        return items.size();
    }
}
