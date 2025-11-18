import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Entity Player = new Entity("YOU", "The Dass Boss",10, 1000, 2, 77, 50, "Beginners");
        Entity Buddy = new Entity("heuuu", "The Dass Boss",10, 10, 2, 0, 50, "Beginners");
        int ouch = Buddy.attackPlayer();
        Player.dmgReceived(ouch);
    }
}