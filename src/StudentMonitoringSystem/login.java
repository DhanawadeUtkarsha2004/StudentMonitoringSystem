package StudentMonitoringSystem;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {
    JLabel l1,l2;
    JTextField username ;
    JButton signIn, cancel;
    JPasswordField password;
    Font f1 = new Font("Tahoma", Font.PLAIN, 16);
    login(){
        setSize(500,300);

        l1 = new JLabel("Username");
        l1.setBounds(40,50,100,40);
        l1.setForeground(Color.WHITE);
        l1.setFont(f1);
        add(l1);

        l2 = new JLabel("Password");
        l2.setBounds(40,120,100,40);
        l2.setForeground(Color.WHITE);
        l2.setFont(f1);
        add(l2);

        username = new JTextField();
        username.setBounds(150,50,150,40);
        add(username);

        password = new JPasswordField();
        password.setBounds(150,120,150,40);
        add(password);

        signIn = new JButton("SignIn");
        signIn.setBounds(100,200,120,50);
        signIn.setFont(f1);
        signIn.addActionListener(this);
        add(signIn);

        cancel = new JButton("Cancel");
        cancel.setBounds(250,200,120,50);
        cancel.setFont(f1);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/WhatsApp Image 2022-09-26 at 12.42.49 AM.jpeg"));
        JLabel i3 = new JLabel(i1);
        i3.setBounds(0,0,500,300);
        add(i3);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==signIn)
        {
            String username = this.username.getText();
            String password = String.valueOf(this.password.getPassword());
            conn c = new conn();

            try
            {
                String str1 = "select * from login where username = '"+username+"'  and password = '"+password+"'; ";
                ResultSet rs = c.s.executeQuery(str1);
                if(rs.next())
                {
                    JOptionPane.showMessageDialog(null,"Login Successfull!!");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Invalid Login Credentials");
                }

            }
            catch(Exception e)
            {
                System.out.println(e);

            }
        }
        if(ae.getSource()==cancel)
        {
            System.exit(0);
        }
        if(ae.getSource()==signIn)
        {
           new addDetails();
        }
    }


    public static void main(String[] args)
    {
        new login();
    }
}
