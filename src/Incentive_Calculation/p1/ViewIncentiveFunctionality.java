package Incentive_Calculation.p1;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class ViewIncentiveFunctionality extends JFrame {
    JFrame incentiveFrame;
    JLabel empIdLabel, nameLabel, lastIncrementLabel;

    public void viewIncentiveDetails(String empId) {
        incentiveFrame = new JFrame("View Incentive");
        incentiveFrame.setSize(600, 400); // Larger frame size
        incentiveFrame.setLayout(new GridLayout(3, 2, 10, 10)); // Grid layout for structured format

        // Fetch employee details and last increment from the database using empId
        try {
            ConnectionClass obj = new ConnectionClass();
            String query = "SELECT * FROM employee WHERE empId=?";
            PreparedStatement statement = obj.c.prepareStatement(query);
            statement.setString(1, empId);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                nameLabel = new JLabel("Employee Name:");
                incentiveFrame.add(nameLabel);
                JLabel nameValueLabel = new JLabel(rs.getString("name"));
                incentiveFrame.add(nameValueLabel);

                empIdLabel = new JLabel("Employee ID:");
                incentiveFrame.add(empIdLabel);
                JLabel empIdValueLabel = new JLabel(empId);
                incentiveFrame.add(empIdValueLabel);

                double lastIncrement = rs.getDouble("LastIncrement");
                lastIncrementLabel = new JLabel("Last Increment: $" + lastIncrement);
                lastIncrementLabel.setFont(new Font("Arial", Font.BOLD, 16));
                incentiveFrame.add(lastIncrementLabel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

       
        incentiveFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Position the frame slightly to the right
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - incentiveFrame.getWidth()) / 2 + 350; // Adjusted position
        int y = (screenSize.height - incentiveFrame.getHeight()) / 2;
        incentiveFrame.setLocation(x, y);

       
        incentiveFrame.setVisible(true);
    }
}
