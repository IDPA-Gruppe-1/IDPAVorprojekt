package i3a.schbennoa.idpa_vorprojekt.InputPage;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class MainPageController implements Initializable {
    
	private ToggleGroup tgAbschreibungsart;
	private ToggleGroup tgAbschreibungsmethode;
	
	
	@FXML
	private RadioButton rbDirekt;
	@FXML
	private RadioButton rbIndirekt;
	@FXML
	private RadioButton rbLinear;
	@FXML
	private RadioButton rbDegressive;
	@FXML
	private Label lblRestwertProzent;
	@FXML
	private TextField txtAnschaffungswert;
	@FXML
	private TextField txtDauerInJahre;
	@FXML
	private TextField txtRestwertProzent;
	@FXML
	private Button btnBerechnen;
	@FXML
	private Label lblInfo;
	@FXML
	private Label lblTitle;
    
    
	@FXML
	private void btnBerechnen(ActionEvent event) {
		double anschaffungswert;
		double dauerInJahre;
		double restwertProzent;
		
		
		try {
			anschaffungswert = Double.parseDouble(this.txtAnschaffungswert.getText());
			dauerInJahre = Double.parseDouble(this.txtDauerInJahre.getText());
			restwertProzent = Double.parseDouble(this.txtRestwertProzent.getText());
			
			if (anschaffungswert < 1 || dauerInJahre < 1 || restwertProzent < 1) {
				throw new RuntimeException("nicht plausible Eingaben");
			}
		} 
		catch (Exception e) {
			this.lblInfo.setText("Es wurden nicht alle Felder* ausgefüllt\noder Buchstaben anstatt Zahlen > 0 eingegeben.");
			System.out.println(e.getMessage());
		}
		
		// Hier Methoden für die Berechnung aufrufen
		
	}
    
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// Radiobuttons zur richtigen ToggleGroup hinzufuegen
		tgAbschreibungsart = new ToggleGroup();
		tgAbschreibungsmethode = new ToggleGroup();

		rbDirekt.setToggleGroup(tgAbschreibungsart);
		rbIndirekt.setToggleGroup(tgAbschreibungsart);
		rbLinear.setToggleGroup(tgAbschreibungsmethode);
		rbDegressive.setToggleGroup(tgAbschreibungsmethode);
		
		txtRestwertProzent.setVisible(false);
	}    

	@FXML
	private void rbLinear(ActionEvent event) {
		lblRestwertProzent.setText("Restwert der Anlage *");
		txtRestwertProzent.setVisible(true);
	}

	@FXML
	private void rbDegressive(ActionEvent event) {
		lblRestwertProzent.setText("Abschreibung in Prozent *");
		txtRestwertProzent.setVisible(true);
	}

}
