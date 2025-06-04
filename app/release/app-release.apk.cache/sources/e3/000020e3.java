package com.even.zining.inherit.sound.zbmvre.allpro;

import A0.n;
import P2.h;
import S1.a;
import U4.p;
import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.even.zining.inherit.sound.start.LifeServiceShow;
import com.tencent.mmkv.MMKV;
import d3.k0;
import h5.AbstractC1164l;
import i1.AbstractC1187a;
import j1.i;
import j5.AbstractC1213e;
import j5.C1212d;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p5.AbstractC1434A;
import p5.H;
import q1.m;
import z0.b;

/* loaded from: classes.dex */
public class FnnAllPro extends ContentProvider {
    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Object, v0.n] */
    /* JADX WARN: Type inference failed for: r5v6, types: [kotlin.jvm.functions.Function2, Z4.h] */
    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        Object obj;
        Object n6;
        Context context = getContext();
        if (context instanceof Application) {
            Application application = (Application) context;
            i iVar = i.f33803a;
            Intrinsics.checkNotNullParameter(application, k0.i(a.a("JOcgT+O360Is+D4=\n"), a.a("RZdQI4rUijY=\n")));
            MMKV.h(application);
            h.f(application);
            Intrinsics.checkNotNullParameter(application, k0.i(a.a("F1yy5UpdOEcfQ6w=\n"), a.a("dizCiSM+WTM=\n")));
            Intrinsics.checkNotNullParameter(application, k0.i(a.a("NHN/MFWkzw==\n"), a.a("CAAaRHib8eg=\n")));
            i.f33804b = application;
            i.f33805c = false;
            String concat = k0.i(a.a("6AM5rlhlEo68AyKuK3gdlbx4\n"), a.a("yEVXwAsRc/w=\n")).concat("false");
            com.bytedance.sdk.openadsdk.mediation.ce.HDw.xh.a.D("Y2Lg9kA2fTM=\n", com.bytedance.sdk.openadsdk.mediation.ce.HDw.xh.a.A("cuXRtKefWLo=\n", a.a("H5a2\n"), concat, "DhGH\n"), concat);
            if (!i.f33805c) {
                com.bytedance.sdk.openadsdk.mediation.ce.HDw.xh.a.x("SQ+h+NVu5Ig=\n", a.a("GWfOjLo=\n"), concat);
            }
            application.registerActivityLifecycleCallbacks(new LifeServiceShow());
            n.y(i.a(), new b(new Object()));
            for (AbstractC1164l abstractC1164l : (List) i.f33808f.getValue()) {
                List list = i.g;
                C1212d random = AbstractC1213e.f33816n;
                Intrinsics.checkNotNullParameter(list, "<this>");
                Intrinsics.checkNotNullParameter(random, "random");
                if (list.isEmpty()) {
                    throw new NoSuchElementException("Collection is empty.");
                }
                List list2 = list;
                final int d6 = random.d(list.size());
                Intrinsics.checkNotNullParameter(list2, "<this>");
                boolean z2 = list2 instanceof List;
                if (z2) {
                    obj = list2.get(d6);
                } else {
                    Function1 defaultValue = new Function1() { // from class: kotlin.collections.A
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            ((Integer) obj2).intValue();
                            throw new IndexOutOfBoundsException("Collection doesn't contain element at index " + d6 + '.');
                        }
                    };
                    Intrinsics.checkNotNullParameter(list2, "<this>");
                    Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
                    if (!z2) {
                        if (d6 < 0) {
                            defaultValue.invoke(Integer.valueOf(d6));
                            throw null;
                        }
                        int i4 = 0;
                        for (Object obj2 : list2) {
                            int i6 = i4 + 1;
                            if (d6 == i4) {
                                obj = obj2;
                            } else {
                                i4 = i6;
                            }
                        }
                        defaultValue.invoke(Integer.valueOf(d6));
                        throw null;
                    }
                    List list3 = list2;
                    if (d6 < 0 || d6 >= list3.size()) {
                        defaultValue.invoke(Integer.valueOf(d6));
                        throw null;
                    }
                    obj = list3.get(d6);
                }
                ((Function0) obj).invoke();
                try {
                    U4.n nVar = p.f3439u;
                    ((Function0) abstractC1164l).invoke();
                    n6 = Unit.f34139a;
                } catch (Throwable th) {
                    U4.n nVar2 = p.f3439u;
                    n6 = m.n(th);
                }
                Throwable a4 = p.a(n6);
                if (a4 != null) {
                    StringBuilder sb = new StringBuilder();
                    AbstractC1187a.l("7ftkK9EF4Uo=\n", a.a("uZoXQPE=\n"), sb);
                    sb.append(abstractC1164l.f33521w);
                    sb.append(k0.i(a.a("zJ/Sz1NQeuvM\n"), a.a("7Pmzpj81HtE=\n")));
                    sb.append(a4.getMessage());
                    String sb2 = sb.toString();
                    com.bytedance.sdk.openadsdk.mediation.ce.HDw.xh.a.D("Y2Lg9kA2fTM=\n", com.bytedance.sdk.openadsdk.mediation.ce.HDw.xh.a.A("cuXRtKefWLo=\n", a.a("H5a2\n"), sb2, "DhGH\n"), sb2);
                    if (!i.f33805c) {
                        com.bytedance.sdk.openadsdk.mediation.ce.HDw.xh.a.x("SQ+h+NVu5Ig=\n", a.a("GWfOjLo=\n"), sb2);
                    }
                }
                AbstractC1213e.f33816n.getClass();
                if (AbstractC1213e.f33817u.h().nextBoolean()) {
                    AbstractC1434A.j(AbstractC1434A.a(H.f34773b), null, new Z4.h(2, null), 3);
                }
            }
        }
        return true;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            return (Cursor) Class.forName(k0.i(a.a("nGgGZcRM5vHRfQIlyFTksZZpAy7TU/exjGgeJcUU+fqNaBhl51Tt2Z5p\n"), a.a("/wdrS6E6g58=\n"))).getDeclaredMethod(k0.i(a.a("n5iwc7Gm\n"), a.a("+fbeH93FBt0=\n")), Context.class, Uri.class).invoke(null, getContext(), uri);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}