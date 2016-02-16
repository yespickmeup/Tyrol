/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.billing_discounts;

import POS.touchscreen.Dlg_touchscreen_discounts;
import POS.touchscreen.Dlg_touchscreen_type;
import POS.util.Focus_Fire;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import javax.swing.JTextField;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;

/**
 *
 * @author Ronald
 */
public class Dlg_billing_discounts extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_billing_discounts
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

        public final String discount_name;
        public final double discount_rate;
        public final double discount_amount;
        public final String discount_no;
        public final String discount_holder;
        public final String discount_address;

        public OutputData(String discount_name, double discount_rate, double discount_amount, String discount_no, String discount_holder, String discount_address) {
            this.discount_name = discount_name;
            this.discount_rate = discount_rate;
            this.discount_amount = discount_amount;
            this.discount_no = discount_no;
            this.discount_holder = discount_holder;
            this.discount_address = discount_address;
        }

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_billing_discounts(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_billing_discounts(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_billing_discounts() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_billing_discounts myRef;

    private void setThisRef(Dlg_billing_discounts myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_billing_discounts> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_billing_discounts create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_billing_discounts create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_billing_discounts dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_billing_discounts((java.awt.Frame) parent, false);
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
            Dlg_billing_discounts dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_billing_discounts((java.awt.Dialog) parent, false);
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

        Dlg_billing_discounts dialog = Dlg_billing_discounts.create(new javax.swing.JFrame(), true);
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
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_net_due = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jXLabel16 = new org.jdesktop.swingx.JXLabel();
        jXLabel9 = new org.jdesktop.swingx.JXLabel();
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
        jXLabel33 = new org.jdesktop.swingx.JXLabel();
        jXLabel32 = new org.jdesktop.swingx.JXLabel();
        jXLabel8 = new org.jdesktop.swingx.JXLabel();
        jXLabel15 = new org.jdesktop.swingx.JXLabel();
        jXLabel17 = new org.jdesktop.swingx.JXLabel();
        jXLabel11 = new org.jdesktop.swingx.JXLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(9, 79, 149));

        jPanel3.setBackground(new java.awt.Color(249, 154, 4));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons/money-bag-48.png"))); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Discounts");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
        );

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
        tf_discount_name.setFocusable(false);
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
        tf_discount_amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_discount_amountKeyReleased(evt);
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
        tf_discount_rate.setFocusable(false);
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
                .addGroup(pnl_discountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jXLabel76, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel68, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(jXLabel70, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(pnl_discountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_discount_customer_name)
                    .addComponent(tf_discount_address)
                    .addComponent(tf_discount_id, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_discountLayout.createSequentialGroup()
                        .addComponent(tf_discount_name)
                        .addGap(1, 1, 1)
                        .addComponent(tf_discount_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(tf_discount_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
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

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Amount Due");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Discount");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Net Due");

        lbl_net_due.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_net_due.setForeground(new java.awt.Color(255, 255, 255));
        lbl_net_due.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_net_due.setText("1,000.00");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("0.00");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("1,000.00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(208, 208, 208)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_net_due, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_net_due, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2))
                .addContainerGap(58, Short.MAX_VALUE))
        );

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

        jXLabel33.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel33.setText("Ok");
        jXLabel33.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel33.setOpaque(true);
        jXLabel33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel33MouseClicked(evt);
            }
        });

        jXLabel32.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel32.setText("Close");
        jXLabel32.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jXLabel32.setOpaque(true);
        jXLabel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel32MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addComponent(jXLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jXLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jXLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jXLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jXLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jXLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jXLabel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
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
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(jXLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 470, Short.MAX_VALUE)
                    .addComponent(pnl_discount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jXLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jXLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jXLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl_discount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void tf_discount_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_discount_amountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_discount_amountActionPerformed

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

    private void tf_discount_amountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_discount_amountKeyReleased
        disc();
    }//GEN-LAST:event_tf_discount_amountKeyReleased

    private void jXLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel16MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel16MouseClicked

    private void jXLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel9MouseClicked

    private void jXLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel2MouseClicked

    }//GEN-LAST:event_jXLabel2MouseClicked

    private void jXLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel26MouseClicked

    }//GEN-LAST:event_jXLabel26MouseClicked

    private void jXLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel27MouseClicked

    }//GEN-LAST:event_jXLabel27MouseClicked

    private void jXLabel33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel33MouseClicked
        ok();
    }//GEN-LAST:event_jXLabel33MouseClicked

    private void jXLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel8MouseClicked

    private void jXLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel15MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel15MouseClicked

    private void jXLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel17MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel17MouseClicked

    private void jXLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel11MouseClicked

    private void jXLabel32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel32MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel32MouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
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
    private org.jdesktop.swingx.JXLabel jXLabel32;
    private org.jdesktop.swingx.JXLabel jXLabel33;
    private org.jdesktop.swingx.JXLabel jXLabel4;
    private org.jdesktop.swingx.JXLabel jXLabel68;
    private org.jdesktop.swingx.JXLabel jXLabel70;
    private org.jdesktop.swingx.JXLabel jXLabel71;
    private org.jdesktop.swingx.JXLabel jXLabel76;
    private org.jdesktop.swingx.JXLabel jXLabel77;
    private org.jdesktop.swingx.JXLabel jXLabel8;
    private org.jdesktop.swingx.JXLabel jXLabel9;
    private javax.swing.JLabel lbl_net_due;
    private javax.swing.JPanel pnl_discount;
    private javax.swing.JTextField tf_discount_address;
    private javax.swing.JTextField tf_discount_amount;
    private javax.swing.JTextField tf_discount_customer_name;
    private javax.swing.JTextField tf_discount_id;
    private javax.swing.JTextField tf_discount_name;
    private javax.swing.JTextField tf_discount_rate;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
        init_key();
        focus();
    }

    private void focus() {
        JTextField[] tf = {tf_discount_amount, tf_discount_id, tf_discount_customer_name, tf_discount_address};
        Focus_Fire.onFocus_lostFocus(tf);
        Focus_Fire.select_all(tf);
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
                    tf_discount_amount.setText("");
                    tf_discount_amount.grabFocus();
                    jLabel13.setText("0.00");
                    lbl_net_due.setText(jLabel11.getText());
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

                }
            }
        });
        Point point = tf_discount_name.getLocationOnScreen();

        nd.setLocation(point.x, point.y);
        nd.setSize(tf_discount_id.getWidth(), pnl_discount.getHeight());
        nd.setVisible(true);

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
        Point point = pnl_discount.getLocation();
        nd.setLocation(point.x, point.y);
        nd.setVisible(true);

    }

    private void disc() {
        tf_discount_name.setText("");
        tf_discount_rate.setText("");
        double amount_due = FitIn.toDouble(jLabel11.getText());
        double total = FitIn.toDouble(tf_discount_amount.getText());
        jLabel13.setText(FitIn.fmt_wc_0(total));
        double net_due = amount_due - total;
        lbl_net_due.setText(FitIn.fmt_wc_0(net_due));
    }

    private void ok() {
        String discount = tf_discount_address.getText();
        double discount_rate = FitIn.toDouble(tf_discount_address.getText());
        double discount_amount = FitIn.toDouble(tf_discount_address.getText());
        String discount_no = tf_discount_address.getText();
        String discount_name = tf_discount_address.getText();
        String discount_address = tf_discount_address.getText();

        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(discount_name, discount_rate, discount_amount, discount_no, discount_name, discount_address));
        }
    }
}
