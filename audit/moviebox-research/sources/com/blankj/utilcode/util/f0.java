package com.blankj.utilcode.util;

import android.content.res.Resources;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f0 {

    /* JADX INFO: compiled from: source.java */
    public interface a {
    }

    public static int a(float f11) {
        return (int) ((f11 * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static int b(float f11) {
        return (int) ((f11 / Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static int c(float f11) {
        return (int) ((f11 / Resources.getSystem().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int d(float f11) {
        return (int) ((f11 * Resources.getSystem().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
