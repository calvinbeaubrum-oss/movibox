package com.applovin.impl;

import android.view.Surface;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class od extends jd {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f21505c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f21506d;

    public od(Throwable th2, kd kdVar, Surface surface) {
        super(th2, kdVar);
        this.f21505c = System.identityHashCode(surface);
        this.f21506d = surface == null || surface.isValid();
    }
}
