/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen_printing;

import java.io.InputStream;
import java.util.ArrayList;
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
public class Srpt_billing_statement {

    public final List<Srpt_billing_statement.field> fields;
    public final String business_name;
    public final String address;
    public final String telephone_no;
    public final String table_name;
    public final String transaction_no;
    public final String waiter;
    public final String date;
    public final double discount;
    public final double net_due;
    public final String discount_type;
    public final String customer_id;
    public final String customer_name;

    public Srpt_billing_statement(String business_name, String address, String telephone_no, String table_name, String transaction_no, String waiter, String date, double discount, double net_due, String discount_type, String customer_id, String customer_name) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.address = address;
        this.telephone_no = telephone_no;
        this.table_name = table_name;
        this.transaction_no = transaction_no;
        this.waiter = waiter;
        this.date = date;
        this.discount = discount;
        this.net_due = net_due;
        this.discount_type = discount_type;
        this.customer_id = customer_id;
        this.customer_name = customer_name;

    }

    public static class field {

        double qty;
        String description;
        double selling_price;
        double amount;

        public field() {
        }

        public field(double qty, String description, double selling_price, double amount) {
            this.qty = qty;
            this.description = description;
            this.selling_price = selling_price;
            this.amount = amount;
        }

        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getSelling_price() {
            return selling_price;
        }

        public void setSelling_price(double selling_price) {
            this.selling_price = selling_price;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }
    }

    public static void main(String[] args) {

        List<Srpt_billing_statement.field> fields = new ArrayList();
        for (int i = 0; i < 20; i++) {
            double qty = 11;
            String description = "description";
            double selling_price = 1000;
            double amount = qty * selling_price;
            Srpt_billing_statement.field to = new field(qty, description, selling_price, amount);
            fields.add(to);
        }
        String business_name = System.getProperty("business_name", "Casablanca");
        String address = System.getProperty("address", "Dumaguete City");
        String telephone_no = "225-1000";
        String table_name = "1";
        String transaction_no = "0000000001";
        String waiter = "Ronald Pascua";
        String date = "01/25/2013 11:29AM";
        String discount_type = "";
        String customer_id = "";
        String customer_name = "";
        Srpt_billing_statement rpt = new Srpt_billing_statement(business_name, address, telephone_no, table_name, transaction_no, waiter, date, 0, 0, discount_type, customer_id, customer_name);
        rpt.fields.addAll(fields);
        String jrxml = "rpt_billing_statement.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper(String jrxml) {
        try {
            InputStream is = Srpt_billing_statement.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_billing_statement to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }
}
