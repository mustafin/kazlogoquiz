package flat56.kazlogoquiz.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.widget.GridView;
import android.widget.Toast;

import java.util.List;

import flat56.kazlogoquiz.R;
import flat56.kazlogoquiz.activities.adapters.LogosAdapter;
import flat56.kazlogoquiz.domain.models.Level;
import flat56.kazlogoquiz.domain.models.Logo;
import flat56.kazlogoquiz.utils.DataUtils;

/**
 * Created by Murat on 31.01.2015.
 */
public class LogosActivity extends BaseActivity{

    public static String LEVEL_EXTRA = "LEVEL_EXTRA";
    private GridView grid;
    private LogosAdapter adapter;
    private Level curLevel;
    private int itemId;

    private List<Level> data;

    @Override
    @LayoutRes
    protected int contentView() {
        return R.layout.logos;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        data = getLevels();

        if(savedInstanceState != null){
            itemId = savedInstanceState.getInt(LEVEL_EXTRA);
            curLevel = DataUtils.findLevel(data, itemId);
        }

        itemId = getIntent().getIntExtra(LEVEL_EXTRA, -1);
        if(itemId != -1)
            curLevel = DataUtils.findLevel(data, itemId);

        if(curLevel == null)
            Toast.makeText(LogosActivity.this, "No Such Level", Toast.LENGTH_SHORT).show();
        else {
            grid = (GridView) findViewById(R.id.logos);
            adapter = new LogosAdapter(this, R.layout.logo_cell, curLevel.getLogos());
            grid.setAdapter(adapter);
            grid.setOnItemClickListener(((parent, view, position, id) -> {
                Logo item = adapter.getItem(position);
                Intent intent = new Intent(LogosActivity.this, GameActivity.class);
                intent.putExtra(GameActivity.LOGO_EXTRA, item.getId());
                intent.putExtra(LEVEL_EXTRA, itemId);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }));
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(LEVEL_EXTRA, itemId);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        itemId = savedInstanceState.getInt(LEVEL_EXTRA);
        curLevel = DataUtils.findLevel(data, itemId);
    }

}
