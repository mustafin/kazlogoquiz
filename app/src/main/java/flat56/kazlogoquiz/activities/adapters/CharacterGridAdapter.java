package flat56.kazlogoquiz.activities.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import flat56.kazlogoquiz.R;

/**
 * Created by MusMB on 18.03.2016.
 */
public class CharacterGridAdapter extends BaseAdapter {

    private Context context;
    private List<Button> buttonList;
    private List<Character> characterList;
    private String chars;
    private int GAME_BUTTON_WIDTH = 0;

    private int rows = 0;
    private GridView gridView;

    public CharacterGridAdapter(Context context, GridView gridView, String chars, int rows) {
        this.context = context;
        this.gridView = gridView;
        this.chars = chars;
        this.rows = rows;
        this.GAME_BUTTON_WIDTH = (int) context.getResources().getDimension(R.dimen.game_button_width);
        this.buttonList = new ArrayList<>(20);
        this.characterList = new ArrayList<>(15);
        for (int i = 0; i < chars.length(); i++) {
            characterList.add(chars.charAt(i));
        }

        if (rows == 0) {
            gridView.setNumColumns(8);
            this.rows = (int) Math.ceil(chars.length() / 8.0);
        } else
            gridView.setNumColumns(chars.length() / rows);

    }

    @Override
    public int getCount() {
        return characterList.size();
    }

    @Override
    public Object getItem(int position) {
        return characterList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Character c = characterList.get(position);
        View view;
        if (c == '-') {
            view = new View(context);
            view.setLayoutParams(new LayoutParams(GAME_BUTTON_WIDTH, LayoutParams.WRAP_CONTENT));
        }else{
            Button b = new Button(context);
            b.setLayoutParams(new LayoutParams(GAME_BUTTON_WIDTH, LayoutParams.WRAP_CONTENT));
            b.setText(c.toString());
            buttonList.add(b);


            b.setOnClickListener(v -> {

                characterList.set(position, '-');
                notifyDataSetChanged();
            });
            view = b;
        }

        return view;
    }
}
