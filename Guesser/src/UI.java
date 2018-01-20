import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {
    private JPanel mainPanel;
    private JLabel hintTextArea;
    private JFormattedTextField formattedTextField1;
    private JTextArea outputTextArea;
    private JButton generateButton;
    private JButton submitButton;


    public UI() {

        JFrame frame = new JFrame();
        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);





        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                outputTextArea.setText(OptionProcessor.getInstance().getOption());

            }
        });
    }


    public static void main(String[] args) {
        OptionProcessor processor = new OptionProcessor();
        UI ui = new UI();
    }





}
