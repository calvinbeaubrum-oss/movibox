package com.google.android.exoplayer2.drm;

import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.o0;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface b {

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f33165a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final com.google.android.exoplayer2.source.i.b f33166b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final CopyOnWriteArrayList<C0360a> f33167c;

        /* JADX INFO: renamed from: com.google.android.exoplayer2.drm.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static final class C0360a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Handler f33168a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public b f33169b;

            public C0360a(Handler handler, b bVar) {
                this.f33168a = handler;
                this.f33169b = bVar;
            }
        }

        public a() {
            this(new CopyOnWriteArrayList(), 0, null);
        }

        public a(CopyOnWriteArrayList<C0360a> copyOnWriteArrayList, int i11, @Nullable com.google.android.exoplayer2.source.i.b bVar) {
            this.f33167c = copyOnWriteArrayList;
            this.f33165a = i11;
            this.f33166b = bVar;
        }

        public void g(Handler handler, b bVar) {
            com.google.android.exoplayer2.util.a.e(handler);
            com.google.android.exoplayer2.util.a.e(bVar);
            this.f33167c.add(new C0360a(handler, bVar));
        }

        public void h() {
            for (C0360a c0360a : this.f33167c) {
                final b bVar = c0360a.f33169b;
                o0.L0(c0360a.f33168a, new Runnable() { // from class: sg.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f76345a.n(bVar);
                    }
                });
            }
        }

        public void i() {
            for (C0360a c0360a : this.f33167c) {
                final b bVar = c0360a.f33169b;
                o0.L0(c0360a.f33168a, new Runnable() { // from class: sg.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f76343a.o(bVar);
                    }
                });
            }
        }

        public void j() {
            for (C0360a c0360a : this.f33167c) {
                final b bVar = c0360a.f33169b;
                o0.L0(c0360a.f33168a, new Runnable() { // from class: sg.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f76347a.p(bVar);
                    }
                });
            }
        }

        public void k(final int i11) {
            for (C0360a c0360a : this.f33167c) {
                final b bVar = c0360a.f33169b;
                o0.L0(c0360a.f33168a, new Runnable() { // from class: sg.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f76340a.q(bVar, i11);
                    }
                });
            }
        }

        public void l(final Exception exc) {
            for (C0360a c0360a : this.f33167c) {
                final b bVar = c0360a.f33169b;
                o0.L0(c0360a.f33168a, new Runnable() { // from class: sg.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f76337a.r(bVar, exc);
                    }
                });
            }
        }

        public void m() {
            for (C0360a c0360a : this.f33167c) {
                final b bVar = c0360a.f33169b;
                o0.L0(c0360a.f33168a, new Runnable() { // from class: sg.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f76335a.s(bVar);
                    }
                });
            }
        }

        public final /* synthetic */ void n(b bVar) {
            bVar.C(this.f33165a, this.f33166b);
        }

        public final /* synthetic */ void o(b bVar) {
            bVar.u(this.f33165a, this.f33166b);
        }

        public final /* synthetic */ void p(b bVar) {
            bVar.F(this.f33165a, this.f33166b);
        }

        public final /* synthetic */ void q(b bVar, int i11) {
            bVar.v(this.f33165a, this.f33166b);
            bVar.D(this.f33165a, this.f33166b, i11);
        }

        public final /* synthetic */ void r(b bVar, Exception exc) {
            bVar.y(this.f33165a, this.f33166b, exc);
        }

        public final /* synthetic */ void s(b bVar) {
            bVar.E(this.f33165a, this.f33166b);
        }

        public void t(b bVar) {
            for (C0360a c0360a : this.f33167c) {
                if (c0360a.f33169b == bVar) {
                    this.f33167c.remove(c0360a);
                }
            }
        }

        @CheckResult
        public a u(int i11, @Nullable com.google.android.exoplayer2.source.i.b bVar) {
            return new a(this.f33167c, i11, bVar);
        }
    }

    void C(int i11, @Nullable com.google.android.exoplayer2.source.i.b bVar);

    void D(int i11, @Nullable com.google.android.exoplayer2.source.i.b bVar, int i12);

    void E(int i11, @Nullable com.google.android.exoplayer2.source.i.b bVar);

    void F(int i11, @Nullable com.google.android.exoplayer2.source.i.b bVar);

    void u(int i11, @Nullable com.google.android.exoplayer2.source.i.b bVar);

    @Deprecated
    void v(int i11, @Nullable com.google.android.exoplayer2.source.i.b bVar);

    void y(int i11, @Nullable com.google.android.exoplayer2.source.i.b bVar, Exception exc);
}
