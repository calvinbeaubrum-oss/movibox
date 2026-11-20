package com.cloud.tmc.miniutils.util;

import android.content.res.Resources;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class x {

    /* JADX INFO: compiled from: source.java */
    public interface a {
    }

    public static int a(float f11) {
        return (int) ((f11 * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static int b(float f11) {
        return (int) ((f11 / Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }
}
