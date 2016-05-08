package flat56.kazlogoquiz.domain.models;

import android.app.Activity;
import android.widget.Button;

import java.util.List;

import flat56.kazlogoquiz.activities.adapters.CharacterGridAdapter;
import flat56.kazlogoquiz.activities.views.AnswerGrid;
import flat56.kazlogoquiz.activities.views.AnswerGrid.Element;
import flat56.kazlogoquiz.domain.persistable.DataStateHandler;

/**
 * Created by MusMB on 12.04.2016.
 */
public class OpenHint extends Hint {

    private static final int COST = 8;
    public static final String HINT_PREFIX = "open";
    private AnswerGrid answerGrid;

    public OpenHint(Activity activity, Logo logo, AnswerGrid answerGrid) {
        super(activity, logo);
        this.answerGrid = answerGrid;
    }

    @Override
    public int cost() {
        return COST;
    }

    @Override
    protected void onUse() {
        changeElementsListeners();

    }

    @Override
    protected void onSave(DataStateHandler handler) {
        //TODO implement
    }

    //TODO change styles on hinted elements
    private void changeElementsListeners() {
        List<List<Element>> elementsList = answerGrid.getElementsList();
        for (List<Element> elements : elementsList) {
            for (int i = 0; i < elements.size(); i++) {
                Element element = elements.get(i);

                final int index = i;
                if (AnswerGrid.isView(element.view)) {
                    element.view.setOnClickListener(v -> {

                        answerGrid.getCharacterGridAdapter().removeFirstChar(element.character);
                        Button b = CharacterGridAdapter.newButton(activity, answerGrid.GAME_BUTTON_SIZE, answerGrid.GAME_BUTTON_SIZE);
                        b.setText(String.valueOf(element.character));
                        Element buttonElement = answerGrid.new Element(b);
                        elements.set(index, buttonElement);
                        answerGrid.swapViewAt(b, element.i, element.j);
                        returnElementListeners();
                    });
                }


            }
        }
    }

    private void returnElementListeners() {
        List<List<Element>> elementsList = answerGrid.getElementsList();
        for (List<Element> elements : elementsList) {
            for (int i = 0; i < elements.size(); i++) {
                Element element = elements.get(i);


                if (AnswerGrid.isView(element.view)) {
                    element.view.setOnClickListener(v -> {

                    });
                }


            }
        }
    }
}
