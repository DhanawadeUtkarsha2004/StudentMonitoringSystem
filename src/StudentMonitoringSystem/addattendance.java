package StudentMonitoringSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class addattendance extends JFrame implements ActionListener
{
    JLabel l1 , l2 ;
    JTextField gr , att ;
    JButton display , submit , next ;
    JScrollPane sp1;
    JTable t1;
    addattendance()
    {
        setSize(600,600);




        l1 =  new JLabel("GR NO");
        l1.setBounds(70 , 50 ,120 , 50 );
        add(l1);

        gr =  new JTextField();
        gr.setBounds(190 , 50 ,150 , 50 );
        add(gr);

        display =  new JButton("Display");
        display.setBounds(390 , 50 ,100 , 50 );
        display.addActionListener(this);
        add(display);

        sp1 = new JScrollPane();
        sp1.setBounds( 30,180 ,480 , 50 );
        add(sp1);

        t1 = new JTable();
        sp1.setViewportView(t1);

         l2 = new JLabel("Add / Update Record");
         l2.setBounds( 60, 330 , 130 , 50);
         add(l2);

         att = new JTextField();
         att.setBounds(250 , 330 , 100 , 50);
         add(att);

         submit = new JButton("Submit");
         submit.setBounds(  100,450 , 100 , 50);
         submit.addActionListener(this);
         add(submit);

        next = new JButton("Next");
        next.setBounds(  250,450 , 100 , 50);
        next.addActionListener(this);
        add(next);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/ranger-4df6c1b6.png"));
        Image i3  = i1.getImage().getScaledInstance(600,600,Image.SCALE_SMOOTH);
        ImageIcon i4 = new ImageIcon(i3);
        JLabel i2 = new JLabel(i4);
        i2.setBounds(0,0,600,600);
        add(i2);


        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if( ae.getSource() == display)
        {
            String gr = this.gr.getText();
            conn c = new conn();
            try
            {
                String str = "select name , gr , attendance from stud_details where gr ='"+gr+"';";
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        if(ae.getSource() == submit)
        {
            String gr = this.gr.getText();
            String attend = this.att.getText();
            conn c = new conn();
            try
            {
                String str1 = "Update stud_details set attendance = '"+attend+"' where gr = '"+gr+"' ;" ;
                c.s.executeUpdate(str1);
                JOptionPane.showMessageDialog(null , "Attendance record update successfully!!");
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
        if(ae.getSource() == next)
        {
            new marks();
        }
    }


    public static void main(String[] args)
    {
      new addattendance();
    }

}
