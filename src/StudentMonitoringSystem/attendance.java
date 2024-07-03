package StudentMonitoringSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class attendance extends JFrame implements ActionListener
{
    JButton add , defaulters , refresh , next ;
    JTable t1;
    JScrollPane sp1 ;

    attendance()
    {
        setSize(1000 ,500);


        sp1 = new JScrollPane();
        sp1.setBounds(550 , 80 , 300 , 300);
        this.add(sp1);


        t1 = new JTable();
        sp1.setViewportView(t1);
        displayOrignal();



        add = new JButton("Add/Update");
        add.setBounds(70 , 50 , 150 , 50);
        add.addActionListener(this);
        this.add(add);

        next = new JButton("Next");
        next.setBounds(70 , 300 , 150 , 50);
        next.addActionListener(this);
        this.add(next);


        defaulters = new JButton("Defaulters");
        defaulters.setBounds(70 , 150 , 150 , 50);
        defaulters.addActionListener(this);
        this.add(defaulters);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/WhatsApp Image 2022-10-01 at 11.41.25 PM.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        refresh = new JButton(i3);
        refresh.setBounds(800 , 390 , 40 , 40);
        refresh.addActionListener(this );
        add(refresh);





        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }




    void displayOrignal()
    {
        try
        {
            conn c = new conn();
            String str = "select gr , name , attendance from stud_details;";
            ResultSet rs = c.s.executeQuery(str);
            t1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e )
        {
            System.out.println(e);
        }
    }

   public void actionPerformed(ActionEvent ae)
   {
      if(ae.getSource() == defaulters)
      {
          conn c = new conn();
          try
          {
              String str = "select gr , name, attendance from stud_details where attendance  <50;";
              ResultSet rs = c.s.executeQuery(str);
              t1.setModel(DbUtils.resultSetToTableModel(rs));
          }catch (Exception e)
          {
              System.out.println(e);
          }

      }
      if(ae.getSource() == refresh)
      {
          displayOrignal();
      }
       if(ae.getSource() == add)
       {
           new addattendance();
       }
       if(ae.getSource() == next)
       {
           new updateprofile();
       }
   }

    public static void main(String[] args)
    {
        new attendance();

    }
}


