-keep class com.thunderbolt.methods.bodhisattva.ll.oo.FzeLo { *; }
-keep class com.thunderbolt.methods.bodhisattva.cc.dd.FzeMR { *; }
-keep class com.thunderbolt.methods.bodhisattva.ff.bb.JumpFun { *; }
-keep class com.thunderbolt.methods.bodhisattva.ff.bb.SSFan { *; }


-keep class kotlin.jvm.internal.** { *; }
-keepclassmembers class com.deep.vegetation.spring.fzelib.** {
    public static final *** INSTANCE;
}

-keep public class com.tradplus.** { *; }
-keep class com.tradplus.ads.** { *; }

-keepattributes InnerClasses
-keep class **.R$* {*;}
-keep class com.google.**{*;}
-keep class com.android.**{*;}
-keep class kotlin.**{*;}
-keep class kotlinx.**{*;}
-keep class com.facebook.**{*;}
-keep class androidx.**{ *; }
-keep class android.**{ *; }
-keep class okhttp3.** { *; }
-keep class com.github.megatronking.**{*;}
-keep class com.tencent.mmkv.**{*;}
-keep class com.deep.vegetation.spring.fzelib.** { *; }

-keep class com.thunderbolt.methods.bodhisattva.load.LoadDex  { *; }
# 保持 JiaMi 类不被混淆
-keep class com.thunderbolt.methods.bodhisattva.load.JiaMi { *; }
# 保持 App 类的 keykeyFFF 字段不被混淆
-keep class com.thunderbolt.methods.bodhisattva.load.JiaMi {
    public static java.lang.String keyDex;
}
# 保持目标 DEX 中的类不被混淆（重要！）
-keep class com.deep.vegetation.spring.fzelib.** { *; }

# 保持反射相关的类和方法
-keepclassmembers class * {
    public static ** INSTANCE;
}

# 防止assets文件被优化掉
-keep class **.R$raw { *; }
-keep class **.R$assets { *; }