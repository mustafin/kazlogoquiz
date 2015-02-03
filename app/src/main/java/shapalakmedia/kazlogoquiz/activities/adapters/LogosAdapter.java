package shapalakmedia.kazlogoquiz.activities.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import shapalakmedia.kazlogoquiz.R;
import shapalakmedia.kazlogoquiz.entities.Logo;

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

        return convertView;
    }
}
