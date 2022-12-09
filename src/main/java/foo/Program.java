package foo;
import java.io.IOException;

public class Program {

    public void runInternal() {
        new Internal().test1().test2();
    }
    
    public static void main(String... args) throws IOException {
        new Program().runInternal();
    }
}