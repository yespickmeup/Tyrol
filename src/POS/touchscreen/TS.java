/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package POS.touchscreen;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;





/**
 *
 * @author Ronald
 */
public class TS extends javax.swing.JDialog {

    /** Creates new form TS */
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
private TS(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private TS(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public TS() {
        super();
        initComponents();
        myInit();

    }
    private TS myRef;

    private void setThisRef(TS myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, TS> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static TS create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static TS create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            TS dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new TS((java.awt.Frame) parent, false);
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
            TS dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new TS((java.awt.Dialog) parent, false);
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


        TS dialog = TS.create(new javax.swing.JFrame(), true);
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

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnl_discount = new javax.swing.JPanel();
        jXLabel68 = new org.jdesktop.swingx.JXLabel();
        tf_waiter4 = new javax.swing.JTextField();
        jXLabel69 = new org.jdesktop.swingx.JXLabel();
        tf_waiter9 = new javax.swing.JTextField();
        tf_waiter10 = new javax.swing.JTextField();
        jXLabel76 = new org.jdesktop.swingx.JXLabel();
        tf_waiter11 = new javax.swing.JTextField();
        jXLabel77 = new org.jdesktop.swingx.JXLabel();
        tf_waiter12 = new javax.swing.JTextField();
        tf_waiter13 = new javax.swing.JTextField();
        jXLabel70 = new org.jdesktop.swingx.JXLabel();
        pnl_credit_card = new javax.swing.JPanel();
        jXLabel66 = new org.jdesktop.swingx.JXLabel();
        tf_waiter3 = new javax.swing.JTextField();
        tf_waiter6 = new javax.swing.JTextField();
        jXLabel67 = new org.jdesktop.swingx.JXLabel();
        jXLabel71 = new org.jdesktop.swingx.JXLabel();
        tf_waiter7 = new javax.swing.JTextField();
        jXLabel72 = new org.jdesktop.swingx.JXLabel();
        tf_waiter8 = new javax.swing.JTextField();
        tf_waiter5 = new javax.swing.JTextField();
        jXLabel73 = new org.jdesktop.swingx.JXLabel();
        jXLabel74 = new org.jdesktop.swingx.JXLabel();
        jXLabel75 = new org.jdesktop.swingx.JXLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.CardLayout());

        pnl_discount.setBackground(new java.awt.Color(255, 255, 255));

        jXLabel68.setBackground(new java.awt.Color(176, 138, 75));
        jXLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel68.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXLabel68.setText("  Discount:");
        jXLabel68.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jXLabel68.setOpaque(true);
        jXLabel68.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel68MouseClicked(evt);
            }
        });

        tf_waiter4.setBackground(new java.awt.Color(223, 213, 196));
        tf_waiter4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tf_waiter4.setForeground(new java.awt.Color(176, 138, 75));
        tf_waiter4.setBorder(null);
        tf_waiter4.setMargin(new java.awt.Insets(2, 10, 2, 2));
        tf_waiter4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_waiter4MouseClicked(evt);
            }
        });

        jXLabel69.setBackground(new java.awt.Color(176, 138, 75));
        jXLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel69.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXLabel69.setText("  ID #:");
        jXLabel69.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jXLabel69.setOpaque(true);
        jXLabel69.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel69MouseClicked(evt);
            }
        });

        tf_waiter9.setBackground(new java.awt.Color(223, 213, 196));
        tf_waiter9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tf_waiter9.setForeground(new java.awt.Color(176, 138, 75));
        tf_waiter9.setBorder(null);
        tf_waiter9.setMargin(new java.awt.Insets(2, 10, 2, 2));
        tf_waiter9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_waiter9MouseClicked(evt);
            }
        });

        tf_waiter10.setBackground(new java.awt.Color(223, 213, 196));
        tf_waiter10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tf_waiter10.setForeground(new java.awt.Color(176, 138, 75));
        tf_waiter10.setBorder(null);
        tf_waiter10.setMargin(new java.awt.Insets(2, 10, 2, 2));
        tf_waiter10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_waiter10MouseClicked(evt);
            }
        });

        jXLabel76.setBackground(new java.awt.Color(176, 138, 75));
        jXLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel76.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXLabel76.setText("  Name:");
        jXLabel76.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jXLabel76.setOpaque(true);
        jXLabel76.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel76MouseClicked(evt);
            }
        });

        tf_waiter11.setBackground(new java.awt.Color(223, 213, 196));
        tf_waiter11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tf_waiter11.setForeground(new java.awt.Color(176, 138, 75));
        tf_waiter11.setBorder(null);
        tf_waiter11.setMargin(new java.awt.Insets(2, 10, 2, 2));
        tf_waiter11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_waiter11MouseClicked(evt);
            }
        });

        jXLabel77.setBackground(new java.awt.Color(176, 138, 75));
        jXLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel77.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXLabel77.setText("  Address:");
        jXLabel77.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jXLabel77.setOpaque(true);
        jXLabel77.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel77MouseClicked(evt);
            }
        });

        tf_waiter12.setBackground(new java.awt.Color(223, 213, 196));
        tf_waiter12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tf_waiter12.setForeground(new java.awt.Color(176, 138, 75));
        tf_waiter12.setBorder(null);
        tf_waiter12.setMargin(new java.awt.Insets(2, 10, 2, 2));
        tf_waiter12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_waiter12MouseClicked(evt);
            }
        });

        tf_waiter13.setBackground(new java.awt.Color(223, 213, 196));
        tf_waiter13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tf_waiter13.setForeground(new java.awt.Color(176, 138, 75));
        tf_waiter13.setBorder(null);
        tf_waiter13.setMargin(new java.awt.Insets(2, 10, 2, 2));
        tf_waiter13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_waiter13MouseClicked(evt);
            }
        });

        jXLabel70.setBackground(new java.awt.Color(255, 255, 255));
        jXLabel70.setForeground(new java.awt.Color(176, 138, 75));
        jXLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel70.setText("%");
        jXLabel70.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jXLabel70.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jXLabel70.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel70MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnl_discountLayout = new javax.swing.GroupLayout(pnl_discount);
        pnl_discount.setLayout(pnl_discountLayout);
        pnl_discountLayout.setHorizontalGroup(
            pnl_discountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_discountLayout.createSequentialGroup()
                .addGroup(pnl_discountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jXLabel76, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(jXLabel69, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel68, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(pnl_discountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_discountLayout.createSequentialGroup()
                        .addComponent(tf_waiter4, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(tf_waiter13, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jXLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_waiter10, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tf_waiter9)
                    .addComponent(tf_waiter11)
                    .addComponent(tf_waiter12)))
        );
        pnl_discountLayout.setVerticalGroup(
            pnl_discountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_discountLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pnl_discountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_discountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tf_waiter10)
                        .addComponent(tf_waiter4)
                        .addGroup(pnl_discountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_waiter13, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(1, 1, 1)
                .addGroup(pnl_discountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_waiter9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnl_discountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_waiter11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnl_discountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_waiter12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        jPanel1.add(pnl_discount, "card3");

        pnl_credit_card.setBackground(new java.awt.Color(255, 255, 255));

        jXLabel66.setBackground(new java.awt.Color(176, 138, 75));
        jXLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel66.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXLabel66.setText("  Card Type:");
        jXLabel66.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jXLabel66.setOpaque(true);
        jXLabel66.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel66MouseClicked(evt);
            }
        });

        tf_waiter3.setBackground(new java.awt.Color(223, 213, 196));
        tf_waiter3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tf_waiter3.setForeground(new java.awt.Color(176, 138, 75));
        tf_waiter3.setBorder(null);
        tf_waiter3.setMargin(new java.awt.Insets(2, 10, 2, 2));
        tf_waiter3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_waiter3MouseClicked(evt);
            }
        });

        tf_waiter6.setBackground(new java.awt.Color(223, 213, 196));
        tf_waiter6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tf_waiter6.setForeground(new java.awt.Color(176, 138, 75));
        tf_waiter6.setBorder(null);
        tf_waiter6.setMargin(new java.awt.Insets(2, 10, 2, 2));
        tf_waiter6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_waiter6MouseClicked(evt);
            }
        });

        jXLabel67.setBackground(new java.awt.Color(176, 138, 75));
        jXLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel67.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXLabel67.setText("  Card #:");
        jXLabel67.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jXLabel67.setOpaque(true);
        jXLabel67.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel67MouseClicked(evt);
            }
        });

        jXLabel71.setBackground(new java.awt.Color(176, 138, 75));
        jXLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel71.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXLabel71.setText("  Card Holder:");
        jXLabel71.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jXLabel71.setOpaque(true);
        jXLabel71.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel71MouseClicked(evt);
            }
        });

        tf_waiter7.setBackground(new java.awt.Color(223, 213, 196));
        tf_waiter7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tf_waiter7.setForeground(new java.awt.Color(176, 138, 75));
        tf_waiter7.setBorder(null);
        tf_waiter7.setMargin(new java.awt.Insets(2, 10, 2, 2));
        tf_waiter7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_waiter7MouseClicked(evt);
            }
        });

        jXLabel72.setBackground(new java.awt.Color(176, 138, 75));
        jXLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel72.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXLabel72.setText("  App Code:");
        jXLabel72.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jXLabel72.setOpaque(true);
        jXLabel72.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel72MouseClicked(evt);
            }
        });

        tf_waiter8.setBackground(new java.awt.Color(223, 213, 196));
        tf_waiter8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tf_waiter8.setForeground(new java.awt.Color(176, 138, 75));
        tf_waiter8.setBorder(null);
        tf_waiter8.setMargin(new java.awt.Insets(2, 10, 2, 2));
        tf_waiter8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_waiter8MouseClicked(evt);
            }
        });

        tf_waiter5.setBackground(new java.awt.Color(223, 213, 196));
        tf_waiter5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tf_waiter5.setForeground(new java.awt.Color(176, 138, 75));
        tf_waiter5.setBorder(null);
        tf_waiter5.setMargin(new java.awt.Insets(2, 10, 2, 2));
        tf_waiter5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_waiter5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnl_credit_cardLayout = new javax.swing.GroupLayout(pnl_credit_card);
        pnl_credit_card.setLayout(pnl_credit_cardLayout);
        pnl_credit_cardLayout.setHorizontalGroup(
            pnl_credit_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_credit_cardLayout.createSequentialGroup()
                .addGroup(pnl_credit_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jXLabel71, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(jXLabel67, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel66, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel72, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(pnl_credit_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_credit_cardLayout.createSequentialGroup()
                        .addComponent(tf_waiter3, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(tf_waiter5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tf_waiter6)
                    .addComponent(tf_waiter7)
                    .addComponent(tf_waiter8)))
        );
        pnl_credit_cardLayout.setVerticalGroup(
            pnl_credit_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_credit_cardLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pnl_credit_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_credit_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tf_waiter3)
                        .addComponent(tf_waiter5)))
                .addGap(1, 1, 1)
                .addGroup(pnl_credit_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_waiter6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnl_credit_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_waiter7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnl_credit_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_waiter8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        jPanel1.add(pnl_credit_card, "card2");

        jXLabel73.setBackground(new java.awt.Color(143, 114, 68));
        jXLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel73.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXLabel73.setText("  Discount");
        jXLabel73.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jXLabel73.setOpaque(true);
        jXLabel73.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel73MouseClicked(evt);
            }
        });

        jXLabel74.setBackground(new java.awt.Color(143, 114, 68));
        jXLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel74.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXLabel74.setText("  Credit Card");
        jXLabel74.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jXLabel74.setOpaque(true);
        jXLabel74.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel74MouseClicked(evt);
            }
        });

        jXLabel75.setBackground(new java.awt.Color(143, 114, 68));
        jXLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jXLabel75.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXLabel75.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jXLabel75.setOpaque(true);
        jXLabel75.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXLabel75MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jXLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jXLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jXLabel75, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(226, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(134, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jXLabel73MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel73MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel73MouseClicked

    private void jXLabel74MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel74MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel74MouseClicked

    private void jXLabel75MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel75MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel75MouseClicked

    private void jXLabel66MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel66MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel66MouseClicked

    private void tf_waiter3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_waiter3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_waiter3MouseClicked

    private void tf_waiter6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_waiter6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_waiter6MouseClicked

    private void jXLabel67MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel67MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel67MouseClicked

    private void jXLabel71MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel71MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel71MouseClicked

    private void tf_waiter7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_waiter7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_waiter7MouseClicked

    private void jXLabel72MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel72MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel72MouseClicked

    private void tf_waiter8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_waiter8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_waiter8MouseClicked

    private void tf_waiter5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_waiter5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_waiter5MouseClicked

    private void jXLabel68MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel68MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel68MouseClicked

    private void tf_waiter4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_waiter4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_waiter4MouseClicked

    private void jXLabel69MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel69MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel69MouseClicked

    private void tf_waiter9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_waiter9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_waiter9MouseClicked

    private void tf_waiter10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_waiter10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_waiter10MouseClicked

    private void jXLabel76MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel76MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel76MouseClicked

    private void tf_waiter11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_waiter11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_waiter11MouseClicked

    private void jXLabel77MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel77MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel77MouseClicked

    private void tf_waiter12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_waiter12MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_waiter12MouseClicked

    private void tf_waiter13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_waiter13MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_waiter13MouseClicked

    private void jXLabel70MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXLabel70MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jXLabel70MouseClicked

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private org.jdesktop.swingx.JXLabel jXLabel66;
    private org.jdesktop.swingx.JXLabel jXLabel67;
    private org.jdesktop.swingx.JXLabel jXLabel68;
    private org.jdesktop.swingx.JXLabel jXLabel69;
    private org.jdesktop.swingx.JXLabel jXLabel70;
    private org.jdesktop.swingx.JXLabel jXLabel71;
    private org.jdesktop.swingx.JXLabel jXLabel72;
    private org.jdesktop.swingx.JXLabel jXLabel73;
    private org.jdesktop.swingx.JXLabel jXLabel74;
    private org.jdesktop.swingx.JXLabel jXLabel75;
    private org.jdesktop.swingx.JXLabel jXLabel76;
    private org.jdesktop.swingx.JXLabel jXLabel77;
    private javax.swing.JPanel pnl_credit_card;
    private javax.swing.JPanel pnl_discount;
    private javax.swing.JTextField tf_waiter10;
    private javax.swing.JTextField tf_waiter11;
    private javax.swing.JTextField tf_waiter12;
    private javax.swing.JTextField tf_waiter13;
    private javax.swing.JTextField tf_waiter3;
    private javax.swing.JTextField tf_waiter4;
    private javax.swing.JTextField tf_waiter5;
    private javax.swing.JTextField tf_waiter6;
    private javax.swing.JTextField tf_waiter7;
    private javax.swing.JTextField tf_waiter8;
    private javax.swing.JTextField tf_waiter9;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
    }

    public void do_pass(){
 
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
    
    
}