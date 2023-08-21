package org.bfsi.bureau.utils;

import java.util.Random;


public class BureauScore {

    public static int getBureauScore(){
        Random r = new Random();
        int low = 300;
        int high = 900;
        return r.nextInt(high-low) + low;
    }

}
