import java.util.Scanner;

public class BlackJack{
  private static String name;

  public BlackJack(){
  }

  public String getName() {
    return name;
  }

  public static void start() throws InterruptedException{
    Player player = new Player(0);
    BlackJack blackJack = new BlackJack();
    
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("   Welcome to Black Jack! ");
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    //Input name
    System.out.print("Enter your name: ");
    Scanner scanner = new Scanner(System.in);

    name = scanner.nextLine();
    System.out.println();

    Thread.sleep(1000);
    System.out.println("Welcome " + blackJack.getName() + ",");

    //Game Start
    Thread.sleep(1000);
    System.out.println("---------------------------");
    System.out.println("        Game Start       ");
    System.out.println("---------------------------");
    player.GameStart(); 

    //Result
    Thread.sleep(1500);
    System.out.println("---------------------------");
    System.out.println("           RESULT          ");
    System.out.println("---------------------------");
    Result result = new Result(player.getPlayersTotal(), player.getDealer().getDealersTotal(),player.ispFlag(), player.getDealer().isdFlag());
    result.compareResults();
    scanner.close();
 }

}
