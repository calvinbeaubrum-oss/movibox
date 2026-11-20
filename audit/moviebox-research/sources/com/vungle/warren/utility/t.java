package com.vungle.warren.utility;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f62640a = new Handler(Looper.getMainLooper());

    public static boolean a() {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return mainLooper.isCurrentThread();
        }
        Looper looperMyLooper = Looper.myLooper();
        return looperMyLooper != null && mainLooper.getThread().equals(looperMyLooper.getThread());
    }

    public static void b(@NonNull Runnable runnable) {
        if (a()) {
            runnable.run();
        } else {
            f62640a.post(runnable);
        }
    }
}
