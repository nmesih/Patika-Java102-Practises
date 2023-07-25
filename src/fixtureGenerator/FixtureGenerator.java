package fixtureGenerator;

import java.util.*;

public class FixtureGenerator {
    private List<String> teams;

    public FixtureGenerator(List<String> teams) {
        // Eğer takım sayısı tekse, "Bay" takımını ekleyelim.
        if (teams.size() % 2 != 0) {
            this.teams.add("Bay");
        }
        this.teams = teams;
    }

    public List<String> generateFixtures() {
        List<String> fixtures = new ArrayList<>();
        int numWeeks = this.teams.size() - 1;

        // Takımları rastgele sıralayalım.
        Collections.shuffle(this.teams);

        for (int week = 0; week < numWeeks; week++) {
            fixtures.add("Week " + (week + 1));
            for (int i = 0; i < this.teams.size() / 2; i++) {
                String homeTeam = this.teams.get(i);
                String awayTeam = this.teams.get(this.teams.size() - 1 - i);

                if (!awayTeam.equals("Bay")) {
                    fixtures.add(homeTeam + " vs " + awayTeam);
                }
            }
            rotateTeams(); // Takımları döndürelim (çift devreli lig usulü için).
        }
        return fixtures;
    }

    private void rotateTeams() {
        // Takımları döndürelim (çift devreli lig usulü için).
        String lastTeam = this.teams.get(this.teams.size() - 1);
        teams.remove(lastTeam);
        teams.add(1, lastTeam);
    }



}
