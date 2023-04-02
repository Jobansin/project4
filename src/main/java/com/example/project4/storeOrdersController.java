package com.example.project4;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import cafe_classes.orderingBasket;
import cafe_classes.donuts;
import cafe_classes.coffee;
import cafe_classes.StoreOrders;

import java.io.File;
import java.util.ArrayList;

public class storeOrdersController {
    /** Index of first order for set up. **/
    private static final int INITIAL_ORDER = 0;
    /** The reference to the menu controller to access orders. **/
    private MenuController menuController;
    /** Store orders from menu controller **/
    private StoreOrders orders;
    /** ComboBox from GUI. **/
    @FXML
    private ComboBox orderBox;
    /** TextField from GUI. **/
    @FXML
    private TextField orderTotal;
    /** ListView from GUI. **/
    @FXML
    private ListView list;
    /** Button box from GUI. **/
    @FXML
    private Button cancelButton;

    /**
     * The initial screen.
     */
    protected void setUpScreen(MenuController controller){
//        menuController = controller;
//        orders = menuController.getStoreOrders();
//        orderBox.getSelectionModel().select(INITIAL_ORDER);
//        showItems();
    }

    /**
     * Populates the ListView from selected order.
     */
    private void showItems(){
//        orderingBasket order = orders.getOrder(orderBox.getSelectionModel().getSelectedIndex());
//        ArrayList<String> items = new ArrayList<>();
//        for(Item item : order.getItems()){
//            items.add(item.toString());
//        }
//        list.setItems(FXCollections.observableArrayList(items));
//        orderTotal.setText("$" + order.getFinalPrice());
    }

    /**
     * Updates information based on the new selected order.
     */
    @FXML
    private void showChosenOrder(){
//        if(orderBox.getSelectionModel().getSelectedIndex() >= INITIAL_ORDER){
//            showItems();
//        }
//        else{
//            ((Stage) cancelButton.getScene().getWindow()).close();
//        }
    }
    /**
     * Allows the user to choose a file to export data for all orders.
     */
    @FXML
    private void exportOrders() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose location of export file");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
        );
        Stage stage = new Stage();
        File targetFile = fileChooser.showSaveDialog(stage);
        orders.export(targetFile);
    }

    /**
     * Cancels an order and removes it from the list of orders.
     */
    @FXML
    private void cancelOrder() {
        int selectedIndex = orderBox.getSelectionModel().getSelectedIndex();
        orderBox.getItems().remove(selectedIndex);
        orders.removeOrder(selectedIndex);
    }
}
