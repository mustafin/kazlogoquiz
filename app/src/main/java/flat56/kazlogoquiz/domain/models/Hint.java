package flat56.kazlogoquiz.domain.models;

import android.content.Context;
import android.content.SharedPreferences;

import flat56.kazlogoquiz.AppConsts;

/**
 * Created by MusMB on 16.03.2016.
 */
public abstract class Hint {


    public void use(Context context){
        SharedPreferences preferences = context.getSharedPreferences(AppConsts.MY_PREFS_NAME, Context.MODE_PRIVATE);

    }

    private void saveUsed(String name){

    }

    protected abstract String getHintType();

}
