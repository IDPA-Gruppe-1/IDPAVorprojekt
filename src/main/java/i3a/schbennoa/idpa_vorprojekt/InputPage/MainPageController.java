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
	private void btnBerechnen(ActionEvent event) {
		
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
	    
	}    

}
