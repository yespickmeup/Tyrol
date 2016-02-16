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
public class Srpt_printing_assembly {

    public final List<Srpt_printing_assembly.field> fields;

    public Srpt_printing_assembly() {
        this.fields = new ArrayList();
    }

    public static class field {

        String printing_assembly;
        String description;
        double qty;
        String waiter_name;
        String table_name;

        public field() {
        }

        public field(String printing_assembly, String description, double qty, String waiter_name, String table_name) {
            this.printing_assembly = printing_assembly;
            this.description = description;
            this.qty = qty;
            this.waiter_name = waiter_name;
            this.table_name = table_name;
        }

        public String getTable_name() {
            return table_name;
        }

        public void setTable_name(String table_name) {
            this.table_name = table_name;
        }

        public String getPrinting_assembly() {
            return printing_assembly;
        }

        public void setPrinting_assembly(String printing_assembly) {
            this.printing_assembly = printing_assembly;
        }

        public String getWaiter_name() {
            return waiter_name;
        }

        public void setWaiter_name(String waiter_name) {
            this.waiter_name = waiter_name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
        }
    }

    public static void main(String[] args) {

        List<Srpt_printing_assembly.field> fields = new ArrayList();
        for (int i = 0; i < 20; i++) {
            String printing_assembly = "Kitchen";
            String description = "desc";
            double qty = 1;
            Srpt_printing_assembly.field to = new field(printing_assembly, description, qty, "asdasd","table1");
            fields.add(to);
        }

        Srpt_printing_assembly rpt = new Srpt_printing_assembly();
        rpt.fields.addAll(fields);
        String jrxml = "rpt_printing_assembly.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_printing_assembly.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_printing_assembly to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }
}
