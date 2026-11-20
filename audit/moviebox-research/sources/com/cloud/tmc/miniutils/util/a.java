package com.cloud.tmc.miniutils.util;

import android.app.Activity;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static void a(@NonNull Class<? extends Activity> cls) {
        b(cls, false);
    }

    public static void b(@NonNull Class<? extends Activity> cls, boolean z11) {
        for (Activity activity : h0.g()) {
            if (activity.getClass().equals(cls)) {
                activity.finish();
                if (!z11) {
                    activity.overridePendingTransition(0, 0);
                }
            }
        }
    }

    public static Activity c() {
        return h0.m();
    }

    public static boolean d(Activity activity) {
        return (activity == null || activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }
}
