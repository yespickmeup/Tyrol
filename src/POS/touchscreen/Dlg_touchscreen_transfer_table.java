/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen;

import POS.table_customers.S1_table_customers;
import POS.tables.S1_tables;
import POS.util.Alert;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JScrollBar;
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
public class Dlg_touchscreen_transfer_table extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_touchscreen_transfer_table
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

        public final S1_tables.to_tables new_table_location;

        public OutputData(S1_tables.to_tables new_table_location) {
            this.new_table_location = new_table_location;
        }

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_touchscreen_transfer_table(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_touchscreen_transfer_table(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_touchscreen_transfer_table() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_touchscreen_transfer_table myRef;

    private void setThisRef(Dlg_touchscreen_transfer_table myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_touchscreen_transfer_table> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_touchscreen_transfer_table create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_touchscreen_transfer_table create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_touchscreen_transfer_table dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_transfer_table((java.awt.Frame) parent, false);
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
            Dlg_touchscreen_transfer_table dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_transfer_table((java.awt.Dialog) parent, false);
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

        Dlg_touchscreen_transfer_table dialog = Dlg_touchscreen_transfer_table.create(new javax.swing.JFrame(), true);
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
        jLabel24 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_tables = new javax.swing.JTable();
        jXLabel63 = new org.jdesktop.swingx.JXLabel();
        jXLabel14 = new org.jdesktop.swingx.JXLabel();
        jXLabel13 = new org.jdesktop.swingx.JXLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_table_customers = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        jXLabel15 = new org.jdesktop.swingx.JXLabel();
        jXLabel16 = new org.jdesktop.swingx.JXLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(9, 79, 149));

        jLabel24.setBackground(new java.awt.Color(154, 123, 72));
        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("  Status  ");
        jLabel24.setOpaque(true);

        jLabel34.setBackground(new java.awt.Color(154, 123, 72));
        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel34.setText("  Waiter");
        jLabel34.setOpaque(true);

        jLabel22.setBackground(new java.awt.Color(154, 123, 72));
        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("  Table");
        jLabel22.setOpaque(true);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tbl_tables.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbl_tables.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_tables.setGridColor(new java.awt.Color(204, 204, 204));
        tbl_tables.setSelectionBackground(new java.awt.Color(226, 221, 181));
        tbl_tables.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tbl_tables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_tablesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_tables);

        jXLabel63.setBackground(new java.awt.Color(154, 123, 72));
        jXLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel63.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXLabel63.setText("  Ronald Pascua/Deneice/Cedric from Table 1");
        jXLabel63.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jXLabel63.setOpaque(true);
        jXLabel63.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel63MouseClicked(evt);
            }
        });

        jXLabel14.setBackground(new java.awt.Color(154, 123, 72));
        jXLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons/arrow_left_16.png"))); // NOI18N
        jXLabel14.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jXLabel14.setOpaque(true);
        jXLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel14MouseClicked(evt);
            }
        });

        jXLabel13.setBackground(new java.awt.Color(154, 123, 72));
        jXLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons/arrow_right_16.png"))); // NOI18N
        jXLabel13.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jXLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jXLabel13.setOpaque(true);
        jXLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel13MouseClicked(evt);
            }
        });

        tbl_table_customers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbl_table_customers);

        jLabel25.setBackground(new java.awt.Color(154, 123, 72));
        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Guest/s");
        jLabel25.setOpaque(true);

        jXLabel15.setBackground(new java.awt.Color(154, 123, 72));
        jXLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel15.setText("Transfer");
        jXLabel15.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jXLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jXLabel15.setOpaque(true);
        jXLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel15MouseClicked(evt);
            }
        });

        jXLabel16.setBackground(new java.awt.Color(154, 123, 72));
        jXLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel16.setText("Close");
        jXLabel16.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jXLabel16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jXLabel16.setOpaque(true);
        jXLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel16MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jXLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jXLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jXLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jXLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void tbl_tablesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_tablesMouseClicked
        data_cols_table_customers();

    }//GEN-LAST:event_tbl_tablesMouseClicked

    private void jXLabel63MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel63MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel63MouseClicked

    private void jXLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel14MouseClicked
        int height = tbl_tables.getRowHeight() * (7 - 1);
        JScrollBar bar = jScrollPane1.getVerticalScrollBar();
        bar.setValue(bar.getValue() - height);
    }//GEN-LAST:event_jXLabel14MouseClicked

    private void jXLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel13MouseClicked
        int height = tbl_tables.getRowHeight() * (7 - 1);
        JScrollBar bar = jScrollPane1.getVerticalScrollBar();
        bar.setValue(bar.getValue() + height);
    }//GEN-LAST:event_jXLabel13MouseClicked

    private void jXLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel15MouseClicked
        ok();
    }//GEN-LAST:event_jXLabel15MouseClicked

    private void jXLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel16MouseClicked
      disposed();
    }//GEN-LAST:event_jXLabel16MouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXLabel jXLabel13;
    private org.jdesktop.swingx.JXLabel jXLabel14;
    private org.jdesktop.swingx.JXLabel jXLabel15;
    private org.jdesktop.swingx.JXLabel jXLabel16;
    private org.jdesktop.swingx.JXLabel jXLabel63;
    private javax.swing.JTable tbl_table_customers;
    private javax.swing.JTable tbl_tables;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
        init_key();
        init_tbl_tables();
        data_cols_tables();
        init_tbl_table_customers();
    }

    String ids = "";
    String customers = "";

    public void do_pass(String id, String customer) {
        ids = id;
        customers = customer;
        jXLabel63.setText("  " + customers);
        data_cols_tables();
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

    private ArrayListModel tbl_tables_ALM;
    private TbltablesModel tbl_tables_M;

    private void init_tbl_tables() {
        tbl_tables_ALM = new ArrayListModel();
        tbl_tables_M = new TbltablesModel(tbl_tables_ALM);
        tbl_tables.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_tables.setModel(tbl_tables_M);
        tbl_tables.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbl_tables.setRowHeight(25);

        int[] tbl_widths_tables = {jLabel22.getWidth(), jLabel34.getWidth(), jLabel24.getWidth(), 0};
        for (int i = 0, n = tbl_widths_tables.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_tables, i, tbl_widths_tables[i]);
        }
        Dimension d = tbl_tables.getTableHeader().getPreferredSize();
        d.height = 0;
        tbl_tables.getTableHeader().setPreferredSize(d);
        tbl_tables.getTableHeader().setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
        tbl_tables.setRowHeight(50);
        tbl_tables.setFont(new java.awt.Font("Tahoma", 0, 14));
    }

    private void loadData_tables(List<S1_tables.to_tables> acc) {
        tbl_tables_ALM.clear();
        tbl_tables_ALM.addAll(acc);
    }

    public static class TbltablesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Table", "Waiter", "Status", "table_location_id"
        };

        public TbltablesModel(ListModel listmodel) {
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
            S1_tables.to_tables tt = (S1_tables.to_tables) getRow(row);
            switch (col) {
                case 0:
                    return "   " + tt.table_name;
                case 1:
                    return "   " + tt.waiter_name;
                case 2:
                    if (tt.status == 0) {
                        return "             Available  ";
                    } else {
                        return "             ---------  ";
                    }

                default:
                    return tt.table_location_id;
            }
        }
    }

    private void data_cols_tables() {
        String where = "";
        loadData_tables(S1_tables.ret_data_touch(where));
    }

    private ArrayListModel tbl_table_customers_ALM;
    private Tbltable_customersModel tbl_table_customers_M;

    private void init_tbl_table_customers() {
        tbl_table_customers_ALM = new ArrayListModel();
        tbl_table_customers_M = new Tbltable_customersModel(tbl_table_customers_ALM);
        tbl_table_customers.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_table_customers.setModel(tbl_table_customers_M);
        tbl_table_customers.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_table_customers.setRowHeight(25);
        int[] tbl_widths_table_customers = {0, 100, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_table_customers.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_table_customers, i, tbl_widths_table_customers[i]);
        }
        Dimension d = tbl_table_customers.getTableHeader().getPreferredSize();
        d.height = 0;
        tbl_table_customers.getTableHeader().setPreferredSize(d);
        tbl_table_customers.getTableHeader().setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_table_customers.setRowHeight(50);

    }

    private void loadData_table_customers(List<S1_table_customers.to_table_customers> acc) {
        tbl_table_customers_ALM.clear();
        tbl_table_customers_ALM.addAll(acc);
    }

    public static class Tbltable_customersModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "customer_id", "customer_name", "table_id", "table_name", "date_added", "user_name", "waiter_id", "waiter_name", "status"
        };

        public Tbltable_customersModel(ListModel listmodel) {
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
            S1_table_customers.to_table_customers tt = (S1_table_customers.to_table_customers) getRow(row);
            switch (col) {
                case 0:
                    if (tt.selected == 0) {
                        return "/POS/icons/x-mark-16.png";
                    } else {
                        return "/POS/icons/check-mark-16.png";
                    }

                case 1:
                    return "   " + tt.customer_name;
                case 2:
                    return "         Delete";
                case 3:
                    return tt.table_id;
                case 4:
                    return tt.table_name;
                case 5:
                    return tt.date_added;
                case 6:
                    return tt.user_name;
                case 7:
                    return tt.waiter_id;
                case 8:
                    return tt.waiter_name;
                default:
                    return tt.status;
            }
        }
    }

    private void data_cols_table_customers() {
        int row = tbl_tables.getSelectedRow();
        if (row < 0) {
            return;
        }

        S1_tables.to_tables to = (S1_tables.to_tables) tbl_tables_ALM.get(tbl_tables.convertRowIndexToModel(row));
        if (ids.equals("" + to.id)) {
            Alert.set(0, "At current location!");
            return;
        }
        String where = "where table_id='" + to.id + "' and status='" + "0" + "'";
        loadData_table_customers(S1_table_customers.ret_data(where));
    }

    private void ok() {
        int row = tbl_tables.getSelectedRow();
        if (row < 0) {
            return;
        }

        S1_tables.to_tables to = (S1_tables.to_tables) tbl_tables_ALM.get(tbl_tables.convertRowIndexToModel(row));
        if (ids.equals("" + to.id)) {
            Alert.set(0, "At current location!");
            return;
        }

        if (callback != null) {
           
            callback.ok(new CloseDialog(this), new OutputData(to));

        }
    }
}
