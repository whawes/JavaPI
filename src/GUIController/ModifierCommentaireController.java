/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import Services.CommentaireC;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class ModifierCommentaireController implements Initializable {

    @FXML
    private TextArea text;

    /**
     * Initializes the controller class.
     */
    @FXML
    void cancel(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/GUIInterface/AfficherSujet.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        System.clearProperty("comm_id");
        System.clearProperty("comm_texte");
        stage.setTitle("New Window");
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void modifier(ActionEvent event) throws IOException, SQLException {

        CommentaireC cc = new CommentaireC();
        Alert info = new Alert(Alert.AlertType.INFORMATION);
        info.setTitle("Add");
        info.setContentText(" Done");
        info.show();
        cc.update(text.getText(), Integer.parseInt(System.getProperty("comm_id")));
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/GUIInterface/AfficherSujet.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        System.clearProperty("comm_id");
        System.clearProperty("comm_texte");
        stage.setTitle("New Window");
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        text.setText(System.getProperty("comm_texte"));
    }

}
