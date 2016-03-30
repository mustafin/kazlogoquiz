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
        new Logo("raymbek.png", "ааимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2, true),
        new Logo("raymbek.png", "Привет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true),
        new Logo("raymbek.png", "Привет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true),
        new Logo("raymbek.png", "Привет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true),
        new Logo("raymbek.png", "мурат", "мурат", "рамуорта", "цужафы", "Мурат это такой человек кароче \n хорошиий такой", 3),
        new Logo("raymbek.png", "человек", "человек", "чоелшошвщекк", "чоелшошвщекк", "Как одгадал? Тут картинки нет лол", 1),
        new Logo("raymbek.png", "раимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2)
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


    public static List<Logo> moreLogos = logoList;
    static {
        moreLogos.add(new Logo("raymbek.png", "ааимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2, true));
        moreLogos.add(new Logo("raymbek.png", "Привет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", "рривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", "рривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", "сурат", "мурат", "рамуорта", "цужафы", "Мурат это такой человек кароче \n хорошиий такой", 3));
        moreLogos.add(new Logo("raymbek.png", "иеловек", "человек", "чоелшошвщекк", "чоелшошвщекк", "Как одгадал? Тут картинки нет лол", 1));
        moreLogos.add(new Logo("raymbek.png", "раимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2));
        moreLogos.add(new Logo("raymbek.png", "ааимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2, true));
        moreLogos.add(new Logo("raymbek.png", "привет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", "рривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", "Привет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", "рурат", "мурат", "рамуорта", "цужафы", "Мурат это такой человек кароче \n хорошиий такой", 3));
        moreLogos.add(new Logo("raymbek.png", "ееловек", "человек", "чоелшошвщекк", "чоелшошвщекк", "Как одгадал? Тут картинки нет лол", 1));
        moreLogos.add(new Logo("raymbek.png", "наимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2));
        moreLogos.add(new Logo("raymbek.png", "ваимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2, true));
        moreLogos.add(new Logo("raymbek.png", "аривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", "привет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", "аривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", "курат", "мурат", "рамуорта", "цужафы", "Мурат это такой человек кароче \n хорошиий такой", 3));
        moreLogos.add(new Logo("raymbek.png", "оеловек", "человек", "чоелшошвщекк", "чоелшошвщекк", "Как одгадал? Тут картинки нет лол", 1));
        moreLogos.add(new Logo("raymbek.png", "лаимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2));
        moreLogos.add(new Logo("raymbek.png", "уаимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2, true));
        moreLogos.add(new Logo("raymbek.png", "лривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", "лривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", "дривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", "мурат", "мурат", "рамуорта", "цужафы", "Мурат это такой человек кароче \n хорошиий такой", 3));
        moreLogos.add(new Logo("raymbek.png", "меловек", "человек", "чоелшошвщекк", "чоелшошвщекк", "Как одгадал? Тут картинки нет лол", 1));
        moreLogos.add(new Logo("raymbek.png", "маимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2));
        moreLogos.add(new Logo("raymbek.png", "каимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2, true));
        moreLogos.add(new Logo("raymbek.png", "кривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", "кривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", "уривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", "пурат", "мурат", "рамуорта", "цужафы", "Мурат это такой человек кароче \n хорошиий такой", 3));
        moreLogos.add(new Logo("raymbek.png", "веловек", "человек", "чоелшошвщекк", "чоелшошвщекк", "Как одгадал? Тут картинки нет лол", 1));
        moreLogos.add(new Logo("raymbek.png", "ваимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2));

    }


}
