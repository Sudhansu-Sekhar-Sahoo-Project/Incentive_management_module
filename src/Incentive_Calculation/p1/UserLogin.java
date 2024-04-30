package Incentive_Calculation.p1;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class UserLogin extends JFrame implements ActionListener {
    JFrame g;
    JLabel l1, l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1, b2, b3;
    static String empId;

    public void UserLoginMethod() {
        g = new JFrame("User Login");
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        g.setBackground(Color.WHITE);
        g.setLayout(null);

        ImageIcon background = new ImageIcon(ClassLoader.getSystemResource("Incentive_Calculation/p1/back_img2.jpg"));
        Image background1 = background.getImage().getScaledInstance(1600, 900, Image.SCALE_DEFAULT);
        ImageIcon background2 = new ImageIcon(background1);
        JLabel backgroundLabel = new JLabel(background2);
        backgroundLabel.setBounds(0, 0, 1600, 900);

        g.add(backgroundLabel);

        JLabel adminLabel = new JLabel("USER LOGIN PANEL");
        adminLabel.setBounds(530, 30, 700, 70);
        adminLabel.setFont(new Font("Arial", Font.BOLD, 50));
        adminLabel.setForeground(Color.cyan);

        backgroundLabel.add(adminLabel);

        l1 = new JLabel("User ID");
        l1.setBounds(40, 120, 200, 30);
        l1.setFont(new Font("Arial", Font.BOLD, 28));
        l1.setForeground(Color.orange);
        backgroundLabel.add(l1);

        l2 = new JLabel("Password");
        l2.setBounds(40, 180, 200, 30);
        l2.setFont(new Font("Arial", Font.BOLD, 28));
        l2.setForeground(Color.orange);
        backgroundLabel.add(l2);

        t1 = new JTextField();
        t1.setBounds(250, 120, 250, 30);
        backgroundLabel.add(t1);

        t2 = new JPasswordField();
        t2.setBounds(250, 180, 250, 30);
        backgroundLabel.add(t2);

        b1 = new JButton("Login");
        b1.setBackground(Color.red);
        b1.setBounds(100, 260, 120, 30);
        b1.addActionListener(this);
        b1.setForeground(Color.yellow);
        backgroundLabel.add(b1);

        b2 = new JButton("Cancel");
        b2.setBackground(Color.red);
        b2.setBounds(250, 260, 120, 30);
        b2.addActionListener(this);
        b2.setForeground(Color.yellow);
        backgroundLabel.add(b2);

        b3 = new JButton("ADMIN LOGIN");
        b3.setBackground(Color.MAGENTA);
        b3.setBounds(111, 350, 250, 40);
        b3.addActionListener(this);
        b3.setForeground(Color.white);
        backgroundLabel.add(b3);

        g.setExtendedState(JFrame.MAXIMIZED_BOTH);
        g.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ee) {
        if (ee.getSource() == b1) {
            try {
                ConnectionClass obj = new ConnectionClass();
                empId = t1.getText();
                String pass = t2.getText();

                String q = "select * from employee where empId='" + empId + "' and password='" + pass + "'";

                ResultSet rs = obj.s.executeQuery(q);

                if (rs.next()) {
                    
                    new UserHomePage().UserHomePageMethod();
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "You have Entered Wrong User Id or Password");
                    g.setVisible(false);
                    g.setVisible(true);
                }
            } catch (HeadlessException | SQLException e) {
                e.printStackTrace();
            }
        }
        
        if (ee.getSource() == b2) {
            this.g.setVisible(false);
        }
        if (ee.getSource() == b3) {
            this.g.setVisible(false);
            new AdminLogin();
        }
        
    }

}
