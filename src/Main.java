import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        double dMG = (aTK * ((r.nextInt(41) + 80) / 100.0));
        Entity Player = new Entity("YOU", "The Dass Boss",10, 100000000, 2, 0, 100, "Beginners");
        Entity bud = new Entity("Das", "The Dass Boss",10, 1, 2, 0, 100, "Beginners");
        System.out.println(Player.attackPlayer());
    }
}