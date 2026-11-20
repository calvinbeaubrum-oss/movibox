package e4;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.exoplayer.audio.AudioSink;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface c {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f63812a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final androidx.media3.common.m0 f63813b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f63814c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public final androidx.media3.exoplayer.source.l.b f63815d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f63816e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final androidx.media3.common.m0 f63817f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f63818g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        public final androidx.media3.exoplayer.source.l.b f63819h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final long f63820i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final long f63821j;

        public a(long j11, androidx.media3.common.m0 m0Var, int i11, @Nullable androidx.media3.exoplayer.source.l.b bVar, long j12, androidx.media3.common.m0 m0Var2, int i12, @Nullable androidx.media3.exoplayer.source.l.b bVar2, long j13, long j14) {
            this.f63812a = j11;
            this.f63813b = m0Var;
            this.f63814c = i11;
            this.f63815d = bVar;
            this.f63816e = j12;
            this.f63817f = m0Var2;
            this.f63818g = i12;
            this.f63819h = bVar2;
            this.f63820i = j13;
            this.f63821j = j14;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f63812a == aVar.f63812a && this.f63814c == aVar.f63814c && this.f63816e == aVar.f63816e && this.f63818g == aVar.f63818g && this.f63820i == aVar.f63820i && this.f63821j == aVar.f63821j && com.google.common.base.j.a(this.f63813b, aVar.f63813b) && com.google.common.base.j.a(this.f63815d, aVar.f63815d) && com.google.common.base.j.a(this.f63817f, aVar.f63817f) && com.google.common.base.j.a(this.f63819h, aVar.f63819h);
        }

        public int hashCode() {
            return com.google.common.base.j.b(Long.valueOf(this.f63812a), this.f63813b, Integer.valueOf(this.f63814c), this.f63815d, Long.valueOf(this.f63816e), this.f63817f, Integer.valueOf(this.f63818g), this.f63819h, Long.valueOf(this.f63820i), Long.valueOf(this.f63821j));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final androidx.media3.common.s f63822a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SparseArray<a> f63823b;

        public b(androidx.media3.common.s sVar, SparseArray<a> sparseArray) {
            this.f63822a = sVar;
            SparseArray<a> sparseArray2 = new SparseArray<>(sVar.d());
            for (int i11 = 0; i11 < sVar.d(); i11++) {
                int iC = sVar.c(i11);
                sparseArray2.append(iC, (a) z3.a.e(sparseArray.get(iC)));
            }
            this.f63823b = sparseArray2;
        }

        public boolean a(int i11) {
            return this.f63822a.a(i11);
        }

        public int b(int i11) {
            return this.f63822a.c(i11);
        }

        public a c(int i11) {
            return (a) z3.a.e(this.f63823b.get(i11));
        }

        public int d() {
            return this.f63822a.d();
        }
    }

    void A(a aVar, int i11);

    void B(a aVar, p4.n nVar, p4.o oVar);

    void C(a aVar, androidx.media3.exoplayer.n nVar);

    void D(a aVar, androidx.media3.exoplayer.n nVar);

    @Deprecated
    void E(a aVar, boolean z11);

    void F(a aVar, p4.n nVar, p4.o oVar);

    void G(a aVar, long j11);

    void H(a aVar, int i11);

    void I(a aVar, androidx.media3.exoplayer.n nVar);

    void J(a aVar, int i11, int i12);

    void K(a aVar, androidx.media3.common.h0.e eVar, androidx.media3.common.h0.e eVar2, int i11);

    void L(a aVar, String str);

    void M(a aVar, boolean z11);

    void N(a aVar, float f11);

    void O(a aVar, AudioSink.a aVar2);

    void P(a aVar);

    void Q(a aVar, String str);

    void R(a aVar, Exception exc);

    void S(a aVar, int i11);

    void T(a aVar, androidx.media3.common.y yVar, @Nullable androidx.media3.exoplayer.o oVar);

    @Deprecated
    void U(a aVar, String str, long j11);

    void V(a aVar, @Nullable androidx.media3.common.b0 b0Var, int i11);

    void W(a aVar, androidx.media3.common.y yVar, @Nullable androidx.media3.exoplayer.o oVar);

    @Deprecated
    void X(a aVar, boolean z11, int i11);

    @Deprecated
    void Y(a aVar, String str, long j11);

    void Z(a aVar, AudioSink.a aVar2);

    void a0(a aVar);

    @Deprecated
    void b(a aVar, List<y3.a> list);

    void b0(a aVar, androidx.media3.common.d0 d0Var);

    void c(a aVar, boolean z11);

    void c0(a aVar, androidx.media3.common.p0 p0Var);

    void d(a aVar, Exception exc);

    void d0(a aVar, int i11);

    void e(a aVar, boolean z11);

    void e0(androidx.media3.common.h0 h0Var, b bVar);

    void f(a aVar, androidx.media3.common.h0.b bVar);

    void f0(a aVar, p4.o oVar);

    void g(a aVar, Object obj, long j11);

    void g0(a aVar, androidx.media3.exoplayer.n nVar);

    void h(a aVar, int i11, long j11, long j12);

    @Deprecated
    void h0(a aVar, androidx.media3.common.y yVar);

    void i(a aVar, int i11, long j11, long j12);

    void i0(a aVar, int i11);

    void j(a aVar, boolean z11, int i11);

    void j0(a aVar, androidx.media3.common.t0 t0Var);

    void k(a aVar);

    void k0(a aVar, p4.n nVar, p4.o oVar);

    @Deprecated
    void l(a aVar, int i11);

    void l0(a aVar, int i11, long j11);

    @Deprecated
    void m(a aVar, androidx.media3.common.y yVar);

    void m0(a aVar, p4.n nVar, p4.o oVar, IOException iOException, boolean z11);

    void n(a aVar, String str, long j11, long j12);

    void n0(a aVar, androidx.media3.common.q0 q0Var);

    void o(a aVar, boolean z11);

    @Deprecated
    void p(a aVar);

    void q(a aVar, Exception exc);

    void r(a aVar, @Nullable PlaybackException playbackException);

    @Deprecated
    void r0(a aVar, int i11, int i12, int i13, float f11);

    void s(a aVar);

    void s0(a aVar, p4.o oVar);

    void t(a aVar, PlaybackException playbackException);

    void t0(a aVar);

    void u(a aVar, int i11, boolean z11);

    void u0(a aVar, androidx.media3.common.g0 g0Var);

    @Deprecated
    void v(a aVar);

    void v0(a aVar, androidx.media3.common.o oVar);

    void w(a aVar, Metadata metadata);

    void w0(a aVar, long j11, int i11);

    void x(a aVar, String str, long j11, long j12);

    void y(a aVar, y3.b bVar);

    void z(a aVar, Exception exc);
}
