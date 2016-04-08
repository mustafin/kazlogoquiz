package flat56.kazlogoquiz.domain.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Murat on 31.01.2015.
 */
public class Level {

    private int id;
    private int points;
    private int logosFound;
    private boolean opened;
    private List<Logo> logos;
    private int leftToOpen;

    public Level(int id, int points, int logosFound, boolean opened) {
        this.id = id;
        this.points = points;
        this.logosFound = logosFound;
        this.opened = opened;
    }

    public Level(int id, int points, int logosFound, boolean opened, List<Logo> logos) {
        this.id = id;
        this.points = points;
        this.logosFound = logosFound;
        this.opened = opened;
        this.logos = logos;
    }

    public Level() {
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getLogosFound() {
        return logosFound;
    }

    public void setLogosFound(int logosFound) {
        this.logosFound = logosFound;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Logo> getLogos() {
        if(logos == null) logos = new ArrayList<>();
        return logos;
    }

    public void setLogos(List<Logo> logos) {
        this.logos = logos;
    }

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

    @Override
    public String toString() {
        return "Level{" +
                "id=" + id +
                ", points=" + points +
                ", logosFound=" + logosFound +
                ", opened=" + opened +
                ", logos=" + logos +
                '}';
    }

    public int getLeftToOpen() {
        return leftToOpen;
    }

    public void setLeftToOpen(int leftToOpen) {
        this.leftToOpen = leftToOpen;
    }
}
