/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.users;

import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import mijzcx.synapse.desk.utils.ReceiptIncrementor;

/**
 *
 * @author Ronald
 */
public class S2_users {

    public static String getScreenname(String user_name) {
        String id = "";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select screen_name from users where user_name='" + user_name + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);
            }
            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
