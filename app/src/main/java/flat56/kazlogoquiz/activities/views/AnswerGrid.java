package flat56.kazlogoquiz.activities.views;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.text.TextUtilsCompat;
import android.support.v4.widget.Space;
import android.text.Html;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Property;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import flat56.kazlogoquiz.R;
import flat56.kazlogoquiz.activities.adapters.CharacterGridAdapter;


/**
 * Created by MusMB on 17.03.2016.
 */
public class AnswerGrid {

    private int ACTIVITY_PADDING;
    private int VIEW_MARGIN = 0;
    private Context context;
    private List<List<Character>> charsList;
    private List<LinearLayout> layoutRows;
    private String answer;
    private int rowCount;
    private int GAME_BUTTON_SIZE = 0;
    private int GAME_SPACE_SIZE = 0;
    private HashMap<Integer, Integer> map = new HashMap<>();
    private CharacterGridAdapter characterGridAdapter;
    private int deviceWidth;
    public static final char WORDS_DELIMETER = ' ';
    public static final char WORDS_MINUS = '-';
    public static final char LINE_NEXT = '\u23CE';

    public AnswerGrid(Context context, String answer) {
        this.context = context;
        this.answer = answer;


        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        deviceWidth = (int) Math.floor(displayMetrics.widthPixels / displayMetrics.density);

        GAME_BUTTON_SIZE = (int) context.getResources().getDimension(R.dimen.game_button_width);
        GAME_SPACE_SIZE = (int) context.getResources().getDimension(R.dimen.game_space_width);
        VIEW_MARGIN = (int) context.getResources().getDimension(R.dimen.char_view_margin);
        ACTIVITY_PADDING = (int) context.getResources().getDimension(R.dimen.activity_padding);
        deviceWidth -= ACTIVITY_PADDING;


        initRowBuffer();

    }

    public void initAndAddTo(ViewGroup parent) {
        for (List<Character> chars : charsList) {

            LinearLayout linearLayout = initLinearLayout();
            layoutRows.add(linearLayout);
            for (Character character : chars) {
                if (character == WORDS_DELIMETER) {
                    Space v = new Space(context);
                    LayoutParams layoutParams = new LayoutParams(GAME_SPACE_SIZE, LayoutParams.MATCH_PARENT);
                    v.setLayoutParams(layoutParams);
                    linearLayout.addView(v);
                } else if (character == WORDS_MINUS || character == LINE_NEXT) {
                    TextView v = new TextView(context);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(GAME_BUTTON_SIZE, LinearLayout.LayoutParams.MATCH_PARENT);
                    layoutParams.setMargins(VIEW_MARGIN, 0, 0, VIEW_MARGIN);
                    v.setLayoutParams(layoutParams);
                    v.setText(Html.fromHtml(character.toString()));
                    v.setCompoundDrawablesWithIntrinsicBounds(
                            R.drawable.ic_subdirectory_arrow_left, 0, 0, 0);
                    linearLayout.addView(v);
                } else {

                    linearLayout.addView(emptyView());
                }
            }
            parent.addView(linearLayout);

        }
    }

    private LinearLayout initLinearLayout() {
        LinearLayout linearLayout = new LinearLayout(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        linearLayout.setClipChildren(false);
        linearLayout.setLayoutParams(params);
        return linearLayout;
    }

    public void addButton(Button b, int fromPos) {

        if (swapFirstView(b)) {
            map.put(b.getId(), fromPos);
            b.setOnClickListener(view -> {
                int positionInChars = map.get(b.getId());


                View v = emptyView();
                swapViewAt(b, v);

                characterGridAdapter.setButton(positionInChars, b);
            });
        }
    }

    private boolean swapViewAt(View remove, View add) {
        ViewGroup parent = (ViewGroup) remove.getParent();
        if (parent != null) {
            int index = parent.indexOfChild(remove);
            if (index != -1) {
                parent.removeView(remove);
                parent.addView(add, index);
                return true;
            }
        }
        return false;
    }

    private boolean swapFirstView(View swap) {
        for (LinearLayout layout : layoutRows) {
            for (int i = 0; i < layout.getChildCount(); i++) {
                View view = layout.getChildAt(i);
                if (!(view instanceof Button) && !(view instanceof Space) && !(view instanceof TextView)) {
                    layout.removeViewAt(i);
                    layout.addView(swap, i);

                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) swap.getLayoutParams();
                    layoutParams.setMargins(VIEW_MARGIN, 0, 0, VIEW_MARGIN);

                    startAnim(swap);

                    return true;
                }
            }
        }
        return false;
    }

    public boolean canSwap() {
        for (LinearLayout layout : layoutRows) {
            for (int i = 0; i < layout.getChildCount(); i++) {
                View view = layout.getChildAt(i);
                if (!(view instanceof Button) && !(view instanceof Space) && !(view instanceof TextView)) {
                    return true;
                }
            }
        }
        return false;
    }

    private View emptyView() {
        View v = new View(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(GAME_BUTTON_SIZE, GAME_BUTTON_SIZE);
        layoutParams.setMargins(VIEW_MARGIN, 0, 0, VIEW_MARGIN);
        v.setLayoutParams(layoutParams);
        v.setBackgroundResource(R.drawable.button_stub_bg);
        return v;
    }

    public void setCharacterGridAdapter(CharacterGridAdapter characterGridAdapter) {
        this.characterGridAdapter = characterGridAdapter;
    }

    private void startAnim(View view) {
        AnimatorSet anim = (AnimatorSet) AnimatorInflater.loadAnimator(context, R.animator.jump_in);
//        PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat(View.ROTATION_X, 80f);
//
//        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat(View.ROTATION_X, -100f);
//        PropertyValuesHolder pvhE = PropertyValuesHolder.ofFloat(View.ROTATION_X, 100f);
//
//        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(view, pvhX, pvhY);
//        animator.setProperty(Property.of());
//        animator.start();


        anim.setTarget(view);
        anim.start();
    }

    private void initRowBuffer() {

        ArrayList<String> rows = new ArrayList<>();
        rows.addAll(Arrays.asList(answer.split("\n")));
        rowCount = rows.size();

        this.charsList = new ArrayList<>(5);
        int rowWidth = 0;
        for (int i = 0; i < rows.size(); i++) {
            String row = rows.get(i);
            ArrayList<Character> chars = new ArrayList<>(15);
            rowWidth = 0;
            for (int j = 1; j < row.length(); j++) {
                char c = (row.charAt(j));
                if (c == WORDS_DELIMETER) {
                    rowWidth += GAME_SPACE_SIZE + VIEW_MARGIN;
                } else {
                    rowWidth += GAME_BUTTON_SIZE + VIEW_MARGIN;
                }
                if (rowWidth >= deviceWidth) {
                    chars.add(LINE_NEXT);
                    if (i + 1 < rows.size())  rows.set(i + 1, row.substring(j - 1).trim() + " " + rows.get(i + 1));
                    else                      rows.add(row.substring(j - 1).trim());
                    break;
                } else {
                    chars.add(row.charAt(j - 1));
                }
            }
            if (chars.get(chars.size() - 1) != LINE_NEXT)
                chars.add(row.charAt(row.length() - 1));
            else{
                //remove white space between word and nextline character
                if(chars.size() > 2 && chars.get(chars.size() - 2) == ' '){
                    chars.remove(chars.size() - 2);
                }
            }
            this.charsList.add(chars);
        }


        layoutRows = new ArrayList<>(5);
    }

}
