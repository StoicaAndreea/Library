package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

public class GuiApp {
    private JPanel PanelMain1;
    private JButton buttonMsg;
    private JComboBox opt;
    private JTable table1;

    public GuiApp() {
        buttonMsg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"HelloWorldd");
            }
        });
        table1.addComponentListener(new ComponentAdapter() {
            @Override
            public String toString() {
                return super.toString();
            }
        });
        opt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opt = (JComboBox)e.getSource();
                String op = (String)opt.getSelectedItem();
            }
        });
    }

    public JPanel getPanelMain1() {
        return PanelMain1;
    }

    public JButton getButtonMsg() {
        return buttonMsg;
    }
}
