package AdventureGame.model;

public class SafeHouse extends NormalLocation{

    public SafeHouse(Player player ) {
        super(player, "Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in the safe place !");
        System.out.println("Your health bar renewed !");
        return true;
    }
}
