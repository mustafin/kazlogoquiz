package flat56.kazlogoquiz.domain.persistable.models;

/**
 * Created by MusMB on 08.04.2016.
 */
public class UserLogo {

    int id;
    boolean answered;
    int userId;
    int levelId;

    public UserLogo(int id, boolean answered, int userId, int levelId) {
        this.id = id;
        this.answered = answered;
        this.userId = userId;
        this.levelId = levelId;
    }
}
