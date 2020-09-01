/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i3a.schbennoa.idpa_vorprojekt.outputPage;

import i3a.schbennoa.idpa_vorprojekt.Calculations;
import java.awt.Font;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author 1810g
 */
public class OutputPageController implements Initializable {

	@FXML
	private Pagination pagesOut;

	//Instanz der Calculations Klasse
	Calculations calculations = Calculations.getInstance();

	/**
	 * Initializes the controller class.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO

		//Erstellen der Pagination mit Länge der Abschreibungsliste
		//Eigentlich: pagesOut=new Pagination(calculations.getKonten()[2].getBetraegeList().size(),0);
		pagesOut.setPageCount(10);
		 pagesOut.setPageFactory((pageIndex) -> {

            Label label1 = new Label("Jahr: " + pageIndex+1);

            Label label2 = new Label("Main content of the page ...");

            return new VBox(label1, label2);
        });

	}

}
