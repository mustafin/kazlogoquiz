/**
 * Created by MusMB on 17.03.2016.
 */
public class MainTest {

    public static void main(String[] args) {
        String st = "Hello-world asd\nasdaef";

        String[] split = st.split("[-\\s]");
        for (String s : split) {
            System.out.println(s);
        }
    }

}
