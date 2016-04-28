package flat56.kazlogoquiz.domain.models;

import android.app.Activity;

import com.annimon.stream.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import flat56.kazlogoquiz.activities.adapters.CharacterGridAdapter;
import flat56.kazlogoquiz.domain.persistable.DataStateHandler;

/**
 * Created by MusMB on 12.04.2016.
 */
public class BombHint extends Hint{

    private static final int COST = 8;
    public static final String HINT_PREFIX = "bomb";
    private CharacterGridAdapter chars;

    public BombHint(Activity activity, Logo logo, CharacterGridAdapter chars) {
        super(activity, logo);
        this.chars = chars;
    }

    @Override
    public int cost() {
        return COST;
    }

    @Override
    protected void onUse() {
        char[] correct = logo.getCorrect().toCharArray();
        List<Character> list = this.chars.getCharacterList();
        for (int i = 0; i < correct.length; i++) {
            boolean found = false;
            int d = 0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i) == correct[i]) {
                    correct[i] = '-';
                    found = true;
                    d = j;
                    break;
                }
            }
            if(found) list.set(d, '-');
        }
        this.chars.notifyDataSetChanged();
    }

    @Override
    protected void onSave(DataStateHandler handler) {
        handler.saveHintUsed(logo.getId(), HINT_PREFIX);
        //TODO SAVE CHARS REMOVED
    }
}
