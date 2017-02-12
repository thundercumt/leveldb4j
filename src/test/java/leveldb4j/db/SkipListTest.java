package leveldb4j.db;

import org.junit.Before;
import org.junit.Test;

public class SkipListTest {

    SkipList<String, Integer> list;

    @Before
    public void setUp() {
        list = new SkipList<>();
    }
    
    @Test
    public void basicOperations() {
        list.skipInsert("0012", 12);
        list.skipInsert("0123", 123);
        list.skipInsert("1",1);
        list.skipInsert("4", 4);
        list.skipInsert("999", 999);
        list.skipInsert("1000", 1000);

        System.out.println(list.skipSearch("00123").value);
        System.out.println(list.skipSearch("0123").value);
        System.out.println(list.skipSearch("1").value);
        System.out.println(list.skipSearch("999").value);
        System.out.println(list.skipSearch("1000").value);
    }
}
