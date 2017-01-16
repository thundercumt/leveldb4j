package leveldb4j.error;

public class NotImplementedException extends LevelDB4JException {
    public NotImplementedException() {
    }

    public NotImplementedException(String msg) {
        super(msg);
    }
}
