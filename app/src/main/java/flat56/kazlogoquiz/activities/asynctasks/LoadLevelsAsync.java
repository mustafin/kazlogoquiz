package flat56.kazlogoquiz.activities.asynctasks;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

import flat56.kazlogoquiz.domain.DataParser;
import flat56.kazlogoquiz.domain.models.Level;

/**
 * Created by MusMB on 08.04.2016.
 */
public class LoadLevelsAsync extends AsyncTask<Void, Void, List<Level>> {

    private Context context;
    private SideFunction<List<Level>> onPostExecute;

    public LoadLevelsAsync(Context context, SideFunction<List<Level>> onPostExecute) {
        this.context = context;
        this.onPostExecute = onPostExecute;
    }

    @Override
    protected List<Level> doInBackground(Void... params) {
        DataParser parser = DataParser.getInstance(context);
        return parser.getCachedLevels();
    }

    @Override
    protected void onPostExecute(List<Level> ts) {
        onPostExecute.apply(ts);
    }
}


