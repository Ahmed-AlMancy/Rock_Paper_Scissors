import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Front-End
public class GUI extends JFrame implements ActionListener{

    //Player buttons as GlobalVariables as we are adding listeners to the buttons
    JButton rockButton,paperButton,scissorButton;
    JLabel computerChoice;
    //Back-end obj
    RockPaperScissor rockPaperScissor;
    //will display the score to the computer and the player
    JLabel computerScoreLabel,playerScoreLabel;




    public GUI(){
        //Invoke JFrame constructor and add title to the GUI
        super("Rock Paper Scissor");
        //Set the size of the GUI
        setSize(450,574);
        //Set layout to null to disable the layout management, So we can use absolute positioning for the elements.
        setLayout(null);
        //Load GUI in the center of the screen every time we run the app
        setLocationRelativeTo(null);
        //initialize the backend obj
        rockPaperScissor=new RockPaperScissor();
        //terminate the JVM when closing the GUI
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //add GUI components
        addGuiComponents();

    }
    private void addGuiComponents(){
        //Create computer Score label
        computerScoreLabel=new JLabel("Computer: 0");
        //set x,y coordinates and width/height values
        computerScoreLabel.setBounds(0,43,450,30);
        //set the Font to have a font family of dialog,font-weight of BOLD,font size of 26;
        computerScoreLabel.setFont(new Font("Dialog",Font.BOLD,26));
        //place the text in the center
        computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //add to GUI
        add(computerScoreLabel);

        //create computer choice
        computerChoice=new JLabel("?");
        computerChoice.setBounds(175,118,98,81);
        computerChoice.setFont(new Font("Dialog",Font.PLAIN,18));
        computerChoice.setHorizontalAlignment(SwingConstants.CENTER);
        //create a black border around it
        computerChoice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(computerChoice);

        //create player score label
        playerScoreLabel=new JLabel("Player: 0");
        playerScoreLabel.setBounds(0,317,450,30);
        playerScoreLabel.setFont(new Font("Dialog",Font.BOLD,26));
        playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(playerScoreLabel);

        //player buttons

        //Rock button
        rockButton=new JButton("Rock");
        rockButton.setBounds(40,387,106,81);
        rockButton.setFont(new Font("Dialog",Font.PLAIN,18));
        rockButton.setFocusable(false);
        rockButton.addActionListener(this);
        add(rockButton);

        //Paper button
        paperButton=new JButton("Paper");
        paperButton.setBounds(165,387,106,81);
        paperButton.setFont(new Font("Dialog",Font.PLAIN,18));
        paperButton.setFocusable(false);
        paperButton.addActionListener(this);
        add(paperButton);

        //Scissor button
        scissorButton=new JButton("Scissors");
        scissorButton.setBounds(290,387,106,81);
        scissorButton.setFont(new Font("Dialog",Font.PLAIN,18));
        scissorButton.setFocusable(false);
        scissorButton.addActionListener(this);
        add(scissorButton);


    }
    //Displays a message dialog which will sow the winner and a try again button to play again
    private void showDialog(String message){
        JDialog resultDialog=new JDialog(this,"Result",true);
        resultDialog.setSize(227,124);
        resultDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        resultDialog.setResizable(false);
        //message label
        JLabel resultLabel=new JLabel(message);
        resultLabel.setFont(new Font("Dialog",Font.BOLD,18));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultDialog.add(resultLabel,BorderLayout.CENTER);

        //try again button
        JButton tryAgainButton=new JButton("Try Again");
        tryAgainButton.setFocusable(false);
        tryAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //reset computer choice
                computerChoice.setText("?");
                //close the dialog box
                resultDialog.dispose();

            }
        });
        resultDialog.add(tryAgainButton,BorderLayout.SOUTH);
        resultDialog.setLocationRelativeTo(this);
        resultDialog.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //get player choice
        String playerChoice =e.getActionCommand().toString();
        //play rock paper scissor and store the result into string variable
        String result=rockPaperScissor.playRockPaperScissor(playerChoice);
        //load computer choice
        computerChoice.setText(rockPaperScissor.getComputerChoice());
        //update score
        computerScoreLabel.setText("Computer: "+rockPaperScissor.getComputerScore());
        playerScoreLabel.setText("Player: "+rockPaperScissor.getPlayerScore());

        //display the result dialog
        showDialog(result);
    }
}
