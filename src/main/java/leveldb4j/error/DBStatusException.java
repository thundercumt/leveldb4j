package leveldb4j.error;

import leveldb4j.db.Slice;

public class DBStatusException extends LevelDB4JException {

    public enum Code {
        OK(0), NotFound(1), Corruption(2), NotSupported(3), InvalidArgument(
                4), IOError(5);

        private final int value;

        private Code(int v) {
            value = v;
        }

        public int getValue() {
            return value;
        }
    }

    private Code   code;
    private String message = "";

    private DBStatusException() {
    }

    private DBStatusException(Code c, String msg) {
        code = c;
        message = msg;
    }

    private DBStatusException(Code c, String msg1, String msg2) {
        code = c;
        int len = msg1 == null ? 0
                : msg1.length() + msg2 == null ? 0 : msg2.length();
        StringBuilder sb = new StringBuilder(len);
        if (msg1 != null)
            sb.append(msg1);
        if (msg2 != null)
            sb.append(msg2);
        message = sb.toString();
    }

    private DBStatusException(Code c, Slice msg1, Slice msg2) {
        code = c;
        int len = (msg1 == null ? 0 : msg1.size())
                + (msg2 == null ? 0 : msg2.size());
        StringBuilder sb = new StringBuilder(len);
        if (msg1 != null)
            sb.append(msg1);
        if (msg2 != null)
            sb.append(msg2);
        message = sb.toString();
    }

    public Code getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return DBStatusException.class.getSimpleName() + "[" + "code: "
                + getCode().name() + ", message: " + getMessage();
    }

    public static DBStatusException notFound(Slice msg1, Slice msg2) {
        return new DBStatusException(Code.NotFound, msg1, msg2);
    }

    public static DBStatusException corruption(Slice msg1, Slice msg2) {
        return new DBStatusException(Code.Corruption, msg1, msg2);
    }

    public static DBStatusException notSupported(Slice msg1, Slice msg2) {
        return new DBStatusException(Code.NotFound, msg1, msg2);
    }

    public static DBStatusException invalidArgument(Slice msg1, Slice msg2) {
        return new DBStatusException(Code.InvalidArgument, msg1, msg2);
    }

    public static DBStatusException ioError(Slice msg1, Slice msg2) {
        return new DBStatusException(Code.IOError, msg1, msg2);
    }

    public static DBStatusException ioError(String msg1, String msg2) {
        return new DBStatusException(Code.IOError, msg1, msg2);
    }

}