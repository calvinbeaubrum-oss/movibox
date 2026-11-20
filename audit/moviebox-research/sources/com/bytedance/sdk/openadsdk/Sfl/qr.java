package com.bytedance.sdk.openadsdk.Sfl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class qr {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static sc f27247sc;

    /* JADX INFO: compiled from: source.java */
    public interface sc {
        void sc(String str, String str2, Throwable th2);
    }

    public static void sc(sc scVar) {
        f27247sc = scVar;
    }

    public static void sc(String str, String str2, Throwable th2) {
        if (f27247sc == null) {
            return;
        }
        if (th2 == null) {
            th2 = new Throwable();
        }
        f27247sc.sc(str, str2, th2);
    }

    public static boolean sc() {
        return f27247sc != null;
    }
}
