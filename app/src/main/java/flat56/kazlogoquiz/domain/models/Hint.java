package flat56.kazlogoquiz.domain.models;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by MusMB on 16.03.2016.
 */
public abstract class Hint {


    public void use(Context context) {

    }

    protected abstract String getHintType();

    protected abstract void onSaveUsed(SharedPreferences preferences);

    protected abstract void onRetrieve(SharedPreferences preferences);

}
