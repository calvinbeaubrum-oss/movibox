package com.applovin.impl;

import android.content.Context;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class hh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f19484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f19486c;

    public hh(String str, String str2, Context context) {
        this.f19484a = str.replace("android.permission.", "");
        this.f19485b = str2;
        this.f19486c = z3.a(str, context);
    }

    public String a() {
        return this.f19485b;
    }

    public String b() {
        return this.f19484a;
    }

    public boolean c() {
        return this.f19486c;
    }
}
