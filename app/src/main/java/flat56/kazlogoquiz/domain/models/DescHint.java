package flat56.kazlogoquiz.domain.models;

import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;

import flat56.kazlogoquiz.domain.persistable.DataStateHandler;

/**
 * Created by MusMB on 12.04.2016.
 */
public class DescHint extends Hint{

    private static final int COST = 8;



    public DescHint(Context context) {
        super(context);
    }

    @Override
    public int cost() {
        return 0;
    }

    @Override
    protected void onUse() {

    }

    @Override
    protected void onSave(DataStateHandler handler) {

    }
}
