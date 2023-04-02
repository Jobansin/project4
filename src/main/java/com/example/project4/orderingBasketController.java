package com.example.project4;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import cafe_classes.orderingBasket;
import cafe_classes.donuts;
import cafe_classes.coffee;
import java.util.ArrayList;

public class orderingBasketController {

    /** The reference to the menu controller to access current order **/
    private MenuController menuController;
    /** Current order **/
    private Order currentOrder;
    /** TextFields from GUI **/
    @FXML
    private TextField num, subtotal, total, tax;
    /** Label from GUI **/
    @FXML
    private Label numItem;
    /** ListView from GUI **/
    @FXML
    private ListView list;
    /** Button from GUI **/
    @FXML
    private Button placeButton;

    /**
     * Sets up the screen with data of current order.
     */
    protected void setUpScreen(MenuController controller){
        menuController = controller;
        currentOrder = menuController.getCurrentOrder();
        numItem.setText("Amount of Items: " + currentOrder.size());
        listItems();
        updatePrice();
    }

    /**
     * Populates the ListView with item information.
     */
    private void listItems(){
//        ArrayList<String> items = new ArrayList<>();
//        for(Item item : currentOrder.getItems()){
//            items.add(item.toString());
//        }
//
//        list.setItems(FXCollections.observableArrayList(items));
    }

    /**
     * Updates the price of current order.
     */
    private void updatePrice(){
        subtotal.setText("$" + currentOrder.getSubtotal());
        tax.setText("$" + currentOrder.getTax());
        total.setText("$" + currentOrder.getFinalPrice());
    }

    /**
     * Removes the selected item from order and updates GUI.
     */
    @FXML
    private void removeSelectedItem(){
        int selectedIndex = list.getSelectionModel().getSelectedIndex();
        list.getItems().remove(selectedIndex);
        currentOrder.removeItems(selectedIndex);
        numItem.setText("Amount of items: " + currentOrder.size());
        updatePrice();
        if(list.getSelectionModel().getSelectedIndex() == -1){
            ((Stage) placeButton.getScene().getWindow()).close();
            currentOrder = null;
        }
    }

    /**
     * Adds the order to the store orders and closes the window.
     */
    @FXML
    private void placeOrder(){
//        if(currentOrder.getItems().size() == Order.EMPTY){
//            menuController.showError("There are no items", "Add donuts and/or coffee to place an order.");
//            return;
//        }
//        menuController.addToOrders(currentOrder);
//        ((Stage) placeButton.getScene().getWindow()).close();
    }
}
