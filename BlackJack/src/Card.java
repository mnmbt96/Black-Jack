import java.util.ArrayList;
import java.util.Random;

public class Card{
  //define fields
  // private int card;

  // public Card(){
  //   this.card = 0;
  // }

  // public Card(int card){
  //   this.card = card;
  // }

  // public int getCard() {
  //   return card;
  // }

  // public void setCard(int card) {
  //   this.card = card;
  // }


  public String deal(int n,int n2 ){

    String[][] cardList = {
      {"1","1","A"}, 
      {"2","2","2"},
      {"3","3","3"}, 
      {"4","4","4"},
      {"5","5","5"},
      {"6","6","6"}, 
      {"7","7","7"},
      {"8","8","8"},
      {"9","9","9"},
      {"10","10","10"},
      {"11","10","J"},
      {"12","10","Q"},
      {"13","10","K"}
    };
    return cardList[n-1][n2];
    
  }
}
