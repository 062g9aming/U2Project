import java.util.Random;

public class Entity {
    private String entity;
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

    Random r = new Random();


    public Entity(String name, String title, int maxHP, int ATK, int DEF, int luck, int criticalRate, String weapon)
    {
        entity = name;
        hP = maxHP;
        aTK = ATK;
        this.dEF = DEF;
        this.luck = luck;
        cR = criticalRate;

        System.out.println(name);
        System.out.println("-------" + title + "-------");
        System.out.println("HP: " + maxHP + "   |   ATK: " + ATK + "   |   DEF: " + DEF);
    }

    public int attackPlayer()
    {
        //used to randomize base ATK
        int dMG = (int)(aTK * ((r.nextInt(41) + 80) / 100.0));
        int generated_Percent = r.nextInt(101);
        if (cR >= generated_Percent)
        {
            System.out.println("Crit!");
            dMG *= 2;
        }
        return(dMG);
    }

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
    }

    public void statsCurrent()
    {
        System.out.println(name);
        System.out.println("-------" + title + "-------");
        System.out.println("HP: " + maxHP + "   |   ATK: " + ATK + "   |   DEF: " + DEF);
    }


    

}
