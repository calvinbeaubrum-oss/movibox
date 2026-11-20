package com.applovin.impl;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class dh extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f18447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f18448b;

    public dh(String str, Throwable th2, boolean z11, int i11) {
        super(str, th2);
        this.f18447a = z11;
        this.f18448b = i11;
    }

    public static dh a(String str) {
        return new dh(str, null, false, 1);
    }

    public static dh a(String str, Throwable th2) {
        return new dh(str, th2, true, 1);
    }

    public static dh b(String str, Throwable th2) {
        return new dh(str, th2, true, 0);
    }
}
