package task;

public class ArmorDestroyer extends BattleUnitBase{

    public ArmorDestroyer(String name, int maxHealth, int baseStrength, int maxArmor){
        super(name, maxHealth, baseStrength, maxArmor);
    }

    public void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam){
        boolean healthCheck = false;
        int firstHealthy= 0;
        for( int i = 0; i< enemyTeam.length;i++){
            if(enemyTeam[i].health() > 0){
                firstHealthy = i;
                healthCheck = true;
                break;
            }
        }
        if(healthCheck == true) {
            int trueEnemy = firstHealthy;
            int maxFoundArmor = enemyTeam[firstHealthy].armor();
            for(int i = firstHealthy; i < enemyTeam.length; i++){
                if(enemyTeam[i].health() > 0){
                    if(enemyTeam[i].armor() > maxFoundArmor){
                        maxFoundArmor = enemyTeam[i].armor();
                        trueEnemy = i;
                    }
                }
            }
            int enemy_a = enemyTeam[trueEnemy].armor();
            int attack = strength();
            if(enemy_a > 0){
                if( attack < 0){
                    enemyTeam[trueEnemy].damageArmor(1);
                }
                else {
                    enemyTeam[trueEnemy].damageArmor(2 * attack);
                }
            }
            else {
                attack= attack/4;
                if (attack < 0){
                    enemyTeam[trueEnemy].takeDamage(1);
                }
                else {
                    enemyTeam[trueEnemy].takeDamage(attack);
                }
            }
        }
    }
    public void attack(BattleUnit other){
        int enemy_a = other.armor();
        int attack = strength();
        if(enemy_a > 0){
            int damage_h = attack/4;
            if( damage_h < 1){
                other.takeDamage(1);
            }
            else{
                other.takeDamage(damage_h);
            }
            if( attack < 1){
                other.damageArmor(1);
            }
            else{
                other.damageArmor(attack);
            }
        }
        else{
            int damage_h = attack/2;
            if(damage_h < 1){
                other.takeDamage(1);
            }
            else{
                other.takeDamage(damage_h);
            }
        }
    }
}
