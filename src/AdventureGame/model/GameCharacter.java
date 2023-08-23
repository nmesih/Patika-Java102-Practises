package AdventureGame.model;

public abstract class GameCharacter {

    private int id;
    private int damage;
    private int health;
    private int price;
    public String characterName;
    private Inventory inventory;


    private int originalHealth;
    public GameCharacter (String charName, int damage, int health, int money, int id) {
        setCharacterName(charName);
        setDamage(damage);
        setHealth(health);
        setMoney(money);
        setId(id);
        setOriginalHealth(health);
        this.inventory = new Inventory();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public int getTotalDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if(health < 0){
            health = 0;
        }
        this.health = health;
    }

    public int getMoney() {
        return price;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setMoney(int price) {
        this.price = price;
    }

    public Weapon getWeapon() {
        return this.getInventory().getWeapon();
    }

    public Armor getArmor() {
        return this.getInventory().getArmor();
    }
    public int getBlock() {
        return this.getInventory().getArmor().getBlock();
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }
}
