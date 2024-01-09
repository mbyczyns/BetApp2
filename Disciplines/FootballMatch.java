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

    public FootballMatch(String teamA, String teamB) {
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

    public boolean getTeamAgoals(int teamAgoals, int teamBgoals) {
        return (teamBgoals < teamAgoals);
    }

    public boolean getTeamBgoals(int teamAgoals, int teamBgoals) {
        return (teamBgoals > teamAgoals);
    }

    public boolean draw(int teamAgoals, int teamBgoals) {
        return (teamBgoals == teamAgoals);
    }

    public boolean more4(int teamAgoals, int teamBgoals) {
        return (teamBgoals + teamAgoals > 4);
    }

    public boolean more6(int teamAgoals, int teamBgoals) {
        return (teamBgoals + teamAgoals > 6);
    }

    public boolean more8(int teamAgoals, int teamBgoals){
        return (teamBgoals+teamAgoals>8);
    }

    public boolean noGoals(int teamAgoals, int teamBgoals){
        return (teamBgoals==0 || teamAgoals==0);
    }
}
