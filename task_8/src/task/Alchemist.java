package task;

public class Alchemist extends  BattleUnitBase{

    public Alchemist(String name, int maxHealth, int baseStrength, int maxArmor){
        super(name, maxHealth, baseStrength, maxArmor);
    }


    public void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam){
        boolean healthCheck = false;
        int firstHealthy= 0;
        for( int i = 0; i< ownTeam.length; i++){
            if(ownTeam[i].health() > 0){
                firstHealthy = i;
                healthCheck = true;
                break;
            }
        }
        if(healthCheck == true) {
            int minFoundHealth = ownTeam[firstHealthy].health();
            int beatenOne = firstHealthy;
            int maxFoundHealth = ownTeam[firstHealthy].health();
            int livingOne = firstHealthy;
            for(int i = firstHealthy; i< ownTeam.length; i++){
                if(ownTeam[i].health() > 0){
                    if(ownTeam[i].health() < minFoundHealth){
                        minFoundHealth = ownTeam[i].health();
                        beatenOne = i;
                    }

                    if(ownTeam[i].health() > maxFoundHealth){
                        maxFoundHealth = ownTeam[i].health();
                        livingOne = i;
                    }
                }
            }
            ownTeam[beatenOne].heal(10);
            ownTeam[livingOne].setStrength(ownTeam[beatenOne].strength() + 1);
        }
    }

    public void attack(BattleUnit other){
        other.setStrength(other.strength() - 2);
        other.setMaxHealth(other.maxHealth() - 4);
    }
}
