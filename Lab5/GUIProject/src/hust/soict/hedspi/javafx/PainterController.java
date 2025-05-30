package hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
	@FXML
	private RadioButton penRadioButton;
	@FXML
	private RadioButton eraserRadioButton;

	private Color currentColor = Color.BLACK;

	@FXML
	private Pane drawingAreaPane;

	@FXML
	void toolSelected(ActionEvent event) {
		if (penRadioButton.isSelected()) {
			currentColor = Color.BLACK;
		} else if (eraserRadioButton.isSelected()) {
			currentColor = Color.WHITE;
		}

	}

	@FXML
	void clearButtonPressed(ActionEvent event) {
		drawingAreaPane.getChildren().clear();
	}

	@FXML
	void drawingAreaMouseDragged(MouseEvent event) {
		Circle newCircle = new Circle(event.getX(), event.getY(), 4, currentColor);
		drawingAreaPane.getChildren().add(newCircle);
	}

	@FXML
	public void initialize() {

		if (penRadioButton != null) {
			penRadioButton.setSelected(true);
		}
		currentColor = Color.BLACK;
	}
}
