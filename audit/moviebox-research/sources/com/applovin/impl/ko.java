package com.applovin.impl;

import android.os.Trace;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ko {
    public static void a() {
        if (xp.f24372a >= 18) {
            b();
        }
    }

    public static void a(String str) {
        if (xp.f24372a >= 18) {
            b(str);
        }
    }

    private static void b() {
        Trace.endSection();
    }

    private static void b(String str) {
        Trace.beginSection(str);
    }
}
