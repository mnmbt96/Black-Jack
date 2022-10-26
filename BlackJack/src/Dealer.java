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


  public void DealersTurn(){
    ArrayList<String> list = new ArrayList<>(2);
    ArrayList<Integer> sumList = new ArrayList<>(2);

    for(int i = 0; i < 2; i++){
      Random rand = new Random();
      int n = rand.nextInt(13)+1;

      Card card = new Card();


      dealersTotal = Integer.parseInt(card.deal(n, 1));
      list.add(card.deal(n, 2));
      sumList.add(dealersTotal);
    }
    dealersTotal = sumList.get(0) + sumList.get(1);

    if(sumList.get(0)>=10 && sumList.get(1) == 1){
      System.out.println("Black Jack");
      result.compareResults();
    }else if(sumList.get(0) == 1 && sumList.get(1)>=10){
      System.out.println("Black Jack");
      result.compareResults();
    }

    // System.out.println("Dealer's card: " + list);

    while(dealersTotal < 17){
      Card card = new Card();
      Random rand2 = new Random();
      int n2 = rand2.nextInt(13)+1;
      list.add(card.deal(n2, 2));
      dealersTotal += Integer.parseInt(card.deal(n2, 1));
      System.out.println();
      System.out.println("Dealer is dealing cards...");
    }
    
    System.out.println("Dealer's card: " + list);
    System.out.println("Dealer's total: " + dealersTotal);
    System.out.println();
  }

}
