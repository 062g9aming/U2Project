public class Main {
    public static void main(String[] args) {
        Entity player = new Entity("YOU", "Hero of The Story",10000, 1000, 1, 77, 50, "Beginners");
        Entity enemy = new Entity("MR DAS", "The Dass Boss",10, 5000, 2, 1, 50, "Beginners");
            player.dmgReceived(enemy.attackM1(20, 1, 2));
            player.healM2(20, 3, 1, 10);
            enemy.dmgReceived(player.nukeU1(1,1,1));
            player.boostDMGM3(5,5);
            player.swapHPU2();
    }
}