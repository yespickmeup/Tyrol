/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.voider;

import POS.main.Main;
import POS.sales.S1_sales;
import POS.sales.S1_sales.to_sales;
import POS.sales.S1_sales_items;
import POS.sales.S1_sales_items.to_sales_items;
import POS.touchscreen_printing.Srpt_billing_statement;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.Dlg_confirm;
import POS.util.TextHighlighter1;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;

/**
 *
 * @author Maytopacka
 */
public class Dlg_voider extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_all_sales_report
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
    private Dlg_voider(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_voider(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_voider() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_voider myRef;

    private void setThisRef(Dlg_voider myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_voider> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_voider create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_voider create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_voider dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_voider((java.awt.Frame) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().
                        log(Level.INFO, "instances: {0}", dialogContainer.size());
                dialog.setThisRef(dialog);
                return dialog;
            } else {
                dialog.setModalityType(modalType);
                return dialog;
            }

        }

        if (parent instanceof java.awt.Dialog) {
            Dlg_voider dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_voider((java.awt.Dialog) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().
                        log(Level.INFO, "instances: {0}", dialogContainer.size());
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
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.
                    getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Dlg_voider dialog = Dlg_voider.create(new javax.swing.JFrame(), true);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().
                getWidth());
        int ySize = ((int) tk.getScreenSize().
                getHeight());
        dialog.setSize(xSize, ySize);
        dialog.setVisible(true);

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" added ">
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible == true) {
            getContentPane().
                    removeAll();
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_sales = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_sales_items = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        tf_search = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbl_cert = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dp_from = new com.toedter.calendar.JDateChooser();
        dp_to = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lbl_void_no = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tbl_sales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_sales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_salesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_sales);

        tbl_sales_items.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_sales_items.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_sales_itemsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_sales_items);

        jLabel5.setText("SEARCH OR:");

        tf_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_searchActionPerformed(evt);
            }
        });

        jLabel6.setText("Total Trans:");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("0");

        jLabel9.setText("Sales:");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("0.00");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("0.00");

        jLabel12.setText("Cash:");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("0.00");

        jLabel14.setText("Discount:");

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("0.00");

        jLabel16.setText("Credit Card:");

        jLabel17.setText("Total Qty:");

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("0");

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("0.00");

        jLabel20.setText("Total Amount:");

        jLabel21.setText("Certificate:");

        lbl_cert.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cert.setText("0.00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_search))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_cert, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(jLabel19))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21)
                        .addComponent(lbl_cert))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel8)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10)
                        .addComponent(jLabel12)
                        .addComponent(jLabel11)
                        .addComponent(jLabel14)
                        .addComponent(jLabel13)
                        .addComponent(jLabel16)
                        .addComponent(jLabel15)
                        .addComponent(jLabel17)
                        .addComponent(jLabel18)))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("VOIDER");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("DATE FROM:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("DATE TO:");

        jButton1.setText("SEARCH");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("|");

        lbl_void_no.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("VOID NO:");

        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dp_from, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dp_to, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_void_no, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_void_no, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(dp_to, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dp_from, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        data_cols_or();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tf_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_searchActionPerformed
        // TODO add your handling code here:
        data_cols_or();
    }//GEN-LAST:event_tf_searchActionPerformed

    private void tbl_salesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_salesMouseClicked
        // TODO add your handling code here:
        data_cols();
        delete_transaction();
    }//GEN-LAST:event_tbl_salesMouseClicked

    private void tbl_sales_itemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_sales_itemsMouseClicked
        void_sales();
    }//GEN-LAST:event_tbl_sales_itemsMouseClicked
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dp_from;
    private com.toedter.calendar.JDateChooser dp_to;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_cert;
    private javax.swing.JLabel lbl_void_no;
    private javax.swing.JTable tbl_sales;
    private javax.swing.JTable tbl_sales_items;
    private javax.swing.JTextField tf_search;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        Main.MyDB.setNames("db_fortune_three");
        init_key();
        dp_from.setDate(new Date());
        dp_to.setDate(new Date());
        init_tbl_sales();
        init_tbl_sales_items();
        init_no();
        tf_search.grabFocus();
    }

    private void init_no() {
        lbl_void_no.setText(S1_voids.increment_id());
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
        tf_search.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (!tbl_sales_ALM.isEmpty()) {
                        tbl_sales.setRowSelectionInterval(0, 0);
                        tbl_sales.grabFocus();
                    }
                }
            }
        });
        tbl_sales.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    data_cols();
                    e.consume();
                }
            }
        });
    }
    // </editor-fold>
    private ArrayListModel tbl_sales_ALM;
    private TblsalesModel tbl_sales_M;

    private void init_tbl_sales() {
        tbl_sales_ALM = new ArrayListModel();
        tbl_sales_M = new TblsalesModel(tbl_sales_ALM);
        tbl_sales.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_sales.setModel(tbl_sales_M);
        tbl_sales.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_sales.setRowHeight(25);
        int[] tbl_widths_sales = {100, 80, 80, 80, 80, 80, 80, 60, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_sales.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_sales, i, tbl_widths_sales[i]);
        }
        Dimension d = tbl_sales.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_sales.getTableHeader().
                setPreferredSize(d);
        tbl_sales.getTableHeader().
                setFont(new java.awt.Font("Arial", 0, 11));
        tbl_sales.setRowHeight(35);
        tbl_sales.setFont(new java.awt.Font("Arial", 0, 11));
        TableWidthUtilities.setColumnRightRenderer(tbl_sales, 2);
        TableWidthUtilities.setColumnRightRenderer(tbl_sales, 3);
        TableWidthUtilities.setColumnRightRenderer(tbl_sales, 4);
        TableWidthUtilities.setColumnRightRenderer(tbl_sales, 5);
        TableWidthUtilities.setColumnRightRenderer(tbl_sales, 6);
//        TableWidthUtilities.setColumnRightRenderer(tbl_sales, 7);
    }

    private void loadData_sales(List<to_sales> acc) {
        tbl_sales_ALM.clear();
        tbl_sales_ALM.addAll(acc);

    }

    public static class TblsalesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Transaction #", "Date", "Amount Due", "Cash", "Discount", "Gift Certificate", "Credit Card", "Status", "discount_name", "discount", "discount_amount", "customer_name", "check_bank", "check_no", "check_amount", "discount_customer_name", "discount_customer_id", "status", "or_no", "check_holder", "services", "service_amount"
        };

        public TblsalesModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 1) {
                return true;
            }
            return false;
        }

        @Override
        public Class getColumnClass(int col) {
            if (col == 1000) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            to_sales tt = (to_sales) getRow(row);
            switch (col) {
                case 0:
                    return tt.sales_no;
                case 1:
                    return DateType.convert_slash_datetime2(tt.date_added);
                case 2:
                    return FitIn.fmt_wc_0(tt.amount_due) + " ";
                case 3:
                    return FitIn.fmt_wc_0(tt.amount_due - tt.discount_amount - tt.credit_card_amount-tt.gift_certificate_amount) + " ";
                case 4:
                    return FitIn.fmt_wc_0(tt.discount_amount) + " ";
                case 5:
                    return FitIn.fmt_wc_0(tt.gift_certificate_amount) + " ";
                case 6:

                    return FitIn.fmt_wc_0(tt.credit_card_amount) + " ";
                case 7:
                    if (tt.status == 0) {
                        return TextHighlighter1.highlight("COUNTED", "COUNTED", "BLUE");
                    } else {
                        return TextHighlighter1.highlight2("VOID", "VOID", "RED");
                    }
                case 8:
                    return tt.discount_name;
                case 9:
                    return tt.discount;
                case 10:
                    return tt.discount_amount;
                case 11:
                    return tt.customer_name;
                case 12:
                    return tt.check_bank;
                case 13:
                    return tt.check_no;
                case 14:
                    return tt.check_amount;
                case 15:
                    return tt.discount_customer_name;
                case 16:
                    return tt.discount_customer_id;
                case 17:
                    return tt.status;
                case 18:
                    return tt.or_no;
                case 19:
                    return tt.check_holder;
                case 20:
                    return tt.services;
                default:
                    return tt.service_amount;
            }
        }
    }

    private void data_cols_or() {
        jProgressBar1.setString("Loading...Please wait...");
        jProgressBar1.setIndeterminate(true);
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                String date_from = DateType.sf.format(dp_from.getDate());
                String date_to = DateType.sf.format(dp_to.getDate());
                String where = "";
                where = " where Date(date_added) between '" + date_from + "' and '" + date_to + "'";
                where = where + " or sales_no like '" + tf_search.getText() + "'";
                where = where + " order by date_added asc";
                List<to_sales> datas = S1_sales.ret_data(where);
                loadData_sales(datas);
                double amount_due = 0;
                double cash = 0;
                double discount = 0;
                double credit_card = 0;
                double certificate=0;
                for (to_sales to : datas) {
                    if (to.status == 0) {
                        amount_due += to.amount_due;
                        cash += to.amount_due - to.discount_amount - to.credit_card_amount-to.gift_certificate_amount;
                        credit_card += to.credit_card_amount;
                        discount += to.discount_amount;
                        certificate+=to.gift_certificate_amount;
                    }

                }

                jLabel8.setText("" + datas.size());
                jLabel10.setText(FitIn.fmt_wc_0(amount_due));
                jLabel11.setText(FitIn.fmt_wc_0(cash));
                jLabel13.setText(FitIn.fmt_wc_0(discount));
                jLabel15.setText(FitIn.fmt_wc_0(credit_card));
                lbl_cert.setText(FitIn.fmt_wc_0(certificate));
                jProgressBar1.setString("Finished...");
                jProgressBar1.setIndeterminate(false);
            }
        });
        t.start();

    }

    private void data_cols_date() {
        String date_from = DateType.sf.format(dp_from.getDate());
        String date_to = DateType.sf.format(dp_to.getDate());
        String search = tf_search.getText();
        loadData_sales(S1_sales.ret_data_or(date_from, date_to, search));
    }
    private ArrayListModel tbl_sales_items_ALM;
    private Tblsales_itemsModel tbl_sales_items_M;

    private void init_tbl_sales_items() {
        tbl_sales_items_ALM = new ArrayListModel();
        tbl_sales_items_M = new Tblsales_itemsModel(tbl_sales_items_ALM);
        tbl_sales_items.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_sales_items.setModel(tbl_sales_items_M);
        tbl_sales_items.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_sales_items.setRowHeight(25);
        int[] tbl_widths_sales_items = {50, 70, 100, 0, 0, 60, 80, 80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_sales_items.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_sales_items, i, tbl_widths_sales_items[i]);
        }
        Dimension d = tbl_sales_items.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_sales_items.getTableHeader().
                setPreferredSize(d);
        tbl_sales_items.getTableHeader().
                setFont(new java.awt.Font("Arial", 0, 11));
        tbl_sales_items.setRowHeight(35);
        tbl_sales_items.setFont(new java.awt.Font("Arial", 0, 11));
        TableWidthUtilities.setColumnRightRenderer(tbl_sales_items, 6);
        TableWidthUtilities.setColumnRightRenderer(tbl_sales_items, 5);
        TableWidthUtilities.setColumnRightRenderer(tbl_sales_items, 4);
    }

    private void loadData_sales_items(List<to_sales_items> acc) {
        tbl_sales_items_ALM.clear();
        tbl_sales_items_ALM.addAll(acc);
    }

    public static class Tblsales_itemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Barcode", "Description", "Unit", "Discount", "Price", "Total", "Status", "sub_classification", "sub_classification_id", "product_qty", "unit", "conversion", "selling_price", "date_added", "user_name", "item_type", "status", "session_no", "item_discount", "discount", "discount_amount", "sales_no", "fixed_price", "supplier", "supplier_id", "vatable", "or_no"
        };

        public Tblsales_itemsModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 1) {
                return true;
            }
            return false;
        }

        @Override
        public Class getColumnClass(int col) {
            if (col == 1000) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            to_sales_items tt = (to_sales_items) getRow(row);
            switch (col) {
                case 0:
                    return "  " + FitIn.fmt_woc(tt.product_qty);
                case 1:
                    return tt.barcode;
                case 2:
                    return tt.description;
                case 3:
                    return tt.unit;
                case 4:
                    return FitIn.fmt_wc_0(tt.discount_amount) + "  ";
                case 5:
                    return FitIn.fmt_wc_0(tt.selling_price) + "  ";
                case 6:
                    return FitIn.fmt_wc_0(tt.product_qty * tt.selling_price) + "  ";
                case 7:
                    if (tt.status == 0) {
                        return "      ---";
                    } else {
                        return "Cancelled";
                    }

                case 8:
                    return tt.sub_classification;
                case 9:
                    return tt.sub_classification_id;
                case 10:
                    return tt.product_qty;
                case 11:
                    return tt.unit;
                case 12:
                    return tt.conversion;
                case 13:
                    return tt.selling_price;
                case 14:
                    return tt.date_added;
                case 15:
                    return tt.user_name;
                case 16:
                    return tt.item_type;
                case 17:
                    return tt.status;
                case 18:
                    return tt.session_no;
                case 19:
                    return tt.item_discount;
                case 20:
                    return tt.discount;
                case 21:
                    return tt.discount_amount;
                case 22:
                    return tt.sales_no;
                case 23:
                    return tt.fixed_price;
                case 24:
                    return tt.supplier;
                case 25:
                    return tt.supplier_id;
                case 26:
                    return tt.vatable;
                default:
                    return tt.or_no;
            }
        }
    }

    private void data_cols() {
        int row = tbl_sales.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_sales to = (to_sales) tbl_sales_ALM.get(tbl_sales.
                convertRowIndexToModel(row));
        List<to_sales_items> datas = S1_sales_items.ret_data(to.sales_no);
        loadData_sales_items(datas);
        int qty = 0;
        double total_amount = 0;

        for (to_sales_items to1 : datas) {
            qty += to1.product_qty;
            total_amount += to1.product_qty * to1.selling_price;
        }
        jLabel18.setText(FitIn.fmt_woc(qty));
        jLabel19.setText(FitIn.fmt_wc_0(total_amount));
    }

    private void void_sales() {

        int row2 = tbl_sales_items.getSelectedRow();
        if (row2 < 0) {
            return;
        }
        to_sales_items to = (to_sales_items) tbl_sales_items_ALM.get(tbl_sales_items.convertRowIndexToModel(row2));

        int row3 = tbl_sales.getSelectedRow();
        if (row3 < 0) {
            return;
        }
        to_sales to3 = (to_sales) tbl_sales_ALM.get(tbl_sales.
                convertRowIndexToModel(row3));

        int id = to.id;
        String barcode = to.barcode;
        String description = to.description;
        String generic_name = to.generic_name;
        String category = to.category;
        String category_id = to.category_id;
        String classification = to.classification;
        String classification_id = to.classification_id;
        String sub_classification = to.sub_classification;
        String sub_classification_id = to.sub_classification_id;
        double product_qty = to.product_qty;
        String unit = to.unit;
        double conversion = to.conversion;
        double selling_price = to.selling_price;
        String date_added = to.date_added;
        String user_name = to.user_name;
        String item_type = to.item_type;
        int status = to.status;
        String session_no = to.session_no;
        String item_discount = to.item_discount;
        double discount = to.discount;
        double discount_amount = to.discount_amount;
        String void_no = lbl_void_no.getText();
        int fixed_price = to.fixed_price;
        String supplier = to.supplier;
        String supplier_id = to.supplier_id;
        int vatable = to.vatable;
        String or_no = to.or_no;

        S1_void_items.to_void_items to2 = new S1_void_items.to_void_items(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, session_no, item_discount, discount, discount_amount, void_no, fixed_price, supplier, supplier_id, vatable, or_no);

    }

    private void delete_transaction() {
        final int row = tbl_sales.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_sales to = (to_sales) tbl_sales_ALM.get(tbl_sales.convertRowIndexToModel(row));

        Window p = (Window) this;
        Dlg_confirm nd = Dlg_confirm.create(p, true);
        nd.setTitle("");

        nd.setCallback(new Dlg_confirm.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm.OutputData data) {
                closeDialog.ok();
                Thread t = new Thread(new Runnable() {

                    @Override
                    public void run() {

                        to_sales to = (to_sales) tbl_sales_ALM.get(tbl_sales.
                                convertRowIndexToModel(row));
                        if (to.status == 0) {
                            S1_voids.delete_receipts(to.sales_no);
                            data_cols_or();
                            tbl_sales_items_ALM.clear();
                            tbl_sales_items_M.fireTableDataChanged();
                            Alert.set(3, "");
                        } else {
                            S1_voids.edit_sales(to.sales_no);
                            data_cols_or();
                            tbl_sales_items_ALM.clear();
                            tbl_sales_items_M.fireTableDataChanged();
                            Alert.set(2, "");
                        }

                    }
                });
                t.start();
            }

            @Override
            public void print(CloseDialog closeDialog, Dlg_confirm.OutputData data) {
                closeDialog.ok();
                jProgressBar1.setString("Printing Bill...");
                jProgressBar1.setIndeterminate(true);
                setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        List<to_sales_items> datas = tbl_sales_items_ALM;
                        List<Srpt_billing_statement.field> fields = new ArrayList();

                        printing(to);
//                        String business_name = System.getProperty("business_name", "Tyron Restaurant");
//                        String address = System.getProperty("address", "Lacson Stree, Bacolod City");
//                        String telephone_no = "";
//                        String table_name = to.table_name;
//                        String transaction_no = "";
//                        String waiter = to.waiter_name;
//                        String date = DateType.day_and_time.format(new Date());
//                        Srpt_billing_statement rpt = new Srpt_billing_statement(business_name, address, telephone_no, table_name, transaction_no, waiter, date, to.discount_amount, to.amount_due - to.discount_amount);
//                        rpt.fields.addAll(fields);
//                        String jrxml = "rpt_billing_statement.jrxml";
//
//                        try {
//                            InputStream is = Srpt_billing_statement.class
//                                    .getResourceAsStream(jrxml);
//                            JasperReport jasperReport = JasperCompileManager.compileReport(is);
//                            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, JasperUtil.
//                                    setParameter(rpt), JasperUtil.makeDatasource(rpt.fields));
//
//                            JasperPrintManager.printReport(jasperPrint,
//                                                           false);
//                        } catch (JRException ex) {
//                            Logger.getLogger(Dlg_touchscreen.class
//                                    .getName()).
//                                    log(Level.SEVERE, null, ex);
//                        }
//                        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
//                        jProgressBar1.setString("Finished...");
//                        jProgressBar1.setIndeterminate(false);
                    }
                });
                t.start();

            }

        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void printing(to_sales to) {
        List<to_sales_items> datas = tbl_sales_items_ALM;
        Window p = (Window) this;
        Dlg_bill nd = Dlg_bill.create(p, true);
        nd.setTitle("");
//        nd.do_pass(services);
        nd.do_pass(to, datas);
        nd.setCallback(new Dlg_bill.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_bill.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }
}
