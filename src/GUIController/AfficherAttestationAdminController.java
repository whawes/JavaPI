/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import Entities.Attestation;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import Services.AttestationService;

/**
 * FXML Controller class
 *
 * @author Selim Chikh Zaouali
 */
public class AfficherAttestationAdminController implements Initializable {

    
    
    
   /* @FXML
    private TableColumn<Attestation, String> nom;
    @FXML
    private TableColumn<Attestation, String> prenom;*/
    @FXML
    private TableColumn<Attestation, String> date;
    @FXML
    private TableColumn<Attestation, String> etat;
    @FXML
    private TableColumn<Attestation, String> parent;
    @FXML
    private TableView<Attestation> tableview;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        AttestationService as = new AttestationService();
        try {
            ArrayList<Attestation> arrayList = (ArrayList<Attestation>) as.getAllAttestations();
            System.out.println("fonction executée");
            ObservableList obs = FXCollections.observableArrayList(arrayList);
            tableview.setItems(obs);

            //nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            //prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            date.setCellValueFactory(new PropertyValueFactory<>("date"));
            etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
            parent.setCellValueFactory(new PropertyValueFactory<>("parent"));
        } catch (SQLException ex) {
            Logger.getLogger(AfficherAttestationAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
    
    
}
