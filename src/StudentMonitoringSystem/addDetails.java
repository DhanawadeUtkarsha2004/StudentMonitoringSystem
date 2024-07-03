package StudentMonitoringSystem;


import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class addDetails extends JFrame implements ActionListener
{
    JLabel l1, l2, l3, l4 ,l5 , l6, l7, l8;
    JTextField name, age, aadhar , gr , address , contact , gender;
    JButton submit , next;
    JRadioButton male, female;
    ButtonGroup b1;
    JDateChooser dob;
    //size variables
    int labX = 60;
    int labH = 50;
    int labW = 100;
    int txtX = 200;
    int txth = 40;
    int txtW = 150;
    addDetails(){
        setSize(500,800);

        l1 = new JLabel("Name");
        l1.setBounds(labX,40,labW,labH);
        add(l1);

        l2 = new JLabel("DOB");
        l2.setBounds(labX,100,labW,labH);
        add(l2);

        l3 = new JLabel("Age");
        l3.setBounds(labX,160,labW,labH);
        add(l3);

        l4 = new JLabel("Gender");
        l4.setBounds(labX,220,labW,labH);
        add(l4);

        l5 = new JLabel("Address");
        l5.setBounds(labX,280,labW,labH);
        add(l5);

        l6 = new JLabel("Aadhar");
        l6.setBounds(labX,340,labW,labH);
        add(l6);

        l7 = new JLabel("Contact");
        l7.setBounds(labX,400,labW,labH);
        add(l7);

        l8 = new JLabel("GR NO");
        l8.setBounds(labX,460,labW,labH);
        add(l8);

        //textfields
        name = new JTextField();
        name.setBounds(txtX,40,txtW,txth);
        this.add(name);

        dob = new JDateChooser();
        dob.setBounds(txtX, 100, txtW, txth);
        this.add(dob);

        age = new JTextField();
        age.setBounds(txtX,160,txtW,txth);
        this.add(age);

        address = new JTextField();
        address.setBounds(txtX,280,txtW,txth);
        this.add(address);

        aadhar = new JTextField();
        aadhar.setBounds(txtX,340,txtW,txth);
        this.add(aadhar);

        contact = new JTextField();
        contact.setBounds(txtX,400,txtW,txth);
        this.add(contact);

        gr = new JTextField();
        gr.setBounds(txtX,460,txtW,txth);
        this.add(gr);

        b1 = new ButtonGroup();

        male = new JRadioButton("Male");
        male.setBounds(txtX , 220 ,65 , txth);
        b1.add(male);
        this.add(male);

        female = new JRadioButton("Female");
        female.setBounds(300 , 220 ,95 , txth);
        b1.add(female);
        this.add(female);

        submit = new JButton("submit");
        submit.setBounds(100 , 540 , 100 ,40);
        submit.addActionListener(this);
        this.add(submit);

        next = new JButton("Next");
        next.setBounds(250 , 540 , 100 ,40);
        next.addActionListener(this);
        this.add(next);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/ranger-4df6c1b6.png"));
        Image i3  = i1.getImage().getScaledInstance(500,800,Image.SCALE_SMOOTH);
        ImageIcon i4 = new ImageIcon(i3);
        JLabel i2 = new JLabel(i4);
        i2.setBounds(0,0,500,800);
        add(i2);


        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

    }
     public void actionPerformed(ActionEvent ae)
     {
         if(ae.getSource() == submit)
         {
             String name = this.name.getText();
             String age = this.age.getText();
             String address = this.address.getText();
             String aadhar = this.aadhar.getText();
             String gr = this.gr.getText();
             String contact = this.contact.getText();
             SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
             String dob = dateFormat.format(this.dob.getDate());
             String gender = null;

             if(this.male.isSelected())
             {
                 gender = "Male";
             }
             else
             {
              gender = "Female";
             }

           conn c = new conn();

             String str = "insert into stud_details (name,dob,age,gender,address,aadhar,gr,contact) values( '"+name+"','"+dob+"','"+age+"','"+gender+"','"+address+"','"+aadhar+"','"+gr+"','"+contact+"');";

             try
             {
                 c.s.executeUpdate(str);
                 JOptionPane.showMessageDialog(null, "Data Added Successfully!!!");

                 this.name.setText(null);
                 this.contact.setText(null);
                 this.gr.setText(null);
                 this.address.setText(null);
                 this.age.setText(null);
                 this.aadhar.setText(null);

                 this.male.setSelected(false);
                 this.female.setSelected(false);

             }
             catch (Exception e)
             {
                 System.out.println(e);
             }
         }
         if(ae.getSource() == next)
         {
             new attendance();
         }
     }


    public static void main(String[] args)
    {
        new addDetails();
    }
}