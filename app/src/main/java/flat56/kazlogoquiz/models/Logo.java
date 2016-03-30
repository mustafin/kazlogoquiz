package flat56.kazlogoquiz.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Created by Murat on 31.01.2015.
 */
public class Logo {

    private String path;
    private String correctRu;
    private String correctKz;
    private String charsRu;
    private String charsKz;
    private String description;
    private int points;
    private boolean answered;

    private int levelId = 1;

    public Logo(String path, String correctRu, String correctKz, String charsRu, String charsKz, String description) {
        this.path = path;
        this.correctRu = correctRu;
        this.correctKz = correctKz;
        this.charsRu = charsRu;
        this.charsKz = charsKz;
        this.description = description;
    }

    public Logo(String path, String correctRu, String correctKz,
                String charsRu, String charsKz, String description, int points) {
        this.path = path;
        this.correctRu = correctRu;
        this.correctKz = correctKz;
        this.charsRu = charsRu;
        this.charsKz = charsKz;
        this.description = description;
        this.points = points;
    }

    public Logo(String path, String correctRu, String correctKz,
                String charsRu, String charsKz, String description, int points, boolean answered) {
        this.path = path;
        this.correctRu = correctRu;
        this.correctKz = correctKz;
        this.charsRu = charsRu;
        this.charsKz = charsKz;
        this.description = description;
        this.points = points;
        this.answered = answered;
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

    public String getChars(){
        //TODO LOCALE
//        return Locale.getDefault()
        return charsRu;
    }


    public String getCorrect(){
        return correctRu;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAnswered() {
        return answered;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }
}
