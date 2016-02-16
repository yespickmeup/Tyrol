/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen;

import POS.util.Alert;
import POS_order_specifications.S1_order_specifications;
import POS_order_specifications.S1_order_specifications.to_order_specifications;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.logging.Level;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import org.jdesktop.swingx.JXLabel;

/**
 *
 * @author Ronald
 */
public class Dlg_touchscreen_quantity extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_touchscreen_quantity
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

        public final double qty;
        public final String spec;

        public OutputData(double qty, String spec) {
            this.qty = qty;
            this.spec = spec;
        }

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_touchscreen_quantity(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_touchscreen_quantity(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_touchscreen_quantity() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_touchscreen_quantity myRef;

    private void setThisRef(Dlg_touchscreen_quantity myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_touchscreen_quantity> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_touchscreen_quantity create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_touchscreen_quantity create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_touchscreen_quantity dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_quantity((java.awt.Frame) parent, false);
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
            Dlg_touchscreen_quantity dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_quantity((java.awt.Dialog) parent, false);
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

        Dlg_touchscreen_quantity dialog = Dlg_touchscreen_quantity.create(new javax.swing.JFrame(), true);
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

        jPanel4 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        jXLabel4 = new org.jdesktop.swingx.JXLabel();
        jXLabel25 = new org.jdesktop.swingx.JXLabel();
        jXLabel26 = new org.jdesktop.swingx.JXLabel();
        jXLabel13 = new org.jdesktop.swingx.JXLabel();
        jXLabel14 = new org.jdesktop.swingx.JXLabel();
        jXLabel12 = new org.jdesktop.swingx.JXLabel();
        jXLabel24 = new org.jdesktop.swingx.JXLabel();
        jXLabel22 = new org.jdesktop.swingx.JXLabel();
        jXLabel23 = new org.jdesktop.swingx.JXLabel();
        jXLabel27 = new org.jdesktop.swingx.JXLabel();
        jXLabel28 = new org.jdesktop.swingx.JXLabel();
        jXLabel29 = new org.jdesktop.swingx.JXLabel();
        jXLabel30 = new org.jdesktop.swingx.JXLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_order_specifications = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_order_specifications2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(249, 154, 4));
        jTextField1.setBorder(null);
        jTextField1.setMargin(new java.awt.Insets(2, 10, 2, 2));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jXLabel2.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel2.setText("7");
        jXLabel2.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel2.setOpaque(true);
        jXLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel2MouseClicked(evt);
            }
        });

        jXLabel3.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel3.setText("8");
        jXLabel3.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel3.setOpaque(true);

        jXLabel4.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel4.setText("9");
        jXLabel4.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel4.setOpaque(true);

        jXLabel25.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel25.setText("0");
        jXLabel25.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel25.setOpaque(true);

        jXLabel26.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel26.setText("Cl");
        jXLabel26.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel26.setOpaque(true);
        jXLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel26MouseClicked(evt);
            }
        });

        jXLabel13.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel13.setText("6");
        jXLabel13.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel13.setOpaque(true);

        jXLabel14.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel14.setText("5");
        jXLabel14.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel14.setOpaque(true);

        jXLabel12.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel12.setText("4");
        jXLabel12.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel12.setOpaque(true);

        jXLabel24.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel24.setText("1");
        jXLabel24.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel24.setOpaque(true);

        jXLabel22.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel22.setText("2");
        jXLabel22.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel22.setOpaque(true);

        jXLabel23.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel23.setText("3");
        jXLabel23.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel23.setOpaque(true);

        jXLabel27.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel27.setText("OK");
        jXLabel27.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel27.setOpaque(true);
        jXLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel27MouseClicked(evt);
            }
        });

        jXLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jXLabel28.setForeground(new java.awt.Color(249, 154, 4));
        jXLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel28.setText("X");
        jXLabel28.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jXLabel28.setOpaque(true);
        jXLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel28MouseClicked(evt);
            }
        });

        jXLabel29.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXLabel29.setText(" Enter Quantity");
        jXLabel29.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jXLabel29.setOpaque(true);

        jXLabel30.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons/SOFTWARE_48x48-32.png"))); // NOI18N
        jXLabel30.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jXLabel30.setOpaque(true);

        tbl_order_specifications.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_order_specifications.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_order_specificationsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_order_specifications);

        tbl_order_specifications2.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_order_specifications2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_order_specifications2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_order_specifications2);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("  ORDER SPECIFICATIONS");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jXLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jXLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(jXLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jTextField1)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jXLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jXLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jXLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jXLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jXLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jXLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jXLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jXLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jXLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jXLabel28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jXLabel29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)))
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jXLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jXLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jXLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel2MouseClicked

    }//GEN-LAST:event_jXLabel2MouseClicked

    private void jXLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel28MouseClicked
        disposed();
    }//GEN-LAST:event_jXLabel28MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jXLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel26MouseClicked
        jTextField1.setText("");
    }//GEN-LAST:event_jXLabel26MouseClicked

    private void jXLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel27MouseClicked
        ok();
    }//GEN-LAST:event_jXLabel27MouseClicked

    private void tbl_order_specificationsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_order_specificationsMouseClicked
        // TODO add your handling code here:
        add_spec();
    }//GEN-LAST:event_tbl_order_specificationsMouseClicked

    private void tbl_order_specifications2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_order_specifications2MouseClicked
        delete();
    }//GEN-LAST:event_tbl_order_specifications2MouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private org.jdesktop.swingx.JXLabel jXLabel12;
    private org.jdesktop.swingx.JXLabel jXLabel13;
    private org.jdesktop.swingx.JXLabel jXLabel14;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXLabel jXLabel22;
    private org.jdesktop.swingx.JXLabel jXLabel23;
    private org.jdesktop.swingx.JXLabel jXLabel24;
    private org.jdesktop.swingx.JXLabel jXLabel25;
    private org.jdesktop.swingx.JXLabel jXLabel26;
    private org.jdesktop.swingx.JXLabel jXLabel27;
    private org.jdesktop.swingx.JXLabel jXLabel28;
    private org.jdesktop.swingx.JXLabel jXLabel29;
    private org.jdesktop.swingx.JXLabel jXLabel3;
    private org.jdesktop.swingx.JXLabel jXLabel30;
    private org.jdesktop.swingx.JXLabel jXLabel4;
    private javax.swing.JTable tbl_order_specifications;
    private javax.swing.JTable tbl_order_specifications2;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
        init_key();
        Border line = BorderFactory.createLineBorder(new java.awt.Color(249, 154, 4));
        Border empty = new EmptyBorder(0, 20, 0, 0);
        CompoundBorder border = new CompoundBorder(line, empty);
        jTextField1.setBorder(border);
        jTextField1.grabFocus();
        focus();
        type();
        init_tbl_order_specifications();
        data_cols();

        init_tbl_order_specifications2();
    }

    private void type() {

        JXLabel[] lbl = {
            jXLabel2, jXLabel3, jXLabel4, jXLabel25, jXLabel12, jXLabel14, jXLabel13, jXLabel24, jXLabel22, jXLabel23,};

        for (final JXLabel l : lbl) {
            l.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    String text = jTextField1.getText();
                    text = text + l.getText();
                    jTextField1.setText(text);

                }

            });
        }

    }

    private void focus() {
        JTextField[] tf = {};
//        Focus_Fire.onFocus_lostFocus(tf);
//        Focus_Fire.select_all(tf);
    }

    public void do_pass(double qty, String spec) {
//        jTextField1.setText(FitIn.fmt_woc(qty));
        jTextField1.grabFocus();
//        jTextField1.selectAll();
        String[] aw = spec.split(",");
        tbl_order_specifications_ALM2.clear();
        for (String a : aw) {
            to_order_specifications to = new to_order_specifications(-1, a);
            if (!a.isEmpty()) {
                tbl_order_specifications_ALM2.add(to);
            }

        }
        tbl_order_specifications_M2.fireTableDataChanged();
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
        tbl_order_specifications.setRowHeight(40);
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

    private ArrayListModel tbl_order_specifications_ALM2;
    private Tblorder_specificationsModel2 tbl_order_specifications_M2;

    private void init_tbl_order_specifications2() {
        tbl_order_specifications_ALM2 = new ArrayListModel();
        tbl_order_specifications_M2 = new Tblorder_specificationsModel2(tbl_order_specifications_ALM2);
        tbl_order_specifications2.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_order_specifications2.setModel(tbl_order_specifications_M2);
        tbl_order_specifications2.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_order_specifications2.setRowHeight(25);
        int[] tbl_widths_order_specifications = {100, 0};
        for (int i = 0, n = tbl_widths_order_specifications.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_order_specifications2, i, tbl_widths_order_specifications[i]);
        }
        Dimension d = tbl_order_specifications.getTableHeader().getPreferredSize();
        d.height = 30;
        tbl_order_specifications2.getTableHeader().setPreferredSize(d);
        tbl_order_specifications2.getTableHeader().setFont(new java.awt.Font("Arial", 0, 11));
        tbl_order_specifications2.setRowHeight(40);
        tbl_order_specifications2.setFont(new java.awt.Font("Arial", 0, 11));
    }

    private void loadData_order_specifications2(List<to_order_specifications> acc) {
        tbl_order_specifications_ALM2.clear();
        tbl_order_specifications_ALM2.addAll(acc);
    }

    public static class Tblorder_specificationsModel2 extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Specification", "specification"
        };

        public Tblorder_specificationsModel2(ListModel listmodel) {
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

    private void add_spec() {
        int row = tbl_order_specifications.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_order_specifications to = (to_order_specifications) tbl_order_specifications_ALM.get(tbl_order_specifications.convertRowIndexToModel(row));
        tbl_order_specifications_ALM2.add(to);
        tbl_order_specifications_M2.fireTableDataChanged();

    }

    private void ok() {
        double qty = FitIn.toDouble(jTextField1.getText());
        if (qty == 0) {
            Alert.set(0, "Enter Quantity");
            return;
        }
        List<to_order_specifications> datas = tbl_order_specifications_ALM2;
        String specs = "";
        for (to_order_specifications to : datas) {
            specs = specs + "," + to.specification;
        }
        if (!specs.isEmpty()) {
            specs = specs.substring(1, specs.length());
        }
        System.out.println(specs);
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(qty, specs));
        }
    }

    private void delete() {
        int row = tbl_order_specifications2.getSelectedRow();
        if (row < 0) {
            return;
        }
        tbl_order_specifications_ALM2.remove(row);
        tbl_order_specifications_M2.fireTableDataChanged();

    }
}
