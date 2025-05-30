package hust.soict.hedspi.aims.screen.customer.Controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.store.Store;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewStoreController {
    @FXML
    private GridPane gridPane;

    private Store store;
    private Cart cart;

    public ViewStoreController() {
    }

    @FXML
    public void initialize() {
        // Không dùng store ở đây nữa
    }

    public void initData(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;

        updateGrid();
    }

    // Phương thức này dùng để cập nhật UI sau khi có dữ liệu store và cart
    public void updateGrid() {
        if (store == null || cart == null) {
            System.out.println("Store or Cart is null, cannot update grid");
            return;
        }

        final String ITEM_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Item.fxml";
        int column = 0;
        int row = 1;

        gridPane.getChildren().clear();  // Xóa cũ nếu có

        System.out.println("Store items: " + store.getItemsInStore().size());
        for (int i = 0; i < store.getItemsInStore().size(); i++) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource(ITEM_FXML_FILE_PATH));

                ItemController itemController = new ItemController(cart);
                fxmlLoader.setController(itemController);

                AnchorPane anchorPane = fxmlLoader.load();

                itemController.setData(store.getItemsInStore().get(i));

                if (column == 3) {
                    column = 0;
                    row++;
                }

                gridPane.add(anchorPane, column++, row);
                GridPane.setMargin(anchorPane, new Insets(20, 10, 10, 10));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setStore(Store store) {
        this.store = store;
    }


    private void updateGridIfReady() {
        if (this.store != null && this.cart != null) {
            updateGrid();
        }
    }

    @FXML
    void btnViewCartPressed(ActionEvent event) {
        try {
            final String CART_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Cart.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));

            Parent root = fxmlLoader.load();
            CartController cartController = fxmlLoader.getController();
            cartController.setCart(cart);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Cart");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

