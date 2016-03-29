package flat56.kazlogoquiz.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import flat56.kazlogoquiz.Dummy;
import flat56.kazlogoquiz.R;
import flat56.kazlogoquiz.activities.fragments.DescFragment;
import flat56.kazlogoquiz.activities.fragments.GameFragment;
import flat56.kazlogoquiz.activities.fragments.OnFragmentInteractionListener;
import flat56.kazlogoquiz.models.Logo;

public class GameActivity extends AppCompatActivity implements OnFragmentInteractionListener{

    public static String LOGO_EXTRA = "LOGO_EXTRA";
    private int levelPos;
    private int logoPos;
    private Logo logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        if(getIntent().getExtras() != null){
            Bundle bundle = getIntent().getExtras();
            levelPos = bundle.getInt(LogosActivity.LEVEL_EXTRA);
            logoPos = bundle.getInt(LOGO_EXTRA);
            logo = Dummy.levelList.get(levelPos).getLogos().get(logoPos);
        }else if(savedInstanceState != null){
            levelPos = savedInstanceState.getInt(LogosActivity.LEVEL_EXTRA);
            logoPos = savedInstanceState.getInt(LOGO_EXTRA);
            logo = Dummy.levelList.get(levelPos).getLogos().get(logoPos);
        }
        if(logo == null) throw new IllegalArgumentException("NO LOGO FOUND");

        Fragment gameFragment = null;
        if (logo.isAnswered()) {
            gameFragment = DescFragment.newInstance(levelPos, logoPos);
        }else{
            gameFragment = GameFragment.newInstance(levelPos, logoPos);
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment, gameFragment);
        transaction.commit();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(LogosActivity.LEVEL_EXTRA, levelPos);
        outState.putInt(LOGO_EXTRA, logoPos);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState != null) {
            levelPos = savedInstanceState.getInt(LogosActivity.LEVEL_EXTRA);
            logoPos = savedInstanceState.getInt(LOGO_EXTRA);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onFragmentAction() {
        DescFragment descFragment = DescFragment.newInstance(levelPos, logoPos);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out);
        transaction.replace(R.id.fragment, descFragment);
        transaction.commit();
    }



}


