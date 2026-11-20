package com.iab.omid.library.bytedance2.internal;

import android.annotation.SuppressLint;
import android.content.Context;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static g f42262b = new g();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f42263a;

    private g() {
    }

    public static g b() {
        return f42262b;
    }

    public Context a() {
        return this.f42263a;
    }

    public void a(Context context) {
        this.f42263a = context != null ? context.getApplicationContext() : null;
    }
}
