package com.applovin.impl;

import android.os.Bundle;
import android.util.SparseArray;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class p2 {
    public static SparseArray a(o2.a aVar, SparseArray sparseArray, SparseArray sparseArray2) {
        if (sparseArray == null) {
            return sparseArray2;
        }
        SparseArray sparseArray3 = new SparseArray(sparseArray.size());
        for (int i11 = 0; i11 < sparseArray.size(); i11++) {
            sparseArray3.put(sparseArray.keyAt(i11), aVar.a((Bundle) sparseArray.valueAt(i11)));
        }
        return sparseArray3;
    }

    public static eb a(o2.a aVar, List list) {
        eb.a aVarF = eb.f();
        for (int i11 = 0; i11 < list.size(); i11++) {
            aVarF.b(aVar.a((Bundle) b1.a((Bundle) list.get(i11))));
        }
        return aVarF.a();
    }

    public static o2 a(o2.a aVar, Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        return aVar.a(bundle);
    }

    public static List a(o2.a aVar, List list, List list2) {
        return list == null ? list2 : a(aVar, list);
    }

    public static void a(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader((ClassLoader) xp.a(p2.class.getClassLoader()));
        }
    }
}
