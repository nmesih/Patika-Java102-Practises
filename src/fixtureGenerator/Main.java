package fixtureGenerator;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> teams = Arrays.asList("FB", "GS", "BJK", "TS");
        FixtureGenerator fixtureGenerator = new FixtureGenerator(teams);
        List<String> fixtures = fixtureGenerator.generateFixtures();

        for (String fixture : fixtures) {
            System.out.println(fixture);
        }
    }
}
