package com.cloud.tmc.miniutils.util;

import android.os.Vibrator;
import androidx.annotation.RequiresPermission;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Vibrator f31996a;

    @RequiresPermission("android.permission.VIBRATE")
    public static void a() {
        Vibrator vibratorB = b();
        if (vibratorB == null) {
            return;
        }
        vibratorB.cancel();
    }

    public static Vibrator b() {
        if (f31996a == null) {
            f31996a = (Vibrator) e0.a().getSystemService("vibrator");
        }
        return f31996a;
    }

    @RequiresPermission("android.permission.VIBRATE")
    public static void c(long j11) {
        Vibrator vibratorB = b();
        if (vibratorB == null) {
            return;
        }
        vibratorB.vibrate(j11);
    }

    @RequiresPermission("android.permission.VIBRATE")
    public static void d(long[] jArr, int i11) {
        Vibrator vibratorB = b();
        if (vibratorB == null) {
            return;
        }
        vibratorB.vibrate(jArr, i11);
    }
}
