import java.util.ArrayList;
import java.util.Random;


public class Dealer {

  Result result = new Result();

  private int dealersTotal;
  private boolean dFlag;

  Dealer(int dealersTotal){
    this.dealersTotal = dealersTotal;
  }

  Dealer(boolean dFlag){
    this.dFlag = false;
  }

  Dealer(){};

	public boolean isdFlag() {
    return dFlag;
  }

  public void setdFlag(boolean dFlag) {
    this.dFlag = dFlag;
  }

  public int getDealersTotal() {
		return this.dealersTotal;
	}

	public void setDealersTotal(int dealersTotal) {
		this.dealersTotal = dealersTotal;
	}

  Card card = new Card();

  public void DealersTurn() throws InterruptedException{
    ArrayList<String> list = new ArrayList<>(2); //Random number between 1 and 13
    ArrayList<Integer> sumList = new ArrayList<>(2); //Sum number

    /*     Test1: Random Number    */
    //Get 2 random numbers
    for(int i = 0; i < 2; i++){
      Random rand = new Random();
      int n = rand.nextInt(13)+1;

      dealersTotal = Integer.parseInt(card.deal(n, 1));
      list.add(card.deal(n, 2));
      sumList.add(dealersTotal);
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

    System.out.println();
    Thread.sleep(2000);
    System.out.print("Kubilay's Turn");
    Thread.sleep(500);
    System.out.print(".");
    Thread.sleep(500);
    System.out.print(".");
    Thread.sleep(500);
    System.out.print(".");
    Thread.sleep(500);
    System.out.println(".");

    dealersTotal = sumList.get(0) + sumList.get(1);

    //Blck Jack
    if(sumList.get(0)==10 && sumList.get(1) == 1 || sumList.get(0) == 1 && sumList.get(1)==10){
      dealersTotal = 21;
      dFlag = true;

      Thread.sleep(2000);
      System.out.println("🎉🃏Black Jack🃏🎉");
      Thread.sleep(2000);
      System.out.println("Kubilay's total: " + dealersTotal);
      System.out.println();

      //Not Black Jack
    }else{
      dFlag = false;
      Card card = new Card();

    /*      TEST 1 : Random Number on the second turn    */
    //Dealer has to get cards until the total reaches 17
    while(dealersTotal < 17){
      Random rand2 = new Random();
      int n2 = rand2.nextInt(13)+1;
      list.add(card.deal(n2, 2));
      dealersTotal += Integer.parseInt(card.deal(n2, 1));
    }

      /*     TEST 3 : Sum = 21 but not Black Jack on the second turn  */
      // list.add(card.deal(6, 2));
      // dealersTotal += 6;
    
    Thread.sleep(2000);
    System.out.println("Kubilay's Card: " + list);
    Thread.sleep(2000);
    System.out.println("Kubilay's Total: " + dealersTotal);
    System.out.println();
  }
}
}
