import processing.OptionProcessor;
import processing.Source;
import javax.swing.*;
import java.awt.event.*;

public class UI {
    private JPanel mainPanel;
    private JFormattedTextField recordInput;
    private JTextArea outputTextArea;
    private JButton generateButton, submitButton, clearButton;


    private void showWindow() {
        JFrame frame = new JFrame();
        frame.setContentPane(mainPanel);
        frame.setTitle("Random Option Selector v 1.21");
        frame.setResizable(false);
        frame.setVisible(true);
        submitButton.setEnabled(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);






        frame.pack();
    }

    private void checkSrc() {
        if (OptionProcessor.getInstance().getOption() == null) {
            generateButton.setVisible(false);
            clearButton.setVisible(false);
            outputTextArea.setText("The app was UNABLE to find any records\nPlease make sure source file is in the same folder\nand / or contains at least one record\nFeel free to add" +
                    " your own records they will be synced");
        }
    }

    private void addInputListeners() {
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
                    outputTextArea.setText("An ERROR OCCURED:\nAn Empty record cannot be added to the source\nPlease make sure your record has at least one character ");
                else {
                    OptionProcessor.getInstance().addOption(recordInput.getText());
                    outputTextArea.setText("A record has been added successfully");
                    generateButton.setVisible(true);
                    clearButton.setVisible(true);
                    recordInput.setText("");
                }
            }
        });

        recordInput.addInputMethodListener(new InputMethodListener() {
            @Override
            public void caretPositionChanged(InputMethodEvent event) {}
            @Override
            public void inputMethodTextChanged(InputMethodEvent event) {}
        });
        recordInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                    if (recordInput.getText().equalsIgnoreCase(""))
                        outputTextArea.setText("An ERROR OCCURED:\nAn Empty record cannot be added to the source\nPlease make sure your record has at least one character ");
                    else {
                        OptionProcessor.getInstance().addOption(recordInput.getText());
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

                int res = JOptionPane.showConfirmDialog(null, "Are you sure you want to wipe option storage?", "Alert" , JOptionPane.YES_NO_OPTION);

                if (res == 0) {
                    Source.wipe();
                    clearButton.setVisible(false);
                    generateButton.setVisible(false);
                    outputTextArea.setText("Storage has been wiped successfully\nNo records are currenly available");
                }
            }
        });





        submitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);

                if (recordInput.getText().length() == 0) {
                    submitButton.setEnabled(false);
                }

                else {
                    submitButton.setEnabled(true);
                }

            }
        });





        recordInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (recordInput.getText().length() > 0)
                    submitButton.setEnabled(true);
            }
        });
    }

    private UI() {
        showWindow();
        checkSrc();
        addInputListeners();

    }
    public static void main(String[] args) {
        UI ui = new UI();
    }
}
