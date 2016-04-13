package flat56.kazlogoquiz.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.widget.GridView;

import java.util.ArrayList;

import flat56.kazlogoquiz.R;
import flat56.kazlogoquiz.activities.adapters.LogosAdapter;
import flat56.kazlogoquiz.activities.asynctasks.LoadLevelsAsync;
import flat56.kazlogoquiz.domain.models.Level;
import flat56.kazlogoquiz.domain.models.Logo;
import flat56.kazlogoquiz.utils.DataUtils;

/**
 * Created by Murat on 31.01.2015.
 */
public class LogosActivity extends BaseActivity {

    public static String LEVEL_EXTRA = "LEVEL_EXTRA";
    private GridView grid;
    private LogosAdapter adapter;
    private Level curLevel;
    private int itemId;

    @Override
    @LayoutRes
    protected int contentView() {
        return R.layout.logos;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        itemId = getIntent().getIntExtra(LEVEL_EXTRA, -1);

        if (savedInstanceState != null) {
            itemId = savedInstanceState.getInt(LEVEL_EXTRA);
        }



        grid = (GridView) findViewById(R.id.logos);
        adapter = new LogosAdapter(this, R.layout.logo_cell, new ArrayList<>());

        grid.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        grid.setOnItemClickListener(((parent, view, position, id) -> {
            Logo item = adapter.getItem(position);
            Intent intent = new Intent(LogosActivity.this, GameActivity.class);
            intent.putExtra(GameActivity.LOGO_EXTRA, item.getId());
            intent.putExtra(LEVEL_EXTRA, itemId);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

        }));

        LoadLevelsAsync loadLogos = new LoadLevelsAsync(this,
                list -> {
                    curLevel = DataUtils.findLevel(list, itemId);
                    adapter.clear();
                    adapter.addAll(curLevel.getLogos());
                    adapter.notifyDataSetChanged();
                }
        );
        loadLogos.execute();

    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(LEVEL_EXTRA, itemId);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        itemId = savedInstanceState.getInt(LEVEL_EXTRA);
    }

}
