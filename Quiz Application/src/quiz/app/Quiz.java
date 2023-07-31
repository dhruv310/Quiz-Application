package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame implements ActionListener {
    String name;
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String userAnswer[][] = new String[10][1];

    public static int timer =15;
    public static int ans_given=0;
    public static int count=0;
    public static int score =0;


    JRadioButton option1 ,option2,option3,option4;
    JLabel question_number,  question;
    ButtonGroup bg;
    JButton next , submit , help;
    Quiz(String name)
    {
        super("Quiz");
        this.name =name;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1440,390);
        add(image);

        question_number = new JLabel();
        question_number.setBounds(100,450,50,30);
        question_number.setFont(new Font("Tahoma",Font.PLAIN,25));
        add(question_number);

        question = new JLabel();
        question.setBounds(150,450,900,30);
        question.setFont(new Font("Tahoma",Font.PLAIN,25));
        add(question);

        questions[0][0] = "Number of primitive data types in Java are.?";
        questions[0][1] = "6";
        questions[0][2] = "7";
        questions[0][3] = "8";
        questions[0][4] = "9";

        questions[1][0] = "What is the size of float and double in java.?";
        questions[1][1] = "32 and 64";
        questions[1][2] = "32 and 32";
        questions[1][3] = "64 and 64";
        questions[1][4] = "64 and 32";

        questions[2][0] = "Automatic type conversion is possible in which of the possible cases?";
        questions[2][1] = "Byte to int";
        questions[2][2] = "Int to Long";
        questions[2][3] = "Long to int";
        questions[2][4] = "Short to int";

        questions[3][0] = "When an array is passed to a method, what does the method receive?";
        questions[3][1] = "The reference of the array";
        questions[3][2] = "A copy of the array";
        questions[3][3] = "Length of the array";
        questions[3][4] = "Copy of first element";

        questions[4][0] = "Arrays in java are.?";
        questions[4][1] = "Object References";
        questions[4][2] = "Objects";
        questions[4][3] = "Primitive data type";
        questions[4][4] = "None";

        questions[5][0] = "When is the object created with new keyword?";
        questions[5][1] = "At rum time";
        questions[5][2] = "At compile time";
        questions[5][3] = "Depends on the code";
        questions[5][4] = "None";

        questions[6][0] = "Identify the corrected definition of a package.?";
        questions[6][1] = "A package is a collection of editing tools";
        questions[6][2] = "A package is a collection of Classes";
        questions[6][3] = "A package is a collection of Classes and interfaces";
        questions[6][4] = "A package is a collection of interfaces";

        questions[7][0] = "compareTo() returns";
        questions[7][1] = "True";
        questions[7][2] = "False";
        questions[7][3] = "An int value";
        questions[7][4] = "None";

        questions[8][0] = "To which of the following does the class string belong to.";
        questions[8][1] = "java.lang";
        questions[8][2] = "java.awt";
        questions[8][3] = "java.applet";
        questions[8][4] = "java.String";

        questions[9][0] = "Total constructor string class have.?";
        questions[9][1] = "3";
        questions[9][2] = "7";
        questions[9][3] = "13";
        questions[9][4] = "20";

        answers[0][1] = "8";
        answers[1][1] = "32 and 64";
        answers[2][1] = "Int to Long";
        answers[3][1] = "The reference of the array";
        answers[4][1] = "Objects";
        answers[5][1] = "At rum time";
        answers[6][1] = "A package is a collection of Classes and interfaces";
        answers[7][1] = "An int value";
        answers[8][1] = "java.lang";
        answers[9][1] = "13";

        option1 = new JRadioButton();
        option1.setBounds(170,520,700,30);
        option1.setBackground(Color.white);
        option1.setFont(new Font("Dialog",Font.PLAIN,20));
        add(option1);

        option2 = new JRadioButton();
        option2.setBounds(170,560,700,30);
        option2.setBackground(Color.white);
        option2.setFont(new Font("Dialog",Font.PLAIN,20));
        add(option2);

        option3 = new JRadioButton();
        option3.setBounds(170,600,700,30);
        option3.setBackground(Color.white);
        option3.setFont(new Font("Dialog",Font.PLAIN,20));
        add(option3);

        option4 = new JRadioButton();
        option4.setBounds(170,640,700,30);
        option4.setBackground(Color.white);
        option4.setFont(new Font("Dialog",Font.PLAIN,20));
        add(option4);

        bg = new ButtonGroup();
        bg.add(option1);
        bg.add(option2);
        bg.add(option3);
        bg.add(option4);

        next = new JButton("Next");
        next.setBounds(1150,600,200,30);
        next.setBackground(new Color(252, 250, 76));
        next.setForeground(Color.black);
        next.addActionListener(this);
        add(next);

        submit = new JButton("Submit");
        submit.setBounds(1150,650,200,30);
        submit.setBackground(new Color(255, 0, 66));
        submit.setForeground(Color.black);
        submit.addActionListener(this);
        add(submit);

        help = new JButton("Help");
        help.setBounds(1150,550,200,30);
        help.setBackground(new Color(91, 250, 0));
        help.setForeground(Color.black);
        help.addActionListener(this);
        add(help);


        start(count);



        setSize(1440,850);
        setLocation(50,0);
        getContentPane().setBackground(Color.CYAN);
        setLayout(null);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==next)
        {
            repaint();
            option1.setEnabled(true);
            option2.setEnabled(true);
            option3.setEnabled(true);
            option4.setEnabled(true);

            ans_given=1;
            if(bg.getSelection()==null)
            {
                userAnswer[count][0]="";
            }
            else{
                userAnswer[count][0]=bg.getSelection().getActionCommand();
            }
            if(count==8)
            {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count);

        }
        else if(e.getSource()==help)
        {
            if(count==2||count==4||count==6||count==8||count==9)
            {
                option2.setEnabled(false);
                option3.setEnabled(false);
            }
            else{
                option1.setEnabled(false);
                option4.setEnabled(false);

            }
            help.setEnabled(false);
        }
        else if (e.getSource()==submit)
        {
            ans_given=1;
            if(bg.getSelection()==null)
            {
                userAnswer[count][0]="";
            }
            else
            {
                userAnswer[count][0]=bg.getSelection().getActionCommand();
            }
            for(int i=0;i<userAnswer.length;i++)

            {
                if(userAnswer[i][0].equals(answers[i][1]))
                {
                    score+=10;
                }
                else {
                    score+=0;
                }
            }
            setVisible(false);
            new Score(name ,score);
        }
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        String time = "Time Left - "+ timer + "Seconds";
        g.setColor(Color.red);
        g.setFont(new Font("Tahoma",Font.BOLD,25));
        if(timer>0)
        {
            g.drawString(time,1100,500);
        }
        else
        {
            g.drawString("Times Up " ,1100,500);
        }
        timer--;
        try
        {
            Thread.sleep(1000);
            repaint();
        }
        catch(Exception e)
        {
            e.getStackTrace();
        }
        if(ans_given==1)
        {
            ans_given=0;
            timer=15;
        }
        else if(timer<0)
        {
            timer=15;
            option1.setEnabled(true);
            option2.setEnabled(true);
            option3.setEnabled(true);
            option4.setEnabled(true);


            if(count==8)
            {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if(count==9)
            {
                if(bg.getSelection()==null)
                {
                    userAnswer[count][0]="";
                }
                else
                {
                    userAnswer[count][0]=bg.getSelection().getActionCommand();
                }
                for(int i=0;i<userAnswer.length;i++)
                {
                    if(userAnswer[i][0].equals(answers[i][1]))
                    {
                        score+=10;

                    }
                    else
                    {
                        score+=0;
                    }
                }

                setVisible(false);
                new Score(name,score);
            }
            else
            {
                if(bg.getSelection()==null)
                {
                    userAnswer[count][0]="";
                }
                else {
                    userAnswer[count][0]= bg.getSelection().getActionCommand();
                }
                count++;
                start(count);
            }

        }
    }
    public void start(int count)
    {
        question_number.setText(""+(count+1)+". ");
        question.setText(questions[count][0]);
        option1.setText(questions[count][1]);
        option1.setActionCommand(questions[count][1]);

        option2.setText(questions[count][2]);
        option2.setActionCommand(questions[count][2]);

        option3.setText(questions[count][3]);
        option3.setActionCommand(questions[count][3]);

        option4.setText(questions[count][4]);
        option4.setActionCommand(questions[count][4]);

        bg.clearSelection();


    }
    public static void main(String[] args)
    {
        new Quiz("User");
    }

}
