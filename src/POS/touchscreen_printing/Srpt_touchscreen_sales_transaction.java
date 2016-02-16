/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen_printing;

import POS.sales.S1_sales.to_sales;
import POS.util.DateType;
import POS.util.MyConnection;
import POS.util.Users;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Ronald
 */
public class Srpt_touchscreen_sales_transaction {

    public final List<Srpt_touchscreen_sales_transaction.field> fields;
    public final String business_name;
    public final String business_owner;
    public final String business_address;
    public final String date_printed;
    public final String sales_date;
    public final String printed_by;
    public final String SUBREPORT_DIR;

    public Srpt_touchscreen_sales_transaction(String business_name, String business_owner, String business_address, String date_printed, String sales_date, String printed_by, String SUBREPORT_DIR) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.business_owner = business_owner;
        this.business_address = business_address;
        this.date_printed = date_printed;
        this.sales_date = sales_date;
        this.printed_by = printed_by;
        this.SUBREPORT_DIR = SUBREPORT_DIR;
    }

    public static class field {

        String transaction_no;
        String table_name;
        String customer_name;
        double cash;
        double discount;
        double credit_card;
        double total;

        public field() {
        }

        public field(String transaction_no, String table_name, String customer_name, double cash, double discount, double credit_card, double total) {
            this.transaction_no = transaction_no;
            this.table_name = table_name;
            this.customer_name = customer_name;
            this.cash = cash;
            this.discount = discount;
            this.credit_card = credit_card;
            this.total = total;
        }

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }

        public String getTransaction_no() {
            return transaction_no;
        }

        public void setTransaction_no(String transaction_no) {
            this.transaction_no = transaction_no;
        }

        public String getTable_name() {
            return table_name;
        }

        public void setTable_name(String table_name) {
            this.table_name = table_name;
        }

        public String getCustomer_name() {
            return customer_name;
        }

        public void setCustomer_name(String customer_name) {
            this.customer_name = customer_name;
        }

        public double getCash() {
            return cash;
        }

        public void setCash(double cash) {
            this.cash = cash;
        }

        public double getDiscount() {
            return discount;
        }

        public void setDiscount(double discount) {
            this.discount = discount;
        }

        public double getCredit_card() {
            return credit_card;
        }

        public void setCredit_card(double credit_card) {
            this.credit_card = credit_card;
        }

    }

    public static void main(String[] args) {

        List<Srpt_touchscreen_sales_transaction.field> fields = Srpt_touchscreen_sales_transaction.ret_data("");

        String business_name = System.getProperty("business_name", "Fortune Tree Enterprises");
        String business_owner = System.getProperty("operated_by", "Ernesto C.QUiamco");
        String business_address = System.getProperty("address", "Door 2, H & J Ong bldg, Corner Colon & Sta Catalina Street Dumaguete City");
        String date_printed = DateType.day_and_time.format(new Date());
        String sales_date = "Sales Date: [" + DateType.slash.format(new Date()) + "]";
        String printed_by = Users.screen_name.toUpperCase();
        String SUBREPORT_DIR = System.getProperty("user.home");
        Srpt_touchscreen_sales_transaction rpt = new Srpt_touchscreen_sales_transaction(business_name, business_owner, business_address, date_printed, sales_date, printed_by, SUBREPORT_DIR);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_touchscreen_sales_transaction.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_touchscreen_sales_transaction.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_touchscreen_sales_transaction to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<Srpt_touchscreen_sales_transaction.field> ret_data(String where) {
        List<Srpt_touchscreen_sales_transaction.field> datas = new ArrayList();

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
                double total = (cash + credit_card_amount);

                cash=amount_due-credit_card_amount-discount_amount;
                total+=amount_due;
                Srpt_touchscreen_sales_transaction.field to = new field(sales_no, table_name, customer_names, cash
                        , discount_amount, credit_card_amount, total);
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
