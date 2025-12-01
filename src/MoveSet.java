public class MoveSet {
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
