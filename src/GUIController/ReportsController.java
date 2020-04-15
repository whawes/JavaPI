/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import Entities.Signaler;
import Entities.User;
import Services.CommentaireC;
import Services.SignalerC;
import Services.SujetC;
import Services.UserC;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Properties;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class ReportsController implements Initializable {

    @FXML
    private TableView<Signaler> listereport;
    @FXML
    private TableColumn<Signaler, String> commentaire_id;

    @FXML
    private TableColumn<Signaler, String> sujet_id;

    @FXML
    private TableColumn<Signaler, String> type;

    @FXML
    private TableColumn<Signaler, String> nombre;
    @FXML
    private Button accept;
    @FXML
    private Button decline;

    private static Message prepareMessage(Session session, String from, String recepient, String subj, String desc) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject(subj);
            message.setText(desc);
            return message;
        } catch (Exception ex) {
            System.out.println("error send");
        }
        return null;
    }

    public static void sendMail(String recepient, String subj, String desc) throws MessagingException {
        System.out.println("prep...");
        Properties prop = new Properties();

        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");

        String from = "mohamedyassine.ghadhoune@esprit.tn";
        String mdp = "sakerfomek753";
        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, mdp);
            }
        });
        Message message = prepareMessage(session, from, recepient, subj, desc);
        try {
            Transport.send(message);;
        } catch (MessagingException ex) {
            System.out.println(ex);
        }
        System.out.println("send ok");
    }

    @FXML
    void accept(ActionEvent event) throws SQLException, MessagingException {
        SujetC suj = new SujetC();
        CommentaireC cc = new CommentaireC();
        UserC u = new UserC();
        SignalerC sc = new SignalerC();
        if (listereport.getSelectionModel().getSelectedItem().getType().equals("sujet")) {
            sc.AcceptSujet(listereport.getSelectionModel().getSelectedItem().getSignaler_id(), listereport.getSelectionModel().getSelectedItem().getSujet_id());
            String user = u.login(suj.Createur(listereport.getSelectionModel().getSelectedItem().getSujet_id()));
            sendMail("mohamedyassine.ghadhoune@esprit.tn", "Sujet supprimé", "votre sujet a été trop signaler");
        } else {
            sc.AcceptComm(listereport.getSelectionModel().getSelectedItem().getSignaler_id(), listereport.getSelectionModel().getSelectedItem().getCommentaire_id());
            String user = u.login(suj.Createur(listereport.getSelectionModel().getSelectedItem().getSujet_id()));
            sendMail(user, "Commentaire supprimé", "votre commentaire a été trop signaler");

        }
        refresh();
    }

    @FXML
    void decline(ActionEvent event) throws SQLException {
        SignalerC sc = new SignalerC();
        sc.delete(listereport.getSelectionModel().getSelectedItem().getSignaler_id());

        refresh();
    }

    @FXML
    public void clickItem(MouseEvent event) throws SQLException {
        if (event.getClickCount() == 1) //Checking double click
        {
            accept.setVisible(true);
            decline.setVisible(true);
        }
    }

    @FXML
    public void refresh() throws SQLException {
        accept.setVisible(false);
        decline.setVisible(false);
        SignalerC s = new SignalerC();
        try {
            listereport.setItems(s.getAll());

        } catch (SQLException ex) {
            Logger.getLogger(ReportsController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void home(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/GUIInterface/BacK.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("New Window");
        stage.setScene(scene);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sujet_id.setCellValueFactory(new PropertyValueFactory<>("sujet_id"));
        commentaire_id.setCellValueFactory(new PropertyValueFactory<>("commentaire_id"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        accept.setVisible(false);
        decline.setVisible(false);
        SignalerC s = new SignalerC();
        try {
            listereport.setItems(s.getAll());

        } catch (SQLException ex) {
            Logger.getLogger(ReportsController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

}
