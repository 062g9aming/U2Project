public class Main {
    public static void main(String[] args) {
        Entity player = new Entity("YOU", "The Dass Boss",10000, 1000, 1, 77, 50, "Beginners");
        Entity enemy = new Entity("heuuu", "The Dass Boss",10, 5000, 2, 0, 50, "Beginners");
        for (int i = 1; i != 5; i++) {
            int ouch = enemy.attackM1(20, 1, 2);
            player.dmgReceived(ouch);
            player.healM2(20, 3, 1, 10);
            player.nukeU1(1,1,1);
        }
    }
}