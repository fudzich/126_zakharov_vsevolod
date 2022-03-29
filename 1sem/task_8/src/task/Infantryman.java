package task;

public class Infantryman extends BattleUnitBase{

    /*
    private String name;
    private int MaxHealth;
    private int BaseStrength;
    private int MaxArmor;
    */
    public Infantryman( String name, int maxHealth, int baseStrength, int maxArmor){
        super(name, maxHealth, baseStrength, maxArmor);
    }

    public void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam){

    }
    public void attack(BattleUnit other){
        int enemy_a = other.armor();
        int attack = strength();
        if(enemy_a > 0){
            int damage_h = attack/2;
            int damage_a = attack/4;
            if( damage_h < 1){
                other.takeDamage(1);
            }
            else{
                other.takeDamage(damage_h);
            }
            if( damage_a < 1){
                other.damageArmor(1);
            }
            else{
                other.damageArmor(damage_a);
            }
        }
        else{
            if(attack < 1){
                other.takeDamage(1);
            }
            else{
                other.takeDamage(attack);
            }
        }
    };
}
