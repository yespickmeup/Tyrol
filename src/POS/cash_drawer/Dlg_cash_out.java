/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.cash_drawer;

import POS.banks.S1_banks;
import POS.bir_session.Srpt_checks;
import POS.cash_drawer.S1_cash_drawer.to_cash_drawer;
import POS.cash_drawer.S1_cash_drawer_checks.to_cash_drawer_checks;
import POS.cash_drawer.S1_cash_drawer_expenses.to_cash_drawer_expenses;
import POS.expenses.S1_expenses;
import POS.main.Main;
import POS.reports.Srpt_receipts;
import POS.touchscreen.Dlg_touchscreen_expenses;
import POS.util.DateType;
import POS.util.Focus_Fire;
import POS.util.MyBorder;
import POS.util.Users;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.*;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import net.sf.jasperreports.engine.*;
import org.jdesktop.swingx.JXLabel;

/**
 *
 * @author Maytopacka
 */
public class Dlg_cash_out extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_cash_out
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

        public final S1_cash_drawer.to_cash_drawer drawer;

        public OutputData(to_cash_drawer drawer) {
            this.drawer = drawer;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_cash_out(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_cash_out(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_cash_out() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_cash_out myRef;

    private void setThisRef(Dlg_cash_out myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_cash_out> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_cash_out create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_cash_out create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_cash_out dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_cash_out((java.awt.Frame) parent, false);
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
            Dlg_cash_out dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_cash_out((java.awt.Dialog) parent, false);
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

        Dlg_cash_out dialog = Dlg_cash_out.create(new javax.swing.JFrame(), true);
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
        jPanel2 = new javax.swing.JPanel();
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
        jPanel6 = new javax.swing.JPanel();
        pnl_cashout = new javax.swing.JPanel();
        tf_coins = new javax.swing.JTextField();
        tf_20 = new javax.swing.JTextField();
        tf_50 = new javax.swing.JTextField();
        tf_100 = new javax.swing.JTextField();
        tf_200 = new javax.swing.JTextField();
        tf_500 = new javax.swing.JTextField();
        tf_1000 = new javax.swing.JTextField();
        tf_cash_in = new javax.swing.JTextField();
        lbl_cash_total = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        pnl_expenses = new javax.swing.JPanel();
        tf_expense_name = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_cash_drawer_expenses = new javax.swing.JTable();
        tf_expense_amount = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        lbl_expenses_total = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jXLabel82 = new org.jdesktop.swingx.JXLabel();
        jXLabel83 = new org.jdesktop.swingx.JXLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        pnl_check = new javax.swing.JPanel();
        tf_bank = new SearchField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_cash_drawer_checks = new javax.swing.JTable();
        tf_check_paid = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lbl_check_total = new javax.swing.JLabel();
        tf_check_no = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(9, 79, 149));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

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
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jXLabel31, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
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
                .addComponent(jXLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new java.awt.CardLayout());

        pnl_cashout.setBackground(new java.awt.Color(255, 255, 255));

        tf_coins.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_coins.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_coins.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 154, 4)));
        tf_coins.setNextFocusableComponent(tf_1000);
        tf_coins.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_coinsKeyReleased(evt);
            }
        });

        tf_20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_20.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 154, 4)));
        tf_20.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_20KeyReleased(evt);
            }
        });

        tf_50.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_50.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_50.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 154, 4)));
        tf_50.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_50KeyReleased(evt);
            }
        });

        tf_100.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_100.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_100.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 154, 4)));
        tf_100.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_100KeyReleased(evt);
            }
        });

        tf_200.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_200.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_200.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 154, 4)));
        tf_200.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_200KeyReleased(evt);
            }
        });

        tf_500.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_500.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_500.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 154, 4)));
        tf_500.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_500KeyReleased(evt);
            }
        });

        tf_1000.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_1000.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_1000.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 154, 4)));
        tf_1000.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_1000KeyReleased(evt);
            }
        });

        tf_cash_in.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_cash_in.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_cash_in.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 154, 4)));
        tf_cash_in.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_cash_inKeyReleased(evt);
            }
        });

        lbl_cash_total.setBackground(new java.awt.Color(255, 255, 255));
        lbl_cash_total.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lbl_cash_total.setForeground(new java.awt.Color(249, 154, 4));
        lbl_cash_total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_cash_total.setText("0.00");

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(249, 154, 4));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Total");

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(249, 154, 4));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Coins");
        jLabel23.setOpaque(true);

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(249, 154, 4));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("20.00");
        jLabel24.setOpaque(true);

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(249, 154, 4));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("X");
        jLabel12.setOpaque(true);

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(249, 154, 4));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("50.00");
        jLabel25.setOpaque(true);

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(249, 154, 4));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("X");
        jLabel26.setOpaque(true);

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(249, 154, 4));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("100.00");
        jLabel27.setOpaque(true);

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(249, 154, 4));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("X");
        jLabel28.setOpaque(true);

        jLabel29.setBackground(new java.awt.Color(255, 255, 255));
        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(249, 154, 4));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel29.setText("200.00");
        jLabel29.setOpaque(true);

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(249, 154, 4));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("X");
        jLabel30.setOpaque(true);

        jLabel31.setBackground(new java.awt.Color(255, 255, 255));
        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(249, 154, 4));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel31.setText("500.00");
        jLabel31.setOpaque(true);

        jLabel32.setBackground(new java.awt.Color(255, 255, 255));
        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(249, 154, 4));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("X");
        jLabel32.setOpaque(true);

        jLabel33.setBackground(new java.awt.Color(255, 255, 255));
        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(249, 154, 4));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel33.setText("1,000.00");
        jLabel33.setOpaque(true);

        jLabel34.setBackground(new java.awt.Color(255, 255, 255));
        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(249, 154, 4));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("X");
        jLabel34.setOpaque(true);

        jLabel35.setBackground(new java.awt.Color(255, 255, 255));
        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(249, 154, 4));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel35.setText("Cashin");
        jLabel35.setOpaque(true);

        javax.swing.GroupLayout pnl_cashoutLayout = new javax.swing.GroupLayout(pnl_cashout);
        pnl_cashout.setLayout(pnl_cashoutLayout);
        pnl_cashoutLayout.setHorizontalGroup(
            pnl_cashoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_cashoutLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnl_cashoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_cashoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnl_cashoutLayout.createSequentialGroup()
                            .addGroup(pnl_cashoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(113, 113, 113)
                            .addGroup(pnl_cashoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_cashoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_1000, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_500, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_200, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_100, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_50, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_cash_in, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_cashoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lbl_cash_total, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_coins, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );
        pnl_cashoutLayout.setVerticalGroup(
            pnl_cashoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_cashoutLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_cashoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_cashoutLayout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addGroup(pnl_cashoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_cashoutLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_cashoutLayout.createSequentialGroup()
                        .addComponent(tf_cash_in, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_cashoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnl_cashoutLayout.createSequentialGroup()
                                .addComponent(tf_1000, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_500, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_200, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_100, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_50, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_20, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnl_cashoutLayout.createSequentialGroup()
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnl_cashoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnl_cashoutLayout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addGroup(pnl_cashoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnl_cashoutLayout.createSequentialGroup()
                                                .addGap(41, 41, 41)
                                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_coins, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_cashoutLayout.createSequentialGroup()
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_cashoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_cash_total, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.add(pnl_cashout, "card2");

        pnl_expenses.setBackground(new java.awt.Color(255, 255, 255));

        tf_expense_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_expense_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 154, 4)));
        tf_expense_name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_expense_nameMouseClicked(evt);
            }
        });

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 154, 4)));

        tbl_cash_drawer_expenses.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 154, 4)));
        tbl_cash_drawer_expenses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_cash_drawer_expenses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_cash_drawer_expensesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_cash_drawer_expenses);

        tf_expense_amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_expense_amount.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_expense_amount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 154, 4)));
        tf_expense_amount.setNextFocusableComponent(tf_bank);
        tf_expense_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_expense_amountActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(249, 154, 4));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Total");

        lbl_expenses_total.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl_expenses_total.setForeground(new java.awt.Color(249, 154, 4));
        lbl_expenses_total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_expenses_total.setText("0.00");

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(249, 154, 4));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("+");
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 154, 4)));
        jLabel13.setOpaque(true);
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnl_expensesLayout = new javax.swing.GroupLayout(pnl_expenses);
        pnl_expenses.setLayout(pnl_expensesLayout);
        pnl_expensesLayout.setHorizontalGroup(
            pnl_expensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_expensesLayout.createSequentialGroup()
                .addGroup(pnl_expensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_expensesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_expenses_total, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_expensesLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(pnl_expensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                            .addGroup(pnl_expensesLayout.createSequentialGroup()
                                .addComponent(tf_expense_name, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_expense_amount)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(5, 5, 5))
        );
        pnl_expensesLayout.setVerticalGroup(
            pnl_expensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_expensesLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(pnl_expensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_expense_amount)
                    .addGroup(pnl_expensesLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(tf_expense_name))
                    .addGroup(pnl_expensesLayout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_expensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_expenses_total, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel6.add(pnl_expenses, "card4");

        jXLabel82.setBackground(new java.awt.Color(157, 122, 67));
        jXLabel82.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel82.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXLabel82.setText("  Cash Out");
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
        jXLabel83.setText("  Disbursements");
        jXLabel83.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jXLabel83.setOpaque(true);
        jXLabel83.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel83MouseClicked(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(249, 154, 4));

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons/money-bag-48.png"))); // NOI18N

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Cash Count");

        pnl_check.setBackground(new java.awt.Color(255, 255, 255));
        pnl_check.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CHECK (F2)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        tf_bank.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        tbl_cash_drawer_checks.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbl_cash_drawer_checks);

        tf_check_paid.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tf_check_paid.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_check_paid.setNextFocusableComponent(tf_bank);
        tf_check_paid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_check_paidActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Sub-total");

        lbl_check_total.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_check_total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_check_total.setText("0.00");
        lbl_check_total.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tf_check_no.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_check_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_check_noActionPerformed(evt);
            }
        });

        jLabel15.setText("CHECK NO:");

        javax.swing.GroupLayout pnl_checkLayout = new javax.swing.GroupLayout(pnl_check);
        pnl_check.setLayout(pnl_checkLayout);
        pnl_checkLayout.setHorizontalGroup(
            pnl_checkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_checkLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_checkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_checkLayout.createSequentialGroup()
                        .addComponent(tf_bank, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_check_paid))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_checkLayout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_check_no, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_checkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(pnl_checkLayout.createSequentialGroup()
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_check_total, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnl_checkLayout.setVerticalGroup(
            pnl_checkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_checkLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_checkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_check_paid, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_bank, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_checkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_check_no)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_checkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_check_total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("Please double check Cash Count before leaving. ");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(pnl_check, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addGap(30, 30, 30))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(pnl_check, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jXLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel83, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_1000KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_1000KeyReleased
        // TODO add your handling code here:
        compute_cash();
    }//GEN-LAST:event_tf_1000KeyReleased

    private void tf_500KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_500KeyReleased
        // TODO add your handling code here:
        compute_cash();
    }//GEN-LAST:event_tf_500KeyReleased

    private void tf_200KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_200KeyReleased
        // TODO add your handling code here:
        compute_cash();
    }//GEN-LAST:event_tf_200KeyReleased

    private void tf_100KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_100KeyReleased
        // TODO add your handling code here:
        compute_cash();
    }//GEN-LAST:event_tf_100KeyReleased

    private void tf_50KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_50KeyReleased
        // TODO add your handling code here:
        compute_cash();
    }//GEN-LAST:event_tf_50KeyReleased

    private void tf_20KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_20KeyReleased
        // TODO add your handling code here:
        compute_cash();
    }//GEN-LAST:event_tf_20KeyReleased

    private void tf_coinsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_coinsKeyReleased
        // TODO add your handling code here:
        compute_cash();
    }//GEN-LAST:event_tf_coinsKeyReleased

    private void tf_check_paidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_check_paidActionPerformed
        // TODO add your handling code here:
        tf_check_no.grabFocus();

    }//GEN-LAST:event_tf_check_paidActionPerformed

    private void tf_cash_inKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_cash_inKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_cash_inKeyReleased

    private void tf_expense_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_expense_amountActionPerformed
        // TODO add your handling code here:
        add_expenses();
    }//GEN-LAST:event_tf_expense_amountActionPerformed

    private void tf_check_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_check_noActionPerformed
        // TODO add your handling code here:
        add_bank();
    }//GEN-LAST:event_tf_check_noActionPerformed

    private void jXLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel2MouseClicked

    }//GEN-LAST:event_jXLabel2MouseClicked

    private void jXLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel26MouseClicked

    }//GEN-LAST:event_jXLabel26MouseClicked

    private void jXLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel27MouseClicked

    }//GEN-LAST:event_jXLabel27MouseClicked

    private void jXLabel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel31MouseClicked
        ok1();
    }//GEN-LAST:event_jXLabel31MouseClicked

    private void jXLabel82MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel82MouseClicked
        cardLayout.show(jPanel6, "1");
    }//GEN-LAST:event_jXLabel82MouseClicked

    private void jXLabel83MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel83MouseClicked
        cardLayout.show(jPanel6, "2");
        loadData_cash_drawer_expenses(S1_cash_drawer_expenses.ret_data2(Users.session_no));
    }//GEN-LAST:event_jXLabel83MouseClicked

    private void tf_expense_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_expense_nameMouseClicked
        discounts();
    }//GEN-LAST:event_tf_expense_nameMouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        add_expenses();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void tbl_cash_drawer_expensesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_cash_drawer_expensesMouseClicked
        delete();
    }//GEN-LAST:event_tbl_cash_drawer_expensesMouseClicked
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
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
    private org.jdesktop.swingx.JXLabel jXLabel3;
    private org.jdesktop.swingx.JXLabel jXLabel31;
    private org.jdesktop.swingx.JXLabel jXLabel4;
    private org.jdesktop.swingx.JXLabel jXLabel82;
    private org.jdesktop.swingx.JXLabel jXLabel83;
    private javax.swing.JLabel lbl_cash_total;
    private javax.swing.JLabel lbl_check_total;
    private javax.swing.JLabel lbl_expenses_total;
    private javax.swing.JPanel pnl_cashout;
    private javax.swing.JPanel pnl_check;
    private javax.swing.JPanel pnl_expenses;
    private javax.swing.JTable tbl_cash_drawer_checks;
    private javax.swing.JTable tbl_cash_drawer_expenses;
    private javax.swing.JTextField tf_100;
    private javax.swing.JTextField tf_1000;
    private javax.swing.JTextField tf_20;
    private javax.swing.JTextField tf_200;
    private javax.swing.JTextField tf_50;
    private javax.swing.JTextField tf_500;
    private javax.swing.JTextField tf_bank;
    private javax.swing.JTextField tf_cash_in;
    private javax.swing.JTextField tf_check_no;
    private javax.swing.JTextField tf_check_paid;
    private javax.swing.JTextField tf_coins;
    private javax.swing.JTextField tf_expense_amount;
    private javax.swing.JTextField tf_expense_name;
    // End of variables declaration//GEN-END:variables

    private void myInit() {

        init_key();
        choose_out(0);
        init_tbl_cash_drawer_checks();
        init_tbl_cash_drawer_expenses();
        init_bank();
        init_expenses();
        focus();
        pnl_check.setVisible(false);
        tf_cash_in.enable(false);
        set_card_items();
        setBOrder();
        type();
        tf_expense_name.enable(false);
    }

    private void setBOrder() {
        MyBorder.setBorder2(tf_cash_in);
        MyBorder.setBorder2(tf_1000);
        MyBorder.setBorder2(tf_1000);
        MyBorder.setBorder2(tf_500);
        MyBorder.setBorder2(tf_200);
        MyBorder.setBorder2(tf_100);
        MyBorder.setBorder2(tf_50);
        MyBorder.setBorder2(tf_20);
        MyBorder.setBorder2(tf_coins);
        MyBorder.setBorder2(tf_expense_name);
        MyBorder.setBorder2(tf_expense_amount);
    }

    private void type() {

        JXLabel[] lbl = {
            jXLabel2, jXLabel3, jXLabel4, jXLabel25, jXLabel12, jXLabel14, jXLabel13, jXLabel24, jXLabel22, jXLabel23, jXLabel26, jXLabel27};
        for (final JXLabel l : lbl) {
            l.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {

                    if (tf_1000.hasFocus()) {
                        if (l.getText().equalsIgnoreCase("CL")) {
                            tf_1000.setText("");
                        } else {
                            String text = tf_1000.getText();
                            text = text + l.getText();
                            tf_1000.setText(text);
                        }

                    }
                    if (tf_500.hasFocus()) {
                        if (l.getText().equalsIgnoreCase("CL")) {
                            tf_500.setText("");
                        } else {
                            String text = tf_500.getText();
                            text = text + l.getText();
                            tf_500.setText(text);
                        }

                    }
                    if (tf_200.hasFocus()) {
                        if (l.getText().equalsIgnoreCase("CL")) {
                            tf_200.setText("");
                        } else {
                            String text = tf_200.getText();
                            text = text + l.getText();
                            tf_200.setText(text);
                        }

                    }
                    if (tf_100.hasFocus()) {
                        if (l.getText().equalsIgnoreCase("CL")) {
                            tf_100.setText("");
                        } else {
                            String text = tf_100.getText();
                            text = text + l.getText();
                            tf_100.setText(text);
                        }

                    }
                    if (tf_50.hasFocus()) {
                        if (l.getText().equalsIgnoreCase("CL")) {
                            tf_50.setText("");
                        } else {
                            String text = tf_50.getText();
                            text = text + l.getText();
                            tf_50.setText(text);
                        }

                    }
                    if (tf_coins.hasFocus()) {
                        if (l.getText().equalsIgnoreCase("CL")) {
                            tf_coins.setText("");
                        } else {
                            String text = tf_coins.getText();
                            text = text + l.getText();
                            tf_coins.setText(text);
                        }
                    }

                    if (tf_expense_amount.hasFocus()) {
                        if (l.getText().equalsIgnoreCase("Cl")) {
                            tf_expense_amount.setText("");
                        } else {
                            String text = tf_expense_amount.getText();
                            text = text + l.getText();
                            tf_expense_amount.setText(text);
                        }
                    }

                    compute_cash();
                    compute_all();
                }
            });
        }
    }

    CardLayout cardLayout = new CardLayout();

    private void set_card_items() {
        cardLayout = (CardLayout) jPanel6.getLayout();
        cardLayout.addLayoutComponent("1", pnl_cashout);
        cardLayout.addLayoutComponent("2", pnl_expenses);

    }

    private void focus() {
        JTextField[] tf = {tf_1000, tf_500, tf_200, tf_100, tf_50, tf_20, tf_coins, tf_bank, tf_check_paid, tf_expense_name, tf_expense_amount, tf_check_no};
        Focus_Fire.onFocus_lostFocus(tf);
    }

    private void init_bank() {

    }

    private void init_expenses() {
//        final SearchField sf = (SearchField) tf_expense_name;
//        sf.setFont(new java.awt.Font("Tahoma", 1, 14));
//        sf.set_instruction1("Search EXPENSES");
//        sf.set_searcher(new SearchField.ISearcher() {
//
//            @Override
//            public List get_entered(String starts_with) {
//                return S1_expenses.ret_cb_data();
//            }
//        });
//
//        sf.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                tf_expense_amount.grabFocus();
//            }
//        });
    }

    public void do_pass_in(List<to_cash_drawer_checks> checks, S1_cash_drawer.to_cash_drawer to) {
        tf_cash_in.setText(FitIn.fmt_woc(to_cash_drawer.amount));
        tf_cash_in.enable(false);
    }

    public void do_pass(List<to_cash_drawer_checks> checks, S1_cash_drawer.to_cash_drawer to) {
        tf_cash_in.setText(FitIn.fmt_woc(to_cash_drawer.amount));
        tf_cash_in.enable(false);
        loadData_cash_drawer_checks(S1_cash_drawer_checks.ret_data(Users.session_no));
        loadData_cash_drawer_expenses(S1_cash_drawer_expenses.ret_data(Users.session_no));
        compute_check();
        tf_1000.setText(FitIn.fmt_woc(to.thousand));
        tf_500.setText(FitIn.fmt_woc(to.five_hundred));
        tf_200.setText(FitIn.fmt_woc(to.two_hundred));
        tf_100.setText(FitIn.fmt_woc(to.one_hundred));
        tf_50.setText(FitIn.fmt_woc(to.fifty));
        tf_20.setText(FitIn.fmt_woc(to.twenty));
        tf_coins.setText(FitIn.fmt_wc_0(to.coins));
        compute_expenses();
        compute_cash();
        compute_all();
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
                              KeyEvent.VK_CONTROL, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                btn_0.doClick();
//                disposed();
//                ok1();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                              KeyEvent.VK_F1, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                btn_0.doClick();

                choose_out(0);
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                              KeyEvent.VK_F2, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                btn_0.doClick();
                choose_out(1);
            }
        });

        KeyMapping.mapKeyWIFW(getSurface(),
                              KeyEvent.VK_F3, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                btn_0.doClick();
                choose_out(3);
            }
        });

        tf_check_paid.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (!tbl_cash_drawer_checks_ALM.isEmpty()) {
                        tbl_cash_drawer_checks.setRowSelectionInterval(0, 0);
                        tbl_cash_drawer_checks.grabFocus();
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    ok1();
                }
            }
        });

        tf_expense_amount.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (!tbl_cash_drawer_expenses_ALM.isEmpty()) {
                        tbl_cash_drawer_expenses.setRowSelectionInterval(0, 0);
                        tbl_cash_drawer_expenses.grabFocus();
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    ok1();
                }
                if (e.getKeyCode() == KeyEvent.VK_F3) {
                    choose_out(3);
                }
            }
        });

        tbl_cash_drawer_checks.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_F2) {
                    choose_out(1);
                }
                if (e.getKeyCode() == KeyEvent.VK_F3) {
                    choose_out(3);
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    delete_bank();
                }
                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    ok1();
                }
            }
        });

        tbl_cash_drawer_expenses.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_F2) {
                    choose_out(1);
                }
                if (e.getKeyCode() == KeyEvent.VK_F3) {
                    choose_out(3);
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    delete_expenses();
                }
                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    ok1();
                }
            }
        });

        tf_1000.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    ok1();
                }
                if (e.getKeyCode() == KeyEvent.VK_F3) {
                    choose_out(3);
                }
            }
        });
        tf_bank.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    ok1();
                }
            }
        });
        tf_expense_name.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    ok1();
                }
            }
        });

        tf_500.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    ok1();
                }
            }
        });
        tf_200.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    ok1();
                }
            }
        });
        tf_100.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    ok1();
                }
            }
        });
        tf_50.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    ok1();
                }
            }
        });
        tf_20.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    ok1();
                }
            }
        });
        tf_coins.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    ok1();
                }
            }
        });
    }
    // </editor-fold>

    private void choose_out(int stmt) {
        if (stmt == 0) {
            tf_1000.grabFocus();
//            pnl_cash.setBackground(new java.awt.Color(153, 204, 255));
            pnl_check.setBackground(new java.awt.Color(255, 255, 255));
            pnl_expenses.setBackground(new java.awt.Color(255, 255, 255));
        }
        if (stmt == 1) {
            tf_bank.grabFocus();
//            pnl_cash.setBackground(new java.awt.Color(255, 255, 255));
            pnl_expenses.setBackground(new java.awt.Color(255, 255, 255));
            pnl_check.setBackground(new java.awt.Color(153, 204, 255));
        }
        if (stmt == 3) {
            tf_expense_name.grabFocus();
//            pnl_cash.setBackground(new java.awt.Color(255, 255, 255));
            pnl_check.setBackground(new java.awt.Color(255, 255, 255));
            pnl_expenses.setBackground(new java.awt.Color(153, 204, 255));

        }
    }

    private void compute_cash() {
        double thousand = FitIn.toDouble(tf_1000.getText()) * 1000;
        double f_hundred = FitIn.toDouble(tf_500.getText()) * 500;
        double two_hundred = FitIn.toDouble(tf_200.getText()) * 200;
        double hundred = FitIn.toDouble(tf_100.getText()) * 100;
        double fifty = FitIn.toDouble(tf_50.getText()) * 50;
        double twenty = FitIn.toDouble(tf_20.getText()) * 20;
        double coins = FitIn.toDouble(tf_coins.getText()) * 1;
        double total = thousand + f_hundred + two_hundred + hundred + fifty + twenty + coins;
        lbl_cash_total.setText(FitIn.fmt_wc_0(total));
        compute_all();

    }
    private ArrayListModel tbl_cash_drawer_checks_ALM;
    private Tblcash_drawer_checksModel tbl_cash_drawer_checks_M;

    private void init_tbl_cash_drawer_checks() {
        tbl_cash_drawer_checks_ALM = new ArrayListModel();
        tbl_cash_drawer_checks_M = new Tblcash_drawer_checksModel(tbl_cash_drawer_checks_ALM);
        tbl_cash_drawer_checks.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_cash_drawer_checks.setModel(tbl_cash_drawer_checks_M);
        tbl_cash_drawer_checks.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_cash_drawer_checks.setRowHeight(25);
        int[] tbl_widths_cash_drawer_checks = {0, 0, 0, 0, 0, 0, 100, 0, 0, 100};
        for (int i = 0, n = tbl_widths_cash_drawer_checks.length; i < n; i++) {
            if (i == 6) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_cash_drawer_checks, i, tbl_widths_cash_drawer_checks[i]);
        }
        Dimension d = tbl_cash_drawer_checks.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_cash_drawer_checks.getTableHeader().
                setPreferredSize(d);
        tbl_cash_drawer_checks.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_cash_drawer_checks.setRowHeight(35);
        tbl_cash_drawer_checks.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_cash_drawer_checks(List<to_cash_drawer_checks> acc) {
        tbl_cash_drawer_checks_ALM.clear();
        tbl_cash_drawer_checks_ALM.addAll(acc);
    }

    public static class Tblcash_drawer_checksModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "session_no", "user_name", "screen_name", "time_in", "time_out", "BANK", "check_no", "check_holder", "AMOUNT"
        };

        public Tblcash_drawer_checksModel(ListModel listmodel) {
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
            to_cash_drawer_checks tt = (to_cash_drawer_checks) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                case 1:
                    return tt.session_no;
                case 2:
                    return tt.user_name;
                case 3:
                    return tt.screen_name;
                case 4:
                    return tt.time_in;
                case 5:
                    return tt.time_out;
                case 6:
                    return tt.bank;
                case 7:
                    return tt.check_no;
                case 8:
                    return tt.check_holder;
                default:
                    return tt.amount;
            }
        }
    }

    private void add_bank() {
        int id = -1;
        String session_no = Users.session_no;
        String user_name = Users.user_name;
        String screen_name = Users.screen_name;
        String time_in = Users.time_in;
        String time_out = DateType.datetime.format(new Date());
        String bank = tf_bank.getText();
        String check_no = tf_check_no.getText();
        String check_holder = "";
        double amount = FitIn.toDouble(tf_check_paid.getText());
        to_cash_drawer_checks to = new to_cash_drawer_checks(id, session_no, user_name, screen_name, time_in, time_out, bank, check_no, check_holder, amount);
        if (Users.is_active == 0) {
            tbl_cash_drawer_checks_ALM.add(to);
            tbl_cash_drawer_checks_M.fireTableDataChanged();
            tf_bank.grabFocus();
            tf_check_paid.setText("");
            tf_check_no.setText("");
            compute_check();
            compute_all();
        } else {
            List<to_cash_drawer_checks> data = new ArrayList();
            data.add(to);
            S1_cash_drawer_checks.add_cash_drawer_checks(data);
            loadData_cash_drawer_checks(S1_cash_drawer_checks.ret_data(Users.session_no));
            tf_bank.grabFocus();
            tf_check_paid.setText("");
            tf_check_no.setText("");
            compute_check();
            compute_all();
        }
    }

    private void delete_bank() {
        int row = tbl_cash_drawer_checks.getSelectedRow();
        if (row < 0) {
            return;
        }

        if (Users.drawer.time_out == null) {
            tbl_cash_drawer_checks_ALM.remove(row);
            tbl_cash_drawer_checks_M.fireTableDataChanged();
            tf_bank.grabFocus();
            compute_check();
            compute_all();
        } else {

            to_cash_drawer_checks to = (to_cash_drawer_checks) tbl_cash_drawer_checks_ALM.
                    get(tbl_cash_drawer_checks.convertRowIndexToModel(row));
            S1_cash_drawer_checks.delete_cash_drawer_checks(to);
            loadData_cash_drawer_checks(S1_cash_drawer_checks.ret_data(Users.session_no));
            tf_bank.grabFocus();
            tf_check_paid.setText("");
            compute_check();
            compute_all();
        }

    }
    private ArrayListModel tbl_cash_drawer_expenses_ALM;
    private Tblcash_drawer_expensesModel tbl_cash_drawer_expenses_M;

    private void init_tbl_cash_drawer_expenses() {
        tbl_cash_drawer_expenses_ALM = new ArrayListModel();
        tbl_cash_drawer_expenses_M = new Tblcash_drawer_expensesModel(tbl_cash_drawer_expenses_ALM);
        tbl_cash_drawer_expenses.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_cash_drawer_expenses.setModel(tbl_cash_drawer_expenses_M);
        tbl_cash_drawer_expenses.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_cash_drawer_expenses.setRowHeight(25);
        int[] tbl_widths_cash_drawer_expenses = {100, 100, 100, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_cash_drawer_expenses.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_cash_drawer_expenses, i, tbl_widths_cash_drawer_expenses[i]);
        }
        Dimension d = tbl_cash_drawer_expenses.getTableHeader().
                getPreferredSize();
        d.height = 0;
        tbl_cash_drawer_expenses.getTableHeader().
                setPreferredSize(d);
        tbl_cash_drawer_expenses.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_cash_drawer_expenses.setRowHeight(50);
        tbl_cash_drawer_expenses.setFont(new java.awt.Font("Tahoma", 0, 14));
    }

    private void loadData_cash_drawer_expenses(List<to_cash_drawer_expenses> acc) {
        tbl_cash_drawer_expenses_ALM.clear();
        tbl_cash_drawer_expenses_ALM.addAll(acc);
    }

    public static class Tblcash_drawer_expensesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "session_no", "user_name", "screen_name", "time_in", "time_out", "EXPENSE", "check_no", "check_holder", "AMOUNT"
        };

        public Tblcash_drawer_expensesModel(ListModel listmodel) {
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
            to_cash_drawer_expenses tt = (to_cash_drawer_expenses) getRow(row);
            switch (col) {
                case 0:
                    return tt.bank;
                case 1:
                    return "       " + FitIn.fmt_wc_0(tt.amount);
                case 2:
                    return "       Delete";
                case 3:
                    return tt.screen_name;
                case 4:
                    return tt.time_in;
                case 5:
                    return tt.time_out;
                case 6:
                    return tt.bank;
                case 7:
                    return tt.check_no;
                case 8:
                    return tt.check_holder;
                default:
                    return FitIn.fmt_wc_0(tt.amount);
            }
        }
    }

    private void add_expenses() {
        int id = -1;
        String session_no = Users.session_no;
        String user_name = Users.user_name;
        String screen_name = Users.screen_name;
        String time_in = Users.time_in;
        String time_out = DateType.datetime.format(new Date());
        String bank = tf_expense_name.getText();
        String check_no = "";
        String check_holder = "";
        double amount = FitIn.toDouble(tf_expense_amount.getText());
        to_cash_drawer_expenses to = new to_cash_drawer_expenses(id, session_no, user_name, screen_name
                , time_in, time_out, bank, check_no, check_holder, amount,0);

        S1_cash_drawer_expenses.add_cash_drawer_checks(to);
        loadData_cash_drawer_expenses(S1_cash_drawer_expenses.ret_data2(Users.session_no));
        tf_expense_name.grabFocus();
        tf_expense_amount.setText("");
        tf_expense_name.setText("");
        compute_expenses();

    }

    private void delete_expenses() {
        int row = tbl_cash_drawer_expenses.getSelectedRow();
        if (row < 0) {
            return;
        }

        if (Users.drawer.time_out == null) {
            tbl_cash_drawer_expenses_ALM.remove(row);
            tbl_cash_drawer_expenses_M.fireTableDataChanged();
            tf_expense_name.grabFocus();
            tf_expense_amount.setText("");
            compute_expenses();
        } else {

            to_cash_drawer_expenses to = (to_cash_drawer_expenses) tbl_cash_drawer_expenses_ALM.
                    get(tbl_cash_drawer_expenses.convertRowIndexToModel(row));
            S1_cash_drawer_expenses.delete_cash_drawer_checks(to);
            loadData_cash_drawer_expenses(S1_cash_drawer_expenses.ret_data(Users.session_no));
            tf_expense_name.grabFocus();
            tf_expense_amount.setText("");
            compute_expenses();
        }

    }

    private void compute_check() {
        List<to_cash_drawer_checks> datas = tbl_cash_drawer_checks_ALM;
        double total = 0;
        for (to_cash_drawer_checks to : datas) {
            total += to.amount;
        }
        lbl_check_total.setText(FitIn.fmt_wc_0(total));
        compute_all();
    }

    private void compute_expenses() {
        List<to_cash_drawer_expenses> datas = tbl_cash_drawer_expenses_ALM;
        double total = 0;
        for (to_cash_drawer_expenses to : datas) {
            total += to.amount;
        }
        lbl_expenses_total.setText(FitIn.fmt_wc_0(total));
//        compute_all();
    }

    private void compute_all() {
        double cash = FitIn.toDouble(lbl_cash_total.getText());
        double check = FitIn.toDouble(lbl_check_total.getText());
        double total = cash + check;

//        lbl_total.setText(FitIn.fmt_wc_0(total));
    }

    private void ok1() {
//        Alert.set(0, "");
//        System.out.println("asdasd");
        int id = 0;
        String session_no = Users.session_no;
        String user_name = Users.user_name;
        String screen_name = Users.screen_name;
        String time_in = Users.time_in;
        String time_out = Users.time_out;
        double amount = to_cash_drawer.amount;
        double cash_out = 0;

        double thousand = FitIn.toDouble(tf_1000.getText());
        double five_hundred = FitIn.toDouble(tf_500.getText());
        double two_hundred = FitIn.toDouble(tf_200.getText());
        double fifty = FitIn.toDouble(tf_50.getText());
        double twenty = FitIn.toDouble(tf_20.getText());
        double coins = FitIn.toDouble(tf_coins.getText());
        double one_hundred = FitIn.toDouble(tf_100.getText());
        List<S1_cash_drawer_checks.to_cash_drawer_checks> checks = tbl_cash_drawer_checks_ALM;
        List<S1_cash_drawer_expenses.to_cash_drawer_expenses> expen = tbl_cash_drawer_expenses_ALM;
        double expenses = FitIn.toDouble(lbl_expenses_total.getText());
        S1_cash_drawer.to_cash_drawer to = new to_cash_drawer(id, session_no, user_name, screen_name, time_in, time_out, amount, cash_out, thousand, five_hundred, two_hundred, fifty, twenty, coins, one_hundred, checks, expen, expenses);

        String business_name = System.getProperty("business_name", "Fortune Tree Enterprises");
        String operated_by = System.getProperty("operated_by", "Ernesto C.QUiamco");
        String address = System.getProperty("address", "Door 2, H & J Ong bldg, Corner Colon & Sta Catalina Street Dumaguete City");
        double cash_in = FitIn.toDouble(tf_cash_in.getText());
        double cash_total = FitIn.toDouble(lbl_cash_total.getText());
        String cashier_name = Users.screen_name;
        double net_total = FitIn.toDouble(lbl_cash_total.getText());
        String date = DateType.month_date.format(new Date());
        List<Srpt_checks.field> fields = new ArrayList();
        List<Srpt_checks.field> fields2 = new ArrayList();
        List<to_cash_drawer_checks> f = tbl_cash_drawer_checks_ALM;
        List<to_cash_drawer_expenses> ex1 = tbl_cash_drawer_expenses_ALM;
        double grand_sales = 0;
        double grand_checks = 0;
        double grand_expenses = 0;
        for (to_cash_drawer_checks t : f) {
            String check_bank = t.bank;
            String check_holder = t.check_holder;
            String check_no = t.check_no;
            double check_amount = t.amount;
            String date1 = DateType.convert_jan_1_2013_datetime2(DateType.datetime.
                    format(new Date()));
            Srpt_checks.field t1 = new Srpt_checks.field(check_bank + " - " + check_no, check_holder, check_no, check_amount, date1);
            fields.add(t1);
            grand_checks += check_amount;
        }
        for (to_cash_drawer_expenses t : ex1) {
            String check_bank = t.bank;
            String check_holder = t.check_holder;
            String check_no = t.check_no;
            double check_amount = t.amount;
            String date1 = DateType.convert_jan_1_2013_datetime2(DateType.datetime.
                    format(new Date()));
            Srpt_checks.field t1 = new Srpt_checks.field(check_bank, check_holder, check_no, check_amount, date1);
            fields2.add(t1);
            grand_expenses += check_amount;
        }
        net_total=cash_total-grand_expenses;
        grand_sales = FitIn.toDouble(lbl_cash_total.getText());
        grand_sales=cash_total;
        String SUBREPORT_DIR = System.getProperty("img_path", "C:\\Users\\Ronald\\") + "retail_res\\rpt\\";
        Srpt_cash_count rpt = new Srpt_cash_count(business_name, address, operated_by, cash_in, thousand, five_hundred, two_hundred, one_hundred, fifty, twenty, coins, cash_total, cashier_name, net_total, date, fields, SUBREPORT_DIR, fields2, grand_sales, grand_checks, grand_expenses);
//        rpt.fields.addAll(fields);
        String jrxml = "rpt_cash_count.jrxml";
        JasperReport jasperReport = null;
        String print = System.getProperty("print_to_receipts2", "false");
        if (print.equals("true")) {
            InputStream is = S1_cash_drawer.class.getResourceAsStream(jrxml);
            try {
                jasperReport = JasperCompileManager.compileReport(is);
                jasperPrint = JasperFillManager.fillReport(jasperReport, JasperUtil.
                        setParameter(rpt), JasperUtil.emptyDatasource());
            } catch (JRException ex) {
                Logger.getLogger(Srpt_receipts.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
            try {
                JasperPrintManager.printReport(jasperPrint, false);
            } catch (JRException e) {
                JOptionPane.showMessageDialog(null, "Failed To Print, Please Check the Printer");
                throw new RuntimeException(e);
            }
        }
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(to));
        }
    }
    JasperPrint jasperPrint = null;

    private void discounts() {
        Window p = (Window) this;
        Dlg_touchscreen_expenses nd = Dlg_touchscreen_expenses.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_touchscreen_expenses.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_touchscreen_expenses.OutputData data) {
                closeDialog.ok();
                tf_expense_name.setText(data.discount);
                tf_expense_amount.grabFocus();
            }
        });
        Point point = tf_expense_name.getLocationOnScreen();

        nd.setLocation(point.x, point.y + 39);
        nd.setSize(tbl_cash_drawer_expenses.getWidth() + 90, jScrollPane2.getHeight());
        nd.setVisible(true);

    }

    private void delete() {
        int row = tbl_cash_drawer_expenses.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_cash_drawer_expenses to = (to_cash_drawer_expenses) tbl_cash_drawer_expenses_ALM.get(tbl_cash_drawer_expenses.convertRowIndexToModel(row));
        S1_cash_drawer_expenses.delete_cash_drawer_checks(to);
        loadData_cash_drawer_expenses(S1_cash_drawer_expenses.ret_data2(Users.session_no));
        compute_expenses();
    }
}
