package flat56.kazlogoquiz.activities.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import flat56.kazlogoquiz.R;
import flat56.kazlogoquiz.models.Level;

/**
 * Created by Murat on 31.01.2015.
 */
public class LevelsAdapter extends ArrayAdapter<Level> {

    private List<Level> levels;
    private Context context;

    public LevelsAdapter(Context context, int resource, List<Level> objects) {
        super(context, resource, objects);
        this.context = context;
        levels = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Level level = levels.get(position);

        if (convertView == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            if(getItemViewType(position) == 0)
                convertView = inflater.inflate(R.layout.row, parent, false);
            else
                convertView = inflater.inflate(R.layout.row_locked, parent, false);
        }

        TextView title = (TextView) convertView.findViewById(R.id.levelTitle);

        String levelString = context.getResources().getString(R.string.level);
        title.setText(String.format(Locale.getDefault(), "%s %d", levelString, level.getId()));

        if(level.isOpened()) {
            ProgressBar progress = (ProgressBar) convertView.findViewById(R.id.progressBar);
            TextView progressText = (TextView) convertView.findViewById(R.id.progressText);
            progress.setProgress(level.getLogosFound() * 100 / level.getLogosCount());
            progressText.setText(String.format(
                    Locale.getDefault(),
                    "%d / %d",
                    level.getLogosFound(),
                    level.getLogosCount())
            );
        }
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        // Define a way to determine which layout to use, here it's just evens and odds.
        return isEnabled(position) ? 0 : 1;
    }

    @Override
    public int getViewTypeCount() {
        return 2; // Count of different layouts
    }

    @Override
    public boolean isEnabled(int position) {
        return levels.get(position).isOpened();
    }

    @Override
    public Level getItem(int position) {
        return levels.get(position);
    }
}
