package leveldb4j.error;

public class LevelDB4JException extends RuntimeException {

    public LevelDB4JException() {
        super();
    }

    public LevelDB4JException(String message) {
        super(message);
    }
}
