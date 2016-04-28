package flat56.kazlogoquiz.domain.models;

import android.app.Activity;

import flat56.kazlogoquiz.activities.views.AnswerGrid;
import flat56.kazlogoquiz.domain.persistable.DataStateHandler;

/**
 * Created by MusMB on 12.04.2016.
 */
public class OpenHint extends Hint {

    private static final int COST = 8;
    public static final String HINT_PREFIX = "open";
    private AnswerGrid answerGrid;

    public OpenHint(Activity activity, Logo logo, AnswerGrid answerGrid) {
        super(activity, logo);
        this.answerGrid = answerGrid;
    }

    @Override
    public int cost() {
        return COST;
    }

    @Override
    protected void onUse() {
        //TODO SWAP ONCLICKLISTENERS ON ANSWERGRID
    }

    @Override
    protected void onSave(DataStateHandler handler) {

    }
}
