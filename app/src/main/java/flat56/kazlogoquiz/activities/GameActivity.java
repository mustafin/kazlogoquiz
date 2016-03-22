package flat56.kazlogoquiz.activities;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import flat56.kazlogoquiz.Dummy;
import flat56.kazlogoquiz.R;
import flat56.kazlogoquiz.activities.adapters.CharacterGridAdapter;
import flat56.kazlogoquiz.activities.views.AnswerGrid;
import flat56.kazlogoquiz.models.Logo;

public class GameActivity extends AppCompatActivity {

    public static String LOGO_EXTRA = "LOGO_EXTRA";
    private Logo logo;
    private int levelPos;
    private int logoPos;
    private ImageView imageLogo;
    private LinearLayout answerGridCont;
    private GridView charsGrid;
    private AnswerGrid answerGrid;
    private CharacterGridAdapter characterGridAdapter;
    private LinearLayout points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }



        imageLogo = (ImageView) findViewById(R.id.imageLogo);
        answerGridCont = (LinearLayout) findViewById(R.id.answer_grid);
        charsGrid = (GridView) findViewById(R.id.characters_grid);
        points = (LinearLayout) findViewById(R.id.points);

        if(savedInstanceState != null){
            levelPos = savedInstanceState.getInt(LogosActivity.LEVEL_EXTRA);
            logoPos = savedInstanceState.getInt(LOGO_EXTRA);
            logo = Dummy.levelList.get(levelPos).getLogos().get(logoPos);
        }

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            levelPos = extras.getInt(LogosActivity.LEVEL_EXTRA);
            logoPos = extras.getInt(LOGO_EXTRA);
            logo = Dummy.levelList.get(levelPos).getLogos().get(logoPos);
        }

        answerGrid = new AnswerGrid(this, logo.getCorrect());
        characterGridAdapter = new CharacterGridAdapter(this, charsGrid, logo.getChars(), 0);
        characterGridAdapter.setAnswerGrid(answerGrid);
        answerGrid.setCharacterGridAdapter(characterGridAdapter);

        charsGrid.setAdapter(characterGridAdapter);

        fillData();

    }

    public void fillData(){
        imageLogo.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.logo_temp));
        for (int i = 0; i < logo.getPoints(); i++) {
            ImageView view = new ImageView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(5, 0, 0, 5);
            view.setLayoutParams(params);
            view.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.icon_tenge_small));
            points.addView(view);
        }
        answerGrid.initAndAddTo(answerGridCont);


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

}
