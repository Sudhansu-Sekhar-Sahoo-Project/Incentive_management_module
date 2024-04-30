package Incentive_Calculation.p1;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.util.Locale;

public class AdminHomePage extends JFrame implements ActionListener
{
        JLabel backgroundLabel;
        JFrame h1;
        JButton add,view,update,delete,HolidayPackage,dailysellupdates;
        
    AdminHomePage()
    {
        
        h1=new JFrame("AdminHomePage");
        h1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        h1.setBackground(Color.WHITE);
        h1.setLayout(null);
        
        ImageIcon background=new ImageIcon(ClassLoader.getSystemResource("Incentive_Calculation/p1/admin_home.jpg"));
        Image background1=background.getImage().getScaledInstance(1600, 900, Image.SCALE_DEFAULT);
        ImageIcon background2=new ImageIcon(background1);
        JLabel backgroundLabel=new JLabel(background2);
        backgroundLabel.setBounds(0,0,1600,900);
        
        
        add=new JButton("Insert");
        add.setBackground(Color.white);
        add.setBounds(10, 10, 160, 60);//(L-R, U-D, box-width, box-height)
        add.setFont(new Font("Arial", Font.BOLD, 20));
        add.addActionListener(this);
        add.setForeground(Color.red);
        backgroundLabel.add(add);
        
        
        view=new JButton("View");
        view.setBackground(Color.white);
        view.setBounds(220, 10, 160, 60);//(L-R, U-D, box-width, box-height)
        view.setFont(new Font("Arial", Font.BOLD, 20));
        view.addActionListener(this);
        view.setForeground(Color.red);
        backgroundLabel.add(view);
        
        update=new JButton("Update");
        update.setBackground(Color.white);
        update.setBounds(430, 10, 160, 60);//(L-R, U-D, box-width, box-height)
        update.setFont(new Font("Arial", Font.BOLD, 20));
        update.addActionListener(this);
        update.setForeground(Color.red);
        backgroundLabel.add(update);
        
        delete=new JButton("Delete");
        delete.setBackground(Color.white);
        delete.setBounds(640, 10, 160, 60);//(L-R, U-D, box-width, box-height)
        delete.setFont(new Font("Arial", Font.BOLD, 20));
        delete.addActionListener(this);
        delete.setForeground(Color.red);
        backgroundLabel.add(delete);
        h1.add(backgroundLabel);
        
        HolidayPackage=new JButton("Holiday Package");
        HolidayPackage.setBackground(Color.white);
        HolidayPackage.setBounds(10, 300, 300, 80);//(L-R, U-D, box-width, box-height)
        HolidayPackage.setFont(new Font("Arial", Font.BOLD, 20));
        HolidayPackage.addActionListener(this);
        HolidayPackage.setForeground(Color.red);
        backgroundLabel.add(HolidayPackage);
        h1.add(backgroundLabel);
        
        dailysellupdates=new JButton("Daily Sell Updates");
        dailysellupdates.setBackground(Color.white);
        dailysellupdates.setBounds(10, 140, 300, 80);//(L-R, U-D, box-width, box-height)
        dailysellupdates.setFont(new Font("Arial", Font.BOLD, 25));
        dailysellupdates.addActionListener(this);
        dailysellupdates.setForeground(Color.red);
        backgroundLabel.add(dailysellupdates);
        
        
        h1.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the frame to full screen
        h1.setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == add) {
        setVisible(false);
        AddEmployee addobj=new AddEmployee();
    } else if (ae.getSource() == view) {
        setVisible(false);
        ViewEmployee viewobj=new ViewEmployee();
    } else if (ae.getSource() == update) {
        setVisible(false);
        new ViewEmployee();
    } else if(ae.getSource() == delete){
        setVisible(false);
        RemoveEmployee removeobj=new RemoveEmployee();
    } else if(ae.getSource() == HolidayPackage){
        setVisible(false);
        AddPackage addpackage=new AddPackage();
    }else if(ae.getSource() == dailysellupdates){
        setVisible(false);
        DailyUpdates daily=new DailyUpdates("");
    }
}


}
