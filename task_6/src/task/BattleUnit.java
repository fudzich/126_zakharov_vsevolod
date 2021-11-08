package task;

public class BattleUnit {
    private int strength;
    private int armor;
    private int health;
    private int x;
    private int y;

    public BattleUnit(int strength, int armor, int health, int x, int y){
        this.strength=strength;
        this.health=health;
        this.armor=armor;
        this.x=x;
        this.y=y;
    }

    public int getStrength() {
        return strength;
    }
    public int getArmor() {
        return armor;
    }
    public int getHealth() {
        return health;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void attacked(BattleUnit enemy){
        if(enemy.strength>armor){
            int damage=enemy.strength-armor;
            if(damage>enemy.strength){
                health=health-enemy.strength;
            }
            else {
                health = health - damage;
            }
        }
    }
    public void moveUp(){
        y=y-1;
    }
    public void moveDown(){
        y=y+1;
    }
    public void moveLeft(){
        x=x-1;
    }
    public void moveRight(){
        x=x+1;
    }
    public boolean isAlive(){
        if(health>0){
            return true;
        }
        else{
            return false;
        }
    }
}
