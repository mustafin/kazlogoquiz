package flat56.kazlogoquiz.activities.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import flat56.kazlogoquiz.R;
import flat56.kazlogoquiz.domain.models.Logo;

/**
 * Created by MusMB on 30.03.2016.
 */
public class DirectoryAdapter extends ArrayAdapter<Logo> implements SectionIndexer {

    private List<Logo> logos;
    private Context context;
    private HashMap<String, Integer> mapIndex;
    private String[] sections;

    public DirectoryAdapter(Context context, int resource, List<Logo> objects) {
        super(context, resource, objects);
        this.context = context;
        this.logos = objects;

        mapIndex = new LinkedHashMap<>(25);

        for (int x = 0; x < objects.size(); x++) {
            Logo fruit = objects.get(x);
            String ch = fruit.getCorrect().substring(0, 1);
            ch = ch.toUpperCase();
            if (!mapIndex.containsKey(ch))
                mapIndex.put(ch, x);
        }
        Set<String> indexes = mapIndex.keySet();

        sections = new String[indexes.size()];
        indexes.toArray(sections);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Logo logo = getItem(position);

        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.directory_item, parent, false);

            viewHolder.letter = (TextView) convertView.findViewById(R.id.letter);
            viewHolder.logoImage = (ImageView) convertView.findViewById(R.id.logo);
            viewHolder.title = (TextView) convertView.findViewById(R.id.title);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (isFirstSameLetter(position)) {
            viewHolder.letter.setText(String.valueOf(logo.getCorrect().toUpperCase().charAt(0)));
        } else {
            viewHolder.letter.setText("");
        }
        viewHolder.title.setText(logo.getCorrect());

        return convertView;
    }

    private boolean isFirstSameLetter(int position) {
        String curWord = getItem(position).getCorrect().substring(0, 1).toUpperCase();
        return mapIndex.get(curWord) == position;
    }

    @Override
    public Logo getItem(int position) {
        return logos.get(position);
    }

    @Override
    public int getCount() {
        return logos.size();
    }

    @Override
    public Object[] getSections() {
        return sections;
    }

    @Override
    public int getPositionForSection(int sectionIndex) {
        return mapIndex.get(sections[sectionIndex]);
    }

    @Override
    public int getSectionForPosition(int position) {
        return 0;
    }

    public static class ViewHolder {
        TextView letter;
        ImageView logoImage;
        TextView title;
    }
}
