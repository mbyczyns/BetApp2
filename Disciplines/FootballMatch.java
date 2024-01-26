package Disciplines;

import java.util.Random;

public class FootballMatch {

    Random rand = new Random();
    private String teamA;
    private String teamB;
    private int teamAgoals;
    private int teamBgoals;

    public FootballMatch() {
        this.teamA = "Real Madrid";
        this.teamB = "Barcelona";
        this.teamAgoals = rand.nextInt(6);
        this.teamBgoals = rand.nextInt(6);
    }

    public String getTeamA() {
        return teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public int getTeamAgoals() {
        return teamAgoals;
    }

    public int getTeamBgoals() {
        return teamBgoals;
    }

}
