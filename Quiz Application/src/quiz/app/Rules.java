package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rules extends JFrame implements ActionListener {
    JButton start , back;
    String name;
    Rules(String name)
    {
        super("Rules");
        this.name=name;

        JLabel heading  = new JLabel("Welcome"+ name +" To Quiz Test");
        heading.setFont(new Font("Raleway",Font.BOLD,30));
        heading.setBounds(150,100,700,30);
        heading.setForeground(new Color(20,100,55));
        add(heading);

        JLabel rules  = new JLabel();
        rules.setFont(new Font("Tahoma",Font.BOLD,15));
        rules.setBounds(70,150,700,350);
        rules.setText( "<html>"+
                "1. Participation in the quiz is free and open to all persons above 18 years old." + "<br><br>" +
                "2. There are a total 10 questions. " + "<br><br>" +
                "3. You only have 15 seconds to answer the question." + "<br><br>" +
                "4. No cell phones or other secondary devices in the room or test area." + "<br><br>" +
                "5. No talking." + "<br><br>" +
                "6. No one else can be in the room with you." + "<br><br>" +
                "<html>");
        rules.setForeground(new Color(20,100,55));
        add(rules);

        start =  new JButton("Start");
        start.setBounds(300,500,100,30);
        start.setBackground(new Color(20,100,55));
        start.setForeground(Color.white);
        start.addActionListener(this);
        add(start);

        back =  new JButton("Back");
        back.setBounds(450 ,500,100,30);
        back.setBackground(new Color(20,100,55));
        back.addActionListener(this);
        back.setForeground(Color.white);
        add(back);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/back.png"));
        Image i = i1.getImage().getScaledInstance(800,650,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i);
        JLabel image = new JLabel(i2);
        image.setBounds(0,0,800,650);
        add(image);

        setSize(800,650);
        setLocation(350,100);
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==start)
        {
            new Quiz(name);
            setVisible(false);
        }
        else if(e.getSource()==back)
        {


            new Login();
            setVisible(false);
        }
    }

    public static void main(String[] args)
    {
        new Rules("User");
    }


}
