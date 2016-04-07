package flat56.kazlogoquiz.utils;

import com.annimon.stream.Stream;

import java.util.List;

import flat56.kazlogoquiz.domain.models.Level;
import flat56.kazlogoquiz.domain.models.Logo;

/**
 * Created by MusMB on 07.04.2016.
 */
public class DataUtils {

    public static Level findLevel(List<Level> data, int levelId) {
        return Stream.of(data).filter(l -> l.getId() == levelId).findFirst().orElse(null);
    }

    public static Logo findLogo(List<Level> data, int levelId, int logoId) {
        Level level = Stream.of(data).filter(l -> l.getId() == levelId).findFirst().orElse(null);
        if (level == null) return null;
        else
            return Stream.of(level.getLogos()).filter(logo -> logo.getId() == logoId).findFirst().orElse(null);
    }

    public static Logo findLogoByPosition(List<Level> data, int levelPosition, int logoPosition) {
        Level level = data.get(levelPosition);
        if (level == null) return null;
        else return level.getLogos() == null ? null : level.getLogos().get(logoPosition);
    }

    public static Logo findLogo(List<Level> data, int logoId) {
        for (Level level : data) {
            List<Logo> logos = level.getLogos();
            for (int i = 0; i < logos.size(); i++) {
                if (logos.get(i).getId() == logoId) {
                    return logos.get(i);
                }
            }
        }
        return null;
    }

}
