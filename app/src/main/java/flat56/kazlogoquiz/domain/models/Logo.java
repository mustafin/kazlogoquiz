package flat56.kazlogoquiz.domain.models;

/**
 * Created by Murat on 31.01.2015.
 */
public class Logo {

    private int id;
    private String path;
    private String pathComplete;
    private String correctRu;
    private String correctKz;
    private String charsRu;
    private String charsKz;
    private String descriptionRu;
    private String descriptionKz;
    private int points;
    private boolean answered;

    private Level level;

    public Logo(int id, String path, String pathComplete, String correctRu, String correctKz, String charsRu, String charsKz, String descriptionRu, String descriptionKz) {
        this.path = path;
        this.pathComplete = pathComplete;
        this.correctRu = correctRu;
        this.correctKz = correctKz;
        this.charsRu = charsRu;
        this.charsKz = charsKz;
        this.descriptionRu = descriptionRu;
        this.descriptionKz = descriptionKz;
        this.id = id;

    }

    public Logo(int id, String path, String pathComplete, String correctRu, String correctKz,
                String charsRu, String charsKz, String descriptionRu, String descriptionKz, int points) {
        this.path = path;
        this.pathComplete = pathComplete;
        this.correctRu = correctRu;
        this.correctKz = correctKz;
        this.charsRu = charsRu;
        this.charsKz = charsKz;
        this.descriptionRu = descriptionRu;
        this.descriptionKz = descriptionKz;
        this.points = points;
        this.id = id;
    }

    public Logo(int id, String path, String pathComplete, String correctRu, String correctKz,
                String charsRu, String charsKz, String descriptionRu,String descriptionKz,  int points, boolean answered) {
        this.path = path;
        this.pathComplete = pathComplete;
        this.correctRu = correctRu;
        this.correctKz = correctKz;
        this.charsRu = charsRu;
        this.charsKz = charsKz;
        this.descriptionRu = descriptionRu;
        this.descriptionKz = descriptionKz;
        this.points = points;
        this.answered = answered;
        this.id = id;
    }

    public Logo() {
    }

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

    public String getChars() {
        //TODO LOCALE
//        return Locale.getDefault()
        return charsRu;
    }


    public String getCorrect() {
        return correctRu;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getDescriptionRu() {
        return descriptionRu;
    }

    public void setDescriptionRu(String description) {
        this.descriptionRu = description;
    }

    public String getDescription() {
        return descriptionRu;
    }

    public boolean isAnswered() {
        return answered;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getPathComplete() {
        return pathComplete;
    }

    public void setPathComplete(String pathComplete) {
        this.pathComplete = pathComplete;
    }

    @Override
    public String toString() {
        return "Logo{" +
                "path='" + path + '\'' +
                ", pathComplete='" + pathComplete + '\'' +
                ", correctRu='" + correctRu + '\'' +
                ", charsRu='" + charsRu + '\'' +
                ", descriptionRu='" + descriptionRu + '\'' +
                ", points=" + points +
                ", answered=" + answered +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescriptionKz() {
        return descriptionKz;
    }

    public void setDescriptionKz(String descriptionKz) {
        this.descriptionKz = descriptionKz;
    }
}
