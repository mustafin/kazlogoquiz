package flat56.kazlogoquiz.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import flat56.kazlogoquiz.AppConsts;
import flat56.kazlogoquiz.R;
import flat56.kazlogoquiz.activities.adapters.LevelsAdapter;
import flat56.kazlogoquiz.activities.asynctasks.LoadLevelsAsync;
import flat56.kazlogoquiz.domain.models.Level;


/**
 * Created by Murat on 27.01.2015.
 */
public class LevelsActivity extends BaseActivity {

    private ListView list;
    private LevelsAdapter adapter;

    @Override
    @LayoutRes
    protected int contentView() {
        return R.layout.levels;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new LevelsAdapter(this, R.layout.row, new ArrayList<>());
        list = (ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(LevelsActivity.this, LogosActivity.class);
            Level item = adapter.getItem(position);
            intent.putExtra(LogosActivity.LEVEL_EXTRA, item.getId());
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        LoadLevelsAsync loadLevels = new LoadLevelsAsync(this,
        list -> {

            setLeftToOpenNextLevel(list);

            adapter.clear();
            adapter.addAll(list);
            adapter.notifyDataSetChanged();
        });
        loadLevels.execute();
    }

    public void setLeftToOpenNextLevel(List<Level> data){
        int curFound = 0;
        int curTotal = 0;
        int toOpen = 0;
        int left = 0;
        data.get(0).setOpened(true);
        for (int i = 1; i < data.size(); i++) {
            Level prev = data.get(i - 1);
            Level cur = data.get(i);
            curFound += prev.getLogosFound();
            curTotal += prev.getLogos().size();

            toOpen = curTotal * AppConsts.PERCENTS_FOUND_TO_OPEN / 100;
            if(curFound < toOpen) left = toOpen - curFound;
            else if(!cur.isOpened()) {
                cur.setOpened(true);
            }
            cur.setLeftToOpen(left);
        }

    }
}
