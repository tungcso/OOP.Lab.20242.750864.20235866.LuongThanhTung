package hust.soict.hedspi.aims.screen.customer.Controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.value.ChangeListener;
import javafx.collections.transformation.FilteredList;
import javafx.stage.Stage;

import java.io.IOException;


public class CartController {

    private Cart cart;
    private FilteredList<Media> filteredData;

    public CartController() {
    }

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TextField filterText;

    @FXML
    private Label costLabel;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    public void setCart(Cart cart) {
        this.cart = cart;

        if (cart != null && cart.getItemsOrdered() != null) {
            filteredData = new FilteredList<>(cart.getItemsOrdered(), p -> true);
            tblMedia.setItems(filteredData);
            updateTotalCostLabel(); // cập nhật cost khi mở giỏ hàng
        }
    }

    @FXML
    public void initialize() {
        colMediaId.setCellValueFactory(
                new PropertyValueFactory<Media, Integer>("id"));
        colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(
                new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<Media, Float>("cost"));

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue){
                updateButtonBar(newValue);
            }
        });

        filterText.textProperty().addListener((observable, oldValue, newValue) -> {
            showFilteredMedia(newValue);
        });
    }

    private void showFilteredMedia(String filterText) {
        filteredData.setPredicate(media -> {
            if (filterText == null || filterText.isEmpty()) {
                return true;
            }

            if (radioBtnFilterId.isSelected()) {
                try {
                    int id = Integer.parseInt(filterText);
                    return media.getId() == id;
                } catch (NumberFormatException e) {
                    return false;
                }
            } else if (radioBtnFilterTitle.isSelected()) {
                return media.getTitle().toLowerCase().contains(filterText.toLowerCase());
            }

            return true;
        });
    }



    private void updateButtonBar(Media media) {
        if (media != null) {
            btnRemove.setVisible(true); // Có item chọn thì hiện nút Remove
            if (media instanceof Playable) {
                btnPlay.setVisible(true);
            } else {
                btnPlay.setVisible(false);
            }
        } else {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        }
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Now Playing");
                alert.setHeaderText(null);
                alert.setContentText("Now playing: " + media.getTitle());
                alert.showAndWait();

            } catch (hust.soict.dsai.aims.exception.PlayerException e) {
                // Hiển thị lỗi nếu không thể play
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Playback Error");
                errorAlert.setHeaderText("Cannot play media");
                errorAlert.setContentText(e.getMessage());
                errorAlert.showAndWait();
            }
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        System.out.println("Remove pressed");

        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("failed");
            alert.setHeaderText(null);
            alert.setContentText("No media selected.");
            alert.showAndWait();
            return;
        }

        if (cart == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("cart");
            alert.setHeaderText(null);
            alert.setContentText("Cart is null. ");
            alert.showAndWait();
            return;
        }

        System.out.println("Removing media: " + media.getTitle());
        boolean removed = cart.getItemsOrdered().remove(media);
        if (removed) {
            System.out.println("Removed successfully");
            tblMedia.refresh();
            updateButtonBar(null);
            updateTotalCostLabel();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("remove");
            alert.setHeaderText(null);
            alert.setContentText("Remove: " + media.getTitle() + " successfully.");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("failed");
            alert.setHeaderText(null);
            alert.setContentText("Remove failed.");
            alert.showAndWait();
        }
    }


    @FXML
    void btnViewStorePressed(ActionEvent event) throws IOException {
        Store store = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        store.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        store.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        store.addMedia(dvd3);

        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avatar: The Way of Water", "Mystic", "James Cameron", 125, 27.99f);
        store.addMedia(dvd4);
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Sci-Fi", 24.95f));
        store.addMedia(new DigitalVideoDisc("Aladdin", "Animation", 18.99f));
        store.addMedia(new DigitalVideoDisc("The Dark Knight", "Action", 29.99f));
        store.addMedia(new DigitalVideoDisc("Inception", "Sci-Fi", 19.95f));
        store.addMedia(new DigitalVideoDisc("Matrix", "Action", 24.99f));
        store.addMedia(new DigitalVideoDisc("The Avengers", "Action", 29.99f));
        store.addMedia(new DigitalVideoDisc("Frozen", "Animation", 21.99f));
        store.addMedia(new DigitalVideoDisc("Jurassic Park", "Adventure", 15.99f));
        final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        Parent root = fxmlLoader.load();

        ViewStoreController controller = fxmlLoader.getController();
        controller.initData(store, cart);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Store");
        stage.show();
    }

    private void updateTotalCostLabel() {
        if (cart != null) {
            float totalCost = cart.totalCost();
            costLabel.setText(String.format("Total cost: $%.2f", totalCost));
        }
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        if (cart != null && cart.getItemsOrdered().size() > 0) {
            System.out.println("Order placed successfully. Total cost: $" + String.format("%.2f", cart.totalCost()));
            cart.getItemsOrdered().clear(); // Clear cart after order
            tblMedia.refresh();
            updateTotalCostLabel();
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Place Order");
            alert.setHeaderText(null);
            alert.setContentText("Place Order succesfully.");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("failed");
            alert.setHeaderText(null);
            alert.setContentText("Cart is empty. Cannot place order.");
            alert.showAndWait();
        }
    }

}
