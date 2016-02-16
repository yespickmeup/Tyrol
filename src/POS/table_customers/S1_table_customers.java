/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.table_customers;

import POS.tables.S1_tables.to_tables;
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
public class S1_table_customers {

    public static class to_table_customers {

        public final int id;
        public final String customer_id;
        public final String customer_name;
        public final String table_id;
        public final String table_name;
        public final String date_added;
        public final String user_name;
        public final String waiter_id;
        public final String waiter_name;
        public final int status;
        public int selected;

        public to_table_customers(int id, String customer_id, String customer_name, String table_id, String table_name, String date_added, String user_name, String waiter_id, String waiter_name, int status, int selected) {
            this.id = id;
            this.customer_id = customer_id;
            this.customer_name = customer_name;
            this.table_id = table_id;
            this.table_name = table_name;
            this.date_added = date_added;
            this.user_name = user_name;
            this.waiter_id = waiter_id;
            this.waiter_name = waiter_name;
            this.status = status;
            this.selected = selected;
        }

        public int getSelected() {
            return selected;
        }

        public void setSelected(int selected) {
            this.selected = selected;
        }

    }

    public static void add_table_customers(to_table_customers to_table_customers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into table_customers("
                    + "customer_id"
                    + ",customer_name"
                    + ",table_id"
                    + ",table_name"
                    + ",date_added"
                    + ",user_name"
                    + ",waiter_id"
                    + ",waiter_name"
                    + ",status"
                    + ")values("
                    + ":customer_id"
                    + ",:customer_name"
                    + ",:table_id"
                    + ",:table_name"
                    + ",:date_added"
                    + ",:user_name"
                    + ",:waiter_id"
                    + ",:waiter_name"
                    + ",:status"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("customer_id", to_table_customers.customer_id)
                    .setString("customer_name", to_table_customers.customer_name)
                    .setString("table_id", to_table_customers.table_id)
                    .setString("table_name", to_table_customers.table_name)
                    .setString("date_added", to_table_customers.date_added)
                    .setString("user_name", to_table_customers.user_name)
                    .setString("waiter_id", to_table_customers.waiter_id)
                    .setString("waiter_name", to_table_customers.waiter_name)
                    .setNumber("status", to_table_customers.status)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_table_customers.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_table_customers(to_table_customers to_table_customers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update table_customers set "
                    + "customer_id= :customer_id"
                    + ",customer_name= :customer_name"
                    + ",table_id= :table_id"
                    + ",table_name= :table_name"
                    + ",date_added= :date_added"
                    + ",user_name= :user_name"
                    + ",waiter_id= :waiter_id"
                    + ",waiter_name= :waiter_name"
                    + ",status= :status"
                    + " where "
                    + " id ='" + to_table_customers.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("customer_id", to_table_customers.customer_id)
                    .setString("customer_name", to_table_customers.customer_name)
                    .setString("table_id", to_table_customers.table_id)
                    .setString("table_name", to_table_customers.table_name)
                    .setString("date_added", to_table_customers.date_added)
                    .setString("user_name", to_table_customers.user_name)
                    .setString("waiter_id", to_table_customers.waiter_id)
                    .setString("waiter_name", to_table_customers.waiter_name)
                    .setNumber("status", to_table_customers.status)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_table_customers.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_table_customers(to_table_customers to_table_customers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from table_customers where "
                    + " id ='" + to_table_customers.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_table_customers.class, "Successfully Deleted");
            String s2 = "delete from table_customer_orders where "
                    + " table_customer_id ='" + to_table_customers.id + "' "
                    + " ";
            
            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();
            Lg.s(S1_table_customers.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_table_customers> ret_data(String where) {
        List<to_table_customers> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_id"
                    + ",customer_name"
                    + ",table_id"
                    + ",table_name"
                    + ",date_added"
                    + ",user_name"
                    + ",waiter_id"
                    + ",waiter_name"
                    + ",status"
                    + " from table_customers  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String customer_id = rs.getString(2);
                String customer_name = rs.getString(3);
                String table_id = rs.getString(4);
                String table_name = rs.getString(5);
                String date_added = rs.getString(6);
                String user_name = rs.getString(7);
                String waiter_id = rs.getString(8);
                String waiter_name = rs.getString(9);
                int status = rs.getInt(10);

                to_table_customers to = new to_table_customers(id, customer_id, customer_name, table_id, table_name, date_added, user_name, waiter_id, waiter_name, status, 1);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_table_customer_waiter(to_tables to_table_customers, String waiter_id, String waiter_name) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update table_customers set "
                    + "waiter_id= :waiter_id"
                    + ",waiter_name= :waiter_name"
                    + " where "
                    + " table_id ='" + to_table_customers.id + "' and status='" + "0" + "'"
                    + " ";
            s0 = SqlStringUtil.parse(s0)
                    .setString("waiter_id", waiter_id)
                    .setString("waiter_name", waiter_name)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_table_customers.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
