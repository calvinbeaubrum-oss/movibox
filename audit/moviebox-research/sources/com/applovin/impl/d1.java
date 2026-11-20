package com.applovin.impl;

import android.content.Context;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d1 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.applovin.impl.sdk.j f18335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final String f18336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.applovin.impl.sdk.n f18337c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final AtomicBoolean f18339e = new AtomicBoolean();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f18338d = com.applovin.impl.sdk.j.l();

    public d1(String str, com.applovin.impl.sdk.j jVar) {
        this.f18336b = str;
        this.f18335a = jVar;
        this.f18337c = jVar.J();
    }

    public Context a() {
        return this.f18338d;
    }

    public void a(boolean z11) {
        this.f18339e.set(z11);
    }
}
