package com.bytedance.sdk.component.Ol.sc;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc {
    private static volatile sc pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private volatile pFF f26551sc;

    private sc() {
    }

    public static sc sc() {
        if (pFF == null) {
            synchronized (sc.class) {
                try {
                    if (pFF == null) {
                        pFF = new sc();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return pFF;
    }

    public pFF pFF() {
        return this.f26551sc;
    }

    public void sc(pFF pff) {
        this.f26551sc = pff;
    }
}
