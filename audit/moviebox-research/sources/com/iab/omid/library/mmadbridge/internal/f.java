package com.iab.omid.library.mmadbridge.internal;

import android.annotation.SuppressLint;
import android.content.Context;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static f f42365b = new f();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f42366a;

    public static f c() {
        return f42365b;
    }

    public Context a() {
        return this.f42366a;
    }

    public void b(Context context) {
        this.f42366a = context != null ? context.getApplicationContext() : null;
    }
}
