import java.util.Random;
import java.util.Scanner;

public class Entity {
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
    private int ultCharge;

    Random r = new Random();


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
        System.out.println("HP: " + maxHP + "   |   ATK: " + ATK + "   |   DEF: " + DEF);
    }





    //stat updates
    public void dmgReceived(int RawDMG) {
        int incomingDMG = (int) (RawDMG * (100 - dEF) / 100.0);
        if (luck <= r.nextInt(101))
        {
            System.out.println("You Dodged " + incomingDMG + " DMG!");
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
        System.out.println("HP: " + hP + "   |   ATK: " + aTK + "   |   DEF: " + dEF);
        if (hP <= 0)
        {
            System.out.println(entity + " has been slain...");
        }
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
    }





    //movesets
    public int attackM1(int variance, int base, int multiplier)
    {
        //used to randomize base ATK
        int dMG = (int)((multiplier) * (aTK + base) * ((r.nextInt(80 - variance, 80 + variance+1)) / 100.0));
        int generated_Percent = r.nextInt(101);
        if (cR >= generated_Percent)
        {
            System.out.println("Crit!");
            dMG *= 2;
        }
        System.out.println(entity + " dealt " + dMG + " DMG!");
        return(dMG);
    }

    public void healM2(int percent, int variance, int base, int multiplier)
    {
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
    public int boostDMGM3(int multiplier, int duration)
    {
        if (duration > 0)
        {
            duration -= 1;
            return(multiplier);
        }
        return(0);
    }





    //ultset

    public int nukeU1(int variance, int base, int multiplier)
    {
        //triple attack but takes personal dmg
        int dMG = (int)((3 * multiplier) * (aTK + base) * ((r.nextInt(80 - variance, 80 + variance+1)) / 100.0));
        int generated_Percent = r.nextInt(101);
        if (cR >= generated_Percent)
        {
            System.out.println("Crit!");
            dMG *= 2;
        }
        System.out.println(entity + " dealt " + dMG + " Nuke DMG!");
        return(dMG);
    }

}
