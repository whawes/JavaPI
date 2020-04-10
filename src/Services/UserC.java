/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import BD.Database;
import Entities.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class UserC {

    Connection connexion;
    Statement ste;

    public UserC() {
        connexion = Database.getInstance().getConnexion();
    }

    public User login(String username, String mdp) throws SQLException {

        User u = null;
        ste = connexion.createStatement();
        ResultSet rs = ste.executeQuery("select * from fos_user where  username='" + username + "' and password='" + mdp + "'");
        while (rs.next()) {
            String emailUser = rs.getString("email");

            System.setProperty("id", Integer.toString(rs.getInt("id")));
            u = new User(username, emailUser);
            u.setRoleUser(rs.getString("roles"));

        }
        return u;
    }

    public String login(int username) throws SQLException {

        String emailUser = null;
        ste = connexion.createStatement();
        ResultSet rs = ste.executeQuery("select * from fos_user where id=" + username);
        while (rs.next()) {
            emailUser = rs.getString("email");
        }
        return emailUser;
    }

}
