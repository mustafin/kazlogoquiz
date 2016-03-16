package flat56.kazlogoquiz.models;

/**
 * Created by Murat on 31.01.2015.
 */
public class Logo {

    private String path;
    private String correctRu;
    private String correctKz;
    private String charsRu;
    private String charsKz;
    private int points;

    public Logo(String path, String correctRu, String correctKz, String charsRu, String charsKz) {
        this.path = path;
        this.correctRu = correctRu;
        this.correctKz = correctKz;
        this.charsRu = charsRu;
        this.charsKz = charsKz;
    }

    public Logo(String path, String correctRu, String correctKz, String charsRu, String charsKz, int points) {
        this.path = path;
        this.correctRu = correctRu;
        this.correctKz = correctKz;
        this.charsRu = charsRu;
        this.charsKz = charsKz;
        this.points = points;
    }

    public Logo(){}

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCorrectRu() {
        return correctRu;
    }

    public void setCorrectRu(String correctRu) {
        this.correctRu = correctRu;
    }

    public String getCorrectKz() {
        return correctKz;
    }

    public void setCorrectKz(String correctKz) {
        this.correctKz = correctKz;
    }

    public String getCharsRu() {
        return charsRu;
    }

    public void setCharsRu(String charsRu) {
        this.charsRu = charsRu;
    }

    public String getCharsKz() {
        return charsKz;
    }

    public void setCharsKz(String charsKz) {
        this.charsKz = charsKz;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
