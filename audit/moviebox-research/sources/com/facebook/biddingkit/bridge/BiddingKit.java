package com.facebook.biddingkit.bridge;

import android.content.Context;
import com.facebook.biddingkit.logging.h;
import xf.a;
import xf.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class BiddingKit {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Context f32418a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile String f32419b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f32420c = false;

    public static Context a() {
        return f32418a;
    }

    public static String b() {
        return f32419b;
    }

    public static synchronized void c(final Context context, final String str) {
        try {
            if (!f32420c) {
                if (context == null) {
                    throw new IllegalArgumentException("Missing Context");
                }
                f32418a = context.getApplicationContext();
                f32420c = true;
                f32419b = str;
                a.f80479b.execute(new Runnable() { // from class: com.facebook.biddingkit.bridge.BiddingKit.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Context context2 = context;
                        h.a(context2, c.c(context2), "0.5.1", str);
                    }
                });
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static synchronized void d(boolean z11) {
        h.c(z11);
    }
}
