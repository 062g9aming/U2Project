public class Main {
    public static void main(String[] args) {
        Entity player = new Entity("Bob", "Hero of The Story",10000, 1000, 1, 20, 50, "Beginners");
        Entity enemy = new Entity("MR DAS", "The Dass Boss",10, 5000, 2, 1, 50, "Beginners");

        nukeU1(1,1,1, 1,player, enemy);
        aTKM1(10,1,1, player, enemy);
        healM2(20, 3, 1, 10, enemy);
        boostDMGM3(5,10,player);
        swapHPU2(10,player, enemy);



            //player.nukeU1(1,1,1);
        //enemy.dmgReceived(player.nukeU1(1,1,1));
        //player.boostDMGM3(5,5);
        //player.swapHPU2();
    }

    public static void aTKM1(int variance, int base, int multiplier, Entity caster, Entity reciever)
    {
        reciever.dmgReceived(caster.attackM1(variance, base, multiplier));
        caster.turnEnd();
        caster.statsCurrent();
    }

    public static void healM2(int percent, int variance, int base, int multiplier, Entity caster)
    {
        caster.healM2(percent, variance, base, multiplier);
        caster.turnEnd();
        caster.statsCurrent();
    }

    public static void boostDMGM3(int multiplier, int duration, Entity caster)
    {
        caster.boostDMGM3(multiplier, duration);
        caster.turnEnd();
        caster.statsCurrent();
    }

    public static void nukeU1(int variance, int base, int multiplier, int cost, Entity caster, Entity receiver)
    {
        receiver.dmgReceived(caster.nukeU1(variance, base, multiplier, cost));
        caster.turnEnd();
        caster.statsCurrent();
    }
    public static void swapHPU2(int cost, Entity caster, Entity receiver)
    {
        if (caster.returnUltCharge() <= cost)
        {
            caster.swapHPU2(receiver.returnHP(), cost);
        }
        else
        {
            receiver.enemySwapHPU2(caster.swapHPU2(receiver.returnHP(), cost));
        }
        caster.turnEnd();
        caster.statsCurrent();
    }

}