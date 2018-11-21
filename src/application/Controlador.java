package application;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Controlador {

	@FXML
	private AnchorPane paneDrawer, opacityPane, pane1, pane2, pane3;

	@FXML
	private ImageView drawerImagen;

	public void initialize() {
		// TODO Auto-generated method stub

//		TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(0.5), paneDrawer);
//		translateTransition.setByX(-200);
//        translateTransition.play();

		opacityPane.setVisible(false);

		pane1.setStyle("-fx-background-image: url('application/naturaleza1.jpg')");
		pane2.setStyle("-fx-background-image: url('application/naturaleza2.jpg')");
		pane3.setStyle("-fx-background-image: url('application/naturaleza3.jpg')");

		Animation();

		drawerImagen.setOnMouseClicked(event -> {

			opacityPane.setVisible(true);

			FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(0.5), opacityPane);
			fadeTransition1.setFromValue(0);
			fadeTransition1.setToValue(0.6);
			fadeTransition1.play();

			TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), paneDrawer);
			translateTransition1.setByX(+200);
			translateTransition1.play();
		});

		opacityPane.setOnMouseClicked(event -> {

			FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(0.5), opacityPane);
			fadeTransition1.setFromValue(0.6);
			fadeTransition1.setToValue(0);
			fadeTransition1.play();

			fadeTransition1.setOnFinished(event1 -> {
				opacityPane.setVisible(false);
			});
			TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), paneDrawer);
			translateTransition1.setByX(-200);
			translateTransition1.play();
		});
	}

	public void Animation() {
		FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3), pane3);
		fadeTransition.setFromValue(1);
		fadeTransition.setToValue(0);
		fadeTransition.play();

		fadeTransition.setOnFinished(event -> {
			FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(3), pane2);
			fadeTransition2.setFromValue(1);
			fadeTransition2.setToValue(0);
			fadeTransition2.play();

			fadeTransition2.setOnFinished(event2 -> {
				FadeTransition fadeTransition3 = new FadeTransition(Duration.seconds(3), pane2);
				fadeTransition3.setFromValue(0);
				fadeTransition3.setToValue(1);
				fadeTransition3.play();
				
				fadeTransition3.setOnFinished(event3->{
					FadeTransition fadeTransition4 = new FadeTransition(Duration.seconds(3), pane3);
					fadeTransition4.setFromValue(0);
					fadeTransition4.setToValue(1);
					fadeTransition4.play();
					
					fadeTransition4.setOnFinished(event4->{
						Animation();
					});
				});
			});
		});

	}
}
