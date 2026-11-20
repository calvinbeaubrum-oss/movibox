package com.bytedance.sdk.component.TRI.sc.TRI;

import com.bytedance.sdk.component.TRI.sc.Qj;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static volatile pFF f26590sc;

    public static pFF sc() {
        if (f26590sc == null) {
            synchronized (pFF.class) {
                try {
                    if (f26590sc == null) {
                        f26590sc = new zY(Qj.qr().TRI(), new TRI(Qj.qr().TRI()));
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f26590sc;
    }
}
