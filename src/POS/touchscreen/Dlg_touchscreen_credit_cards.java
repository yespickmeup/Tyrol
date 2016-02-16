/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen;

import POS.credit_cards.S1_credit_cards;
import POS.discounts.S1_discounts;
import POS.discounts.S1_discounts.to_discounts;
import POS.util.Focus_Fire;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;

/**
 *
 * @author Ronald
 */
public class Dlg_touchscreen_credit_cards extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_touchscreen_discounts
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

        public final String discount;
        public final double discount_rate;

        public OutputData(String discount, double discount_rate) {
            this.discount = discount;
            this.discount_rate = discount_rate;
        }

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_touchscreen_credit_cards(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_touchscreen_credit_cards(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_touchscreen_credit_cards() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_touchscreen_credit_cards myRef;

    private void setThisRef(Dlg_touchscreen_credit_cards myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_touchscreen_credit_cards> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_touchscreen_credit_cards create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.MODELESS);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_touchscreen_credit_cards create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_touchscreen_credit_cards dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_credit_cards((java.awt.Frame) parent, false);
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
            Dlg_touchscreen_credit_cards dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_touchscreen_credit_cards((java.awt.Dialog) parent, false);
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

        Dlg_touchscreen_credit_cards dialog = Dlg_touchscreen_credit_cards.create(new javax.swing.JFrame(), true);
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
        jPanel2 = new javax.swing.JPanel();
        jXLabel63 = new org.jdesktop.swingx.JXLabel();
        jXLabel14 = new org.jdesktop.swingx.JXLabel();
        jXLabel13 = new org.jdesktop.swingx.JXLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_discounts = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jXLabel63.setBackground(new java.awt.Color(9, 79, 149));
        jXLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/icons/back_24.png"))); // NOI18N
        jXLabel63.setText("Back");
        jXLabel63.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jXLabel63.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jXLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jXLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jXLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jXLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jXLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tbl_discounts.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_discounts.setSelectionBackground(new java.awt.Color(226, 221, 181));
        tbl_discounts.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tbl_discounts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_discountsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_discounts);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void jXLabel63MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel63MouseClicked
        disposed();
    }//GEN-LAST:event_jXLabel63MouseClicked

    private void jXLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel14MouseClicked
        int height = tbl_discounts.getRowHeight() * (4 - 1);
        JScrollBar bar = jScrollPane1.getVerticalScrollBar();
        bar.setValue(bar.getValue() - height);
    }//GEN-LAST:event_jXLabel14MouseClicked

    private void jXLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel13MouseClicked
        int height = tbl_discounts.getRowHeight() * (4 - 1);
        JScrollBar bar = jScrollPane1.getVerticalScrollBar();
        bar.setValue(bar.getValue() + height);
    }//GEN-LAST:event_jXLabel13MouseClicked

    private void tbl_discountsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_discountsMouseClicked
        ok();
    }//GEN-LAST:event_tbl_discountsMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXLabel jXLabel13;
    private org.jdesktop.swingx.JXLabel jXLabel14;
    private org.jdesktop.swingx.JXLabel jXLabel63;
    private javax.swing.JTable tbl_discounts;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
        init_key();
        focus();

        init_tbl_discounts();
        data_cols();
    }

    private void focus() {
        JTextField[] tf = {};
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

    private void ok() {
        int row = tbl_discounts.getSelectedRow();
        if (row < 0) {
            return;
        }
        S1_credit_cards.to_credit_cards to = (S1_credit_cards.to_credit_cards) tbl_discounts_ALM.get(tbl_discounts.convertRowIndexToModel(row));
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(to.credit_card, to.rate));
        }
    }

    private ArrayListModel tbl_discounts_ALM;
    private TbldiscountsModel tbl_discounts_M;

    private void init_tbl_discounts() {
        tbl_discounts_ALM = new ArrayListModel();
        tbl_discounts_M = new TbldiscountsModel(tbl_discounts_ALM);
        tbl_discounts.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_discounts.setModel(tbl_discounts_M);
        tbl_discounts.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_discounts.setRowHeight(25);
        int[] tbl_widths_discounts = {100, 159, 0};
        for (int i = 0, n = tbl_widths_discounts.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_discounts, i, tbl_widths_discounts[i]);
        }
        Dimension d = tbl_discounts.getTableHeader().getPreferredSize();
        d.height = 0;
        tbl_discounts.getTableHeader().setPreferredSize(d);
        tbl_discounts.getTableHeader().setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_discounts.setRowHeight(43);
        tbl_discounts.setFont(new java.awt.Font("Tahoma", 0, 14));

        tbl_discounts.setDefaultRenderer(Object.class, new TableCellRenderer() {
            private final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (column == 1) {
                    DEFAULT_RENDERER.setHorizontalAlignment(JLabel.RIGHT);
                } else {
                    DEFAULT_RENDERER.setHorizontalAlignment(JLabel.LEFT);
                }
                return c;
            }

        });
    }

    private void loadData_discounts(List<S1_credit_cards.to_credit_cards> acc) {
        tbl_discounts_ALM.clear();
        S1_credit_cards.to_credit_cards to = new S1_credit_cards.to_credit_cards(-1, "", 0);
        tbl_discounts_ALM.add(to);
        tbl_discounts_M.fireTableDataChanged();
        tbl_discounts_ALM.addAll(acc);
    }

    public static class TbldiscountsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "discount_name", "discount_rate"
        };

        public TbldiscountsModel(ListModel listmodel) {
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
            S1_credit_cards.to_credit_cards tt = (S1_credit_cards.to_credit_cards) getRow(row);
            switch (col) {
                case 0:
                    return "  " + tt.credit_card;
                case 1:
                    return FitIn.fmt_wc_0(tt.rate) + "  ";
                default:
                    return tt.id + "  ";
            }
        }
    }

    private void data_cols() {
        String search = "";

        loadData_discounts(S1_credit_cards.ret_data(search));

    }

}
