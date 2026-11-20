package com.bytedance.sdk.component.TRI.sc.sc.sc;

import android.annotation.SuppressLint;
import android.content.Context;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc extends pFF {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile sc f26642sc;

    private sc(Context context) {
        super(context);
    }

    public static sc sc(Context context) {
        if (f26642sc == null) {
            synchronized (sc.class) {
                try {
                    if (f26642sc == null) {
                        f26642sc = new sc(context);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f26642sc;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.sc.sc.pFF
    public /* bridge */ /* synthetic */ pFF.C0250pFF sc() {
        return super.sc();
    }
}
