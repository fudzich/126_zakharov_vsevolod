package task;

public abstract class BattleUnitBase implements BattleUnit {

    private String name;
    private int MaxHealth;
    private int BaseStrength;
    private int MaxArmor;
    private int Health;
    private int atack;
    private int armor;

    public BattleUnitBase(String Name, int maxHealth, int baseStrength, int maxArmor){
        name = Name;
        MaxArmor = maxArmor;
        BaseStrength = baseStrength;
        MaxHealth = maxHealth;
        armor = maxArmor;
        atack = baseStrength;
        Health = maxHealth;
    }

    public abstract void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam);
    public abstract void attack(BattleUnit other);

    public String name(){
        return name;
    }
    public int health(){
        return Health;
    }
    public int maxHealth(){
        return MaxHealth;
    }
    public void setMaxHealth(int value){
        MaxHealth = value;
        if(Health > MaxHealth){
            Health = MaxHealth;
        }
    }
    public void heal(int value){
        if(value > 0){
            Health = Health + value;
            if (Health > MaxHealth) {
                Health = MaxHealth;
            }
        }
    }
    public void takeDamage(int value){
        if(value > 0) {
            Health = Health - value;
            if (Health < 0) {
                Health = 0;
            }
        }
    }
    public int strength(){
        return atack;
    }
    public void setStrength(int value){
        atack = value;
    }
    public int baseStrength(){
        return BaseStrength;
    }
    public int armor(){
        return armor;
    }
    public void restoreArmor(int value){
        if(value > 0) {
            armor = armor + value;
            if (armor > MaxArmor) {
                armor = MaxArmor;
            }
        }
    }
    public void damageArmor(int value){
        if( value > 0) {
            armor = armor - value;
            if (armor < 0) {
                armor = 0;
            }
        }
    }
    public int maxArmor(){
        return MaxArmor;
    }
    public void setMaxArmor(int value){
        MaxArmor = value;
        if (armor > MaxArmor){
            armor = MaxArmor;
        }
    }
}
