package MosMetro;

public class Station {
    private String name;
    private Line line;
    private String numberStation;

    public Station(String name, Line line, String numberStation) {
        this.name = name;
        this.line = line;
        this.numberStation = numberStation;
    }

    public Station() {
    }

    public String getNumberStation() {
        return numberStation;
    }

    public void setNumberStation(String numberStation) {
        this.numberStation = numberStation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public String toString(){
        return getName() + " " + getNumberStation();
    }
}
