package com.bytedance.sdk.component.qr.We;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY {
    private pFF pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private sc f26965sc;

    /* JADX INFO: compiled from: source.java */
    public interface pFF {
    }

    /* JADX INFO: compiled from: source.java */
    public enum sc {
        DEBUG,
        INFO,
        ERROR,
        OFF
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.qr.We.zY$zY, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0263zY {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private static final zY f26967sc = new zY();
    }

    private zY() {
        this.f26965sc = sc.OFF;
        this.pFF = new com.bytedance.sdk.component.qr.We.pFF();
    }

    public static void sc(sc scVar) {
        synchronized (zY.class) {
            C0263zY.f26967sc.f26965sc = scVar;
        }
    }
}
