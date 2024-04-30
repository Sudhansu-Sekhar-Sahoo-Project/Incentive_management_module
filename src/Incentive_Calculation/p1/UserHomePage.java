package Incentive_Calculation.p1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserHomePage implements ActionListener {

    JFrame frame;
    JLabel welcomeLabel;
    JButton profileButton, changePasswordButton, viewIncentivesButton, viewSalesHistoryButton, sendFeedbackButton, logoutButton;
    String empId = UserLogin.empId;
    ViewProfileFunctionality view = new ViewProfileFunctionality();
    ViewIncentiveFunctionality view2=new ViewIncentiveFunctionality();
    ChangePasswordFunctionality view3=new ChangePasswordFunctionality();
    ViewSalesHistoryFunctionality view4=new ViewSalesHistoryFunctionality();

    public void UserHomePageMethod() {

        Color btcolor = new Color(160, 80, 230);

        frame = new JFrame("UserHomePage");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(null);

        
        welcomeLabel = new JLabel("Welcome to Your Dashboard!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 55));
        welcomeLabel.setForeground(new Color(240, 0, 0));
        welcomeLabel.setBounds(350, 50, 850, 80);
        frame.add(welcomeLabel);

       
        profileButton = new JButton("View Profile");
        profileButton.setBounds(60, 170, 200, 50);
        profileButton.setBackground(btcolor);
        profileButton.addActionListener(this); // Add ActionListener to profileButton
        frame.add(profileButton);

        
        changePasswordButton = new JButton("Change Password");
        changePasswordButton.setBounds(60, 270, 200, 50);
        changePasswordButton.setBackground(btcolor);

        changePasswordButton.addActionListener(this); // Add ActionListener to changePasswordButton
        frame.add(changePasswordButton);

        viewIncentivesButton = new JButton("View Incentives");
        viewIncentivesButton.setBounds(60, 370, 200, 50);
        viewIncentivesButton.setBackground(btcolor);
        viewIncentivesButton.addActionListener(this); // Add ActionListener to viewIncentivesButton
        frame.add(viewIncentivesButton);

       
        viewSalesHistoryButton = new JButton("View Sales History");
        viewSalesHistoryButton.setBounds(60, 470, 200, 50);
        viewSalesHistoryButton.setBackground(btcolor);
        viewSalesHistoryButton.addActionListener(this); // Add ActionListener to viewSalesHistoryButton
        frame.add(viewSalesHistoryButton);

        
        sendFeedbackButton = new JButton("Send Feedback");
        sendFeedbackButton.setBounds(60, 570, 200, 50);
        sendFeedbackButton.setBackground(btcolor);
        sendFeedbackButton.addActionListener(this); // Add ActionListener to sendFeedbackButton
        frame.add(sendFeedbackButton);

        
        logoutButton = new JButton("Logout");
        logoutButton.setBounds(60, 670, 200, 50);
        logoutButton.setBackground(btcolor);
        logoutButton.addActionListener(this); // Add ActionListener to logoutButton
        frame.add(logoutButton);

        
        ImageIcon backgroundImageIcon = new ImageIcon(ClassLoader.getSystemResource("Incentive_Calculation/p1/userhomepage03.jpg"));
        Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance(1600, 900, Image.SCALE_DEFAULT);
        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
        backgroundLabel.setBounds(0, 0, 1600, 900);
        frame.add(backgroundLabel);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the frame to full screen
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == profileButton) {
//            frame.setVisible(false);
            view.ViewProfileFunctionalityMethod(empId);
        } else if (e.getSource() == changePasswordButton) {
            view3.changePassword(empId);
        } else if (e.getSource() == viewIncentivesButton) {
           view2.viewIncentiveDetails(empId);
           
        } else if (e.getSource() == viewSalesHistoryButton) {
            view4.viewSalesHistoryDetails(empId);
        } else if (e.getSource() == sendFeedbackButton) {
            // iwill add it ii later bcz it needs an extra column in database so ...
        } else if (e.getSource() == logoutButton) {
            
            frame.dispose(); // Close the current frame
            new UserLogin().UserLoginMethod(); // Open the login frame again
        }
    }

    public static void main(String[] args) {
        new UserHomePage().UserHomePageMethod();
    }

}
