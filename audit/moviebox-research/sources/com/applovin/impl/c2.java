package com.applovin.impl;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c2 implements be {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList f18080a = new ArrayList(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashSet f18081b = new HashSet(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ce.a f18082c = new ce.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a7.a f18083d = new a7.a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Looper f18084e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private fo f18085f;

    public final a7.a a(int i11, be.a aVar) {
        return this.f18083d.a(i11, aVar);
    }

    public final a7.a a(be.a aVar) {
        return this.f18083d.a(0, aVar);
    }

    public final ce.a a(int i11, be.a aVar, long j11) {
        return this.f18082c.a(i11, aVar, j11);
    }

    @Override // com.applovin.impl.be
    public final void a(Handler handler, a7 a7Var) {
        b1.a(handler);
        b1.a(a7Var);
        this.f18083d.a(handler, a7Var);
    }

    @Override // com.applovin.impl.be
    public final void a(Handler handler, ce ceVar) {
        b1.a(handler);
        b1.a(ceVar);
        this.f18082c.a(handler, ceVar);
    }

    @Override // com.applovin.impl.be
    public final void a(a7 a7Var) {
        this.f18083d.e(a7Var);
    }

    @Override // com.applovin.impl.be
    public final void a(be.b bVar) {
        boolean z11 = !this.f18081b.isEmpty();
        this.f18081b.remove(bVar);
        if (z11 && this.f18081b.isEmpty()) {
            e();
        }
    }

    @Override // com.applovin.impl.be
    public final void a(be.b bVar, xo xoVar) {
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.f18084e;
        b1.a(looper == null || looper == looperMyLooper);
        fo foVar = this.f18085f;
        this.f18080a.add(bVar);
        if (this.f18084e == null) {
            this.f18084e = looperMyLooper;
            this.f18081b.add(bVar);
            a(xoVar);
        } else if (foVar != null) {
            b(bVar);
            bVar.a(this, foVar);
        }
    }

    @Override // com.applovin.impl.be
    public final void a(ce ceVar) {
        this.f18082c.a(ceVar);
    }

    public final void a(fo foVar) {
        this.f18085f = foVar;
        Iterator it = this.f18080a.iterator();
        while (it.hasNext()) {
            ((be.b) it.next()).a(this, foVar);
        }
    }

    public abstract void a(xo xoVar);

    public final ce.a b(be.a aVar) {
        return this.f18082c.a(0, aVar, 0L);
    }

    @Override // com.applovin.impl.be
    public final void b(be.b bVar) {
        b1.a(this.f18084e);
        boolean zIsEmpty = this.f18081b.isEmpty();
        this.f18081b.add(bVar);
        if (zIsEmpty) {
            f();
        }
    }

    @Override // com.applovin.impl.be
    public final void c(be.b bVar) {
        this.f18080a.remove(bVar);
        if (!this.f18080a.isEmpty()) {
            a(bVar);
            return;
        }
        this.f18084e = null;
        this.f18085f = null;
        this.f18081b.clear();
        h();
    }

    @Override // com.applovin.impl.be
    public /* synthetic */ boolean c() {
        return ht.a(this);
    }

    @Override // com.applovin.impl.be
    public /* synthetic */ fo d() {
        return ht.b(this);
    }

    public void e() {
    }

    public void f() {
    }

    public final boolean g() {
        return !this.f18081b.isEmpty();
    }

    public abstract void h();
}
