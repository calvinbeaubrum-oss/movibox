package com.blankj.utilcode.util;

import android.os.Vibrator;
import androidx.annotation.RequiresPermission;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Vibrator f25334a;

    public static Vibrator a() {
        if (f25334a == null) {
            f25334a = (Vibrator) Utils.a().getSystemService("vibrator");
        }
        return f25334a;
    }

    @RequiresPermission("android.permission.VIBRATE")
    public static void b(long j11) {
        Vibrator vibratorA = a();
        if (vibratorA == null) {
            return;
        }
        vibratorA.vibrate(j11);
    }
}
