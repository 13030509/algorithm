package design_patterns.adptor;

public class AdaptorTest {

    public static void main(String[] args) {

        Targetable target = new Adaptor();

        target.method1();
        target.method2();


        Source source = new Source();
        Targetable wapper = new Wrapper(source);

        wapper.method1();
        wapper.method2();


    }

}
