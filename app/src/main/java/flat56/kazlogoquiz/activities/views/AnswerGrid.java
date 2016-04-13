package flat56.kazlogoquiz.activities.views;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.widget.Space;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import flat56.kazlogoquiz.R;
import flat56.kazlogoquiz.activities.adapters.CharacterGridAdapter;


/**
 * Created by MusMB on 17.03.2016.
 */
public class AnswerGrid {

    public static final char WORDS_DELIMETER = ' ';
    public static final char WORDS_MINUS = '-';
    public static final char LINE_NEXT = '\u23CE';
    private int ACTIVITY_PADDING;
    private int VIEW_MARGIN = 0;
    private Context context;
    private List<List<Element>> elementsList;
    private List<LinearLayout> layoutRows;
    private String answer;
    private int GAME_BUTTON_SIZE = 0;
    private int GAME_SPACE_SIZE = 0;
    private CharacterGridAdapter characterGridAdapter;
    private int deviceWidth;
    private OnButtonAddListener btnAddListener;
    private OnLastButtonAddListener lastBtnAddListener;
    private ViewGroup parent;

    public AnswerGrid(Context context, String answer, ViewGroup parent) {
        this.context = context;
        this.answer = answer;
        this.parent = parent;

        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        deviceWidth = displayMetrics.widthPixels;

        GAME_BUTTON_SIZE = (int) context.getResources().getDimension(R.dimen.game_button_width);
        GAME_SPACE_SIZE = (int) context.getResources().getDimension(R.dimen.game_space_width);
        VIEW_MARGIN = (int) context.getResources().getDimension(R.dimen.char_view_margin);
        ACTIVITY_PADDING = (int) context.getResources().getDimension(R.dimen.activity_padding);
        deviceWidth -= ACTIVITY_PADDING * 3;

    }

    public void initAndAddToParent() {

        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                initRowBuffer();
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                for (int i = 0; i < elementsList.size(); i++) {
                    List<Element> elements = elementsList.get(i);

                    LinearLayout linearLayout = initLinearLayout();
                    layoutRows.add(linearLayout);
                    for (int j = 0; j < elements.size(); j++) {
                        Element element = elements.get(j);
                        element.setPos(i, j);
                        linearLayout.addView(element.view);
                    }
                    parent.addView(linearLayout);

                }
            }
        }.execute();

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

    public void addButton(Button b, final int fromPos) {

        if (swapFirstView(b, fromPos)) {
            b.setOnClickListener(view -> {
                View v = emptyView();
                swapViewAt(b, v);
                characterGridAdapter.setButton(fromPos, b);
            });
            if (btnAddListener != null) {
                btnAddListener.apply(getCurrentWord());
            }
            if (lastBtnAddListener != null) {
                if (!canSwap()) {
                    lastBtnAddListener.apply(getCurrentWord());
                }
            }
        }
    }

    private String getCurrentWord() {
        StringBuilder builder = new StringBuilder();
        for (LinearLayout layout : layoutRows) {
            for (int i = 0; i < layout.getChildCount(); i++) {
                View view = layout.getChildAt(i);
                if (view instanceof Button) {
                    Button button = (Button) view;
                    builder.append(button.getText());
                } else if (view instanceof TextView) {
                    TextView textView = (TextView) view;
                    CharSequence text = textView.getText();
                    if (text != null && text.length() != 0) {
                        if (textView.getText().charAt(0) == WORDS_MINUS)
                            builder.append(WORDS_MINUS);
                    }
                } else if (view instanceof Space) {
                    builder.append(WORDS_DELIMETER);
                }
            }
        }
        return builder.toString();
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

    private boolean swapFirstView(Button swap, int prevPos) {
        for (int i = 0; i < layoutRows.size(); i++) {
            LinearLayout layout = layoutRows.get(i);
            for (int j = 0; j < layout.getChildCount(); j++) {
                View view = layout.getChildAt(j);
                if (!(view instanceof Button) && !(view instanceof Space) && !(view instanceof TextView)) {
                    layout.removeViewAt(j);
                    layout.addView(swap, j);

                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) swap.getLayoutParams();
                    layoutParams.setMargins(VIEW_MARGIN, 0, 0, VIEW_MARGIN);
                    Element element = new Element(swap);
                    element.setPos(i, j);
                    element.setCharGridPos(prevPos);
                    elementsList.get(i).set(j, element);
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

    public void setCharacterGridAdapter(CharacterGridAdapter characterGridAdapter) {
        this.characterGridAdapter = characterGridAdapter;
    }

    private void startAnim(View view) {
        AnimatorSet anim = (AnimatorSet) AnimatorInflater.loadAnimator(context, R.animator.jump_in);

        anim.setTarget(view);
        anim.start();
    }

    private void initRowBuffer() {

        ArrayList<String> rows = new ArrayList<>();
        rows.addAll(Arrays.asList(answer.split("\n")));

        this.elementsList = new ArrayList<>(5);
        int rowWidth = 0;
        for (int i = 0; i < rows.size(); i++) {
            String row = rows.get(i);
            ArrayList<Element> chars = new ArrayList<>(15);
            rowWidth = GAME_BUTTON_SIZE + VIEW_MARGIN;
            for (int j = 1; j < row.length(); j++) {
                char c = (row.charAt(j));
                if (c == WORDS_DELIMETER || c == WORDS_MINUS) {
                    rowWidth += GAME_SPACE_SIZE + VIEW_MARGIN;
                } else {
                    rowWidth += GAME_BUTTON_SIZE + VIEW_MARGIN;
                }
                if (rowWidth >= deviceWidth) {
                    chars.add(new Element(LINE_NEXT));
                    if (i + 1 < rows.size())
                        rows.set(i + 1, row.substring(j - 1).trim() + " " + rows.get(i + 1));
                    else rows.add(row.substring(j - 1).trim());
                    break;
                } else {
                    chars.add(new Element(row.charAt(j - 1)));
                }
            }
            if (chars.get(chars.size() - 1).character != LINE_NEXT)
                chars.add(new Element(row.charAt(row.length() - 1)));
            else {
                //remove white space between word and nextline character
                if (chars.size() > 2 && chars.get(chars.size() - 2).character == WORDS_DELIMETER) {
                    chars.remove(chars.size() - 2);
                }
            }
            this.elementsList.add(chars);
        }


        layoutRows = new ArrayList<>(5);
    }

    public void setBtnAddListener(OnButtonAddListener btnAddListener) {
        this.btnAddListener = btnAddListener;
    }

    public void setLastBtnAddListener(OnLastButtonAddListener lastBtnAddListener) {
        this.lastBtnAddListener = lastBtnAddListener;
    }

    public void animateShake() {
        AnimatorSet anim = (AnimatorSet) AnimatorInflater.loadAnimator(context, R.animator.shake);
        anim.setTarget(parent);
        anim.start();
    }

    public View emptyView() {
        View v = new View(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(GAME_BUTTON_SIZE, GAME_BUTTON_SIZE);
        layoutParams.setMargins(VIEW_MARGIN, 0, 0, VIEW_MARGIN);
        v.setLayoutParams(layoutParams);
        v.setBackgroundResource(R.drawable.button_stub_bg);
        return v;
    }

    public interface OnButtonAddListener {
        void apply(String st);
    }

    public interface OnLastButtonAddListener {
        void apply(String st);
    }

    class Element {

        public View view;
        /**
         * position in answerGrid
         */
        public int i = -1;
        public int j = -1;

        /**
         * position in characterGrid
         */
        public int posInCharGrid = -1;
        public Character character;

        public Element(Character character) {
            this.character = character;
            view = fromElementType(character);
        }

        public Element(Button button){
            this.character = button.getText().charAt(0);
            view = button;
        }

        public void setPos(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public void setCharGridPos(int pos) {
            posInCharGrid = pos;
        }

        public View fromElementType(char character) {
            View view;
            switch (character) {
                case WORDS_DELIMETER:
                    Space v = new Space(context);
                    LayoutParams layoutParams = new LayoutParams(GAME_SPACE_SIZE, LayoutParams.MATCH_PARENT);
                    v.setLayoutParams(layoutParams);
                    view = v;
                    break;
                case WORDS_MINUS:
                    TextView textView = new TextView(context);
                    LinearLayout.LayoutParams layoutParams1 = new LinearLayout
                            .LayoutParams(GAME_BUTTON_SIZE, LinearLayout.LayoutParams.MATCH_PARENT);
                    layoutParams1.setMargins(VIEW_MARGIN, 0, 0, VIEW_MARGIN);
                    textView.setLayoutParams(layoutParams1);
                    textView.setText(String.valueOf(character));
                    view = textView;
                    break;
                case LINE_NEXT:
                    TextView textView1 = new TextView(context);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout
                            .LayoutParams(GAME_SPACE_SIZE, LinearLayout.LayoutParams.MATCH_PARENT);
                    layoutParams2.setMargins(VIEW_MARGIN, 0, 0, VIEW_MARGIN);
                    textView1.setLayoutParams(layoutParams2);
                    textView1.setCompoundDrawablesWithIntrinsicBounds(
                            R.drawable.ic_subdirectory_arrow_left, 0, 0, 0);
                    view = textView1;
                    break;
                default:
                    view = emptyView();
                    break;
            }
            return view;
        }

    }


}
