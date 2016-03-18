package flat56.kazlogoquiz.activities.views;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.view.ViewGroup.LayoutParams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import flat56.kazlogoquiz.R;


/**
 * Created by MusMB on 17.03.2016.
 */
public class AnswerGrid {

    private Context context;
    private List<List<Character>> charsList;
    private List<LinearLayout> layoutRows;
    private String answer;
    private int rowCount;
    private int GAME_BUTTON_WIDTH = 0;
    private HashMap<Integer, Integer> map = new HashMap<>();

    public AnswerGrid(Context context, String answer) {
        this.context = context;
        this.answer = answer;
        String[] rows = answer.split("\n");
        rowCount = rows.length;

        this.charsList = new ArrayList<>(5);
        for (String row : rows) {
            List<Character> c = new ArrayList<>(15);
            for (int i = 0; i < row.length(); i++) {
                c.add(row.charAt(i));
            }
            this.charsList.add(c);
        }
        this.GAME_BUTTON_WIDTH = (int)context.getResources().getDimension(R.dimen.game_button_width);

        layoutRows = new ArrayList<>(5);
    }

    public void initAndaddTo(ViewGroup parent) {
        for (List<Character> chars : charsList) {

            LinearLayout linearLayout = initLinearLayout();
            layoutRows.add(linearLayout);
            for (Character character : chars) {
                View v = new View(context);
                if(character == ' ' || character == '-'){
                    LayoutParams layoutParams = new LayoutParams(20, LayoutParams.MATCH_PARENT);
                    v.setLayoutParams(layoutParams);
                }else {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(GAME_BUTTON_WIDTH, GAME_BUTTON_WIDTH);
                    layoutParams.setMargins(10, 0, 0, 10);
                    v.setLayoutParams(layoutParams);
                    v.setBackground(ContextCompat.getDrawable(context, R.drawable.button_stub_bg));
                }
                linearLayout.addView(v);
            }
            parent.addView(linearLayout);

        }
    }

    private LinearLayout initLinearLayout(){
        LinearLayout linearLayout = new LinearLayout(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        linearLayout.setLayoutParams(params);
        return linearLayout;
    }

    //TODO CHANGE LOGIC, THIS IS WRONG: потому что сильно связанно с CharacterGridAdapter, надо сделать в одном месте
    public void addButton(Button b, int fromPos){
        map.put(b.getId(), fromPos);
        View v = getFirstEmpty();
    }

    private View getFirstEmpty(){
        for (LinearLayout layout : layoutRows) {
            for (int i = 0; i < layout.getChildCount(); i++) {
                View view = layout.getChildAt(i);
                if(!(view instanceof Button)){
                    return view;
                }
            }
        }
        return null;
    }


}
