package gui;

import autoclicker.AutoClicker;

import javax.swing.*;
import java.awt.*;

public class MyApp{


    private JButton runButton;
    private JButton stopButton;
    private JPanel mainPanel;
    private JTextPane textPane1;

    Thread thread;

    public static void main(String[] args) {
        JFrame frame = new JFrame("AutoClicker");
        new MyApp(frame);
    }

    private void init(JFrame frame) {
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setMinimumSize(new Dimension(180, 140));
        frame.setVisible(true);
    }

    public MyApp(JFrame frame) {
        init(frame);

        runButton.addActionListener(e -> {
            thread = new Thread(() -> {
                AutoClicker autoClicker = new AutoClicker();
                textPane1.setText("Running");
                autoClicker.clickImage();
            });
            thread.start();
        });
        stopButton.addActionListener(e -> {
            AutoClicker.shouldRun = false;
            textPane1.setText("");
        });
    }
}
