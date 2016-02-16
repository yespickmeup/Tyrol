/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen;

import POS.touchscreen_printing.Srpt_touchscreen_sales_by_item;
import static POS.touchscreen_printing.Srpt_touchscreen_sales_by_item.ret_data;
import POS.touchscreen_printing.Srpt_touchscreen_sales_transaction;
import POS.util.DateType;
import POS.util.Users;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.JasperUtil;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Ronald
 */
public class Dlg_touchscreen_report extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_touchscreen_report
     */
    //<editor-fold defaultstate="collapsed" desc=" callback ">
    private Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;

    }

    public static interface Callback {

        void ok(CloseDialog closeDialog, OutputData data);
    }

    public static class InputData {
    }

    public static class OutputData {
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_touchscreen_report(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_touchscreen_report(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_touchscreen_report() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_touchscreen_report myRef;

    private void setThisRef(Dlg_touchscreen_report myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_touchscreen_report> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_touchscreen_report create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_touchscreen_report create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_touchscreen_report dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_report((java.awt.Frame) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().log(Level.INFO, "instances: {0}", dialogContainer.size());
                dialog.setThisRef(dialog);
                return dialog;
            } else {
                dialog.setModalityType(modalType);
                return dialog;
            }

        }

        if (parent instanceof java.awt.Dialog) {
            Dlg_touchscreen_report dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_report((java.awt.Dialog) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().log(Level.INFO, "instances: {0}", dialogContainer.size());
                dialog.setThisRef(dialog);
                return dialog;
            } else {
                dialog.setModalityType(modalType);
                return dialog;
            }

        }

        return null;

    }
    //</editor-fold>    

    //<editor-fold defaultstate="collapsed" desc=" main ">
    public static void main(String args[]) {

        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Dlg_touchscreen_report dialog = Dlg_touchscreen_report.create(new javax.swing.JFrame(), true);
        dialog.setVisible(true);

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" added ">
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible == true) {
            getContentPane().removeAll();
            initComponents();
            myInit();
            repaint();
        }

    }

    public javax.swing.JPanel getSurface() {
        return (javax.swing.JPanel) getContentPane();
    }

    public void nullify() {
        myRef.setVisible(false);
        myRef = null;
    }
    //</editor-fold>

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jXLabel82 = new org.jdesktop.swingx.JXLabel();
        jXLabel83 = new org.jdesktop.swingx.JXLabel();
        jXLabel84 = new org.jdesktop.swingx.JXLabel();
        jXLabel85 = new org.jdesktop.swingx.JXLabel();
        jXLabel86 = new org.jdesktop.swingx.JXLabel();
        jPanel3 = new javax.swing.JPanel();
        pnl_report = new javax.swing.JPanel();
        pnl_sales_items = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(9, 79, 149));

        jXLabel82.setBackground(new java.awt.Color(157, 122, 67));
        jXLabel82.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel82.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXLabel82.setText("  Sales Transaction");
        jXLabel82.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jXLabel82.setOpaque(true);
        jXLabel82.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel82MouseClicked(evt);
            }
        });

        jXLabel83.setBackground(new java.awt.Color(157, 122, 67));
        jXLabel83.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel83.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXLabel83.setText("  Sales Items");
        jXLabel83.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jXLabel83.setOpaque(true);
        jXLabel83.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel83MouseClicked(evt);
            }
        });

        jXLabel84.setBackground(new java.awt.Color(157, 122, 67));
        jXLabel84.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel84.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons/printer-32.png"))); // NOI18N
        jXLabel84.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jXLabel84.setOpaque(true);
        jXLabel84.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel84MouseClicked(evt);
            }
        });

        jXLabel85.setBackground(new java.awt.Color(157, 122, 67));
        jXLabel85.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons/printer-32.png"))); // NOI18N
        jXLabel85.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jXLabel85.setOpaque(true);
        jXLabel85.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel85MouseClicked(evt);
            }
        });

        jXLabel86.setBackground(new java.awt.Color(157, 122, 67));
        jXLabel86.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel86.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel86.setText("X");
        jXLabel86.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jXLabel86.setOpaque(true);
        jXLabel86.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel86MouseClicked(evt);
            }
        });

        jPanel3.setLayout(new java.awt.CardLayout());

        pnl_report.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_reportLayout = new javax.swing.GroupLayout(pnl_report);
        pnl_report.setLayout(pnl_reportLayout);
        pnl_reportLayout.setHorizontalGroup(
            pnl_reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 929, Short.MAX_VALUE)
        );
        pnl_reportLayout.setVerticalGroup(
            pnl_reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 503, Short.MAX_VALUE)
        );

        jPanel3.add(pnl_report, "card2");

        javax.swing.GroupLayout pnl_sales_itemsLayout = new javax.swing.GroupLayout(pnl_sales_items);
        pnl_sales_items.setLayout(pnl_sales_itemsLayout);
        pnl_sales_itemsLayout.setHorizontalGroup(
            pnl_sales_itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 929, Short.MAX_VALUE)
        );
        pnl_sales_itemsLayout.setVerticalGroup(
            pnl_sales_itemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 503, Short.MAX_VALUE)
        );

        jPanel3.add(pnl_sales_items, "card3");

        jPanel2.setBackground(new java.awt.Color(157, 122, 67));

        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("State");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jXLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jXLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jXLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jXLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jXLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jXLabel86, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jXLabel82MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel82MouseClicked
        sales_transaction();
        cardLayout.show(jPanel3, "1");

    }//GEN-LAST:event_jXLabel82MouseClicked

    private void jXLabel83MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel83MouseClicked
        sales_items();
        cardLayout.show(jPanel3, "2");

    }//GEN-LAST:event_jXLabel83MouseClicked

    private void jXLabel84MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel84MouseClicked
        if (jasperPrint2 != null) {
            try {
                JasperPrintManager.printPage(jasperPrint2, 0, false);
            } catch (JRException ex) {
                Logger.getLogger(Dlg_touchscreen_report.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jXLabel84MouseClicked

    private void jXLabel85MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel85MouseClicked
        if (jasperPrint != null) {
            try {
                JasperPrintManager.printPage(jasperPrint, 0, false);
            } catch (JRException ex) {
                Logger.getLogger(Dlg_touchscreen_report.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_jXLabel85MouseClicked

    private void jXLabel86MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel86MouseClicked
        disposed();
    }//GEN-LAST:event_jXLabel86MouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JProgressBar jProgressBar1;
    private org.jdesktop.swingx.JXLabel jXLabel82;
    private org.jdesktop.swingx.JXLabel jXLabel83;
    private org.jdesktop.swingx.JXLabel jXLabel84;
    private org.jdesktop.swingx.JXLabel jXLabel85;
    private org.jdesktop.swingx.JXLabel jXLabel86;
    private javax.swing.JPanel pnl_report;
    private javax.swing.JPanel pnl_sales_items;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
        init_key();
        set_card_items();

    }

    public void do_pass() {

    }

    // <editor-fold defaultstate="collapsed" desc="Key">
    private void disposed() {
        this.dispose();
    }

    private void init_key() {
        KeyMapping.mapKeyWIFW(getSurface(),
                              KeyEvent.VK_ESCAPE, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                btn_0.doClick();
                disposed();
            }
        });
    }
    // </editor-fold>

    CardLayout cardLayout = new CardLayout();

    private void set_card_items() {
        cardLayout = (CardLayout) jPanel3.getLayout();
        cardLayout.addLayoutComponent("1", pnl_report);
        cardLayout.addLayoutComponent("2", pnl_sales_items);

    }

    private void sales_transaction() {
        jProgressBar1.setString("Loading...Please wait...");
        jProgressBar1.setIndeterminate(true);
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {

                String date = DateType.sf.format(new Date());
                String where = "where user_name='" + Users.user_name + "' and date(date_added)='" + date + "'";
                if (Users.user_level == 0) {
                    where = "where date(date_added)='" + date + "'";
                }
                List<Srpt_touchscreen_sales_transaction.field> fields = Srpt_touchscreen_sales_transaction.ret_data(where);
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
                report_sales_items(rpt, jrxml);

                try {
                    JasperReport jasperReport;

                    InputStream is = Srpt_touchscreen_sales_transaction.class.getResourceAsStream(jrxml);
                    jasperReport = JasperCompileManager.compileReport(is);
                    jasperPrint = JasperFillManager.fillReport(jasperReport, JasperUtil.setParameter(rpt), JasperUtil.makeDatasource(rpt.fields));

                } catch (JRException e) {

                    throw new RuntimeException(e);
                }
                jProgressBar1.setString("Finished...");
                jProgressBar1.setIndeterminate(false);
            }
        });
        t.start();

    }
    JasperPrint jasperPrint;

    private void report_sales_items(final Srpt_touchscreen_sales_transaction to, String jrxml_name) {
        pnl_report.removeAll();
        pnl_report.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_all_sales(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            pnl_report.add(viewer);
            pnl_report.updateUI();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_all_sales(Srpt_touchscreen_sales_transaction to, String rpt_name) {
        try {
            return JasperUtil.getJasperViewer(
                    compileJasper(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.makeDatasource(to.fields));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JasperReport compileJasper(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_touchscreen_sales_transaction.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    private void sales_items() {
        jProgressBar1.setString("Loading...Please wait...");
        jProgressBar1.setIndeterminate(true);
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                String date = DateType.sf.format(new Date());
                String where = "where date(date_added)='" + date + "' group by barcode order by category,description asc";
                if (Users.user_level != 0) {
                    where = "where date(date_added)='" + date + "' and user_name ='" + Users.user_name + "' group by barcode order by category,description asc";
                }

                List<Srpt_touchscreen_sales_by_item.field> fields = ret_data(where);

                String business_name = System.getProperty("business_name", "Fortune Tree Enterprises");
                String business_owner = System.getProperty("operated_by", "Ernesto C.QUiamco");
                String business_address = System.getProperty("address", "Door 2, H & J Ong bldg, Corner Colon & Sta Catalina Street Dumaguete City");
                String date_printed = DateType.day_and_time.format(new Date());
                String sales_date = "Sales Date: [" + DateType.slash.format(new Date()) + "]";
                String printed_by = Users.screen_name.toUpperCase();
                String SUBREPORT_DIR = System.getProperty("user.home");
                Srpt_touchscreen_sales_by_item rpt = new Srpt_touchscreen_sales_by_item(business_name, business_owner, business_address, date_printed, sales_date, printed_by, SUBREPORT_DIR);
                rpt.fields.addAll(fields);
                String jrxml = "rpt_sales_by_item.jrxml";
                report_sales_items2(rpt, jrxml);
                try {
                    JasperReport jasperReport;

                    InputStream is = Srpt_touchscreen_sales_by_item.class.getResourceAsStream(jrxml);
                    jasperReport = JasperCompileManager.compileReport(is);
                    jasperPrint2 = JasperFillManager.fillReport(jasperReport, JasperUtil.setParameter(rpt), JasperUtil.makeDatasource(rpt.fields));

                } catch (JRException e) {

                    throw new RuntimeException(e);
                }
                jProgressBar1.setString("Finished...");
                jProgressBar1.setIndeterminate(false);
            }
        });
        t.start();

    }
    JasperPrint jasperPrint2;

    private void report_sales_items2(final Srpt_touchscreen_sales_by_item to, String jrxml_name) {
        pnl_sales_items.removeAll();
        pnl_sales_items.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_all_sales2(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            pnl_sales_items.add(viewer);
            pnl_sales_items.updateUI();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_all_sales2(Srpt_touchscreen_sales_by_item to, String rpt_name) {
        try {
            return JasperUtil.getJasperViewer(
                    compileJasper(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.makeDatasource(to.fields));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JasperReport compileJasper2(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_touchscreen_sales_by_item.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
}
