package AdventureGame.model;

public class Armor {

    private int id;
    private String name;
    private int block;
    private int price;

    public Armor(String name,int id, int block, int price) {
        this.name = name;
        this.id = id;
        this.block = block;
        this.price = price;
    }

    public static Armor[] armors() {
        Armor[] armors = new Armor[] {
                new Armor("Light Armor", 1, 1, 15),
                new Armor("Medium Armor", 2,3, 25),
                new Armor("Heavy Armor", 3, 5, 40)
        };
        return armors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static Armor getArmorById(int id) {
        for (Armor armor : armors()) {
            if (armor.getId() == id) {
                return armor;
            }
        }
        return null;
    }
}
