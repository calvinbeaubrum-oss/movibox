package com.bytedance.adsdk.ugeno.qr;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class We {
    private static Resources pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static String f26443sc;

    @SuppressLint({"StaticFieldLeak"})
    private static Context zY;

    public static int sc(Context context, String str) {
        return sc(context, str, "drawable");
    }

    private static int sc(Context context, String str, String str2) {
        if (pFF == null) {
            pFF = context.getResources();
        }
        return pFF.getIdentifier(str, str2, sc(context));
    }

    private static String sc(Context context) {
        if (f26443sc == null) {
            f26443sc = context.getPackageName();
        }
        return f26443sc;
    }

    public static void sc(String str) {
        f26443sc = str;
    }
}
