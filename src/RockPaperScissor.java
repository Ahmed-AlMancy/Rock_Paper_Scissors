import java.util.Random;

//Back-End
public class RockPaperScissor {
    //all the choices that a computer can choose
    private static final String[] computerChoices={"Rock","Paper","Scissors"};
    //store the computer choice, so we can retrieve the value and display it
    private String computerChoice;
    //store the result so that we can retrieve the values and display it to the front end
    private int computerScore,playerScore;

    //use to generate a random number to choose an option for the computer
    private Random random;
    public  RockPaperScissor(){
        random=new Random();

    }

    //call this the method to begin playing rock paper scissor
    //playerChoice is the choice made by the player
    //this method will return th==e result of the game(Bot wins, player wins, draw)
    public String playRockPaperScissor(String playerChoice){
        //generate the computer choice
        computerChoice=computerChoices[random.nextInt(computerChoices.length)];
        //will contain the returning message  the result of the game
        String result =null;
        //evaluate the winner
        if(computerChoice.equals("Rock")){
            if(playerChoice.equals("Paper")){
                result="Player wins";
                playerScore++;

            }else if(playerChoice.equals("Scissors")){
                result="Computer wins";
                computerScore++;

            }else{
                result="Draw";
            }
        }
        else if(computerChoice.equals("Paper")){
            if(playerChoice.equals("Scissors")){
                result="Player wins";
                playerScore++;

            }else if(playerChoice.equals("Rock")){
                result="Computer wins";
                computerScore++;

            }else{
                result="Draw";
            }
        }
        else if(computerChoice.equals("Scissors")){
            if(playerChoice.equals("Rock")){
                result="Player wins";
                playerScore++;

            }else if(playerChoice.equals("Paper")){
                result="Computer wins";
                computerScore++;

            }else{
                result="Draw";
            }
        }
        return result;

    }

    public String getComputerChoice() {
        return computerChoice;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public int getPlayerScore() {
        return playerScore;
    }

}
