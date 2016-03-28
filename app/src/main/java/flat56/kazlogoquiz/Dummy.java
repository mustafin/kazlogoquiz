package flat56.kazlogoquiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import flat56.kazlogoquiz.models.Level;
import flat56.kazlogoquiz.models.Logo;

/**
 * Created by musta on 2016-03-16.
 */
public class Dummy {

    public static Logo[] logos = {
        new Logo("raymbek.png", "раим бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2, true),
        new Logo("raymbek.png", "раим бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true),
        new Logo("raymbek.png", "раим бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3),
        new Logo("raymbek.png", "раим бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 1),
        new Logo("raymbek.png", "раим бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2)
    };

    public static List<Logo> logoList = new ArrayList<>(Arrays.asList(logos));


    public static Level[] levels = {
        new Level(1, 40, 23, 40, true, logoList),
        new Level(2, 40, 13, 40, false, logoList),
        new Level(3, 33, 5, 33, false, logoList),
        new Level(4, 40, 26, 40, false, logoList),
        new Level(5, 40, 38, 40, false, logoList),
    };

    public static List<Level> levelList = new ArrayList<>(Arrays.asList(levels));


}
