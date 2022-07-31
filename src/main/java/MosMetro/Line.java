package MosMetro;

import java.util.List;

public class Line {
    private String name ;
    private String number;
    private List<Station>stations;

    public Line(String name, String number, List<Station> stations) {
        this.name = name;
        this.number = number;
        this.stations = stations;
    }

    public Line(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public void setStations(List<Station>stations){
        this.stations = stations;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    public String toString(){
        return getNumber() + " " + getName();
    }
}
