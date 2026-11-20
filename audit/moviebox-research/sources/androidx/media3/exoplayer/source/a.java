package androidx.media3.exoplayer.source;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.media3.common.b0;
import androidx.media3.common.m0;
import e4.x3;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<l.c> f11117a = new ArrayList<>(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet<l.c> f11118b = new HashSet<>(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m.a f11119c = new m.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.media3.exoplayer.drm.b.a f11120d = new androidx.media3.exoplayer.drm.b.a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public Looper f11121e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public m0 f11122f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public x3 f11123g;

    public final void A(m0 m0Var) {
        this.f11122f = m0Var;
        Iterator<l.c> it = this.f11117a.iterator();
        while (it.hasNext()) {
            it.next().a(this, m0Var);
        }
    }

    public abstract void B();

    @Override // androidx.media3.exoplayer.source.l
    public /* synthetic */ boolean c() {
        return p4.p.c(this);
    }

    @Override // androidx.media3.exoplayer.source.l
    public /* synthetic */ m0 d() {
        return p4.p.b(this);
    }

    @Override // androidx.media3.exoplayer.source.l
    public final void e(Handler handler, m mVar) {
        z3.a.e(handler);
        z3.a.e(mVar);
        this.f11119c.g(handler, mVar);
    }

    @Override // androidx.media3.exoplayer.source.l
    public final void f(m mVar) {
        this.f11119c.B(mVar);
    }

    @Override // androidx.media3.exoplayer.source.l
    public final void i(l.c cVar, @Nullable c4.o oVar, x3 x3Var) {
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.f11121e;
        z3.a.a(looper == null || looper == looperMyLooper);
        this.f11123g = x3Var;
        m0 m0Var = this.f11122f;
        this.f11117a.add(cVar);
        if (this.f11121e == null) {
            this.f11121e = looperMyLooper;
            this.f11118b.add(cVar);
            z(oVar);
        } else if (m0Var != null) {
            m(cVar);
            cVar.a(this, m0Var);
        }
    }

    @Override // androidx.media3.exoplayer.source.l
    public final void j(Handler handler, androidx.media3.exoplayer.drm.b bVar) {
        z3.a.e(handler);
        z3.a.e(bVar);
        this.f11120d.g(handler, bVar);
    }

    @Override // androidx.media3.exoplayer.source.l
    public final void k(androidx.media3.exoplayer.drm.b bVar) {
        this.f11120d.t(bVar);
    }

    @Override // androidx.media3.exoplayer.source.l
    public final void m(l.c cVar) {
        z3.a.e(this.f11121e);
        boolean zIsEmpty = this.f11118b.isEmpty();
        this.f11118b.add(cVar);
        if (zIsEmpty) {
            w();
        }
    }

    @Override // androidx.media3.exoplayer.source.l
    public /* synthetic */ void n(b0 b0Var) {
        p4.p.d(this, b0Var);
    }

    @Override // androidx.media3.exoplayer.source.l
    public final void o(l.c cVar) {
        this.f11117a.remove(cVar);
        if (!this.f11117a.isEmpty()) {
            p(cVar);
            return;
        }
        this.f11121e = null;
        this.f11122f = null;
        this.f11123g = null;
        this.f11118b.clear();
        B();
    }

    @Override // androidx.media3.exoplayer.source.l
    public final void p(l.c cVar) {
        boolean z11 = !this.f11118b.isEmpty();
        this.f11118b.remove(cVar);
        if (z11 && this.f11118b.isEmpty()) {
            v();
        }
    }

    @Override // androidx.media3.exoplayer.source.l
    public /* synthetic */ boolean q(b0 b0Var) {
        return p4.p.a(this, b0Var);
    }

    public final androidx.media3.exoplayer.drm.b.a r(int i11, @Nullable l.b bVar) {
        return this.f11120d.u(i11, bVar);
    }

    public final androidx.media3.exoplayer.drm.b.a s(@Nullable l.b bVar) {
        return this.f11120d.u(0, bVar);
    }

    public final m.a t(int i11, @Nullable l.b bVar) {
        return this.f11119c.E(i11, bVar);
    }

    public final m.a u(@Nullable l.b bVar) {
        return this.f11119c.E(0, bVar);
    }

    public void v() {
    }

    public void w() {
    }

    public final x3 x() {
        return (x3) z3.a.i(this.f11123g);
    }

    public final boolean y() {
        return !this.f11118b.isEmpty();
    }

    public abstract void z(@Nullable c4.o oVar);
}
