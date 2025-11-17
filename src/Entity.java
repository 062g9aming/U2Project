import java.util.Random;
public class Entity {
    private static String entity;
    private static int hP;
    private static int aTK;
    private static int dEF;
    private static int luck;
    private static int cR;
    private static int baseHP;
    private static int baseATK;
    private static int baseDEF;
    private static int baseLuck;
    private static int baseCR;


    public Entity(String name, String title, int maxHP, int ATK, int DEF, int luck, int criticalRate, String weapon)
    {
        hP = maxHP;
        Entity.aTK = ATK;
        this.dEF = DEF;
        this.luck = luck;
        cR = criticalRate;

        System.out.println(name);
        System.out.println("-------" + title + "-------");
        System.out.println("HP: " + maxHP + "   |   ATK: " + ATK + "   |   DEF: " + DEF);
    }

    public double attackPlayer()
    {
        Random r = new Random();
        //used to randomize base ATK
        double dMG = (aTK * ((r.nextInt(41) + 80) / 100.0));
        int generated_Percent = r.nextInt(101);
        if (cR >= generated_Percent)
        {
            System.out.println("Crit!");
            dMG *= 2;
        }
        return(dMG);
    }

    

}
