package design_patterns.adptor;

public class Adaptor extends Source implements Targetable {

    @Override
    public void method2() {

        System.out.println("this is target method !");

    }
}
