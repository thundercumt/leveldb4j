package leveldb4j;

import java.nio.ByteBuffer;

public class Main {

    public static void main(String[] args) {
        verifyEndian();

    }
    
    private static void verifyEndian() {
        int a = 0x12345678;
        System.out.println(String.format("input 0x%x", a));
        ByteBuffer bf = ByteBuffer.allocate(4);
        bf.asIntBuffer().put(a);
        for(int i=0; i<4; i++)
            System.out.println(String.format("%x", bf.get(i)));
    }

} 
