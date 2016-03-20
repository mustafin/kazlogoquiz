package flat56.kazlogoquiz.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import flat56.kazlogoquiz.R;


public class MainActivity extends Activity {

    private Button play;
    private ImageButton dict;
    private ImageButton share;
    private ImageButton like;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dict = (ImageButton) findViewById(R.id.dict);
        share = (ImageButton) findViewById(R.id.share);
        like = (ImageButton) findViewById(R.id.like);

        int color_blue = getResources().getColor(R.color.main_blue);
        int color_violet = getResources().getColor(R.color.main_violet);
        ((GradientDrawable)share.getBackground().getCurrent()).setColor(color_blue);
        ((GradientDrawable)like.getBackground().getCurrent()).setColor(color_violet);





        play = (Button)findViewById(R.id.play);
        play.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LevelsActivity.class);
            startActivity(intent);
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
