package flat56.kazlogoquiz.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.GridView;

import java.util.Arrays;

import flat56.kazlogoquiz.R;
import flat56.kazlogoquiz.activities.adapters.LogosAdapter;
import flat56.kazlogoquiz.models.Logo;

/**
 * Created by Murat on 31.01.2015.
 */
public class LogosActivity extends ActionBarActivity {

    private GridView grid;
    private LogosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logos);

        grid = (GridView)findViewById(R.id.logos);
        adapter = new LogosAdapter(this, R.layout.logo_cell, Arrays.asList(new Logo(), new Logo(), new Logo(), new Logo(), new Logo(), new Logo(), new Logo(), new Logo(), new Logo(), new Logo(), new Logo()));
        grid.setAdapter(adapter);

    }
}
