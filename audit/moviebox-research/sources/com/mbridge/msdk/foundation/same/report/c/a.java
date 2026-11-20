package com.mbridge.msdk.foundation.same.report.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f44807a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f44808b;

    private a() {
    }

    public static a a() {
        if (f44808b == null) {
            synchronized (a.class) {
                try {
                    if (f44808b == null) {
                        f44808b = new a();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f44808b;
    }
}
