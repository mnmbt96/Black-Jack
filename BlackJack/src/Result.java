import java.io.ObjectInputStream.GetField;

public class Result {

  private int playerResult;
  private int dealerResult;

  public Result(){
    playerResult = 0;
    dealerResult = 0;
  }

  public Result(int playerResult, int dealerResult){
    this.playerResult = playerResult;
    this.dealerResult = dealerResult;
  }

  public int getPlayerResult() {
    return playerResult;
  }

  public void setPlayerResult(int playerResult) {
    this.playerResult = playerResult;
  }

  public int getDealerResult() {
    return dealerResult;
  }

  public void setDealerResult(int dealerResult) {
    this.dealerResult = dealerResult;
  }


  // method
  public void compareResults(){
    if(this.playerResult == 21){
      System.out.println("🎉Congratulations🎉");
    }else if(this.dealerResult == 21){
      System.out.println("😭You lost😭");
    }
    
    if(this.playerResult==21 && this.dealerResult ==21){
      System.out.println("👯Even👯 ");
    }else if(this.playerResult>21 && this.dealerResult>21){
      System.out.println("😵Burst😵");
    }else if(this.playerResult<21 && this.dealerResult>21){
      System.out.println("🎉Congratulations🎉");
    }else if(this.playerResult>21 && this.dealerResult<21){
      System.out.println("😵Burst😵 You lost...");
    }

    if(this.playerResult<21 && this.dealerResult<21){
      if((21 - this.playerResult)<(21 - this.dealerResult)){
        System.out.println("🎉Congratulations🎉");
      }else if(this.playerResult == this.dealerResult){
        System.out.println("😧Even😧");
      }else{
        System.out.println("😭You lost😭");
      }
    }
    
    //Total
    BlackJack blackJack = new BlackJack();
    System.out.println("....................");
    System.out.println(blackJack.getName() + "'s total is " + this.playerResult);
    System.out.println("Dealer's total is " + this.dealerResult);
    System.out.println("....................");
  }
  
}
