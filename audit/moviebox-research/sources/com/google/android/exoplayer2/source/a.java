package com.google.android.exoplayer2.source;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.j3;
import com.google.android.exoplayer2.upstream.k0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import qg.u1;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<i.c> f33762a = new ArrayList<>(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet<i.c> f33763b = new HashSet<>(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j.a f33764c = new j.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.b.a f33765d = new com.google.android.exoplayer2.drm.b.a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public Looper f33766f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public j3 f33767g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public u1 f33768h;

    public final boolean A() {
        return !this.f33763b.isEmpty();
    }

    public abstract void B(@Nullable k0 k0Var);

    public final void C(j3 j3Var) {
        this.f33767g = j3Var;
        Iterator<i.c> it = this.f33762a.iterator();
        while (it.hasNext()) {
            it.next().a(this, j3Var);
        }
    }

    public abstract void D();

    @Override // com.google.android.exoplayer2.source.i
    public /* synthetic */ boolean c() {
        return nh.q.b(this);
    }

    @Override // com.google.android.exoplayer2.source.i
    public /* synthetic */ j3 d() {
        return nh.q.a(this);
    }

    @Override // com.google.android.exoplayer2.source.i
    public final void f(i.c cVar) {
        this.f33762a.remove(cVar);
        if (!this.f33762a.isEmpty()) {
            p(cVar);
            return;
        }
        this.f33766f = null;
        this.f33767g = null;
        this.f33768h = null;
        this.f33763b.clear();
        D();
    }

    @Override // com.google.android.exoplayer2.source.i
    public final void h(Handler handler, j jVar) {
        com.google.android.exoplayer2.util.a.e(handler);
        com.google.android.exoplayer2.util.a.e(jVar);
        this.f33764c.g(handler, jVar);
    }

    @Override // com.google.android.exoplayer2.source.i
    public final void i(j jVar) {
        this.f33764c.C(jVar);
    }

    @Override // com.google.android.exoplayer2.source.i
    public final void m(i.c cVar) {
        com.google.android.exoplayer2.util.a.e(this.f33766f);
        boolean zIsEmpty = this.f33763b.isEmpty();
        this.f33763b.add(cVar);
        if (zIsEmpty) {
            y();
        }
    }

    @Override // com.google.android.exoplayer2.source.i
    public final void o(i.c cVar, @Nullable k0 k0Var, u1 u1Var) {
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.f33766f;
        com.google.android.exoplayer2.util.a.a(looper == null || looper == looperMyLooper);
        this.f33768h = u1Var;
        j3 j3Var = this.f33767g;
        this.f33762a.add(cVar);
        if (this.f33766f == null) {
            this.f33766f = looperMyLooper;
            this.f33763b.add(cVar);
            B(k0Var);
        } else if (j3Var != null) {
            m(cVar);
            cVar.a(this, j3Var);
        }
    }

    @Override // com.google.android.exoplayer2.source.i
    public final void p(i.c cVar) {
        boolean z11 = !this.f33763b.isEmpty();
        this.f33763b.remove(cVar);
        if (z11 && this.f33763b.isEmpty()) {
            x();
        }
    }

    @Override // com.google.android.exoplayer2.source.i
    public final void q(Handler handler, com.google.android.exoplayer2.drm.b bVar) {
        com.google.android.exoplayer2.util.a.e(handler);
        com.google.android.exoplayer2.util.a.e(bVar);
        this.f33765d.g(handler, bVar);
    }

    @Override // com.google.android.exoplayer2.source.i
    public final void r(com.google.android.exoplayer2.drm.b bVar) {
        this.f33765d.t(bVar);
    }

    public final com.google.android.exoplayer2.drm.b.a s(int i11, @Nullable i.b bVar) {
        return this.f33765d.u(i11, bVar);
    }

    public final com.google.android.exoplayer2.drm.b.a t(@Nullable i.b bVar) {
        return this.f33765d.u(0, bVar);
    }

    public final j.a u(int i11, @Nullable i.b bVar, long j11) {
        return this.f33764c.F(i11, bVar, j11);
    }

    public final j.a v(@Nullable i.b bVar) {
        return this.f33764c.F(0, bVar, 0L);
    }

    public final j.a w(i.b bVar, long j11) {
        com.google.android.exoplayer2.util.a.e(bVar);
        return this.f33764c.F(0, bVar, j11);
    }

    public void x() {
    }

    public void y() {
    }

    public final u1 z() {
        return (u1) com.google.android.exoplayer2.util.a.i(this.f33768h);
    }
}
