import javax.swing.*;
import java.awt.event.*;


public class UI {
    private JPanel mainPanel;
    private JFormattedTextField recordInput;
    private JTextArea outputTextArea;
    private JButton generateButton;
    private JButton submitButton;
    private JButton clearButton;
    private static OptionProcessor processor;


    public UI() {

        JFrame frame = new JFrame();
        frame.setContentPane(mainPanel);
        frame.setTitle("Random Option Selector v 1.21");
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        if (processor.getOption().equalsIgnoreCase("No options are available")) {
            generateButton.setVisible(false);
            clearButton.setVisible(false);
            outputTextArea.setText("No options are available");
        }





        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                outputTextArea.setText(OptionProcessor.getInstance().getOption());

            }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (recordInput.getText().equalsIgnoreCase(""))
                    outputTextArea.setText("Empty record cannot be added");
                else {
                    processor.addOption(recordInput.getText());
                    outputTextArea.setText("A record has been added successfully");
                    generateButton.setVisible(true);
                    clearButton.setVisible(true);
                    recordInput.setText("");

                }
            }
        });

        recordInput.addInputMethodListener(new InputMethodListener() {
            @Override
            public void caretPositionChanged(InputMethodEvent event) {

            }

            @Override
            public void inputMethodTextChanged(InputMethodEvent event) {

            }
        });
        recordInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                    if (recordInput.getText().equalsIgnoreCase(""))
                        outputTextArea.setText("Empty record cannot be added");
                    else {

                        processor.addOption(recordInput.getText());
                        outputTextArea.setText("A record has been added successfully");
                        recordInput.setText("");
                        clearButton.setVisible(true);
                        submitButton.setVisible(true);
                        generateButton.setVisible(true);

                    }
                }

            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Source.wipe();
                clearButton.setVisible(false);
                generateButton.setVisible(false);
                outputTextArea.setText("Storage has been wiped successfully\nSome features are DISABLED");
            }
        });
    }


    public static void main(String[] args) {
        processor = new OptionProcessor();
        UI ui = new UI();
    }

}
