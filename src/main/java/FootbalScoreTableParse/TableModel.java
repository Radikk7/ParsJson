package FootbalScoreTableParse;

public class TableModel {
    private String reating;
    private String name;
    private String games;
    private String winers;
    private String draft;
    private String loses;
    private String goals;
    private String score;


    public TableModel(String reating, String name, String games, String winers,
                      String draft, String loses, String goals, String score) {
        this.reating = reating;
        this.name = name;
        this.games = games;
        this.winers = winers;
        this.draft = draft;
        this.loses = loses;
        this.goals = goals;
        this.score = score;
    }

    public String getReating() {
        return reating;
    }

    public void setReating(String reating) {
        this.reating = reating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGames() {
        return games;
    }

    public void setGames(String games) {
        this.games = games;
    }

    public String getWiners() {
        return winers;
    }

    public void setWiners(String winers) {
        this.winers = winers;
    }

    public String getDraft() {
        return draft;
    }

    public void setDraft(String draft) {
        this.draft = draft;
    }

    public String getLoses() {
        return loses;
    }

    public void setLoses(String loses) {
        this.loses = loses;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
    public String toString (){
        return getReating() + " " + getName() + " " + getGames() + " " + getWiners() + " " + getDraft() +
                " " + getLoses() + "  "  +  getGoals() +  "  " + getScore();
    }

}
