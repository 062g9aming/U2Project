public class Main {
    public static void main(String[] args) {
        Entity player = new Entity("Bob", "Hero of The Story",10000, 1000, 1, 20, 50, "Beginners");
        Entity enemy = new Entity("MR DAS", "The Dass Boss",10, 5000, 2, 1, 50, "Beginners");

        MoveSet.nukeU1(1,1,1, 1,player, enemy);
        MoveSet.aTKM1(10,1,1, player, enemy);
        MoveSet.healM2(20, 3, 1, 10, enemy);
        MoveSet.boostDMGM3(5,10,player);
        MoveSet.swapHPU2(10,player, enemy);



            //player.nukeU1(1,1,1);
        //enemy.dmgReceived(player.nukeU1(1,1,1));
        //player.boostDMGM3(5,5);
        //player.swapHPU2();
    }



}