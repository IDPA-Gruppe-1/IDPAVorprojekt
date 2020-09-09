package i3a.schbennoa.idpa_vorprojekt.InputPage;

import i3a.schbennoa.idpa_vorprojekt.Calculations;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

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
    
   	
	//Singleton Instanz von Calculations
	private Calculations calculations = Calculations.getInstance();
	
	@FXML
	private void btnBerechnen(ActionEvent event) throws IOException {
		
		double anschaffungswert=0.0;
		int dauerInJahre=0;
		double restwertProzent=0.0;
		int dirIn=0;
		int liDeg=0;

		
		
		try {
			anschaffungswert = Double.parseDouble(this.txtAnschaffungswert.getText());
			dauerInJahre = Integer.parseInt(this.txtDauerInJahre.getText());
			restwertProzent = Double.parseDouble(this.txtRestwertProzent.getText());
			
			if (anschaffungswert < 1 || dauerInJahre < 1 || restwertProzent < 0) {
				throw new RuntimeException("nicht plausible Eingaben");
			}
			
				RadioButton selectedRadioZone = (RadioButton) tgAbschreibungsart.getSelectedToggle();
				String selAbArt = selectedRadioZone.getId();
				
				if(selAbArt==rbDirekt.getId()){
					dirIn=0;
				}else{
					dirIn=1;
				}

				selectedRadioZone=(RadioButton)tgAbschreibungsmethode.getSelectedToggle();
				String selAbMeth=selectedRadioZone.getId();
				
				if(selAbMeth==rbLinear.getId()){
					liDeg=0;
				}else{
					liDeg=1;
				}
				
				// Hier Methoden für die Berechnung aufrufen
				calculations.calculate(anschaffungswert,dauerInJahre,dirIn,liDeg,restwertProzent);

				try {
					
					FXMLLoader fxmlLoader = new FXMLLoader();
					fxmlLoader.setLocation(getClass().getResource("/fxml/OutputPage/OutputPage.fxml"));
					Scene scene = new Scene(fxmlLoader.load(), 600, 600);
					Stage stage = new Stage();
					stage.setTitle("Ausgabe");
					stage.setScene(scene);
					stage.show();
					((Node)(event.getSource())).getScene().getWindow().hide();
					
				} catch (IOException e) {
					
					Logger logger = Logger.getLogger(getClass().getName());
					logger.log(Level.SEVERE, "Failed to create new Window.", e);
					
				}
		} 
		catch (Exception e) {
			this.lblInfo.setText("Es wurden nicht alle Felder* ausgefüllt\noder Buchstaben anstatt Zahlen > 0 eingegeben.");
			System.out.println(e.getMessage());
		}
		
	
		
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
		lblRestwertProzent.setText("Restwert der Anlage *");
		txtRestwertProzent.setVisible(true);	
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
