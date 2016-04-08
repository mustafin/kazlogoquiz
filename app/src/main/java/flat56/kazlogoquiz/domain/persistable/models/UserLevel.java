package flat56.kazlogoquiz.domain.persistable.models;

/**
 * Created by MusMB on 08.04.2016.
 */
public class UserLevel {

    private int id;
    private int points;
    private int logosFound;
    private boolean opened;

    public UserLevel(int id, int points, int logosFound, boolean opened) {
        this.id = id;
        this.points = points;
        this.logosFound = logosFound;
        this.opened = opened;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLogosFound() {
        return logosFound;
    }

    public void setLogosFound(int logosFound) {
        this.logosFound = logosFound;
    }

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

    @Override
    public String toString() {
        return "UserLevel{" +
                "id=" + id +
                ", points=" + points +
                ", logosFound=" + logosFound +
                ", opened=" + opened +
                '}';
    }
}
