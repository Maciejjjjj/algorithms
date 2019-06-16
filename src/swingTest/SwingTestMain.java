package swingTest;

import javax.swing.*;
import java.awt.*;

public class SwingTestMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { // invokeLater = stwórz nowy wątek ; potem lambda bez argumentów

            JFrame frame = new JFrame("Hello, World!"); // nowa ramka programu o nazwie Hello World

            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // co sie stanie po zamknięciu ramki

            frame.add(new JLabel("dsgsdfdg!")); // dodaj nowy element JLabel o tekście dsgsdfdg!

            frame.setLayout(new FlowLayout()); // ustawienie elementów ramki

            JTextArea textArea = new JTextArea(); // tworzymy nowy JTextArea

            textArea.setText("bla"); // ustawiamy tekst (wartość) stworzonego JTextArea

            JTextField textField = new JTextField(); // tworzymy nowy JTextField

            textField.setText("blabla"); // ustawiamy tekst (wartość) stworzonego JTextField

            frame.add(textArea); // dodajemy stworzony wcześniej JTextArea do ramki programu

            frame.add(textField); // dodajemy stworzony wcześniej JTextField do ramki programu

            frame.setMinimumSize(new Dimension(500, 200)); // ustawiamy minimalny wymiar ramki

            JButton guzik = new JButton("go");

            frame.add(guzik);

            frame.pack(); // pakujemy do ramki jej elementy

            frame.setVisible(true); // ustawiamy widoczność na zauważalną

        });
    }
}
