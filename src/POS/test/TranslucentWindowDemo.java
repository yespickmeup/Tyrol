/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.test;

/**
 *
 * @author Ronald
 */
import java.awt.*;
import javax.swing.*;
import static java.awt.GraphicsDevice.WindowTranslucency.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import mijzcx.synapse.desk.utils.KeyMapping;

public final class TranslucentWindowDemo extends JFrame {

    @Override
    public void setUndecorated(boolean undecorated) {
        super.setUndecorated(true);
    }

    public TranslucentWindowDemo() {
        super("TranslucentWindow");

        setLayout(new GridBagLayout());
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().
                getWidth());
        int ySize = ((int) tk.getScreenSize().
                getHeight());
        setSize(xSize, ySize);
        setUndecorated(true);
        setOpacity(0.80f);
        closes();
        setLocationRelativeTo(null);

    }

    private void closes() {
        KeyMapping.mapKeyWIFW(this.rootPane,
                              KeyEvent.VK_ESCAPE, new KeyMapping.KeyAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tw.dispose();
            }
        });
    }

    static TranslucentWindowDemo tw = new TranslucentWindowDemo();

    public static void main(String[] args) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        if (!gd.isWindowTranslucencySupported(TRANSLUCENT)) {

        } else {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {

                    tw.setVisible(true);
                }
            });
        }

    }
}
