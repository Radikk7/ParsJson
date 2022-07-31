package DubaiAeroport;

public class FlightModel {
    private String aeroport;
    private String codaeroport;
    private String flightnumber;
    private String Scheddate;
    private String Reviseddate;

    public FlightModel(String aeroport, String codaeroport, String flightnumber, String scheddate, String reviseddate) {
        this.aeroport = aeroport;
        this.codaeroport = codaeroport;
        this.flightnumber = flightnumber;
        Scheddate = scheddate;
        Reviseddate = reviseddate;
    }

    public String getAeroport() {
        return aeroport;
    }

    public void setAeroport(String aeroport) {
        this.aeroport = aeroport;
    }

    public String getCodaeroport() {
        return codaeroport;
    }

    public void setCodaeroport(String codaeroport) {
        this.codaeroport = codaeroport;
    }

    public String getFlightnumber() {
        return flightnumber;
    }

    public void setFlightnumber(String flightnumber) {
        this.flightnumber = flightnumber;
    }

    public String getScheddate() {
        return Scheddate;
    }

    public void setScheddate(String scheddate) {
        Scheddate = scheddate;
    }

    public String getReviseddate() {
        return Reviseddate;
    }

    public void setReviseddate(String reviseddate) {
        Reviseddate = reviseddate;
    }
    public String toString(){
        return getAeroport() + " " + getCodaeroport() +
                " " + getFlightnumber() + " " + getScheddate() + " " + getReviseddate();
    }
}
