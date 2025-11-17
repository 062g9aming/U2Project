public class Entity {
    private String entity;
    private int hP;
    private static int aTK;
    private int dEF;
    private int luckiness;
    private int cR;

    public Entity(String name, String title, int maxHP, int ATK, int DEF, int luck, int criticalChance, String weapon)
    {
        hP = maxHP;
        aTK = ATK;
        dEF = DEF;
        luckiness = luck;
        cR = criticalChance;

        System.out.println(name);
        System.out.println("-------" + title + "-------");
        System.out.println("HP: " + maxHP + "   |   ATK: " + ATK + "   |   DEF: " + DEF);
    }

    public static int attackPlayer()
    {
        return(aTK);
    }

    

}
