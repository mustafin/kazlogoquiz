package flat56.kazlogoquiz.domain.models;

import android.app.Activity;

import flat56.kazlogoquiz.domain.persistable.DataStateHandler;

/**
 * Created by MusMB on 12.04.2016.
 */
public class DescHint extends Hint{

    private static final int COST = 8;

    public DescHint(Activity activity) {
        super(activity);
    }

    @Override
    public int cost() {
        return COST;
    }

    @Override
    protected void onUse() {

    }

    @Override
    protected void onSave(DataStateHandler handler) {

    }

}
