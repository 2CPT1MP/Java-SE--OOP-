package ui;

import javax.swing.*;

public abstract class Errors {

    public static void showFileNotFoundError() {
        JOptionPane.showMessageDialog(null, "Source file cannot be located. Please make sure it is in the root directory along with this application");
    }

    public static void showIOerror() {
        JOptionPane.showMessageDialog(null, "An error occured during reading / writing a file. Please make sure the application has priviligies for disk I/O");
    }
}
