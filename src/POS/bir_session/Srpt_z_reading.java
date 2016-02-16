/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.bir_session;

import POS.reports.Srpt_cashier_sales;
import POS.sales.S1_sales.to_sales;
import POS.sales.S1_sales_items.to_sales_items;
import POS.users.S2_users;
import POS.util.DateType;
import POS.util.DateUtils;
import POS.util.MyConnection;
import POS.util.Users;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Maytopacka
 */
public class Srpt_z_reading {

    public final String SUBREPORT_DIR;
    public final String business_name;
    public final String operated_by;
    public final String address;
    public final String start_date;
    public final String date_as_of;
    public final String generated_by;
    public final String date_printed;
    public final String total_days_as_of;
    public final double total_gross_sales;
    public final double total_vat_sales;
    public final double total_non_vat_sales;
    public final double total_void_sales;
    public final double total_vat;
    public final double total_discount;
    public final double total_sc_discount;
    public final double total_reg_discount;
    public final double total_other_discount;
    public final double no_qty_sold;
    public final double no_trans;
    public final double no_not_void_trans;
    public final double no_void_trans;
    public final double no_no_discount_trans;
    public final double no_sc_discount_trans;
    public final double no_reg_discount_trans;
    public final double no_other_discount_trans;
    public final double total_prev_end_sales;
    public final double total_prev_grand_total_sales;
    public final double total_current_end_sales;
    public final double total_current_grand_sales;
    public final List<Srpt_checks.field> rpt_checks;
    public final double qty_sold;
    public final double no_cash_payments;
    public final double no_check_payments;
    public final double total_cash_payments;
    public final double total_check_payments;
    public final List<Srpt_checks.field> rpt_expenses;
    public final double grand_sales;
    public final double grand_checks;
    public final double grand_expenses;
    public final double foods;
    public final double beverages;
    public final List<Srpt_cashier_sales.field> rpt_cashier_sales;
    public final double total_void_amount;
    public final double gift_certificate;
    public final double total_disbursements;
    public final double total_cash_in_hand;
    public final List<Srpt_checks.field> rpt_expenses_vault;
    public final double total_disbursements_vault;

    public Srpt_z_reading(String SUBREPORT_DIR, String business_name, String operated_by, String address, String start_date, String date_as_of, String generated_by, String date_printed, String total_days_as_of, double total_gross_sales, double total_vat_sales, double total_non_vat_sales, double total_void_sales, double total_vat, double total_discount, double total_sc_discount, double total_reg_discount, double total_other_discount, double no_qty_sold, double no_trans, double no_not_void_trans, double no_void_trans, double no_no_discount_trans, double no_sc_discount_trans, double no_reg_discount_trans, double no_other_discount_trans, double total_prev_end_sales, double total_prev_grand_total_sales, double total_current_end_sales, double total_current_grand_sales, List<Srpt_checks.field> rpt_checks, double qty_sold, double no_cash_payments, double no_check_payments, double total_cash_payments, double total_check_payments, List<Srpt_checks.field> rpt_expenses, double grand_sales, double grand_checks, double grand_expenses, double foods, double beverages, List<Srpt_cashier_sales.field> rpt_cashier_sales, double total_void_amount, double gift_certificate, double total_disbursements, double total_cash_in_hand, List<Srpt_checks.field> rpt_expenses_vault, double total_disbursements_vault) {
        this.SUBREPORT_DIR = SUBREPORT_DIR;
        this.business_name = business_name;
        this.operated_by = operated_by;
        this.address = address;
        this.start_date = start_date;
        this.date_as_of = date_as_of;
        this.generated_by = generated_by;
        this.date_printed = date_printed;
        this.total_days_as_of = total_days_as_of;
        this.total_gross_sales = total_gross_sales;
        this.total_vat_sales = total_vat_sales;
        this.total_non_vat_sales = total_non_vat_sales;
        this.total_void_sales = total_void_sales;
        this.total_vat = total_vat;
        this.total_discount = total_discount;
        this.total_sc_discount = total_sc_discount;
        this.total_reg_discount = total_reg_discount;
        this.total_other_discount = total_other_discount;
        this.no_qty_sold = no_qty_sold;
        this.no_trans = no_trans;
        this.no_not_void_trans = no_not_void_trans;
        this.no_void_trans = no_void_trans;
        this.no_no_discount_trans = no_no_discount_trans;
        this.no_sc_discount_trans = no_sc_discount_trans;
        this.no_reg_discount_trans = no_reg_discount_trans;
        this.no_other_discount_trans = no_other_discount_trans;
        this.total_prev_end_sales = total_prev_end_sales;
        this.total_prev_grand_total_sales = total_prev_grand_total_sales;
        this.total_current_end_sales = total_current_end_sales;
        this.total_current_grand_sales = total_current_grand_sales;
        this.rpt_checks = rpt_checks;
        this.qty_sold = qty_sold;
        this.no_cash_payments = no_cash_payments;
        this.no_check_payments = no_check_payments;
        this.total_cash_payments = total_cash_payments;
        this.total_check_payments = total_check_payments;
        this.rpt_expenses = rpt_expenses;
        this.grand_sales = grand_sales;
        this.grand_checks = grand_checks;
        this.grand_expenses = grand_expenses;
        this.foods = foods;
        this.beverages = beverages;
        this.rpt_cashier_sales = rpt_cashier_sales;
        this.total_void_amount = total_void_amount;
        this.gift_certificate = gift_certificate;
        this.total_disbursements = total_disbursements;
        this.total_cash_in_hand = total_cash_in_hand;
        this.rpt_expenses_vault = rpt_expenses_vault;
        this.total_disbursements_vault = total_disbursements_vault;

    }

    public static void main(String[] args) {

//        List<Srpt_sales_items.field> fields = new ArrayList();
        String SUBREPORT_DIR = System.getProperty("img_path", "C:\\Users\\Ronald\\") + "retail_res\\rpt\\";
        String business_name = System.getProperty("business_name", "Fortune Tree Enterprises");
        String operated_by = System.getProperty("operated_by", "Ernesto C.QUiamco");
        String address = System.getProperty("address", "Door 2, H & J Ong bldg, Corner Colon & Sta Catalina Street Dumaguete City");
        String start_date = "July 1,2013";
        String date_as_of = "July 1,2013";
        String generated_by = "Administrator";
        String date_printed = "July 1,2013";
        String total_days_as_of = "1";
        double total_gross_sales = 0;
        double total_vat_sales = 0;
        double total_non_vat_sales = 0;
        double total_void_sales = 0;
        double total_vat = 0;
        double total_discount = 0;
        double total_sc_discount = 0;
        double total_reg_discount = 0;
        double total_other_discount = 0;
        double no_qty_sold = 0;
        double no_trans = 0;
        double no_not_void_trans = 0;
        double no_void_trans = 0;
        double no_no_discount_trans = 0;
        double no_sc_discount_trans = 0;
        double no_reg_discount_trans = 0;
        double no_other_discount_trans = 0;
        double total_prev_end_sales = 0;
        double total_prev_grand_total_sales = 0;
        double total_current_end_sales = 0;
        double total_current_grand_sales = 0;
        double grand_sales = 0;
        double grand_checks = 0;
        double grand_expenses = 0;
        List<Srpt_checks.field> fields = new ArrayList();
        List<Srpt_cashier_sales.field> rpt_cashier_sales = new ArrayList();
        for (int i = 0; i < 5; i++) {
            String check_bank = "BANK " + i;
            String check_holder = "HOLDER " + i;
            String check_no = "0000000" + i;
            double check_amount = 10000 + i;
            String date = "July 1,2013";
            if (i >= 1 && i <= 5) {
                date = "July 1,2013";
            }
            if (i >= 6 && i <= 10) {
                date = "July 2,2013";
            }
            if (i >= 11 && i <= 15) {
                date = "July 3,2013";
            }
            if (i >= 16 && i <= 20) {
                date = "July 4,2013";
            }
            Srpt_checks.field t = new Srpt_checks.field(check_bank, check_holder, check_no, check_amount, date);
            fields.add(t);
        }

        Srpt_z_reading rpt = new Srpt_z_reading(SUBREPORT_DIR, business_name, operated_by, address, start_date, date_as_of, generated_by, date_printed, total_days_as_of, total_gross_sales, total_vat_sales, total_non_vat_sales, total_void_sales, total_vat, total_discount, total_sc_discount, total_reg_discount, total_other_discount, no_qty_sold, no_trans, no_not_void_trans, no_void_trans, no_no_discount_trans, no_sc_discount_trans, no_reg_discount_trans, no_other_discount_trans, total_prev_end_sales, total_prev_grand_total_sales, total_current_end_sales, total_current_grand_sales, fields, 0, 0, 0, 0, 0, fields, grand_sales, grand_checks, grand_expenses, 0, 0, rpt_cashier_sales, 0, 0, 0, 0, new ArrayList(), 0);

        //        rpt.fields.addAll(fields);
        String jrxml = "rpt_z_reading.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_z_reading.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_z_reading to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.emptyDatasource());
    }

    public static Srpt_z_reading ret_data(String date_from, String date_to) {
        List<to_sales> datas = new ArrayList();
        String SUBREPORT_DIR = System.getProperty("img_path", "C:\\Users\\Guinness\\") + "retail_res\\rpt\\";
        String business_name = System.getProperty("business_name", "Fortune Tree Enterprises");
        String operated_by = System.getProperty("operated_by", "Ernesto C.QUiamco");
        String address = System.getProperty("address", "Door 2, H & J Ong bldg, Corner Colon & Sta Catalina Street Dumaguete City");
        Date start = new Date();
        Date end = new Date();
        try {
            start = DateType.sf.parse(date_from);
            end = DateType.sf.parse(date_to);
        } catch (ParseException ex) {
            Logger.getLogger(Srpt_z_reading.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        int count_days = DateUtils.count_days(start, end) + 1;
        String start_date = DateType.month_date.format(start);
        String date_as_of = DateType.month_date.format(end);

        String now = DateType.sf.format(new Date());
        String now2 = DateType.sf.format(end);

        String generated_by = "Administrator";
        String date_printed = DateType.day_and_time.format(new Date());
        String total_days_as_of = "" + count_days;
        double total_gross_sales = 0;
        double total_vat_sales = 0;
        double total_non_vat_sales = 0;
        double total_void_sales = 0;
        double total_vat = 0;
        double total_discount = 0;
        double total_sc_discount = 0;
        double total_reg_discount = 0;
        double total_other_discount = 0;
        double no_qty_sold = 0;
        double no_trans = 0;
        double no_not_void_trans = 0;
        double no_void_trans = 0;
        double no_no_discount_trans = 0;
        double no_sc_discount_trans = 0;
        double no_reg_discount_trans = 0;
        double no_other_discount_trans = 0;
        double total_prev_end_sales = 0;
        double total_prev_grand_total_sales = 0;
        double total_current_end_sales = 0;
        double total_current_grand_sales = 0;
        double qty_sold = 0;
        List<Srpt_checks.field> fields = new ArrayList();
        List<Srpt_checks.field> fields2 = new ArrayList();
        double no_cash_payments = 0;
        double no_check_payments = 0;
        double total_cash_payments = 0;
        double total_check_payments = 0;
        double grand_sales = 0;
        double grand_checks = 0;
        double grand_expenses = 0;
        double total_void_amount = 0;
        double gift_certificate = 0;
        double total_disbursements = 0;
        double total_cash_in_hand;
        List<Srpt_cashier_sales.field> rpt_cashier_sales = new ArrayList();
        double total_disbursements_vault = 0;
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
                    + ",credit_card_amount"
                    + ",discount_customer_name"
                    + ",discount_customer_id"
                    + ",status"
                    + ",or_no"
                    + ",check_holder"
                    + ",credit_card_amount"
                    + ",gift_certificate_amount"
                    + " from sales where "
                    + " date(date_added) between '" + date_from + "' and '" + date_to + "' order by user_name asc"
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            List<to_sales_items> items = new ArrayList();

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
                double credit_card_amount = rs.getDouble(21);
                double gift_certificate_amount = rs.getDouble(22);
                if (status == 0) {
                    total_gross_sales += amount_due;
                    total_discount += discount_amount;
                    total_cash_payments += amount_due - discount_amount - check_amount - gift_certificate_amount;
                    total_check_payments += check_amount;
                    double d = discount_amount;
                    double c = amount_due - discount_amount - check_amount;
                    double cc = check_amount;
                    total_current_grand_sales += d + c + cc;
                    gift_certificate += gift_certificate_amount;
                    String user_name1 = user_name;
                    user_name1 = S2_users.getScreenname(user_name1);
                    double amount_due1 = amount_due;
                    double cash1 = c;
                    double discount_amount1 = d;
                    double credit_card1 = cc;
                    

                    Srpt_cashier_sales.field f = new Srpt_cashier_sales.field(user_name1, amount_due1, cash1, discount_amount1, credit_card_amount);
                    rpt_cashier_sales.add(f);

                } else {
                    no_void_trans++;
                    total_void_amount += amount_due;
                }
            }
            
            String s2 = "select "
                    + "id"
                    + ",barcode"
                    + ",description"
                    + ",generic_name"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_classification"
                    + ",sub_classification_id"
                    + ",product_qty"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",date_added"
                    + ",user_name"
                    + ",item_type"
                    + ",status"
                    + ",session_no"
                    + ",item_discount"
                    + ",discount"
                    + ",discount_amount"
                    + ",sales_no"
                    + ",fixed_price"
                    + ",supplier"
                    + ",supplier_id"
                    + ",vatable"
                    + ",or_no"
                    + ",group_id"
                    + " from sales_items where "
                    + " date(date_added) between '" + date_from + "' and '" + date_to + "' "
                    + " ";

            double foods = 0;
            double beverages = 0;
            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt2.executeQuery(s2);
            double non_vat_sales = 0;
            while (rs2.next()) {
                int id2 = rs2.getInt(1);
                String barcode = rs2.getString(2);
                String description = rs2.getString(3);
                String generic_name = rs2.getString(4);
                String category = rs2.getString(5);
                String category_id = rs2.getString(6);
                String classification = rs2.getString(7);
                String classification_id = rs2.getString(8);
                String sub_classification = rs2.getString(9);
                String sub_classification_id = rs2.getString(10);
                double product_qty = rs2.getDouble(11);

                String unit = rs2.getString(12);
                double conversion = rs2.getDouble(13);
                double selling_price = rs2.getDouble(14);
                String date_added2 = rs2.getString(15);
                String user_name2 = rs2.getString(16);
                String item_type = rs2.getString(17);
                int status2 = rs2.getInt(18);
                String session_no2 = rs2.getString(19);
                String item_discount = rs2.getString(20);
                double discount2 = rs2.getDouble(21);
                double discount_amount2 = rs2.getDouble(22);
                String sales_no2 = rs2.getString(23);
                int fixed_price = rs2.getInt(24);
                String supplier = rs2.getString(25);
                String supplier_id = rs2.getString(26);
                int vatable = rs2.getInt(27);
                String or_no2 = rs2.getString(28);
                String group_id = rs2.getString(29);

                no_trans++;
                if (status2 == 0) {
//                    total_gross_sales += product_qty * selling_price;
                    qty_sold += product_qty;
                    no_not_void_trans++;
                    if (group_id.equalsIgnoreCase("1")) {
                        beverages += product_qty * selling_price;
                    } else {
                        foods += product_qty * selling_price;
                    }
                } else {

                }
            }

            List<Srpt_checks.field> expenses = new ArrayList();
            String s3 = "select "
                    + "id"
                    + ",session_no"
                    + ",user_name"
                    + ",screen_name"
                    + ",time_in"
                    + ",time_out"
                    + ",bank"
                    + ",check_no"
                    + ",check_holder"
                    + ",amount"
                    + ",vault"
                    + " from cash_drawer_expenses where "
                    + " date(time_out) between '" + date_from + "' and '" + date_to + "' "
                    + " ";

            Statement stmt3 = conn.createStatement();
            ResultSet rs3 = stmt3.executeQuery(s3);
            while (rs3.next()) {
                int id = rs3.getInt(1);
                String session_no = rs3.getString(2);
                String user_name = rs3.getString(3);
                String screen_name = rs3.getString(4);
                String time_in = rs3.getString(5);
                String time_out = rs3.getString(6);
                String bank = rs3.getString(7);
                String check_no = rs3.getString(8);
                String check_holder = rs3.getString(9);
                double amount = rs3.getDouble(10);
                int vault = rs3.getInt(11);
                String date_added = DateType.convert_jan_1_2013_datetime2(time_in);
                Srpt_checks.field t = new Srpt_checks.field(bank, check_holder, check_no, amount, date_added);
                if (vault == 0) {
                    grand_expenses += amount;
                    fields.add(t);
                } else {
                    total_disbursements_vault += amount;
                    fields2.add(t);
                }

            }

            total_vat_sales = (total_gross_sales - total_discount) / 1.12;
            total_vat = total_vat_sales * .12;

            total_cash_in_hand = total_cash_payments - grand_expenses;
            Srpt_z_reading rpt = new Srpt_z_reading(SUBREPORT_DIR, business_name, operated_by, address, start_date, date_as_of, generated_by, date_printed, total_days_as_of, total_gross_sales, total_vat_sales, total_non_vat_sales, total_void_sales, total_vat, total_discount, total_sc_discount, total_reg_discount, total_other_discount, no_qty_sold, no_trans, no_not_void_trans, no_void_trans, no_no_discount_trans, no_sc_discount_trans, no_reg_discount_trans, no_other_discount_trans, total_prev_end_sales, total_prev_grand_total_sales, total_current_end_sales, total_current_grand_sales, fields, qty_sold, no_cash_payments, no_check_payments, total_cash_payments, total_check_payments, expenses, grand_sales, grand_checks, grand_expenses, foods, beverages, rpt_cashier_sales, total_void_amount, gift_certificate, grand_expenses, total_cash_in_hand, fields2, total_disbursements_vault);

            return rpt;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
