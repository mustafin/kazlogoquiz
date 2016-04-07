package flat56.kazlogoquiz;

import android.app.Application;
import android.provider.ContactsContract;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.SmallTest;

import java.io.IOException;

import flat56.kazlogoquiz.domain.DataParser;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }


    @SmallTest
    public void test() {

        DataParser parser = DataParser.getInstance(getContext());

        try {
            System.out.println(parser.getLevels());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}