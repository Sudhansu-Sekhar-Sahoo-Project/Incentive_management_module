package Incentive_Calculation.p1;
import java.sql.*;



public class ConnectionClass 
{
    Connection c;
    Statement s;
    
    public ConnectionClass()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem","root","Ss@81147.");
            s=c.createStatement();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}


