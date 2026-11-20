package com.applovin.impl;

import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class an extends yl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final WeakReference f17737h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Object f17738i;

    public an(fi fiVar, Object obj, String str, com.applovin.impl.sdk.j jVar) {
        super(str, jVar);
        this.f17737h = new WeakReference(fiVar);
        this.f17738i = obj;
    }

    public static void a(long j11, fi fiVar, Object obj, String str, com.applovin.impl.sdk.j jVar) {
        if (j11 <= 0) {
            return;
        }
        jVar.j0().a(new an(fiVar, obj, str, jVar), tm.b.TIMEOUT, j11);
    }

    @Override // java.lang.Runnable
    public void run() {
        fi fiVar = (fi) this.f17737h.get();
        if (fiVar == null || fiVar.c()) {
            return;
        }
        this.f24689a.J();
        if (com.applovin.impl.sdk.n.a()) {
            this.f24689a.J().d(this.f24690b, "Attempting to timeout pending task " + fiVar.b() + " with " + this.f17738i);
        }
        fiVar.a(this.f17738i);
    }
}
