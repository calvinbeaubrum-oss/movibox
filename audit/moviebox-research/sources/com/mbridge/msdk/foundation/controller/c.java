package com.mbridge.msdk.foundation.controller;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class c extends a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile c f44076f;

    private c() {
    }

    public static c m() {
        if (f44076f == null) {
            synchronized (c.class) {
                try {
                    if (f44076f == null) {
                        f44076f = new c();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f44076f;
    }

    @Override // com.mbridge.msdk.foundation.controller.a
    public final void a(a.InterfaceC0484a interfaceC0484a) {
    }
}
