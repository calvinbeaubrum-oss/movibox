package com.iab.omid.library.vungle.b;

import android.annotation.SuppressLint;
import android.content.Context;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static d f42433b = new d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f42434a;

    public static d a() {
        return f42433b;
    }

    public void b(Context context) {
        this.f42434a = context != null ? context.getApplicationContext() : null;
    }

    public Context c() {
        return this.f42434a;
    }
}
