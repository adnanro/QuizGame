    import java.awt.event.*;
    import java.awt.*;
    import javax.swing.*;
    import javax.swing.border.BevelBorder;


    public class Game implements ActionListener{

        String[] questions = {

                            "What is thought to be the first video game, created in 1958 and becoming popular in the 1970s?",
                            "What 1980s arcade game was inducted into the Guinness Book of Records as the \"Most Successful Coin-Operated Game\" in 2005?",
                            "What North Carolina-based video game company created the 2018 breakout hit \"Fortnite\"?",
                            "What 1996 video game kicked off a long-running film and game franchise and eleveated the \"horror\" genre of video games into the mainstream?",
                            "What 2018 video games is set in 1899 and follows the story of outlaws Arthur Morgan and John Marston? Both characters are members of the Van der Linde gang."

                            };


        String[][] options = {
                            
                            {"Pac-Man", "Pong", "Civil War", "Lego Dimensions"},
                            {"Donkey Kong", "SlimCity", "Pac-Man", "The Legend of Zelda"},
                            {"Epic Games", "Grover Gaming", "Sega", "Red Storm Entertainment"},
                            {"Quake", "Tomb Raider", "Dragon Force", "Resident Evil"},
                            {"Red Dead Redemption 2", "Monster Hunter: World", "Spider-Man", "Super Smash Bros. Ultimate"}

                            };

        char[] answers = {
                            
                        'B',
                        'C',
                        'A',
                        'D',
                        'A'

                        };

        
    char trying;
    char answer;
    int index;     
    int correctAnswers = 0;
    int numOfQuestions = questions.length;
    int result;
    int timer = 13;
    
    JFrame frame = new JFrame();
    JTextField textField = new JTextField();
    JTextArea textArea = new JTextArea();

    JButton button1 = new JButton();
    JButton button2 = new JButton();
    JButton button3 = new JButton();
    JButton button4 = new JButton();
    
    JLabel answer1 = new JLabel();
    JLabel answer2 = new JLabel();
    JLabel answer3 = new JLabel();
    JLabel answer4 = new JLabel();

    JLabel timerLabel = new JLabel();
    JLabel timeLeft = new JLabel();

    JTextField correctAns = new JTextField();
    JTextField correctAnsweredPercentage = new JTextField();

    Timer timerCountDown = new Timer(1000, new ActionListener() {
                    
        @Override
        public void actionPerformed(ActionEvent e) {

            timer--;
            timeLeft.setText(String.valueOf(timer));

            if(timer<=0) {
                showAnswer();
            }
            
    }

    });

        public Game() {

            //gui

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 550);
        frame.getContentPane().setBackground(new Color(0, 76, 153));
        frame.setLayout(null);
        frame.setResizable(false);

        textField.setBounds(0, 0, 995, 80);
        textField.setBackground(new Color(96, 96, 96));
        textField.setForeground(new Color(0,0,0));
        textField.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 40));
        textField.setBorder(BorderFactory.createBevelBorder(2));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);

        textArea.setBounds(10, 100, 965, 90);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(96, 96, 96));
        textArea.setForeground(new Color(0,0,0));
        textArea.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 23));
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setEditable(false);
        
        button1.setBounds(10, 210, 50, 50);
        button1.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 20));
        button1.setFocusable(false);
        button1.addActionListener(this);
        button1.setBackground(new Color(96,96,96));
        button1.setForeground(new Color(255,255,0));
        button1.setText("A");

        button2.setBounds(10, 290, 50, 50);
        button2.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 20));
        button2.setFocusable(false);
        button2.addActionListener(this);
        button2.setBackground(new Color(96,96,96));
        button2.setForeground(new Color(255,255,0));
        button2.setText("B");

        button3.setBounds(10, 370, 50, 50);
        button3.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 20));
        button3.setFocusable(false);
        button3.addActionListener(this);
        button3.setBackground(new Color(96,96,96));
        button3.setForeground(new Color(255,255,0));
        button3.setText("C");

        button4.setBounds(10, 450, 50, 50);
        button4.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 20));
        button4.setFocusable(false);
        button4.addActionListener(this);
        button4.setBackground(new Color(96,96,96));
        button4.setForeground(new Color(255,255,0));
        button4.setText("D");

        answer1.setBounds(90, 200, 1000, 70);
        answer1.setBackground(new Color(50, 50,50));
        answer1.setForeground(new Color(255,255,0));
        answer1.setFont(new Font("Arial", Font.BOLD, 27));

        answer2.setBounds(90, 280, 1000, 70);
        answer2.setBackground(new Color(50, 50,50));
        answer2.setForeground(new Color(255,255,0));
        answer2.setFont(new Font("Arial", Font.BOLD, 27));

        answer3.setBounds(90, 360, 1000, 70);
        answer3.setBackground(new Color(50, 50,50));
        answer3.setForeground(new Color(255,255,0));
        answer3.setFont(new Font("Arial", Font.BOLD, 27));

        answer4.setBounds(90, 440, 1000, 70);
        answer4.setBackground(new Color(50, 50,50));
        answer4.setForeground(new Color(255,255,0));
        answer4.setFont(new Font("Arial", Font.BOLD, 27));

        timeLeft.setBounds(875,300,60,60);
        timeLeft.setBackground(new Color(0,51,102));
        timeLeft.setForeground(new Color(255,0,0));
        timeLeft.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 40));
        timeLeft.setBorder(BorderFactory.createBevelBorder(2));
        timeLeft.setOpaque(true);
        timeLeft.setHorizontalAlignment(JTextField.CENTER);
        timeLeft.setText(String.valueOf(timer));

        correctAns.setBounds(400,225,200,100);
        correctAns.setBackground(new Color(0,0,0));
        correctAns.setForeground(new Color(0,255,0));
        correctAns.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 50));
        correctAns.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.gray));
        correctAns.setHorizontalAlignment(JTextField.CENTER);
        correctAns.setEditable(false);

        correctAnsweredPercentage.setBounds(400,325,200,100);
        correctAnsweredPercentage.setBackground(new Color(0,0,0));
        correctAnsweredPercentage.setForeground(new Color(0,255,0));
        correctAnsweredPercentage.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 50));
        correctAnsweredPercentage.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.gray));
        correctAnsweredPercentage.setHorizontalAlignment(JTextField.CENTER);
        correctAnsweredPercentage.setEditable(false);

        
        frame.add(timerLabel);
        frame.add(timeLeft);

        frame.add(answer1);
        frame.add(answer2);
        frame.add(answer3);
        frame.add(answer4);

        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        
        frame.add(textArea);
        frame.add(textField);
        frame.setVisible(true);
        nextQn();

        }

        public void nextQn() {

        if(index>=numOfQuestions) {
            showResults();
        } else {
            textField.setText("Question "+(index+1));
            textArea.setText(questions[index]);
            answer1.setText(options[index][0]);
            answer2.setText(options[index][1]);
            answer3.setText(options[index][2]);
            answer4.setText(options[index][3]);
            timerCountDown.start();

        }

        }

        private void result() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'result'");
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);

            if(e.getSource()==button1) {
                answer = 'A';
                if(answer == answers[index]) {
                    correctAnswers++;
                }
            }
            if(e.getSource()==button2) {
                answer = 'B';
                if(answer == answers[index]) {
                    correctAnswers++;
                }
            }
            if(e.getSource()==button3) {
                answer = 'C';
                if(answer == answers[index]) {
                    correctAnswers++;
                }
            }
            if(e.getSource()==button4) {
                answer = 'D';
                if(answer == answers[index]) {
                    correctAnswers++;
                }
            }
            showAnswer();
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
        }

        public void showAnswer() {

            timerCountDown.stop();

            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);
            
            if(answers[index] != 'A') 
                answer1.setForeground(new Color(255,0,0));
                if(answers[index] != 'B') 
                answer2.setForeground(new Color(255,0,0));
                if(answers[index] != 'C') 
                answer3.setForeground(new Color(255,0,0));
                if(answers[index] != 'D') 
                answer4.setForeground(new Color(255,0,0));
                
                Timer delay = new Timer(1500, new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        answer1.setForeground(new Color(255,255,0));
                        answer2.setForeground(new Color(255,255,0));
                        answer3.setForeground(new Color(255,255,0));
                        answer4.setForeground(new Color(255,255,0));

                
                answer = ' ';
                timer = 13;
                timeLeft.setText(String.valueOf(timer));
                button1.setEnabled(true);
                button2.setEnabled(true);
                button3.setEnabled(true);
                button4.setEnabled(true);
                index++;
                nextQn();

            }

        });

        delay.setRepeats(false);
                delay.start();
            
        }

        public void showResults() {

            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);

            result = (int)((correctAnswers/(double)numOfQuestions)*100);

            textField.setText("You have finished the quiz! Results:");
            textArea.setText("");
            answer1.setText("");
            answer2.setText("");
            answer3.setText("");
            answer4.setText("");

            correctAnsweredPercentage.setText(result+"%");
            correctAns.setText(correctAnswers+"/"+numOfQuestions);

            frame.add(correctAnsweredPercentage);
            frame.add(correctAns);


        }

    }
