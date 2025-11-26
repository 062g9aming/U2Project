import java.util.Random;

public class Entity {
    //standard info
    private String entity;
    private String title;
    private int hP;
    private int aTK;
    private int dEF;
    private int luck;
    private int cR;
    private int baseHP;
    private int baseATK;
    private int baseDEF;
    private int baseLuck;
    private int baseCR;
    private int ultCharge = 0;

    //buff mech
    private int boostATKmult = 1;
    private int boostATKdur = 0;


    Random r = new Random();

    public void indent()
    {
        System.out.println();
        System.out.println();
    }

    public Entity(String name, String title, int maxHP, int ATK, int DEF, int luck, int criticalRate, String weapon)
    {
        //display stats at max
        entity = name;
        this.title = title;
        hP = maxHP;
        aTK = ATK;
        dEF = DEF;
        this.luck = luck;
        cR = criticalRate;
        //display stats at base/max
        baseHP = maxHP;
        baseATK = ATK;
        baseDEF = DEF;
        baseLuck = luck;
        baseCR = criticalRate;

        System.out.println(name);
        System.out.println("-------" + title + "-------");
        System.out.println("HP: " + maxHP + "/" + maxHP + "   |   ATK: " + ATK + "   |   DEF: " + DEF);
        indent();
    }





    //stat updates/info
    public void dmgReceived(int RawDMG) {
        int incomingDMG = (int) (RawDMG * (100 - dEF) / 100.0);
        if (RawDMG == 0)
        {
            System.out.println(entity + " took no DMG!");
        }
        else if(luck >= r.nextInt(101))
        {
            System.out.println(entity +  " dodged " + incomingDMG + " DMG!");
        }
        else
        {
            System.out.println("Ouch! " + entity + " received " + incomingDMG + " DMG!");
            hP -= incomingDMG;
        }
        statsCurrent();
    }

    public void statsCurrent()
    {
        System.out.println(entity);
        System.out.println("-------" + title + "-------");
        System.out.println("HP: " + hP + "/" + baseHP + "   |   ATK: " + aTK + "   |   DEF: " + dEF + "   |   Ult: " + ultCharge + "/5");
        buffDetails();
        if (hP <= 0)
        {
            System.out.println(entity + " has been slain...");
        }
        indent();
    }


    public void turnEnd()
    {
        ultCharge++;
        boostATKdur --;
        if (boostATKdur < 1)
        {
            boostATKmult = 1;
        }
    }


    public void buffDetails()
    {
        if (boostATKdur > 0)
        {
            System.out.println("ATK boost: x" + boostATKmult + "   Duration: " + boostATKdur + " rounds");
        }
    }


    public int returnHP()
    {
        return(hP);
    }
    public int returnUltCharge()
    {
        return(ultCharge);
    }




    //permanent stat change
    public void statMutation(int HP, int ATK, int DEF, int luck, int criticalRate)
    {
        baseHP += HP;
        baseATK += ATK;
        baseDEF += DEF;
        baseLuck += luck;
        baseCR += criticalRate;
    }

    public void statReset()
    {
        hP = baseHP;
        aTK = baseATK;
        dEF = baseDEF;
        luck = baseLuck;
        cR = baseCR;
    }


    //create new opponent
    public void newEntity(String name, String title, int maxHP, int ATK, int DEF, int luck, int criticalRate, String weapon)
    {
        entity = name;
        this.title = title;
        hP = maxHP;
        aTK = ATK;
        dEF = DEF;
        this.luck = luck;
        cR = criticalRate;
        //display stats at base/max
        baseHP = maxHP;
        baseATK = ATK;
        baseDEF = DEF;
        baseLuck = luck;
        baseCR = criticalRate;

        System.out.println(name);
        System.out.println("-------" + title + "-------");
        System.out.println("HP: " + maxHP + "   |   ATK: " + ATK + "   |   DEF: " + DEF);
        indent();
    }





    //movesets
    public int attackM1(int variance, int base, int multiplier)
    {

        //used to randomize base ATK
        multiplier *= boostATKmult;
        System.out.println(entity + " used basic attack!");
        int dMG = (int)((multiplier) * (aTK + base) * ((r.nextInt(80 - variance, 80 + variance+1)) / 100.0));
        int generated_Percent = r.nextInt(101);
        if (cR >= generated_Percent)
        {
            System.out.println("Crit!");
            dMG *= 2;
        }

        System.out.println(entity + " dealt " + dMG + " DMG!");
        indent();
        return(dMG);
    }

    public void healM2(int percent, int variance, int base, int multiplier)
    {
        System.out.println(entity + " is healing!");
        int healing = (int)((multiplier) * (baseHP + base) * ((r.nextInt(percent - variance, percent+variance+1)  / 100.0)));
        int generated_Percent = r.nextInt(101);
        if (luck >= generated_Percent)
        {
            System.out.println("Crit Heal!");
            healing *= 1.5;
        }
        System.out.println(entity + " recovered " + healing + " HP!");
        if ((hP + healing) > baseHP)
        {
            hP = baseHP;
        }
        else
        {
            hP += healing;
        }
        statsCurrent();
    }

    //code this such that during buff rest will apply right after
    public void boostDMGM3(int multiplier, int duration)
    {
        System.out.println(entity + " is buffing!");
        System.out.println(entity + " now deals x" + multiplier + " DMG for " + duration + " rounds!");
        boostATKmult = multiplier;
        boostATKdur = duration;
        statsCurrent();
    }





    //ultset
    public void chargeUlt(int amount)
    {
        if (ultCharge <= 5)
        {
            ultCharge += amount;
        }
    }


    public int nukeU1(int variance, int base, int multiplier, int cost)
    {
        if (cost <= ultCharge)
        {
            //triple attack but takes personal dmg
            System.out.println("Nuke Incoming! " + entity + " has used their ultimate!");
            int dMG = (int)((3 * multiplier) * (aTK + base) * ((r.nextInt(80 - variance, 80 + variance+1)) / 100.0));
            int generated_Percent = r.nextInt(101);
            if (cR >= generated_Percent)
            {
                System.out.println("Crit!");
                dMG *= 2;
            }
            System.out.println(entity + " dealt " + dMG + " Nuke DMG!");
            dmgReceived(dMG/5);
            ultCharge -= (cost + 1);
            return(dMG);
        }
        else
        {
            System.out.println(entity + " has insufficient charge! Resorting to Ult. Charge!");
            ultCharge ++;
            return(0);}
    }

    public int swapHPU2(int targetHP, int cost)
    {
        if (cost <= ultCharge) {
            //swap HP
            System.out.println("S-Witch-eroo! " + entity + " has used their ultimate!");
            System.out.println("HP has been swapped!");

            int casterHP = hP;
            hP = targetHP;
            statsCurrent();
            ultCharge -= (cost + 1);
            return (casterHP);
        }
        else
        {
            System.out.println(entity + " has insufficient charge! Resorting to Ult. Charge!");
            ultCharge ++;
            return(0);
        }
    }
        //follow up HP swap
        public void enemySwapHPU2(int HPChange)
        {
            hP = HPChange;
            statsCurrent();
        }

}
