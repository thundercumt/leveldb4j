package leveldb4j.db.env;

public class ParameteredRunnableWrapper implements Runnable {
    private Object              obj;
    private ParameteredRunnable prun;

    public ParameteredRunnableWrapper(ParameteredRunnable r, Object o) {
        prun = r;
        obj = o;
    }

    @Override
    public void run() {
        prun.run(obj);
    }
}
