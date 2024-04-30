package Incentive_Calculation.p1;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class ChangePasswordFunctionality extends JFrame {
    JFrame changePasswordFrame;
    JLabel newPasswordLabel;
    JTextField newPasswordField;
    JButton updateButton;

    public void changePassword(String empId) {
        changePasswordFrame = new JFrame("Change Password");
        changePasswordFrame.setSize(300, 200); // Set smaller frame size
        changePasswordFrame.setLayout(new GridLayout(3, 1, 10, 10)); // Grid layout for structured format

        // Label for "Give your new password"
        newPasswordLabel = new JLabel("Give your new password:");
        changePasswordFrame.add(newPasswordLabel);

        // Text field for new password input
        newPasswordField = new JTextField();
        changePasswordFrame.add(newPasswordField);

        // Update button
        updateButton = new JButton("Update");
        updateButton.addActionListener(e -> updatePassword(empId));
        changePasswordFrame.add(updateButton);

        // Set the close operation to dispose the frame instead of exit
        changePasswordFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Center the frame on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - changePasswordFrame.getWidth()) / 2 + 350; // Adjusted position
        int y = (screenSize.height - changePasswordFrame.getHeight()) / 2;
        changePasswordFrame.setLocation(x, y);

        // Set the changePasswordFrame visible
        changePasswordFrame.setVisible(true);
    }

    private void updatePassword(String empId) {
        // Get the new password from the text field
        String newPassword = newPasswordField.getText();

        // Update password in the database using empId
        try {
            ConnectionClass obj = new ConnectionClass();
            String query = "UPDATE employee SET password=? WHERE empId=?";
            PreparedStatement statement = obj.c.prepareStatement(query);
            statement.setString(1, newPassword);
            statement.setString(2, empId);
            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                // Password updated successfully, show dialog box
                JOptionPane.showMessageDialog(null, "Password updated successfully.");
                changePasswordFrame.dispose(); // Close the changePasswordFrame
            } else {
                JOptionPane.showMessageDialog(null, "Failed to update password.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error updating password.");
        }
    }
}
