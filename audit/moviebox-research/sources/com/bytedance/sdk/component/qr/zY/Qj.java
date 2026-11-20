package com.bytedance.sdk.component.qr.zY;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Qj {
    private static HashMap<Integer, TRI> pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static volatile Qj f26981sc;
    private static HashMap<Integer, sc> zY;

    private Qj() {
        pFF = new HashMap<>();
        zY = new HashMap<>();
    }

    public static synchronized Qj sc() {
        try {
            if (f26981sc == null) {
                synchronized (Qj.class) {
                    try {
                        if (f26981sc == null) {
                            f26981sc = new Qj();
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        } catch (Throwable th3) {
            throw th3;
        }
        return f26981sc;
    }

    public TRI sc(int i11) {
        TRI tri = pFF.get(Integer.valueOf(i11));
        if (tri != null) {
            return tri;
        }
        TRI tri2 = new TRI(i11);
        pFF.put(Integer.valueOf(i11), tri2);
        return tri2;
    }

    public sc sc(int i11, Context context) {
        sc scVar = zY.get(Integer.valueOf(i11));
        if (scVar != null) {
            return scVar;
        }
        sc scVar2 = new sc(context, i11);
        zY.put(Integer.valueOf(i11), scVar2);
        return scVar2;
    }
}
