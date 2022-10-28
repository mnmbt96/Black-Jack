public class App {
    public static void main(String[] args) throws Exception {
        BlackJack.start();
    }
}

/*    TEST CASE   */ 
/* 1. If the player gets Black Jack  =>  No hit and stand option. Call dealer's method directory.
 * 2. If the dealer gets Black Jack
 * 3. If both get Black Jack
 * 4. If the player's total reaches more than or equals to 21  =>  No hit and stand option. Call dealer's method directory.
 * 5. While the player's total is less than 21  =>  you can hit until you choose stand.
 * 6. If the player gets black jack and the dealer also gets 21 but not black jack  =>  Player wins 
 * 7. If the dealer gets black jack and the player also gets 21 but not black jack  =>  Dealer wins
 * 8. If you enter a string to hit and stand option  =>  Catch exeption. You can try again.
 * 9. If you enter a number but it is not 1 or 2 => Default. You can try again.
 */