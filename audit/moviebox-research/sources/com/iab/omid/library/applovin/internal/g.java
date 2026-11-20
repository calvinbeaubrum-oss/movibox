package com.iab.omid.library.applovin.internal;

import android.annotation.SuppressLint;
import android.content.Context;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static g f42133b = new g();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f42134a;

    private g() {
    }

    public static g b() {
        return f42133b;
    }

    public Context a() {
        return this.f42134a;
    }

    public void a(Context context) {
        this.f42134a = context != null ? context.getApplicationContext() : null;
    }
}
