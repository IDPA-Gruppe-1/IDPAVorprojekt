/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i3a.schbennoa.idpa_vorprojekt.outputPage;

import i3a.schbennoa.idpa_vorprojekt.Calculations;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 *Kontroller der Ausgabeseite 
 * 
 *
 * @version 16.09.2020
 */
public class OutputPageController implements Initializable {

	@FXML
	private Pagination pagesOut;

	//Instanz der Calculations Klasse
	private final Calculations calculations = Calculations.getInstance();
    @FXML
    private ImageView ausgabeBG;

	/**
	 * Konstruktor der Kontroller Klasse
	 * Label1: das aktuelle Jahr
	 * Label2: Der Betrag des Anlagevermögen Kontos
	 * Label3: Der Betrag des WBAnlagevermögen Kontos
	 * Label4: der Betrag des Abschreibung Kontos
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		//Erstellen der Pagination mit Länge der Abschreibungsliste
		pagesOut.setPageCount(calculations.getKonten()[2].getBetraegeList().size());


		//Factory für das Beüllen der Seiten der Pagination
		//Quelle:http://tutorials.jenkov.com/javafx/pagination.html (Aktuell am 16.09.2020) 
		 pagesOut.setPageFactory((pageIndex) -> {

            Label label1 = new Label("Jahr:  " + (pageIndex+1));
            label1.setStyle("-fx-text-fill: white; -fx-font-size: 18");

            
            //label1.setStyle("-fx-font-size: 24");
	    double anlageVermoegen=calculations.getKonten()[0].getBetraegeList().get(pageIndex);

	    //Wenn die Abschreibungsmethode direkt ist, ist das Anlagevermöegen=Anlagevermögen-Abschreibungen, ansonsten bleibt es immer gleich
	    if(calculations.getKonten()[1].getBetraegeList().get(0)==0){
		    anlageVermoegen-=calculations.getKonten()[2].getBetraegeList().get(pageIndex);
	    }
            Label label2 = new Label("Anlagevermögen:  "+anlageVermoegen);
            label2.setStyle("-fx-text-fill: white; -fx-font-size: 18");
            Label label3 = new Label("WB Anlagevermögen:  "+calculations.getKonten()[1].getBetraegeList().get(pageIndex));
            label3.setStyle("-fx-text-fill: white; -fx-font-size: 18");
            Label label4 = new Label("Abschreibungen:  "+calculations.getKonten()[2].getBetraegeList().get(pageIndex));
            label4.setStyle("-fx-text-fill: white; -fx-font-size: 18");
            VBox ausgabe = new VBox(label1, label2,label3,label4);
            ausgabe.setAlignment(Pos.CENTER);
            return ausgabe;
        });

	}

}
