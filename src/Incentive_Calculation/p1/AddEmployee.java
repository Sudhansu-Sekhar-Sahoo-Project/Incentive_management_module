package Incentive_Calculation.p1;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener{
    
    Random ran = new Random();
    int number = ran.nextInt(999999);
    
    JTextField tfname, tffname, tfaddress,tftotalSell, tfphone, tfaadhar, tfemail, tfsalary, tfdesignation,tfpassword,lblLastIncrement;
    JDateChooser dcdob;
    JComboBox cbeducation;
    JLabel lblempId;
    JButton add, back;
   
    static int sell,LastIncrement;
    static int salary;
    
    AddEmployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);
        
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
        
        dcdob = new JDateChooser();
        dcdob.setBounds(200, 200, 150, 30);
        add(dcdob);
        
        JLabel labelempId = new JLabel("Employee id");
        labelempId.setBounds(400, 200, 150, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);
        
        lblempId = new JLabel("" + number);
        lblempId.setBounds(600, 200, 150, 30);
        lblempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempId);
        
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
        
        String courses[] = {"BBA", "BCA", "BA", "BSC", "B.COM", "BTech", "MBA", "MCA", "MA", "MTech", "MSC", "PHD"};
        cbeducation = new JComboBox(courses);
        cbeducation.setBackground(Color.WHITE);
        cbeducation.setBounds(600, 300, 150, 30);
        add(cbeducation);
        
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
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(600, 350, 150, 30);
        add(tfaadhar);
        
        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(50, 400, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(200, 400, 150, 30);
        add(tfsalary);
        
        JLabel labelpassword = new JLabel("User Password");
        labelpassword.setBounds(400, 400, 150, 30);
        labelpassword.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(600, 400, 150, 30);
        add(tfpassword);
        
        JLabel labeltotalSell = new JLabel("Total  Sell  Of  this  month");
        labeltotalSell.setBounds(70, 450, 300, 30);
        labeltotalSell.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeltotalSell);
        
        tftotalSell = new JTextField();
        tftotalSell.setBounds(350, 450, 250, 30);
        add(tftotalSell);
        
        lblLastIncrement = new JTextField();
        tftotalSell.setBounds(350, 450, 250, 30);
        //add(tftotalSell);
        
        add = new JButton("Add Details");
        add.setBounds(250, 680, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450, 680, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        setSize(900, 800);
        setLocation(300, 8);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            
            String name = tfname.getText();
            String fname = tffname.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String empId = lblempId.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = (String) cbeducation.getSelectedItem();
            String designation = tfdesignation.getText();
            String aadhar = tfaadhar.getText();
            String password=tfpassword.getText();
            String sellcheck=tftotalSell.getText();
            if(sellcheck.equals(""))
            {
                    sell=0;
            }
            else
            {
                sell=Integer.parseInt(tftotalSell.getText());
            }
            String LastIncrementCheck=lblLastIncrement.getText();
            if(LastIncrementCheck.equals(""))
            {
                LastIncrement=0;
            }
            
                     
            
            
//            String salary=tfsalary.getText();
            salary = Integer.parseInt(tfsalary.getText());
            
//            salary_i = 0; 
//            try {
//                salary_i = Integer.parseInt(salary);
//                System.out.println(salary_i);
//            } catch (NumberFormatException e) {
//            System.err.println("Invalid salary format: " + salary);
//            // Optionally, i can show an error message to the user or add any message for the user
//            }

            try {
                ConnectionClass conn = new ConnectionClass();
                String query = "insert into employee values('" + name + "', '" + fname + "', '" + dob + "', '" + empId + "', '" + address + "', '" + phone + "', '" + email + "', '" + education + "', '" + designation + "', '" + aadhar + "', '" + salary + "', '" +password+"','"+sell+"','" +LastIncrement+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");

                // Send greeting email to the employee
                String senderEmail = "sudhansusahoo0101@gmail.com"; // Sender's email address
                String senderpassword = "anzdyyysajwzmrel"; // Sender's email password
                String subject = "Welcome to Our Company! : HyScaler";
                String body = "Dear " + name + ",\n\nCongratulations! You have been successfully added to our company's employee database.\n\n" +
                                "-----------Details------------\n\n" +
                                "Employee ID: " + empId+"\n"+
                                "Password: " + password+"\n\n"+
                                " Use the above Details to login to your Employee Account \n"+
                                " -----Other details----- \n"+
                                "Name: " + name + "\n" +
                                "Father's Name: " + fname + "\n" +
                                "Date of Birth: " + dob + "\n" +
                                "Salary: " + salary + "\n" +
                                "Address: " + address + "\n" +
                                "Phone: " + phone + "\n" +
                                "Email: " + email + "\n" +
                                "Highest Education: " + education + "\n" +
                                "Designation: " + designation + "\n" +
                                "Aadhar Number: " + aadhar + "\n" 
                               ;
                
                EmailSender emailSender = new EmailSender(senderEmail, senderpassword);
                emailSender.sendEmail(email, subject, body);

                setVisible(false);
                new AdminHomePage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new AdminHomePage();
        }
    }


}