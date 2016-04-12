package flat56.kazlogoquiz.domain.models;

import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;

import flat56.kazlogoquiz.R;
import flat56.kazlogoquiz.activities.asynctasks.SideFunction;
import flat56.kazlogoquiz.domain.persistable.DataStateHandler;

/**
 * Created by MusMB on 16.03.2016.
 */
public abstract class Hint {

    protected Context context;
    private DataStateHandler stateHandler;

    /**
     * Resources
     */
    private String defaultDialogTitle;
    private String defaultDialogDesc;
    private String notEnoughPoints;
    private String positive;
    private String negative;

    public Hint(Context context) {
        this.context = context.getApplicationContext();
        this.stateHandler = DataStateHandler.getInstance(context);
    }

    public void use(int points, SideFunction<Boolean> onComplete) {
        if (points < cost()) {
            notEnoughDialog(defaultDialogTitle, notEnoughPoints).show();
        } else {
            hintDialog(defaultDialogTitle, defaultDialogDesc).onPositive((dialog, which) -> {
                onUse();
                onSave(stateHandler);
                onComplete.apply(true);
            }).onNegative((dialog1, which1) -> {
                onComplete.apply(false);
            }).show();
        }
    }

    protected MaterialDialog.Builder hintDialog(String title, String desc) {
        if (!resourcesInitialized()) initResources();
        MaterialDialog.Builder builder = new MaterialDialog.Builder(context);
        builder.title(title).content(desc)
                .positiveText(positive).negativeText(negative);
        return builder;
    }

    protected MaterialDialog.Builder notEnoughDialog(String title, String desc) {
        if (!resourcesInitialized()) initResources();
        MaterialDialog.Builder builder = new MaterialDialog.Builder(context);
        builder.title(title).content(desc)
                .positiveText(positive);
        return builder;
    }


    private void initResources() {
        defaultDialogTitle = context.getString(R.string.default_hint_title);
        defaultDialogDesc = context.getString(R.string.default_hint_desc, cost());
        notEnoughPoints = context.getString(R.string.not_enough_ponts);
        positive = context.getString(R.string.yes);
        negative = context.getString(R.string.no);
    }

    private boolean resourcesInitialized() {
        return defaultDialogTitle != null && defaultDialogDesc != null
                && notEnoughPoints != null && positive != null && negative != null;
    }

    /**
     * @return Amount of points costs
     */
    public abstract int cost();

    protected abstract void onUse();

    protected abstract void onSave(DataStateHandler handler);

}
