package DubaiAeroport;

public class Model {
  private String tanks;
  private String model;
  private int tankcounts;


    public Model(String tanks, String model, int tankcounts) {
        this.tanks = tanks;
        this.model = model;
        this.tankcounts = tankcounts;
    }

    public String getTanks() {
        return tanks;
    }

    public void setTanks(String tanks) {
        this.tanks = tanks;
    }

    public int getTankcounts() {
        return tankcounts;
    }

    public void setTankcounts(int tankcounts) {
        this.tankcounts = tankcounts;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String toString(){
        return getTanks() + " " + getModel() + " " + getTankcounts();
    }

}
