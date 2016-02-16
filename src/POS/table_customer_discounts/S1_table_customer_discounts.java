/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.table_customer_discounts;

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
public class S1_table_customer_discounts {

    public static class to_table_customer_discounts {

        public final int id;
        public final String table_customer_id;
        public final String table_id;
        public final String table_name;
        public final String user_name;
        public final String date_added;
        public final String discount_name;
        public final double discount_rate;
        public final double discount_amount;
        public final String discount_customer_no;
        public final String discount_customer_name;
        public final String discount_customer_address;
        public final String customer_ids;
        public final String customer_names;

        public to_table_customer_discounts(int id, String table_customer_id, String table_id, String table_name, String user_name, String date_added, String discount_name, double discount_rate, double discount_amount, String discount_customer_no, String discount_customer_name, String discount_customer_address, String customer_ids, String customer_names) {
            this.id = id;
            this.table_customer_id = table_customer_id;
            this.table_id = table_id;
            this.table_name = table_name;
            this.user_name = user_name;
            this.date_added = date_added;
            this.discount_name = discount_name;
            this.discount_rate = discount_rate;
            this.discount_amount = discount_amount;
            this.discount_customer_no = discount_customer_no;
            this.discount_customer_name = discount_customer_name;
            this.discount_customer_address = discount_customer_address;
            this.customer_ids = customer_ids;
            this.customer_names = customer_names;
        }
    }

    public static void add_table_customer_discounts(to_table_customer_discounts to_table_customer_discounts) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into table_customer_discounts("
                    + "table_customer_id"
                    + ",table_id"
                    + ",table_name"
                    + ",user_name"
                    + ",date_added"
                    + ",discount_name"
                    + ",discount_rate"
                    + ",discount_amount"
                    + ",discount_customer_no"
                    + ",discount_customer_name"
                    + ",discount_customer_address"
                    + ",customer_ids"
                    + ",customer_names"
                    + ")values("
                    + ":table_customer_id"
                    + ",:table_id"
                    + ",:table_name"
                    + ",:user_name"
                    + ",:date_added"
                    + ",:discount_name"
                    + ",:discount_rate"
                    + ",:discount_amount"
                    + ",:discount_customer_no"
                    + ",:discount_customer_name"
                    + ",:discount_customer_address"
                    + ",:customer_ids"
                    + ",:customer_names"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("table_customer_id", to_table_customer_discounts.table_customer_id)
                    .setString("table_id", to_table_customer_discounts.table_id)
                    .setString("table_name", to_table_customer_discounts.table_name)
                    .setString("user_name", to_table_customer_discounts.user_name)
                    .setString("date_added", to_table_customer_discounts.date_added)
                    .setString("discount_name", to_table_customer_discounts.discount_name)
                    .setNumber("discount_rate", to_table_customer_discounts.discount_rate)
                    .setNumber("discount_amount", to_table_customer_discounts.discount_amount)
                    .setString("discount_customer_no", to_table_customer_discounts.discount_customer_no)
                    .setString("discount_customer_name", to_table_customer_discounts.discount_customer_name)
                    .setString("discount_customer_address", to_table_customer_discounts.discount_customer_address)
                    .setString("customer_ids", to_table_customer_discounts.customer_ids)
                    .setString("customer_names", to_table_customer_discounts.customer_names)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_table_customer_discounts.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_table_customer_discounts(to_table_customer_discounts to_table_customer_discounts) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update table_customer_discounts set "
                    + "table_customer_id= :table_customer_id"
                    + ",table_id= :table_id"
                    + ",table_name= :table_name"
                    + ",user_name= :user_name"
                    + ",date_added= :date_added"
                    + ",discount_name= :discount_name"
                    + ",discount_rate= :discount_rate"
                    + ",discount_amount= :discount_amount"
                    + ",discount_customer_no= :discount_customer_no"
                    + ",discount_customer_name= :discount_customer_name"
                    + ",discount_customer_address= :discount_customer_address"
                    + ",customer_ids= :customer_ids"
                    + ",customer_names= :customer_names"
                    + " where "
                    + " id ='" + to_table_customer_discounts.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("table_customer_id", to_table_customer_discounts.table_customer_id)
                    .setString("table_id", to_table_customer_discounts.table_id)
                    .setString("table_name", to_table_customer_discounts.table_name)
                    .setString("user_name", to_table_customer_discounts.user_name)
                    .setString("date_added", to_table_customer_discounts.date_added)
                    .setString("discount_name", to_table_customer_discounts.discount_name)
                    .setNumber("discount_rate", to_table_customer_discounts.discount_rate)
                    .setNumber("discount_amount", to_table_customer_discounts.discount_amount)
                    .setString("discount_customer_no", to_table_customer_discounts.discount_customer_no)
                    .setString("discount_customer_name", to_table_customer_discounts.discount_customer_name)
                    .setString("discount_customer_address", to_table_customer_discounts.discount_customer_address)
                    .setString("customer_ids", to_table_customer_discounts.customer_ids)
                    .setString("customer_names", to_table_customer_discounts.customer_names)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_table_customer_discounts.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_table_customer_discounts(to_table_customer_discounts to_table_customer_discounts) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from table_customer_discounts where "
                    + " id ='" + to_table_customer_discounts.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_table_customer_discounts.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_table_customer_discounts> ret_data(String where) {
        List<to_table_customer_discounts> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",table_customer_id"
                    + ",table_id"
                    + ",table_name"
                    + ",user_name"
                    + ",date_added"
                    + ",discount_name"
                    + ",discount_rate"
                    + ",discount_amount"
                    + ",discount_customer_no"
                    + ",discount_customer_name"
                    + ",discount_customer_address"
                    + ",customer_ids"
                    + ",customer_names"
                    + " from table_customer_discounts  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String table_customer_id = rs.getString(2);
                String table_id = rs.getString(3);
                String table_name = rs.getString(4);
                String user_name = rs.getString(5);
                String date_added = rs.getString(6);
                String discount_name = rs.getString(7);
                double discount_rate = rs.getDouble(8);
                double discount_amount = rs.getDouble(9);
                String discount_customer_no = rs.getString(10);
                String discount_customer_name = rs.getString(11);
                String discount_customer_address = rs.getString(12);
                String customer_ids = rs.getString(13);
                String customer_names = rs.getString(14);

                to_table_customer_discounts to = new to_table_customer_discounts(id, table_customer_id, table_id, table_name, user_name, date_added, discount_name, discount_rate, discount_amount, discount_customer_no, discount_customer_name, discount_customer_address, customer_ids, customer_names);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static to_table_customer_discounts ret_customer_discount(String where) {
        to_table_customer_discounts to1 = new to_table_customer_discounts(-1, "", "", "", "", "", "", 0, 0, "", "", "", "", "");

        
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",table_customer_id"
                    + ",table_id"
                    + ",table_name"
                    + ",user_name"
                    + ",date_added"
                    + ",discount_name"
                    + ",discount_rate"
                    + ",discount_amount"
                    + ",discount_customer_no"
                    + ",discount_customer_name"
                    + ",discount_customer_address"
                    + ",customer_ids"
                    + ",customer_names"
                    + " from table_customer_discounts  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                int id = rs.getInt(1);
                String table_customer_id = rs.getString(2);
                String table_id = rs.getString(3);
                String table_name = rs.getString(4);
                String user_name = rs.getString(5);
                String date_added = rs.getString(6);
                String discount_name = rs.getString(7);
                double discount_rate = rs.getDouble(8);
                double discount_amount = rs.getDouble(9);
                String discount_customer_no = rs.getString(10);
                String discount_customer_name = rs.getString(11);
                String discount_customer_address = rs.getString(12);
                String customer_ids = rs.getString(13);
                String customer_names = rs.getString(14);
                to1 = new to_table_customer_discounts(id, table_customer_id, table_id, table_name, user_name, date_added, discount_name, discount_rate, discount_amount, discount_customer_no, discount_customer_name, discount_customer_address, customer_ids, customer_names);
            }
            return to1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
