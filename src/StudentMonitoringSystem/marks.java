package StudentMonitoringSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class marks extends JFrame implements ActionListener
{
    JScrollPane sp1 , sp2 ;
    JTabbedPane tabs ;
    JTable SEM1 , SEM2 ;
    JButton add , pf , next ;
    marks()
    {
        setSize(1000 , 500 );

        sp1 = new JScrollPane();
        sp2 = new JScrollPane();

        SEM1 = new JTable();
        sp1.setViewportView(SEM1);

        SEM2 = new JTable();
        sp2.setViewportView(SEM2);

        tabs = new JTabbedPane();
        tabs.setBounds(400 , 80 , 520 , 350);

       tabs.add("SEM1 " ,sp1);
       tabs.add("SEM2 ", sp2);

       add(tabs);

        conn c = new conn();

       try
       {
           String str1 = "select name , gr ,english , maths , science , tot1 from stud_details;";
           ResultSet rs = c.s.executeQuery(str1);
           SEM1.setModel(DbUtils.resultSetToTableModel(rs));

       }catch (Exception e)
       {
           System.out.println(e);
       }

        try
        {
            String str2 = "select name , gr ,history, geography, marathi, tot2 from stud_details;";
            ResultSet rs = c.s.executeQuery(str2);
            SEM2.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e)
        {
            System.out.println(e);
        }

          add = new JButton("Add/Update");
          add.setBounds(100 , 100 , 100 ,50);
          add.addActionListener(this );
          add(add);

        pf = new JButton("Pass/Failed");
        pf.setBounds(100 , 250 , 100 ,50);
       pf.addActionListener(this );
        add(pf);

        next = new JButton("Next");
        next.setBounds(100 , 350 , 100 ,50);
       next.addActionListener(this );
        add(next);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/ranger-4df6c1b6.png"));
        Image i3  = i1.getImage().getScaledInstance(1000,500,Image.SCALE_SMOOTH);
        ImageIcon i4 = new ImageIcon(i3);
        JLabel i2 = new JLabel(i4);
        i2.setBounds(0,0,1000,500);
        add(i2);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == next)
        {
            new updateprofile();
        }
    }


    public static void main(String[] args)
    {
         new marks();
    }
}
