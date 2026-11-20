package com.bytedance.sdk.openadsdk.core.settings;

import android.util.Log;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Tf {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static final AtomicInteger f28496sc = new AtomicInteger(1);

    public static void sc(int i11) {
        boolean z11 = true;
        if (i11 != 1 && i11 != 2) {
            return;
        }
        try {
            AtomicInteger atomicInteger = f28496sc;
            if (atomicInteger.get() != i11) {
                try {
                    atomicInteger.set(i11);
                } catch (Throwable th2) {
                    th = th2;
                    com.bytedance.sdk.component.utils.Tf.sc("SdkSwitch", th.getMessage());
                    if (!z11) {
                        return;
                    }
                }
                Log.e("SdkSwitch", "switch status changed: " + sc());
                if (sc()) {
                    com.bytedance.sdk.openadsdk.We.sc.We.pFF();
                } else {
                    com.bytedance.sdk.openadsdk.We.sc.We.zY();
                }
            }
        } catch (Throwable th3) {
            th = th3;
            z11 = false;
        }
    }

    public static boolean sc() {
        return f28496sc.get() == 1;
    }
}
