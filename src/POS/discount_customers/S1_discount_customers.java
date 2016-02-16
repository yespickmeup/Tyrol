/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.discount_customers;

import POS.sales.S1_sales.to_sales;
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
 * @author Maytopacka
 */
public class S1_discount_customers {

    public static class to_discount_customers {

        public final int id;
        public final String customer_name;
        public final String id_no;

        public to_discount_customers(int id, String customer_name, String id_no) {
            this.id = id;
            this.customer_name = customer_name;
            this.id_no = id_no;
        }
    }

    public static void add_discount_customers(to_discount_customers to_discount_customers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into discount_customers("
                    + "customer_name"
                    + ",id_no"
                    + ")values("
                    + ":customer_name"
                    + ",:id_no"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("customer_name", to_discount_customers.customer_name).
                    setString("id_no", to_discount_customers.id_no).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_discount_customers.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_discount_customers(to_discount_customers to_discount_customers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update discount_customers set "
                    + "customer_name= '" + to_discount_customers.customer_name + "'"
                    + ",id_no= '" + to_discount_customers.id_no + "'"
                    + "where "
                    + " id ='" + to_discount_customers.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_discount_customers.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_discount_customers(to_discount_customers to_discount_customers) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from discount_customers where "
                    + " id ='" + to_discount_customers.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_discount_customers.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_discount_customers> ret_data(String search) {
        List<to_discount_customers> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_name"
                    + ",id_no"
                    + " from discount_customers where "
                    + " customer_name like'%" + search + "%' "
                    + " ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String customer_name = rs.getString(2);
                String id_no = rs.getString(3);

                to_discount_customers to = new to_discount_customers(id, customer_name, id_no);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_discount_customers> ret_data2(String where) {
        List<to_discount_customers> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_name"
                    + ",id_no"
                    + " from discount_customers  "
                    + " " + where;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String customer_name = rs.getString(2);
                String id_no = rs.getString(3);

                to_discount_customers to = new to_discount_customers(id, customer_name, id_no);
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
            String s0 = "select customer_name from discount_customers";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String id = rs.getString(1);
                datas.add(id);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static to_discount_customers ret_id_no(String customer) {
        to_discount_customers to1 = null;

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_name"
                    + ",id_no"
                    + " from discount_customers where "
                    + " customer_name like'%" + customer + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                int id = rs.getInt(1);
                String customer_name = rs.getString(2);
                String id_no = rs.getString(3);

                to1 = new to_discount_customers(id, customer_name, id_no);
            }
            return to1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static to_discount_customers ret_data3(String where) {
        to_discount_customers to1 = new to_discount_customers(-1, "", "");

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_name"
                    + ",id_no"
                    + " from discount_customers  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                int id = rs.getInt(1);
                String customer_name = rs.getString(2);
                String id_no = rs.getString(3);

                to1 = new to_discount_customers(id, customer_name, id_no);
            }
            return to1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main2(String[] args) {

        String where = " group by discount_customer_name asc";
        ret_sales(where);
    }

    public static List<to_sales> ret_sales(String where) {
        List<to_sales> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",sales_no"
                    + ",date_added"
                    + ",user_name"
                    + ",session_no"
                    + ",gross_amount"
                    + ",amount_paid"
                    + ",amount_due"
                    + ",discount_name"
                    + ",discount"
                    + ",discount_amount"
                    + ",customer_name"
                    + ",check_bank"
                    + ",check_no"
                    + ",check_amount"
                    + ",discount_customer_name"
                    + ",discount_customer_id"
                    + ",status"
                    + ",or_no"
                    + ",check_holder"
                    + ",services"
                    + ",service_amount"
                    + ",customer_id"
                    + ",table_id"
                    + ",table_name"
                    + ",customer_ids"
                    + ",customer_names"
                    + ",waiter_id"
                    + ",waiter_name"
                    + ",credit_card_type"
                    + ",credit_card_rate"
                    + ",credit_card_no"
                    + ",credit_card_holder"
                    + ",credit_card_approval_code"
                    + ",credit_card_amount"
                    + ",cash"
                    + " from sales  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String sales_no = rs.getString(2);
                String date_added = rs.getString(3);
                String user_name = rs.getString(4);
                String session_no = rs.getString(5);
                double gross_amount = rs.getDouble(6);
                double amount_paid = rs.getDouble(7);
                double amount_due = rs.getDouble(8);
                String discount_name = rs.getString(9);
                double discount = rs.getDouble(10);
                double discount_amount = rs.getDouble(11);
                String customer_name = rs.getString(12);
                String check_bank = rs.getString(13);
                String check_no = rs.getString(14);
                double check_amount = rs.getDouble(15);
                String discount_customer_name = rs.getString(16);
                String discount_customer_id = rs.getString(17);
                int status = rs.getInt(18);
                String or_no = rs.getString(19);
                String check_holder = rs.getString(20);
                String services = rs.getString(21);
                double service_amount = rs.getDouble(22);
                String customer_id = rs.getString(23);
                String table_id = rs.getString(24);
                String table_name = rs.getString(25);
                String customer_ids = rs.getString(26);
                String customer_names = rs.getString(27);
                String waiter_id = rs.getString(28);
                String waiter_name = rs.getString(29);
                String credit_card_type = rs.getString(30);
                double credit_card_rate = rs.getDouble(31);
                String credit_card_no = rs.getString(32);
                String credit_card_holder = rs.getString(33);
                String credit_card_approval_code = rs.getString(34);
                double credit_card_amount = rs.getDouble(35);
                double cash = rs.getDouble(36);

                System.out.println(discount_customer_name);
                if (discount_customer_id.isEmpty() || discount_customer_id.equals("")) {

                } else {
                    if (discount_customer_name.contains(",")) {

                    } else {
                        String[] names = discount_customer_name.split("/");
                        String[] numbers = discount_customer_id.split("/");
                        for (int i = 0; i < names.length; i++) {
                            System.out.println(names[i] + " " + numbers[i]);
                        }

                    }

                    S1_discount_customers.to_discount_customers t = new S1_discount_customers.to_discount_customers(0, discount_customer_name, discount_customer_id);

//                    S1_discount_customers.add_discount_customers(t);
                }

//                to_sales to = new to_sales(id, sales_no, date_added, user_name, session_no, gross_amount, amount_paid, amount_due, discount_name, discount, discount_amount, customer_name, check_bank, check_no, check_amount, discount_customer_name, discount_customer_id, status, or_no, check_holder, services, service_amount, customer_id, table_id, table_name, customer_ids, customer_names, waiter_id, waiter_name, credit_card_type, credit_card_rate, credit_card_no, credit_card_holder, credit_card_approval_code, credit_card_amount, cash);
//                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main3(String[] args) {
        ret_data4(" where id>663");
    }

    public static List<to_discount_customers> ret_data4(String where) {
        List<to_discount_customers> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",customer_name"
                    + ",id_no"
                    + " from discount_customers2  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String customer_name = rs.getString(2);
                String id_no = rs.getString(3);
                System.out.println(customer_name + " : " + id_no);

                String[] cust = customer_name.split(",");
                String[] nums = id_no.split(",");
                for (int i = 0; i < cust.length; i++) {
                    S1_discount_customers.to_discount_customers t = new S1_discount_customers.to_discount_customers(0, cust[i], nums[i]);
                    S1_discount_customers.add_discount_customers(t);
                }
//                to_discount_customers to = new to_discount_customers(id, customer_name, id_no);
//                
//                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
