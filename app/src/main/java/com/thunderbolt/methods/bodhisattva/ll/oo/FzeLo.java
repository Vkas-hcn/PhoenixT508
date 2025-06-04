package com.thunderbolt.methods.bodhisattva.ll.oo;

import android.content.Context;

import androidx.annotation.Keep;

@Keep
public class FzeLo {

    static {
        try {
            System.loadLibrary("ffzoo");
        } catch (Exception e) {
        }
    }

    @Keep
    public static native boolean ffzoojk(Context context, int num);//参数num%8==5隐藏图标,num%8==3恢复隐藏.num%8==7外弹(外弹在主进程主线程调用).

}
