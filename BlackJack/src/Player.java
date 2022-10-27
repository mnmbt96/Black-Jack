import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Player{
   //Field
   private int playersTotal;

   // dealer varialbe type is Dealer 
   private Dealer dealer;

   //Constructor
   Player(int playersTotal){
     this.playersTotal = playersTotal;
     this.dealer = new Dealer(0);
   }

   //Getter & Setter
	 public int getPlayersTotal() {
		return this.playersTotal;
	 }

	 public void setPlayersTotal(int playersTotal) {
		this.playersTotal = playersTotal;
	 }
 
   public Dealer getDealer() {
      return dealer;
   }

   public void setDealer(Dealer dealer) {
      this.dealer = dealer;
   }

   //Method
   public void GameStart(){
    BlackJack blackJack = new BlackJack();

    ArrayList<String> list = new ArrayList<>(2);
    ArrayList<Integer> sumList = new ArrayList<>(2);

    for(int i = 0; i < 2; i++){
      Random rand = new Random();
      int n = rand.nextInt(13)+1;
       
      Card card = new Card();

      playersTotal = Integer.parseInt(card.deal(n,1));
      list.add(card.deal(n,2));
      sumList.add(playersTotal);
    }
  
    if(sumList.get(0)==10 && sumList.get(1) == 1){
      playersTotal = 21;
      System.out.println("Dealer deals two cards: " + list.get(0) + " & " + list.get(1));
      System.out.println("🎉🃏Black Jack🃏🎉");
      System.out.println(blackJack.getName()+ "'s total: " + playersTotal);
      dealer.DealersTurn();
    }else if(sumList.get(0) == 1 && sumList.get(1)==10){
      playersTotal = 21;
      System.out.println("Dealer deals two cards: " + list.get(0) + " & " + list.get(1));
      System.out.println("🎉🃏Black Jack🃏🎉");
      System.out.println(blackJack.getName()+ "'s total: " + playersTotal);
      dealer.DealersTurn();
    }else{

      playersTotal = sumList.get(0) + sumList.get(1);
      System.out.println("Dealer deals two cards: " + list.get(0) + " & " + list.get(1));
      System.out.println(blackJack.getName()+ "'s total: " + playersTotal);

      int option = 0;

    do{
    System.out.println("==============");
    System.out.println("=  1. Hit    =");
    System.out.println("=  2. Stand  =");
    System.out.println("==============");

    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter an option: ");

      try{
       option = scanner.nextInt();
      }catch(InputMismatchException e){
        scanner.next();
        System.out.println("It should be a number.");
        System.out.println("Enter an option again: ");
      }catch(Exception e){
        scanner.next();
        System.out.println("Something went wrong.");
        System.out.print("Enter number again: ");
      }

    switch (option) {
      case 1:
        Random rand2 = new Random();
        int n2 = rand2.nextInt(13) + 1;

        Card card = new Card();
        list.add(card.deal(n2, 2));

        playersTotal += Integer.parseInt(card.deal(n2, 1));
        System.out.println("=======================");
        System.out.println("Dealer deals: " + list.get(list.size()-1));
        System.out.println(blackJack.getName() + "'s total: " + playersTotal);
        System.out.println();

        break;
      case 2:
        dealer.DealersTurn();
        scanner.close();
        break;
      // default:
      // System.out.println("Invalid option! Please enter an option again.");
      // break;
    }
  }while(option != 2);
 }
 }
}
