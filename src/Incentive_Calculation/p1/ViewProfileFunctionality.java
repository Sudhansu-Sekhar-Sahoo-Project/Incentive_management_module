package Incentive_Calculation.p1;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class ViewProfileFunctionality extends JFrame {
    JFrame profileFrame;
    JLabel nameLabel, idLabel, addressLabel, phoneLabel, emailLabel, educationLabel, designationLabel, aadharLabel, salaryLabel;
    String empId = UserLogin.empId;

    public void ViewProfileFunctionalityMethod(String empId) {
        profileFrame = new JFrame("View Profile");
        profileFrame.setSize(600, 500);
        profileFrame.setLocation(800,250);
        profileFrame.setLayout(new GridLayout(9, 2, 10, 10)); // Grid layout for structured format

       
        profileFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        
        try {
            ConnectionClass obj = new ConnectionClass();
            String query = "SELECT * FROM employee WHERE empId=?";
            PreparedStatement statement = obj.c.prepareStatement(query);
            statement.setString(1, empId);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                nameLabel = new JLabel("Name:");
                profileFrame.add(nameLabel);
                JLabel nameValueLabel = new JLabel(rs.getString("name"));
                profileFrame.add(nameValueLabel);

                idLabel = new JLabel("Emp ID:");
                profileFrame.add(idLabel);
                JLabel idValueLabel = new JLabel(empId);
                profileFrame.add(idValueLabel);

                addressLabel = new JLabel("Address:");
                profileFrame.add(addressLabel);
                JLabel addressValueLabel = new JLabel(rs.getString("address"));
                profileFrame.add(addressValueLabel);

                phoneLabel = new JLabel("Phone:");
                profileFrame.add(phoneLabel);
                JLabel phoneValueLabel = new JLabel(rs.getString("phone"));
                profileFrame.add(phoneValueLabel);

                emailLabel = new JLabel("Email:");
                profileFrame.add(emailLabel);
                JLabel emailValueLabel = new JLabel(rs.getString("email"));
                profileFrame.add(emailValueLabel);

                educationLabel = new JLabel("Education:");
                profileFrame.add(educationLabel);
                JLabel educationValueLabel = new JLabel(rs.getString("education"));
                profileFrame.add(educationValueLabel);

                designationLabel = new JLabel("Designation:");
                profileFrame.add(designationLabel);
                JLabel designationValueLabel = new JLabel(rs.getString("designation"));
                profileFrame.add(designationValueLabel);

                aadharLabel = new JLabel("Aadhar:");
                profileFrame.add(aadharLabel);
                JLabel aadharValueLabel = new JLabel(rs.getString("aadhar"));
                profileFrame.add(aadharValueLabel);

                salaryLabel = new JLabel("Salary:");
                profileFrame.add(salaryLabel);
                JLabel salaryValueLabel = new JLabel(rs.getString("salary"));
                profileFrame.add(salaryValueLabel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        
        profileFrame.setVisible(true);
    }
}
