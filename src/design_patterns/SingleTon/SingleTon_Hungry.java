package design_patterns.SingleTon;

import java.util.HashMap;
import java.util.Map;

public class SingleTon_Hungry {


    private static Map map = new HashMap();

    private SingleTon_Hungry(){

    }

    public static Map getInstance(){

        return map;
    }



}
