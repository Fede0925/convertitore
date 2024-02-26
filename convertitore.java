package primeProve;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class convertitore extends Application{
	Button calcola = new Button("converti");
	TextField tBase = new TextField();
	TextField tNumero = new TextField();
	Label lRis = new Label();
	
	public void start(Stage finestra) {
		GridPane griglia = new GridPane();
		Scene scena = new Scene(griglia, 400, 600);
		
		griglia.setAlignment(Pos.CENTER);
		griglia.setPadding(new Insets(10));
		griglia.setHgap(10);
		griglia.setVgap(10);
		griglia.add(calcola, 0, 0);
		griglia.add(tBase, 0, 1);
		griglia.add(tNumero, 1, 1);
		griglia.add(lRis, 0, 2);
		
		tBase.setPromptText("Base di arrivo");
		tNumero.setPromptText("Numero da convertire");
		
		calcola.setOnAction(e->calcola());
		
		finestra.setScene(scena);
		finestra.setTitle("Convertitore");
		finestra.show();
	}

	private void calcola() {
		int base = Integer.parseInt(tBase.getText());
		int numero = Integer.parseInt(tNumero.getText());
		int posto;
		String convertito="";
		
		if(base!=16) {
			while (numero!=0) {
				posto=numero-((numero/base)*base);
				convertito+=posto+" ";
				numero=numero/base;
			}
		}
		
		if(base==16) {
			while (numero!=0) {
				posto=numero-((numero/base)*base);
				
				if(posto<10) {
					convertito+=posto+" ";
					numero=numero/base;
				}
				
				if(posto>=10) {
					if(posto==10) {
						convertito+="A"+" ";
						numero=numero/base;
					}
					if(posto==11) {
						convertito+="B"+" ";
						numero=numero/base;
					}
					if(posto==12) {
						convertito+="C"+" ";
						numero=numero/base;
					}
					if(posto==13) {
						convertito+="D"+" ";
						numero=numero/base;
					}
					if(posto==14) {
						convertito+="E"+" ";
						numero=numero/base;
					}
					if(posto==15) {
						convertito+="F"+" ";
						numero=numero/base;
					}
				}
			}
		}
		
		String inverti[] = convertito.split(" ");
		convertito="";
		
		for(int i=inverti.length-1;i>=0;i--) {
			convertito+=inverti[i];
		}
		
		lRis.setText(convertito);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
