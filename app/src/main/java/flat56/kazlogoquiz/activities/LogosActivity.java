package flat56.kazlogoquiz.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.Toast;

import java.util.Arrays;

import flat56.kazlogoquiz.Dummy;
import flat56.kazlogoquiz.R;
import flat56.kazlogoquiz.activities.adapters.LogosAdapter;
import flat56.kazlogoquiz.models.Level;
import flat56.kazlogoquiz.models.Logo;

/**
 * Created by Murat on 31.01.2015.
 */
public class LogosActivity extends AppCompatActivity{

    public static String ITEM_EXTRA = "ITEM_EXTRA";
    private GridView grid;
    private LogosAdapter adapter;
    private Level curLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logos);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int itemId = extras.getInt(ITEM_EXTRA);
            curLevel = Dummy.levelList.get(itemId);
        }

        if(curLevel == null)
            Toast.makeText(LogosActivity.this, "No Such Level", Toast.LENGTH_SHORT).show();
        else {

            grid = (GridView) findViewById(R.id.logos);
            adapter = new LogosAdapter(this, R.layout.logo_cell, curLevel.getLogos());
            grid.setAdapter(adapter);
        }

    }
}
