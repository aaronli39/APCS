/*=====================================================
  Joan Chirinos, Aaron Li, Rohan Ahammed - The RPGers
  APCS1 pd08
  HW26 -- Ye Olde Role Playing Game
  2017-11-08
  =====================================================*/

public class Protagonist {

    // ========== INSTANCE VARIABLES ==========
    
    // variable to store character name
    private String name;
    // variable to store health points
    private int hp;
    // variable to store strength points
    private int strength;
    // variable to store defense points
    private int def;
    // variable to store attack rating
    private double atr;

    // Overloaded constructor takes input nam and sets the character name to nam
    public Protagonist(String nam) {
	name = nam;
	hp = 200;
	strength = 100;
	def = 40;
	atr = 0.5; 
    }

    // Returns bool true if player hp > 0
    public boolean isAlive() {
	return hp > 0;
    }

    // Returns player defense
    public int getDefense() {
	return def;
    }

    // Returns player name
    public String getName() {
	return name;
    }

    //Sets hp to current hp - int loss
    public void lowerHP(int loss) {
	hp -= loss;
    }

    // Attacks a Monster object. Formula for dmg is (strength * atr) - monsterDefense
    public int attack(Monster rawr) {
	int dmg = (int) ((strength * atr) - rawr.getDefense()); // damage calculation formula
	if (dmg < 0) { // if damage is negative, damage will instead be 0
	    dmg = 0;
	} rawr.lowerHP(dmg); // else simply lose health by damage amount
	return dmg;
    }

    // Increases strength to a constant amount greater than default value. Defense is lowered by a constant as well.
    public void specialize() {
	strength = 175;
	def = 10;
    }

    //Sets strength and defense to default values
    public void normalize() {
	strength = 100;
	def = 40;
    }
    
}
