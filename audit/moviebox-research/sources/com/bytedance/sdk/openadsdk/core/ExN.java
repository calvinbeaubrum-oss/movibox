package com.bytedance.sdk.openadsdk.core;

import android.annotation.SuppressLint;
import android.content.Context;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class ExN extends TRI {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile ExN f28003sc;

    private ExN(Context context) {
        super(context);
    }

    public static ExN sc(Context context) {
        if (f28003sc == null) {
            synchronized (ExN.class) {
                try {
                    if (f28003sc == null) {
                        f28003sc = new ExN(context);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f28003sc;
    }

    @Override // com.bytedance.sdk.openadsdk.core.TRI
    public /* bridge */ /* synthetic */ TRI.zY sc() {
        return super.sc();
    }
}
