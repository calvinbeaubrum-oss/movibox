package com.bytedance.adsdk.ugeno.TRI;

import java.util.Collection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We {
    public static int sc(boolean z11, int i11, int i12) {
        if (i12 == 0 || !z11) {
            return i11;
        }
        int i13 = i11 - 1073741823;
        int iAbs = Math.abs(i13) % i12;
        return (i13 >= 0 || iAbs == 0) ? iAbs : i12 - iAbs;
    }

    public static boolean sc(int i11, Collection<?> collection) {
        return i11 >= 0 && i11 < collection.size();
    }
}
