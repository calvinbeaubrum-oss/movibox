package com.facebook.biddingkit.logging;

import android.annotation.SuppressLint;
import android.content.Context;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f32478a = false;

    @SuppressLint({"CatchGeneralException"})
    public static void a(Context context, String str, String str2, String str3) {
        try {
            a.b(context, str, str2);
            EventLogDispatcher.j(new i(str3));
            f.f(context);
            c.b();
        } catch (Exception e11) {
            b.d("Logging", "Failed to initialize", e11);
        }
    }

    public static synchronized boolean b() {
        return f32478a;
    }

    public static synchronized void c(boolean z11) {
        f32478a = z11;
    }
}
