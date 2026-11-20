package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class UFX {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static String f28757sc;

    public static String sc() {
        if (TextUtils.isEmpty(f28757sc)) {
            f28757sc = q8.c.e().getCacheDir() + File.separator + "proxy_cache";
        }
        return f28757sc;
    }

    public static void sc(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th2) {
                th2.getMessage();
            }
        }
    }
}
