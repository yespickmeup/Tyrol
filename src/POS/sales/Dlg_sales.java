/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.sales;

import POS.discounts.S1_discounts;
import POS.items.S1_items;
import POS.main.Main;
import POS.services.S1_sales_services;
import POS.util.*;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.*;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import mijzcx.synapse.desk.utils.*;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import net.sf.jasperreports.engine.*;

/**
 *
 * @author i1
 */
public class Dlg_sales extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_sales
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
    private Dlg_sales(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_sales(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_sales() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_sales myRef;

    private void setThisRef(Dlg_sales myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_sales> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_sales create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_sales create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_sales dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_sales((java.awt.Frame) parent, false);
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
            Dlg_sales dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_sales((java.awt.Dialog) parent, false);
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


        Dlg_sales dialog = Dlg_sales.create(new javax.swing.JFrame(), true);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_sales_items = new javax.swing.JTable();
        lbl_total = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbl_discount = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_discount_amount = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf_search = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tf_qty = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        tf_discount = new SearchField();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lbl_screen_name = new javax.swing.JLabel();
        lbl_date = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbl_trans_no = new javax.swing.JLabel();
        pnl_search = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_items = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        tf_search1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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

        lbl_total.setBackground(new java.awt.Color(51, 153, 255));
        lbl_total.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lbl_total.setForeground(new java.awt.Color(255, 255, 255));
        lbl_total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_total.setText("0.00");
        lbl_total.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_total.setOpaque(true);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("SETTLE (Ctrl)");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("CLEAR ORDER (F3)");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("DISCOUNT (F5):");

        lbl_discount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_discount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_discount.setText("0.00");
        lbl_discount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("%");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("AMOUNT:");

        tf_discount_amount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_discount_amount.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("SEARCH (F2):");

        tf_search.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_searchActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("QTY:");

        tf_qty.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_qty.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_qty.setText("1");
        tf_qty.setNextFocusableComponent(tf_search);
        tf_qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_qtyActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/s_reload.png"))); // NOI18N
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        tf_discount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_discount.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(tf_search)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tf_discount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_discount, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_discount_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_discount, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tf_discount_amount, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_discount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("SCREEN NAME:");

        lbl_screen_name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_screen_name.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_screen_name.setText("SCREEN NAME:");

        lbl_date.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_date.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_date.setText("SCREEN NAME:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("DATE:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("TRANS #:");

        lbl_trans_no.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_trans_no.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_trans_no.setText("SCREEN NAME:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_screen_name, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_date, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addGap(39, 39, 39)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_trans_no, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbl_screen_name)
                    .addComponent(jLabel8)
                    .addComponent(lbl_date)
                    .addComponent(jLabel9)
                    .addComponent(lbl_trans_no))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_total, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnl_search.setBackground(new java.awt.Color(182, 217, 251));

        tbl_items.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_items.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_itemsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_items);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("SEARCH:");

        tf_search1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_search1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tf_search1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_search1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnl_searchLayout = new javax.swing.GroupLayout(pnl_search);
        pnl_search.setLayout(pnl_searchLayout);
        pnl_searchLayout.setHorizontalGroup(
            pnl_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_searchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_searchLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(pnl_searchLayout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        pnl_searchLayout.setVerticalGroup(
            pnl_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_searchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_searchActionPerformed
        data_cols2();
    }//GEN-LAST:event_tf_searchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        settle();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbl_sales_itemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_sales_itemsMouseClicked
        edit_order();
    }//GEN-LAST:event_tbl_sales_itemsMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        tbl_sales_items_ALM.clear();
        tbl_sales_items_M.fireTableDataChanged();
        Alert.set(0, "Orders Cleared");
        compute();
        tf_search.grabFocus();
        tf_search.selectAll();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbl_itemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_itemsMouseClicked
        // TODO add your handling code here:
        add_order();
    }//GEN-LAST:event_tbl_itemsMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        init_discount();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tf_search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_search1ActionPerformed
        // TODO add your handling code here:
        data_cols();
    }//GEN-LAST:event_tf_search1ActionPerformed

    private void tf_qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_qtyActionPerformed
        data_cols2();
        tf_qty.setText("1");
    }//GEN-LAST:event_tf_qtyActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
//        Alert.set(0, "OUT");
    }//GEN-LAST:event_formWindowClosing
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_date;
    private javax.swing.JLabel lbl_discount;
    private javax.swing.JLabel lbl_screen_name;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JLabel lbl_trans_no;
    private javax.swing.JPanel pnl_search;
    private javax.swing.JTable tbl_items;
    private javax.swing.JTable tbl_sales_items;
    private javax.swing.JTextField tf_discount;
    private javax.swing.JTextField tf_discount_amount;
    private javax.swing.JTextField tf_qty;
    private javax.swing.JTextField tf_search;
    private javax.swing.JTextField tf_search1;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        Main.MyDB.setNames("db_fortune_three");
        init_key();
        focus();
//        init_tf();
        init();
        init_discount();
        init_trans_no();
        init_tbl_items();
//        data_cols();
//        AutoCompleteDecorator.decorate(cb_discount);
//        cb_discount.setEditable(true);
        init_tbl_sales_items();
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                tf_search.requestFocus();
            }
        });
        DateTime.setLabel(lbl_date);
        lbl_screen_name.setText(Users.screen_name);
        pnl_search.setVisible(false);
    }

    private void focus() {
        JTextField[] tf = {tf_discount, tf_search, tf_discount_amount, tf_qty, tf_search1};
        Focus_Fire.onFocus_lostFocus(tf);
    }

    private void init_discount() {
//        cb_discount.setModel(new ListComboBoxModel(S1_discounts.ret_cb_data()));
        final SearchField sf2 = (SearchField) tf_discount;
        sf2.setFont(new java.awt.Font("Tahoma", 1, 14));
        sf2.set_instruction1("Select Discount");
        sf2.set_searcher(new SearchField.ISearcher() {

            @Override
            public List get_entered(String starts_with) {
                return S1_discounts.ret_cb_data();
            }
        });
        sf2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                get_discount();
                tf_search.grabFocus();
                tf_search.selectAll();
            }
        });
    }

    private void init_trans_no() {
        lbl_trans_no.setText(S1_sales.increment_id());
    }

    private void get_discount() {
        String discount_name = tf_discount.getText().
                toString();
        S1_discounts.to_discounts to = S1_discounts.ret_data2(discount_name);
        if (to == null) {
        } else {
            lbl_discount.setText(FitIn.fmt_wc_0(to.discount_rate));
        }
        if (discount_name.isEmpty() || discount_name.equalsIgnoreCase("NO DISCOUNT")) {
            tf_discount_amount.setEnabled(true);
        } else {
            tf_discount_amount.setText("");
            tf_discount_amount.setEnabled(false);
        }
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

    public void do_pass() {
        tf_search.setCaretPosition(0);
        tf_search.grabFocus();
        tf_search.selectAll();
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
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_ALT, KeyEvent.VK_F4, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                btn_0.doClick();
                Alert.set(0, "asdasd");
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_F3, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                btn_0.doClick();
                jButton2.doClick();
                tf_search.selectAll();
                tf_search.grabFocus();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_F1, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                btn_0.doClick();
//               jButton2.doClick();
                tf_search.selectAll();
                tf_search.grabFocus();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_F5, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                btn_0.doClick();
//               jButton2.doClick();
//               tf_search.selectAll();
//               tf_search.grabFocus();
                tf_discount.grabFocus();
            }
        });

        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_F2, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                btn_0.doClick();
                if (pnl_search.isVisible()) {
                    jPanel1.setVisible(true);
                    pnl_search.setVisible(false);
                    tf_search.selectAll();
                    tf_search.grabFocus();
                } else {
                    jPanel1.setVisible(false);
                    pnl_search.setVisible(true);
                    tf_search1.selectAll();
                    tf_search1.grabFocus();
                    tbl_items_ALM.clear();
                    tbl_items_M.fireTableDataChanged();
                }

            }
        });

        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_CONTROL, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jButton1.doClick();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_ALT, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                jButton1.doClick();
            }
        });

        tf_search1.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (!tbl_items_ALM.isEmpty()) {
                        tbl_items.setRowSelectionInterval(0, 0);
                        tbl_items.grabFocus();
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                }
                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    settle();
                }
                if (e.getKeyCode() == KeyEvent.VK_ALT) {
//                    settle();
                }
                if (e.getKeyCode() == KeyEvent.VK_TAB) {
//                    settle();
                    tf_qty.selectAll();
                    tf_qty.grabFocus();

                }
            }
        });
        tf_search.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (!tbl_sales_items_ALM.isEmpty()) {
                        tbl_sales_items.setRowSelectionInterval(0, 0);
                        tbl_sales_items.grabFocus();
                    }
                }

                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    settle();
                }
                if (e.getKeyCode() == KeyEvent.VK_ALT) {
//                    settle();
                }
                if (e.getKeyCode() == KeyEvent.VK_TAB) {
//                    settle();
                    tf_qty.requestFocus();
                    tf_qty.selectAll();


                }
            }
        });

        tbl_items.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    if (!tbl_sales_items_ALM.isEmpty()) {
                        tbl_sales_items.setRowSelectionInterval(0, 0);
                        tbl_sales_items.grabFocus();
                    }
                }

                if (e.getKeyCode() == KeyEvent.VK_F2) {
                    if (pnl_search.isVisible()) {
                        jPanel1.setVisible(true);
                        pnl_search.setVisible(false);
                        tf_search.selectAll();
                        tf_search.grabFocus();
                    } else {
                        jPanel1.setVisible(false);
                        pnl_search.setVisible(true);
                        tf_search1.selectAll();
                        tf_search1.grabFocus();
                        tbl_items_ALM.clear();
                        tbl_items_M.fireTableDataChanged();
                    }
                }

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                    add_order();
                    tf_search1.grabFocus();
                    tf_search1.selectAll();
                    e.consume();
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    tf_search1.grabFocus();
                    tf_search1.selectAll();

                }
            }
        });
        tbl_sales_items.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    if (!tbl_sales_items_ALM.isEmpty()) {
                        delete_item();
                        tf_search.grabFocus();
                        tf_search.selectAll();
                        e.consume();
                    }
                }

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                    edit_order();
                    e.consume();
                }

            }
        });
        tf_qty.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    settle();
                }
            }
        });
    }
    // </editor-fold>
    private ArrayListModel tbl_items_ALM;
    private TblitemsModel tbl_items_M;

    private void init_tbl_items() {
        tbl_items_ALM = new ArrayListModel();
        tbl_items_M = new TblitemsModel(tbl_items_ALM);
        tbl_items.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_items.setModel(tbl_items_M);
        tbl_items.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_items.setRowHeight(25);
        int[] tbl_widths_items = {50, 100, 100, 0, 0, 0, 0, 0, 0, 0, 0, 60, 0, 60, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_items.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_items, i, tbl_widths_items[i]);
        }
        Dimension d = tbl_items.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_items.getTableHeader().
                setPreferredSize(d);
        tbl_items.getTableHeader().
                setFont(new java.awt.Font("Arial", 0, 11));
        tbl_items.setRowHeight(30);
        tbl_items.setFont(new java.awt.Font("Arial", 0, 11));
    }

    private void loadData_items(List<S1_items.to_items> acc) {
        tbl_items_ALM.clear();
        tbl_items_ALM.addAll(acc);
    }

    public static class TblitemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Barcode", "Description", "generic_name", "Category", "category_id", "Classification", "classification_id"
                , "Sub Class", "sub_classification_id", "id", "Unit", "conversion", "Price", "date_added", "user_name", "item_type", "Active"
        };

        public TblitemsModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 111) {
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
            S1_items.to_items tt = (S1_items.to_items) getRow(row);
            switch (col) {
                case 0:
                    return FitIn.fmt_wc_0(tt.product_qty);
                case 1:
                    return tt.barcode;
                case 2:
                    return tt.description;
                case 3:
                    return tt.generic_name;
                case 4:
                    return tt.category;
                case 5:
                    return tt.category_id;
                case 6:
                    return tt.classification;
                case 7:
                    return tt.classification_id;
                case 8:
                    return tt.sub_classification;
                case 9:
                    return tt.sub_classification_id;
                case 10:
                    return tt.id;
                case 11:
                    return tt.unit;
                case 12:
                    return tt.conversion;
                case 13:
                    return FitIn.fmt_wc_0(tt.selling_price);
                case 14:
                    return tt.date_added;
                case 15:
                    return tt.user_name;
                case 16:
                    return tt.item_type;
                default:
                    if (tt.status == 0) {
                        return "NO";
                    } else {
                        return "YES";
                    }

            }
        }
    }

    private void data_cols() {
        String search = tf_search1.getText();
        List<S1_items.to_items> datas = S1_items.ret_data3(search, "", "", "", "");
        loadData_items(datas);
        if (datas.size() == 1) {
            tbl_items.setRowSelectionInterval(0, 0);
            add_order();
        }
    }

    private void data_cols2() {
        String search = tf_search.getText();
        List<S1_items.to_items> datas = S1_items.ret_data2(search, "", "", "", "");

        loadData_items(datas);
        if (datas.size() == 1) {
            tbl_items.setRowSelectionInterval(0, 0);
            add_order2();
        }

        if (datas.isEmpty()) {
            Alert.set(0, "ITEM NOT FOUND");
            tf_search.selectAll();
            tf_search.grabFocus();
        }
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
        int[] tbl_widths_sales_items = {50, 100, 100, 60, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100, 0, 0, 0, 0, 0, 0, 0, 0, 80};
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
        tbl_sales_items.setRowHeight(30);
        tbl_sales_items.setFont(new java.awt.Font("Arial", 0, 11));
    }

    private void loadData_sales_items(List<S1_sales_orders.to_sales_items> acc) {
        tbl_sales_items_ALM.clear();
        tbl_sales_items_ALM.addAll(acc);
    }

    public static class Tblsales_itemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Barcode", "Description", "unit", "category", "category_id", "classification"
                , "classification_id", "sub_classification", "sub_classification_id", "id", "Unit", "conversion", "Price"
                , "date_added", "user_name", "item_type", "status", "session_no", "item_discount", "discount", "discount_amount", "Total"
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
            S1_sales_orders.to_sales_items tt = (S1_sales_orders.to_sales_items) getRow(row);
            switch (col) {
                case 0:
                    return FitIn.fmt_wc_0(tt.product_qty);
                case 1:
                    return tt.barcode;
                case 2:
                    String add = "";
                    if (tt.discount_amount > 0) {
                        add = " - " + FitIn.fmt_wc_0(tt.discount_amount) + " disc";
                    }
                    return tt.description + "" + add;
                case 3:
                    return tt.unit;
                case 4:
                    return tt.category;
                case 5:
                    return tt.category_id;
                case 6:
                    return tt.classification;
                case 7:
                    return tt.classification_id;
                case 8:
                    return tt.sub_classification;
                case 9:
                    return tt.sub_classification_id;
                case 10:
                    return tt.id;
                case 11:
                    return tt.unit;
                case 12:
                    return tt.conversion;
                case 13:
                    return FitIn.fmt_wc_0(tt.selling_price);
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

                default:
                    return tt.sales_no;
            }
        }
    }

    private void data_cols_orders() {
        String search = tf_search.getText();
//        loadData_sales_items(S1_sales_items.ret_data(search));
    }

    private void add_order() {
        int row = tbl_items.getSelectedRow();
        if (row < 0) {
            return;
        }

     final   S1_items.to_items to = (S1_items.to_items) tbl_items_ALM.get(tbl_items.
                convertRowIndexToModel(row));
        final int id = -1;
        final String barcode = to.barcode;
        final String description = to.description;
        final String generic_name = to.generic_name;
        final String category = to.category;
        final String category_id = to.category_id;
        final String classification = to.classification;
        final String classification_id = to.classification_id;
        final String sub_classification = to.sub_classification;
        final String sub_classification_id = to.sub_classification_id;
        final double product_qty = FitIn.toDouble(tf_qty.getText());
        final String unit = to.unit;
        final double conversion = to.conversion;
        final double selling_price = to.selling_price;
        final String date_added = DateType.datetime.format(new Date());
        final String user_name = Users.user_name;
        final String item_type = to.item_type;
        final int statu = 0;
        final String session_no = Users.session_no;
        final String item_discount = tf_discount.getText();

        final double discount = FitIn.toDouble(lbl_discount.getText());
        double discount_amount = 0;

        if (item_discount.isEmpty() || item_discount.equalsIgnoreCase("NO DISCOUNT")) {
            discount_amount = FitIn.toDouble(tf_discount_amount.getText());
        } else {
            double due = to.selling_price * product_qty;
            discount_amount = discount / 100;
            discount_amount = due * discount_amount;
        }
        final String sales_no = FitIn.fmt_wc_0((product_qty * selling_price) - discount_amount);
        final int fixed_price = to.fixed_price;
        final double d = discount_amount;
        final double d2 = discount_amount;
        final List< S1_sales_orders.to_sales_items> datas = tbl_sales_items_ALM;
        int naa = 0;
        final String supplier = to.supplier;
        final String supplier_id = to.supplier_id;
        final int vatable = to.vatable;
        
        for (final S1_sales_orders.to_sales_items to2 : datas) {
            if (to2.barcode.equalsIgnoreCase(to.barcode) && to.unit.equals(to2.unit)) {
                naa = 1;
                if (to2.fixed_price == 0) {
                    Window p = (Window) this;
                    Dlg_fixed_price nd = Dlg_fixed_price.create(p, true);
                    nd.setTitle("");
                    nd.do_pass(to2.product_qty, to2.selling_price, to2.description);
                    nd.setCallback(new Dlg_fixed_price.Callback() {

                        @Override
                        public void ok(CloseDialog closeDialog, Dlg_fixed_price.OutputData data) {
                            closeDialog.ok();
                            double qty = to2.product_qty + data.qty;
                            double disc = to2.discount_amount + d;
//                System.out.println("" + to2.discount_amount + " " + discount_amount);
                            double total = (qty * to2.selling_price) - disc;
                            to2.setDiscount_amount(disc);
                            to2.setSales_no(FitIn.fmt_wc_0(total));
                            to2.setProduct_qty(qty);
                            tbl_sales_items_M.fireTableDataChanged();
                            Alert.set(0, "ORDER UPDATED");
                        }
                    });
                    nd.setLocationRelativeTo(this);

                    nd.setVisible(true);
                } else {
                    Window p = (Window) this;
                    Dlg_qty_delete_fixed nd = Dlg_qty_delete_fixed.create(p, true);
                    nd.setTitle("");
                    nd.do_pass3(1, selling_price, to.description);
                    nd.setCallback(new Dlg_qty_delete_fixed.Callback() {

                        @Override
                        public void ok(CloseDialog closeDialog, Dlg_qty_delete_fixed.OutputData data) {
                            closeDialog.ok();
                            double qty = to2.product_qty + data.qty;
                            double disc = to2.discount_amount + d2;
//                System.out.println("" + to2.discount_amount + " " + discount_amount);
                            double total = (qty * to2.selling_price) - disc;
//                System.out.println(qty + " " + to2.selling_price + " = " + " " + disc + " " + " " + total);
                            to2.setDiscount_amount(disc);
                            to2.setSales_no(FitIn.fmt_wc_0(total));
                            to2.setProduct_qty(qty);
                            tbl_sales_items_M.fireTableDataChanged();
                            Alert.set(0, "ORDER ADDED");
                        }

                        @Override
                        public void delete(CloseDialog closeDialog, Dlg_qty_delete_fixed.OutputData data) {
                            closeDialog.ok();
                        }
                    });
                    nd.setLocationRelativeTo(this);
                    nd.setVisible(true);



                }
                break;
            } else {
                naa = 0;
            }
        }
        final double disc = discount_amount;
        if (naa == 0) {
            if (to.fixed_price == 0) {
                Window p = (Window) this;
                Dlg_fixed_price nd = Dlg_fixed_price.create(p, true);
                nd.setTitle("");
                nd.do_pass2(0, to.selling_price, to.description);
                nd.setCallback(new Dlg_fixed_price.Callback() {

                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_fixed_price.OutputData data) {
                        closeDialog.ok();
                        S1_sales_orders.to_sales_items order = new S1_sales_orders.to_sales_items(id, barcode, description
                                , generic_name, category, category_id, classification, classification_id, sub_classification
                                , sub_classification_id, data.qty, unit, conversion, data.price, date_added, user_name
                                , item_type, statu, session_no, item_discount, discount, disc, FitIn.
                                fmt_wc_0((data.qty * data.price) - disc), fixed_price, supplier, supplier_id, vatable,to.printing_assembly_id,to.printing_assembly_name,to.group_id,to.group_name);
                        datas.add(order);
                        tbl_sales_items_M.fireTableDataChanged();
                        Alert.set(0, "ORDER ADDED");
                    }
                });
                nd.setLocationRelativeTo(this);
                nd.setVisible(true);
            } else {
                Window p = (Window) this;
                Dlg_qty_delete_fixed nd = Dlg_qty_delete_fixed.create(p, true);
                nd.setTitle("");
                nd.do_pass3(1, selling_price, to.description);
                nd.setCallback(new Dlg_qty_delete_fixed.Callback() {

                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_qty_delete_fixed.OutputData data) {
                        closeDialog.ok();
                        S1_sales_orders.to_sales_items order = new S1_sales_orders.to_sales_items(id, barcode, description, generic_name
                                , category, category_id, classification, classification_id, sub_classification, sub_classification_id
                                , data.qty, unit, conversion, selling_price, date_added, user_name, item_type, statu, session_no
                                , item_discount, discount, d2, FitIn.
                                fmt_wc_0((data.qty * data.price) - disc), fixed_price, supplier, supplier_id, vatable,to.printing_assembly_id,to.printing_assembly_name,to.group_id,to.group_name);
                        datas.add(order);
                        tbl_sales_items_M.fireTableDataChanged();
                        tf_search1.grabFocus();
                        tf_search1.selectAll();
                        Alert.set(0, "ORDER ADDED");
                        
                    }

                    @Override
                    public void delete(CloseDialog closeDialog, Dlg_qty_delete_fixed.OutputData data) {
                        closeDialog.ok();
                    }
                });
                nd.setLocationRelativeTo(this);
                nd.setVisible(true);

            }
        }
     
        tbl_items.removeRowSelectionInterval(row, row);
        compute();
    }

    private void add_order2() {
        int row = tbl_items.getSelectedRow();
        if (row < 0) {
            return;
        }

       final S1_items.to_items to = (S1_items.to_items) tbl_items_ALM.get(tbl_items.
                convertRowIndexToModel(row));
        final int id = -1;
        final String barcode = to.barcode;
        final String description = to.description;
        final String generic_name = to.generic_name;
        final String category = to.category;
        final String category_id = to.category_id;
        final String classification = to.classification;
        final String classification_id = to.classification_id;
        final String sub_classification = to.sub_classification;
        final String sub_classification_id = to.sub_classification_id;
        final double product_qty = FitIn.toDouble(tf_qty.getText());
        final String unit = to.unit;
        final double conversion = to.conversion;
        final double selling_price = to.selling_price;
        final String date_added = DateType.datetime.format(new Date());
        final String user_name = Users.user_name;
        final String item_type = to.item_type;
        final int statu = 0;
        final String session_no = Users.session_no;
        final String item_discount = tf_discount.getText();

        final double discount = FitIn.toDouble(lbl_discount.getText());
        double discount_amount = 0;
        if (item_discount.isEmpty() || item_discount.equalsIgnoreCase("NO DISCOUNT")) {
            discount_amount = FitIn.toDouble(tf_discount_amount.getText());
        } else {
            double due = to.selling_price * product_qty;
            discount_amount = discount / 100;
            discount_amount = due * discount_amount;
        }
        final String sales_no = FitIn.fmt_wc_0((product_qty * selling_price) - discount_amount);
        final int fixed_price = to.fixed_price;
        final double d = discount_amount;
        final List< S1_sales_orders.to_sales_items> datas = tbl_sales_items_ALM;
        int naa = 0;
        final String supplier = to.supplier;
        final String supplier_id = to.supplier_id;
        final int vatable = to.vatable;
        for (final S1_sales_orders.to_sales_items to2 : datas) {
            if (to2.barcode.equalsIgnoreCase(to.barcode) && to2.unit.equals(to.unit)) {
                naa = 1;
                if (to2.fixed_price == 0) {
                    Window p = (Window) this;
                    Dlg_fixed_price nd = Dlg_fixed_price.create(p, true);
                    nd.setTitle("");
                    nd.do_pass(to2.product_qty, to2.selling_price, to2.description);
                    nd.setCallback(new Dlg_fixed_price.Callback() {

                        @Override
                        public void ok(CloseDialog closeDialog, Dlg_fixed_price.OutputData data) {

                            closeDialog.ok();
                            double qty = to2.product_qty + data.qty;
                            double disc = to2.discount_amount + d;
//                System.out.println("" + to2.discount_amount + " " + discount_amount);
                            double total = (qty * to2.selling_price) - disc;
                            to2.setDiscount_amount(disc);
                            to2.setSales_no(FitIn.fmt_wc_0(total));
                            to2.setProduct_qty(qty);
                            tbl_sales_items_M.fireTableDataChanged();
                            Alert.set(0, "ORDER UPDATED");
                        }
                    });
                    nd.setLocationRelativeTo(this);

                    nd.setVisible(true);
                } else if (to.multi_level_pricing == 1) {

                    Window p = (Window) this;
                    Dlg_multi_pricing nd = Dlg_multi_pricing.create(p, true);
                    nd.setTitle("");
                    nd.do_pass(to.multi, to.description);
                    nd.setCallback(new Dlg_multi_pricing.Callback() {

                        @Override
                        public void ok(CloseDialog closeDialog, Dlg_multi_pricing.OutputData data) {
                            closeDialog.ok();
                            int naa3 = 0;
                            double d3 = 0;
                            for (final S1_sales_orders.to_sales_items to3 : datas) {
                                if (to3.unit.equalsIgnoreCase(data.unit)) {
                                    double qty = data.qty;
                                    double disc = to3.discount_amount + d;
                                    d3 = disc;
//                System.out.println("" + to2.discount_amount + " " + discount_amount);
                                    double total = (qty * to3.selling_price) - disc;
                                    to3.setDiscount_amount(disc);
                                    to3.setSales_no(FitIn.fmt_wc_0(total));
                                    to3.setProduct_qty(qty);
                                    tbl_sales_items_M.fireTableDataChanged();
                                    Alert.set(0, "ORDER ADDED");
                                    naa3 = 1;
                                    break;
                                }
                            }
                            if (naa3 == 0) {
//                                System.out.println("");
                                double disc = d3 + d;
                                String sales_no2 = FitIn.fmt_wc_0((data.qty * data.price) - disc);
                                S1_sales_orders.to_sales_items order = new S1_sales_orders.to_sales_items(id, barcode, description
                                        , generic_name, category, category_id, classification, classification_id, sub_classification
                                        , sub_classification_id, data.qty, data.unit, data.conversion, data.price, date_added, user_name
                                        , item_type, statu, session_no, item_discount, discount, disc, sales_no2, fixed_price, supplier
                                        , supplier_id, vatable,to.printing_assembly_id,to.printing_assembly_name,to.group_id,to.group_name);
                                datas.add(order);
                                tbl_sales_items_M.fireTableDataChanged();
                                Alert.set(0, "ORDER UPDATED");
                            }
                            compute();
                        }
                    });
                    nd.setLocationRelativeTo(this);

                    nd.setVisible(true);
                } else {
                    double qty = to2.product_qty + product_qty;
                    double disc = to2.discount_amount + discount_amount;
//                System.out.println("" + to2.discount_amount + " " + discount_amount);
                    double total = (qty * to2.selling_price) - disc;
//                System.out.println(qty + " " + to2.selling_price + " = " + " " + disc + " " + " " + total);
                    to2.setDiscount_amount(disc);
                    to2.setSales_no(FitIn.fmt_wc_0(total));
                    to2.setProduct_qty(qty);
                    tbl_sales_items_M.fireTableDataChanged();
                    Alert.set(0, "ORDER UPDATED");
                }
                break;
            } else {
                naa = 0;
            }
        }
        final double disc = discount_amount;
        if (naa == 0) {
            if (to.fixed_price == 0) {
                Window p = (Window) this;
                Dlg_fixed_price nd = Dlg_fixed_price.create(p, true);
                nd.setTitle("");
                nd.do_pass2(0, to.selling_price, to.description);
                nd.setCallback(new Dlg_fixed_price.Callback() {

                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_fixed_price.OutputData data) {
                        closeDialog.ok();
                        S1_sales_orders.to_sales_items order = new S1_sales_orders.to_sales_items(id, barcode, description, generic_name, category
                                , category_id, classification, classification_id, sub_classification, sub_classification_id, data.qty, unit
                                , conversion, data.price, date_added, user_name, item_type, statu, session_no, item_discount, discount
                                , disc, FitIn.
                                fmt_wc_0((data.qty * data.price) - disc), fixed_price, supplier, supplier_id, vatable,to.printing_assembly_id,to.printing_assembly_name,to.group_id,to.group_name);
                        datas.add(order);
                        tbl_sales_items_M.fireTableDataChanged();
                        Alert.set(0, "ORDER ADDED");
                    }
                });
                nd.setLocationRelativeTo(this);
                nd.setVisible(true);
            }

            if (to.multi_level_pricing == 1) {
                Window p = (Window) this;
                Dlg_multi_pricing nd = Dlg_multi_pricing.create(p, true);
                nd.setTitle("");
                nd.do_pass(to.multi, to.description);
                nd.setCallback(new Dlg_multi_pricing.Callback() {

                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_multi_pricing.OutputData data) {
                        closeDialog.ok();
                        S1_sales_orders.to_sales_items order = new S1_sales_orders.to_sales_items(id, barcode, description, generic_name
                                , category, category_id, classification, classification_id, sub_classification, sub_classification_id, data.qty, unit, data.conversion, data.price, date_added, user_name, item_type, statu, session_no, item_discount, discount, disc, FitIn.
                                fmt_wc_0((data.qty * data.price) - disc), fixed_price, supplier, supplier_id, vatable,to.printing_assembly_id,to.printing_assembly_name,to.group_id,to.group_name);
                        datas.add(order);
                        tbl_sales_items_M.fireTableDataChanged();
                        Alert.set(0, "ORDER ADDED");
                    }
                });
                nd.setLocationRelativeTo(this);
                nd.setVisible(true);

            }

            if (to.fixed_price == 1 && to.multi_level_pricing == 0) {
                S1_sales_orders.to_sales_items order = new S1_sales_orders.to_sales_items(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price,
                        date_added, user_name, item_type, statu, session_no, item_discount, discount, discount_amount
                        , sales_no, fixed_price, supplier, supplier_id, vatable,to.printing_assembly_id,to.printing_assembly_name,to.group_id,to.group_name);
                datas.add(order);
                tbl_sales_items_M.fireTableDataChanged();
                Alert.set(0, "ORDER ADDED");
            }
//            System.out.println(to.fixed_price + " ----------- " + to.multi_level_pricing);
        }
        tf_search.grabFocus();
        tf_search.selectAll();
//         int row = tbl_.getSelectedRow();
//        if (row < 0) {
//            return;
//        }
        tbl_items.removeRowSelectionInterval(row, row);
        compute();
    }

    private void delete_item() {
        int row = tbl_sales_items.getSelectedRow();
        if (row < 0) {
            return;
        }

        tbl_sales_items_ALM.remove(row);
        tbl_sales_items_M.fireTableDataChanged();
        compute();
    }

    private void compute() {
        List< S1_sales_orders.to_sales_items> datas = tbl_sales_items_ALM;
        double total = 0;
        for (S1_sales_orders.to_sales_items to2 : datas) {
            total += ((to2.product_qty * to2.selling_price) - to2.discount_amount);
        }
        lbl_total.setText(FitIn.fmt_wc_0(total));
    }

    private void settle() {
        if (tbl_sales_items_ALM.isEmpty()) {
            Alert.set(0, "NO ORDERS");
            return;
        }
        Window p = (Window) this;
        Dlg_pay nd = Dlg_pay.create(p, true);
        nd.setTitle("");
        String sales_no = lbl_trans_no.getText();
        double due = FitIn.toDouble(lbl_total.getText());
        nd.do_pass(sales_no, due);
        nd.setCallback(new Dlg_pay.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_pay.OutputData data) {
                closeDialog.ok();
                add_payment(data.to_sales, data.change,data.my_services);
            }
        });
        nd.setLocationRelativeTo(this);

        nd.setVisible(true);
    }

    private void add_payment(S1_sales.to_sales to, double change,List<S1_sales_services.to_sales_services> my_services) {

        List<S1_sales_orders.to_sales_items> datas = tbl_sales_items_ALM;
        List<S1_sales_items.to_sales_items> datas2 = new ArrayList();
        List<Srpt_receipt.field> fields = new ArrayList();
        int qty = 0;
        double vatable_sale = 0;
        double zero_rate_sale = 0;
        double vat_exempt_sale = 0;
        double vat_percent = 0;

        String customer_name=to.customer_name;
        String customer_id=to.customer_id;
        for (S1_sales_orders.to_sales_items to1 : datas) {
            int id = to1.id;
            String barcode = to1.barcode;
            String description = to1.description;
            String generic_name = to1.generic_name;
            String category = to1.category;
            String category_id = to1.category_id;
            String classification = to1.classification;
            String classification_id = to1.classification_id;
            String sub_classification = to1.sub_classification;
            String sub_classification_id = to1.sub_classification_id;
            double product_qty = to1.product_qty;
            qty += product_qty;
            String unit = to1.unit;
            double conversion = to1.conversion;
            double selling_price = to1.selling_price;
            String date_added = to1.date_added;
            String user_name = to1.user_name;
            String item_type = to1.item_type;
            int status = to1.status;
            String session_no = to1.session_no;
            String item_discount = to1.item_discount;
            double discount = to1.discount;
            double discount_amount = to1.discount_amount;
            String sales_no = to1.sales_no;
            String add = "";
            if (discount_amount > 0) {
                add = " - " + FitIn.fmt_wc_0(discount_amount) + " disc";
            }
            int fixed_price = to1.fixed_price;

            String supplier = to1.supplier;
            String supplier_id = to1.supplier_id;
            int vatable = to1.vatable;
            if (selling_price == 0) {
                zero_rate_sale++;
            }
            if (to1.vatable == 0) {
                vat_exempt_sale += product_qty * selling_price;
            } else {
                vatable_sale += product_qty * selling_price;
            }

            Srpt_receipt.field tbar = new Srpt_receipt.field(to1.description + add, new Date(), FitIn.
                    toDouble(to1.sales_no), to1.product_qty, to1.selling_price);
            fields.add(tbar);
            String or_no = to.sales_no;
            String printing_assembly_id=to1.printing_assembly_id;
            String printing_assembly_name=to1.printing_assembly_name;
            String group_id=to1.group_id;
            String group_name=to1.group_name;
            
            S1_sales_items.to_sales_items to3 = new S1_sales_items.to_sales_items(id, barcode, description
                    , generic_name, category, category_id, classification, classification_id, sub_classification
                    , sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name
                    , item_type, status, session_no, item_discount, discount, discount_amount, sales_no, fixed_price
                    , supplier, supplier_id, vatable, or_no,customer_name,customer_id
                    ,printing_assembly_id,printing_assembly_name,group_id,group_name,to.table_id,to.table_name,to.customer_ids
                    ,to.customer_names,to.waiter_id,to.waiter_name,"");
            datas2.add(to3);                   
        }


        vat_percent = vatable_sale / 9.333;
        vatable_sale = vatable_sale - vat_percent;
        String print = System.getProperty("print_to_receipts", "false");
        String business_name = System.getProperty("business_name", "Fortune Tree Enterprises");
        if (print.equals("true")) {
            String operated_by = System.getProperty("operated_by", "Ernesto C.QUiamco");
            String address = System.getProperty("address", "Door 2, H & J Ong bldg, Corner Colon & Sta Catalina Street Dumaguete City");
            String status = System.getProperty("status", "NV");
            String tin_no = System.getProperty("tin_no", "")+" "+status;
            String serial_no = System.getProperty("serial_no", "");
            String permit_no = System.getProperty("permit_no", "");
            String datetime = DateType.slash_w_time.format(new Date());
            String or_no = "OR NO. " + lbl_trans_no.getText();
            String items = System.getProperty("items", "");
            double total_due = FitIn.toDouble(lbl_total.getText());
            double cash = to.amount_paid;
            String check_bank = to.check_bank;
            double check_amount = to.check_amount;
            double change_due = change;
            System.out.println(change_due + " - - ");
            String receipt_infos = System.getProperty("receipt_infos", "");
            String receipt_footer = System.getProperty("receipt_footer", "This is not an Official Receipt ");
            double discount = to.discount_amount;
            
            String cashier_name = Users.user_name;
            String discount_name = to.discount_name;
            if (discount_name.equalsIgnoreCase("NO DISCOUNT")) {
                discount_name = "";
            }
            String pos_no = "POS 1";
            int total_qty = qty;

            String accreditation_no = System.getProperty("acct_no", "Accreditation No. 000-0000000000-000000");
            String trans_no = lbl_trans_no.getText();
            String telephone_number = System.getProperty("telephone_number", "please call:000-0000-00");
            String discount_customer_name = to.discount_customer_name;
//            System.out.println(discount_customer_name+ " asdasd");
            String discount_customer_id = to.discount_customer_id;
            discount_customer_name = discount_customer_name + " - " + discount_customer_id;
            String min_no = System.getProperty("min_no", "MIN NO: 130321854");
             
            double addtl_service=to.service_amount;
            Srpt_receipt rpt = new Srpt_receipt(business_name, operated_by, address, tin_no, serial_no, permit_no, datetime, or_no, items
                    , total_due, cash, change_due, receipt_infos, receipt_footer, discount, customer_name, cashier_name, discount_name
                    , pos_no, total_qty, vatable_sale, zero_rate_sale, vat_exempt_sale, vat_percent, accreditation_no, trans_no, check_bank
                    , check_amount, telephone_number, discount_customer_name, discount_customer_id,min_no,addtl_service);
            rpt.fields.addAll(fields);
            String l = "rpt_receipt.jrxml";
            JasperReport jasperReport = null;
            InputStream is = Srpt_receipt.class.getResourceAsStream(l);
            try {
                jasperReport = JasperCompileManager.compileReport(is);
                jasperPrint = JasperFillManager.fillReport(jasperReport, JasperUtil.
                        setParameter(rpt), JasperUtil.makeDatasource(rpt.fields));

                JasperPrintManager.printReport(jasperPrint, false);
            } catch (JRException ex) {
                Logger.getLogger(Dlg_sales.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        }

        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        S1_sales.add_sales(to);
        S1_sales_items.add_sales_items(datas2, to.sales_no);
        S1_sales_services.add_sales_services(my_services);
        tbl_sales_items_ALM.clear();
        tbl_sales_items_M.fireTableDataChanged();
        tf_search.grabFocus();
        tf_search.selectAll();
        lbl_total.setText("0.00");
        init_trans_no();
        data_cols();
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        set_change(change);

        if (pnl_search.isVisible()) {
            SwingUtilities.invokeLater(new Runnable() {

                public void run() {
                    tf_search1.grabFocus();
                    tf_search1.selectAll();
                }
            });

        } else {
            SwingUtilities.invokeLater(new Runnable() {

                public void run() {
                    tf_search.grabFocus();
                    tf_search.selectAll();
                }
            });
        }
//        Alert.set(0, "PAYMENT SUCCESSFUL");
    }

    private void set_change(double change) {
        Window p = (Window) this;
        Dlg_change nd = Dlg_change.create(p, true);
        nd.setTitle("");
        nd.do_pass(change);
        nd.setCallback(new Dlg_change.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_change.OutputData data) {
                closeDialog.ok();


            }
        });
        nd.setLocationRelativeTo(this);

        nd.setVisible(true);
    }
    JasperPrint jasperPrint = null;

    private void edit_order() {
        final int row = tbl_sales_items.getSelectedRow();
        if (row < 0) {
            return;
        }
        final S1_sales_orders.to_sales_items to = (S1_sales_orders.to_sales_items) tbl_sales_items_ALM.
                get(tbl_sales_items.convertRowIndexToModel(row));
        if (to.fixed_price == 0) {
            Window p = (Window) this;
            Dlg_qty_delete_fixed nd = Dlg_qty_delete_fixed.create(p, true);
            nd.setTitle("");
            nd.do_pass(to.product_qty, to.selling_price, to.description);
            nd.setCallback(new Dlg_qty_delete_fixed.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_qty_delete_fixed.OutputData data) {
                    closeDialog.ok();
                    to.setProduct_qty(data.qty);
                    to.setSelling_price(data.price);
                    to.setSales_no(FitIn.fmt_wc_0((data.price * data.qty) - to.discount_amount));
                    tbl_sales_items_M.fireTableDataChanged();
                    compute();
                    tf_search.selectAll();
                    tf_search.grabFocus();
                }

                @Override
                public void delete(CloseDialog closeDialog, Dlg_qty_delete_fixed.OutputData data) {
                    closeDialog.ok();
                    tbl_sales_items_ALM.remove(row);
                    tbl_sales_items_M.fireTableDataChanged();
                    compute();
                    tf_search.selectAll();
                    tf_search.grabFocus();
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        } else {
            Window p = (Window) this;
            Dlg_qty_delete nd = Dlg_qty_delete.create(p, true);
            nd.setTitle("");
            nd.do_pass(to.product_qty, to.selling_price, to.description);
            nd.setCallback(new Dlg_qty_delete.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_qty_delete.OutputData data) {
                    closeDialog.ok();
                    to.setProduct_qty(data.amount);
                    to.setSales_no(FitIn.fmt_wc_0((to.selling_price * data.amount) - to.discount_amount));
                    tbl_sales_items_M.fireTableDataChanged();
                    compute();
                    tf_search.selectAll();
                    tf_search.grabFocus();

                }

                @Override
                public void delete(CloseDialog closeDialog, Dlg_qty_delete.OutputData data) {
                    closeDialog.ok();
                    tbl_sales_items_ALM.remove(row);
                    tbl_sales_items_M.fireTableDataChanged();
                    compute();
                    tf_search.selectAll();
                    tf_search.grabFocus();
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }

    }
}
