package flat56.kazlogoquiz.activities.views;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.Space;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.LinearLayout;
import android.view.ViewGroup.LayoutParams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import flat56.kazlogoquiz.R;
import flat56.kazlogoquiz.activities.adapters.CharacterGridAdapter;


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
    private CharacterGridAdapter characterGridAdapter;

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
                if(character == ' ' || character == '-'){
                    Space v = new Space(context);
                    LayoutParams layoutParams = new LayoutParams(20, LayoutParams.MATCH_PARENT);
                    v.setLayoutParams(layoutParams);
                    linearLayout.addView(v);
                }else {
                    linearLayout.addView(emptyView());
                }
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

    public void addButton(Button b, int fromPos){

        if(swapFirstView(b)){
            map.put(b.getId(), fromPos);
            b.setOnClickListener(view -> {
                int positionInChars = map.get(b.getId());

                View v = emptyView();
                swapViewAt(b, v);

                characterGridAdapter.setButton(positionInChars, b);
            });
        }
    }

    private boolean swapViewAt(View view, View swap){
        ViewGroup parent = (ViewGroup) view.getParent();
        if(parent != null) {
            int index = parent.indexOfChild(view);
            if(index != -1) {
                parent.removeView(view);
                parent.addView(swap, index);
                return true;
            }
        }
        return false;
    }

    private boolean swapFirstView(View swap){
        for (LinearLayout layout : layoutRows) {
            for (int i = 0; i < layout.getChildCount(); i++) {
                View view = layout.getChildAt(i);
                if(!(view instanceof Button) && !(view instanceof Space)){
                    layout.removeViewAt(i);
                    layout.addView(swap, i);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canSwap(View swap){
        for (LinearLayout layout : layoutRows) {
            for (int i = 0; i < layout.getChildCount(); i++) {
                View view = layout.getChildAt(i);
                if(!(view instanceof Button) && !(view instanceof Space)){
                    return true;
                }
            }
        }
        return false;
    }

    private View emptyView(){
        View v = new View(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(GAME_BUTTON_WIDTH, GAME_BUTTON_WIDTH);
//                    layoutParams.setMargins(10, 0, 0, 10);
        v.setPadding(10, 0, 0, 10);
        v.setLayoutParams(layoutParams);
        v.setBackground(ContextCompat.getDrawable(context, R.drawable.button_stub_bg));
        return v;
    }

    public void setCharacterGridAdapter(CharacterGridAdapter characterGridAdapter) {
        this.characterGridAdapter = characterGridAdapter;
    }
}
