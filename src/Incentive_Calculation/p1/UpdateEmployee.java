package Incentive_Calculation.p1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener{
    
    JTextField tfeducation, tffname, tfaddress,tftotalsell, tfphone, tfaadhar, tfemail, tfsalary, tfdesignation;
    JLabel lblempId,lblpassword;
    JButton add, back;
    String empId,body,packagemsg= " ";
    static double updatedsalary,increment,salary;
    static int bonus=1000;
    static int sell;
    
    UpdateEmployee(String empId) {
        this.empId = empId;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Update Employee Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 150, 150, 30);
        add(lblname);
        
        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);
        
        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);
        
        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);
        
        JLabel lbldob = new JLabel();
        lbldob.setBounds(200, 200, 150, 30);
        add(lbldob);
        
        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(400, 200, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(600, 200, 150, 30);
        add(tfsalary);
        
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400, 250, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);
        
        JLabel labeleducation = new JLabel("Higest Education");
        labeleducation.setBounds(400, 300, 150, 30);
        labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeleducation);
        
        tfeducation = new JTextField();
        tfeducation.setBounds(600, 300, 150, 30);
        add(tfeducation);
        
        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50, 350, 150, 30);
        labeldesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldesignation);
        
        tfdesignation = new JTextField();
        tfdesignation.setBounds(200, 350, 150, 30);
        add(tfdesignation);
        
        JLabel labelaadhar = new JLabel("Aadhar Number");
        labelaadhar.setBounds(400, 350, 150, 30);
        labelaadhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelaadhar);
        
        JLabel lblaadhar = new JLabel();
        lblaadhar.setBounds(600, 350, 150, 30);
        add(lblaadhar);
        
        JLabel labelempId = new JLabel("Employee id");
        labelempId.setBounds(50, 400, 150, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);
        
        lblempId = new JLabel();
        lblempId.setBounds(200, 400, 150, 30);
        lblempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempId);
        
        JLabel labelpassword = new JLabel("User Password");
        labelpassword.setBounds(400, 400, 150, 30);
        labelpassword.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelpassword);
        
        lblpassword = new JLabel();
        lblpassword.setBounds(600, 400, 150, 30);
        add(lblpassword);
        
        JLabel labeltotalSell = new JLabel("Total  Sell  Of  this  month");
        labeltotalSell.setBounds(70, 450, 300, 30);
        labeltotalSell.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeltotalSell);
        
        tftotalsell = new JTextField();
        tftotalsell.setBounds(350, 450, 250, 30);
        add(tftotalsell);
        
        //----------------------------------------------------------------27/04/2024(work pending)
        String bronzeDetails = fetchPackageDetails("Bronze");
        String silverDetails = fetchPackageDetails("Silver");
        String goldDetails = fetchPackageDetails("Gold");

        // Print package details
        System.out.println("Bronze Package Details:");
        System.out.println(bronzeDetails);

        System.out.println("Silver Package Details:");
        System.out.println(silverDetails);

        System.out.println("Gold Package Details:");
        System.out.println(goldDetails);
        //----------------------------------------------------------------
        
        try {
            ConnectionClass c = new ConnectionClass();
            String query = "select * from employee where empId = '"+empId+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                lblname.setText(rs.getString("name"));//Not changable
                tffname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));//Not changable
                tfaddress.setText(rs.getString("address"));

                tfsalary.setText(rs.getString("salary"));
                tftotalsell.setText(rs.getString("sell"));

                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));
                lblaadhar.setText(rs.getString("aadhar"));//Not changable
                lblempId.setText(rs.getString("empId"));//Not changable
                tfdesignation.setText(rs.getString("designation"));
                lblpassword.setText(rs.getString("password"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        add = new JButton("Update Details");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }
    
    //----------------------------------------------------------------------------------------------------------------
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
     //--------------------------------------------------------------------------------------------------------------
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) 
        {
            String fname = tffname.getText();
            salary = Double.parseDouble(tfsalary.getText());
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = tfeducation.getText();
            String designation = tfdesignation.getText();
            sell = Integer.parseInt(tftotalsell.getText());
            if (sell >= 50000) {
                increment = salary * 0.05;
                JOptionPane.showMessageDialog(this, "Congratulations! You qualify for a 5% incentive and a holiday package.");
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
            else if (sell >= 30000) 
            {
                increment = salary * 0.035 + bonus;
                JOptionPane.showMessageDialog(this, "Congratulations! You qualify for a 3.5% incentive and a $1000 bonus.");
            } 
            else if (sell >= 20000) 
            {
                increment = salary * 0.03;
                JOptionPane.showMessageDialog(this, "Congratulations! You qualify for a 3% incentive.");
            } 
            else if (sell >= 10000) 
            {
                increment = salary * 0.015;
                JOptionPane.showMessageDialog(this, "Congratulations! You qualify for a 1.5% incentive.");
            }
            else 
            {
                JOptionPane.showMessageDialog(this, "Your sales performance does not qualify for any incentives.");
            }

            updatedsalary = salary + increment;
            System.out.println("increment"+increment);
            System.out.println("Updated salary"+updatedsalary);
            
            
            if (increment > 0) 
            {
                try 
                {
                ConnectionClass conn = new ConnectionClass();
                String query = "update employee set fname = '"+fname+"', salary = '"+updatedsalary+"', address = '"+address+"', phone = '"+phone+"', email =  '"+email+"', education = '"+education+"', designation = '"+designation+"', sell = '"+sell+"', LastIncrement ='"+increment+"' where empId = '"+empId+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new AdminHomePage();
                } 
                catch (Exception e) 
                {
                    e.printStackTrace();
                }
                
            
                EmailSender emailSender = new EmailSender("sudhansusahoo0101@gmail.com", "anzdyyysajwzmrel");

            
                String subject = "Congratulations on Achieving Sales Target!";
                body = "Dear sir , \n\n Congratulations on achieving your sales target!" +sell+
                        "\n \n Your sales performance qualifies you for an incentive of $" + increment + ".\n" +
                        "Your updated salary is $" + updatedsalary + ".\n\n" +
                        packagemsg+"\"Best regards,\\n\\n HyScaler\\n\"";

            // Send the email
                emailSender.sendEmail(tfemail.getText(), subject, body);
            }
            else
            {
                try 
                {
                ConnectionClass conn = new ConnectionClass();
                String query = "update employee set fname = '"+fname+"', salary = '"+salary+"', address = '"+address+"', phone = '"+phone+"', email =  '"+email+"', education = '"+education+"', designation = '"+designation+"' where empId = '"+empId+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                this.setVisible(false);
                new AdminHomePage();
                } 
                catch (Exception e) 
                {
                    e.printStackTrace();
                }
            }
            
            
            
        } 
        else 
        {
            setVisible(false);
            new AdminHomePage();
        }
    }

    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}