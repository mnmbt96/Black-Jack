import java.util.ArrayList;
import java.util.Random;


public class Dealer {

  Result result = new Result();

  private int dealersTotal;

  Dealer(int dealersTotal){
    this.dealersTotal = dealersTotal;
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
    ArrayList<Integer> sumList = new ArrayList<>(2); //Sum number between 1 and 10, A is 11

    //Get 2 random number
    for(int i = 0; i < 2; i++){
      Random rand = new Random();
      int n = rand.nextInt(13)+1;

      dealersTotal = Integer.parseInt(card.deal(n, 1));
      list.add(card.deal(n, 2));
      sumList.add(dealersTotal);
    }


    //TEST
    //Black Jack condition
    // list.add(card.deal(1, 2));
    // list.add(card.deal(11, 2));
    // sumList.add(1);
    // sumList.add(10);

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

    if(sumList.get(0)==10 && sumList.get(1) == 1){
      dealersTotal = 21;
      Thread.sleep(2000);
      System.out.println("🎉🃏Black Jack🃏🎉");
      Thread.sleep(2000);
      System.out.println("Kubilay's total: " + dealersTotal);
      System.out.println();
    }else if(sumList.get(0) == 1 && sumList.get(1)==10){
      dealersTotal = 21;
      Thread.sleep(2000);
      System.out.println("🎉🃏Black Jack🃏🎉");
      Thread.sleep(2000);
      System.out.println("Kubilay's total: " + dealersTotal);
      System.out.println();
    }else{
    // System.out.println("Dealer's card: " + list);

    while(dealersTotal < 17){
      Card card = new Card();
      Random rand2 = new Random();
      int n2 = rand2.nextInt(13)+1;
      list.add(card.deal(n2, 2));
      dealersTotal += Integer.parseInt(card.deal(n2, 1));
    }
    
    Thread.sleep(2000);
    System.out.println("Kubilay's card: " + list);
    Thread.sleep(2000);
    System.out.println("Kubilay's total: " + dealersTotal);
    System.out.println();
  }
}
}
