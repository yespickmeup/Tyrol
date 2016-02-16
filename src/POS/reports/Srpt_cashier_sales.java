/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.reports;

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
public class Srpt_cashier_sales {

    public final List<field> fields;

    public Srpt_cashier_sales() {
        this.fields = new ArrayList();
    }

    public static class field {

        String user_name;
        double amount_due;
        double cash;
        double discount_amount;
        double credit_card;

        public field() {
        }

        public field(String user_name, double amount_due, double cash, double discount_amount, double credit_card) {
            this.user_name = user_name;
            this.amount_due = amount_due;
            this.cash = cash;
            this.discount_amount = discount_amount;
            this.credit_card = credit_card;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public double getAmount_due() {
            return amount_due;
        }

        public void setAmount_due(double amount_due) {
            this.amount_due = amount_due;
        }

        public double getCash() {
            return cash;
        }

        public void setCash(double cash) {
            this.cash = cash;
        }

        public double getDiscount_amount() {
            return discount_amount;
        }

        public void setDiscount_amount(double discount_amount) {
            this.discount_amount = discount_amount;
        }

        public double getCredit_card() {
            return credit_card;
        }

        public void setCredit_card(double credit_card) {
            this.credit_card = credit_card;
        }

    }

    public static void main(String[] args) {
        List<Srpt_cashier_sales.field> fields = new ArrayList();
        for (int i = 0; i < 10; i++) {
            String user_name = "user 1";
            double amount_due = 100;
            double cash = 50;
            double discount_amount = 0;
            double credit_card = 10;
            Srpt_cashier_sales.field f = new field(user_name, amount_due, cash, discount_amount, credit_card);
            fields.add(f);
        }

        Srpt_cashier_sales rpt = new Srpt_cashier_sales();
        rpt.fields.addAll(fields);
        String jrxml = "rpt_cashier_sales.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_cashier_sales.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_cashier_sales to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

}
