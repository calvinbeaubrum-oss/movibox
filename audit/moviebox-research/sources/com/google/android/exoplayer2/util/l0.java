package com.google.android.exoplayer2.util;

import android.os.Trace;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class l0 {
    public static void a(String str) {
        if (o0.f35608a >= 18) {
            b(str);
        }
    }

    @RequiresApi(18)
    public static void b(String str) {
        Trace.beginSection(str);
    }

    public static void c() {
        if (o0.f35608a >= 18) {
            d();
        }
    }

    @RequiresApi(18)
    public static void d() {
        Trace.endSection();
    }
}
