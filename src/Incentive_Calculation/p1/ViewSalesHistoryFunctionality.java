package Incentive_Calculation.p1;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class ViewSalesHistoryFunctionality extends JFrame {
    JFrame salesHistoryFrame;
    JLabel empIdLabel, nameLabel, totalSalesLabel;

    public void viewSalesHistoryDetails(String empId) {
        salesHistoryFrame = new JFrame("View Sales History");
        salesHistoryFrame.setSize(600, 400); // Frame size
        salesHistoryFrame.setLayout(new GridLayout(3, 2, 10, 10)); // Grid layout for structured format

       
        try {
            ConnectionClass obj = new ConnectionClass();
            String query = "SELECT * FROM employee WHERE empId=?";
            PreparedStatement statement = obj.c.prepareStatement(query);
            statement.setString(1, empId);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                nameLabel = new JLabel("Employee Name:");
                salesHistoryFrame.add(nameLabel);
                JLabel nameValueLabel = new JLabel(rs.getString("name"));
                salesHistoryFrame.add(nameValueLabel);

                empIdLabel = new JLabel("Employee ID:");
                salesHistoryFrame.add(empIdLabel);
                JLabel empIdValueLabel = new JLabel(empId);
                salesHistoryFrame.add(empIdValueLabel);

                double totalSales = rs.getDouble("sell");
                totalSalesLabel = new JLabel("Total Sales: $" + totalSales);
                totalSalesLabel.setFont(new Font("Arial", Font.BOLD, 16));
                salesHistoryFrame.add(totalSalesLabel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

       
        salesHistoryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - salesHistoryFrame.getWidth()) / 2+350;
        int y = (screenSize.height - salesHistoryFrame.getHeight()) / 2;
        salesHistoryFrame.setLocation(x, y);

        
        salesHistoryFrame.setVisible(true);
    }
}
