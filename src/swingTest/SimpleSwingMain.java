package swingTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleSwingMain {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("My Swing program");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.add(new JLabel("Hello World!1"));
            frame.add(new JLabel("Hello World!2"));
            frame.add(new JLabel("Hello World!3"));
            frame.add(new JLabel("Hello World!4"));

            frame.setLayout(new GridLayout(2, 2));

            frame.setMinimumSize(new Dimension(100, 50));
            JButton button = new JButton("Go!");
            frame.add(button);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JCheckBox checkBox = new JCheckBox();
                    frame.add(checkBox);
                    frame.pack();
                    checkBox.setVisible(true);
                    frame.setVisible(true);
                }
            });

            frame.setVisible(true);

        });
    }
}
