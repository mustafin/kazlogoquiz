package flat56.kazlogoquiz.domain;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import flat56.kazlogoquiz.AppConsts;
import flat56.kazlogoquiz.domain.models.Level;
import flat56.kazlogoquiz.domain.models.Logo;
import flat56.kazlogoquiz.domain.persistable.DataStateHandler;

/**
 * Created by MusMB on 07.04.2016.
 */
public class DataParser {

    private static final String LEVELS_CACHE_KEY = "LEVELS_CACHE";
    private static DataParser instance;
    private Context context;
    private Map<String, List<Level>> levelsCache = new ConcurrentHashMap<>();
    private DataStateHandler dataStateHandler;

    private DataParser() {
    }

    public static DataParser getInstance(Context context) {

        if (instance == null) {
            instance = new DataParser();
        }
        instance.setContext(context.getApplicationContext());
        instance.setDataStateHandler(DataStateHandler.getInstance(context));
        return instance;
    }

    private Reader readFile() throws IOException {
        AssetManager assetManager = context.getAssets();
        InputStream ims = assetManager.open(AppConsts.DATA_FILE);

        return new InputStreamReader(ims);
    }

    public List<Level> getLevels() {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Level>>() {}.getType();

        List<Level> gsonObj;
        try {
            gsonObj = gson.fromJson(readFile(), listType);
        } catch (IOException e) {
            Log.i(DataParser.class.getName(), e.getMessage());
            return null;
        }

        for (Level level : gsonObj) {
            List<Logo> logos = level.getLogos();
            for (int i = 0; i < logos.size(); i++) {
                Logo logo = logos.get(i);
                logo.setLevel(level);
            }
        }

        return gsonObj;
    }

    public List<Level> getCachedLevels() {
        if (!levelsCache.containsKey(LEVELS_CACHE_KEY)) {
            List<Level> levels = getLevels();
            if (levels != null) levelsCache.put(LEVELS_CACHE_KEY, levels);
            else return Collections.emptyList();
        }

        List<Level> levels = levelsCache.get(LEVELS_CACHE_KEY);
        for (Level level : levels) {
            level.setPoints(dataStateHandler.getLevelPoints(level.getId()));

            List<Logo> logos = level.getLogos();
            int answeredCount = 0;
            for (int i = 0; i < logos.size(); i++) {
                Logo logo = logos.get(i);
                logo.setLevel(level);
                boolean logoAnswered = dataStateHandler.isAnsweredLogo(logo.getId());
                logo.setAnswered(logoAnswered);
                if(logoAnswered) answeredCount++;
            }
            level.setLogosFound(answeredCount);
            level.setOpened(dataStateHandler.isOpenedLevel(level.getId()));

        }

        return levels;
    }



    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setDataStateHandler(DataStateHandler dataStateHandler) {
        this.dataStateHandler = dataStateHandler;
    }
}
