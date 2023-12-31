package AdventureGame.model;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private final Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to Adventure Game!");
        System.out.println("Enter name: ");
        String playerName = input.nextLine();

        Player player = new Player(playerName);
        System.out.println("Player " + player.getName() + ". Select the character.");
        player.selectChar();
        player.printCharInfo();
        Location location = null;
        Location[] locations = {new SafeHouse(player), new ToolStore(player),
                new Cave(player), new Forest(player), new River(player)};
        ArrayList<Location> clearedAreaList = new ArrayList<>();
        while (true) {
            int i = 1;
            for (Location location1 : locations) {
                System.out.println(i + " - " + location1.getName());
                i++;
            }
            System.out.print("Select the place you want to go : ");
            int selectLoc = input.nextInt();
            switch (selectLoc) {
                case 1:
                    location = locations[0];
                    break;
                case 2:
                    location = locations[1];
                    break;
                case 3:
                    location = locations[2];
                    break;
                case 4:
                    location = locations[3];
                    break;
                case 5:
                    location = locations[4];
                    break;
            }
            boolean isAreaCleared = location.onLocation();
            if (!isAreaCleared) {
                System.out.println("Game OVER!!!");
                break;
            } else if (isAreaCleared && location.getSelectCombatValue()) {
                clearedAreaList.add(location);
            }
            if (clearedAreaList.size() > 5) {
                System.out.println("You Won the Game!!" +
                        "\n Congrats!!!");
                break;
            }
        }
    }
}

