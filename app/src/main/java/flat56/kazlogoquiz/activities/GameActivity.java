package flat56.kazlogoquiz.activities;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.annimon.stream.Stream;
import com.annimon.stream.function.Consumer;

import java.util.Arrays;
import java.util.Locale;

import flat56.kazlogoquiz.Dummy;
import flat56.kazlogoquiz.R;
import flat56.kazlogoquiz.activities.adapters.AnswerGridAdapter;
import flat56.kazlogoquiz.models.Logo;

public class GameActivity extends AppCompatActivity {

    public static String LOGO_EXTRA = "LOGO_EXTRA";
    private Logo logo;
    private int levelPos;
    private int logoPos;
    private ImageView imageLogo;
    private GridView answerGrid;
    private GridView charsGrid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        imageLogo = (ImageView) findViewById(R.id.imageLogo);
        answerGrid = (GridView) findViewById(R.id.answer_grid);
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

        fillData();

    }

    public void fillData(){
        imageLogo.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_launcher));
        AnswerGridAdapter adapter = new AnswerGridAdapter(this, logo.getChars());
        answerGrid.setAdapter(adapter);





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
        levelPos = savedInstanceState.getInt(LogosActivity.LEVEL_EXTRA);
        logoPos = savedInstanceState.getInt(LOGO_EXTRA);
        fillData();
    }

}
