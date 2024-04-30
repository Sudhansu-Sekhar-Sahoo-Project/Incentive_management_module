package Incentive_Calculation.p1;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.util.Locale;

public class AdminLogin extends JFrame implements ActionListener 
{
    JFrame f;
    JLabel l1,l2,adminLabel;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2,b3;
    
    AdminLogin()
    {
        f=new JFrame("Admin Login");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBackground(Color.WHITE);
        f.setLayout(null);
        
        ImageIcon background=new ImageIcon(ClassLoader.getSystemResource("Incentive_Calculation/p1/back_img.jpg"));
        Image background1=background.getImage().getScaledInstance(1600, 900, Image.SCALE_DEFAULT);
        ImageIcon background2=new ImageIcon(background1);
        JLabel backgroundLabel=new JLabel(background2);
        backgroundLabel.setBounds(0,0,1600,900);
        
        f.add(backgroundLabel);
        
        JLabel adminLabel =new JLabel("ADMIN LOGIN PANEL");
        adminLabel.setBounds(530, 30, 700, 70);//(L-R, U-D, box-width, box-height)
        adminLabel.setFont(new Font("Arial", Font.BOLD, 50));
        adminLabel.setForeground(Color.ORANGE);
        
        backgroundLabel.add(adminLabel);
        
        
        JLabel l1=new JLabel("Admin Name");
        l1.setBounds(40, 120, 200, 30);//(L-R, U-D, box-width, box-height)
        l1.setFont(new Font("Arial", Font.BOLD, 28));
        l1.setForeground(Color.green);
        
        backgroundLabel.add(l1);
        
        l2=new JLabel("Password");
        l2.setBounds(40, 180,200, 30);//(L-R, U-D, box-width, box-height)
        l2.setFont(new Font("Arial", Font.BOLD, 28));
        l2.setForeground(Color.green);
        backgroundLabel.add(l2);
        
        t1=new JTextField();
        t1.setBounds(250,120,250,30);//(L-R, U-D, box-width, box-height)
        backgroundLabel.add(t1);
        
        t2=new JPasswordField();
        t2.setBounds(250,180,250,30);//(L-R, U-D, box-width, box-height)
        backgroundLabel.add(t2);
        
//        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Incentive_Calculation/p1/key_img_1.png"));
//        Image i2=i1.getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT);
//        ImageIcon i3=new ImageIcon(i2);
//        JLabel l3=new JLabel(i3);
//        l3.setBounds(350, 120, 150, 150);
//        f.add(l3);
        

        
//        l3.setBounds(350, 20, 150, 150);
//        f.add(l3);
        //f.add(backgroundLabel);
        
        b1=new JButton("Login");
        b1.setBackground(Color.red);
        b1.setBounds(100, 260, 120, 30);
        b1.addActionListener(this);
        b1.setForeground(Color.yellow);
        backgroundLabel.add(b1);
        
        
        b2=new JButton("Cancel");
        b2.setBackground(Color.red);
        b2.setBounds(250, 260, 120, 30);
        b2.addActionListener(this);
        b2.setForeground(Color.yellow);
        backgroundLabel.add(b2);
        
        b3=new JButton("USER LOGIN");
        b3.setBackground(Color.MAGENTA);
        b3.setBounds(111, 350, 250,40);
        b3.addActionListener(this);
        b3.setForeground(Color.white);
        backgroundLabel.add(b3);
        l1.setFont(new Font("Arial", Font.BOLD, 30));
        f.getContentPane();
        
        f.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the frame to full screen
        f.setVisible(true);
//        f.setVisible(true);
//        f.setSize(1600,800);
       // f.setLocation(400,300);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ee)
    {
        if(ee.getSource()==b1)
        {
            try
            {
                ConnectionClass obj=new ConnectionClass();
                String name=t1.getText();
                String pass=t2.getText();
                String q="select * from login_admin where username='"+name+"' and password='"+pass+"'";
                
                ResultSet rs=obj.s.executeQuery(q);
                
                if(rs.next())
                {
                    new AdminHomePage().setVisible(true);   
                    this.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"You have Entered Wrong User Name or Password");
                    f.setVisible(false);
                    f.setVisible(true);
                }
            }
            catch(HeadlessException | SQLException e)
            {
                e.printStackTrace();

            }
        }
        if(ee.getSource()==b2)
        { 
            this.f.setVisible(false);
        }
        if(ee.getSource()==b3)
        {
            new UserLogin().UserLoginMethod();
            this.f.setVisible(false);
        }
    }

}
