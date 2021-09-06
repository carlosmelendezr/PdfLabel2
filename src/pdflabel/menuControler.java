package pdflabel;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class menuControler implements Initializable {

    Stage stage;
    @FXML
    private Parent root;

    @Override
    public void initialize(URL url, ResourceBundle rb) {



    }

    public void Amazon() {


        stage = (Stage) root.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        } catch(Exception e) {

        }

        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();




    }

    public void Etiqueta() {

        stage = (Stage) root.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("etiqenvio.fxml"));
        } catch(Exception e) {

        }

        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    public void Almacen() {

        stage = (Stage) root.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("etiqalmacen.fxml"));
        } catch(Exception e) {

        }

        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
}
