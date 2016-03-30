package flat56.kazlogoquiz.activities.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;

import java.util.List;

import flat56.kazlogoquiz.R;
import flat56.kazlogoquiz.models.Logo;

/**
 * Created by MusMB on 30.03.2016.
 */
public class DirectoryAdapter extends ArrayAdapter<Logo> {

    private List<Logo> logos;
    private Context context;

    public static class ViewHolder{
        TextView letter;
        ImageView logoImage;
        TextView title;
    }

    public DirectoryAdapter(Context context, int resource, List<Logo> objects) {
        super(context, resource, objects);
        this.context = context;
        this.logos = objects;
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
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if(isFirstSameLetter(position)) {
            viewHolder.letter.setText(String.valueOf(logo.getCorrect().toUpperCase().charAt(0)));
        }else{
            viewHolder.letter.setText("");
        }
        viewHolder.title.setText(logo.getCorrect());

        return convertView;
    }

    private boolean isFirstSameLetter(int position){
        if(position == 0) return true;
        else {
            String curWord = getItem(position).getCorrect().toUpperCase();
            String prevWord = getItem(position - 1).getCorrect().toUpperCase();
            char curvLet = curWord.charAt(0);
            char prevLet = prevWord.charAt(0);
            return curvLet != prevLet;
        }
    }


    @Override
    public Logo getItem(int position) {
        return logos.get(position);
    }

    @Override
    public int getCount() {
        return logos.size();
    }
}
