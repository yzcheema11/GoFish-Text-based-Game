import java.util.*;
public class GoFish
{
    private Player[] numPlayers;
    private GoFish[] game;
    int playerName;
    int requestedcard;
    Player requestedPlayer;
    Player previousPlayer;
    Card matchingRanks;
    private int suit;
    private int rank;
    boolean endGame = true;
    int numPlayer;
    Deck d;
  
    
    public void numPlayers(){
        Scanner input = new Scanner(System.in);
        numPlayer = 0;
        while((numPlayer <= 1) || (numPlayer >= 7)){
            System.out.println("How many players want to play");
            numPlayer = input.nextInt();
        }
       
        
        numPlayers = new Player[numPlayer];
        
        for (int i = 0; i <  numPlayer; i++){
           
            System.out.println("Player Number(Player" + i + ")");
            playerName = input.nextInt();
            numPlayers[i] = new Player(playerName);
        }
        requestedPlayer = numPlayers[0];
    }
    
     public Player taketurn(Player P){
         System.out.println(P);
        //set up scanner
        Scanner input = new Scanner(System.in);
        //declare variables
        int player;
        int rank;
        int numMatches = 0;
        System.out.println("Player " + P.getnumplayerNumber() + " turn");
        //Player P ask what player cars it want to sk for
        player = 7;
        while(player >= numPlayer){
            System.out.println("what Player Do you want to ask");
            player = input.nextInt();
        }
        player = P.getnumplayerNumber();
        while(player == P.getnumplayerNumber()){
            System.out.println("what Player Do you want to ask");
            player = input.nextInt();
        }

       
        //data type of Player is set to the player that Play P requested
        requestedPlayer = numPlayers[player];
        //request card
        System.out.println("What rank do you want(2-10 = the corresponding number rank on the card, 11 = jack, 12 = queen, 13 = king, 14 = ace)");
        rank = input.nextInt();
        
   
        for(int i = 0; i < (requestedPlayer.getnumCardsInHand()); i++){
            if((requestedPlayer.cardsInHand[i].getRank()) == rank){
                // if requested rank == to the player that was aksed for the card
                //the card will be transfered and removed from hand
                requestedPlayer.cardsInHand[i].test1();
                System.out.println("Card of rank " + rank + " are being transfered");
                //requestedPlayer.cardsInHand[i].test();
                for(int j = 0; j < (requestedPlayer.getnumCardsInHand()); j++){
                    P.transfercard(i, requestedPlayer);
                    requestedPlayer.removeCard(i);
                }
                
                
                P.findBooks();
                return P;
            }else{
                //place draw in paremters
                System.out.println("Go Fish");
                P.addCard(d.draw());
                //-1
                if((P.cardsInHand[P.getnumCardsInHand()-1].getRank()) == rank){
                    return P;
                }else{
                    System.out.println("Requested Players turn");
                    return requestedPlayer;
                }
            }
        }  
        return requestedPlayer;
    }
    
    public void getWinner(){
        int winner = 0;
        for(int i = 0; i < numPlayers.length-1; i++){
            if((numPlayers[i].getnumBooks()) > numPlayers[i+1].getnumBooks()){
                winner = (numPlayers[i].getnumBooks());
                System.out.println("Player " + winner +" won");
            }
        }
    }
    
    public void startGame(){
        numPlayers();
        d = new Deck();
        d.shuffle();
        for(int i = 0; i < numPlayers.length;i++){
            for(int j = 0; j < 5;j++){
                numPlayers[i].addCard(d.draw());
            }
        } 
       Player currentPlayer = numPlayers[0];;
        while(endGame){
            //the index of 0 request card first
             currentPlayer = taketurn(currentPlayer);
            
            if(d.gettopCard() == 52){
                (new GoFish()).getWinner();
                 break;
            }
            
            for(int i = 0; i < numPlayers.length; i++){
                if((numPlayers[i].getnumCardsInHand()) == 0){
                    endGame = false;
                    
                }
            }
             
        }
            
    }
    
    
    public static void main(String[] args){
        (new GoFish()).startGame();
    }
}
