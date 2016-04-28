package flat56.kazlogoquiz.domain.models;

import android.app.Activity;

import com.afollestad.materialdialogs.MaterialDialog;

import flat56.kazlogoquiz.R;
import flat56.kazlogoquiz.activities.asynctasks.SideFunction;
import flat56.kazlogoquiz.domain.persistable.DataStateHandler;

/**
 * Created by MusMB on 16.03.2016.
 */
public abstract class Hint {

    protected final Logo logo;
    protected Activity activity;
    private DataStateHandler stateHandler;

    /**
     * Resources
     */
    private String defaultDialogTitle;
    private String defaultDialogDesc;
    private String notEnoughPoints;
    private String positive;
    private String negative;

    public Hint(Activity activity, Logo logo) {
        this.activity = activity;
        this.logo = logo;
        this.stateHandler = DataStateHandler.getInstance(this.activity);
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
        MaterialDialog.Builder builder = new MaterialDialog.Builder(activity);
        builder.title(title).content(desc)
                .positiveText(positive).negativeText(negative);
        return builder;
    }

    protected MaterialDialog.Builder notEnoughDialog(String title, String desc) {
        if (!resourcesInitialized()) initResources();
        MaterialDialog.Builder builder = new MaterialDialog.Builder(activity);
        builder.title(title).content(desc)
                .positiveText(positive);
        return builder;
    }


    private void initResources() {
        defaultDialogTitle = activity.getString(R.string.default_hint_title);
        defaultDialogDesc = activity.getString(R.string.default_hint_desc, cost());
        notEnoughPoints = activity.getString(R.string.not_enough_ponts);
        positive = activity.getString(R.string.yes);
        negative = activity.getString(R.string.no);
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
