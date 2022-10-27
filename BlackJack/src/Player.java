import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Player{
   private int playersTotal;

   // dealer varialbe type is Dealer 
   private Dealer dealer;

   Player(int playersTotal){
     this.playersTotal = playersTotal;
     this.dealer = new Dealer(0);
   }

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

   Card card = new Card();

   public void GameStart() throws InterruptedException{
    BlackJack blackJack = new BlackJack();

    ArrayList<String> list = new ArrayList<>(2);
    ArrayList<Integer> sumList = new ArrayList<>(2);

    for(int i = 0; i < 2; i++){
      Random rand = new Random();
      int n = rand.nextInt(13)+1;

      playersTotal = Integer.parseInt(card.deal(n,1));
      list.add(card.deal(n,2));
      sumList.add(playersTotal);
      
    }

    //TEST
    //Black Jack conditions
    // list.add(card.deal(1, 2));
    // list.add(card.deal(11, 2));
    // sumList.add(1);
    // sumList.add(10);

    Thread.sleep(1000);
    System.out.print("Dealing 2 Cards");
    Thread.sleep(500);
    System.out.print(".");
    Thread.sleep(500);
    System.out.print(".");
    Thread.sleep(500);
    System.out.print(".");
    Thread.sleep(500);
    System.out.println(".");
  
    //Black Jack
    if(sumList.get(0)==10 && sumList.get(1) == 1){
      playersTotal = 21;
      Thread.sleep(1500);
      System.out.print(blackJack.getName()+ "'s Cards: ");
      Thread.sleep(1500);
      System.out.println(list.get(0) + " & " + list.get(1));
      Thread.sleep(1500);
      System.out.println("🎉🃏Black Jack🃏🎉");
      Thread.sleep(1500);
      System.out.println(blackJack.getName()+ "'s total: " + playersTotal);
      dealer.DealersTurn();
    }else if(sumList.get(0) == 1 && sumList.get(1)==10){
      playersTotal = 21;
      Thread.sleep(1500);
      System.out.print(blackJack.getName()+ "'s Cards: " );
      Thread.sleep(1500);
      System.out.println(list.get(0) + " & " + list.get(1));
      Thread.sleep(1500);
      System.out.println("🎉🃏Black Jack🃏🎉");
      Thread.sleep(1500);
      System.out.println(blackJack.getName()+ "'s total: " + playersTotal);
      dealer.DealersTurn();

      //if not black jack
    }else{
      playersTotal = sumList.get(0) + sumList.get(1);

      Thread.sleep(1500);
      System.out.print(blackJack.getName()+"'s Cards: " );
      Thread.sleep(1500);
      System.out.println(list.get(0) + " & " + list.get(1));
      Thread.sleep(1500);
      System.out.println(blackJack.getName()+ "'s total: " + playersTotal);
      System.out.println();

      int option = 0;

    do{
      Thread.sleep(1500);
    System.out.println("==============");
    System.out.println("=  1. Hit    =");
    System.out.println("=  2. Stand  =");
    System.out.println("==============");

    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter an option: ");

      //If the input is not a number
      try{
       option = scanner.nextInt();
      }catch(InputMismatchException e){
        scanner.next();
        option = 3;
        // System.out.println("It should be a number.");
        // System.out.println("Enter an option again. ");
      }catch(Exception e){
        scanner.next();
        option =3;
        // System.out.println("Something went wrong.");
        // System.out.print("Enter number again. ");
      }

    switch (option) {
      //Hit
      case 1:
        Random rand2 = new Random();
        int n2 = rand2.nextInt(13) + 1;

        // Card card = new Card();
        list.add(card.deal(n2, 2));

        System.out.println();
        Thread.sleep(1000);
        System.out.print("Dealing Cards");
        Thread.sleep(500);
        System.out.print(".");
        Thread.sleep(500);
        System.out.print(".");

        playersTotal += Integer.parseInt(card.deal(n2, 1));
        System.out.println();
        Thread.sleep(1500);
        System.out.print(blackJack.getName()+ "'s Card: " );
        Thread.sleep(1500);
        System.out.println(list.get(list.size()-1));
        Thread.sleep(1500);
        System.out.println(blackJack.getName() + "'s total: " + playersTotal);
        System.out.println();

        if(playersTotal>21){
          Thread.sleep(1500);
          System.out.println("😵Burst😵");
          dealer.DealersTurn();
        }
        break;

        //Stand
      case 2:
        dealer.DealersTurn();
        scanner.close();
        break;
      default:
      System.out.println("Invalid option! Please enter an option again.");
      break;
    }
  }while(option != 2 && playersTotal< 22);
 }
 }
}
