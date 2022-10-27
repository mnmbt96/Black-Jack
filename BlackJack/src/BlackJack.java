import java.util.Scanner;

public class BlackJack {
  private static String name;

  public BlackJack(){
  }

  public String getName() {
    return name;
  }

  public static void start(){
    Player player = new Player(0);
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("   Welcome to Black Jack! ");
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    //Input name
    System.out.print("Enter your name: ");
    Scanner scanner = new Scanner(System.in);

    BlackJack blackJack = new BlackJack();
    name = scanner.nextLine();
    System.out.println();
    System.out.println("Welcome " + blackJack.getName() + ",");

    //Game Start
    System.out.println("---------------------------");
    System.out.println("        Game Start!!       ");
    System.out.println("---------------------------");
    player.GameStart(); 
  

    //Result
    System.out.println("---------------------------");
    System.out.println("           RESULT          ");
    System.out.println("---------------------------");
    Result result = new Result(player.getPlayersTotal(), player.getDealer().getDealersTotal());
    result.compareResults();
    scanner.close();
 }

}
