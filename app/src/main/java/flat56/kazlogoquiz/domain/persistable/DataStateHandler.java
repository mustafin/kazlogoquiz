package flat56.kazlogoquiz.domain.persistable;

import android.content.Context;
import android.content.SharedPreferences;

import flat56.kazlogoquiz.AppConsts;

/**
 * Created by MusMB on 08.04.2016.
 */
public class DataStateHandler {

    private static DataStateHandler instance;
    private SharedPreferences preferences;
    private Context context;

    private DataStateHandler(){}

    public static DataStateHandler getInstance(Context context){
        if (instance == null) {
            instance = new DataStateHandler();
        }
        instance.setContext(context.getApplicationContext());
        instance.setPreferences(context.getApplicationContext()
                .getSharedPreferences(AppConsts.MY_PREFS_NAME, Context.MODE_PRIVATE));
        return instance;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void answerLogo(int logoId){
        SharedPreferences.Editor edit = preferences.edit();
        edit.putBoolean(AppConsts.LOGO_PREFIX + logoId, true);
        edit.apply();
    }

    public void addLevelPoints(int levelId, int points){
        int userTotal = preferences.getInt(AppConsts.USER_TOTAL_SCORE, 0);
        int levelTotal = preferences.getInt(AppConsts.LEVEL_PREFIX + levelId, 0);
        userTotal += points;
        levelTotal += points;
        SharedPreferences.Editor edit = preferences.edit();
        edit.putInt(AppConsts.USER_TOTAL_SCORE, userTotal);
        edit.putInt(AppConsts.LEVEL_PREFIX + levelId, levelTotal);
        edit.apply();
    }

    public void openLevel(int levelId){
        SharedPreferences.Editor edit = preferences.edit();
        edit.putBoolean(AppConsts.LEVEL_OPENED_PREFIX + levelId, true);
        edit.apply();
    }

    public int getLevelPoints(int levelId){
        return preferences.getInt(AppConsts.LEVEL_PREFIX + levelId, 0);
    }

    public int getTotal(){
        return preferences.getInt(AppConsts.USER_TOTAL_SCORE, 0);
    }

    public boolean isAnsweredLogo(int logoId) {
        return preferences.getBoolean(AppConsts.LOGO_PREFIX + logoId, false);
    }

    public boolean isOpenedLevel(int levelId){
        return preferences.getBoolean(AppConsts.LEVEL_OPENED_PREFIX + levelId, false);
    }

    public void setPreferences(SharedPreferences preferences) {
        this.preferences = preferences;
    }
}
