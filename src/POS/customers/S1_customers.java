/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.customers;

import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.ReceiptIncrementor;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Maytopacka
 */
public class S1_customers {

    public static class to_customers {

        public final int id;
        public final String customer_name;
        public final String fname;
        public final String lname;
        public final String client_id;
        public final String client_type;
        public final String member_type;
        public final String membership;

        public to_customers(int id, String customer_name, String fname, String lname, String client_id, String client_type, String member_type, String membership) {
            this.id = id;
            this.customer_name = customer_name;
            this.fname = fname;
            this.lname = lname;
            this.client_id = client_id;
            this.client_type = client_type;
            this.member_type = member_type;
            this.membership = membership;
        }
    }

    public static void add_customers(to_customers to_customers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into customers("
                    + "customer_name"
                    + ",fname"
                    + ",lname"
                    + ",client_id"
                    + ",client_type"
                    + ",member_type"
                    + ",membership"
                    + ")values("
                    + ":customer_name"
                    + ",:fname"
                    + ",:lname"
                    + ",:client_id"
                    + ",:client_type"
                    + ",:member_type"
                    + ",:membership"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("customer_name", to_customers.customer_name)
                    .setString("fname", to_customers.fname)
                    .setString("lname", to_customers.lname)
                    .setString("client_id", to_customers.client_id)
                    .setString("client_type", to_customers.client_type)
                    .setString("member_type", to_customers.member_type)
                    .setString("membership", to_customers.membership)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_customers.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_customers(to_customers to_customers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update customers set "
                    + "customer_name= :customer_name"
                    + ",fname= :fname"
                    + ",lname= :lname"
                    + ",client_id= :client_id"
                    + ",client_type= :client_type"
                    + ",member_type= :member_type"
                    //                    + ",membership= :membership"
                    + " where "
                    + " id ='" + to_customers.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("customer_name", to_customers.customer_name)
                    .setString("fname", to_customers.fname)
                    .setString("lname", to_customers.lname)
                    .setString("client_id", to_customers.client_id)
                    .setString("client_type", to_customers.client_type)
                    .setString("member_type", to_customers.member_type)
                    //                    .setString("membership", to_customers.membership)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_customers.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_customers(to_customers to_customers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from customers where "
                    + " id ='" + to_customers.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_customers.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_customers> ret_data(String where) {
        List<to_customers> datas = new ArrayList();
        to_customers to2 = new to_customers(-1, "", "WALK-IN", "", "", "", "", "");
        datas.add(to2);
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_name"
                    + ",fname"
                    + ",lname"
                    + ",client_id"
                    + ",client_type"
                    + ",member_type"
                    + ",membership"
                    + " from customers  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String customer_name = rs.getString(2);
                String fname = rs.getString(3);
                String lname = rs.getString(4);
                String client_id = rs.getString(5);
                String client_type = rs.getString(6);
                String member_type = rs.getString(7);
                String membership = rs.getString(8);

                to_customers to = new to_customers(id, customer_name, fname, lname, client_id, client_type, member_type, membership);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<String> ret_cb_data() {
        List<String> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select customer_name from customers";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String id = rs.getString(1);
                datas.add(id);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main(String[] args) {
        System.out.println(increment_id());
    }

    public static String increment_id() {
        String id = "0";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from customers";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);
            }

            String s2 = "select "
                    + "client_id"
                    + " from customers where "
                    + " id ='" + id + "' "
                    + " ";

            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt.executeQuery(s2);
            if (rs2.next()) {
                 id = rs2.getString(1);
            }
            id = ReceiptIncrementor.increment(id);
            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
