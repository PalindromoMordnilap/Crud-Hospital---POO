package application;
	
import controller.ControllerMain;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.WindowEvent;

public class Main extends Application {
	
	private static Stage palco;
	private static Main main;
	
	//Singleton
	public static synchronized Main getMain() {
		if(main == null)
			main = new Main();
		
		return main;
	}
	
		
	@Override
	public void start(Stage palco) {
		
		this.palco = palco;
		
		palco.setTitle("Alchemilla Hospital");
		
		try {
			String url = "../view/LoginPane.fxml";
			Parent root = FXMLLoader.load(getClass().getResource(url));
			ControllerMain.lerArquivos();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			palco.setScene(scene);
			palco.show();

            palco.setOnCloseRequest(new EventHandler<WindowEvent>() {
                public void handle(WindowEvent we) {
                    ControllerMain.escreverArquivos();
                }
            });
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Stage getPalco() {
		return palco;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
