/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.credit_cards;

import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Ronald
 */
public class S1_credit_cards {

    public static class to_credit_cards {

        public final int id;
        public final String credit_card;
        public final double rate;

        public to_credit_cards(int id, String credit_card, double rate) {
            this.id = id;
            this.credit_card = credit_card;
            this.rate = rate;
        }
    }

    public static void add_credit_cards(to_credit_cards to_credit_cards) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into credit_cards("
                    + "credit_card"
                    + ",rate"
                    + ")values("
                    + ":credit_card"
                    + ",:rate"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("credit_card", to_credit_cards.credit_card)
                    .setNumber("rate", to_credit_cards.rate)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_credit_cards.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_credit_cards(to_credit_cards to_credit_cards) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update credit_cards set "
                    + "credit_card= :credit_card"
                    + ",rate= :rate"
                    + " where "
                    + " id ='" + to_credit_cards.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("credit_card", to_credit_cards.credit_card)
                    .setNumber("rate", to_credit_cards.rate)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_credit_cards.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_credit_cards(to_credit_cards to_credit_cards) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from credit_cards where "
                    + " id ='" + to_credit_cards.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_credit_cards.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_credit_cards> ret_data(String where) {
        List<to_credit_cards> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",credit_card"
                    + ",rate"
                    + " from credit_cards  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String credit_card = rs.getString(2);
                double rate = rs.getDouble(3);

                to_credit_cards to = new to_credit_cards(id, credit_card, rate);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
