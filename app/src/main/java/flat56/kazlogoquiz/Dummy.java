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
        new Logo(1, "raymbek.png", pathComplete, "ааимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2, true),
        new Logo(2, "raymbek.png", pathComplete, "Привет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true),
        new Logo(3, "raymbek.png", pathComplete, "Привет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true),
        new Logo(4, "raymbek.png", pathComplete, "Привет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true),
        new Logo(5, "raymbek.png", pathComplete, "мурат", "мурат", "рамуорта", "цужафы", "Мурат это такой человек кароче \n хорошиий такой", 3),
        new Logo(6, "raymbek.png", pathComplete, "человек", "человек", "чоелшошвщекк", "чоелшошвщекк", "Как одгадал? Тут картинки нет лол", 1),
        new Logo(7, "raymbek.png", pathComplete, "раимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2)
    };

    public static List<Logo> logoList = new ArrayList<>(Arrays.asList(logos));

    public static Level[] levels = {
        new Level(1, 40, 23, true, logoList),
        new Level(2, 40, 13, false, logoList),
        new Level(3, 33, 5, false, logoList),
        new Level(4, 40, 26, false, logoList),
        new Level(5, 40, 38, false, logoList),
    };

    public static List<Level> levelList = new ArrayList<>(Arrays.asList(levels));

    public static List<Logo> moreLogos = logoList;
    static {
        moreLogos.add(new Logo(1, "raymbek.png", pathComplete, "ааимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2, true));
        moreLogos.add(new Logo(2, "raymbek.png", pathComplete, "Привет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo(3, "raymbek.png", pathComplete, "рривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo(4, "raymbek.png", pathComplete, "рривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo(5, "raymbek.png", pathComplete, "сурат", "мурат", "рамуорта", "цужафы", "Мурат это такой человек кароче \n хорошиий такой", 3));
        moreLogos.add(new Logo(6, "raymbek.png", pathComplete, "иеловек", "человек", "чоелшошвщекк", "чоелшошвщекк", "Как одгадал? Тут картинки нет лол", 1));
        moreLogos.add(new Logo(7, "raymbek.png", pathComplete, "раимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2));
        moreLogos.add(new Logo(8, "raymbek.png", pathComplete, "ааимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2, true));
        moreLogos.add(new Logo(9, "raymbek.png", pathComplete, "привет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo(10, "raymbek.png", pathComplete, "рривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo(11, "raymbek.png", pathComplete, "Привет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo(12, "raymbek.png", pathComplete, "рурат", "мурат", "рамуорта", "цужафы", "Мурат это такой человек кароче \n хорошиий такой", 3));
        moreLogos.add(new Logo(13, "raymbek.png", pathComplete, "ееловек", "человек", "чоелшошвщекк", "чоелшошвщекк", "Как одгадал? Тут картинки нет лол", 1));
        moreLogos.add(new Logo(14, "raymbek.png", pathComplete, "наимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2));
        moreLogos.add(new Logo(15, "raymbek.png", pathComplete, "ваимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2, true));
        moreLogos.add(new Logo(16, "raymbek.png", pathComplete, "аривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo(17, "raymbek.png", pathComplete, "привет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo(18, "raymbek.png", pathComplete, "аривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo(19, "raymbek.png", pathComplete, "курат", "мурат", "рамуорта", "цужафы", "Мурат это такой человек кароче \n хорошиий такой", 3));
        moreLogos.add(new Logo(20, "raymbek.png", pathComplete, "оеловек", "человек", "чоелшошвщекк", "чоелшошвщекк", "Как одгадал? Тут картинки нет лол", 1));
        moreLogos.add(new Logo(21, "raymbek.png", pathComplete, "лаимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2));
        moreLogos.add(new Logo(22, "raymbek.png", pathComplete, "уаимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2, true));
        moreLogos.add(new Logo(23, "raymbek.png", pathComplete, "лривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo(24, "raymbek.png", pathComplete, "лривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo(25, "raymbek.png", pathComplete, "дривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo(26, "raymbek.png", pathComplete, "мурат", "мурат", "рамуорта", "цужафы", "Мурат это такой человек кароче \n хорошиий такой", 3));
        moreLogos.add(new Logo(27, "raymbek.png", pathComplete, "меловек", "человек", "чоелшошвщекк", "чоелшошвщекк", "Как одгадал? Тут картинки нет лол", 1));
        moreLogos.add(new Logo(28, "raymbek.png", pathComplete, "маимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2));
        moreLogos.add(new Logo(29, "raymbek.png", pathComplete, "каимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2, true));
        moreLogos.add(new Logo(30, "raymbek.png", pathComplete, "кривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo(31, "raymbek.png", pathComplete, "кривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo(32, "raymbek.png", pathComplete, "уривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo(33, "raymbek.png", pathComplete, "пурат", "мурат", "рамуорта", "цужафы", "Мурат это такой человек кароче \n хорошиий такой", 3));
        moreLogos.add(new Logo(34, "raymbek.png", pathComplete, "веловек", "человек", "чоелшошвщекк", "чоелшошвщекк", "Как одгадал? Тут картинки нет лол", 1));
        moreLogos.add(new Logo(35, "raymbek.png", pathComplete, "ваимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2));
        moreLogos.add(new Logo(36, "raymbek.png", pathComplete, "рурат", "мурат", "рамуорта", "цужафы", "Мурат это такой человек кароче \n хорошиий такой", 3));
        moreLogos.add(new Logo(37, "raymbek.png", pathComplete, "ееловек", "человек", "чоелшошвщекк", "чоелшошвщекк", "Как одгадал? Тут картинки нет лол", 1));
        moreLogos.add(new Logo(38, "raymbek.png", pathComplete, "наимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2));
        moreLogos.add(new Logo(39, "raymbek.png", pathComplete, "ваимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2, true));
        moreLogos.add(new Logo(40, "raymbek.png", pathComplete, "аривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo(41, "raymbek.png", pathComplete, "привет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo(42, "raymbek.png", pathComplete, "аривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo(43, "raymbek.png", pathComplete, "курат", "мурат", "рамуорта", "цужафы", "Мурат это такой человек кароче \n хорошиий такой", 3));
        moreLogos.add(new Logo(44, "raymbek.png", pathComplete, "оеловек", "человек", "чоелшошвщекк", "чоелшошвщекк", "Как одгадал? Тут картинки нет лол", 1));
        moreLogos.add(new Logo(45, "raymbek.png", pathComplete, "лаимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2));
        moreLogos.add(new Logo(46, "raymbek.png", pathComplete, "уаимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2, true));
        moreLogos.add(new Logo(47, "raymbek.png", pathComplete, "лривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo(48, "raymbek.png", pathComplete, "лривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo(49, "raymbek.png", pathComplete, "дривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo(50, "raymbek.png", pathComplete, "мурат", "мурат", "рамуорта", "цужафы", "Мурат это такой человек кароче \n хорошиий такой", 3));
        moreLogos.add(new Logo(51, "raymbek.png", pathComplete, "меловек", "человек", "чоелшошвщекк", "чоелшошвщекк", "Как одгадал? Тут картинки нет лол", 1));
        moreLogos.add(new Logo(52, "raymbek.png", pathComplete, "маимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2));
        moreLogos.add(new Logo(53, "raymbek.png", pathComplete, "каимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2, true));
        moreLogos.add(new Logo(54, "raymbek.png", pathComplete, "кривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo(55, "raymbek.png", pathComplete, "кривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo(56, "raymbek.png", pathComplete, "уривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo(57, "raymbek.png", pathComplete, "пурат", "мурат", "рамуорта", "цужафы", "Мурат это такой человек кароче \n хорошиий такой", 3));
        moreLogos.add(new Logo(58, "raymbek.png", pathComplete, "веловек", "человек", "чоелшошвщекк", "чоелшошвщекк", "Как одгадал? Тут картинки нет лол", 1));
        moreLogos.add(new Logo(59, "raymbek.png", pathComplete, "ваимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2));
        moreLogos.add(new Logo(60, "raymbek.png", pathComplete, "рурат", "мурат", "рамуорта", "цужафы", "Мурат это такой человек кароче \n хорошиий такой", 3));
        moreLogos.add(new Logo(61, "raymbek.png", pathComplete, "ееловек", "человек", "чоелшошвщекк", "чоелшошвщекк", "Как одгадал? Тут картинки нет лол", 1));
        moreLogos.add(new Logo(62, "raymbek.png", pathComplete, "наимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2));
        moreLogos.add(new Logo(63, "raymbek.png", pathComplete, "ваимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2, true));
        moreLogos.add(new Logo(64, "raymbek.png", pathComplete, "аривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo(65, "raymbek.png", pathComplete, "привет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo(66, "raymbek.png", pathComplete, "аривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo(67, "raymbek.png", pathComplete, "курат", "мурат", "рамуорта", "цужафы", "Мурат это такой человек кароче \n хорошиий такой", 3));
        moreLogos.add(new Logo(68, "raymbek.png", pathComplete, "оеловек", "человек", "чоелшошвщекк", "чоелшошвщекк", "Как одгадал? Тут картинки нет лол", 1));
        moreLogos.add(new Logo(69, "raymbek.png", pathComplete, "лаимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2));
        moreLogos.add(new Logo(70, "raymbek.png", pathComplete, "уаимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2, true));
        moreLogos.add(new Logo(71, "raymbek.png", pathComplete, "лривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo(72, "raymbek.png", pathComplete, "лривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo(73, "raymbek.png", pathComplete, "дривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo(74, "raymbek.png", pathComplete, "мурат", "мурат", "рамуорта", "цужафы", "Мурат это такой человек кароче \n хорошиий такой", 3));
        moreLogos.add(new Logo(75, "raymbek.png", pathComplete, "меловек", "человек", "чоелшошвщекк", "чоелшошвщекк", "Как одгадал? Тут картинки нет лол", 1));
        moreLogos.add(new Logo(76, "raymbek.png", pathComplete, "маимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2));
        moreLogos.add(new Logo(77, "raymbek.png", pathComplete, "каимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2, true));
        moreLogos.add(new Logo(78, "raymbek.png", pathComplete, "кривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo(79, "raymbek.png", pathComplete, "кривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo(80, "raymbek.png", pathComplete, "уривет", "цууфы", "поветрифы", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 3, true));
        moreLogos.add(new Logo(81, "raymbek.png", pathComplete, "пурат", "мурат", "рамуорта", "цужафы", "Мурат это такой человек кароче \n хорошиий такой", 3));
        moreLogos.add(new Logo(82, "raymbek.png", pathComplete, "веловек", "человек", "чоелшошвщекк", "чоелшошвщекк", "Как одгадал? Тут картинки нет лол", 1));
        moreLogos.add(new Logo(83, "raymbek.png", pathComplete, "ваимы бек\nфыуафп", "цууфы", "реомиклбеджвуаеу", "цужафы", "Рымбефыт фышв фшыовщф \n фывщл фщузлафу", 2));
    }
}
