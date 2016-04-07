package flat56.kazlogoquiz.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.widget.ListView;

import flat56.kazlogoquiz.R;
import flat56.kazlogoquiz.activities.adapters.LevelsAdapter;
import flat56.kazlogoquiz.domain.models.Level;

import static flat56.kazlogoquiz.AppConsts.MY_PREFS_NAME;

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

        adapter = new LevelsAdapter(this, R.layout.row, getLevels());
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

    private void readPrefs(){
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String restoredText = prefs.getString("text", null);
        if (restoredText != null) {
            String name = prefs.getString("name", "No name defined");//"No name defined" is the default value.
            int idName = prefs.getInt("idName", 0); //0 is the default value.
        }
    }

    private void savePrefs(){
        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString("name", "Elena");
        editor.putInt("idName", 12);

        editor.commit();
    }

}
