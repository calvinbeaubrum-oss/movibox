package com.cloud.hisavana.sdk;

import android.util.Log;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class z extends com.cloud.sdk.commonutil.util.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static z f30228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f30229b = Log.isLoggable("ADSDK", 3);

    public static synchronized z a() {
        try {
            if (f30228a == null) {
                synchronized (z.class) {
                    try {
                        if (f30228a == null) {
                            f30228a = new z();
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        } catch (Throwable th3) {
            throw th3;
        }
        return f30228a;
    }

    public static boolean b() {
        return f30229b;
    }

    @Override // com.cloud.sdk.commonutil.util.c
    public String getGlobalTag() {
        return "ADSDK_S";
    }
}
