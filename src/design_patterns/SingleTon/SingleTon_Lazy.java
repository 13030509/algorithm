package design_patterns.SingleTon;

import java.util.HashMap;
import java.util.Map;

public class SingleTon_Lazy {

    private static Map map = null;


    private SingleTon_Lazy() {


    }


    public static Map getInstance()  {

        if (null == map) {
/*            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            map = new HashMap();

            System.out.println("I am in ");
        }
        return map;
    }


    public static void main(String[] args) {

        Map map1 = SingleTon_Lazy.getInstance();
        Map map2 = SingleTon_Lazy.getInstance();

        System.out.println(map1==map2);

    }


}
