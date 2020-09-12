package i3a.schbennoa.idpa_vorprojekt;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



/**
 * Zuständig für die Aktionen, beim Starten des Programmes
 * 
 *@version 12.09.2020 
 */
public class MainApp extends Application {


	/**
	 *Öffnet das erste Fenster
	 */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/InputPage/MainPage.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setTitle("Abschreibungsrechner");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.sizeToScene();
        stage.show();
        
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
