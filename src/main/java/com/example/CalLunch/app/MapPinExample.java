package com.example.CalLunch.app;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MapPinExample extends JFrame {

    private JPanel panel;
    private JLabel label;
    private JButton pinButton = null; //追加7/5

    public MapPinExample() {
        super("Map Pin Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(950, 480));
        add(panel);

        ImageIcon mapIcon = new ImageIcon("image/image.jpg"); // 画像ファイルのパス
        label = new JLabel(mapIcon);
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                drawPin(x, y);
            }
        });
        panel.add(label);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void drawPin(int x, int y) {
        ImageIcon pinIcon = new ImageIcon("image/pin.png"); // ピン画像ファイルのパス
//        前回指定したピンがあれば削除する
        if(pinButton != null) {
        	label.remove(pinButton);
        }
        JButton button = new JButton(pinIcon);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(MapPinExample.this, "Button clicked at (" + x + ", " + y + ")");
            }
        });
        label.add(button);
        pinButton = button;
        button.setBounds(x - 5, y - 20, pinIcon.getIconWidth(), pinIcon.getIconHeight());
        label.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MapPinExample());
    }
}