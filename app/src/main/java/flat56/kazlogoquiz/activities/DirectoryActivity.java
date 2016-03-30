package flat56.kazlogoquiz.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;

import java.util.List;

import flat56.kazlogoquiz.Dummy;
import flat56.kazlogoquiz.R;
import flat56.kazlogoquiz.activities.adapters.DirectoryAdapter;
import flat56.kazlogoquiz.activities.adapters.LevelsAdapter;
import flat56.kazlogoquiz.models.Logo;

public class DirectoryActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory);
        ListView listView = (ListView) findViewById(R.id.listView);

        List<Logo> logos = Stream.of(Dummy.moreLogos).filter(Logo::isAnswered).sortBy(l -> l.getCorrect().toUpperCase()).collect(Collectors.toList());


        DirectoryAdapter adapter = new DirectoryAdapter(this, R.layout.directory_item, logos);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Logo item = adapter.getItem(position);
            Intent intent = new Intent(DirectoryActivity.this, GameActivity.class);
            intent.putExtra(GameActivity.LOGO_EXTRA, position);
            intent.putExtra(LogosActivity.LEVEL_EXTRA, item.getLevelId());
            startActivity(intent);
        });
    }
}
