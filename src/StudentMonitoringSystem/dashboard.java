package StudentMonitoringSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class dashboard extends JFrame implements ActionListener {
    JMenuBar mb;
    JButton prim, sec, highsec, logout;


    dashboard() {
        setSize(700, 500);

        mb = new JMenuBar();
        mb.setBounds(0, 0, 150, 500);
        mb.setBackground(Color.getColor("gray", 40));
        mb.setLayout(new GridLayout(5, 1, 0, 20));

        prim = new JButton("Primary");
        prim.addActionListener(this );
        mb.add(prim);

        sec = new JButton("Secondary");
       sec.addActionListener(this );
        mb.add(sec);

        highsec = new JButton("Higher Secondary");
        highsec.addActionListener(this );
        mb.add(highsec);

        logout = new JButton("Log Out ");
        logout.addActionListener(this );
        mb.add(logout);

        add(mb);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/WhatsApp Image 2022-09-26 at 12.42.49 AM.jpeg"));
        Image i3  = i1.getImage().getScaledInstance(700,500,Image.SCALE_SMOOTH);
        ImageIcon i4 = new ImageIcon(i3);
        JLabel i2 = new JLabel(i4);
        i2.setBounds(0,0,700,500);
        add(i2);


        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() ==prim) {
             new Main();
        }
        if (ae.getSource() ==sec) {
            new Main();
        }
        if (ae.getSource() ==highsec) {
            new Main();
        }
        if (ae.getSource() ==logout) {
        setVisible(false);
        }

    }
    public static void main (String[]args)
    {
        new dashboard();
    }
}

