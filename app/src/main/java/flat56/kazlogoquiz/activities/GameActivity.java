package flat56.kazlogoquiz.activities;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;

import java.util.List;
import java.util.Locale;

import flat56.kazlogoquiz.R;
import flat56.kazlogoquiz.activities.fragments.DescFragment;
import flat56.kazlogoquiz.activities.fragments.GameFragment;
import flat56.kazlogoquiz.activities.fragments.OnFragmentInteractionListener;
import flat56.kazlogoquiz.domain.models.DescHint;
import flat56.kazlogoquiz.domain.models.Level;
import flat56.kazlogoquiz.domain.models.Logo;
import flat56.kazlogoquiz.utils.DataUtils;

public class GameActivity extends BaseActivity implements OnFragmentInteractionListener{

    public static String LOGO_EXTRA = "LOGO_EXTRA";
    private int levelId;
    private int logoId;
    private Logo logo;
    private List<Level> data;
    private TextView total;

    @Override
    @LayoutRes
    protected int contentView() {
        return R.layout.activity_game;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        total = (TextView) findViewById(R.id.total_tenge);

        data = getLevels();

        if(getIntent().getExtras() != null){
            Bundle bundle = getIntent().getExtras();
            levelId = bundle.getInt(LogosActivity.LEVEL_EXTRA);
            logoId = bundle.getInt(LOGO_EXTRA);
            logo = DataUtils.findLogo(data, levelId, logoId);
        }else if(savedInstanceState != null){
            levelId = savedInstanceState.getInt(LogosActivity.LEVEL_EXTRA);
            logoId = savedInstanceState.getInt(LOGO_EXTRA);
            logo = DataUtils.findLogo(data, levelId, logoId);
        }
        if(logo == null) throw new IllegalArgumentException("NO LOGO FOUND");

        Fragment gameFragment = null;
        if (logo.isAnswered()) {
            gameFragment = DescFragment.newInstance(levelId, logoId);
        }else{
            gameFragment = GameFragment.newInstance(levelId, logoId);
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment, gameFragment);
        transaction.commit();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(LogosActivity.LEVEL_EXTRA, levelId);
        outState.putInt(LOGO_EXTRA, logoId);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState != null) {
            levelId = savedInstanceState.getInt(LogosActivity.LEVEL_EXTRA);
            logoId = savedInstanceState.getInt(LOGO_EXTRA);
        }
    }

    @Override
    public void onFragmentAction() {
        DescFragment descFragment = DescFragment.newInstance(levelId, logoId);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out);
        transaction.replace(R.id.fragment, descFragment);
        transaction.commit();
        total.setText(String.format(Locale.getDefault(), "%d", getTotal()));
    }

    public void goBack(View v){
        super.onBackPressed();
    }


}


