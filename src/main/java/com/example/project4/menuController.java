package com.example.project4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;

public class menuController {
    /** TextField from GUI. **/
    @FXML
    private TextField num;

    /** The list of orders to be managed. **/
    private StoreOrders orders = new StoreOrders();

    /** The current order being handled. **/
    private Order currentOrder;

    private void showStoreOrders() throws IOException {
        if (orders.getSize() == StoreOrders.EMPTY) {
            showError("No Orders", "Make sure there are orders placed.");
            return;
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("allOrdersView.fxml"));
        Parent root = loader.load();
        AllOrdersController allOrdersView = loader.getController();
        allOrdersView.setUpScreen(this);

        Stage storeOrdersScreen = new Stage();
        storeOrdersScreen.setScene(new Scene(root));
        storeOrdersScreen.show();
    }

    public void showError(String error, String prompt) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(error);
        alert.setHeaderText(prompt);
        alert.showAndWait();
    }
}
