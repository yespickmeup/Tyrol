/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.sales;

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
 * @author i1
 */
public class S1_sales {

    public static class to_sales {

        public final int id;
        public final String sales_no;
        public final String date_added;
        public final String user_name;
        public final String session_no;
        public final double gross_amount;
        public final double amount_paid;
        public final double amount_due;
        public final String discount_name;
        public final double discount;
        public final double discount_amount;
        public final String customer_name;
        public final String check_bank;
        public final String check_no;
        public final double check_amount;
        public final String discount_customer_name;
        public final String discount_customer_id;
        public final int status;
        public final String or_no;
        public final String check_holder;
        public final String services;
        public final double service_amount;
        public final String customer_id;
        public final String table_id;
        public final String table_name;
        public final String customer_ids;
        public final String customer_names;
        public final String waiter_id;
        public final String waiter_name;
        public final String credit_card_type;
        public final double credit_card_rate;
        public final String credit_card_no;
        public final String credit_card_holder;
        public final String credit_card_approval_code;
        public final double credit_card_amount;
        public final double cash;
        public final double gift_certificate_amount;
        public final String gift_certificate_details;

        public to_sales(int id, String sales_no, String date_added, String user_name, String session_no
                , double gross_amount, double amount_paid, double amount_due, String discount_name, double discount
                , double discount_amount, String customer_name, String check_bank, String check_no, double check_amount
                , String discount_customer_name, String discount_customer_id, int status, String or_no
                , String check_holder, String services, double service_amount, String customer_id
                , String table_id, String table_name, String customer_ids, String customer_names
                , String waiter_id, String waiter_name, String credit_card_type, double credit_card_rate
                , String credit_card_no, String credit_card_holder, String credit_card_approval_code
                , double credit_card_amount, double cash, double gift_certificate_amount, String gift_certificate_details) {
            this.id = id;
            this.sales_no = sales_no;
            this.date_added = date_added;
            this.user_name = user_name;
            this.session_no = session_no;
            this.gross_amount = gross_amount;
            this.amount_paid = amount_paid;
            this.amount_due = amount_due;
            this.discount_name = discount_name;
            this.discount = discount;
            this.discount_amount = discount_amount;
            this.customer_name = customer_name;
            this.check_bank = check_bank;
            this.check_no = check_no;
            this.check_amount = check_amount;
            this.discount_customer_name = discount_customer_name;
            this.discount_customer_id = discount_customer_id;
            this.status = status;
            this.or_no = or_no;
            this.check_holder = check_holder;
            this.services = services;
            this.service_amount = service_amount;
            this.customer_id = customer_id;
            this.table_id = table_id;
            this.table_name = table_name;
            this.customer_ids = customer_ids;
            this.customer_names = customer_names;
            this.waiter_id = waiter_id;
            this.waiter_name = waiter_name;
            this.credit_card_type = credit_card_type;
            this.credit_card_rate = credit_card_rate;
            this.credit_card_no = credit_card_no;
            this.credit_card_holder = credit_card_holder;
            this.credit_card_approval_code = credit_card_approval_code;
            this.credit_card_amount = credit_card_amount;
            this.cash = cash;
            this.gift_certificate_amount = gift_certificate_amount;
            this.gift_certificate_details = gift_certificate_details;
        }
    }

    public static void add_sales(to_sales to_sales) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into sales("
                    + "sales_no"
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
                    + ",gift_certificate_amount"
                    + ",gift_certificate_details"
                    + ")values("
                    + ":sales_no"
                    + ",:date_added"
                    + ",:user_name"
                    + ",:session_no"
                    + ",:gross_amount"
                    + ",:amount_paid"
                    + ",:amount_due"
                    + ",:discount_name"
                    + ",:discount"
                    + ",:discount_amount"
                    + ",:customer_name"
                    + ",:check_bank"
                    + ",:check_no"
                    + ",:check_amount"
                    + ",:discount_customer_name"
                    + ",:discount_customer_id"
                    + ",:status"
                    + ",:or_no"
                    + ",:check_holder"
                    + ",:services"
                    + ",:service_amount"
                    + ",:customer_id"
                    + ",:table_id"
                    + ",:table_name"
                    + ",:customer_ids"
                    + ",:customer_names"
                    + ",:waiter_id"
                    + ",:waiter_name"
                    + ",:credit_card_type"
                    + ",:credit_card_rate"
                    + ",:credit_card_no"
                    + ",:credit_card_holder"
                    + ",:credit_card_approval_code"
                    + ",:credit_card_amount"
                    + ",:cash"
                    + ",:gift_certificate_amount"
                    + ",:gift_certificate_details"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("sales_no", to_sales.sales_no)
                    .setString("date_added", to_sales.date_added)
                    .setString("user_name", to_sales.user_name)
                    .setString("session_no", to_sales.session_no)
                    .setNumber("gross_amount", to_sales.gross_amount)
                    .setNumber("amount_paid", to_sales.amount_paid)
                    .setNumber("amount_due", to_sales.amount_due)
                    .setString("discount_name", to_sales.discount_name)
                    .setNumber("discount", to_sales.discount)
                    .setNumber("discount_amount", to_sales.discount_amount)
                    .setString("customer_name", to_sales.customer_name)
                    .setString("check_bank", to_sales.check_bank)
                    .setString("check_no", to_sales.check_no)
                    .setNumber("check_amount", to_sales.check_amount)
                    .setString("discount_customer_name", to_sales.discount_customer_name)
                    .setString("discount_customer_id", to_sales.discount_customer_id)
                    .setNumber("status", to_sales.status)
                    .setString("or_no", to_sales.or_no)
                    .setString("check_holder", to_sales.check_holder)
                    .setString("services", to_sales.services)
                    .setNumber("service_amount", to_sales.service_amount)
                    .setString("customer_id", to_sales.customer_id)
                    .setString("table_id", to_sales.table_id)
                    .setString("table_name", to_sales.table_name)
                    .setString("customer_ids", to_sales.customer_ids)
                    .setString("customer_names", to_sales.customer_names)
                    .setString("waiter_id", to_sales.waiter_id)
                    .setString("waiter_name", to_sales.waiter_name)
                    .setString("credit_card_type", to_sales.credit_card_type)
                    .setNumber("credit_card_rate", to_sales.credit_card_rate)
                    .setString("credit_card_no", to_sales.credit_card_no)
                    .setString("credit_card_holder", to_sales.credit_card_holder)
                    .setString("credit_card_approval_code", to_sales.credit_card_approval_code)
                    .setNumber("credit_card_amount", to_sales.credit_card_amount)
                    .setNumber("cash", to_sales.cash)
                    .setNumber("gift_certificate_amount",to_sales.gift_certificate_amount)
                    .setString("gift_certificate_details",to_sales.gift_certificate_details)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_sales.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_sales(to_sales to_sales) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update sales set "
                    + "sales_no= :sales_no"
                    + ",date_added= :date_added"
                    + ",user_name= :user_name"
                    + ",session_no= :session_no"
                    + ",gross_amount= :gross_amount"
                    + ",amount_paid= :amount_paid"
                    + ",amount_due= :amount_due"
                    + ",discount_name= :discount_name"
                    + ",discount= :discount"
                    + ",discount_amount= :discount_amount"
                    + ",customer_name= :customer_name"
                    + ",check_bank= :check_bank"
                    + ",check_no= :check_no"
                    + ",check_amount= :check_amount"
                    + ",discount_customer_name= :discount_customer_name"
                    + ",discount_customer_id= :discount_customer_id"
                    + ",status= :status"
                    + ",or_no= :or_no"
                    + ",check_holder= :check_holder"
                    + ",services= :services"
                    + ",service_amount= :service_amount"
                    + ",customer_id= :customer_id"
                    + ",table_id= :table_id"
                    + ",table_name= :table_name"
                    + ",customer_ids= :customer_ids"
                    + ",customer_names= :customer_names"
                    + ",waiter_id= :waiter_id"
                    + ",waiter_name= :waiter_name"
                    + ",credit_card_type= :credit_card_type"
                    + ",credit_card_rate= :credit_card_rate"
                    + ",credit_card_no= :credit_card_no"
                    + ",credit_card_holder= :credit_card_holder"
                    + ",credit_card_approval_code= :credit_card_approval_code"
                    + ",credit_card_amount= :credit_card_amount"
                    + ",gift_certificate_amount= :gift_certificate_amount"
                    + ",gift_certificate_details= :gift_certificate_details"
                    + " where "
                    + " id ='" + to_sales.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("sales_no", to_sales.sales_no)
                    .setString("date_added", to_sales.date_added)
                    .setString("user_name", to_sales.user_name)
                    .setString("session_no", to_sales.session_no)
                    .setNumber("gross_amount", to_sales.gross_amount)
                    .setNumber("amount_paid", to_sales.amount_paid)
                    .setNumber("amount_due", to_sales.amount_due)
                    .setString("discount_name", to_sales.discount_name)
                    .setNumber("discount", to_sales.discount)
                    .setNumber("discount_amount", to_sales.discount_amount)
                    .setString("customer_name", to_sales.customer_name)
                    .setString("check_bank", to_sales.check_bank)
                    .setString("check_no", to_sales.check_no)
                    .setNumber("check_amount", to_sales.check_amount)
                    .setString("discount_customer_name", to_sales.discount_customer_name)
                    .setString("discount_customer_id", to_sales.discount_customer_id)
                    .setNumber("status", to_sales.status)
                    .setString("or_no", to_sales.or_no)
                    .setString("check_holder", to_sales.check_holder)
                    .setString("services", to_sales.services)
                    .setNumber("service_amount", to_sales.service_amount)
                    .setString("customer_id", to_sales.customer_id)
                    .setString("table_id", to_sales.table_id)
                    .setString("table_name", to_sales.table_name)
                    .setString("customer_ids", to_sales.customer_ids)
                    .setString("customer_names", to_sales.customer_names)
                    .setString("waiter_id", to_sales.waiter_id)
                    .setString("waiter_name", to_sales.waiter_name)
                    .setString("credit_card_type", to_sales.credit_card_type)
                    .setNumber("credit_card_rate", to_sales.credit_card_rate)
                    .setString("credit_card_no", to_sales.credit_card_no)
                    .setString("credit_card_holder", to_sales.credit_card_holder)
                    .setString("credit_card_approval_code", to_sales.credit_card_approval_code)
                    .setNumber("credit_card_amount", to_sales.credit_card_amount)
                    .setNumber("gift_certificate_amount",to_sales.gift_certificate_amount)
                    .setString("gift_certificate_details", to_sales.gift_certificate_details)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_sales.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_sales(to_sales to_sales) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from sales where "
                    + " id ='" + to_sales.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_sales.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_sales> ret_data(String date_from, String date_to, String user_names) {
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
                    + ",gift_certificate_amount"
                    + ",gift_certificate_details"
                    + " from sales where "
                    + " date(date_added) between '" + date_from + "' and '" + date_to + "' "
                    + " and user_name like'%" + user_names + "%' "
                    + " ";

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
                double gift_certificate_amount=rs.getDouble(37);
                String gift_certificate_details=rs.getString(38);
                to_sales to = new to_sales(id, sales_no, date_added, user_name, session_no, gross_amount, amount_paid, amount_due
                        , discount_name, discount, discount_amount, customer_name, check_bank, check_no, check_amount
                        , discount_customer_name, discount_customer_id, status, or_no, check_holder, services
                        , service_amount, customer_id, table_id, table_name, customer_ids, customer_names
                        , waiter_id, waiter_name, credit_card_type, credit_card_rate, credit_card_no
                        , credit_card_holder, credit_card_approval_code, credit_card_amount, cash,gift_certificate_amount, gift_certificate_details);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_sales> ret_data_or(String date_from, String date_to, String or_nos) {
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
                    + ",gift_certificate_amount"
                    + ",gift_certificate_details"
                    + " from sales where "
                    + " date(date_added) between '" + date_from + "' and '" + date_to + "' "
                    + " and or_no like '%" + or_nos + "%' "
                    + " ";

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
                double gift_certificate_amount=rs.getDouble(37);
                String gift_certificate_details=rs.getString(38);
                to_sales to = new to_sales(id, sales_no, date_added, user_name, session_no, gross_amount, amount_paid, amount_due
                        , discount_name, discount, discount_amount, customer_name, check_bank, check_no, check_amount
                        , discount_customer_name, discount_customer_id, status, or_no, check_holder, services
                        , service_amount, customer_id, table_id, table_name, customer_ids, customer_names
                        , waiter_id, waiter_name, credit_card_type, credit_card_rate, credit_card_no, credit_card_holder
                        , credit_card_approval_code, credit_card_amount, cash,gift_certificate_amount,gift_certificate_details);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_sales> ret_data(String where) {
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
                    + ",gift_certificate_amount"
                    + ",gift_certificate_details"
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
                double gift_certificate_amount=rs.getDouble(37);
                String gift_certificate_details=rs.getString(38);
                to_sales to = new to_sales(id, sales_no, date_added, user_name, session_no, gross_amount, amount_paid
                        , amount_due, discount_name, discount, discount_amount, customer_name, check_bank, check_no
                        , check_amount, discount_customer_name, discount_customer_id, status, or_no, check_holder
                        , services, service_amount, customer_id, table_id, table_name, customer_ids, customer_names
                        , waiter_id, waiter_name, credit_card_type, credit_card_rate, credit_card_no, credit_card_holder
                        , credit_card_approval_code, credit_card_amount, cash,gift_certificate_amount,gift_certificate_details);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String increment_id() {
        String ids = "SN-00000000000";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from sales";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                ids = rs.getString(1);
            }
            if (ids == null) {
                ids = "SN-00000000001";
            } else {
                String s2 = "select sales_no from sales where id='" + ids + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    ids = rs2.getString(1);
                }
            }

            ids = ReceiptIncrementor.increment(ids);

            return ids;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static int count_sales() {
        int count = 0;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select count(id) from sales";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
