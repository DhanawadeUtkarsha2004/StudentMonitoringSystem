package StudentMonitoringSystem;

import java.sql.*;

public class conn
{
    Connection c ;
    public Statement s ;
   public conn()
   {
       String url = "jdbc:mysql://localhost:3306/studmonsys";
       String username = "root";
       String password = "U##tk@15";

       try
       {
           c = DriverManager.getConnection(url,username,password);
           s = c.createStatement();
       }
       catch (Exception e )
       {
           System.out.println(e);
       }
   }

    public static void main(String[] args)
    {
        new conn();
    }
}
