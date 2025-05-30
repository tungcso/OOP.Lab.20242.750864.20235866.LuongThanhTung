package hust.soict.hedspi.aims.screen.customer.Controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
    private static Store store; // ✅ Khai báo static

    @Override
    public void start(Stage primaryStage) throws Exception {
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
        Cart cart = new Cart();
        final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        Parent root = fxmlLoader.load();

        ViewStoreController controller = fxmlLoader.getController();
        controller.initData(store, cart);

        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        store = new Store();

        launch(args);
    }
}
