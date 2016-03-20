package flat56.kazlogoquiz.activities.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import flat56.kazlogoquiz.R;
import flat56.kazlogoquiz.models.Logo;

/**
 * Created by Murat on 01.02.2015.
 */
public class LogosAdapter extends ArrayAdapter<Logo>{

    private List<Logo>logos;
    private Context context;

    public LogosAdapter(Context context, int resource, List<Logo> objects) {
        super(context, resource, objects);
        this.context = context;
        logos = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.logo_cell, parent, false);
        }
        Logo item = logos.get(position);
        ImageView logo = (ImageView) convertView.findViewById(R.id.logo);
        LinearLayout difficulty = (LinearLayout) convertView.findViewById(R.id.points);
        int points = item.getPoints();
        if(difficulty.getChildCount() == 0) {
            for (int i = 0; i < points; i++) {
                ImageView view = new ImageView(context);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                params.setMargins(5, 5, 5, 5);
                view.setLayoutParams(params);
                view.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.icon_tenge_small));
                difficulty.addView(view);
            }
        }

        return convertView;
    }

    @Override
    public Logo getItem(int position) {
        return logos.get(position);
    }
}
