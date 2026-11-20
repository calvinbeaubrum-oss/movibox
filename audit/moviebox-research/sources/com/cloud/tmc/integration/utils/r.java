package com.cloud.tmc.integration.utils;

import android.content.Context;
import com.cloud.tmc.kernel.log.TmcLogger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static float f31109a;

    public static int a(Context context, float f11) {
        b(context);
        return (int) ((f11 * f31109a) + 0.5f);
    }

    public static void b(Context context) {
        try {
            if (f31109a == 0.0f) {
                f31109a = context.getResources().getDisplayMetrics().density;
            }
        } catch (Throwable th2) {
            TmcLogger.h("TmcKernel:DimensionUtil", th2);
        }
    }
}
