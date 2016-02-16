/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen;

import POS.sales.S1_sales;
import POS.services.S1_services;
import POS.table_customer_discounts.S1_table_customer_discounts;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.Focus_Fire;
import POS.util.Users;
import java.awt.CardLayout;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import org.jdesktop.swingx.JXLabel;

/**
 *
 * @author Ronald
 */
public class Dlg_touchscreen_pay extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_touchscreen_pay
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

        public final S1_sales.to_sales to_sales;
        public final double change;

        public OutputData(S1_sales.to_sales to_sales, double change) {
            this.to_sales = to_sales;
            this.change = change;
        }

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_touchscreen_pay(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_touchscreen_pay(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_touchscreen_pay() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_touchscreen_pay myRef;

    private void setThisRef(Dlg_touchscreen_pay myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_touchscreen_pay> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_touchscreen_pay create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_touchscreen_pay create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_touchscreen_pay dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_pay((java.awt.Frame) parent, false);
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
            Dlg_touchscreen_pay dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_pay((java.awt.Dialog) parent, false);
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

        Dlg_touchscreen_pay dialog = Dlg_touchscreen_pay.create(new javax.swing.JFrame(), true);
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

        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        jXLabel14 = new org.jdesktop.swingx.JXLabel();
        jXLabel12 = new org.jdesktop.swingx.JXLabel();
        jXLabel13 = new org.jdesktop.swingx.JXLabel();
        jXLabel4 = new org.jdesktop.swingx.JXLabel();
        jXLabel25 = new org.jdesktop.swingx.JXLabel();
        jXLabel26 = new org.jdesktop.swingx.JXLabel();
        jXLabel27 = new org.jdesktop.swingx.JXLabel();
        jXLabel23 = new org.jdesktop.swingx.JXLabel();
        jXLabel22 = new org.jdesktop.swingx.JXLabel();
        jXLabel24 = new org.jdesktop.swingx.JXLabel();
        jXLabel31 = new org.jdesktop.swingx.JXLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_net_due = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jXLabel82 = new org.jdesktop.swingx.JXLabel();
        tf_cash_payment = new javax.swing.JTextField();
        jXLabel78 = new org.jdesktop.swingx.JXLabel();
        jXLabel79 = new org.jdesktop.swingx.JXLabel();
        jXLabel83 = new org.jdesktop.swingx.JXLabel();
        jPanel1 = new javax.swing.JPanel();
        pnl_cash = new javax.swing.JPanel();
        pnl_discount = new javax.swing.JPanel();
        jXLabel68 = new org.jdesktop.swingx.JXLabel();
        tf_discount_name = new javax.swing.JTextField();
        jXLabel70 = new org.jdesktop.swingx.JXLabel();
        tf_discount_id = new javax.swing.JTextField();
        tf_discount_amount = new javax.swing.JTextField();
        jXLabel76 = new org.jdesktop.swingx.JXLabel();
        tf_discount_customer_name = new javax.swing.JTextField();
        jXLabel77 = new org.jdesktop.swingx.JXLabel();
        tf_discount_address = new javax.swing.JTextField();
        tf_discount_rate = new javax.swing.JTextField();
        jXLabel71 = new org.jdesktop.swingx.JXLabel();
        pnl_credit_card = new javax.swing.JPanel();
        jXLabel66 = new org.jdesktop.swingx.JXLabel();
        tf_cc_card_type = new javax.swing.JTextField();
        tf_cc_card_no = new javax.swing.JTextField();
        jXLabel67 = new org.jdesktop.swingx.JXLabel();
        jXLabel72 = new org.jdesktop.swingx.JXLabel();
        tf_cc_card_holder = new javax.swing.JTextField();
        jXLabel73 = new org.jdesktop.swingx.JXLabel();
        tf_cc_approval_code = new javax.swing.JTextField();
        tf_credit_card_amount = new javax.swing.JTextField();
        tf_credit_card_rate = new javax.swing.JTextField();
        jXLabel74 = new org.jdesktop.swingx.JXLabel();
        pnl_gift_certificate = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tf_gift_certificate_details = new javax.swing.JTextArea();
        jXLabel75 = new org.jdesktop.swingx.JXLabel();
        jXLabel80 = new org.jdesktop.swingx.JXLabel();
        jLabel16 = new javax.swing.JLabel();
        lbl_gift_certificate = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jXLabel8 = new org.jdesktop.swingx.JXLabel();
        jXLabel11 = new org.jdesktop.swingx.JXLabel();
        jXLabel15 = new org.jdesktop.swingx.JXLabel();
        jXLabel9 = new org.jdesktop.swingx.JXLabel();
        jXLabel16 = new org.jdesktop.swingx.JXLabel();
        jXLabel17 = new org.jdesktop.swingx.JXLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(9, 79, 149));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

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

        jXLabel13.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel13.setText("6");
        jXLabel13.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel13.setOpaque(true);

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

        jXLabel27.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel27.setText(".");
        jXLabel27.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel27.setOpaque(true);
        jXLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel27MouseClicked(evt);
            }
        });

        jXLabel23.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel23.setText("3");
        jXLabel23.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel23.setOpaque(true);

        jXLabel22.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel22.setText("2");
        jXLabel22.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel22.setOpaque(true);

        jXLabel24.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel24.setText("1");
        jXLabel24.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel24.setOpaque(true);

        jXLabel31.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel31.setText("Ok");
        jXLabel31.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel31.setOpaque(true);
        jXLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel31MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jXLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jXLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jXLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jXLabel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jXLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addComponent(jXLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Net Due");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Cash");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Credit Card");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Change");

        lbl_net_due.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_net_due.setForeground(new java.awt.Color(255, 255, 255));
        lbl_net_due.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_net_due.setText("1,000.00");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("0.00");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("0.00");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("0.00");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Amount Due");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("1,000.00");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Discount");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("0.00");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons/check-mark-16.png"))); // NOI18N
        jLabel1.setOpaque(true);

        jXLabel82.setBackground(new java.awt.Color(157, 122, 67));
        jXLabel82.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel82.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXLabel82.setText("    Cash");
        jXLabel82.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jXLabel82.setOpaque(true);
        jXLabel82.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel82MouseClicked(evt);
            }
        });

        tf_cash_payment.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        tf_cash_payment.setBorder(null);
        tf_cash_payment.setMargin(new java.awt.Insets(2, 10, 2, 2));
        tf_cash_payment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_cash_paymentMouseClicked(evt);
            }
        });
        tf_cash_payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_cash_paymentActionPerformed(evt);
            }
        });
        tf_cash_payment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_cash_paymentKeyReleased(evt);
            }
        });

        jXLabel78.setBackground(new java.awt.Color(157, 122, 67));
        jXLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel78.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXLabel78.setText("    Discount");
        jXLabel78.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jXLabel78.setOpaque(true);
        jXLabel78.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel78MouseClicked(evt);
            }
        });

        jXLabel79.setBackground(new java.awt.Color(157, 122, 67));
        jXLabel79.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel79.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXLabel79.setText("    Credit Card");
        jXLabel79.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jXLabel79.setOpaque(true);
        jXLabel79.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel79MouseClicked(evt);
            }
        });

        jXLabel83.setBackground(new java.awt.Color(157, 122, 67));
        jXLabel83.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel83.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXLabel83.setText("    Close");
        jXLabel83.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jXLabel83.setOpaque(true);
        jXLabel83.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel83MouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.CardLayout());

        pnl_cash.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_cashLayout = new javax.swing.GroupLayout(pnl_cash);
        pnl_cash.setLayout(pnl_cashLayout);
        pnl_cashLayout.setHorizontalGroup(
            pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 421, Short.MAX_VALUE)
        );
        pnl_cashLayout.setVerticalGroup(
            pnl_cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 185, Short.MAX_VALUE)
        );

        jPanel1.add(pnl_cash, "card4");

        jXLabel68.setBackground(new java.awt.Color(176, 138, 75));
        jXLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel68.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jXLabel68.setText("    Discount   ");
        jXLabel68.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jXLabel68.setOpaque(true);
        jXLabel68.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel68MouseClicked(evt);
            }
        });

        tf_discount_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_discount_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_discount_name.setBorder(null);
        tf_discount_name.setMargin(new java.awt.Insets(2, 10, 2, 2));
        tf_discount_name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_discount_nameMouseClicked(evt);
            }
        });

        jXLabel70.setBackground(new java.awt.Color(176, 138, 75));
        jXLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel70.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jXLabel70.setText("    ID #   ");
        jXLabel70.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jXLabel70.setOpaque(true);
        jXLabel70.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel70MouseClicked(evt);
            }
        });

        tf_discount_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_discount_id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_discount_id.setBorder(null);
        tf_discount_id.setMargin(new java.awt.Insets(2, 10, 2, 2));
        tf_discount_id.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_discount_idMouseClicked(evt);
            }
        });

        tf_discount_amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_discount_amount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_discount_amount.setText("0.00");
        tf_discount_amount.setBorder(null);
        tf_discount_amount.setMargin(new java.awt.Insets(2, 10, 2, 2));
        tf_discount_amount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_discount_amountMouseClicked(evt);
            }
        });
        tf_discount_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_discount_amountActionPerformed(evt);
            }
        });

        jXLabel76.setBackground(new java.awt.Color(176, 138, 75));
        jXLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel76.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jXLabel76.setText("    Name   ");
        jXLabel76.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jXLabel76.setOpaque(true);
        jXLabel76.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel76MouseClicked(evt);
            }
        });

        tf_discount_customer_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_discount_customer_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_discount_customer_name.setBorder(null);
        tf_discount_customer_name.setMargin(new java.awt.Insets(2, 10, 2, 2));
        tf_discount_customer_name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_discount_customer_nameMouseClicked(evt);
            }
        });

        jXLabel77.setBackground(new java.awt.Color(176, 138, 75));
        jXLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel77.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jXLabel77.setText("    Address   ");
        jXLabel77.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jXLabel77.setOpaque(true);
        jXLabel77.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel77MouseClicked(evt);
            }
        });

        tf_discount_address.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_discount_address.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_discount_address.setBorder(null);
        tf_discount_address.setMargin(new java.awt.Insets(2, 10, 2, 2));
        tf_discount_address.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_discount_addressMouseClicked(evt);
            }
        });

        tf_discount_rate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_discount_rate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_discount_rate.setText("0.00");
        tf_discount_rate.setBorder(null);
        tf_discount_rate.setMargin(new java.awt.Insets(2, 10, 2, 2));
        tf_discount_rate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_discount_rateMouseClicked(evt);
            }
        });

        jXLabel71.setBackground(new java.awt.Color(255, 255, 255));
        jXLabel71.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel71.setText("%");
        jXLabel71.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jXLabel71.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jXLabel71.setOpaque(true);
        jXLabel71.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel71MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnl_discountLayout = new javax.swing.GroupLayout(pnl_discount);
        pnl_discount.setLayout(pnl_discountLayout);
        pnl_discountLayout.setHorizontalGroup(
            pnl_discountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_discountLayout.createSequentialGroup()
                .addGroup(pnl_discountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jXLabel76, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel70, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(pnl_discountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_discountLayout.createSequentialGroup()
                        .addComponent(tf_discount_name, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(tf_discount_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(tf_discount_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tf_discount_id)
                    .addComponent(tf_discount_customer_name)
                    .addComponent(tf_discount_address)))
        );
        pnl_discountLayout.setVerticalGroup(
            pnl_discountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_discountLayout.createSequentialGroup()
                .addGroup(pnl_discountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel71, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_discount_rate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_discount_name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel68, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_discount_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnl_discountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_discount_id, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnl_discountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_discount_customer_name, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnl_discountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_discount_address, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.add(pnl_discount, "card3");

        jXLabel66.setBackground(new java.awt.Color(176, 138, 75));
        jXLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel66.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jXLabel66.setText("    Card Type  ");
        jXLabel66.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jXLabel66.setOpaque(true);
        jXLabel66.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel66MouseClicked(evt);
            }
        });

        tf_cc_card_type.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cc_card_type.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_cc_card_type.setBorder(null);
        tf_cc_card_type.setMargin(new java.awt.Insets(2, 10, 2, 2));
        tf_cc_card_type.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_cc_card_typeMouseClicked(evt);
            }
        });
        tf_cc_card_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_cc_card_typeActionPerformed(evt);
            }
        });

        tf_cc_card_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cc_card_no.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_cc_card_no.setBorder(null);
        tf_cc_card_no.setMargin(new java.awt.Insets(2, 10, 2, 2));
        tf_cc_card_no.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_cc_card_noMouseClicked(evt);
            }
        });

        jXLabel67.setBackground(new java.awt.Color(176, 138, 75));
        jXLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel67.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jXLabel67.setText("    Card #   ");
        jXLabel67.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jXLabel67.setOpaque(true);
        jXLabel67.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel67MouseClicked(evt);
            }
        });

        jXLabel72.setBackground(new java.awt.Color(176, 138, 75));
        jXLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel72.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jXLabel72.setText("    Card Holder   ");
        jXLabel72.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jXLabel72.setOpaque(true);
        jXLabel72.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel72MouseClicked(evt);
            }
        });

        tf_cc_card_holder.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cc_card_holder.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_cc_card_holder.setBorder(null);
        tf_cc_card_holder.setMargin(new java.awt.Insets(2, 10, 2, 2));
        tf_cc_card_holder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_cc_card_holderMouseClicked(evt);
            }
        });

        jXLabel73.setBackground(new java.awt.Color(176, 138, 75));
        jXLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel73.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jXLabel73.setText("    Approval Code   ");
        jXLabel73.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jXLabel73.setOpaque(true);
        jXLabel73.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel73MouseClicked(evt);
            }
        });

        tf_cc_approval_code.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cc_approval_code.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_cc_approval_code.setBorder(null);
        tf_cc_approval_code.setMargin(new java.awt.Insets(2, 10, 2, 2));
        tf_cc_approval_code.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_cc_approval_codeMouseClicked(evt);
            }
        });

        tf_credit_card_amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_credit_card_amount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_credit_card_amount.setText("0.00");
        tf_credit_card_amount.setBorder(null);
        tf_credit_card_amount.setMargin(new java.awt.Insets(2, 10, 2, 2));
        tf_credit_card_amount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_credit_card_amountMouseClicked(evt);
            }
        });

        tf_credit_card_rate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_credit_card_rate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_credit_card_rate.setText("0.00");
        tf_credit_card_rate.setBorder(null);
        tf_credit_card_rate.setMargin(new java.awt.Insets(2, 10, 2, 2));
        tf_credit_card_rate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_credit_card_rateMouseClicked(evt);
            }
        });

        jXLabel74.setBackground(new java.awt.Color(255, 255, 255));
        jXLabel74.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel74.setText("%");
        jXLabel74.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jXLabel74.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jXLabel74.setOpaque(true);
        jXLabel74.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel74MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnl_credit_cardLayout = new javax.swing.GroupLayout(pnl_credit_card);
        pnl_credit_card.setLayout(pnl_credit_cardLayout);
        pnl_credit_cardLayout.setHorizontalGroup(
            pnl_credit_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_credit_cardLayout.createSequentialGroup()
                .addGroup(pnl_credit_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(pnl_credit_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_cc_card_no, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_credit_cardLayout.createSequentialGroup()
                        .addComponent(tf_cc_card_type, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(tf_credit_card_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(tf_credit_card_amount, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addComponent(tf_cc_approval_code, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tf_cc_card_holder)))
        );
        pnl_credit_cardLayout.setVerticalGroup(
            pnl_credit_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_credit_cardLayout.createSequentialGroup()
                .addGroup(pnl_credit_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_credit_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tf_cc_card_type, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel66, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_credit_card_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_credit_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jXLabel74, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_credit_card_rate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(pnl_credit_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_cc_card_no, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnl_credit_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_cc_card_holder, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnl_credit_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_cc_approval_code, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.add(pnl_credit_card, "card2");

        tf_gift_certificate_details.setColumns(20);
        tf_gift_certificate_details.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_gift_certificate_details.setRows(5);
        jScrollPane1.setViewportView(tf_gift_certificate_details);

        jXLabel75.setBackground(new java.awt.Color(255, 255, 255));
        jXLabel75.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXLabel75.setText("  Details:");
        jXLabel75.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jXLabel75.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jXLabel75.setOpaque(true);
        jXLabel75.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel75MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnl_gift_certificateLayout = new javax.swing.GroupLayout(pnl_gift_certificate);
        pnl_gift_certificate.setLayout(pnl_gift_certificateLayout);
        pnl_gift_certificateLayout.setHorizontalGroup(
            pnl_gift_certificateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
            .addComponent(jXLabel75, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_gift_certificateLayout.setVerticalGroup(
            pnl_gift_certificateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_gift_certificateLayout.createSequentialGroup()
                .addComponent(jXLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
        );

        jPanel1.add(pnl_gift_certificate, "card5");

        jXLabel80.setBackground(new java.awt.Color(157, 122, 67));
        jXLabel80.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel80.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXLabel80.setText("Gift Ceftificate");
        jXLabel80.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jXLabel80.setOpaque(true);
        jXLabel80.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel80MouseClicked(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Gift Certificate");

        lbl_gift_certificate.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl_gift_certificate.setForeground(new java.awt.Color(255, 255, 255));
        lbl_gift_certificate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_gift_certificate.setText("0.00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(227, 227, 227)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_net_due, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_gift_certificate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(227, 227, 227)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jXLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(tf_cash_payment)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jXLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jXLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jXLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel80, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(1, 1, 1)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_gift_certificate)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_net_due, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jXLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_cash_payment, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jXLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel80, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel3.setBackground(new java.awt.Color(249, 154, 4));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons/money-bag-48.png"))); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Payment");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addContainerGap(108, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );

        jXLabel8.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel8.setText("100");
        jXLabel8.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel8.setOpaque(true);
        jXLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel8MouseClicked(evt);
            }
        });

        jXLabel11.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel11.setText("50");
        jXLabel11.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel11.setOpaque(true);
        jXLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel11MouseClicked(evt);
            }
        });

        jXLabel15.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel15.setText("20");
        jXLabel15.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel15.setOpaque(true);
        jXLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel15MouseClicked(evt);
            }
        });

        jXLabel9.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel9.setText("200");
        jXLabel9.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel9.setOpaque(true);
        jXLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel9MouseClicked(evt);
            }
        });

        jXLabel16.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel16.setText("1000");
        jXLabel16.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel16.setOpaque(true);
        jXLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel16MouseClicked(evt);
            }
        });

        jXLabel17.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel17.setText("500");
        jXLabel17.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel17.setOpaque(true);
        jXLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel17MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jXLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(1, 1, 1)
                                .addComponent(jXLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(1, 1, 1)
                                .addComponent(jXLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jXLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jXLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jXLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jXLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jXLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jXLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jXLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(382, 382, 382)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jXLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel2MouseClicked

    }//GEN-LAST:event_jXLabel2MouseClicked

    private void jXLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel26MouseClicked
        if (tf_cash_payment.hasFocus()) {
            tf_cash_payment.setText("");
        } else {
//            tf_waiter4.setText("");
        }
    }//GEN-LAST:event_jXLabel26MouseClicked

    private void jXLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel27MouseClicked

    }//GEN-LAST:event_jXLabel27MouseClicked

    private void jXLabel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel31MouseClicked
        ok();
    }//GEN-LAST:event_jXLabel31MouseClicked

    private void jXLabel68MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel68MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel68MouseClicked

    private void tf_discount_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_discount_nameMouseClicked
        discounts();
    }//GEN-LAST:event_tf_discount_nameMouseClicked

    private void jXLabel70MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel70MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel70MouseClicked

    private void tf_discount_idMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_discount_idMouseClicked
        search_item(tf_discount_id);
    }//GEN-LAST:event_tf_discount_idMouseClicked

    private void tf_discount_amountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_discount_amountMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_discount_amountMouseClicked

    private void jXLabel76MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel76MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel76MouseClicked

    private void tf_discount_customer_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_discount_customer_nameMouseClicked
        search_item(tf_discount_customer_name);
    }//GEN-LAST:event_tf_discount_customer_nameMouseClicked

    private void jXLabel77MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel77MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel77MouseClicked

    private void tf_discount_addressMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_discount_addressMouseClicked
        search_item(tf_discount_address);
    }//GEN-LAST:event_tf_discount_addressMouseClicked

    private void tf_discount_rateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_discount_rateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_discount_rateMouseClicked

    private void jXLabel71MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel71MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel71MouseClicked

    private void jXLabel66MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel66MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel66MouseClicked

    private void tf_cc_card_typeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_cc_card_typeMouseClicked
        credit_card();
    }//GEN-LAST:event_tf_cc_card_typeMouseClicked

    private void tf_cc_card_noMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_cc_card_noMouseClicked
        search_item(tf_cc_card_no);
    }//GEN-LAST:event_tf_cc_card_noMouseClicked

    private void jXLabel67MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel67MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel67MouseClicked

    private void jXLabel72MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel72MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel72MouseClicked

    private void tf_cc_card_holderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_cc_card_holderMouseClicked
        search_item(tf_cc_card_holder);
    }//GEN-LAST:event_tf_cc_card_holderMouseClicked

    private void jXLabel73MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel73MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel73MouseClicked

    private void tf_cc_approval_codeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_cc_approval_codeMouseClicked
        search_item(tf_cc_approval_code);
    }//GEN-LAST:event_tf_cc_approval_codeMouseClicked

    private void tf_credit_card_amountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_credit_card_amountMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_credit_card_amountMouseClicked

    private void jXLabel78MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel78MouseClicked
        cardLayout.show(jPanel1, "1");
        tf_cash_payment.setText("");
        menu = 1;
    }//GEN-LAST:event_jXLabel78MouseClicked

    private void jXLabel79MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel79MouseClicked
        cardLayout.show(jPanel1, "2");
        tf_cash_payment.setText("");
        menu = 2;
    }//GEN-LAST:event_jXLabel79MouseClicked

    private void tf_cc_card_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cc_card_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_cc_card_typeActionPerformed

    private void jXLabel82MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel82MouseClicked
        cardLayout.show(jPanel1, "3");
        double cash = FitIn.toDouble(jLabel7.getText());
        if (cash != 0) {
            tf_cash_payment.setText(jLabel7.getText());
        }

        menu = 0;
    }//GEN-LAST:event_jXLabel82MouseClicked

    private void tf_cash_paymentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_cash_paymentMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_cash_paymentMouseClicked

    private void tf_cash_paymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cash_paymentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_cash_paymentActionPerformed

    private void jXLabel83MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel83MouseClicked
        disposed();
    }//GEN-LAST:event_jXLabel83MouseClicked

    private void tf_credit_card_rateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_credit_card_rateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_credit_card_rateMouseClicked

    private void jXLabel74MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel74MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel74MouseClicked

    private void tf_discount_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_discount_amountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_discount_amountActionPerformed

    private void jXLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel8MouseClicked

    private void jXLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel11MouseClicked

    private void jXLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel15MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel15MouseClicked

    private void jXLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel9MouseClicked

    private void jXLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel16MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel16MouseClicked

    private void jXLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel17MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel17MouseClicked

    private void jXLabel75MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel75MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel75MouseClicked

    private void jXLabel80MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel80MouseClicked
        cardLayout.show(jPanel1, "4");
        tf_gift_certificate_details.setText("");
        menu = 4;
    }//GEN-LAST:event_jXLabel80MouseClicked

    private void tf_cash_paymentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_cash_paymentKeyReleased
        // TODO add your handling code here:
         payment_type();
    }//GEN-LAST:event_tf_cash_paymentKeyReleased

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXLabel jXLabel11;
    private org.jdesktop.swingx.JXLabel jXLabel12;
    private org.jdesktop.swingx.JXLabel jXLabel13;
    private org.jdesktop.swingx.JXLabel jXLabel14;
    private org.jdesktop.swingx.JXLabel jXLabel15;
    private org.jdesktop.swingx.JXLabel jXLabel16;
    private org.jdesktop.swingx.JXLabel jXLabel17;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXLabel jXLabel22;
    private org.jdesktop.swingx.JXLabel jXLabel23;
    private org.jdesktop.swingx.JXLabel jXLabel24;
    private org.jdesktop.swingx.JXLabel jXLabel25;
    private org.jdesktop.swingx.JXLabel jXLabel26;
    private org.jdesktop.swingx.JXLabel jXLabel27;
    private org.jdesktop.swingx.JXLabel jXLabel3;
    private org.jdesktop.swingx.JXLabel jXLabel31;
    private org.jdesktop.swingx.JXLabel jXLabel4;
    private org.jdesktop.swingx.JXLabel jXLabel66;
    private org.jdesktop.swingx.JXLabel jXLabel67;
    private org.jdesktop.swingx.JXLabel jXLabel68;
    private org.jdesktop.swingx.JXLabel jXLabel70;
    private org.jdesktop.swingx.JXLabel jXLabel71;
    private org.jdesktop.swingx.JXLabel jXLabel72;
    private org.jdesktop.swingx.JXLabel jXLabel73;
    private org.jdesktop.swingx.JXLabel jXLabel74;
    private org.jdesktop.swingx.JXLabel jXLabel75;
    private org.jdesktop.swingx.JXLabel jXLabel76;
    private org.jdesktop.swingx.JXLabel jXLabel77;
    private org.jdesktop.swingx.JXLabel jXLabel78;
    private org.jdesktop.swingx.JXLabel jXLabel79;
    private org.jdesktop.swingx.JXLabel jXLabel8;
    private org.jdesktop.swingx.JXLabel jXLabel80;
    private org.jdesktop.swingx.JXLabel jXLabel82;
    private org.jdesktop.swingx.JXLabel jXLabel83;
    private org.jdesktop.swingx.JXLabel jXLabel9;
    private javax.swing.JLabel lbl_gift_certificate;
    private javax.swing.JLabel lbl_net_due;
    private javax.swing.JPanel pnl_cash;
    private javax.swing.JPanel pnl_credit_card;
    private javax.swing.JPanel pnl_discount;
    private javax.swing.JPanel pnl_gift_certificate;
    private javax.swing.JTextField tf_cash_payment;
    private javax.swing.JTextField tf_cc_approval_code;
    private javax.swing.JTextField tf_cc_card_holder;
    private javax.swing.JTextField tf_cc_card_no;
    private javax.swing.JTextField tf_cc_card_type;
    private javax.swing.JTextField tf_credit_card_amount;
    private javax.swing.JTextField tf_credit_card_rate;
    private javax.swing.JTextField tf_discount_address;
    private javax.swing.JTextField tf_discount_amount;
    private javax.swing.JTextField tf_discount_customer_name;
    private javax.swing.JTextField tf_discount_id;
    private javax.swing.JTextField tf_discount_name;
    private javax.swing.JTextField tf_discount_rate;
    private javax.swing.JTextArea tf_gift_certificate_details;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
        init_key();

        Border empty = new EmptyBorder(0, 20, 0, 0);
        CompoundBorder border = new CompoundBorder(null, empty);
        tf_cash_payment.setBorder(border);
        type();

        tf_cc_card_type.enable(false);
        tf_discount_name.enable(false);
        tf_cc_card_no.enable(false);
        tf_cc_card_holder.enable(false);
        tf_cc_approval_code.enable(false);

        tf_discount_id.enable(false);
        tf_discount_customer_name.enable(false);
        tf_discount_address.enable(false);

        tf_cc_card_no.enable(false);
        tf_cc_card_holder.enable(false);
        tf_cc_approval_code.enable(false);
//        tf_waiter2.enable(false);

        set_card_items();
        focus();
    }

    private void focus() {
        JTextField[] tf = {tf_cash_payment, tf_discount_amount};
        Focus_Fire.onFocus_lostFocus(tf);
        Focus_Fire.select_all(tf);
    }

    CardLayout cardLayout = new CardLayout();

    private void set_card_items() {
        cardLayout = (CardLayout) jPanel1.getLayout();
        cardLayout.addLayoutComponent("1", pnl_discount);
        cardLayout.addLayoutComponent("2", pnl_credit_card);
        cardLayout.addLayoutComponent("3", pnl_cash);
        cardLayout.addLayoutComponent("4", pnl_gift_certificate);
    }

    int menu = 0;

    private void type() {

        JXLabel[] lbl = {
            jXLabel2, jXLabel3, jXLabel4, jXLabel25, jXLabel12, jXLabel14, jXLabel13, jXLabel24, jXLabel22, jXLabel23, jXLabel26, jXLabel27};
        for (final JXLabel l : lbl) {
            l.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    if (menu == 0) {

                        if (l.getText().equalsIgnoreCase("Cl")) {
                            tf_cash_payment.setText("");
                            jLabel7.setText("0.00");
                            compute_change();
                        } else {
                            String text = tf_cash_payment.getText();
                            text = text + l.getText();
                            tf_cash_payment.setText(text);
                            jLabel7.setText(FitIn.fmt_wc_0(FitIn.toDouble(text)));
                            compute_change();
                        }
                    }

                    if (menu == 2) {
                        if (l.getText().equalsIgnoreCase("Cl")) {
                            tf_cash_payment.setText("");
                            jLabel8.setText("0.00");
                            tf_credit_card_amount.setText("0.00");
                            tf_credit_card_rate.setText("0.00");
                            compute_change();
                        } else {
                            String text = tf_cash_payment.getText();
                            text = text + l.getText();
                            tf_cash_payment.setText(text);
                            double credit_amount = FitIn.toDouble(text);
                            double credit_rate = FitIn.toDouble(tf_credit_card_rate.getText());
                            double total = credit_rate / 100;
                            total = credit_amount * total;
                            double total2 = FitIn.toDouble(text);

                            total = credit_amount + total;
                            tf_credit_card_amount.setText(FitIn.fmt_wc_0(total));
                            jLabel8.setText(FitIn.fmt_wc_0(total2));
                            compute_change();
                        }

                    }

                    if (menu == 4) {
                        if (l.getText().equalsIgnoreCase("Cl")) {

                            lbl_gift_certificate.setText("0.00");
                            tf_gift_certificate_details.setText("");
                            compute_change();
                        } else {
                            String text = tf_cash_payment.getText();
                            text = text + l.getText();
                            tf_cash_payment.setText(text);
                            double am = FitIn.toDouble(tf_cash_payment.getText());
                            lbl_gift_certificate.setText(FitIn.fmt_wc_0(am));

                            compute_change();
                        }

                    }

                    if (tf_discount_amount.hasFocus()) {
                        if (l.getText().equalsIgnoreCase("Cl")) {
                            String txt = tf_discount_amount.getText();
                            if (!txt.isEmpty()) {
                                txt = txt.substring(0, txt.length() - 1);
                                tf_discount_amount.setText(txt);

                                double amount_due = FitIn.toDouble(jLabel11.getText());
                                double total = amount_due - FitIn.toDouble(tf_discount_amount.getText());

                                jLabel13.setText(FitIn.fmt_wc_0(FitIn.toDouble(tf_discount_amount.getText())));

                                double net_due = amount_due - total;
                                lbl_net_due.setText(FitIn.fmt_wc_0(total));
                                compute_change();
                            }
                        } else {
                            String text = tf_discount_amount.getText();
                            text = text + l.getText();
                            tf_discount_amount.setText(text);
                            double amount_due = FitIn.toDouble(jLabel11.getText());
                            double total = amount_due - FitIn.toDouble(tf_discount_amount.getText());
                            jLabel13.setText(FitIn.fmt_wc_0(FitIn.toDouble(tf_discount_amount.getText())));
                            double net_due = amount_due - total;
                            lbl_net_due.setText(FitIn.fmt_wc_0(total));
                            compute_change();
                        }

                    }
                }
            });
        }

        JXLabel[] lbl2 = {jXLabel9, jXLabel17, jXLabel16, jXLabel8, jXLabel11, jXLabel15};
        for (final JXLabel l : lbl2) {
            l.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    if (menu == 0) {
                        if (l.getText().equalsIgnoreCase("Cl")) {
                            tf_cash_payment.setText("");
                            jLabel7.setText("0.00");
                            compute_change();
                        } else {
                            String text = l.getText();
                            double c = FitIn.toDouble(jLabel7.getText());
                            double d = FitIn.toDouble(text);
                            double all = c + d;
                            tf_cash_payment.setText(FitIn.fmt_wc_0(all));
                            jLabel7.setText(FitIn.fmt_wc_0(all));
                            compute_change();
                        }
                    }

                    if (menu == 2) {
                        if (l.getText().equalsIgnoreCase("Cl")) {
                            tf_cash_payment.setText("");
                            jLabel8.setText("0.00");
                            tf_credit_card_amount.setText("0.00");
                            tf_credit_card_rate.setText("0.00");
                            compute_change();
                        } else {
                            String text = l.getText();
                            double c = FitIn.toDouble(jLabel8.getText());
                            double d = FitIn.toDouble(text);
                            double all = c + d;

                            tf_cash_payment.setText(FitIn.fmt_wc_0(all));
                            jLabel8.setText(FitIn.fmt_wc_0(all));

                            double credit_amount = all;
                            double credit_rate = FitIn.toDouble(tf_credit_card_rate.getText());
                            double total = credit_rate / 100;
                            total = credit_amount * total;
                            double total2 = FitIn.toDouble(text);

                            total = credit_amount + total;
                            tf_credit_card_amount.setText(FitIn.fmt_wc_0(total));

                            compute_change();
                        }

                    }

                    if (menu == 4) {
                        if (l.getText().equalsIgnoreCase("Cl")) {
                            tf_cash_payment.setText("");
                            lbl_gift_certificate.setText("0.00");

                            compute_change();
                        } else {
                            String text = l.getText();
                            double c = FitIn.toDouble(lbl_gift_certificate.getText());
                            double d = FitIn.toDouble(text);
                            double all = c + d;

                            tf_cash_payment.setText(FitIn.fmt_wc_0(all));
                            lbl_gift_certificate.setText(FitIn.fmt_wc_0(all));
                            compute_change();
                        }

                    }
                    if (tf_discount_amount.hasFocus()) {
                        if (l.getText().equalsIgnoreCase("Cl")) {
                            String txt = tf_discount_amount.getText();
                            if (!txt.isEmpty()) {
                                txt = txt.substring(0, txt.length() - 1);
                                tf_discount_amount.setText(txt);

                                double amount_due = FitIn.toDouble(jLabel11.getText());
                                double total = amount_due - FitIn.toDouble(tf_discount_amount.getText());

                                jLabel13.setText(FitIn.fmt_wc_0(FitIn.toDouble(tf_discount_amount.getText())));

                                double net_due = amount_due - total;
                                lbl_net_due.setText(FitIn.fmt_wc_0(total));
                                compute_change();
                            }
                        } else {
                            String text = l.getText();

                            double c = FitIn.toDouble(jLabel13.getText());
                            double d = FitIn.toDouble(text);
                            double all = c + d;

                            tf_discount_amount.setText(FitIn.fmt_wc_0(all));
                            double amount_due = FitIn.toDouble(jLabel11.getText());
                            double total = amount_due - FitIn.toDouble(tf_discount_amount.getText());
                            jLabel13.setText(FitIn.fmt_wc_0(FitIn.toDouble(tf_discount_amount.getText())));
                            double net_due = amount_due - total;
                            lbl_net_due.setText(FitIn.fmt_wc_0(total));
                            compute_change();
                        }

                    }
                }

            });

        }
    }

    String sales_no1 = "";
    double amount_due1 = 0;

    String table_id = "";
    String table_name = "";
    String customer_ids = "";
    String customer_names = "";
    String waiter_id = "";
    String waiter_name = "";

    public void do_pass(String sales_no, double amount_due, String table_id1, String table_name1, String customer_ids1, String customer_names1, String waiter_id1, String waiter_name1, S1_table_customer_discounts.to_table_customer_discounts disc) {

        menu = 0;
        tf_cash_payment.setText("");
        tf_cc_card_type.setText("");
        tf_credit_card_rate.setText("0.00");
        tf_credit_card_amount.setText("0.00");
        tf_cc_card_no.setText("");
        tf_cc_card_holder.setText("");
        tf_cc_approval_code.setText("");

        sales_no1 = sales_no;
        table_id = table_id1;
        table_name = table_name1;
        customer_ids = customer_ids1;
        customer_names = customer_names1;
        waiter_id = waiter_id1;
        waiter_name = waiter_name1;
        jLabel11.setText(FitIn.fmt_wc_0(amount_due));
        lbl_net_due.setText(FitIn.fmt_wc_0(amount_due));

        tf_discount_name.setText(disc.discount_name);
        tf_discount_rate.setText(FitIn.fmt_wc_0(disc.discount_rate));
        tf_discount_amount.setText(FitIn.fmt_wc_0(disc.discount_amount));
        jLabel13.setText(FitIn.fmt_wc_0(disc.discount_amount));
        tf_discount_id.setText(disc.discount_customer_no);
        tf_discount_customer_name.setText(disc.discount_customer_name);
        tf_discount_address.setText(disc.discount_customer_address);

        String text = tf_discount_amount.getText();
        double amount_due2 = FitIn.toDouble(jLabel11.getText());
        double total = amount_due2 - FitIn.toDouble(tf_discount_amount.getText());
        double net_due = amount_due2 - total;
        lbl_net_due.setText(FitIn.fmt_wc_0(total));
        compute_change();

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

    private void ok() {

        double change2 = FitIn.toDouble(jLabel9.getText());
        if (change2 < 0) {
            Alert.set(0, "Amount Not Enough");
            return;
        }
        if (callback != null) {

            int id = -1;
            String sales_no = sales_no1;
            String date_added = DateType.datetime.format(new Date());
            String user_name = Users.user_name;
            String session_no = Users.session_no;
            double gross_amount = amount_due1;

            double cash = FitIn.toDouble(jLabel7.getText());
            double disc = FitIn.toDouble(jLabel13.getText());
            double credit = FitIn.toDouble(jLabel8.getText());
            double amount_paid = cash + disc + credit;

            double amount_due = FitIn.toDouble(jLabel11.getText());
            String discount_name = tf_discount_name.getText();
            if (discount_name.isEmpty()) {
                discount_name = "NO DISCOUNT";
            }
            double discount = FitIn.toDouble(tf_discount_rate.getText());
            double discount_amount = FitIn.toDouble(tf_discount_amount.getText());
            double change = FitIn.toDouble(jLabel9.getText());
            if (change < 0) {
                Alert.set(0, "KULANG");
                return;
            }

            String customer = tf_discount_address.getText();
            String customer_id = "";
            String discount_customer_name = tf_discount_customer_name.getText();
            String discount_customer_id = tf_discount_id.getText();
            String check_holder = "";
            String check_no = "";

            String check_bank = "";

            double check_amount = 0;
            if (check_bank.isEmpty()) {
                check_amount = 0;
            }

            int status = 0;
            String or_no = sales_no;
            String serv = "";
            double service_amount = 0;
            List<S1_services.to_services> service = new ArrayList();

            String credit_card_type = tf_cc_card_type.getText();
            double credit_card_rate = FitIn.toDouble(tf_credit_card_rate.getText());
            String credit_card_no = tf_cc_card_no.getText();
            String credit_card_holder = tf_cc_card_holder.getText();
            String credit_card_approval_code = tf_cc_approval_code.getText();
            double credit_card_amount = FitIn.toDouble(jLabel8.getText());
            double cash2 = FitIn.toDouble(jLabel8.getText());
            double gift_certificate_amount = FitIn.toDouble(lbl_gift_certificate.getText());
            String gift_certificate_details = tf_gift_certificate_details.getText();
            S1_sales.to_sales to = new S1_sales.to_sales(id, sales_no, date_added, user_name, session_no, gross_amount, amount_paid, amount_due, discount_name, discount, discount_amount, customer, check_bank, check_no, check_amount, discount_customer_name, discount_customer_id, status, or_no, check_holder, serv, service_amount, customer_id, table_id, table_name, customer_ids, customer_names, waiter_id, waiter_name, credit_card_type, credit_card_rate, credit_card_no, credit_card_holder, credit_card_approval_code, credit_card_amount, cash, gift_certificate_amount, gift_certificate_details);

            callback.ok(new CloseDialog(this), new OutputData(to, change));
        }
    }

    private void discounts() {
        Window p = (Window) this;
        Dlg_touchscreen_discounts nd = Dlg_touchscreen_discounts.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_touchscreen_discounts.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_touchscreen_discounts.OutputData data) {
                closeDialog.ok();
                if (data.discount_rate == 0) {
                    tf_discount_name.setText("");
                    tf_discount_rate.setText("0.00");
                    jLabel13.setText("0.00");
                    tf_discount_amount.setText("");
                    jLabel13.setText("0.00");
                    lbl_net_due.setText(jLabel11.getText());
                    compute_change();
                    tf_discount_amount.grabFocus();
                } else {
                    double amount_due = FitIn.toDouble(jLabel11.getText());
                    double total = data.discount_rate / 100;
                    total = amount_due * total;

                    tf_discount_name.setText(data.discount);
                    tf_discount_rate.setText(FitIn.fmt_wc_0(data.discount_rate));
                    tf_discount_amount.setText(FitIn.fmt_wc_0(total));
                    jLabel13.setText(FitIn.fmt_wc_0(total));

                    double net_due = amount_due - total;
                    lbl_net_due.setText(FitIn.fmt_wc_0(net_due));
                    compute_change();

                }
            }
        });
        Point point = tf_discount_name.getLocationOnScreen();

        nd.setLocation(point.x, point.y);
        nd.setSize(tf_discount_id.getWidth(), pnl_discount.getHeight());
        nd.setVisible(true);

    }

    private void credit_card() {
        Window p = (Window) this;
        Dlg_touchscreen_credit_cards nd = Dlg_touchscreen_credit_cards.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_touchscreen_credit_cards.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_touchscreen_credit_cards.OutputData data) {
                closeDialog.ok();
                if (data.discount_rate == 0) {
                    tf_cc_card_type.setText("");
                    tf_credit_card_amount.setText("0.00");
                    tf_cash_payment.setText("");
                    jLabel8.setText("0.00");
                    tf_credit_card_rate.setText("0.00");
                    compute_change();
                } else {
                    tf_cc_card_type.setText(data.discount);
                    tf_credit_card_rate.setText(FitIn.fmt_wc_0(data.discount_rate));
                }

            }
        });
        Point point = tf_cc_card_type.getLocationOnScreen();

        nd.setLocation(point.x, point.y);
        nd.setSize(tf_discount_id.getWidth(), pnl_discount.getHeight());
        nd.setVisible(true);
    }

    private void compute_change() {
        double net_due = FitIn.toDouble(lbl_net_due.getText());
        double cash = FitIn.toDouble(jLabel7.getText());
        double credit_card = FitIn.toDouble(jLabel8.getText());
        double gift_certificate = FitIn.toDouble(lbl_gift_certificate.getText());
        double total = (cash + credit_card + gift_certificate) - net_due;
        jLabel9.setText(FitIn.fmt_wc_0(total));
    }

    private void search_item(final JTextField tf) {
        Window p = (Window) this;
        Dlg_touchscreen_type nd = Dlg_touchscreen_type.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_touchscreen_type.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, final Dlg_touchscreen_type.OutputData data) {
                closeDialog.ok();
                tf.setText(data.search);

            }
        });
        Point point = jPanel4.getLocation();
        nd.setLocation(point.x, point.y);
        nd.setVisible(true);

    }

    private void payment_type() {
        if (menu == 0) {

            String text = tf_cash_payment.getText();

            tf_cash_payment.setText(text);
            jLabel7.setText(FitIn.fmt_wc_0(FitIn.toDouble(text)));
            compute_change();

        }

        if (menu == 2) {

            String text = tf_cash_payment.getText();

            tf_cash_payment.setText(text);
            double credit_amount = FitIn.toDouble(text);
            double credit_rate = FitIn.toDouble(tf_credit_card_rate.getText());
            double total = credit_rate / 100;
            total = credit_amount * total;
            double total2 = FitIn.toDouble(text);

            total = credit_amount + total;
            tf_credit_card_amount.setText(FitIn.fmt_wc_0(total));
            jLabel8.setText(FitIn.fmt_wc_0(total2));
            compute_change();

        }

        if (menu == 4) {

            String text = tf_cash_payment.getText();

            tf_cash_payment.setText(text);
            double am = FitIn.toDouble(tf_cash_payment.getText());
            lbl_gift_certificate.setText(FitIn.fmt_wc_0(am));

            compute_change();

        }

        if (tf_discount_amount.hasFocus()) {

            String text = tf_discount_amount.getText();

            tf_discount_amount.setText(text);
            double amount_due = FitIn.toDouble(jLabel11.getText());
            double total = amount_due - FitIn.toDouble(tf_discount_amount.getText());
            jLabel13.setText(FitIn.fmt_wc_0(FitIn.toDouble(tf_discount_amount.getText())));
            double net_due = amount_due - total;
            lbl_net_due.setText(FitIn.fmt_wc_0(total));
            compute_change();

        }
    }
}
