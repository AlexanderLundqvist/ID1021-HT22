package Main;

public class Connection {
    private final City endpoint;
    private final Integer distance;

    public Connection(City endpoint, Integer distance) {
        this.endpoint = endpoint;
        this.distance = distance;
    }

    public City getConnectingCity() {
        return this.endpoint;
    }

    public Integer getDistance() {
        return this.distance;
    }
}
