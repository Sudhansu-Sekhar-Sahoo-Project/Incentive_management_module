package Incentive_Calculation.p1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener {

    Splash() {

        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(356, 20, 1050, 38);
        heading.setFont(new Font("serif", Font.PLAIN, 50));
        heading.setForeground(Color.RED);
        add(heading);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Incentive_Calculation/p1/splash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(330, 20, 900, 700);
        add(image);

        JButton clickhere = new JButton("CLICK HERE TO CONTINUE");
        clickhere.setBounds(310, 630, 300, 70);
        clickhere.setBackground(Color.cyan);
        clickhere.setForeground(Color.red);
        clickhere.setFont(new Font("serif", Font.PLAIN, 30));
        clickhere.addActionListener(this);
        image.add(clickhere);

//        
//        setSize(1170, 650);
//        setLocation(200, 50);
//        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);

        while (true) {
            heading.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {

            }

            heading.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {

            }
        }
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new AdminLogin();
    }

    public static void main(String args[]) {
        new Splash();
    }
}
