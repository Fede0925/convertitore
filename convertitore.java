package tpsit_Federico_Mazzetti;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class convertitore extends Application{
	Button calcola = new Button();
	
	public void start(Stage finestra) {
		GridPane griglia = new GridPane();
		Scene scena = new Scene(griglia);
		
		
		
		finestra.setScene(scena);
		finestra.setTitle("Convertitore");
		finestra.show();
	}
}
