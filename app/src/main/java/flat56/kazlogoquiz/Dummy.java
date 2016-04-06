package flat56.kazlogoquiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import flat56.kazlogoquiz.domain.models.Level;
import flat56.kazlogoquiz.domain.models.Logo;

/**
 * Created by musta on 2016-03-16.
 */
public class Dummy {

    static String pathComplete = "raasd.png";

    public static Logo[] logos = {
        new Logo("raymbek.png", pathComplete, "ааимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2, true),
        new Logo("raymbek.png", pathComplete, "Привет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true),
        new Logo("raymbek.png", pathComplete, "Привет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true),
        new Logo("raymbek.png", pathComplete, "Привет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true),
        new Logo("raymbek.png", pathComplete, "мурат", "мурат", "рамуорта", "цужафы", "Мурат это такой человек кароче \n хорошиий такой", 3),
        new Logo("raymbek.png", pathComplete, "человек", "человек", "чоелшошвщекк", "чоелшошвщекк", "Как одгадал? Тут картинки нет лол", 1),
        new Logo("raymbek.png", pathComplete, "раимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2)
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
        moreLogos.add(new Logo("raymbek.png", pathComplete, "ааимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "Привет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "рривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "рривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "сурат", "мурат", "рамуорта", "цужафы", "Мурат это такой человек кароче \n хорошиий такой", 3));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "иеловек", "человек", "чоелшошвщекк", "чоелшошвщекк", "Как одгадал? Тут картинки нет лол", 1));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "раимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "ааимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "привет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "рривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "Привет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "рурат", "мурат", "рамуорта", "цужафы", "Мурат это такой человек кароче \n хорошиий такой", 3));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "ееловек", "человек", "чоелшошвщекк", "чоелшошвщекк", "Как одгадал? Тут картинки нет лол", 1));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "наимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "ваимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "аривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "привет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "аривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "курат", "мурат", "рамуорта", "цужафы", "Мурат это такой человек кароче \n хорошиий такой", 3));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "оеловек", "человек", "чоелшошвщекк", "чоелшошвщекк", "Как одгадал? Тут картинки нет лол", 1));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "лаимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "уаимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "лривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "лривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "дривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "мурат", "мурат", "рамуорта", "цужафы", "Мурат это такой человек кароче \n хорошиий такой", 3));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "меловек", "человек", "чоелшошвщекк", "чоелшошвщекк", "Как одгадал? Тут картинки нет лол", 1));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "маимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "каимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "кривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "кривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "уривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "пурат", "мурат", "рамуорта", "цужафы", "Мурат это такой человек кароче \n хорошиий такой", 3));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "веловек", "человек", "чоелшошвщекк", "чоелшошвщекк", "Как одгадал? Тут картинки нет лол", 1));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "ваимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "рурат", "мурат", "рамуорта", "цужафы", "Мурат это такой человек кароче \n хорошиий такой", 3));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "ееловек", "человек", "чоелшошвщекк", "чоелшошвщекк", "Как одгадал? Тут картинки нет лол", 1));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "наимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "ваимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "аривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "привет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "аривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "курат", "мурат", "рамуорта", "цужафы", "Мурат это такой человек кароче \n хорошиий такой", 3));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "оеловек", "человек", "чоелшошвщекк", "чоелшошвщекк", "Как одгадал? Тут картинки нет лол", 1));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "лаимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "уаимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "лривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "лривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "дривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "мурат", "мурат", "рамуорта", "цужафы", "Мурат это такой человек кароче \n хорошиий такой", 3));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "меловек", "человек", "чоелшошвщекк", "чоелшошвщекк", "Как одгадал? Тут картинки нет лол", 1));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "маимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "каимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "кривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "кривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "уривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "пурат", "мурат", "рамуорта", "цужафы", "Мурат это такой человек кароче \n хорошиий такой", 3));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "веловек", "человек", "чоелшошвщекк", "чоелшошвщекк", "Как одгадал? Тут картинки нет лол", 1));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "ваимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "рурат", "мурат", "рамуорта", "цужафы", "Мурат это такой человек кароче \n хорошиий такой", 3));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "ееловек", "человек", "чоелшошвщекк", "чоелшошвщекк", "Как одгадал? Тут картинки нет лол", 1));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "наимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "ваимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "аривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "привет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "аривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "курат", "мурат", "рамуорта", "цужафы", "Мурат это такой человек кароче \n хорошиий такой", 3));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "оеловек", "человек", "чоелшошвщекк", "чоелшошвщекк", "Как одгадал? Тут картинки нет лол", 1));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "лаимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "уаимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "лривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "лривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "дривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "мурат", "мурат", "рамуорта", "цужафы", "Мурат это такой человек кароче \n хорошиий такой", 3));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "меловек", "человек", "чоелшошвщекк", "чоелшошвщекк", "Как одгадал? Тут картинки нет лол", 1));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "маимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "каимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "кривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "кривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "уривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "пурат", "мурат", "рамуорта", "цужафы", "Мурат это такой человек кароче \n хорошиий такой", 3));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "веловек", "человек", "чоелшошвщекк", "чоелшошвщекк", "Как одгадал? Тут картинки нет лол", 1));
        moreLogos.add(new Logo("raymbek.png", pathComplete, "ваимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2));
    }
}
