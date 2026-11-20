package com.mbridge.msdk.foundation.tools;

import android.net.ConnectivityManager;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConnectivityManager f45089a;

    public static synchronized ConnectivityManager a() {
        try {
            if (f45089a == null && com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                f45089a = (ConnectivityManager) com.mbridge.msdk.foundation.controller.c.m().c().getSystemService("connectivity");
            }
        } catch (Exception e11) {
            ad.b("NetManager", e11.getMessage());
        }
        return f45089a;
    }
}
