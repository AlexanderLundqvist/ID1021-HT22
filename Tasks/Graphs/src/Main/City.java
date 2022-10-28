package Main;

import java.util.LinkedList;

public class City {
    private String name;
    private LinkedList<Connection> neighbours;

    public City(String name) {
        this.name = name;
        this.neighbours = new LinkedList<Connection>();
    }

    public void connect(City next, int distance) {
        this.neighbours.add(new Connection(next, distance));
    }

    public String getName() {
        return this.name;
    }

    public LinkedList<Connection> getNeighbor() {
        return this.neighbours;
    }
}