import java.util.*;
public class Player
{
    protected Card[] cardsInHand = new Card[25];   // this array holds the Card objects currently in the hand
    private int numCardsInHand = 0;
    private int playerNumber;
    private int numBooks;
    protected boolean[] books = new boolean[12];
    protected int nextPlayer = 0;
    int books2 = 0, books3 = 0, books4 = 0, books5 = 0, books6 = 0, books7 = 0, books8 = 0, books9 = 0, books10 = 0, books11 = 0, books12 = 0, books13 = 0, books14 = 0;
    int numRank2 = 0, numRank3 = 0, numRank4 = 0, numRank5 = 0, numRank6 = 0, numRank7 = 0, numRank8 = 0, numRank9 = 0, numRank10 = 0, numRank11 = 0, numRank12 = 0, numRank13 = 0, numRank14 = 0;
    
   public void test(){
       System.out.println("test");
    }
    
    public Player(int Player){
        this.playerNumber = Player;
        numBooks = 0;
        for(int i = 0; i < 12;i++){
            books[i] = false;
        }
    }
    
    public int getnumCardsInHand(){
        return numCardsInHand;
    }
    
    public int getnumplayerNumber(){
        return playerNumber;
    }
    
    public int getnumBooks(){
        return numBooks;
    }
    
    
    // tracks how many cards have been added to the hand so far

    // This method adds the specified Card object to the hand.  Takes no
    //  action if the hand is already full.
    public void addCard(Card c){   
        if (numCardsInHand < cardsInHand.length) {
            cardsInHand[numCardsInHand] = c;
            numCardsInHand++;  // we do this so that next time draw() is called, we get the next card
        } else {
            System.out.println("Hey, there are no more cards in this deck!");
        }
    }
    
    //player calls the method and it searches the other players p hand for the indicated 
    //if player p has the rank then it adds the card to the next index in the hand array
    public void transfercard(int rank, Player p){
        for(int i = 0; i < p.numCardsInHand; i++){
            if((p.cardsInHand[i].getRank()) == rank){
                cardsInHand[numCardsInHand+1] = p.cardsInHand[i];
            }
        }
    }
    
    public void removeCard(int index){
        //seaerches through the hand array and turn the index to null if in array
        for (int i = 0; i < cardsInHand.length;i++){
            
                 cardsInHand[index] = null;
                
     
        }
        // move all elements to the left
        for (int i = 0; i < cardsInHand.length;i++){
            if(cardsInHand[index] == null){
                 cardsInHand[index] = cardsInHand[index+1];
            }
        }
        numCardsInHand--;
    }
    
    public void findBooks(){
        int rank2 = 0, rank3 = 0, rank4 = 0, rank5 = 0, rank6 = 0, rank7 = 0, rank8 = 0, rank9 = 0, rank10 = 0, rank11 = 0, rank12 = 0, rank13 = 0, rank14 = 0;
        for (int i = 0; i < numCardsInHand; i++){
            if((cardsInHand[i].getRank()) == 2){
                rank2++;
                if(rank2 == 4){
                    books[0] = true;
                    numBooks++;
                    if(books[0] == true){books2 = 1;}else{books2 = 0;}
                }
            }else if((cardsInHand[i].getRank()) == 3){
                rank3++;
                if(rank3 == 4){
                    books[1] = true;
                    numBooks++;
                    if(books[0] == true){books3 = 1;}else{books3 = 0;}
                }
            }else if((cardsInHand[i].getRank()) == 4){
                rank4++;
                if(rank4 == 4){
                    books[2] = true;
                    numBooks++;
                    if(books[0] == true){books4 = 1;}else{books4 = 0;}
                }
            }else if((cardsInHand[i].getRank()) == 5){
                rank5++;
                if(rank5 == 4){
                    books[3] = true;
                    numBooks++;
                    if(books[0] == true){books5 = 1;}else{books5 = 0;}
                }
            }else if((cardsInHand[i].getRank()) == 6){
                rank6++;
                if(rank6 == 4){
                    books[4] = true;
                    numBooks++;
                    if(books[0] == true){books6 = 1;}else{books6 = 0;}
                }
            }else if((cardsInHand[i].getRank()) == 7){
                rank7++;
                if(rank7 == 4){
                    books[5] = true;
                    numBooks++;
                    if(books[0] == true){books7 = 1;}else{books7 = 0;}
                }
            }else if((cardsInHand[i].getRank()) == 8){
                rank8++;
                if(rank8 == 4){
                    books[6] = true;
                    numBooks++;
                    if(books[0] == true){books8 = 1;}else{books8 = 0;}
                }
            }else if((cardsInHand[i].getRank()) == 9){
                rank9++;
                if(rank9 == 4){
                    books[7] = true;
                    if(books[0] == true){books9 = 1;}else{books9 = 0;}
                }
            }else if((cardsInHand[i].getRank()) == 10){
                rank10++;
                if(rank10 == 4){
                    books[8] = true;
                    numBooks++;
                    if(books[0] == true){books10 = 1;}else{books10 = 0;}
                }
            }else if((cardsInHand[i].getRank()) == 11){
                rank11++;
                if(rank11 == 4){
                    books[9] = true;
                    numBooks++;
                    if(books[0] == true){books11 = 1;}else{books11 = 0;}
                }
            }else if((cardsInHand[i].getRank()) == 12){
                rank12++;
                if(rank12 == 4){
                    books[10] = true;
                    numBooks++;
                    if(books[0] == true){books12 = 1;}else{books12 = 0;}
                }
            }else if((cardsInHand[i].getRank()) == 13){
                rank13++;
                if(rank13 == 4){
                    books[11] = true;
                    numBooks++;
                    if(books[0] == true){books13 = 1;}else{books13 = 0;}
                }
            }else if((cardsInHand[i].getRank()) == 14){
                rank14++;
                if(rank14 == 4){
                    books[12] = true;
                    numBooks++;
                    if(books[0] == true){books14 = 1;}else{books14 = 0;}
                }
            }
        }
        for(int i = 0; i < books.length;i++){
            if(books[i] == true){
                System.out.println("You have a book of rank " + (i + 2));
            }
        }
    }
 
    public String toString()
    {
        String r = "";
        for (int i = 0; i < numCardsInHand; i++) {
            r += cardsInHand[i] + "\n";
        }
        return "BOOKs 0 == false and 1 == true" + "\n" +
                "__________________________________________________________________" + "\n"+
                            "|" + "       " + "|" + " 2 " + "|"+  " 3 "  + "|" + " 4 " + "|" + " 5 " + "|" + " 6 " + "|" 
                            + " 7 " + "|" + " 8 " + "|" + " 9 " + "|" + " 10 " + "|" + " 11 " + "|" + " 12 " + "|" + " 13 " + "|" + " 14 " + "|" +"\n" +
                            "-----------------------------------------------------------------" + "\n" +
                            "|" + " Books " + "|" + " " +  books2 + " " + "|"+  " " +  books3 + " "  + "|" + " " +  books4 + " " + "|" + " " +  books5 + " " + "|" + " " +  books6 + " " + "|" 
                            + " " +  books7 + " " + "|" + " " +  books8 + " " + "|" + " " +  books9 + " " + "|" + " " +  books10 + " " + "|" + " " +  books11 + " " + "|" + " " +  books12 + " " + "|" + " " +  books13 + " " + "|" + " " +  books14 + " "+ "|" +"\n" +
                            "|________________________________________________________________|" + "\n" + "\n" +
                            "Cards in Hand" + "\n"  + "-------------" + "\n" + r;
    }
    
    
    public static void main(String[] args){
        Player P = new Player(0);
        Player P1 = new Player(1);
        Deck d = new Deck();
        d.shuffle();
        for(int i = 0; i < 1;i++){
            for(int j = 0; j < 5;j++){
                P.addCard(d.draw());
                P1.addCard(d.draw());
            }
        } 
        
        System.out.println("palyer one");
        System.out.println(P);
        System.out.println("palyer two");
        System.out.println(P1);
         
        P.transfercard(0, P1);
        
        System.out.println("palyer one");
        System.out.println(P);
        System.out.println("palyer two");
        System.out.println(P1);
    }
}
