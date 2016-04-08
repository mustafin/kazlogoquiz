package flat56.kazlogoquiz.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;

import java.util.ArrayList;
import java.util.List;

import flat56.kazlogoquiz.Dummy;
import flat56.kazlogoquiz.R;
import flat56.kazlogoquiz.activities.adapters.DirectoryAdapter;
import flat56.kazlogoquiz.domain.models.Level;
import flat56.kazlogoquiz.domain.models.Logo;

public class DirectoryActivity extends BaseActivity {

    @Override
    @LayoutRes
    protected int contentView() {
        return R.layout.activity_directory;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar != null)
            toolbar.setBackgroundColor(getResources().getColor(R.color.main_green));

        ListView listView = (ListView) findViewById(R.id.listView);

        List<Logo> allLogos = new ArrayList<>();


        for (Level level : getLevels()) {
            allLogos.addAll(level.getLogos());
        }
        List<Logo> logos = Stream.of(allLogos)
                .filter(Logo::isAnswered)
                .sortBy(l -> l.getCorrect().toUpperCase())
                .collect(Collectors.toList());

        DirectoryAdapter adapter = new DirectoryAdapter(this, R.layout.directory_item, logos);
        listView.setFastScrollEnabled(true);

        TextView emptyText = (TextView) findViewById(R.id.empty_text);
        listView.setEmptyView(emptyText);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Logo item = adapter.getItem(position);
            Intent intent = new Intent(DirectoryActivity.this, GameActivity.class);
            intent.putExtra(GameActivity.LOGO_EXTRA, item.getId());
            intent.putExtra(LogosActivity.LEVEL_EXTRA, item.getLevel().getId());
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

        });
    }
}
