public class Card{
  public String deal(int n, int arrIndex){

    String[][] cardList = {

      //[][0] = Random card value
      //[][1] = Value for sum
      //[][2] = Value for display

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
    
    return cardList[n-1][arrIndex];
    
  }
}
