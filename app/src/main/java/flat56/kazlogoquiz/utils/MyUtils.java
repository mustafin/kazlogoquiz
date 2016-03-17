package flat56.kazlogoquiz.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by MusMB on 17.03.2016.
 */
public class MyUtils {

    public static List<Character> toCharList(String string){
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            list.add(string.charAt(i));
        }
        return list;
    }

    public static int lfCount(String string){
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if(string.charAt(i) == '\n'){
                count++;
            }
        }
        return count;
    }


}