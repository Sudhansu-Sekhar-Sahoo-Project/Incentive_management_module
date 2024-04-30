package Incentive_Calculation.p1;

import static Incentive_Calculation.p1.UpdateEmployee.sell;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class DailyUpdates extends JFrame implements ActionListener {

    Choice cEmpId;
    JTextField tftotalsellofday;
    JButton update, back;
    JLabel lblemail;
    EmailSender emailSender;
    String packagemsg= " ";
    

    DailyUpdates(String empId) {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Daily Employee Updates");
        heading.setBounds(320, 0, 500, 30);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        add(heading);

        JLabel searchlbl = new JLabel("Select Employee ID");
        searchlbl.setBounds(160, 50, 300, 25);
        searchlbl.setFont(new Font("serif", Font.PLAIN, 20));
        add(searchlbl);

        cEmpId = new Choice();
        cEmpId.setBounds(180, 80, 150, 25);
        add(cEmpId);

        try {
            ConnectionClass c = new ConnectionClass();
            String query = "select * from employee";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                cEmpId.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel labeltotalsellofday = new JLabel("Total Sell of the Day");
        labeltotalsellofday.setBounds(365, 50, 300, 28);
        labeltotalsellofday.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeltotalsellofday);

        tftotalsellofday = new JTextField();
        tftotalsellofday.setBounds(370, 80, 150, 25);
        add(tftotalsellofday);

        update = new JButton("Update Details");
        update.setBounds(540, 80, 120, 25);
        update.addActionListener(this);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        add(update);

        back = new JButton("Back");
        back.setBounds(700, 80, 100, 25);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 200, 100, 30);
        add(labelemail);

        lblemail = new JLabel();
        lblemail.setBounds(200, 200, 300, 30);
        add(lblemail);

        cEmpId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    ConnectionClass c = new ConnectionClass();
                    String query = "select * from employee where empId = '" + cEmpId.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()) {
                        lblemail.setText(rs.getString("email"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        //emailSender = new EmailSender("sudhansusahoo0101@gmail.com", "anzdyyysajwzmrel"); // Initialize EmailSender
        
        
        //----------------------------------------------------------------//27/04/2024
        String bronzeDetails = fetchPackageDetails("Bronze");
        String silverDetails = fetchPackageDetails("Silver");
        String goldDetails = fetchPackageDetails("Gold");

        
        System.out.println("Bronze Package Details:");
        System.out.println(bronzeDetails);

        System.out.println("Silver Package Details:");
        System.out.println(silverDetails);

        System.out.println("Gold Package Details:");
        System.out.println(goldDetails);
        //----------------------------------------------------------------
        setSize(900, 250);
        setLocation(300, 50);
        setVisible(true);
    }
    public String fetchPackageDetails(String packageLevel) {
        String details = "";
        try {
            ConnectionClass c = new ConnectionClass();
            String query = "select * from packagedetails where packagelavel = '" + packageLevel + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                details += "Package Level: " + rs.getString("packagelavel") + "\n";
                details += "Package Name: " + rs.getString("packageName") + "\n";
                details += "Duration: " + rs.getString("duration") + "\n";
                details += "Location: " + rs.getString("location") + "\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return details;
    }

    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == update) {
        String recipientEmail = lblemail.getText();
        String subject = "Congratulations on Achieving Sales Target!";
        double increment = 0.0;
        double updatedSalary = 0.0;

        try {
            ConnectionClass c = new ConnectionClass();
            String empId = cEmpId.getSelectedItem();
            String query = "select * from employee where empId = '" + empId + "'";
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                int currentSell = rs.getInt("sell");
                int totalSellOfDay = Integer.parseInt(tftotalsellofday.getText());
                int updatedSell = currentSell + totalSellOfDay;

                double salary = rs.getDouble("salary");

                if (updatedSell >= 50000) {
                    increment = salary * 0.05;
                    JOptionPane.showMessageDialog(this, "The Employee qualifies for a 5% incentive and a holiday package.");
                    if(sell<=75000) 
                    {
                        String packageLevel="Bronze";
                        packagemsg="Additional Benifits : You also qualifies for a Holiday Package. \nHere is your package details :\n\n "+fetchPackageDetails(packageLevel);
                    }
                    else if(sell<=100000)
                    {
                        String packageLevel="Silver";
                        packagemsg="Additional Benifits : You also qualifies for a Holiday Package. \nHere is your package details :\n\n "+fetchPackageDetails(packageLevel);
                    }
                    else
                    {
                        String packageLevel="Gold";
                        packagemsg="Additional Benifits : You also qualifies for a Holiday Package. \nHere is your package details :\n\n "+fetchPackageDetails(packageLevel);
                    }
                } 
                else if (updatedSell >= 30000) {
                    increment = salary * 0.035 + 1000; // Assuming bonus is $1000
                    JOptionPane.showMessageDialog(this, "The Employee qualifies for a 3.5% incentive and a $1000 bonus.");
                } else if (updatedSell >= 20000) {
                    increment = salary * 0.03;
                    JOptionPane.showMessageDialog(this, "The Employee qualifies for a 3% incentive.");
                } else if (updatedSell >= 10000) {
                    increment = salary * 0.015;
                    JOptionPane.showMessageDialog(this, "The Employee qualifies for a 1.5% incentive.");
                } else {
                    JOptionPane.showMessageDialog(this, "This employee sales performance does not qualify for any incentives.");
                }

                updatedSalary = salary + increment;

                
                String updateQuery = "update employee set sell = " + updatedSell + ", salary = " + updatedSalary + ", LastIncrement ='"+increment+"' where empId = '" + empId + "'";
                c.s.executeUpdate(updateQuery);

               
                EmailSender emailSender = new EmailSender("sudhansusahoo0101@gmail.com", "anzdyyysajwzmrel");
                String body = "Dear Sir/Madam,\n\nCongratulations on achieving your sales target!\n\n" +
                        "Your sales performance qualifies you for an incentive of $" + increment + ".\n" +
                        "Your updated salary is $" + updatedSalary + ".\n\nBest regards,\nHyScaler";

                
                emailSender.sendEmail(recipientEmail, subject, body);
                setVisible(false);
                new AdminHomePage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else if (ae.getSource() == back) {
        
        setVisible(false);
        new AdminHomePage();
    }
}


    public static void main(String[] args) {
        new DailyUpdates("");
    }
}
