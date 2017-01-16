package leveldb4j.ext.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD, ElementType.PARAMETER,
        ElementType.LOCAL_VARIABLE })
public @interface Default {
    enum Type {
        INTEGER, LONG, BYTE, BOOLEAN, STRING, UNIT
    }

    String value() default "";

    public Type type() default Type.STRING;
}
