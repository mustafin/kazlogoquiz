package flat56.kazlogoquiz.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.Arrays;

import flat56.kazlogoquiz.R;
import flat56.kazlogoquiz.activities.adapters.LevelsAdapter;
import flat56.kazlogoquiz.entities.Level;

/**
 * Created by Murat on 27.01.2015.
 */
public class LevelsActivity extends ActionBarActivity {

    ListView list;
    LevelsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.levels);


        adapter = new LevelsAdapter(this, R.layout.row, Arrays.asList(new Level(), new Level(), new Level()));
        list = (ListView)findViewById(R.id.list);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(LevelsActivity.this, LogosActivity.class);
                startActivity(intent);
            }
        });



    }
}
