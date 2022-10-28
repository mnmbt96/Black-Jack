public class Result {

  private int playerResult;
  private int dealerResult;
  private boolean pFlag;
  private boolean dFlag;

  public Result(){
    playerResult = 0;
    dealerResult = 0;
  }

  public Result(int playerResult, int dealerResult, boolean pFlag, boolean dFlag){
    this.playerResult = playerResult;
    this.dealerResult = dealerResult;
    this.pFlag = pFlag;
    this.dFlag = dFlag;
  }

  public boolean ispFlag() {
    return pFlag;
  }

  public void setpFlag(boolean pFlag) {
    this.pFlag = pFlag;
  }

  public boolean isdFlag() {
    return dFlag;
  }

  public void setdFlag(boolean dFlag) {
    this.dFlag = dFlag;
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

  public void compareResults() throws InterruptedException{

    //Both the player and the dealer get Black Jack
    if(this.pFlag == true && this.dFlag == true){
      Thread.sleep(2000);
      System.out.println("👯Even👯 ");
    //Player: Black Jack      Dealer: NOT Black Jack
    }else if(this.pFlag == true && this.dFlag == false){
      Thread.sleep(2000);
      System.out.println("🎉Congratulations🎉");
    //Player: NOT Black Jack      Dealer: Black Jack
    }else if(this.pFlag == false && this.dFlag == true){
      Thread.sleep(2000);
      System.out.println("😭You lost😭");
    }else if(this.playerResult==21 && this.dealerResult ==21 && pFlag == false && dFlag == false){
      Thread.sleep(2000);
      System.out.println("👯Even👯 ");
    }else if(this.playerResult == 21 && this.dealerResult != 21){
      Thread.sleep(2000);
      System.out.println("🎉Congratulations🎉");
    }else if(this.playerResult != 21 && this.dealerResult == 21){
      Thread.sleep(2000);
      System.out.println("😭You lost😭");
    }else if(this.playerResult>21 && this.dealerResult>21){
      Thread.sleep(2000);
      System.out.println("😵Both Bust😵");
    }else if(this.playerResult<21 && this.dealerResult>21){
      Thread.sleep(2000);
      System.out.println("🎉Congratulations🎉");
    }else if(this.playerResult>21 && this.dealerResult<21){
      Thread.sleep(2000);
      System.out.println("😵Bust😵 You lost...");
    }else if(this.playerResult<21 && this.dealerResult<21){
      if((21 - this.playerResult)<(21 - this.dealerResult)){
        Thread.sleep(2000);
        System.out.println("🎉Congratulations🎉");
      }else if(this.playerResult == this.dealerResult){
        Thread.sleep(2000);
        System.out.println("😧Even😧");
      }else{
        Thread.sleep(2000);
        System.out.println("😭You lost😭");
      }
    }
    
    //Display Total
    BlackJack blackJack = new BlackJack();
    Thread.sleep(2000);
    System.out.println("....................");
    System.out.println(blackJack.getName() + "'s Total is " + this.playerResult);
    System.out.println("Kubilay's Total is " + this.dealerResult);
    System.out.println("....................");
  }
}