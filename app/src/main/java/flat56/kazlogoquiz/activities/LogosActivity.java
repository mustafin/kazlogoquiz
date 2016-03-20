package flat56.kazlogoquiz.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

import flat56.kazlogoquiz.Dummy;
import flat56.kazlogoquiz.R;
import flat56.kazlogoquiz.activities.adapters.LogosAdapter;
import flat56.kazlogoquiz.models.Level;

/**
 * Created by Murat on 31.01.2015.
 */
public class LogosActivity extends AppCompatActivity{

    public static String LEVEL_EXTRA = "LEVEL_EXTRA";
    private GridView grid;
    private LogosAdapter adapter;
    private Level curLevel;
    private int itemPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logos);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        if(savedInstanceState != null){
            itemPos = savedInstanceState.getInt(LEVEL_EXTRA);
            curLevel = Dummy.levelList.get(itemPos);
        }

        itemPos = getIntent().getIntExtra(LEVEL_EXTRA, -1);
        if(itemPos != -1)
            curLevel = Dummy.levelList.get(itemPos);

        if(curLevel == null)
            Toast.makeText(LogosActivity.this, "No Such Level", Toast.LENGTH_SHORT).show();
        else {
            grid = (GridView) findViewById(R.id.logos);
            adapter = new LogosAdapter(this, R.layout.logo_cell, curLevel.getLogos());
            grid.setAdapter(adapter);
            grid.setOnItemClickListener(((parent, view, position, id) -> {
                Intent intent = new Intent(LogosActivity.this, GameActivity.class);
                intent.putExtra(GameActivity.LOGO_EXTRA, position);
                startActivity(intent);

            }));
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(LEVEL_EXTRA, itemPos);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        itemPos = savedInstanceState.getInt(LEVEL_EXTRA);
        curLevel = Dummy.levelList.get(itemPos);
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
