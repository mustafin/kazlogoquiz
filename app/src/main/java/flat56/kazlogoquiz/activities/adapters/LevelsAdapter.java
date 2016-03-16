package flat56.kazlogoquiz.activities.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.List;

import flat56.kazlogoquiz.R;
import flat56.kazlogoquiz.activities.LogosActivity;
import flat56.kazlogoquiz.entities.Level;

/**
 * Created by Murat on 31.01.2015.
 */
public class LevelsAdapter extends ArrayAdapter<Level>{

    private List<Level> levels;
    private Context context;

    public LevelsAdapter(Context context, int resource, List<Level> objects) {
        super(context, resource, objects);
        this.context = context;
        levels = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.row, parent, false);
        }

        Button button = (Button) convertView.findViewById(R.id.start);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LogosActivity.class);
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}
