/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen;

import POS.discount_customers.S1_discount_customers;
import POS.discount_customers.S1_discount_customers.to_discount_customers;
import POS.util.Focus_Fire;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;

/**
 *
 * @author Ronald
 */
public class Dlg_touchscreen_customer_discounting extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_touchscreen_customer_discounting
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

        public final String customer_id;
        public final String customer_name;

        public OutputData(String customer_id, String customer_name) {
            this.customer_id = customer_id;
            this.customer_name = customer_name;
        }

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_touchscreen_customer_discounting(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_touchscreen_customer_discounting(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_touchscreen_customer_discounting() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_touchscreen_customer_discounting myRef;

    private void setThisRef(Dlg_touchscreen_customer_discounting myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_touchscreen_customer_discounting> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_touchscreen_customer_discounting create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_touchscreen_customer_discounting create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_touchscreen_customer_discounting dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_customer_discounting((java.awt.Frame) parent, false);
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
            Dlg_touchscreen_customer_discounting dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_customer_discounting((java.awt.Dialog) parent, false);
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

        Dlg_touchscreen_customer_discounting dialog = Dlg_touchscreen_customer_discounting.create(new javax.swing.JFrame(), true);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_discount_customers = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_discount_customers2 = new javax.swing.JTable();
        jXLabel33 = new org.jdesktop.swingx.JXLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(193, 119, 4));

        tbl_discount_customers.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_discount_customers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_discount_customersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_discount_customers);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Id No:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name:");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Search:");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        tbl_discount_customers2.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_discount_customers2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_discount_customers2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_discount_customers2);

        jXLabel33.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel33.setText("Ok");
        jXLabel33.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jXLabel33.setOpaque(true);
        jXLabel33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel33MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3))
                    .addComponent(jSeparator1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jXLabel33, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jXLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)))
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

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        data_cols();
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void tbl_discount_customers2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_discount_customers2MouseClicked
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_tbl_discount_customers2MouseClicked

    private void tbl_discount_customersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_discount_customersMouseClicked
        // TODO add your handling code here:
        add();
    }//GEN-LAST:event_tbl_discount_customersMouseClicked

    private void jXLabel33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel33MouseClicked
        ok();
    }//GEN-LAST:event_jXLabel33MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
        add_customer();
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
        jTextField2.grabFocus();
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private org.jdesktop.swingx.JXLabel jXLabel33;
    private javax.swing.JTable tbl_discount_customers;
    private javax.swing.JTable tbl_discount_customers2;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
        init_key();
        init_tbl_discount_customers();
        data_cols();
        focus();
        jTextField3.grabFocus();
        init_tbl_discount_customers2();
    }

    private void focus() {
        JTextField[] tf = {jTextField3, jTextField1, jTextField2};
        Focus_Fire.onFocus_lostFocus(tf);
        Focus_Fire.select_all(tf);
    }

    public void do_pass(String customer_id, String customer_name) {
        String[] ids = customer_id.split("/");
        String[] nos = customer_name.split("/");
        for (int i = 0; i < ids.length; i++) {
            to_discount_customers to = new to_discount_customers(-1, ids[i], nos[i]);
            if (!to.customer_name.isEmpty()) {
                tbl_discount_customers_ALM2.add(to);
            }

        }

        tbl_discount_customers_M2.fireTableDataChanged();
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

    private ArrayListModel tbl_discount_customers_ALM;
    private Tbldiscount_customersModel tbl_discount_customers_M;

    private void init_tbl_discount_customers() {
        tbl_discount_customers_ALM = new ArrayListModel();
        tbl_discount_customers_M = new Tbldiscount_customersModel(tbl_discount_customers_ALM);
        tbl_discount_customers.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_discount_customers.setModel(tbl_discount_customers_M);
        tbl_discount_customers.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_discount_customers.setRowHeight(25);
        int[] tbl_widths_discount_customers = {100, 100, 0};
        for (int i = 0, n = tbl_widths_discount_customers.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_discount_customers, i, tbl_widths_discount_customers[i]);
        }
        Dimension d = tbl_discount_customers.getTableHeader().getPreferredSize();
        d.height = 30;
        tbl_discount_customers.getTableHeader().setPreferredSize(d);
        tbl_discount_customers.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_discount_customers.setRowHeight(40);
        tbl_discount_customers.setFont(new java.awt.Font("Arial", 0, 12));
    }

    private void loadData_discount_customers(List<to_discount_customers> acc) {
        tbl_discount_customers_ALM.clear();
        tbl_discount_customers_ALM.addAll(acc);
    }

    public static class Tbldiscount_customersModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "ID No", "Name", "id_no"
        };

        public Tbldiscount_customersModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
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
            to_discount_customers tt = (to_discount_customers) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.id_no;
                case 1:
                    return " " + tt.customer_name;
                default:
                    return tt.id_no;
            }
        }
    }

    private void data_cols() {
        String where = " where customer_name like '%" + jTextField3.getText() + "%' or id_no like '%" + jTextField3.getText() + "%' order by customer_name asc";
        loadData_discount_customers(S1_discount_customers.ret_data2(where));
    }

    private ArrayListModel tbl_discount_customers_ALM2;
    private Tbldiscount_customersModel2 tbl_discount_customers_M2;

    private void init_tbl_discount_customers2() {
        tbl_discount_customers_ALM2 = new ArrayListModel();
        tbl_discount_customers_M2 = new Tbldiscount_customersModel2(tbl_discount_customers_ALM2);
        tbl_discount_customers2.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_discount_customers2.setModel(tbl_discount_customers_M2);
        tbl_discount_customers2.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_discount_customers2.setRowHeight(25);
        int[] tbl_widths_discount_customers = {100, 100, 0};
        for (int i = 0, n = tbl_widths_discount_customers.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_discount_customers2, i, tbl_widths_discount_customers[i]);
        }
        Dimension d = tbl_discount_customers2.getTableHeader().getPreferredSize();
        d.height = 30;
        tbl_discount_customers2.getTableHeader().setPreferredSize(d);
        tbl_discount_customers2.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_discount_customers2.setRowHeight(40);
        tbl_discount_customers2.setFont(new java.awt.Font("Arial", 0, 12));
    }

    private void loadData_discount_customers2(List<to_discount_customers> acc) {
        tbl_discount_customers_ALM2.clear();
        tbl_discount_customers_ALM2.addAll(acc);
    }

    public static class Tbldiscount_customersModel2 extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "ID No", "Name", "id_no"
        };

        public Tbldiscount_customersModel2(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
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
            to_discount_customers tt = (to_discount_customers) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.id_no;
                case 1:
                    return " " + tt.customer_name;
                default:
                    return tt.id_no;
            }
        }
    }

    private void add() {
        int row = tbl_discount_customers.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_discount_customers to = (to_discount_customers) tbl_discount_customers_ALM.get(tbl_discount_customers.convertRowIndexToModel(row));
        tbl_discount_customers_ALM2.add(to);
        tbl_discount_customers_M2.fireTableDataChanged();
    }

    private void delete() {
        int row = tbl_discount_customers2.getSelectedRow();
        if (row < 0) {
            return;
        }
        tbl_discount_customers_ALM2.remove(row);
        tbl_discount_customers_M2.fireTableDataChanged();
    }

    private void ok() {

        String customer_id = "";
        String customer_name = "";
        List<to_discount_customers> datas = tbl_discount_customers_ALM2;
        for (to_discount_customers to : datas) {
            customer_id = customer_id + "/" + to.id_no;
            customer_name = customer_name + "/" + to.customer_name;
        }
        if (!customer_id.isEmpty()) {
            customer_id = customer_id.substring(1, customer_id.length());
            customer_name = customer_name.substring(1, customer_name.length());
        }

        System.out.println(customer_id + " : " + customer_name);
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(customer_id, customer_name));
        }
    }

    private void add_customer() {
        S1_discount_customers.to_discount_customers t = new S1_discount_customers.to_discount_customers(0
                , jTextField2.getText(), jTextField1.getText());
        S1_discount_customers.add_discount_customers(t);
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.grabFocus();
    }
}
