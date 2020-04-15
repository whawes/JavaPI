/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class StartController implements Initializable {

    @FXML
    private Pane back;
    @FXML
    private Pane back1;

    /**
     * Initializes the controller class.
     */
    @FXML
    void forum(ActionEvent event) throws IOException {
        /*   FXMLLoader fxmlLoader = new FXMLLoader();
         fxmlLoader.setLocation(getClass().getResource("/GUIInterface/Forum.fxml"));
         Scene scene = new Scene(fxmlLoader.load());
         Stage stage = new Stage();
         stage.setTitle("New Window");
         stage.setScene(scene);
         stage.show();
         ((Node) (event.getSource())).getScene().getWindow().hide();
         */
    }

    @FXML
    void EdTech(ActionEvent event) throws IOException {
        /*
         FXMLLoader fxmlLoader = new FXMLLoader();
         fxmlLoader.setLocation(getClass().getResource("/GUIInterface/HomeView.fxml"));
         Scene scene = new Scene(fxmlLoader.load());
         Stage stage = new Stage();
         stage.setTitle("New Window");
         stage.setScene(scene);
         stage.show();
         ((Node) (event.getSource())).getScene().getWindow().hide();*/
        affichage("/GUIInterface/EdTech/TestView.fxml");
    }

    public void testAction(ActionEvent event) throws IOException {
        System.out.println("HERE ");
        affichage("/GUIInterface/EdTech/TestView.fxml");
    }

    public void ExerciceAction(ActionEvent event) throws IOException {

        affichage("/GUIInterface/EdTech/ExerciceView.fxml");
    }

    public void CourseAction(ActionEvent event) throws IOException {

        affichage("/GUIInterface/EdTech/CourseView.fxml");
    }

     void Sousaffichage(String x) {
        Parent fxml;

        try {
            fxml = FXMLLoader.load(getClass().getResource(x));
            back1.getChildren().removeAll();
            back1.getChildren().setAll(fxml);

        } catch (IOException ex) {
            ex.getMessage();
        }
    }
    
    void affichage(String x) {
        Parent fxml;
        System.out.println("HERE " +x);

        try {
            fxml = FXMLLoader.load(getClass().getResource(x));
            back.getChildren().removeAll();
            back.getChildren().setAll(fxml);

        } catch (IOException ex) {
            ex.getMessage();
            ex.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        affichage("/GUIInterface/EdTech/CourseView.fxml");
    }

}
