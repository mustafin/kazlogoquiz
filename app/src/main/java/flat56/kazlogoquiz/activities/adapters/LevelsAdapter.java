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
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.row, parent, false);
        }

        Level level = levels.get(position);
        TextView title = (TextView) convertView.findViewById(R.id.levelTitle);
        ProgressBar progress = (ProgressBar) convertView.findViewById(R.id.progressBar);
        TextView progressText = (TextView) convertView.findViewById(R.id.progressText);

        String levelString = context.getResources().getString(R.string.level);
        title.setText(String.format(Locale.getDefault(), "%s %d", levelString, level.getId()));
        progress.setProgress(level.getLogosFound() * 100 / level.getLogosCount());
        progressText.setText(String.format(
                Locale.getDefault(),
                "%d / %d",
                level.getLogosFound(),
                level.getLogosCount())
        );
        return convertView;
    }

    @Override
    public Level getItem(int position) {
        return levels.get(position);
    }
}
