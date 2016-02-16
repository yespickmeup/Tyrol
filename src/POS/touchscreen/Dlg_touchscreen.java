/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen;

import POS.cash_drawer.Dlg_cash_out;
import POS.cash_drawer.S1_cash_drawer;
import POS.cash_drawer.S1_cash_drawer_checks;
import POS.category.S1_inv_categories;
import POS.category.S1_inv_categories.to_inv_categories;
import POS.customers.S1_customers;
import POS.customers.S1_customers.to_customers;
import POS.items.S1_items;
import POS.items.S1_items.to_items;
import POS.pnl.Pnl_Dashboard;
import POS.printing_assembly.S1_printing_assembly;
import POS.sales.S1_sales;
import POS.table_customer_discounts.S1_table_customer_discounts;
import POS.table_customer_discounts.S1_table_customer_discounts.to_table_customer_discounts;
import POS.table_customer_orders.S1_table_customer_orders;
import POS.table_customer_orders.S1_table_customer_orders.to_table_customer_orders;
import POS.table_customer_orders.S1_table_customer_orders_queue.to_table_customer_orders_queue;
import POS.table_customers.S1_table_customers;
import POS.table_customers.S1_table_customers.to_table_customers;
import POS.tables.S1_table_transfer;
import POS.tables.S1_tables;
import POS.tables.S1_tables.to_tables;
import POS.touchscreen_printing.Srpt_billing_statement;
import POS.touchscreen_printing.Srpt_printing_assembly;
import POS.util.Alert;
import POS.util.DateType;
import POS.util.Focus_Fire;
import POS.util.Users;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.JasperUtil;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import org.jdesktop.swingx.JXLabel;

/**
 *
 * @author Ronald
 */
public class Dlg_touchscreen extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_touchscreen
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
    private Dlg_touchscreen(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_touchscreen(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_touchscreen() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_touchscreen myRef;

    private void setThisRef(Dlg_touchscreen myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_touchscreen> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_touchscreen create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_touchscreen create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_touchscreen dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen((java.awt.Frame) parent, false);
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
            Dlg_touchscreen dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen((java.awt.Dialog) parent, false);
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
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }

        Dlg_touchscreen dialog = Dlg_touchscreen.create(new javax.swing.JFrame(), true);
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
        jPanel15 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        pnl_item_holder = new javax.swing.JPanel();
        pnl_table_orders = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jXLabel15 = new org.jdesktop.swingx.JXLabel();
        jXLabel16 = new org.jdesktop.swingx.JXLabel();
        jXLabel17 = new org.jdesktop.swingx.JXLabel();
        jLabel30 = new javax.swing.JLabel();
        jXLabel54 = new org.jdesktop.swingx.JXLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_table_customer_orders = new javax.swing.JTable();
        pnl_search_item = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_inv_categories = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jXLabel8 = new org.jdesktop.swingx.JXLabel();
        jXLabel10 = new org.jdesktop.swingx.JXLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_items = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jXLabel9 = new org.jdesktop.swingx.JXLabel();
        jXLabel11 = new org.jdesktop.swingx.JXLabel();
        jXLabel12 = new org.jdesktop.swingx.JXLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        pnl_customers = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jXLabel23 = new org.jdesktop.swingx.JXLabel();
        jXLabel24 = new org.jdesktop.swingx.JXLabel();
        jXLabel25 = new org.jdesktop.swingx.JXLabel();
        jXLabel26 = new org.jdesktop.swingx.JXLabel();
        jXLabel27 = new org.jdesktop.swingx.JXLabel();
        jXLabel28 = new org.jdesktop.swingx.JXLabel();
        jXLabel29 = new org.jdesktop.swingx.JXLabel();
        jXLabel30 = new org.jdesktop.swingx.JXLabel();
        jXLabel31 = new org.jdesktop.swingx.JXLabel();
        jXLabel32 = new org.jdesktop.swingx.JXLabel();
        jXLabel33 = new org.jdesktop.swingx.JXLabel();
        jXLabel34 = new org.jdesktop.swingx.JXLabel();
        jXLabel35 = new org.jdesktop.swingx.JXLabel();
        jXLabel36 = new org.jdesktop.swingx.JXLabel();
        jXLabel37 = new org.jdesktop.swingx.JXLabel();
        jXLabel38 = new org.jdesktop.swingx.JXLabel();
        jXLabel39 = new org.jdesktop.swingx.JXLabel();
        jXLabel40 = new org.jdesktop.swingx.JXLabel();
        jXLabel41 = new org.jdesktop.swingx.JXLabel();
        jXLabel42 = new org.jdesktop.swingx.JXLabel();
        jXLabel43 = new org.jdesktop.swingx.JXLabel();
        jXLabel44 = new org.jdesktop.swingx.JXLabel();
        jXLabel45 = new org.jdesktop.swingx.JXLabel();
        jXLabel46 = new org.jdesktop.swingx.JXLabel();
        jXLabel47 = new org.jdesktop.swingx.JXLabel();
        jXLabel48 = new org.jdesktop.swingx.JXLabel();
        jXLabel49 = new org.jdesktop.swingx.JXLabel();
        jLabel37 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jXLabel59 = new org.jdesktop.swingx.JXLabel();
        jXLabel61 = new org.jdesktop.swingx.JXLabel();
        jXLabel62 = new org.jdesktop.swingx.JXLabel();
        jXLabel55 = new org.jdesktop.swingx.JXLabel();
        jXLabel56 = new org.jdesktop.swingx.JXLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbl_table_customers = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_customers = new javax.swing.JTable();
        jPanel20 = new javax.swing.JPanel();
        jXLabel50 = new org.jdesktop.swingx.JXLabel();
        jXLabel52 = new org.jdesktop.swingx.JXLabel();
        jXLabel53 = new org.jdesktop.swingx.JXLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbl_table_name = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_table_guest_no = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_table_id = new javax.swing.JLabel();
        lbl_waiter_id = new javax.swing.JLabel();
        pnl_table_holder = new javax.swing.JPanel();
        pnl_table = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        jXLabel4 = new org.jdesktop.swingx.JXLabel();
        jXLabel7 = new org.jdesktop.swingx.JXLabel();
        jXLabel6 = new org.jdesktop.swingx.JXLabel();
        jXLabel5 = new org.jdesktop.swingx.JXLabel();
        jXLabel51 = new org.jdesktop.swingx.JXLabel();
        jXLabel63 = new org.jdesktop.swingx.JXLabel();
        tf_waiter = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_tables = new javax.swing.JTable();
        jXLabel13 = new org.jdesktop.swingx.JXLabel();
        jXLabel14 = new org.jdesktop.swingx.JXLabel();
        pnl_orders = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jXLabel18 = new org.jdesktop.swingx.JXLabel();
        jXLabel19 = new org.jdesktop.swingx.JXLabel();
        jXLabel20 = new org.jdesktop.swingx.JXLabel();
        jXLabel21 = new org.jdesktop.swingx.JXLabel();
        jXLabel22 = new org.jdesktop.swingx.JXLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_table_customer_orders_queue = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.setPreferredSize(new java.awt.Dimension(789, 768));

        jPanel15.setBackground(new java.awt.Color(205, 133, 0));

        jLabel20.setBackground(new java.awt.Color(249, 154, 4));
        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 40)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Synapse Software Technologies");

        jLabel21.setBackground(new java.awt.Color(249, 154, 4));
        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("Integrating Business with Technology");

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons/1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel21)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_item_holder.setBackground(new java.awt.Color(255, 255, 255));
        pnl_item_holder.setLayout(new java.awt.CardLayout());

        pnl_table_orders.setBackground(new java.awt.Color(255, 255, 255));

        jLabel26.setBackground(new java.awt.Color(154, 123, 72));
        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("     Qty");
        jLabel26.setOpaque(true);

        jLabel27.setBackground(new java.awt.Color(154, 123, 72));
        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("  Description");
        jLabel27.setOpaque(true);

        jLabel28.setBackground(new java.awt.Color(154, 123, 72));
        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Amount  ");
        jLabel28.setOpaque(true);

        jLabel29.setBackground(new java.awt.Color(154, 123, 72));
        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel29.setText("  Price  ");
        jLabel29.setOpaque(true);

        jXLabel15.setBackground(new java.awt.Color(177, 109, 3));
        jXLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons/arrow_right_24.png"))); // NOI18N
        jXLabel15.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jXLabel15.setOpaque(true);
        jXLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel15MouseClicked(evt);
            }
        });

        jXLabel16.setBackground(new java.awt.Color(177, 109, 3));
        jXLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons/arrow_left_24.png"))); // NOI18N
        jXLabel16.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jXLabel16.setOpaque(true);
        jXLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel16MouseClicked(evt);
            }
        });

        jXLabel17.setBackground(new java.awt.Color(9, 79, 149));
        jXLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons/delete-24.png"))); // NOI18N
        jXLabel17.setText("Delete");
        jXLabel17.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jXLabel17.setOpaque(true);
        jXLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel17MouseClicked(evt);
            }
        });

        jLabel30.setBackground(new java.awt.Color(249, 154, 4));
        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(200, 124, 4));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jXLabel54.setBackground(new java.awt.Color(9, 79, 149));
        jXLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons/back_24.png"))); // NOI18N
        jXLabel54.setText("Back");
        jXLabel54.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jXLabel54.setOpaque(true);
        jXLabel54.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel54MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addComponent(jXLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jXLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jXLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jXLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jXLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jXLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jXLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tbl_table_customer_orders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_table_customer_orders.setSelectionBackground(new java.awt.Color(226, 221, 181));
        tbl_table_customer_orders.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tbl_table_customer_orders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_table_customer_ordersMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_table_customer_orders);

        javax.swing.GroupLayout pnl_table_ordersLayout = new javax.swing.GroupLayout(pnl_table_orders);
        pnl_table_orders.setLayout(pnl_table_ordersLayout);
        pnl_table_ordersLayout.setHorizontalGroup(
            pnl_table_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_table_ordersLayout.createSequentialGroup()
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE)
        );
        pnl_table_ordersLayout.setVerticalGroup(
            pnl_table_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_table_ordersLayout.createSequentialGroup()
                .addGroup(pnl_table_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pnl_item_holder.add(pnl_table_orders, "card2");

        pnl_search_item.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setBackground(new java.awt.Color(249, 154, 4));
        jScrollPane2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jScrollPane2.setForeground(new java.awt.Color(249, 154, 4));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane2.setEnabled(false);

        tbl_inv_categories.setBackground(new java.awt.Color(9, 79, 149));
        tbl_inv_categories.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 154, 4)));
        tbl_inv_categories.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbl_inv_categories.setForeground(new java.awt.Color(255, 255, 255));
        tbl_inv_categories.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Category"
            }
        ));
        tbl_inv_categories.setGridColor(new java.awt.Color(204, 204, 204));
        tbl_inv_categories.setRowHeight(35);
        tbl_inv_categories.setSelectionBackground(new java.awt.Color(12, 117, 223));
        tbl_inv_categories.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_inv_categoriesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_inv_categories);

        jXLabel8.setBackground(new java.awt.Color(177, 109, 3));
        jXLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons/arrow_right_24.png"))); // NOI18N
        jXLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jXLabel8.setOpaque(true);
        jXLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel8MouseClicked(evt);
            }
        });

        jXLabel10.setBackground(new java.awt.Color(177, 109, 3));
        jXLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons/arrow_left_24.png"))); // NOI18N
        jXLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jXLabel10.setOpaque(true);
        jXLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jXLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jXLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
            .addComponent(jXLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel13.setBackground(new java.awt.Color(154, 123, 72));
        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("  Categories");
        jLabel13.setOpaque(true);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane3.setBackground(new java.awt.Color(249, 154, 4));
        jScrollPane3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jScrollPane3.setForeground(new java.awt.Color(249, 154, 4));
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane3.setEnabled(false);

        tbl_items.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbl_items.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Category"
            }
        ));
        tbl_items.setGridColor(new java.awt.Color(204, 204, 204));
        tbl_items.setRowHeight(35);
        tbl_items.setSelectionBackground(new java.awt.Color(226, 221, 181));
        tbl_items.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tbl_items.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_itemsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_items);

        jXLabel9.setBackground(new java.awt.Color(177, 109, 3));
        jXLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons/arrow_right_24.png"))); // NOI18N
        jXLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jXLabel9.setOpaque(true);
        jXLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel9MouseClicked(evt);
            }
        });

        jXLabel11.setBackground(new java.awt.Color(177, 109, 3));
        jXLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons/arrow_left_24.png"))); // NOI18N
        jXLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jXLabel11.setOpaque(true);
        jXLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel11MouseClicked(evt);
            }
        });

        jXLabel12.setBackground(new java.awt.Color(9, 79, 149));
        jXLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons/SEARCH_48x48-32.png"))); // NOI18N
        jXLabel12.setText("Search");
        jXLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jXLabel12.setOpaque(true);
        jXLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel12MouseClicked(evt);
            }
        });

        jLabel23.setBackground(new java.awt.Color(249, 154, 4));
        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(200, 124, 4));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jXLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jXLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jXLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jXLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jXLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel18.setBackground(new java.awt.Color(154, 123, 72));
        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("  Description");
        jLabel18.setOpaque(true);

        jLabel17.setBackground(new java.awt.Color(154, 123, 72));
        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("  Qty");
        jLabel17.setOpaque(true);

        jLabel19.setBackground(new java.awt.Color(154, 123, 72));
        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Price  ");
        jLabel19.setOpaque(true);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnl_search_itemLayout = new javax.swing.GroupLayout(pnl_search_item);
        pnl_search_item.setLayout(pnl_search_itemLayout);
        pnl_search_itemLayout.setHorizontalGroup(
            pnl_search_itemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_search_itemLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_search_itemLayout.setVerticalGroup(
            pnl_search_itemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_search_itemLayout.createSequentialGroup()
                .addGroup(pnl_search_itemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        pnl_item_holder.add(pnl_search_item, "card3");

        pnl_customers.setBackground(new java.awt.Color(255, 255, 255));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        jLabel35.setBackground(new java.awt.Color(154, 123, 72));
        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel35.setText("  Name");
        jLabel35.setOpaque(true);

        jLabel36.setBackground(new java.awt.Color(154, 123, 72));
        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Action");
        jLabel36.setOpaque(true);

        jXLabel23.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel23.setText("Q");
        jXLabel23.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel23.setOpaque(true);
        jXLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel23MouseClicked(evt);
            }
        });

        jXLabel24.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel24.setText("W");
        jXLabel24.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel24.setOpaque(true);

        jXLabel25.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel25.setText("E");
        jXLabel25.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel25.setOpaque(true);

        jXLabel26.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel26.setText("R");
        jXLabel26.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel26.setOpaque(true);

        jXLabel27.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel27.setText("T");
        jXLabel27.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel27.setOpaque(true);

        jXLabel28.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel28.setText("Y");
        jXLabel28.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel28.setOpaque(true);

        jXLabel29.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel29.setText("U");
        jXLabel29.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel29.setOpaque(true);

        jXLabel30.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel30.setText("I");
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
        jXLabel32.setText("A");
        jXLabel32.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel32.setOpaque(true);

        jXLabel33.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel33.setText("D");
        jXLabel33.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel33.setOpaque(true);

        jXLabel34.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel34.setText("S");
        jXLabel34.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel34.setOpaque(true);

        jXLabel35.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel35.setText("F");
        jXLabel35.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel35.setOpaque(true);

        jXLabel36.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel36.setText("G");
        jXLabel36.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel36.setOpaque(true);

        jXLabel37.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel37.setText("H");
        jXLabel37.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel37.setOpaque(true);

        jXLabel38.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel38.setText("J");
        jXLabel38.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel38.setOpaque(true);

        jXLabel39.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel39.setText("K");
        jXLabel39.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel39.setOpaque(true);

        jXLabel40.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel40.setText("L");
        jXLabel40.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel40.setOpaque(true);

        jXLabel41.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel41.setText("X");
        jXLabel41.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel41.setOpaque(true);

        jXLabel42.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel42.setText("C");
        jXLabel42.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel42.setOpaque(true);

        jXLabel43.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel43.setText("Z");
        jXLabel43.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel43.setOpaque(true);

        jXLabel44.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel44.setText("N");
        jXLabel44.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel44.setOpaque(true);

        jXLabel45.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel45.setText("M");
        jXLabel45.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel45.setOpaque(true);

        jXLabel46.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel46.setText("V");
        jXLabel46.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel46.setOpaque(true);

        jXLabel47.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel47.setText("B");
        jXLabel47.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel47.setOpaque(true);

        jXLabel48.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel48.setText("P");
        jXLabel48.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel48.setOpaque(true);

        jXLabel49.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel49.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel49.setOpaque(true);

        jLabel37.setBackground(new java.awt.Color(9, 79, 149));
        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("+");
        jLabel37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 154, 4)));
        jLabel37.setOpaque(true);
        jLabel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel37MouseClicked(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(249, 154, 4));
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(249, 154, 4)));
        jTextField1.setMargin(new java.awt.Insets(2, 10, 2, 2));

        jXLabel59.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel59.setText("Space");
        jXLabel59.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel59.setOpaque(true);

        jXLabel61.setBackground(new java.awt.Color(201, 125, 3));
        jXLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel61.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXLabel61.setText("  Search:");
        jXLabel61.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jXLabel61.setOpaque(true);
        jXLabel61.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel61MouseClicked(evt);
            }
        });

        jXLabel62.setBackground(new java.awt.Color(249, 154, 4));
        jXLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel62.setText("Clear");
        jXLabel62.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jXLabel62.setOpaque(true);
        jXLabel62.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel62MouseClicked(evt);
            }
        });

        jXLabel55.setBackground(new java.awt.Color(154, 123, 72));
        jXLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons/arrow_left_16.png"))); // NOI18N
        jXLabel55.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jXLabel55.setOpaque(true);
        jXLabel55.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel55MouseClicked(evt);
            }
        });

        jXLabel56.setBackground(new java.awt.Color(154, 123, 72));
        jXLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons/arrow_right_16.png"))); // NOI18N
        jXLabel56.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jXLabel56.setOpaque(true);
        jXLabel56.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel56MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel19Layout.createSequentialGroup()
                    .addComponent(jXLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(1, 1, 1)
                    .addComponent(jXLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(1, 1, 1)
                    .addComponent(jXLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(1, 1, 1)
                    .addComponent(jXLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(1, 1, 1)
                    .addComponent(jXLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(1, 1, 1)
                    .addComponent(jXLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(1, 1, 1)
                    .addComponent(jXLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(1, 1, 1)
                    .addComponent(jXLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(1, 1, 1)
                    .addComponent(jXLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel19Layout.createSequentialGroup()
                    .addComponent(jXLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(jTextField1)
                    .addGap(0, 0, 0)
                    .addComponent(jXLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(1, 1, 1)
                    .addComponent(jXLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addComponent(jXLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jXLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jXLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jXLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jXLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jXLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jXLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jXLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jXLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jXLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jXLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jXLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jXLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jXLabel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel19Layout.createSequentialGroup()
                        .addComponent(jXLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jXLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addGap(0, 0, 0)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jXLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jXLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jXLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jXLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jXLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jXLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jXLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jScrollPane7.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane7.setBorder(null);
        jScrollPane7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane7.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tbl_table_customers.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        tbl_table_customers.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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
        tbl_table_customers.setGridColor(new java.awt.Color(204, 204, 204));
        tbl_table_customers.setSelectionBackground(new java.awt.Color(226, 221, 181));
        tbl_table_customers.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tbl_table_customers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_table_customersMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tbl_table_customers);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane7)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));

        jLabel38.setBackground(new java.awt.Color(154, 123, 72));
        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel38.setText("  Customers List");
        jLabel38.setOpaque(true);

        jScrollPane6.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane6.setBorder(null);
        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane6.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tbl_customers.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbl_customers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_customers.setGridColor(new java.awt.Color(204, 204, 204));
        tbl_customers.setSelectionBackground(new java.awt.Color(226, 221, 181));
        tbl_customers.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tbl_customers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_customersMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbl_customers);

        jXLabel50.setBackground(new java.awt.Color(9, 79, 149));
        jXLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons/back_24.png"))); // NOI18N
        jXLabel50.setText("Back");
        jXLabel50.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jXLabel50.setOpaque(true);
        jXLabel50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel50MouseClicked(evt);
            }
        });

        jXLabel52.setBackground(new java.awt.Color(177, 109, 3));
        jXLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons/arrow_left_24.png"))); // NOI18N
        jXLabel52.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jXLabel52.setOpaque(true);
        jXLabel52.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel52MouseClicked(evt);
            }
        });

        jXLabel53.setBackground(new java.awt.Color(177, 109, 3));
        jXLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons/arrow_right_24.png"))); // NOI18N
        jXLabel53.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jXLabel53.setOpaque(true);
        jXLabel53.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel53MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jXLabel53MouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jXLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                .addGap(2, 2, 2)
                .addComponent(jXLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(jXLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jXLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                    .addComponent(jXLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnl_customersLayout = new javax.swing.GroupLayout(pnl_customers);
        pnl_customers.setLayout(pnl_customersLayout);
        pnl_customersLayout.setHorizontalGroup(
            pnl_customersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_customersLayout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnl_customersLayout.setVerticalGroup(
            pnl_customersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnl_item_holder.add(pnl_customers, "card4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_item_holder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnl_item_holder, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel2.setPreferredSize(new java.awt.Dimension(577, 768));

        jPanel5.setBackground(new java.awt.Color(218, 202, 176));

        jLabel1.setBackground(new java.awt.Color(249, 154, 4));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Table:");

        lbl_table_name.setBackground(new java.awt.Color(249, 154, 4));
        lbl_table_name.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbl_table_name.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setBackground(new java.awt.Color(249, 154, 4));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Available:");

        lbl_table_guest_no.setBackground(new java.awt.Color(249, 154, 4));
        lbl_table_guest_no.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_table_guest_no.setForeground(new java.awt.Color(255, 255, 255));
        lbl_table_guest_no.setText("0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_table_name, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(lbl_table_guest_no, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_table_name, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbl_table_guest_no, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel5.setBackground(new java.awt.Color(249, 154, 4));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(249, 154, 4));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel6.setBackground(new java.awt.Color(249, 154, 4));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(249, 154, 4));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel7.setBackground(new java.awt.Color(249, 154, 4));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(249, 154, 4));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Point");

        jLabel9.setBackground(new java.awt.Color(249, 154, 4));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(249, 154, 4));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Sale");

        jLabel8.setBackground(new java.awt.Color(249, 154, 4));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(249, 154, 4));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("of");

        jLabel10.setBackground(new java.awt.Color(249, 154, 4));
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(249, 154, 4));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Good day, Ronald");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(5, 5, 5)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(lbl_table_id, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_waiter_id, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_waiter_id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_table_id, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        pnl_table_holder.setLayout(new java.awt.CardLayout());

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel22.setBackground(new java.awt.Color(154, 123, 72));
        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("  Table");
        jLabel22.setOpaque(true);

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

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel11.setBackground(new java.awt.Color(249, 154, 4));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(249, 154, 4));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Total Amount:");

        jLabel12.setBackground(new java.awt.Color(249, 154, 4));
        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(249, 154, 4));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("0.00");

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setPreferredSize(new java.awt.Dimension(124, 89));

        jLabel14.setBackground(new java.awt.Color(201, 124, 4));
        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(201, 124, 4));
        jLabel14.setText("Total");

        jLabel15.setBackground(new java.awt.Color(201, 124, 4));
        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(201, 124, 4));
        jLabel15.setText("Items:");

        jLabel16.setBackground(new java.awt.Color(201, 124, 4));
        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(201, 124, 4));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("0");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jXLabel1.setBackground(new java.awt.Color(9, 79, 149));
        jXLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons/DOWNLOAD_48x48-32.png"))); // NOI18N
        jXLabel1.setText("Order");
        jXLabel1.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jXLabel1.setOpaque(true);
        jXLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel1MouseClicked(evt);
            }
        });

        jXLabel2.setBackground(new java.awt.Color(9, 79, 149));
        jXLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons/money-bag-48.png"))); // NOI18N
        jXLabel2.setText("Pay");
        jXLabel2.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jXLabel2.setOpaque(true);
        jXLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel2MouseClicked(evt);
            }
        });

        jXLabel3.setBackground(new java.awt.Color(9, 79, 149));
        jXLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons/PRINTER_48x48-32.png"))); // NOI18N
        jXLabel3.setText("Print");
        jXLabel3.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jXLabel3.setOpaque(true);
        jXLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel3MouseClicked(evt);
            }
        });

        jXLabel4.setBackground(new java.awt.Color(9, 79, 149));
        jXLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons/FILE - TEXT_48x48-32.png"))); // NOI18N
        jXLabel4.setText("Bill");
        jXLabel4.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jXLabel4.setOpaque(true);
        jXLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel4MouseClicked(evt);
            }
        });

        jXLabel7.setBackground(new java.awt.Color(9, 79, 149));
        jXLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons/POWER - SLEEP_48x48-32.png"))); // NOI18N
        jXLabel7.setText("Standby");
        jXLabel7.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jXLabel7.setOpaque(true);
        jXLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel7MouseClicked(evt);
            }
        });

        jXLabel6.setBackground(new java.awt.Color(9, 79, 149));
        jXLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons/DEFRAG_48x48-32.png"))); // NOI18N
        jXLabel6.setText("Report");
        jXLabel6.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jXLabel6.setOpaque(true);
        jXLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel6MouseClicked(evt);
            }
        });

        jXLabel5.setBackground(new java.awt.Color(9, 79, 149));
        jXLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons/POWER - SHUT DOWN_48x48-32.png"))); // NOI18N
        jXLabel5.setText("Exit  ");
        jXLabel5.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jXLabel5.setOpaque(true);
        jXLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel5MouseClicked(evt);
            }
        });

        jXLabel51.setBackground(new java.awt.Color(9, 79, 149));
        jXLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons/POWER - SWITCH USER_32x32-32_1.png"))); // NOI18N
        jXLabel51.setText("Transfer");
        jXLabel51.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jXLabel51.setOpaque(true);
        jXLabel51.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel51MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jXLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(jXLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jXLabel63.setBackground(new java.awt.Color(154, 123, 72));
        jXLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel63.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXLabel63.setText("  Waiter:");
        jXLabel63.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jXLabel63.setOpaque(true);
        jXLabel63.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel63MouseClicked(evt);
            }
        });

        tf_waiter.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tf_waiter.setForeground(new java.awt.Color(154, 123, 72));
        tf_waiter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(154, 123, 72)));
        tf_waiter.setMargin(new java.awt.Insets(2, 10, 2, 2));
        tf_waiter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_waiterMouseClicked(evt);
            }
        });

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

        javax.swing.GroupLayout pnl_tableLayout = new javax.swing.GroupLayout(pnl_table);
        pnl_table.setLayout(pnl_tableLayout);
        pnl_tableLayout.setHorizontalGroup(
            pnl_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_tableLayout.createSequentialGroup()
                .addComponent(jXLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tf_waiter)
                .addGap(1, 1, 1)
                .addComponent(jXLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jXLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        pnl_tableLayout.setVerticalGroup(
            pnl_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_tableLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                .addGroup(pnl_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tf_waiter, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jXLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                    .addGroup(pnl_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jXLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pnl_table_holder.add(pnl_table, "card2");

        jXLabel18.setBackground(new java.awt.Color(177, 109, 3));
        jXLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons/arrow_right_24.png"))); // NOI18N
        jXLabel18.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jXLabel18.setOpaque(true);
        jXLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel18MouseClicked(evt);
            }
        });

        jXLabel19.setBackground(new java.awt.Color(177, 109, 3));
        jXLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons/arrow_left_24.png"))); // NOI18N
        jXLabel19.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jXLabel19.setOpaque(true);
        jXLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel19MouseClicked(evt);
            }
        });

        jXLabel20.setBackground(new java.awt.Color(9, 79, 149));
        jXLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons/FILE - CERTIFICATE_48x48-32.png"))); // NOI18N
        jXLabel20.setText("Add");
        jXLabel20.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jXLabel20.setOpaque(true);
        jXLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel20MouseClicked(evt);
            }
        });

        jXLabel21.setBackground(new java.awt.Color(9, 79, 149));
        jXLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons/delete-24.png"))); // NOI18N
        jXLabel21.setText("Delete");
        jXLabel21.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jXLabel21.setOpaque(true);
        jXLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel21MouseClicked(evt);
            }
        });

        jXLabel22.setBackground(new java.awt.Color(9, 79, 149));
        jXLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons/back_24.png"))); // NOI18N
        jXLabel22.setText("Back");
        jXLabel22.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jXLabel22.setOpaque(true);
        jXLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel22MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addComponent(jXLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jXLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jXLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jXLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jXLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jXLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jLabel31.setBackground(new java.awt.Color(154, 123, 72));
        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel31.setText("  Qty");
        jLabel31.setOpaque(true);

        jLabel32.setBackground(new java.awt.Color(154, 123, 72));
        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel32.setText("  Description");
        jLabel32.setOpaque(true);

        jLabel33.setBackground(new java.awt.Color(154, 123, 72));
        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel33.setText("Price  ");
        jLabel33.setOpaque(true);

        jScrollPane5.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane5.setBorder(null);
        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tbl_table_customer_orders_queue.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbl_table_customer_orders_queue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_table_customer_orders_queue.setGridColor(new java.awt.Color(204, 204, 204));
        tbl_table_customer_orders_queue.setSelectionBackground(new java.awt.Color(226, 221, 181));
        tbl_table_customer_orders_queue.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tbl_table_customer_orders_queue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_table_customer_orders_queueMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbl_table_customer_orders_queue);

        javax.swing.GroupLayout pnl_ordersLayout = new javax.swing.GroupLayout(pnl_orders);
        pnl_orders.setLayout(pnl_ordersLayout);
        pnl_ordersLayout.setHorizontalGroup(
            pnl_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_ordersLayout.createSequentialGroup()
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane5)
        );
        pnl_ordersLayout.setVerticalGroup(
            pnl_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_ordersLayout.createSequentialGroup()
                .addGroup(pnl_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pnl_table_holder.add(pnl_orders, "card3");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_table_holder, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnl_table_holder, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jXLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel12MouseClicked
        search_item();
    }//GEN-LAST:event_jXLabel12MouseClicked

    private void tbl_itemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_itemsMouseClicked
        enter_quantity();
    }//GEN-LAST:event_tbl_itemsMouseClicked

    private void tbl_inv_categoriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_inv_categoriesMouseClicked
        data_cols_items();
    }//GEN-LAST:event_tbl_inv_categoriesMouseClicked

    private void jXLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel9MouseClicked
        next_item();
    }//GEN-LAST:event_jXLabel9MouseClicked

    private void jXLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel11MouseClicked
        previous_item();
    }//GEN-LAST:event_jXLabel11MouseClicked

    private void jXLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel10MouseClicked
        previous_category();
    }//GEN-LAST:event_jXLabel10MouseClicked

    private void jXLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel8MouseClicked
        next_category();
    }//GEN-LAST:event_jXLabel8MouseClicked

    private void jXLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel15MouseClicked
        int height = tbl_table_customer_orders.getRowHeight() * (11 - 1);
        JScrollBar bar = jScrollPane4.getVerticalScrollBar();
        bar.setValue(bar.getValue() + height);
    }//GEN-LAST:event_jXLabel15MouseClicked

    private void jXLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel16MouseClicked
        int height = tbl_table_customer_orders.getRowHeight() * (11 - 1);
        JScrollBar bar = jScrollPane4.getVerticalScrollBar();
        bar.setValue(bar.getValue() - height);
    }//GEN-LAST:event_jXLabel16MouseClicked

    private void jXLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel17MouseClicked
        delete_table_customer_order();
    }//GEN-LAST:event_jXLabel17MouseClicked

    private void jXLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel18MouseClicked
        int height = tbl_table_customer_orders_queue.getRowHeight() * (11 - 1);
        JScrollBar bar = jScrollPane5.getVerticalScrollBar();
        bar.setValue(bar.getValue() + height);
    }//GEN-LAST:event_jXLabel18MouseClicked

    private void jXLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel19MouseClicked
        int height = tbl_table_customer_orders_queue.getRowHeight() * (11 - 1);
        JScrollBar bar = jScrollPane5.getVerticalScrollBar();
        bar.setValue(bar.getValue() - height);
    }//GEN-LAST:event_jXLabel19MouseClicked

    private void jXLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel20MouseClicked
        add_table_customer_orders();

    }//GEN-LAST:event_jXLabel20MouseClicked

    private void jXLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel21MouseClicked
        delete_table_order_queue();
    }//GEN-LAST:event_jXLabel21MouseClicked

    private void jXLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel22MouseClicked
        cardLayout.show(pnl_item_holder, "1");
        cardLayout2.show(pnl_table_holder, "1");
    }//GEN-LAST:event_jXLabel22MouseClicked

    private void jXLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel23MouseClicked

    }//GEN-LAST:event_jXLabel23MouseClicked

    private void jXLabel61MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel61MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel61MouseClicked

    private void jXLabel62MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel62MouseClicked
        jTextField1.setText("");
    }//GEN-LAST:event_jXLabel62MouseClicked

    private void tbl_table_customer_orders_queueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_table_customer_orders_queueMouseClicked
        edit_table_orders_queue(evt);
    }//GEN-LAST:event_tbl_table_customer_orders_queueMouseClicked

    private void jXLabel50MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel50MouseClicked

        cardLayout.show(pnl_item_holder, "1");
    }//GEN-LAST:event_jXLabel50MouseClicked

    private void jXLabel52MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel52MouseClicked
        int height = tbl_customers.getRowHeight() * (9 - 1);
        JScrollBar bar = jScrollPane6.getVerticalScrollBar();
        bar.setValue(bar.getValue() - height);
    }//GEN-LAST:event_jXLabel52MouseClicked

    private void jXLabel53MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel53MouseClicked
        int height = tbl_customers.getRowHeight() * (9 - 1);
        JScrollBar bar = jScrollPane6.getVerticalScrollBar();
        bar.setValue(bar.getValue() + height);
    }//GEN-LAST:event_jXLabel53MouseClicked

    private void jXLabel54MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel54MouseClicked

        cardLayout.show(pnl_item_holder, "3");
    }//GEN-LAST:event_jXLabel54MouseClicked

    private void jXLabel53MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel53MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel53MouseEntered

    private void tbl_customersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_customersMouseClicked
        add_customer_to_table(evt);
    }//GEN-LAST:event_tbl_customersMouseClicked

    private void tbl_table_customersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_table_customersMouseClicked
        delete_table_customer(evt);
    }//GEN-LAST:event_tbl_table_customersMouseClicked

    private void jLabel37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseClicked
        add_customer();
    }//GEN-LAST:event_jLabel37MouseClicked

    private void jXLabel63MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel63MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel63MouseClicked

    private void jXLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel5MouseClicked
        cashout();
    }//GEN-LAST:event_jXLabel5MouseClicked

    private void jXLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel7MouseClicked
        logout();
    }//GEN-LAST:event_jXLabel7MouseClicked

    private void jXLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel1MouseClicked

        List<to_table_customers> customers = tbl_table_customers_ALM;
        if (customers.isEmpty()) {
            Alert.set(0, "Please Add Customer/s!");
            return;
        }
        int count_selected = 0;
        for (to_table_customers c : customers) {
            if (c.selected == 1) {
                count_selected++;
            }
        }
        if (count_selected == 0) {
            Alert.set(0, "Please Select Customer/s!");
            return;
        }
        cardLayout.show(pnl_item_holder, "2");

        cardLayout2.next(pnl_table_holder);
    }//GEN-LAST:event_jXLabel1MouseClicked

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

    private void tbl_tablesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_tablesMouseClicked

        set_table();
        data_cols_table_customers();
        data_cols_table_customer_orders();
        cardLayout.show(pnl_item_holder, "3");
        jTextField1.grabFocus();
    }//GEN-LAST:event_tbl_tablesMouseClicked

    private void tbl_table_customer_ordersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_table_customer_ordersMouseClicked
        update_table_customer_order(evt);
    }//GEN-LAST:event_tbl_table_customer_ordersMouseClicked

    private void jXLabel55MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel55MouseClicked
        int height = tbl_table_customers.getRowHeight() * (7 - 1);
        JScrollBar bar = jScrollPane7.getVerticalScrollBar();
        bar.setValue(bar.getValue() - height);
    }//GEN-LAST:event_jXLabel55MouseClicked

    private void jXLabel56MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel56MouseClicked
        int height = tbl_table_customers.getRowHeight() * (7 - 1);
        JScrollBar bar = jScrollPane7.getVerticalScrollBar();
        bar.setValue(bar.getValue() + height);
    }//GEN-LAST:event_jXLabel56MouseClicked

    private void tf_waiterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_waiterMouseClicked
        waiters();
    }//GEN-LAST:event_tf_waiterMouseClicked

    private void jXLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel2MouseClicked
        pay();
    }//GEN-LAST:event_jXLabel2MouseClicked

    private void jXLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel4MouseClicked
        print_bill();
    }//GEN-LAST:event_jXLabel4MouseClicked

    private void jXLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel3MouseClicked
        print_orders();
    }//GEN-LAST:event_jXLabel3MouseClicked

    private void jXLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel6MouseClicked
        report();
    }//GEN-LAST:event_jXLabel6MouseClicked

    private void jXLabel51MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel51MouseClicked
        transfer();
    }//GEN-LAST:event_jXLabel51MouseClicked

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
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextField jTextField1;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel10;
    private org.jdesktop.swingx.JXLabel jXLabel11;
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
    private org.jdesktop.swingx.JXLabel jXLabel21;
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
    private org.jdesktop.swingx.JXLabel jXLabel43;
    private org.jdesktop.swingx.JXLabel jXLabel44;
    private org.jdesktop.swingx.JXLabel jXLabel45;
    private org.jdesktop.swingx.JXLabel jXLabel46;
    private org.jdesktop.swingx.JXLabel jXLabel47;
    private org.jdesktop.swingx.JXLabel jXLabel48;
    private org.jdesktop.swingx.JXLabel jXLabel49;
    private org.jdesktop.swingx.JXLabel jXLabel5;
    private org.jdesktop.swingx.JXLabel jXLabel50;
    private org.jdesktop.swingx.JXLabel jXLabel51;
    private org.jdesktop.swingx.JXLabel jXLabel52;
    private org.jdesktop.swingx.JXLabel jXLabel53;
    private org.jdesktop.swingx.JXLabel jXLabel54;
    private org.jdesktop.swingx.JXLabel jXLabel55;
    private org.jdesktop.swingx.JXLabel jXLabel56;
    private org.jdesktop.swingx.JXLabel jXLabel59;
    private org.jdesktop.swingx.JXLabel jXLabel6;
    private org.jdesktop.swingx.JXLabel jXLabel61;
    private org.jdesktop.swingx.JXLabel jXLabel62;
    private org.jdesktop.swingx.JXLabel jXLabel63;
    private org.jdesktop.swingx.JXLabel jXLabel7;
    private org.jdesktop.swingx.JXLabel jXLabel8;
    private org.jdesktop.swingx.JXLabel jXLabel9;
    private javax.swing.JLabel lbl_table_guest_no;
    private javax.swing.JLabel lbl_table_id;
    private javax.swing.JLabel lbl_table_name;
    private javax.swing.JLabel lbl_waiter_id;
    private javax.swing.JPanel pnl_customers;
    private javax.swing.JPanel pnl_item_holder;
    private javax.swing.JPanel pnl_orders;
    private javax.swing.JPanel pnl_search_item;
    private javax.swing.JPanel pnl_table;
    private javax.swing.JPanel pnl_table_holder;
    private javax.swing.JPanel pnl_table_orders;
    private javax.swing.JTable tbl_customers;
    private javax.swing.JTable tbl_inv_categories;
    private javax.swing.JTable tbl_items;
    private javax.swing.JTable tbl_table_customer_orders;
    private javax.swing.JTable tbl_table_customer_orders_queue;
    private javax.swing.JTable tbl_table_customers;
    private javax.swing.JTable tbl_tables;
    private javax.swing.JTextField tf_waiter;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
        init_key();
        init_tbl_inv_categories();
        data_cols();
        init_tbl_items();
        init_tbl_tables();
        data_cols_tables();
        init_tbl_customers();
        data_cols_customers();
        init_tbl_table_customers();
        init_tbl_table_customer_orders_queue();
        init_tbl_table_customer_orders();
        set_card_items();
        focus();
        set_border();
        type();
        lbl_table_id.setVisible(false);
        lbl_waiter_id.setVisible(false);

        time();

    }

    private void time() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Timer ti = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Calendar currentCalendar = Calendar.getInstance();
                        Date currentTime = currentCalendar.getTime();
                        jLabel5.setText(DateType.time3.format(currentTime));
                        jLabel6.setText(DateType.slash.format(currentTime));
                        if (jLabel5.getText().endsWith("PM")) {
                            jLabel10.setText("Good Afternoon, " + Users.get_ScreenName());
                        } else {
                            jLabel10.setText("Good Morning, " + Users.get_ScreenName());
                        }

                    }
                });
                ti.start();
            }
        });
        t.start();
    }

    private void type() {

        JXLabel[] lbl = {
            jXLabel23, jXLabel24, jXLabel25, jXLabel26, jXLabel27, jXLabel28, jXLabel29, jXLabel30, jXLabel32, jXLabel34, jXLabel33, jXLabel35, jXLabel36, jXLabel37, jXLabel38, jXLabel39, jXLabel40, jXLabel43, jXLabel41, jXLabel42, jXLabel46, jXLabel31, jXLabel47, jXLabel44, jXLabel45, jXLabel48, jXLabel49

        };

        for (final JXLabel l : lbl) {
            l.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    String text = jTextField1.getText();
                    text = text + l.getText();
                    jTextField1.setText(text);
                    data_cols_customers();
                }

            });
        }
        jXLabel59.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String text = jTextField1.getText();
                text = text + " ";
                jTextField1.setText(text);
                data_cols_customers();
            }
        });
    }

    private void focus() {
        JTextField[] tf = {jTextField1};
        Focus_Fire.onFocus_lostFocus(tf);
        Focus_Fire.select_all(tf);
    }

    private void set_border() {
        Border line = BorderFactory.createLineBorder(new java.awt.Color(249, 154, 4));
        Border empty = new EmptyBorder(0, 20, 0, 0);
        CompoundBorder border = new CompoundBorder(line, empty);
        jTextField1.setBorder(border);
        jTextField1.grabFocus();

        Border line2 = BorderFactory.createLineBorder(new java.awt.Color(154, 123, 72));
        Border empty2 = new EmptyBorder(0, 20, 0, 0);
        CompoundBorder border2 = new CompoundBorder(line2, empty);
        tf_waiter.setBorder(border2);
        tf_waiter.grabFocus();
        tf_waiter.enable(false);
    }
    CardLayout cardLayout = new CardLayout();
    CardLayout cardLayout2 = new CardLayout();

    private void set_card_items() {
        cardLayout = (CardLayout) pnl_item_holder.getLayout();
        cardLayout2 = (CardLayout) pnl_table_holder.getLayout();

        cardLayout.addLayoutComponent("1", pnl_table_orders);
        cardLayout.addLayoutComponent("2", pnl_search_item);
        cardLayout.addLayoutComponent("3", pnl_customers);

        cardLayout2.addLayoutComponent("1", pnl_table);
        cardLayout2.addLayoutComponent("2", pnl_orders);

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
//                disposed();
            }
        });
    }
    // </editor-fold>

    private ArrayListModel tbl_inv_categories_ALM;
    private Tblinv_categoriesModel tbl_inv_categories_M;

    private void init_tbl_inv_categories() {
        tbl_inv_categories_ALM = new ArrayListModel();
        tbl_inv_categories_M = new Tblinv_categoriesModel(tbl_inv_categories_ALM);
        tbl_inv_categories.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_inv_categories.setModel(tbl_inv_categories_M);
        tbl_inv_categories.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_inv_categories.setRowHeight(25);
        int[] tbl_widths_inv_categories = {0, 100};
        for (int i = 0, n = tbl_widths_inv_categories.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_inv_categories, i, tbl_widths_inv_categories[i]);
        }
        Dimension d = tbl_inv_categories.getTableHeader().getPreferredSize();
        d.height = 0;
        tbl_inv_categories.getTableHeader().setPreferredSize(d);
        tbl_inv_categories.setRowHeight(50);
        tbl_inv_categories.setFont(new java.awt.Font("Arial", 0, 14));
    }

    private void loadData_inv_categories(List<to_inv_categories> acc) {
        tbl_inv_categories_ALM.clear();
        tbl_inv_categories_ALM.addAll(acc);
    }

    public static class Tblinv_categoriesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", ""
        };

        public Tblinv_categoriesModel(ListModel listmodel) {
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
            to_inv_categories tt = (to_inv_categories) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                default:
                    return "   " + tt.category.toUpperCase();
            }
        }
    }

    private void data_cols() {
        String where = " order by category asc";
        loadData_inv_categories(S1_inv_categories.ret_where(where));
    }

    private ArrayListModel tbl_items_ALM;
    private TblitemsModel tbl_items_M;

    private void init_tbl_items() {
        tbl_items_ALM = new ArrayListModel();
        tbl_items_M = new TblitemsModel(tbl_items_ALM);
        tbl_items.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_items.setModel(tbl_items_M);
        tbl_items.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_items.setRowHeight(25);
        Dimension d1 = jLabel17.getSize();
        Dimension d2 = jLabel18.getSize();
        Dimension d3 = jLabel19.getSize();

        int[] tbl_widths_items = {FitIn.toInt("" + d1.getWidth()), d2.width, d3.width, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_items.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_items, i, tbl_widths_items[i]);
        }
        Dimension d = tbl_items.getTableHeader().getPreferredSize();
        d.height = 0;
        tbl_items.getTableHeader().setPreferredSize(d);
        tbl_items.getTableHeader().setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_items.setRowHeight(50);
        tbl_items.setFont(new java.awt.Font("Tahoma", 0, 14));

        tbl_items.setDefaultRenderer(Object.class, new TableCellRenderer() {
            private final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (column == 2) {
                    DEFAULT_RENDERER.setHorizontalAlignment(JLabel.RIGHT);
                } else {
                    DEFAULT_RENDERER.setHorizontalAlignment(JLabel.LEFT);
                }
                return c;
            }

        });
    }

    private void loadData_items(List<to_items> acc) {
        tbl_items_ALM.clear();
        tbl_items_ALM.addAll(acc);
    }

    public static class TblitemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Description", "Price", "Amount", "category", "category_id", "classification", "classification_id", "sub_classification", "sub_classification_id", "product_qty", "unit", "conversion", "selling_price", "date_added", "user_name", "item_type", "status", "supplier", "fixed_price", "cost", "supplier_id", "multi_level_pricing", "vatable", "reorder_level"
        };

        public TblitemsModel(ListModel listmodel) {
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
            to_items tt = (to_items) getRow(row);
            switch (col) {
                case 0:
                    return "      " + FitIn.fmt_woc(tt.product_qty);
                case 1:
                    return "   " + tt.description;
                case 2:
                    return FitIn.fmt_wc_0(tt.selling_price) + "  ";
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
                    return tt.product_qty;
                case 11:
                    return tt.unit;
                case 12:
                    return tt.conversion;
                case 13:
                    return tt.selling_price;
                case 14:
                    return tt.date_added;
                case 15:
                    return tt.user_name;
                case 16:
                    return tt.item_type;
                case 17:
                    return tt.status;
                case 18:
                    return tt.supplier;
                case 19:
                    return tt.fixed_price;
                case 20:
                    return tt.cost;
                case 21:
                    return tt.supplier_id;
                case 22:
                    return tt.multi_level_pricing;
                case 23:
                    return tt.vatable;
                default:
                    return tt.reorder_level;
            }
        }
    }

    int item_position = 0;
    List<to_items> item_list = new ArrayList();

    private void data_cols_items() {
        int row = tbl_inv_categories.getSelectedRow();
        if (row < 0) {
            return;
        }
        item_list.clear();
        to_inv_categories to = (to_inv_categories) tbl_inv_categories_ALM.get(tbl_inv_categories.convertRowIndexToModel(row));
        String where = " where category='" + to.category + "' and status ='" + "1" + "' order by description asc";
        item_list = S1_items.ret_where(where);

        loadData_items(item_list);
        jLabel23.setText(" " + item_list.size() + " Results");
    }

    private void next_item() {
        int height = tbl_items.getRowHeight() * (11 - 1);
        JScrollBar bar = jScrollPane3.getVerticalScrollBar();
        bar.setValue(bar.getValue() + height);
    }

    private void previous_item() {
        int height = tbl_items.getRowHeight() * (11 - 1);
        JScrollBar bar = jScrollPane3.getVerticalScrollBar();
        bar.setValue(bar.getValue() - height);
    }

    private void next_category() {
        int height = tbl_inv_categories.getRowHeight() * (11 - 1);
        JScrollBar bar = jScrollPane2.getVerticalScrollBar();
        bar.setValue(bar.getValue() + height);
    }

    private void previous_category() {
        int height = tbl_inv_categories.getRowHeight() * (11 - 1);
        JScrollBar bar = jScrollPane2.getVerticalScrollBar();
        bar.setValue(bar.getValue() - height);
    }

    private void search_item() {
        Window p = (Window) this;
        Dlg_touchscreen_search nd = Dlg_touchscreen_search.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_touchscreen_search.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, final Dlg_touchscreen_search.OutputData data) {
                if (!data.search.isEmpty()) {
                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {

                            String where = " where description like '%" + data.search + "%' and status ='" + "1" + "' order by description asc";
                            List<to_items> datas = S1_items.ret_where(where);
                            loadData_items(datas);
                            jLabel23.setText(" " + datas.size() + " Results");
                        }
                    });
                    t.start();
                }

            }
        });
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) rect.getMaxX() - nd.getWidth();
        int y = (int) rect.getMaxY() - nd.getHeight() - 5;
        nd.setLocation(x, y);
        nd.setVisible(true);
    }

    private void search_table_and_customer() {
        Window p = (Window) this;
        Dlg_touchscreen_tables_and_customers nd = Dlg_touchscreen_tables_and_customers.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_touchscreen_tables_and_customers.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_touchscreen_tables_and_customers.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void enter_quantity() {

        final int row = tbl_items.getSelectedRow();
        if (row < 0) {
            return;
        }

        Window p = (Window) this;
        Dlg_touchscreen_quantity nd = Dlg_touchscreen_quantity.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_touchscreen_quantity.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_touchscreen_quantity.OutputData data) {
                closeDialog.ok();
                to_items to = (to_items) tbl_items_ALM.get(tbl_items.convertRowIndexToModel(row));
                int row2 = tbl_tables.getSelectedRow();
                if (row2 < 0) {
                    return;
                }
                to_tables customer = (to_tables) tbl_tables_ALM.get(tbl_tables.convertRowIndexToModel(row2));

                List<to_table_customer_orders_queue> datas = tbl_table_customer_orders_queue_ALM;
                int exists = 0;
                for (to_table_customer_orders_queue queue : datas) {
                    if (to.barcode.equals(queue.barcode)) {
                        exists = 1;
                        queue.setQty(data.qty);
                        tbl_table_customer_orders_queue_M.fireTableDataChanged();
                        break;
                    }
                }
                if (exists == 0) {
                    int id = to.id;
                    String table_customer_id = "" + customer.id;
                    String customer_id = "";
                    String customer_name = "";
                    String table_id = "" + customer.id;
                    String table_name = customer.table_name;
                    String date_added = DateType.datetime.format(new Date());
                    String user_name = "";
                    String waiter_id = customer.waiter_id;
                    String waiter_name = customer.waiter_name;
                    String barcode = to.barcode;
                    String description = to.description;
                    double qty = data.qty;
                    double selling_price = to.selling_price;
                    String category_id = to.category_id;
                    String category_name = to.category;
                    String sub_category_id = to.sub_classification_id;
                    String sub_category_name = to.sub_classification;
                    String printing_assembly_id = to.printing_assembly_id;
                    String printing_assembly_name = to.printing_assembly_name;
                    String group_id = to.group_id;
                    String group_name = to.group_name;
                    String discount_name = "";
                    double discount_rate = 0;
                    double discount_amount = 0;
                    int status = 0;
                    to_table_customer_orders_queue queue = new to_table_customer_orders_queue(id, table_customer_id, customer_id, customer_name, table_id, table_name, date_added, user_name, waiter_id, waiter_name, barcode, description, qty, selling_price, category_id, category_name, sub_category_id, sub_category_name, printing_assembly_id, printing_assembly_name, group_id, group_name, discount_name, discount_rate, discount_amount, status, data.spec);
                    tbl_table_customer_orders_queue_ALM.add(queue);
                    tbl_table_customer_orders_queue_M.fireTableDataChanged();
                }

            }
        });
        nd.setLocationRelativeTo(jScrollPane3);
        nd.setVisible(true);

    }

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
                        return "              Available";
                    } else {
                        return "              ---------";
                    }

                default:
                    return tt.table_location_id;
            }
        }
    }

    private void data_cols_tables() {
        String where = "";
        loadData_tables(S1_tables.ret_data_touch(where));
        List<S1_tables.to_tables> datas = tbl_tables_ALM;
        int available = 0;
        for (S1_tables.to_tables to : datas) {
            if (to.status == 0) {
                available++;
            }
        }
        lbl_table_guest_no.setText("" + available);
    }

    private ArrayListModel tbl_customers_ALM;
    private TblcustomersModel tbl_customers_M;

    private void init_tbl_customers() {
        tbl_customers_ALM = new ArrayListModel();
        tbl_customers_M = new TblcustomersModel(tbl_customers_ALM);
        tbl_customers.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_customers.setModel(tbl_customers_M);
        tbl_customers.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_customers.setRowHeight(25);
        int[] tbl_widths_customers = {100, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_customers.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_customers, i, tbl_widths_customers[i]);
        }
        Dimension d = tbl_customers.getTableHeader().getPreferredSize();
        d.height = 0;
        tbl_customers.getTableHeader().setPreferredSize(d);
        tbl_customers.getTableHeader().setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_customers.setRowHeight(50);
        tbl_customers.setFont(new java.awt.Font("Tahoma", 0, 14));
    }

    private void loadData_customers(List<to_customers> acc) {
        tbl_customers_ALM.clear();
        tbl_customers_ALM.addAll(acc);
    }

    public static class TblcustomersModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "customer_name", "fname", "lname", "client_id", "client_type", "member_type", "membership"
        };

        public TblcustomersModel(ListModel listmodel) {
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
            to_customers tt = (to_customers) getRow(row);
            switch (col) {
                case 0:
                    return "  " + tt.fname + " " + tt.lname;
                case 1:
                    return "  " + tt.fname + " " + tt.lname;
                case 2:
                    return tt.fname;
                case 3:
                    return tt.lname;
                case 4:
                    return tt.client_id;
                case 5:
                    return tt.client_type;
                case 6:
                    return tt.member_type;
                default:
                    return tt.membership;
            }
        }
    }

    private void data_cols_customers() {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                String where = " where"
                        + " fname like'%" + jTextField1.getText() + "%' "
                        + " or lname like'%" + jTextField1.getText() + "%' "
                        + " or concat(fname,space(1),lname) like'%" + jTextField1.getText() + "%' "
                        + " or concat(lname,space(1),fname) like'%" + jTextField1.getText() + "%' ";
                loadData_customers(S1_customers.ret_data(where));
            }
        });
        t.start();

    }

    private void logout() {
        disposed();
        Pnl_Dashboard pnl = new Pnl_Dashboard();
        pnl.login();
    }

    private void add_customer_to_table(MouseEvent evt) {
        int row = tbl_customers.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_customers to = (to_customers) tbl_customers_ALM.get(tbl_customers.convertRowIndexToModel(row));
        int row2 = tbl_tables.getSelectedRow();
        if (row2 < 0) {
            return;
        }

        if (evt.getClickCount() == 1) {
            List<to_table_customers> datas = tbl_table_customers_ALM;
            int exists = 0;
            for (to_table_customers ttc : datas) {
                if (ttc.customer_id.equalsIgnoreCase("" + to.id)) {
                    exists = 1;
                    break;
                }
            }
            if (exists == 0) {
                to_tables to2 = (to_tables) tbl_tables_ALM.get(tbl_tables.convertRowIndexToModel(row2));
                int id = 0;
                String customer_id = "" + to.id;

                String customer_name = to.fname + " " + to.lname;
                String table_id = "" + to2.id;
                String table_name = to2.table_name;
                String date_added = DateType.datetime.format(new Date());
                String user_name = Users.user_name;
                String waiter_id = to2.waiter_id;
                String waiter_name = to2.waiter_name;
                int status = 0;
                S1_table_customers.to_table_customers customer = new S1_table_customers.to_table_customers(id, customer_id, customer_name, table_id, table_name, date_added, user_name, waiter_id, waiter_name, status, 1);
                S1_table_customers.add_table_customers(customer);
                int row_tables = tbl_tables.getSelectedRow();
                data_cols_tables();
                tbl_tables.setRowSelectionInterval(row_tables, row_tables);
                data_cols_table_customers();
            } else {
                Alert.set(0, "Customer Already Added!");
            }
        }
    }

    private void delete_table_customer(MouseEvent evt) {
        final int row = tbl_table_customers.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_table_customers.getSelectedColumn();
        if (col == 2) {
            Window p = (Window) this;
            Dlg_touchscreen_confirm nd = Dlg_touchscreen_confirm.create(p, true);
            nd.setTitle("");

            nd.setCallback(new Dlg_touchscreen_confirm.Callback() {

                @Override
                public void yes(CloseDialog closeDialog, Dlg_touchscreen_confirm.OutputData data) {
                    closeDialog.ok();
                    prompt_delete();
                }

                @Override
                public void no(CloseDialog closeDialog, Dlg_touchscreen_confirm.OutputData data) {
                    closeDialog.ok();
                }

            });
            nd.setLocationRelativeTo(jScrollPane7);
            nd.setVisible(true);

        } else {

            to_table_customers to = (to_table_customers) tbl_table_customers_ALM.get(tbl_table_customers.convertRowIndexToModel(row));
            if (to.selected == 0) {
                to.setSelected(1);
            } else {
                to.setSelected(0);
            }
            tbl_table_customers_M.fireTableDataChanged();
            data_cols_table_customer_orders();
        }

    }

    private void prompt_delete() {
        final int row = tbl_table_customers.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_table_customers to = (to_table_customers) tbl_table_customers_ALM.get(tbl_table_customers.convertRowIndexToModel(row));
        Window p2 = (Window) this;
        Dlg_touchscreen_admin nd = Dlg_touchscreen_admin.create(p2, true);
        nd.setTitle("");

        nd.setCallback(new Dlg_touchscreen_admin.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_touchscreen_admin.OutputData data) {
                closeDialog.ok();
                String customer_ids = "";
                String customer_names = "";

                List<to_table_customers> customers = tbl_table_customers_ALM;
                int c = 0;
                int cc = 0;
                String cust = "";
                String cutno = "";
                for (to_table_customers customer : customers) {
                    if (cc == 0) {
                        cust = customer.customer_name;
                        cutno = "" + customer.id;
                    } else {
                        cust = cust + " ," + customer.customer_name;
                        cutno = cust + " ," + customer.id;
                    }
                    if (customer.selected == 1) {
                        if (c == 0) {
                            customer_names = customer.customer_name;
                            customer_ids = "" + customer.id;
                        } else {
                            customer_names = customer_names + " ," + customer.customer_name;
                            customer_ids = customer_ids + " ," + customer.id;
                        }
                        c++;
                    }
                    cc++;
                }

                String where = " where table_id='" + to.table_id + "' and customer_ids='" + customer_ids + "'";
                final S1_table_customer_discounts.to_table_customer_discounts disc = S1_table_customer_discounts
                        .ret_customer_discount(where);
                S1_table_customer_discounts.delete_table_customer_discounts(disc);
                S1_table_customers.delete_table_customers(to);
                int row_tables = tbl_tables.getSelectedRow();
                data_cols_tables();
                tbl_tables.setRowSelectionInterval(row_tables, row_tables);
                data_cols_table_customers();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void set_table() {
        int row = tbl_tables.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_tables to = (to_tables) tbl_tables_ALM.get(tbl_tables.convertRowIndexToModel(row));

        lbl_table_id.setText("" + to.id);
        lbl_table_name.setText(to.table_name);
        if (to.status == 1) {
            lbl_waiter_id.setText(to.waiter_id);
            tf_waiter.setText(to.waiter_name);
        } else {
            lbl_waiter_id.setText("");
            tf_waiter.setText("");
        }
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
        int[] tbl_widths_table_customers = {50, jLabel35.getWidth() - 50, jLabel36.getWidth(), 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_table_customers.length; i < n; i++) {
            if (i == 100) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_table_customers, i, tbl_widths_table_customers[i]);
        }
        Dimension d = tbl_table_customers.getTableHeader().getPreferredSize();
        d.height = 0;
        tbl_table_customers.getTableHeader().setPreferredSize(d);
        tbl_table_customers.getTableHeader().setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_table_customers.setRowHeight(50);
        tbl_table_customers.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer());
//        tbl_table_customers.setFont(new java.awt.Font("Tahoma", 0, 30));
    }

    private void loadData_table_customers(List<to_table_customers> acc) {
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
            to_table_customers tt = (to_table_customers) getRow(row);
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
        to_tables to = (to_tables) tbl_tables_ALM.get(tbl_tables.convertRowIndexToModel(row));
        String where = "where table_id='" + to.id + "' and status='" + "0" + "'";
        loadData_table_customers(S1_table_customers.ret_data(where));
    }

    private void delete_customer() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                int row = tbl_customers.getSelectedRow();
                if (row < 0) {
                    return;
                }
                to_customers to = (to_customers) tbl_customers_ALM.get(tbl_customers.convertRowIndexToModel(row));
                S1_customers.delete_customers(to);
                data_cols_customers();

            }
        });
        t.start();

    }

    private void add_customer() {

        if (!jTextField1.getText().isEmpty()) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    int id = 0;
                    String customer_name = "";
                    String fname = jTextField1.getText();
                    String lname = "";
                    String client_id = "";
                    String client_type = "";
                    String member_type = "";
                    String membership = DateType.sf.format(new Date());
                    S1_customers.to_customers to = new to_customers(id, customer_name, fname, lname, client_id, client_type, member_type, membership);
                    S1_customers.add_customers(to);
                    data_cols_customers();
                }
            });
            t.start();
        }
    }

    private ArrayListModel tbl_table_customer_orders_queue_ALM;
    private Tbltable_customer_orders_queueModel tbl_table_customer_orders_queue_M;

    private void init_tbl_table_customer_orders_queue() {
        tbl_table_customer_orders_queue_ALM = new ArrayListModel();
        tbl_table_customer_orders_queue_M = new Tbltable_customer_orders_queueModel(tbl_table_customer_orders_queue_ALM);
        tbl_table_customer_orders_queue.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_table_customer_orders_queue.setModel(tbl_table_customer_orders_queue_M);
        tbl_table_customer_orders_queue.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_table_customer_orders_queue.setRowHeight(25);
        int[] tbl_widths_table_customer_orders = {jLabel31.getWidth(), jLabel32.getWidth(), jLabel33.getWidth(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_table_customer_orders.length; i < n; i++) {
            if (i == 100) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_table_customer_orders_queue, i, tbl_widths_table_customer_orders[i]);
        }
        Dimension d = tbl_table_customer_orders_queue.getTableHeader().getPreferredSize();
        d.height = 0;
        tbl_table_customer_orders_queue.getTableHeader().setPreferredSize(d);
        tbl_table_customer_orders_queue.getTableHeader().setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_table_customer_orders_queue.setRowHeight(50);

        tbl_table_customer_orders_queue.setDefaultRenderer(Object.class, new TableCellRenderer() {
            private final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (column == 2) {
                    DEFAULT_RENDERER.setHorizontalAlignment(JLabel.RIGHT);
                } else {
                    DEFAULT_RENDERER.setHorizontalAlignment(JLabel.LEFT);
                }
                return c;
            }
        });
    }

    private void loadData_table_customer_orders_queue(List<to_table_customer_orders_queue> acc) {
        tbl_table_customer_orders_queue_ALM.clear();
        tbl_table_customer_orders_queue_ALM.addAll(acc);
    }

    public static class Tbltable_customer_orders_queueModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "table_customer_id", "customer_id", "customer_name", "table_id", "table_name", "date_added", "user_name", "waiter_id", "waiter_name", "barcode", "description", "qty", "selling_price", "category_id", "category_name", "sub_category_id", "sub_category_name", "printing_assembly_id", "priting_assembly_name", "group_id", "group_name", "discount_name", "discount_rate", "discount_amount", "status"
        };

        public Tbltable_customer_orders_queueModel(ListModel listmodel) {
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
            to_table_customer_orders_queue tt = (to_table_customer_orders_queue) getRow(row);
            switch (col) {
                case 0:
                    return "    " + FitIn.fmt_woc(tt.qty);
                case 1:
                    return "  " + tt.description;
                case 2:
                    return FitIn.fmt_wc_0(tt.selling_price) + "  ";
                case 3:
                    return tt.customer_name;
                case 4:
                    return tt.table_id;
                case 5:
                    return tt.table_name;
                case 6:
                    return tt.date_added;
                case 7:
                    return tt.user_name;
                case 8:
                    return tt.waiter_id;
                case 9:
                    return tt.waiter_name;
                case 10:
                    return tt.barcode;
                case 11:
                    return tt.description;
                case 12:
                    return tt.qty;
                case 13:
                    return tt.selling_price;
                case 14:
                    return tt.category_id;
                case 15:
                    return tt.category_name;
                case 16:
                    return tt.sub_category_id;
                case 17:
                    return tt.sub_category_name;
                case 18:
                    return tt.printing_assembly_id;
                case 19:
                    return tt.priting_assembly_name;
                case 20:
                    return tt.group_id;
                case 21:
                    return tt.group_name;
                case 22:
                    return tt.discount_name;
                case 23:
                    return tt.discount_rate;
                case 24:
                    return tt.discount_amount;
                default:
                    return tt.status;
            }
        }
    }

    private void delete_table_order_queue() {
        int row = tbl_table_customer_orders_queue.getSelectedRow();
        if (row < 0) {
            return;
        }
        tbl_table_customer_orders_queue_ALM.remove(row);
        tbl_table_customer_orders_queue_M.fireTableDataChanged();
    }

    private void edit_table_orders_queue(MouseEvent evt) {
        int row = tbl_table_customer_orders_queue.getSelectedRow();
        if (row < 0) {
            return;
        }

        final to_table_customer_orders_queue to = (to_table_customer_orders_queue) tbl_table_customer_orders_queue_ALM
                .get(tbl_table_customer_orders_queue.convertRowIndexToModel(row));

        if (evt.getClickCount() == 2) {
            Window p = (Window) this;
            Dlg_touchscreen_quantity nd = Dlg_touchscreen_quantity.create(p, true);
            nd.setTitle("");
            nd.do_pass(to.qty, to.specifications);
            nd.setCallback(new Dlg_touchscreen_quantity.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_touchscreen_quantity.OutputData data) {
                    closeDialog.ok();
                    to.setQty(data.qty);
                    to.setSpecifications(data.spec);
                    tbl_table_customer_orders_queue_M.fireTableDataChanged();
                }
            });
            nd.setLocationRelativeTo(jScrollPane5);
            nd.setVisible(true);
        }
    }

    private void add_table_customer_orders() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                List<to_table_customer_orders_queue> datas = tbl_table_customer_orders_queue_ALM;
                if (datas.isEmpty()) {
                    Alert.set(0, "No Orders");
                    return;
                }
                List<to_table_customers> customers = tbl_table_customers_ALM;
                if (tbl_table_customers_ALM.isEmpty()) {
                    Alert.set(0, "Please Add Customer/s!");
                    return;
                }

                int count_selected = 0;
                for (to_table_customers c : customers) {
                    if (c.selected == 1) {
                        count_selected++;
                    }
                }
                if (count_selected == 0) {
                    Alert.set(0, "Please Select Customer/s!");
                    return;
                }

                List<to_table_customer_orders> orders = tbl_table_customer_orders_ALM;
                S1_table_customer_orders.add_table_customer_orders(datas, customers, orders);
                print_orders_queue();

            }
        });
        t.start();

    }

    private ArrayListModel tbl_table_customer_orders_ALM;
    private Tbltable_customer_ordersModel tbl_table_customer_orders_M;

    private void init_tbl_table_customer_orders() {
        tbl_table_customer_orders_ALM = new ArrayListModel();
        tbl_table_customer_orders_M = new Tbltable_customer_ordersModel(tbl_table_customer_orders_ALM);
        tbl_table_customer_orders.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_table_customer_orders.setModel(tbl_table_customer_orders_M);
        tbl_table_customer_orders.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_table_customer_orders.setRowHeight(25);
        int[] tbl_widths_table_customer_orders = {jLabel26.getWidth(), jLabel27.getWidth(), jLabel29.getWidth(), jLabel28.getWidth(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_table_customer_orders.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_table_customer_orders, i, tbl_widths_table_customer_orders[i]);
        }
        Dimension d = tbl_table_customer_orders.getTableHeader().getPreferredSize();
        d.height = 0;
        tbl_table_customer_orders.getTableHeader().setPreferredSize(d);
        tbl_table_customer_orders.getTableHeader().setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_table_customer_orders.setRowHeight(50);
        tbl_table_customer_orders.setFont(new java.awt.Font("Tahoma", 0, 14));
        tbl_table_customer_orders.setDefaultRenderer(Object.class, new TableCellRenderer() {
            private final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (column == 2 || column == 3) {
                    DEFAULT_RENDERER.setHorizontalAlignment(JLabel.RIGHT);
                } else {
                    DEFAULT_RENDERER.setHorizontalAlignment(JLabel.LEFT);
                }
                return c;
            }
        });
    }

    private void loadData_table_customer_orders(List<to_table_customer_orders> acc) {
        tbl_table_customer_orders_ALM.clear();
        tbl_table_customer_orders_ALM.addAll(acc);
    }

    public static class Tbltable_customer_ordersModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "table_customer_id", "customer_id", "customer_name", "table_id", "table_name", "date_added", "user_name", "waiter_id", "waiter_name", "barcode", "description", "qty", "selling_price", "category_id", "category_name", "sub_category_id", "sub_category_name", "printing_assembly_id", "priting_assembly_name", "group_id", "group_name", "discount_name", "discount_rate", "discount_amount", "status"
        };

        public Tbltable_customer_ordersModel(ListModel listmodel) {
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
            to_table_customer_orders tt = (to_table_customer_orders) getRow(row);
            switch (col) {
                case 0:
                    return "        " + FitIn.fmt_woc(tt.qty);
                case 1:
                    return "    " + tt.description;
                case 2:
                    return FitIn.fmt_wc_0(tt.selling_price) + "  ";
                case 3:
                    return FitIn.fmt_wc_0(tt.qty * tt.selling_price) + "  ";
                case 4:
                    return tt.table_id;
                case 5:
                    return tt.table_name;
                case 6:
                    return tt.date_added;
                case 7:
                    return tt.user_name;
                case 8:
                    return tt.waiter_id;
                case 9:
                    return tt.waiter_name;
                case 10:
                    return tt.barcode;
                case 11:
                    return tt.description;
                case 12:
                    return tt.qty;
                case 13:
                    return tt.selling_price;
                case 14:
                    return tt.category_id;
                case 15:
                    return tt.category_name;
                case 16:
                    return tt.sub_category_id;
                case 17:
                    return tt.sub_category_name;
                case 18:
                    return tt.printing_assembly_id;
                case 19:
                    return tt.priting_assembly_name;
                case 20:
                    return tt.group_id;
                case 21:
                    return tt.group_name;
                case 22:
                    return tt.discount_name;
                case 23:
                    return tt.discount_rate;
                case 24:
                    return tt.discount_amount;
                default:
                    return tt.status;
            }
        }
    }

    private void data_cols_table_customer_orders() {

        int row = tbl_tables.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_tables to2 = (to_tables) tbl_tables_ALM.get(tbl_tables.convertRowIndexToModel(row));

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                String where = "";
                List<to_table_customers> datas = tbl_table_customers_ALM;
                if (!datas.isEmpty()) {
                    int i = 0;

                    String where2 = "";
                    for (to_table_customers to : datas) {
                        if (to.selected == 1) {
                            if (i == 0) {
                                where2 = where2 + "where customer_id='" + to.customer_id + "' and table_id='" + to.table_id + "' and status='" + "0" + "' ";
                            } else {
                                where2 = where2 + " or customer_id='" + to.customer_id + "' and table_id='" + to.table_id + "' and status='" + "0" + "' ";

                            }
                            i++;
                        }
                    }
                    System.out.println(i + " : " + datas.size());
                    if (i == datas.size()) {
                        where = where + " where table_id='" + to2.id + "' and status='" + "0" + "'  order by id desc";
                    } else {

                        if (i == 0) {
                            where = where + " where table_id='" + to2.id + "' and status='" + "0" + "'  order by id desc";
                        } else {
                            where = where2;
                            where = where + " and status='" + "0" + "'  order by id desc";
                        }

                    }

                    List<to_table_customer_orders> datas2 = S1_table_customer_orders.ret_data(where);
                    loadData_table_customer_orders(datas2);
                    int items = 0;
                    double total = 0;

                    for (to_table_customer_orders t : datas2) {
                        total += t.qty * t.selling_price;
                        items += t.qty;
                    }

                    jLabel16.setText("" + items);
                    jLabel12.setText(FitIn.fmt_wc_0(total));
                } else {

                    tbl_table_customer_orders_ALM.clear();
                    tbl_table_customer_orders_M.fireTableDataChanged();
                    jLabel16.setText("0");
                    jLabel12.setText("0.00");
                }
            }
        });
        t.start();

        tbl_tables.setRowSelectionInterval(row, row);
    }

    private void delete_table_customer_order() {
        final int row = tbl_table_customer_orders.getSelectedRow();
        if (row < 0) {
            return;
        }
        Window p = (Window) this;
        Dlg_touchscreen_admin nd = Dlg_touchscreen_admin.create(p, true);
        nd.setTitle("");

        nd.setCallback(new Dlg_touchscreen_admin.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_touchscreen_admin.OutputData data) {
                closeDialog.ok();
                final to_table_customer_orders to = (to_table_customer_orders) tbl_table_customer_orders_ALM.get(tbl_table_customer_orders.convertRowIndexToModel(row));

                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        S1_table_customer_orders.delete_table_customer_orders(to);
                        Alert.set(3, "");
                        data_cols_table_customer_orders();
                    }
                });
                t.start();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void update_table_customer_order(MouseEvent evt) {
        if (evt.getClickCount() == 2) {

            List<to_table_customers> cus = tbl_table_customers_ALM;
            int count = 0;
            for (to_table_customers c : cus) {
                if (c.selected == 1) {
                    count++;
                }
            }
            if (count > 1) {
                Alert.set(0, "Choose 1 Customer");

            } else {
                int row = tbl_table_customer_orders.getSelectedRow();
                if (row < 0) {
                    return;
                }
                final to_table_customer_orders to = (to_table_customer_orders) tbl_table_customer_orders_ALM
                        .get(tbl_table_customer_orders.convertRowIndexToModel(row));

                Window p = (Window) this;
                Dlg_touchscreen_quantity nd = Dlg_touchscreen_quantity.create(p, true);
                nd.setTitle("");
                nd.do_pass(to.qty, to.specifications);
                nd.setCallback(new Dlg_touchscreen_quantity.Callback() {

                    @Override
                    public void ok(CloseDialog closeDialog, final Dlg_touchscreen_quantity.OutputData data) {
                        closeDialog.ok();

                        Thread t = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                S1_table_customer_orders.edit_table_customer_orders(to, data.qty, data.spec);
                                data_cols_table_customer_orders();
                                Alert.set(2, "");
                            }
                        });
                        t.start();

                    }
                });
                nd.setLocationRelativeTo(jScrollPane4);
                nd.setVisible(true);
            }
        }

    }

    class ImageRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel label = new JLabel();

            if (value != null) {
                label.setHorizontalAlignment(JLabel.CENTER);
                //value is parameter which filled by byteOfImage
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource(value.toString())));
            }
            return label;
        }
    }

    private void waiters() {
        final int row = tbl_tables.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_tables to = (to_tables) tbl_tables_ALM.get(tbl_tables.convertRowIndexToModel(row));
        Window p = (Window) this;
        Dlg_touchscreen_wiaters nd = Dlg_touchscreen_wiaters.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_touchscreen_wiaters.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_touchscreen_wiaters.OutputData data) {
                closeDialog.ok();
                tf_waiter.setText(data.customer_name);
                lbl_waiter_id.setText(data.customer_id);
                S1_table_customers.update_table_customer_waiter(to, data.customer_id, data.customer_name);
                data_cols_tables();
                tbl_tables.setRowSelectionInterval(row, row);

            }
        });
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) rect.getMaxX() - nd.getWidth();
        int y = (int) rect.getMaxY() - nd.getHeight() - 6;
        nd.setLocation(x, y);
        nd.setVisible(true);
    }

    private void pay() {

        int row = tbl_tables.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_tables to = (to_tables) tbl_tables_ALM.get(tbl_tables.convertRowIndexToModel(row));
        if (to.status == 0) {
            Alert.set(0, "Please Select Table");
            return;
        }

        String sales_no = S1_sales.increment_id();
        double amount_due = FitIn.toDouble(jLabel12.getText());
        String table_id = "" + to.id;
        String table_name = to.table_name;
        String customer_ids = "";
        String customer_names = "";

        List<to_table_customers> customers = tbl_table_customers_ALM;
        int c = 0;
        int cc = 0;
        String cust = "";
        String cutno = "";
        for (to_table_customers customer : customers) {
            if (cc == 0) {
                cust = customer.customer_name;
                cutno = "" + customer.id;
            } else {
                cust = cust + " ," + customer.customer_name;
                cutno = cust + " ," + customer.id;
            }
            if (customer.selected == 1) {
                if (c == 0) {
                    customer_names = customer.customer_name;
                    customer_ids = "" + customer.id;
                } else {
                    customer_names = customer_names + " ," + customer.customer_name;
                    customer_ids = customer_ids + " ," + customer.id;
                }
                c++;
            }
            cc++;
        }
        if (c == 0) {
            Alert.set(0, "Please select Customer/s");
            return;
        }
        if (c == 0) {
            customer_names = cust;
            customer_ids = cutno;
        }

        String waiter_id = to.waiter_id;
        String waiter_name = to.waiter_name;
        String where = " where table_id='" + to.id + "' and customer_ids='" + customer_ids + "'";
        final S1_table_customer_discounts.to_table_customer_discounts disc = S1_table_customer_discounts
                .ret_customer_discount(where);
        Window p = (Window) this;
        Dlg_touchscreen_pay nd = Dlg_touchscreen_pay.create(p, true);
        nd.setTitle("");
        nd.do_pass(sales_no, amount_due, table_id, table_name, customer_ids, customer_names, waiter_id, waiter_name, disc);
        nd.setCallback(new Dlg_touchscreen_pay.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, final Dlg_touchscreen_pay.OutputData data) {
                closeDialog.ok();
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        List<to_table_customers> customers = tbl_table_customers_ALM;
                        List<to_table_customer_orders> orders = tbl_table_customer_orders_ALM;
                        S1_pay.payment(customers, orders, data.to_sales);

                        S1_table_customer_discounts.delete_table_customer_discounts(disc);
                        int row = tbl_tables.getSelectedRow();
                        data_cols_tables();
                        tbl_tables.setRowSelectionInterval(row, row);
                        int r = tbl_table_customers.getSelectedRow();
                        data_cols_table_customers();
                        Alert.set(0, "Payment Successful!");
                        jLabel12.setText("0.00");
                        jLabel16.setText("0");
                        tf_waiter.setText("");
                        lbl_waiter_id.setText("");
                        data_cols_table_customer_orders();
                        change(FitIn.fmt_wc_0(data.change));
                    }
                });
                t.start();

            }
        }
        );
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void change(String change) {
        Window p = (Window) this;
        Dlg_touchscreen_change nd = Dlg_touchscreen_change.create(p, true);
        nd.setTitle("");
        nd.do_pass(change);
        nd.setCallback(new Dlg_touchscreen_change.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_touchscreen_change.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void print_bill() {
        String customer_names = "";
        String customer_ids = "";
        String cti = "";
        List<to_table_customers> customers = tbl_table_customers_ALM;
        int c = 0;
        int cc = 0;
        String cust = "";
        String cutno = "";
        for (to_table_customers customer : customers) {
            cti = "" + customer.id;
            if (cc == 0) {
                cust = customer.customer_name;
                cutno = "" + customer.id;
            } else {
                cust = cust + " ," + customer.customer_name;
                cutno = cust + " ," + customer.id;
            }
            if (customer.selected == 1) {
                if (c == 0) {
                    customer_names = customer.customer_name;
                    customer_ids = "" + customer.id;
                } else {
                    customer_names = customer_names + " ," + customer.customer_name;
                    customer_ids = customer_ids + " ," + customer.id;
                }
                c++;
            }
            cc++;
        }
        if (c == 0) {
            Alert.set(0, "Please select Customer/s");
            return;
        }
        final int row = tbl_tables.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_tables to = (to_tables) tbl_tables_ALM.get(tbl_tables.convertRowIndexToModel(row));
        System.out.println("Table:" +to.id+ " = "+to.table_name);
        String where = " where table_id='" + to.id + "' and customer_ids='" + customer_ids + "'";
        final S1_table_customer_discounts.to_table_customer_discounts disc = S1_table_customer_discounts
                .ret_customer_discount(where);
        Window p = (Window) this;
        final Dlg_touchscreen_billing_discounts nd = Dlg_touchscreen_billing_discounts.create(p, true);
        nd.setTitle("");
        double amount_due = FitIn.toDouble(jLabel12.getText());
        String customer_name = "";
        String discount = disc.discount_name;
        double discount_rate = disc.discount_rate;
        double discount_amount = disc.discount_amount;
        String discount_customer_id = disc.discount_customer_no;
        String discount_customer_names = disc.discount_customer_name;
        String discount_customer_address = disc.discount_customer_address;
        final String ct = cti;
        final String cids = customer_ids;
        final String cs = customer_names;
        nd.do_pass(amount_due, customer_names, discount, discount_rate, discount_amount, discount_customer_id, discount_customer_names, discount_customer_address);
        nd.setCallback(new Dlg_touchscreen_billing_discounts.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, final Dlg_touchscreen_billing_discounts.OutputData data) {
                closeDialog.ok();

                if (disc.id != -1) {
                    int id = disc.id;
                    String table_customer_id = disc.table_customer_id;
                    String table_id = disc.table_id;
                    String table_name = disc.table_name;
                    String user_name = Users.user_name;
                    String date_added = DateType.datetime.format(new Date());
                    String discount_name = data.discount_name;
                    double discount_rate = data.discount_rate;
                    double discount_amount = data.discount_amount;
                    String discount_customer_no = data.discount_no;
                    String discount_customer_name = data.discount_holder;
                    String discount_customer_address = data.discount_address;
                    String customer_id = disc.customer_ids;
                    String customer_names = disc.customer_names;
                    to_table_customer_discounts my_disc = new S1_table_customer_discounts.to_table_customer_discounts(id, table_customer_id, table_id, table_name, user_name, date_added, discount_name, discount_rate, discount_amount, discount_customer_no, discount_customer_name, discount_customer_address, customer_id, customer_names);
                    S1_table_customer_discounts.edit_table_customer_discounts(my_disc);
                } else {
                    int id = 0;
                    String table_customer_id = ct;
                    String table_id = "" + to.id;
                    String table_name = to.table_name;
                    String user_name = Users.user_name;
                    String date_added = DateType.datetime.format(new Date());
                    String discount_name = data.discount_name;
                    double discount_rate = data.discount_rate;
                    double discount_amount = data.discount_amount;
                    String discount_customer_no = data.discount_no;
                    String discount_customer_name = data.discount_holder;
                    String discount_customer_address = data.discount_address;
                    String customer_id = cids;
                    String customer_names = cs;
                    to_table_customer_discounts my_disc = new S1_table_customer_discounts.to_table_customer_discounts(id, table_customer_id, table_id, table_name, user_name, date_added, discount_name, discount_rate, discount_amount, discount_customer_no, discount_customer_name, discount_customer_address, customer_id, customer_names);
                    S1_table_customer_discounts.add_table_customer_discounts(my_disc);
                }
                String print = System.getProperty("print_to_receipts", "false");
                if (print.equals("true")) {
                    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            List<to_table_customer_orders> datas = tbl_table_customer_orders_ALM;
                            List<Srpt_billing_statement.field> fields = new ArrayList();
                            for (to_table_customer_orders to : datas) {
                                double qty = to.qty;
                                String description = to.description;
                                double selling_price = to.selling_price;
                                double amount = qty * selling_price;
                                Srpt_billing_statement.field to2 = new Srpt_billing_statement.field(qty, description, selling_price, amount);
                                fields.add(to2);
                            }
                            String business_name = System.getProperty("business_name", "Tyron Restaurant");
                            String address = System.getProperty("address", "Lacson Stree, Bacolod City");
                            String telephone_no = "";
                            String table_name = to.table_name;
                            String transaction_no = "";
                            String waiter = to.waiter_name;
                            String date = DateType.day_and_time.format(new Date());
                            double discount = data.discount_amount;
                            double net_due = FitIn.toDouble(jLabel12.getText()) - discount;
                            String discount_type = data.discount_name;
                            String customer_name = data.discount_holder;
                            String customer_id = data.discount_no;
                            Srpt_billing_statement rpt = new Srpt_billing_statement(business_name, address, telephone_no, table_name, transaction_no, waiter, date, discount, net_due, discount_type, customer_id, customer_name);
                            rpt.fields.addAll(fields);
                            String jrxml = "rpt_billing_statement.jrxml";
                            try {
                                InputStream is = Srpt_billing_statement.class
                                        .getResourceAsStream(jrxml);
                                JasperReport jasperReport = JasperCompileManager.compileReport(is);
                                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, JasperUtil.
                                        setParameter(rpt), JasperUtil.makeDatasource(rpt.fields));
                                JasperPrintManager.printReport(jasperPrint,
                                                               false);
                            } catch (JRException ex) {
                                Logger.getLogger(Dlg_touchscreen.class
                                        .getName()).
                                        log(Level.SEVERE, null, ex);
                            }
                            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                        }
                    });
                    t.start();
                }
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void print_orders() {
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {

                List<to_table_customer_orders> datas = tbl_table_customer_orders_ALM;

                List<S1_printing_assembly.to_printing_assembly> assembly = S1_printing_assembly.ret_data("");
                for (S1_printing_assembly.to_printing_assembly print : assembly) {
                    List<Srpt_printing_assembly.field> fields = new ArrayList();
                    for (to_table_customer_orders order : datas) {
                        if (order.printing_assembly_id.equals("" + print.id)) {
                            String printing_assembly = order.priting_assembly_name;
                            String spec = order.specifications;
                            if (!spec.isEmpty()) {
                                spec = " [" + order.specifications + "]";
                            }
                            String description = order.description + spec;
                            double qty = order.qty;
                            Srpt_printing_assembly.field to = new Srpt_printing_assembly.field(printing_assembly, description, qty, order.waiter_name, order.table_name);
                            fields.add(to);
                        }
                    }

                    if (!fields.isEmpty()) {
                        Srpt_printing_assembly rpt = new Srpt_printing_assembly();
                        rpt.fields.addAll(fields);
                        String jrxml = "rpt_printing_assembly.jrxml";

                        try {
                            InputStream is = Srpt_billing_statement.class
                                    .getResourceAsStream(jrxml);
                            JasperReport jasperReport = JasperCompileManager.compileReport(is);
                            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, JasperUtil.
                                    setParameter(rpt), JasperUtil.makeDatasource(rpt.fields));

                            JasperPrintManager.printReport(jasperPrint,
                                                           false);
                        } catch (JRException ex) {
                            Logger.getLogger(Dlg_touchscreen.class
                                    .getName()).
                                    log(Level.SEVERE, null, ex);
                        }
                        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                    }

                }
            }
        });
        t.start();

    }

    private void print_orders_queue() {
        String print = System.getProperty("print_to_receipts", "false");
        int customer_no = 0;
        List<to_table_customers> customers = tbl_table_customers_ALM;
        for (to_table_customers to : customers) {
            if (to.selected == 1) {
                customer_no++;
            }
        }
        if (customer_no == 0) {
            customer_no = customers.size();
        }
        final double q = customer_no;
        if (print.equals("true")) {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            Thread t = new Thread(new Runnable() {

                @Override
                public void run() {

                    List<to_table_customer_orders_queue> datas = tbl_table_customer_orders_queue_ALM;
                    List<S1_printing_assembly.to_printing_assembly> assembly = S1_printing_assembly.ret_data("");
                    for (S1_printing_assembly.to_printing_assembly print : assembly) {
                        List<Srpt_printing_assembly.field> fields = new ArrayList();
                        for (to_table_customer_orders_queue order : datas) {
                            if (order.printing_assembly_id.equals("" + print.id)) {
                                String printing_assembly = print.location;

                                String spec = order.specifications;
                                if (!spec.isEmpty()) {
                                    spec = " [" + order.specifications + "]";
                                }
                                String description = order.description + spec;
                                double qty = q * order.qty;
                                System.out.println("My Order: " + qty + " = " + order.description);
                                Srpt_printing_assembly.field to = new Srpt_printing_assembly.field(printing_assembly, description, qty, order.waiter_name, order.table_name);
                                fields.add(to);
                            }
                        }
                        System.out.println(print.location + " " + fields.size() + " : print");
                        if (!fields.isEmpty()) {
                            Srpt_printing_assembly rpt = new Srpt_printing_assembly();
                            rpt.fields.addAll(fields);
                            String jrxml = "rpt_printing_assembly.jrxml";

                            try {
                                InputStream is = Srpt_billing_statement.class
                                        .getResourceAsStream(jrxml);
                                JasperReport jasperReport = JasperCompileManager.compileReport(is);
                                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, JasperUtil.
                                        setParameter(rpt), JasperUtil.makeDatasource(rpt.fields));

                                JasperPrintManager.printReport(jasperPrint, false);
                            } catch (JRException ex) {
                                Logger.getLogger(Dlg_touchscreen.class
                                        .getName()).
                                        log(Level.SEVERE, null, ex);
                            }

                        }

                    }
                    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                    tbl_table_customer_orders_queue_ALM.clear();
                    tbl_table_customer_orders_queue_M.fireTableDataChanged();
                    cardLayout.show(pnl_item_holder, "1");
                    data_cols_table_customer_orders();
                    Alert.set(1, "");
                    cardLayout.show(pnl_item_holder, "1");
                    cardLayout2.show(pnl_table_holder, "1");
                }
            });
            t.start();
        } else {
            tbl_table_customer_orders_queue_ALM.clear();
            tbl_table_customer_orders_queue_M.fireTableDataChanged();
            cardLayout.show(pnl_item_holder, "1");
            data_cols_table_customer_orders();
            Alert.set(1, "");
            cardLayout.show(pnl_item_holder, "1");
            cardLayout2.show(pnl_table_holder, "1");
        }
    }

    private void out(){
         if (Users.user_level == 0) {
            this.dispose();
        } else {

            if (Users.is_active == 0) {

                Window p = (Window) this;
                Dlg_cash_out nd = Dlg_cash_out.create(p, true);
                nd.setTitle("");
                nd.do_pass_in(Users.checks, Users.drawer);
                nd.setCallback(new Dlg_cash_out.Callback() {

                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_cash_out.OutputData data) {
                        closeDialog.ok();
                        S1_cash_drawer.edit_cash_drawer(data.drawer);
                        S1_cash_drawer_checks.add_cash_drawer_checks(data.drawer.checks);
//                        S1_cash_drawer_expenses.add_cash_drawer_checks(data.drawer.exp);
                        Alert.set(0, "THANK YOU, HAVE A NICE DAY");
                        System.exit(1);
//                    login`
                    }
                });

                nd.setLocationRelativeTo(this);
                nd.setVisible(true);
            }
            if (Users.is_active == 1) {
//                JOptionPane.showMessageDialog(null, "adadad");
                Window p = (Window) this;
                Dlg_cash_out nd = Dlg_cash_out.create(p, true);
                nd.setTitle("");
                nd.do_pass(Users.checks, Users.drawer);
                nd.setCallback(new Dlg_cash_out.Callback() {

                    @Override
                    public void ok(CloseDialog closeDialog, Dlg_cash_out.OutputData data) {
                        closeDialog.ok();
                        S1_cash_drawer.edit_cash_drawer(data.drawer);
                        Alert.set(0, "THANK YOU, HAVE A NICE DAY");
                        System.exit(1);
//                    login`
                    }
                });
                nd.setLocationRelativeTo(this);
                nd.setVisible(true);
            }
        }
    }
    private void cashout() {
        Window p = (Window) this;
        Dlg_touchscreen_prompt ndd = Dlg_touchscreen_prompt.create(p, true);
        ndd.setTitle("");

        ndd.setCallback(new Dlg_touchscreen_prompt.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_touchscreen_prompt.OutputData data) {
                closeDialog.ok();
                out();
            }
        });
        ndd.setLocationRelativeTo(this);
        ndd.setVisible(true);
       
    }

    private void report() {
        Window p = (Window) this;
        Dlg_touchscreen_report nd = Dlg_touchscreen_report.create(p, true);
        nd.setTitle("");

        nd.setCallback(new Dlg_touchscreen_report.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_touchscreen_report.OutputData data) {
                closeDialog.ok();

            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void transfer() {
        int row = tbl_tables.getSelectedRow();
        if (row < 0) {
            Alert.set(0, "Please Select Table");
            return;
        }

        List<to_table_customers> customers = tbl_table_customers_ALM;
        int c = 0;
        int cc = 0;
        String cust = "";
        String cutno = "";
        String customer_names = "";
        String customer_ids = "";
        final List<to_table_customers> must_transfer = new ArrayList();
        final List<to_table_customer_orders> orders = tbl_table_customer_orders_ALM;
        for (to_table_customers customer : customers) {
            if (cc == 0) {
                cust = customer.customer_name;
                cutno = "" + customer.id;
            } else {
                cust = cust + "/" + customer.customer_name;
                cutno = cust + "/" + customer.id;
            }
            if (customer.selected == 1) {
                must_transfer.add(customer);
                if (c == 0) {
                    customer_names = customer.customer_name;
                    customer_ids = "" + customer.id;
                } else {
                    customer_names = customer_names + "/" + customer.customer_name;
                    customer_ids = customer_ids + "/" + customer.id;
                }
                c++;
            }
            cc++;
        }
        if (c == 0) {
            Alert.set(0, "Please select Customer/s");
            return;
        }
        final to_tables to = (to_tables) tbl_tables_ALM.get(tbl_tables.convertRowIndexToModel(row));
        Window p = (Window) this;
        Dlg_touchscreen_transfer_table nd = Dlg_touchscreen_transfer_table.create(p, true);
        nd.setTitle("");
        nd.do_pass("" + to.id, customer_names);
        final String cus = customer_names;
        nd.setCallback(new Dlg_touchscreen_transfer_table.Callback() {
            @Override
            public void ok(final CloseDialog closeDialog, final Dlg_touchscreen_transfer_table.OutputData data) {

                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        S1_table_transfer.edit_table_customers(must_transfer, orders, data.new_table_location);
                        int row1 = tbl_tables.getSelectedRow();
                        data_cols_tables();
                        tbl_tables.setRowSelectionInterval(row1, row1);
                        int r = tbl_table_customers.getSelectedRow();
                        data_cols_table_customers();
                        jLabel12.setText("0.00");
                        jLabel16.setText("0");
                        tf_waiter.setText("");
                        lbl_waiter_id.setText("");
                        data_cols_table_customer_orders();
                        Alert.set(0, "Customer/s Transfered! to Table: " + data.new_table_location.table_name);
                        closeDialog.ok();
                    }
                });
                t.start();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }
}
