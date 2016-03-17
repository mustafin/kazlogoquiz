package flat56.kazlogoquiz.activities.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.view.ViewGroup.LayoutParams;

import java.util.ArrayList;
import java.util.List;

import flat56.kazlogoquiz.R;


/**
 * Created by MusMB on 17.03.2016.
 */
public class AnswerGridAdapter{

    private Context context;
    private List<List<Character>> charsList;
    private String answer;
    private int rowCount;

    public AnswerGridAdapter(Context context, String answer) {
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
    }

    public void addTo(ViewGroup parent) {
        for (List<Character> chars : charsList) {
            LinearLayout linearLayout = new LinearLayout(context);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.CENTER_HORIZONTAL;
            linearLayout.setLayoutParams(params);
            for (Character character : chars) {
                View v = new View(context);
                if(character == ' ' || character == '-'){
                    LayoutParams layoutParams = new LayoutParams(50, LayoutParams.MATCH_PARENT);
                    v.setLayoutParams(layoutParams);
                }else {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(100, 100);
                    layoutParams.setMargins(10, 0, 0, 10);
                    v.setLayoutParams(layoutParams);
                    v.setBackground(ContextCompat.getDrawable(context, R.drawable.button_stub_bg));
                }
                linearLayout.addView(v);
            }
            parent.addView(linearLayout);

        }
    }
}
