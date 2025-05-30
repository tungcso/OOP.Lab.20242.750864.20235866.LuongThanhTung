package hust.soict.hedspi.aims.screen.customer.Controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;

public class ItemController {
    @FXML
    private Label lblTitle;

    @FXML
    private Label lblCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnAddToCart;

    private Media media;

    private Cart cart;

    public ItemController(Cart cart) {
        this.cart = cart;
    }


    public void setData(Media media) {
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + " $");

        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
        }
    }

    @FXML
    private void btnAddToCartClicked() {
        if (cart != null && media != null) {
            cart.addMedia(media);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Done");
            alert.setHeaderText(null);
            alert.setContentText("Add " + media.getTitle() + " to cart successfully.");
            alert.showAndWait();
        }
    }

    @FXML
    private void btnPlayClicked() {
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
}

