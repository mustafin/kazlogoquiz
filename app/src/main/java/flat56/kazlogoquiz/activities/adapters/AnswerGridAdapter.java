package flat56.kazlogoquiz.activities.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MusMB on 17.03.2016.
 */
public class AnswerGridAdapter extends BaseAdapter{

    private Context context;
    private List<Character> chars;

    public AnswerGridAdapter(Context context, List<Character> chars) {
        this.context = context;
        this.chars = chars;
    }

    public AnswerGridAdapter(Context context, String chars) {
        this.context = context;
        this.chars = new ArrayList<>();
        for (int i = 0; i < chars.length(); i++) {
            this.chars.add(chars.charAt(i));
        }
    }

    @Override
    public int getCount() {
        return chars.size();
    }

    @Override
    public Character getItem(int position) {
        return chars.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Button b = new Button(context);
        b.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        Character c = chars.get(position);
        b.setText(c.toString().toUpperCase());
        return b;
    }
}
