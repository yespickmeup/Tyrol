/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS_order_specifications;

import POS.util.Focus_Fire;
import POS_order_specifications.S1_order_specifications.to_order_specifications;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.Font;
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
public class Dlg_order_spefications extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_order_spefications
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
    private Dlg_order_spefications(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_order_spefications(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_order_spefications() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_order_spefications myRef;

    private void setThisRef(Dlg_order_spefications myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_order_spefications> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_order_spefications create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_order_spefications create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_order_spefications dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_order_spefications((java.awt.Frame) parent, false);
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
            Dlg_order_spefications dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_order_spefications((java.awt.Dialog) parent, false);
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

        Dlg_order_spefications dialog = Dlg_order_spefications.create(new javax.swing.JFrame(), true);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_order_specifications = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        tf_specification = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbl_order_specifications.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbl_order_specifications);

        jLabel1.setText("Spefications:");

        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tf_specification)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_specification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        add_order_specifications();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        edit_order_specifications();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        delete_order_specifications();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_order_specifications;
    private javax.swing.JTextField tf_specification;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
        init_key();
        init_tbl_order_specifications();
        data_cols();
        focus();
    }

    public void do_pass() {

    }

    private void focus() {
        JTextField[] tf = {tf_specification};
        Focus_Fire.onFocus_lostFocus(tf);
        Focus_Fire.select_all(tf);
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

    private ArrayListModel tbl_order_specifications_ALM;
    private Tblorder_specificationsModel tbl_order_specifications_M;

    private void init_tbl_order_specifications() {
        tbl_order_specifications_ALM = new ArrayListModel();
        tbl_order_specifications_M = new Tblorder_specificationsModel(tbl_order_specifications_ALM);
        tbl_order_specifications.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_order_specifications.setModel(tbl_order_specifications_M);
        tbl_order_specifications.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_order_specifications.setRowHeight(25);
        int[] tbl_widths_order_specifications = {100, 0};
        for (int i = 0, n = tbl_widths_order_specifications.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_order_specifications, i, tbl_widths_order_specifications[i]);
        }
        Dimension d = tbl_order_specifications.getTableHeader().getPreferredSize();
        d.height = 30;
        tbl_order_specifications.getTableHeader().setPreferredSize(d);
        tbl_order_specifications.getTableHeader().setFont(new java.awt.Font("Arial", 0, 11));
        tbl_order_specifications.setRowHeight(25);
        tbl_order_specifications.setFont(new java.awt.Font("Arial", 0, 11));
    }

    private void loadData_order_specifications(List<to_order_specifications> acc) {
        tbl_order_specifications_ALM.clear();
        tbl_order_specifications_ALM.addAll(acc);
    }

    public static class Tblorder_specificationsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Specification", "specification"
        };

        public Tblorder_specificationsModel(ListModel listmodel) {
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
            to_order_specifications tt = (to_order_specifications) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.specification;
                default:
                    return tt.specification;
            }
        }
    }

    private void data_cols() {
        String where = "";
        loadData_order_specifications(S1_order_specifications.ret_data(where));
    }

    private void add_order_specifications() {
        int id = -1;
        String specification = tf_specification.getText();
        to_order_specifications to = new to_order_specifications(id, specification);
        S1_order_specifications.add_order_specifications(to);
        data_cols();
        clear_order_specifications();
    }

    private void select_order_specifications() {
        int row = tbl_order_specifications.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_order_specifications to = (to_order_specifications) tbl_order_specifications_ALM.get(tbl_order_specifications.convertRowIndexToModel(row));
        tf_specification.setText(to.specification);
    }

    private void edit_order_specifications() {
        int row = tbl_order_specifications.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_order_specifications to = (to_order_specifications) tbl_order_specifications_ALM.get(tbl_order_specifications.convertRowIndexToModel(row));
        int id = to.id;
        String specification = tf_specification.getText();
        to_order_specifications to1 = new to_order_specifications(id, specification);
        S1_order_specifications.edit_order_specifications(to1);
        data_cols();
        clear_order_specifications();
    }

    private void clear_order_specifications() {
        tf_specification.setText("");
    }

    private void delete_order_specifications() {
        int row = tbl_order_specifications.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_order_specifications to = (to_order_specifications) tbl_order_specifications_ALM.get(tbl_order_specifications.convertRowIndexToModel(row));
        S1_order_specifications.delete_order_specifications(to);
        data_cols();
        clear_order_specifications();
    }

}
