package com.danikula.videocache;

import android.util.Log;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f32381a = false;

    public static void a(String str) {
    }

    public static void b(String str) {
        if (f32381a) {
            Log.e("Download_VideoCache", str);
        }
    }

    public static void c(String str) {
    }

    public static void d(boolean z11) {
        f32381a = z11;
    }

    public static void e(String str) {
        if (f32381a) {
            Log.v("Download_VideoCache", str);
        }
    }

    public static void f(String str) {
        if (f32381a) {
            Log.w("Download_VideoCache", str);
        }
    }
}
