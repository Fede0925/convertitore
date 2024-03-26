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
	TextField tBaseA = new TextField();
	TextField tBaseB = new TextField();
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
		griglia.add(tBaseA, 0, 1);
		griglia.add(tBaseB, 1, 1);
		griglia.add(tNumero, 0, 2, 2, 1);
		griglia.add(lRis, 0, 3);
		
		
		tBaseA.setPromptText("Base di partenza");
		tBaseB.setPromptText("Base di arrivo");
		tNumero.setPromptText("Numero da convertire");
		
		calcola.setOnAction(e->calcola());
		
		finestra.setScene(scena);
		finestra.setTitle("Convertitore");
		finestra.show();
	}

	private void calcola() {
		int baseA = Integer.parseInt(tBaseA.getText());
		int baseB = Integer.parseInt(tBaseB.getText());
		int numero = 0;
		String sNumero;
		if(baseA!=16) {
			numero = Integer.parseInt(tNumero.getText());
			sNumero = numero + "";
		}else {
			sNumero = tNumero.getText();
		}
		int posto;
		String vsNum[];
		int vNum[];
		String convertito = "";
		int iConv = 0;
		
		if(baseB!=16 && baseA == 10) {
			while (numero!=0) {
				posto=numero-((numero/baseB)*baseB);
				convertito+=posto+" ";
				numero=numero/baseB;
			}
			String inverti[] = convertito.split(" ");
			convertito="";
			
			for(int i=inverti.length-1;i>=0;i--) {
				convertito+=inverti[i];
			}
		}
		
		if(baseA==10 && baseB==16) {
			while (numero!=0) {
				posto=numero-((numero/baseB)* baseB);
				
				if(posto<10) {
					convertito+=posto+" ";
					numero=numero/baseB;
				}
				
				if(posto>=10) {
					if(posto==10) {
						convertito+="A"+" ";
						numero=numero/baseB;
					}
					if(posto==11) {
						convertito+="B"+" ";
						numero=numero/baseB;
					}
					if(posto==12) {
						convertito+="C"+" ";
						numero=numero/baseB;
					}
					if(posto==13) {
						convertito+="D"+" ";
						numero=numero/baseB;
					}
					if(posto==14) {
						convertito+="E"+" ";
						numero=numero/baseB;
					}
					if(posto==15) {
						convertito+="F"+" ";
						numero=numero/baseB;
					}
				}
			}
			String inverti[] = convertito.split(" ");
			convertito="";
			
			for(int i=inverti.length-1;i>=0;i--) {
				convertito+=inverti[i];
			}
		}
			
		if(baseB==10 && baseA!=16) {
			vsNum = sNumero.split("");
			vNum = new int[vsNum.length];
			
			for(int i=0;i<vsNum.length;i++) {
				vNum[i] = Integer.parseInt(vsNum[i]);
			}
			
			for(int i=0;i<vNum.length;i++) {
				iConv += (int) (vNum[i] * Math.pow(baseA, vNum.length-(i+1)));
			}
			convertito+=iConv;
		}
		
		if(baseB==10 && baseA==16) {
			vsNum = sNumero.split("");
			vNum = new int[vsNum.length];
			
			for(int i=0;i<vsNum.length;i++) {
				if(vsNum[i].equals("A") || vsNum[i].equals("a")) {
					vsNum[i]="10";
				}
				if(vsNum[i].equals("B") || vsNum[i].equals("b")) {
					vsNum[i]="11";
				}
				if(vsNum[i].equals("C") || vsNum[i].equals("c")) {
					vsNum[i]="12";
				}
				if(vsNum[i].equals("D") || vsNum[i].equals("d")) {
					vsNum[i]="13";
				}
				if(vsNum[i].equals("E") || vsNum[i].equals("e")) {
					vsNum[i]="14";
				}
				if(vsNum[i].equals("F") || vsNum[i].equals("f")) {
					vsNum[i]="15";
				}
			}
			for(int j=0;j<vsNum.length;j++) {
				vNum[j] = Integer.parseInt(vsNum[j]);
				}
			
			for(int i=0;i<vNum.length;i++) {
				iConv += (int) (vNum[i] * Math.pow(baseA, vNum.length-(i+1)));
			}
			convertito+=iConv;
		}
		
		if(baseA!=10 && baseB!=10 && baseA!=16 && baseB!=16) {
			vsNum = sNumero.split("");
			vNum = new int[vsNum.length];
			
			for(int i=0;i<vsNum.length;i++) {
				vNum[i] = Integer.parseInt(vsNum[i]);
			}
			
			for(int i=0;i<vNum.length;i++) {
				iConv += (int) (vNum[i] * Math.pow(baseA, vNum.length-(i+1)));
			}
			
			numero=iConv;
			while (numero!=0) {
				posto=numero-((numero/baseB)*baseB);
				convertito+=posto+" ";
				numero=numero/baseB;
			}
			String inverti[] = convertito.split(" ");
			convertito="";
			
			for(int i=inverti.length-1;i>=0;i--) {
				convertito+=inverti[i];
			}
		}
		
		if(baseA==16 && baseB!=16) {
			vsNum = sNumero.split("");
			vNum = new int[vsNum.length];
			
			for(int i=0;i<vsNum.length;i++) {
				if(vsNum[i].equals("A") || vsNum[i].equals("a")) {
					vsNum[i]="10";
				}
				if(vsNum[i].equals("B") || vsNum[i].equals("b")) {
					vsNum[i]="11";
				}
				if(vsNum[i].equals("C") || vsNum[i].equals("c")) {
					vsNum[i]="12";
				}
				if(vsNum[i].equals("D") || vsNum[i].equals("d")) {
					vsNum[i]="13";
				}
				if(vsNum[i].equals("E") || vsNum[i].equals("e")) {
					vsNum[i]="14";
				}
				if(vsNum[i].equals("F") || vsNum[i].equals("f")) {
					vsNum[i]="15";
				}
			}
			for(int j=0;j<vsNum.length;j++) {
				vNum[j] = Integer.parseInt(vsNum[j]);
				}
			
			for(int i=0;i<vNum.length;i++) {
				iConv += (int) (vNum[i] * Math.pow(baseA, vNum.length-(i+1)));
			}
			
			numero=iConv;
			while (numero!=0) {
				posto=numero-((numero/baseB)*baseB);
				convertito+=posto+" ";
				numero=numero/baseB;
			}
			String inverti[] = convertito.split(" ");
			convertito="";
			
			for(int i=inverti.length-1;i>=0;i--) {
				convertito+=inverti[i];
			}
		}
		
		if(baseA!=16 && baseB==16) {
			vsNum = sNumero.split("");
			vNum = new int[vsNum.length];
			
			for(int i=0;i<vsNum.length;i++) {
				vNum[i] = Integer.parseInt(vsNum[i]);
			}
			
			for(int i=0;i<vNum.length;i++) {
				iConv += (int) (vNum[i] * Math.pow(baseA, vNum.length-(i+1)));
			}
			
			numero=iConv;
			while (numero!=0) {
				posto=numero-((numero/baseB)* baseB);
				
				if(posto<10) {
					convertito+=posto+" ";
					numero=numero/baseB;
				}
				
				if(posto>=10) {
					if(posto==10) {
						convertito+="A"+" ";
						numero=numero/baseB;
					}
					if(posto==11) {
						convertito+="B"+" ";
						numero=numero/baseB;
					}
					if(posto==12) {
						convertito+="C"+" ";
						numero=numero/baseB;
					}
					if(posto==13) {
						convertito+="D"+" ";
						numero=numero/baseB;
					}
					if(posto==14) {
						convertito+="E"+" ";
						numero=numero/baseB;
					}
					if(posto==15) {
						convertito+="F"+" ";
						numero=numero/baseB;
					}
				}
			}
			String inverti[] = convertito.split(" ");
			convertito="";
			
			for(int i=inverti.length-1;i>=0;i--) {
				convertito+=inverti[i];
			}
		}
		
		lRis.setText(convertito);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}