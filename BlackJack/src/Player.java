import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class Player{
   private int playersTotal;
   private boolean pFlag;

   // dealer varialbe type is Dealer 
   private Dealer dealer;

   Player(int playersTotal){
     this.playersTotal = playersTotal;
     this.dealer = new Dealer(0);
   }

   Player(boolean pFlag){
    this.pFlag = false;
    this.dealer = new Dealer(false);
   }

   Player(){};

	 public boolean ispFlag() {
    return pFlag;
  }

  public void setpFlag(boolean pFlag) {
    this.pFlag = pFlag;
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
   BlackJack blackJack = new BlackJack();

   public void GameStart() throws InterruptedException{

    ArrayList<String> list = new ArrayList<>(2); //List for card's value
    ArrayList<Integer> sumList = new ArrayList<>(2); //List for calculate value
 
    /*     Test1: Random Number    */
    //Get 2 random numbers
    for(int i = 0; i < 2; i++){
      Random rand = new Random();
      int n = rand.nextInt(13)+1; //Random number between 1 and 13

      //Pass n and index number to Card class 
      playersTotal = Integer.parseInt(card.deal(n,1)); 
      list.add(card.deal(n,2));
      sumList.add(playersTotal);
    }

    /*     TEST 2 : Black Jack     */
    // list.add(card.deal(1, 2));
    // list.add(card.deal(11, 2));
    // sumList.add(1);
    // sumList.add(10);


    /*     TEST 3 : Sum = 21 but not black jack    */
    // list.add(card.deal(10, 2));
    // list.add(card.deal(5, 2));
    // sumList.add(10);
    // sumList.add(5);


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
    if(sumList.get(0)==10 && sumList.get(1) == 1 || sumList.get(0) == 1 && sumList.get(1)==10){
      playersTotal = 21;
      pFlag = true;

      Thread.sleep(1500);
      System.out.print(blackJack.getName()+ "'s Cards: ");
      Thread.sleep(1500);
      System.out.println(list.get(0) + " & " + list.get(1));
      Thread.sleep(1500);
      System.out.println("🎉🃏Black Jack🃏🎉");
      Thread.sleep(1500);
      System.out.println(blackJack.getName()+ "'s Total: " + playersTotal);
      dealer.DealersTurn();

      //if not black jack
    }else{
      playersTotal = sumList.get(0) + sumList.get(1);
      pFlag = false;

      Thread.sleep(1500);
      System.out.print(blackJack.getName()+"'s Cards: " );
      Thread.sleep(1500);
      System.out.println(list.get(0) + " & " + list.get(1));
      Thread.sleep(1500);
      System.out.println(blackJack.getName()+ "'s Total: " + playersTotal);
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

    boolean loop = true;
    
    while(loop){
      try{
       option = scanner.nextInt();
       loop = false;

       //If the input is not a number
      }catch(InputMismatchException e){
        scanner.next();
        System.out.println("It should be a number.");
        System.out.print("Enter an option again: ");
      
      //Another exception
      }catch(Exception e){
        scanner.next();
        System.out.println("Something went wrong.");
        System.out.print("Enter number again: ");
      }
    }

    switch (option) {
      //Hit
      case 1:

      /*      TEST 1 : Random Number on the second turn    */
        Random rand2 = new Random();
        int n2 = rand2.nextInt(13) + 1;
        list.add(card.deal(n2, 2));
        playersTotal += Integer.parseInt(card.deal(n2, 1));

        /*    TEST 3 :  Sum = 21 but not black jack on the second turn    */
        // list.add(card.deal(6, 2));
        // playersTotal += 6;


        System.out.println();
        Thread.sleep(1000);
        System.out.print("Dealing Cards");
        Thread.sleep(500);
        System.out.print(".");
        Thread.sleep(500);
        System.out.print(".");

        System.out.println();
        Thread.sleep(1500);
        System.out.print(blackJack.getName()+ "'s Card: " );
        Thread.sleep(1500);
        System.out.println(list.get(list.size()-1));
        Thread.sleep(1500);
        System.out.println(blackJack.getName() + "'s Total: " + playersTotal);
        System.out.println();

        //If burst, go to the dealer's turn
        if(playersTotal>21){
          Thread.sleep(1500);
          System.out.println("😵Bust😵");
          dealer.DealersTurn();
        }
        break;

        //Stand
      case 2:
        dealer.DealersTurn();
        scanner.close();
        break;
      default:
      System.out.println("Invalid option! Please enter 1 or 2.");
      break;
    }
    //Loop while option is 1 and the playersTotal is less than 22
  }while(option != 2 && playersTotal< 22);
 }
 }
}
