package flat56.kazlogoquiz.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Murat on 31.01.2015.
 */
public class Level {

    private int id;
    private int points;
    private int logosFound;
    //TODO remove
    private int logosCount;
    private boolean opened;
    private List<Logo> logos;

    public Level(int id, int points, int logosFound, int logosCount, boolean opened) {
        this.id = id;
        this.points = points;
        this.logosFound = logosFound;
        this.logosCount = logosCount;
        this.opened = opened;
    }

    public Level(int id, int points, int logosFound, int logosCount,  boolean opened, List<Logo> logos) {
        this.id = id;
        this.points = points;
        this.logosFound = logosFound;
        this.logosCount = logosCount;
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

    public int getLogosCount() {
        return logosCount;
    }

    public void setLogosCount(int logosCount) {
        this.logosCount = logosCount;
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
}
