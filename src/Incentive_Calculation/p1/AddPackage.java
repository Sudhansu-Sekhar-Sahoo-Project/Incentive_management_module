package Incentive_Calculation.p1;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class AddPackage extends JFrame implements ActionListener
{
    Choice cPackageLavel;
    JButton Update, back;
    JLabel lblpackagename, lblduration;
    JTextField tflocation;
    EmailSender emailSender;
    JFrame i;
    AddPackage()
    {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel labelname = new JLabel("Employee Id");
        labelname.setBounds(50, 50, 100, 30);
        add(labelname);
        
        cPackageLavel = new Choice();
        cPackageLavel.setBounds(200, 50, 150, 30);
        add(cPackageLavel);
        
        try {
            ConnectionClass c = new ConnectionClass();
            String query = "select * from packagedetails";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                cPackageLavel.add(rs.getString("packagelavel"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel labelpackagename = new JLabel("Package Name");
        labelpackagename.setBounds(50, 100, 150, 30);
        add(labelpackagename);
        
        lblpackagename = new JLabel();
        lblpackagename.setBounds(200, 100, 150, 30);
        add(lblpackagename);
        
        JLabel labelduration = new JLabel("Package Duration");
        labelduration.setBounds(50, 150,150 , 30);
        add(labelduration);
        
        lblduration = new JLabel();
        lblduration.setBounds(200, 150, 150, 30);
        add(lblduration);
        
        JLabel labellocation = new JLabel("Location & Other");
        labellocation.setBounds(50, 200, 200, 40);
        add(labellocation);
        
        tflocation = new JTextField();
        tflocation.setBounds(200, 200, 300, 30);
        add( tflocation);
        
        try {
            ConnectionClass c = new ConnectionClass();
            String query = "select * from packagedetails where packagelavel = '"+cPackageLavel.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                lblpackagename.setText(rs.getString("packageName"));
                lblduration.setText(rs.getString("duration"));
                // tflocation.setText(rs.getString("location"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        cPackageLavel.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    ConnectionClass c = new ConnectionClass();
                    String query = "select * from packagedetails where  packagelavel= '"+cPackageLavel.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        lblpackagename.setText(rs.getString("packageName"));
                        lblduration.setText(rs.getString("duration"));
                        tflocation.setText(rs.getString("location"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        Update = new JButton("Update");
        Update.setBounds(80, 300, 100,30);
        Update.setBackground(Color.BLACK);
        Update.setForeground(Color.WHITE);
        Update.addActionListener(this);
        add(Update);
        
        back = new JButton("Back");
        back.setBounds(220, 300, 100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Incentive_Calculation/p1/AddPackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, -20, 600, 400);
        add(image);
        
        setSize(1000, 400);
        setLocation(300, 150);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        
    }
 @Override
      public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Update) {
            String packagename=lblpackagename.getText();
            String duration=lblduration.getText();
            String location=tflocation.getText();
            try {
                ConnectionClass c = new ConnectionClass();
//                String query = "select * from packagedetails where packagelavel = '"+cPackageLavel.getSelectedItem()+"'";
//                ResultSet rs = c.s.executeQuery(query);
//                String lpackageName = "";
//                while(rs.next()) {
//                    lpackageName = rs.getString("packageName");
//                }
                 String selected=cPackageLavel.getSelectedItem();
                 System.out.println(selected);
                 String query = "update packagedetails set packagelavel = '"+selected+"',packageName = '"+packagename+"',duration='"+duration+"',location='"+location+"' where packagelavel = '"+selected+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Package details Upadated Sucessfully");

               
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new AdminHomePage();
        } 
    }
//    public static void main(String[] args)
//    {
//       new AddPackage(); 
//    }
}
