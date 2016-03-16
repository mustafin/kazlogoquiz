package flat56.kazlogoquiz.models;

/**
 * Created by Murat on 31.01.2015.
 */
public class Level {

    private int points;
    private int logosFound;
    private int logosCount;

    public Level(int points, int logosFound, int logosCount) {
        this.points = points;
        this.logosFound = logosFound;
        this.logosCount = logosCount;
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
}
