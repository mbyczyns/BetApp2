package Disciplines;

import java.util.Random;

public class FootballMatch extends AbstractDiscipline implements DisciplinesInterface {
    @Override
    public int getTotalOdds() {
        return totalOdds;
    }

    Random rand = new Random();
    private String teamA;
    private String teamB;
    private int teamAgoals;
    private int teamBgoals;
    private float winAodd = 3.0f;
    private float winBodd = 3.0f;
    private float drawOdd = 8.0f;
    private float more4Odd = 1.5f;
    private float more6Odd = 2.5f;
    private float more8odd = 4.0f;
    private float noGoalsOdd = 3.5f;

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

    public float winA(int teamAgoals, int teamBgoals) {
        if (teamBgoals < teamAgoals) return 3.0f;
        else return 0;
    }

    public float winB(int teamAgoals, int teamBgoals) {
        if (teamBgoals > teamAgoals) return 3.0f;
        else return 0;
    }

    public float draw(int teamAgoals, int teamBgoals) {
        if (teamBgoals == teamAgoals) return 8.0f;
        else return 0;
    }

    public float more4(int teamAgoals, int teamBgoals) {
        if (teamBgoals + teamAgoals > 4) return 1.5f;
        else return 0;
    }

    public float more6(int teamAgoals, int teamBgoals) {
        if (teamBgoals + teamAgoals > 6) return 2.5f;
        else return 0;
    }

    public float more8(int teamAgoals, int teamBgoals){
        if (teamBgoals+teamAgoals>8) return 4.0f;
        else return 0;
    }

    public float noGoals(int teamAgoals, int teamBgoals){
        if (teamBgoals==0 || teamAgoals==0) return 3.5f;
        else return 0;
    }
}
