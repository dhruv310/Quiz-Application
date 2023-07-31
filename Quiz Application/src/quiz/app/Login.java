package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login extends JFrame implements ActionListener
{
    JTextField text;
    JButton next , back;
    Login()
    {
        super("Login");
        getContentPane().setBackground(Color.CYAN);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i = i1.getImage().getScaledInstance(550,500,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i);
        JLabel image = new JLabel(i2);
        image.setBounds(450,0,550,500);
        add(image);

        JLabel header = new JLabel("Quiz Test");
        header.setBounds(140,60,300,45);
        header.setFont(new Font("Raleway" , Font.BOLD,40));
        header.setForeground(new Color(20,100,55));
        add(header);

        JLabel name = new JLabel("Enter Your Name");
        name.setBounds(160,150,300,20);
        name.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
        name.setForeground(new Color(20,100,55));
        add(name);

        text = new JTextField();
        text.setBounds(80,200,300,25);
        text.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(text);

        next = new JButton("Next");
        next.setBounds(100,270,120,25);
        next.setBackground(new Color(20, 100, 55));
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);

        back = new JButton("Back");
        back.setBounds(250,270,120,25);
        back.setBackground(new Color(20, 100, 55));
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);


        setSize(1000,500);
        setLocation(200,200);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==next)
        {
            String name=text.getText();
            setVisible(false);
            new Rules(name);
        }

        else if(e.getSource()==back)
        {
            System.exit(0);
        }
    }

    public static void main(String[] args)
    {
        new Login();
    }
}
