/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.customers;

import POS.customers.S1_customers.to_customers;
import POS.main.Main;
import POS.util.DateType;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.SearchField;
import mijzcx.synapse.desk.utils.TableWidthUtilities;

/**
 *
 * @author Maytopacka
 */
public class Dlg_customers extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_location
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
    private Dlg_customers(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_customers(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_customers() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_customers myRef;

    private void setThisRef(Dlg_customers myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_customers> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_customers create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_customers create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_customers dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_customers((java.awt.Frame) parent, false);
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
            Dlg_customers dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_customers((java.awt.Dialog) parent, false);
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

        Dlg_customers dialog = Dlg_customers.create(new javax.swing.JFrame(), true);
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

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jXPanel3 = new org.jdesktop.swingx.JXPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_customers = new org.jdesktop.swingx.JXTable();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        tf_search = new javax.swing.JTextField();
        btn_new = new org.jdesktop.swingx.JXLabel();
        btn_edit = new org.jdesktop.swingx.JXLabel();
        btn_delete = new org.jdesktop.swingx.JXLabel();
        btn_add = new org.jdesktop.swingx.JXLabel();
        jLabel7 = new javax.swing.JLabel();
        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        jLabel2 = new javax.swing.JLabel();
        tf_fname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tf_client_id = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tf_lname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf_client_type = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        tf_member_type = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(0, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jPanel1.setOpaque(false);

        jXPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setOpaque(false);

        tbl_customers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_customers.setOpaque(false);
        tbl_customers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_customersMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_customers);

        javax.swing.GroupLayout jXPanel3Layout = new javax.swing.GroupLayout(jXPanel3);
        jXPanel3.setLayout(jXPanel3Layout);
        jXPanel3Layout.setHorizontalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jXPanel3Layout.setVerticalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                .addContainerGap())
        );

        jXPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tf_search.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        tf_search.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_searchActionPerformed(evt);
            }
        });

        btn_new.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/bd_reload.png"))); // NOI18N
        btn_new.setText("NEW");
        btn_new.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_newMouseClicked(evt);
            }
        });

        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/bd_edit.png"))); // NOI18N
        btn_edit.setText("EDIT");
        btn_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_editMouseClicked(evt);
            }
        });

        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/bd_drop.png"))); // NOI18N
        btn_delete.setText("DELETE");
        btn_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_deleteMouseClicked(evt);
            }
        });

        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/bd_new.png"))); // NOI18N
        btn_add.setText("ADD");
        btn_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addMouseClicked(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Search:");

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addGap(11, 11, 11)
                .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_new, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_search)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_new, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jXPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("First Name:");

        tf_fname.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        tf_fname.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Customer Id:");

        tf_client_id.setEnabled(false);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Last Name:");

        tf_lname.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        tf_lname.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Customer Type:");

        tf_client_type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Personal", "Juridical", "Joint" }));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Membership Type:");

        tf_member_type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "N/A", "RM-common", "RM-preferred", "AM-subscriber", "AM-special" }));

        javax.swing.GroupLayout jXPanel2Layout = new javax.swing.GroupLayout(jXPanel2);
        jXPanel2.setLayout(jXPanel2Layout);
        jXPanel2Layout.setHorizontalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf_client_id, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_client_type, 0, 245, Short.MAX_VALUE)
                            .addComponent(tf_fname))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_member_type, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jXPanel2Layout.setVerticalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_client_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_fname)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_lname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_member_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_client_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jXPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jXPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addMouseClicked
        add_customers();
    }//GEN-LAST:event_btn_addMouseClicked

    private void tbl_customersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_customersMouseClicked
        select_customers();
    }//GEN-LAST:event_tbl_customersMouseClicked

    private void btn_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editMouseClicked
        edit_customers();
    }//GEN-LAST:event_btn_editMouseClicked

    private void btn_newMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_newMouseClicked
        clear_customers();
        init_id();
    }//GEN-LAST:event_btn_newMouseClicked

    private void btn_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMouseClicked
        delete_customers();
    }//GEN-LAST:event_btn_deleteMouseClicked

    private void tf_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_searchActionPerformed
        data_cols();
    }//GEN-LAST:event_tf_searchActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXLabel btn_add;
    private org.jdesktop.swingx.JXLabel btn_delete;
    private org.jdesktop.swingx.JXLabel btn_edit;
    private org.jdesktop.swingx.JXLabel btn_new;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    private org.jdesktop.swingx.JXPanel jXPanel3;
    private org.jdesktop.swingx.JXTable tbl_customers;
    private javax.swing.JTextField tf_client_id;
    private javax.swing.JComboBox tf_client_type;
    private javax.swing.JTextField tf_fname;
    private javax.swing.JTextField tf_lname;
    private javax.swing.JComboBox tf_member_type;
    private javax.swing.JTextField tf_search;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        Main.MyDB.setNames("db_fortune_three");
        tf_search.grabFocus();
        init_key();
        hover();
        search();
        init();
        init_tbl_customers();
        data_cols();
        init_id();
    }

    private void init_id() {
        tf_client_id.setText(S1_customers.increment_id());
    }
    // <editor-fold defaultstate="collapsed" desc="settings">

    private void hover() {
        btn_edit.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                btn_edit.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/b_edit.png")));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                btn_edit.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/bd_edit.png")));
            }
        });

        btn_delete.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                btn_delete.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/b_drop.png")));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                btn_delete.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/bd_drop.png")));
            }
        });
        btn_add.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                btn_add.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/b_snewtbl.png")));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                btn_add.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/bd_new.png")));
            }
        });
        btn_new.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                btn_new.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/s_reload.png")));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                btn_new.setIcon(new javax.swing.ImageIcon(getClass().
                        getResource("/POS/img/bd_reload.png")));
            }
        });

    }
    int posX = 0, posY = 0;

    private void init() {
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                posX = e.getX();
                posY = e.getY();
            }
        });
        this.addMouseMotionListener(new MouseAdapter() {

            @Override
            public void mouseDragged(MouseEvent evt) {
                //sets frame position when mouse dragged			
                setLocation(evt.getXOnScreen() - posX, evt.getYOnScreen() - posY);
            }
        });
    }

    private void search() {
//        SearchField sf = (SearchField) tf_search;
//        sf.setFont(new java.awt.Font("Tahoma", 0, 10));
//        sf.set_instruction1("Type To Search");
//        sf.set_searcher(new SearchField.ISearcher() {
//
//            @Override
//            public List get_entered(String starts_with) {
//                // your search list here coming from svc for example.
//
//                return new ArrayList();
//
//            }
//        });

//        sf.setCallbackDisplay(new SearchField.CallbackDisplay() {
//
//            @Override
//            public void display(Object o) {
//            }
//        });
//        sf.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//            }
//        });
    }

    private void hover(JLabel lbl) {
        lbl.setBackground(new java.awt.Color(230, 227, 227));
        lbl.setForeground(new java.awt.Color(0, 0, 0));

    }

    private void exit(JLabel lbl) {
        lbl.setBackground(new java.awt.Color(255, 255, 255));
        lbl.setForeground(new java.awt.Color(153, 153, 153));
    }

    private void hover2(JLabel lbl) {
        lbl.setForeground(new java.awt.Color(0, 0, 0));
        lbl.setFont(new java.awt.Font("Tahoma", 0, 20));
    }

    private void exit2(JLabel lbl) {
        lbl.setForeground(new java.awt.Color(153, 153, 153));
        lbl.setFont(new java.awt.Font("Tahoma", 0, 18));
    }
    // </editor-fold>

    public void do_pass() {
//        data_cols() ;
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
    private ArrayListModel tbl_customers_ALM;
    private TblcustomersModel tbl_customers_M;

    private void init_tbl_customers() {
        tbl_customers_ALM = new ArrayListModel();
        tbl_customers_M = new TblcustomersModel(tbl_customers_ALM);
        tbl_customers.getTableHeader().
                setPreferredSize(new Dimension(100, 0));
        tbl_customers.setModel(tbl_customers_M);
        tbl_customers.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_customers.setRowHeight(25);
        int[] tbl_widths_customers = {80, 100};
        for (int i = 0, n = tbl_widths_customers.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_customers, i, tbl_widths_customers[i]);
        }
        Dimension d = tbl_customers.getTableHeader().
                getPreferredSize();
        d.height = 0;
        tbl_customers.getTableHeader().
                setPreferredSize(d);
        tbl_customers.getTableHeader().
                setFont(new java.awt.Font("Arial", 0, 11));
        tbl_customers.setRowHeight(25);
        tbl_customers.setFont(new java.awt.Font("Arial", 0, 11));
    }

    private void loadData_customers(List<to_customers> acc) {
        tbl_customers_ALM.clear();
        tbl_customers_ALM.addAll(acc);
    }

    public static class TblcustomersModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Member Id", "Name"
        };

        public TblcustomersModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 11) {
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
            to_customers tt = (to_customers) getRow(row);
            switch (col) {
                case 0:
                    return tt.client_id;
                default:
                    return tt.fname + " " + tt.lname;
            }
        }
    }

    private void data_cols() {
        String where = "";
        String search = tf_search.getText();
        where = " where lname like '%" + search + "%' or fname like '%" + search + "%' order by fname asc";
        loadData_customers(S1_customers.ret_data(where));
    }

    private void add_customers() {
        int id = -1;
        String customer_name = "";
        String fname = tf_fname.getText();
        String lname = tf_lname.getText();
        String client_id = S1_customers.increment_id();
        String client_type = tf_client_type.getSelectedItem().toString();
        String member_type = tf_member_type.getSelectedItem().toString();
        String membership = DateType.sf.format(new Date());
        to_customers to = new to_customers(id, customer_name, fname, lname, client_id, client_type, member_type, membership);
        S1_customers.add_customers(to);
        data_cols();
        clear_customers();
    }

    private void select_customers() {
        int row = tbl_customers.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_customers to = (to_customers) tbl_customers_ALM.get(tbl_customers.
                convertRowIndexToModel(row));
        tf_fname.setText(to.fname);
        tf_client_id.setText(to.client_id);
        tf_lname.setText(to.lname);
        tf_client_type.setSelectedItem(to.client_type);
        tf_member_type.setSelectedItem(to.member_type);
    }

    private void edit_customers() {
        int row = tbl_customers.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_customers to = (to_customers) tbl_customers_ALM.get(tbl_customers.
                convertRowIndexToModel(row));
        int id = to.id;
        String customer_name = "";
        String fname = tf_fname.getText();
        String lname = tf_lname.getText();
        String client_id = tf_client_id.getText();
        String client_type = tf_client_type.getSelectedItem().toString();
        String member_type = tf_member_type.getSelectedItem().toString();
        String membership = DateType.sf.format(new Date());
        to_customers to1 = new to_customers(id, customer_name, fname, lname, client_id, client_type, member_type, membership);
        S1_customers.edit_customers(to1);
        data_cols();
        clear_customers();
    }

    private void clear_customers() {
        tf_fname.setText("");
        tf_lname.setText("");
    }

    private void delete_customers() {
        int row = tbl_customers.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_customers to = (to_customers) tbl_customers_ALM.get(tbl_customers.
                convertRowIndexToModel(row));
        S1_customers.delete_customers(to);
        data_cols();
        clear_customers();
    }
}
