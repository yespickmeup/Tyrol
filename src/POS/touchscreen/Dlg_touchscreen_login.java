/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen;

import POS.cash_drawer.Dlg_cashin;
import POS.cash_drawer.S1_cash_drawer;
import POS.users.Dlg_login;
import POS.users.S1_users;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.Users;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import org.jdesktop.swingx.JXLabel;

/**
 *
 * @author Ronald
 */
public class Dlg_touchscreen_login extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_touchscreen_login
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
    private Dlg_touchscreen_login(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_touchscreen_login(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_touchscreen_login() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_touchscreen_login myRef;

    private void setThisRef(Dlg_touchscreen_login myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_touchscreen_login> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_touchscreen_login create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_touchscreen_login create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_touchscreen_login dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_login((java.awt.Frame) parent, false);
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
            Dlg_touchscreen_login dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_login((java.awt.Dialog) parent, false);
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

        Dlg_touchscreen_login dialog = Dlg_touchscreen_login.create(new javax.swing.JFrame(), true);
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
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        jXLabel4 = new org.jdesktop.swingx.JXLabel();
        jXLabel5 = new org.jdesktop.swingx.JXLabel();
        jXLabel6 = new org.jdesktop.swingx.JXLabel();
        jXLabel7 = new org.jdesktop.swingx.JXLabel();
        jXLabel8 = new org.jdesktop.swingx.JXLabel();
        jXLabel9 = new org.jdesktop.swingx.JXLabel();
        jXLabel10 = new org.jdesktop.swingx.JXLabel();
        jXLabel12 = new org.jdesktop.swingx.JXLabel();
        jXLabel13 = new org.jdesktop.swingx.JXLabel();
        jXLabel14 = new org.jdesktop.swingx.JXLabel();
        jXLabel15 = new org.jdesktop.swingx.JXLabel();
        jXLabel16 = new org.jdesktop.swingx.JXLabel();
        jXLabel17 = new org.jdesktop.swingx.JXLabel();
        jXLabel18 = new org.jdesktop.swingx.JXLabel();
        jXLabel19 = new org.jdesktop.swingx.JXLabel();
        jXLabel20 = new org.jdesktop.swingx.JXLabel();
        jXLabel22 = new org.jdesktop.swingx.JXLabel();
        jXLabel23 = new org.jdesktop.swingx.JXLabel();
        jXLabel24 = new org.jdesktop.swingx.JXLabel();
        jXLabel25 = new org.jdesktop.swingx.JXLabel();
        jXLabel26 = new org.jdesktop.swingx.JXLabel();
        jXLabel27 = new org.jdesktop.swingx.JXLabel();
        jXLabel28 = new org.jdesktop.swingx.JXLabel();
        jXLabel30 = new org.jdesktop.swingx.JXLabel();
        jXLabel31 = new org.jdesktop.swingx.JXLabel();
        jXLabel32 = new org.jdesktop.swingx.JXLabel();
        jXLabel33 = new org.jdesktop.swingx.JXLabel();
        jXLabel34 = new org.jdesktop.swingx.JXLabel();
        jXLabel35 = new org.jdesktop.swingx.JXLabel();
        jXLabel36 = new org.jdesktop.swingx.JXLabel();
        jXLabel38 = new org.jdesktop.swingx.JXLabel();
        jXLabel39 = new org.jdesktop.swingx.JXLabel();
        jXLabel40 = new org.jdesktop.swingx.JXLabel();
        jXLabel41 = new org.jdesktop.swingx.JXLabel();
        jXLabel42 = new org.jdesktop.swingx.JXLabel();
        jXLabel29 = new org.jdesktop.swingx.JXLabel();
        jXLabel37 = new org.jdesktop.swingx.JXLabel();
        jXLabel44 = new org.jdesktop.swingx.JXLabel();
        tf_username = new javax.swing.JTextField();
        jXLabel46 = new org.jdesktop.swingx.JXLabel();
        jXLabel47 = new org.jdesktop.swingx.JXLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tf_password = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jXLabel2.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel2.setText("Q");
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
        jXLabel3.setText("W");
        jXLabel3.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel3.setOpaque(true);

        jXLabel4.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel4.setText("E");
        jXLabel4.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel4.setOpaque(true);

        jXLabel5.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel5.setText("R");
        jXLabel5.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel5.setOpaque(true);

        jXLabel6.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel6.setText("T");
        jXLabel6.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel6.setOpaque(true);

        jXLabel7.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel7.setText("Y");
        jXLabel7.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel7.setOpaque(true);

        jXLabel8.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel8.setText("U");
        jXLabel8.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel8.setOpaque(true);

        jXLabel9.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel9.setText("I");
        jXLabel9.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel9.setOpaque(true);

        jXLabel10.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel10.setText("0");
        jXLabel10.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel10.setOpaque(true);

        jXLabel12.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel12.setText("A");
        jXLabel12.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel12.setOpaque(true);

        jXLabel13.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel13.setText("D");
        jXLabel13.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel13.setOpaque(true);

        jXLabel14.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel14.setText("S");
        jXLabel14.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel14.setOpaque(true);

        jXLabel15.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel15.setText("F");
        jXLabel15.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel15.setOpaque(true);

        jXLabel16.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel16.setText("G");
        jXLabel16.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel16.setOpaque(true);

        jXLabel17.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel17.setText("H");
        jXLabel17.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel17.setOpaque(true);

        jXLabel18.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel18.setText("J");
        jXLabel18.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel18.setOpaque(true);

        jXLabel19.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel19.setText("K");
        jXLabel19.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel19.setOpaque(true);

        jXLabel20.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel20.setText("L");
        jXLabel20.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel20.setOpaque(true);

        jXLabel22.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel22.setText("X");
        jXLabel22.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel22.setOpaque(true);

        jXLabel23.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel23.setText("C");
        jXLabel23.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel23.setOpaque(true);

        jXLabel24.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel24.setText("Z");
        jXLabel24.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel24.setOpaque(true);

        jXLabel25.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel25.setText("N");
        jXLabel25.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel25.setOpaque(true);

        jXLabel26.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel26.setText("M");
        jXLabel26.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel26.setOpaque(true);

        jXLabel27.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel27.setText("V");
        jXLabel27.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel27.setOpaque(true);

        jXLabel28.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel28.setText("B");
        jXLabel28.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel28.setOpaque(true);

        jXLabel30.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel30.setText("P");
        jXLabel30.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel30.setOpaque(true);

        jXLabel31.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel31.setText("O");
        jXLabel31.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel31.setOpaque(true);

        jXLabel32.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel32.setText("6");
        jXLabel32.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel32.setOpaque(true);

        jXLabel33.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel33.setText("5");
        jXLabel33.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel33.setOpaque(true);

        jXLabel34.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel34.setText("8");
        jXLabel34.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel34.setOpaque(true);

        jXLabel35.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel35.setText("7");
        jXLabel35.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel35.setOpaque(true);

        jXLabel36.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel36.setText("9");
        jXLabel36.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel36.setOpaque(true);

        jXLabel38.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel38.setText("3");
        jXLabel38.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel38.setOpaque(true);

        jXLabel39.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel39.setText("4");
        jXLabel39.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel39.setOpaque(true);

        jXLabel40.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel40.setText("1");
        jXLabel40.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel40.setOpaque(true);
        jXLabel40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel40MouseClicked(evt);
            }
        });

        jXLabel41.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel41.setText("2");
        jXLabel41.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel41.setOpaque(true);

        jXLabel42.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel42.setText("Space");
        jXLabel42.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel42.setOpaque(true);

        jXLabel29.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel29.setText("Clear");
        jXLabel29.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel29.setOpaque(true);
        jXLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel29MouseClicked(evt);
            }
        });

        jXLabel37.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel37.setText("Login");
        jXLabel37.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel37.setOpaque(true);
        jXLabel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel37MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jXLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jXLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jXLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jXLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jXLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jXLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jXLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jXLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jXLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jXLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jXLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jXLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jXLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jXLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jXLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jXLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jXLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jXLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jXLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jXLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jXLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jXLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jXLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jXLabel44.setBackground(new java.awt.Color(9, 79, 149));
        jXLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel44.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXLabel44.setText(" Username:");
        jXLabel44.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jXLabel44.setOpaque(true);
        jXLabel44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel44MouseClicked(evt);
            }
        });

        tf_username.setBackground(new java.awt.Color(238, 233, 233));
        tf_username.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        tf_username.setForeground(new java.awt.Color(9, 79, 149));
        tf_username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(9, 79, 149)));
        tf_username.setMargin(new java.awt.Insets(2, 10, 2, 2));
        tf_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_usernameActionPerformed(evt);
            }
        });

        jXLabel46.setBackground(new java.awt.Color(9, 79, 149));
        jXLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel46.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXLabel46.setText(" Password:");
        jXLabel46.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jXLabel46.setOpaque(true);
        jXLabel46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel46MouseClicked(evt);
            }
        });

        jXLabel47.setBackground(new java.awt.Color(9, 79, 149));
        jXLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel47.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons/HOME_48x48-32.png"))); // NOI18N
        jXLabel47.setText(" Login with your Credentials");
        jXLabel47.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jXLabel47.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jXLabel47.setIconTextGap(1);
        jXLabel47.setLineWrap(true);
        jXLabel47.setOpaque(true);
        jXLabel47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel47MouseClicked(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(9, 79, 149));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addContainerGap())
        );

        tf_password.setBackground(new java.awt.Color(238, 233, 233));
        tf_password.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        tf_password.setForeground(new java.awt.Color(9, 79, 149));
        tf_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_passwordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jXLabel47, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_username, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_password)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jXLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_username, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jXLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jXLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_password, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(9, 79, 149));

        jLabel20.setBackground(new java.awt.Color(249, 154, 4));
        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 40)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Synapse Software Technologies");

        jLabel21.setBackground(new java.awt.Color(249, 154, 4));
        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Integrating Business with Technology ");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons/1 (Custom).png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(213, 213, 213)))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20)
                .addGap(0, 0, 0)
                .addComponent(jLabel21)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jXLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel2MouseClicked

    }//GEN-LAST:event_jXLabel2MouseClicked

    private void jXLabel40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel40MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel40MouseClicked

    private void jXLabel44MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel44MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel44MouseClicked

    private void jXLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel29MouseClicked


    }//GEN-LAST:event_jXLabel29MouseClicked

    private void jXLabel46MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel46MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel46MouseClicked

    private void jXLabel47MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel47MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel47MouseClicked

    private void tf_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_usernameActionPerformed
        ok1();
    }//GEN-LAST:event_tf_usernameActionPerformed

    private void jXLabel37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel37MouseClicked
        ok1();
    }//GEN-LAST:event_jXLabel37MouseClicked

    private void tf_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_passwordActionPerformed
        ok1();
    }//GEN-LAST:event_tf_passwordActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private org.jdesktop.swingx.JXLabel jXLabel10;
    private org.jdesktop.swingx.JXLabel jXLabel12;
    private org.jdesktop.swingx.JXLabel jXLabel13;
    private org.jdesktop.swingx.JXLabel jXLabel14;
    private org.jdesktop.swingx.JXLabel jXLabel15;
    private org.jdesktop.swingx.JXLabel jXLabel16;
    private org.jdesktop.swingx.JXLabel jXLabel17;
    private org.jdesktop.swingx.JXLabel jXLabel18;
    private org.jdesktop.swingx.JXLabel jXLabel19;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXLabel jXLabel20;
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
    private org.jdesktop.swingx.JXLabel jXLabel31;
    private org.jdesktop.swingx.JXLabel jXLabel32;
    private org.jdesktop.swingx.JXLabel jXLabel33;
    private org.jdesktop.swingx.JXLabel jXLabel34;
    private org.jdesktop.swingx.JXLabel jXLabel35;
    private org.jdesktop.swingx.JXLabel jXLabel36;
    private org.jdesktop.swingx.JXLabel jXLabel37;
    private org.jdesktop.swingx.JXLabel jXLabel38;
    private org.jdesktop.swingx.JXLabel jXLabel39;
    private org.jdesktop.swingx.JXLabel jXLabel4;
    private org.jdesktop.swingx.JXLabel jXLabel40;
    private org.jdesktop.swingx.JXLabel jXLabel41;
    private org.jdesktop.swingx.JXLabel jXLabel42;
    private org.jdesktop.swingx.JXLabel jXLabel44;
    private org.jdesktop.swingx.JXLabel jXLabel46;
    private org.jdesktop.swingx.JXLabel jXLabel47;
    private org.jdesktop.swingx.JXLabel jXLabel5;
    private org.jdesktop.swingx.JXLabel jXLabel6;
    private org.jdesktop.swingx.JXLabel jXLabel7;
    private org.jdesktop.swingx.JXLabel jXLabel8;
    private org.jdesktop.swingx.JXLabel jXLabel9;
    private javax.swing.JPasswordField tf_password;
    private javax.swing.JTextField tf_username;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
        init_key();
        Border line = BorderFactory.createLineBorder(new java.awt.Color(9, 79, 149));
        Border empty = new EmptyBorder(0, 20, 0, 0);
        CompoundBorder border = new CompoundBorder(line, empty);
        tf_username.setBorder(border);
        tf_password.setBorder(border);
        tf_username.grabFocus();
        type();

        jXLabel29.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tf_username.hasFocus()) {
                    String txt = tf_username.getText();
                    if (!txt.isEmpty()) {
                        txt = txt.substring(0, txt.length() - 1);
                        tf_username.setText(txt);
//                        ok1();
                    }
                } else {
                    String txt = tf_password.getText();
                    if (!txt.isEmpty()) {
                        txt = txt.substring(0, txt.length() - 1);
                        tf_password.setText(txt);
//                        ok1();
                    }
                }

            }
        });

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

    private void type() {

        JXLabel[] lbl = {
            jXLabel40, jXLabel41, jXLabel38, jXLabel39, jXLabel33, jXLabel32, jXLabel35, jXLabel34, jXLabel36, jXLabel2, jXLabel3, jXLabel4, jXLabel5, jXLabel6, jXLabel7, jXLabel8, jXLabel9, jXLabel10, jXLabel12, jXLabel14, jXLabel13, jXLabel15, jXLabel16, jXLabel17, jXLabel18, jXLabel19, jXLabel20, jXLabel24, jXLabel22, jXLabel23, jXLabel27, jXLabel28, jXLabel25, jXLabel26, jXLabel30, jXLabel31};

        for (final JXLabel l : lbl) {
            l.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {

                    if (tf_username.hasFocus()) {
                        String text = tf_username.getText();
                        text = text + l.getText();
                        tf_username.setText(text);
                    } else {
                        String text = tf_password.getText();
                        text = text + l.getText();
                        tf_password.setText(text);
                    }

                }

            });
        }
        jXLabel42.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tf_username.hasFocus()) {
                    String text = tf_username.getText();
                    text = text + " ";
                    tf_username.setText(text);
                } else {
                    String text = tf_password.getText();
                    text = text + "";
                    tf_password.setText(text);
                }

            }
        });
    }

    private void ok1() {
        final String user_name = tf_username.getText();
        String date = DateType.sf.format(new Date());
        String password = tf_password.getText();
        final S1_users.to_users to = S1_users.ret_data_autho(user_name, password);
        if (to == null) {
            Alert.set(0, "WRONG USERNAME/PASSWORD");
            tf_password.setText("");
            tf_username.setText("");
            tf_username.grabFocus();
        } else {

            Users.setT_sales(to.t_sales);
            Users.setT_receipts(to.t_receipts);
            Users.setT_stock_transfer(to.t_stock_transfer);
            Users.setM_items(to.m_items);
            Users.setM_category(to.m_category);
            Users.setM_users(to.m_users);

            Users.setM_uom(to.m_uom);
            Users.setM_suppliers(to.m_suppliers);
            Users.setR_sales(to.r_sales);
            Users.setR_cash_count(to.r_cash_count);
            Users.setR_receipts(to.r_receipts);

            Users.setR_stock_transferred(to.r_stock_transferred);
            Users.setR_stock_take(to.r_stock_take);
            Users.setM_customers(to.m_customers);
            Users.setM_discount(to.m_discount);
            Users.setM_banks(to.m_banks);
            Users.setR_stock_left_supplier(to.r_stock_left_supplier);
            Users.setT_inventory_adjuster(to.t_inventory_adjuster);

            if (to.user_level == 1) {
                S1_cash_drawer.to_cash_drawer to1 = S1_cash_drawer.ret_data2(user_name, date);
                if (to1 == null) {
                    Window p = (Window) this;
                    Dlg_cashin nd = Dlg_cashin.create(p, true);
                    nd.setTitle("");
//                               nd.do_pass("");
                    nd.setCallback(new Dlg_cashin.Callback() {

                        @Override
                        public void ok(CloseDialog closeDialog, Dlg_cashin.OutputData data) {
                            closeDialog.ok();
                            int id = 1;
                            String session_no = S1_cash_drawer.increment_id();
                            String user_name1 = to.user_name;
                            String screen_name1 = to.screen_name;
                            String time_in = DateType.datetime.format(new Date());
                            String time_out = null;
                            double amount = data.amount;
                            S1_cash_drawer.to_cash_drawer to2 = new S1_cash_drawer.to_cash_drawer(id, session_no, user_name1, screen_name1, time_in, time_out, amount, 0, 0, 0, 0, 0, 0, 0, 0, new ArrayList(), new ArrayList(), 0);
                            S1_cash_drawer.add_cash_drawer(to2);
                            Users.setSession_no(session_no);
                            Users.setScreen_name(screen_name1);
                            Users.setUser_level(to.user_level);
                            Users.setUser_name(user_name);
                            S1_cash_drawer.to_cash_drawer.setAmount(amount);

                            Users.setTime_in(time_in);
                            ok2();
                        }
                    });
                    nd.setLocationRelativeTo(this);
                    nd.setVisible(true);
                } else {
                    Users.setSession_no(to1.session_no);
                    Users.setScreen_name(to1.screen_name);
                    Users.setUser_level(to.user_level);
                    Users.setUser_name(user_name);
                    Users.setTime_in(to1.time_in);
                    if (to1.time_out == null) {
                        Users.setIs_active(0);
                    } else {
                        Users.setIs_active(1);
                    }

                    Users.setChecks(to1.checks);
                    Users.setDrawer(to1);
                    ok2();
                }
            } else {
                Users.setSession_no("");
                Users.setScreen_name(to.screen_name);
                Users.setUser_level(to.user_level);
                Users.setUser_name(user_name);
                ok2();
            }
        }
//        }
    }

    private void ok2() {
        if (callback != null) {
            callback.ok(new CloseDialog(this), new Dlg_touchscreen_login.OutputData());
        }
    }
}
