package leveldb4j.db.env;

public interface ParameteredRunnable extends Runnable {
    void run(Object p);
}
