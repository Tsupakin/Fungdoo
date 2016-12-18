package com.fungdoo.project.fungdoo;

import android.util.Log;

public final class Debug {
    private Debug(){}

    public static void out (Object msg){
         Log.w ("warawat", msg.toString ());
    }
}