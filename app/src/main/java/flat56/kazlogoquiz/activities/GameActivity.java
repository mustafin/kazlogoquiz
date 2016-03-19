package flat56.kazlogoquiz.activities;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        imageLogo = (ImageView) findViewById(R.id.imageLogo);
        answerGridCont = (LinearLayout) findViewById(R.id.answer_grid);
        charsGrid = (GridView) findViewById(R.id.characters_grid);


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
        imageLogo.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_launcher));
        answerGrid.initAndaddTo(answerGridCont);


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

}
