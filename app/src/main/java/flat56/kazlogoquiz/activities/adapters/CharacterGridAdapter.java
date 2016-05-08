package flat56.kazlogoquiz.activities.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import flat56.kazlogoquiz.R;
import flat56.kazlogoquiz.activities.views.AnswerGrid;
import flat56.kazlogoquiz.utils.ViewIdGenerator;

/**
 * Created by MusMB on 18.03.2016.
 */
public class CharacterGridAdapter extends BaseAdapter {

    private Context context;
    private List<Character> characterList;
    private String chars;
    private int GAME_BUTTON_SIZE = 0;
    private int VIEW_MARGIN = 0;
    public static final char EMPTY_VIEW = '-';
    private AnswerGrid answerGrid;

    private int rows = 0;

    public CharacterGridAdapter(Context context, GridView gridView, String chars, int rows) {
        this.context = context;
        this.chars = chars;
        this.rows = rows;
        this.GAME_BUTTON_SIZE = (int) context.getResources().getDimension(R.dimen.game_button_width);
        this.VIEW_MARGIN = (int) context.getResources().getDimension(R.dimen.char_view_margin);
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
        if (c == EMPTY_VIEW) {
            convertView = new View(context);
            convertView.setLayoutParams(new AbsListView.LayoutParams(GAME_BUTTON_SIZE, GAME_BUTTON_SIZE));

        } else {
            Button b = newButton(context, GAME_BUTTON_SIZE, GAME_BUTTON_SIZE);

            b.setText(c.toString());
            convertView = b;
            b.setOnClickListener(buttonClick(position, b));
        }

        return convertView;
    }

    public static Button newButton(Context context, int width, int height){
        Button b = new Button(context);
        b.setBackgroundResource(R.drawable.game_char_but_selector);
        b.setId(ViewIdGenerator.generateViewId());
        AbsListView.LayoutParams params = new AbsListView.LayoutParams(width, height);
        b.setPadding(0, 0, 0, 0);
        b.setLayoutParams(params);
        return b;
    }


    public View.OnClickListener buttonClick(int position, Button button) {
        return v -> {
            if (answerGrid.canSwap()) {
                characterList.set(position, EMPTY_VIEW);
                notifyDataSetChanged();
                ViewGroup parent = (ViewGroup) button.getParent();
                parent.removeViewInLayout(button);
                answerGrid.addButton(button, position);
            }
        };
    }

    public void removeFirstChar(Character character){
        for (int i = 0; i < characterList.size(); i++) {
            if(characterList.get(i) == character){
                characterList.set(i, EMPTY_VIEW);
                notifyDataSetChanged();
                return;
            }
        }
    }

    public void setButton(int position, Button b) {
        characterList.set(position, b.getText().charAt(0));
        notifyDataSetChanged();
    }

    public AnswerGrid getAnswerGrid() {
        return answerGrid;
    }

    public void setAnswerGrid(AnswerGrid answerGrid) {
        this.answerGrid = answerGrid;
    }

    public List<Character> getCharacterList() {
        return characterList;
    }
}
