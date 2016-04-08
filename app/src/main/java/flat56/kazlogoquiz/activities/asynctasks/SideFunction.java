package flat56.kazlogoquiz.activities.asynctasks;

import com.annimon.stream.function.FunctionalInterface;

/**
 * Created by MusMB on 08.04.2016.
 */
@FunctionalInterface
public interface SideFunction<T> {

    void apply(T t);

}
