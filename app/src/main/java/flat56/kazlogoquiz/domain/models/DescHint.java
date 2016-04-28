package flat56.kazlogoquiz.domain.models;

import android.app.Activity;

import com.afollestad.materialdialogs.MaterialDialog;

import flat56.kazlogoquiz.R;
import flat56.kazlogoquiz.domain.persistable.DataStateHandler;

/**
 * Created by MusMB on 12.04.2016.
 */
public class DescHint extends Hint{

    private static final int COST = 8;
    public static final String HINT_PREFIX = "desc";

    public DescHint(Activity activity, Logo logo) {
        super(activity, logo);
    }

    @Override
    public int cost() {
        return COST;
    }

    @Override
    protected void onUse() {
        MaterialDialog.Builder builder = new MaterialDialog.Builder(activity);
        builder.title(activity.getString(R.string.desc_title)).content(logo.getDescription())
                .positiveText(activity.getString(R.string.yes));
    }

    @Override
    protected void onSave(DataStateHandler handler) {
        handler.saveHintUsed(logo.getId(), HINT_PREFIX);
    }

}
