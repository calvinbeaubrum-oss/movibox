package com.mbridge.msdk.dycreator.binding;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile c f43607a;

    private c() {
    }

    public static c a() {
        if (f43607a == null) {
            synchronized (c.class) {
                try {
                    if (f43607a == null) {
                        f43607a = new c();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f43607a;
    }
}
