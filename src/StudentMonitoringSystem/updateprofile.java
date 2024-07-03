package StudentMonitoringSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class updateprofile extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4;
    JTextField gr , data;
    JButton disp , submit , next ;
    JComboBox fields;
     JTable t1 ;
     JScrollPane sp1;
     String [] list = {"name" , "address" , "aadhar" ," contact" , "gender"};
    updateprofile()
    {
        setSize(900 , 600);


         l1 = new JLabel("GR.Number");
         l1.setBounds(80 , 40 , 150 , 50);
         add(l1);

         gr = new JTextField();
         gr.setBounds(250 , 40 , 150 , 40);
         add(gr);

         disp = new JButton("Display");
         disp.setBounds(450 , 40 , 100 , 40);
         disp.addActionListener(this);
         add(disp);

         sp1 = new JScrollPane();
         sp1.setBounds(50 , 170 , 770 , 60);
         add(sp1);

         t1 = new JTable();
         sp1.setViewportView(t1);

        l2 = new JLabel("Choose Field");
        l2.setBounds( 80, 300 , 150 , 50);
        add(l2);

        fields=new JComboBox(list);
        fields.setBounds(300 , 300 , 150 , 40);
        add(fields);

        l3 = new JLabel("Updated value");
        l3.setBounds( 80, 380 , 150 , 50);
        add(l3);

        data = new JTextField();
        data.setBounds(300 , 380 , 150 , 40);
        add(data);

        submit = new JButton("Update Data");
        submit.setBounds(400 , 450 , 180 , 40);
        submit.addActionListener(this);
        add(submit);

        next = new JButton("Next");
        next.setBounds(700 , 450 , 180 , 40);
        next.addActionListener(this);
        add(next);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/ranger-4df6c1b6.png"));
        Image i3  = i1.getImage().getScaledInstance(900,600,Image.SCALE_SMOOTH);
        ImageIcon i4 = new ImageIcon(i3);
        JLabel i2 = new JLabel(i4);
        i2.setBounds(0,0,900,600);
        add(i2);




        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==disp)
        {
            String gr = this.gr.getText();
            conn c = new conn();
            try
            {
                String str = "select name, age , address , dob ,aadhar , contact , gender  from stud_details where gr = '"+gr+"';";
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e)
            {
                System.out.println(e);
            }
        }
        if(ae.getSource()==submit)
        {
            String gr = this.gr.getText();
            String value = this.data.getText();
            String choice = fields.getSelectedItem().toString();


            conn c= new conn();
            try
            {
              String str = "update  stud_details set"+choice+" = '"+value+"' where gr = '"+gr+"';";
              c.s.executeUpdate(str);
              JOptionPane.showMessageDialog(null , "Data Updated Successfully ");
            }catch(Exception e)
            {
                System.out.println(e);
            }
        }
        if(ae.getSource()==next)
        {
            new dashboard();
        }
    }
    public static void main(String[] args)
    {
        new updateprofile();

    }
}

