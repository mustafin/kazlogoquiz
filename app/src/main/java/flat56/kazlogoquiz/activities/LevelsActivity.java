package flat56.kazlogoquiz.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.BaseAdapter;
import android.widget.ListView;

import flat56.kazlogoquiz.Dummy;
import flat56.kazlogoquiz.R;
import flat56.kazlogoquiz.activities.adapters.LevelsAdapter;

/**
 * Created by Murat on 27.01.2015.
 */
public class LevelsActivity extends BaseActivity {

    private ListView list;
    private LevelsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.levels);

        adapter = new LevelsAdapter(this, R.layout.row, Dummy.levelList);
        list = (ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(LevelsActivity.this, LogosActivity.class);
            intent.putExtra(LogosActivity.LEVEL_EXTRA, position);
            startActivity(intent);
        });

    }

}
