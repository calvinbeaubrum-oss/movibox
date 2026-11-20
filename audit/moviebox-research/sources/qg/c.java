package qg;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.j3;
import com.google.android.exoplayer2.m2;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.n2;
import com.google.android.exoplayer2.o3;
import com.google.android.exoplayer2.z1;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface c {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f74570a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final j3 f74571b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f74572c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public final com.google.android.exoplayer2.source.i.b f74573d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f74574e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final j3 f74575f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f74576g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        public final com.google.android.exoplayer2.source.i.b f74577h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final long f74578i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final long f74579j;

        public a(long j11, j3 j3Var, int i11, @Nullable com.google.android.exoplayer2.source.i.b bVar, long j12, j3 j3Var2, int i12, @Nullable com.google.android.exoplayer2.source.i.b bVar2, long j13, long j14) {
            this.f74570a = j11;
            this.f74571b = j3Var;
            this.f74572c = i11;
            this.f74573d = bVar;
            this.f74574e = j12;
            this.f74575f = j3Var2;
            this.f74576g = i12;
            this.f74577h = bVar2;
            this.f74578i = j13;
            this.f74579j = j14;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f74570a == aVar.f74570a && this.f74572c == aVar.f74572c && this.f74574e == aVar.f74574e && this.f74576g == aVar.f74576g && this.f74578i == aVar.f74578i && this.f74579j == aVar.f74579j && com.google.common.base.j.a(this.f74571b, aVar.f74571b) && com.google.common.base.j.a(this.f74573d, aVar.f74573d) && com.google.common.base.j.a(this.f74575f, aVar.f74575f) && com.google.common.base.j.a(this.f74577h, aVar.f74577h);
        }

        public int hashCode() {
            return com.google.common.base.j.b(Long.valueOf(this.f74570a), this.f74571b, Integer.valueOf(this.f74572c), this.f74573d, Long.valueOf(this.f74574e), this.f74575f, Integer.valueOf(this.f74576g), this.f74577h, Long.valueOf(this.f74578i), Long.valueOf(this.f74579j));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.google.android.exoplayer2.util.m f74580a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SparseArray<a> f74581b;

        public b(com.google.android.exoplayer2.util.m mVar, SparseArray<a> sparseArray) {
            this.f74580a = mVar;
            SparseArray<a> sparseArray2 = new SparseArray<>(mVar.d());
            for (int i11 = 0; i11 < mVar.d(); i11++) {
                int iC = mVar.c(i11);
                sparseArray2.append(iC, (a) com.google.android.exoplayer2.util.a.e(sparseArray.get(iC)));
            }
            this.f74581b = sparseArray2;
        }

        public boolean a(int i11) {
            return this.f74580a.a(i11);
        }

        public int b(int i11) {
            return this.f74580a.c(i11);
        }

        public a c(int i11) {
            return (a) com.google.android.exoplayer2.util.a.e(this.f74581b.get(i11));
        }

        public int d() {
            return this.f74580a.d();
        }
    }

    void A(a aVar, int i11, boolean z11);

    void B(a aVar, nh.n nVar, nh.o oVar);

    void C(a aVar, fi.z zVar);

    void D(a aVar, com.google.android.exoplayer2.decoder.e eVar);

    void E(a aVar);

    void F(a aVar, @Nullable com.google.android.exoplayer2.u1 u1Var, int i11);

    void G(a aVar, o3 o3Var);

    void H(a aVar, String str, long j11, long j12);

    void I(a aVar, int i11, long j11, long j12);

    @Deprecated
    void J(a aVar, int i11);

    @Deprecated
    void K(a aVar, int i11, com.google.android.exoplayer2.m1 m1Var);

    @Deprecated
    void L(a aVar, boolean z11, int i11);

    @Deprecated
    void N(a aVar, com.google.android.exoplayer2.m1 m1Var);

    void O(a aVar, Exception exc);

    void P(a aVar, int i11, long j11);

    void Q(a aVar, String str);

    void R(a aVar, String str, long j11, long j12);

    void S(a aVar, n2.e eVar, n2.e eVar2, int i11);

    void T(a aVar, int i11);

    void U(a aVar, nh.o oVar);

    void V(a aVar, int i11);

    void X(a aVar, com.google.android.exoplayer2.decoder.e eVar);

    void Y(a aVar);

    void Z(a aVar, int i11);

    void a(a aVar, Exception exc);

    @Deprecated
    void a0(a aVar, com.google.android.exoplayer2.m1 m1Var);

    void b(a aVar, boolean z11);

    void b0(a aVar, boolean z11);

    void c(a aVar, com.google.android.exoplayer2.video.y yVar);

    void c0(a aVar);

    @Deprecated
    void d(a aVar, List<vh.b> list);

    void d0(a aVar, nh.n nVar, nh.o oVar, IOException iOException, boolean z11);

    void e(a aVar, boolean z11, int i11);

    void e0(a aVar, int i11, long j11, long j12);

    @Deprecated
    void f(a aVar, int i11, com.google.android.exoplayer2.decoder.e eVar);

    void f0(a aVar, Object obj, long j11);

    void g(a aVar, nh.n nVar, nh.o oVar);

    @Deprecated
    void g0(a aVar, int i11, int i12, int i13, float f11);

    void h(a aVar, boolean z11);

    void h0(a aVar, int i11);

    void i(a aVar, nh.n nVar, nh.o oVar);

    @Deprecated
    void i0(a aVar, int i11, com.google.android.exoplayer2.decoder.e eVar);

    void j0(a aVar, vh.f fVar);

    void k(a aVar, long j11, int i11);

    void k0(a aVar, PlaybackException playbackException);

    @Deprecated
    void l(a aVar);

    void l0(a aVar, com.google.android.exoplayer2.m1 m1Var, @Nullable com.google.android.exoplayer2.decoder.g gVar);

    void m0(a aVar, String str);

    void n(a aVar, com.google.android.exoplayer2.m1 m1Var, @Nullable com.google.android.exoplayer2.decoder.g gVar);

    @Deprecated
    void n0(a aVar, boolean z11);

    void o(a aVar, Metadata metadata);

    void o0(a aVar, Exception exc);

    void p(a aVar, int i11, int i12);

    void p0(a aVar, com.google.android.exoplayer2.decoder.e eVar);

    void q(a aVar, long j11);

    void q0(a aVar, int i11);

    void r(a aVar, com.google.android.exoplayer2.decoder.e eVar);

    void r0(a aVar, nh.o oVar);

    void s(a aVar, float f11);

    void s0(a aVar, n2.b bVar);

    @Deprecated
    void t(a aVar, String str, long j11);

    @Deprecated
    void t0(a aVar, String str, long j11);

    void u(n2 n2Var, b bVar);

    @Deprecated
    void u0(a aVar);

    void v(a aVar);

    void v0(a aVar, boolean z11);

    @Deprecated
    void w(a aVar, int i11, String str, long j11);

    void w0(a aVar, com.google.android.exoplayer2.n nVar);

    void x(a aVar, z1 z1Var);

    void x0(a aVar, Exception exc);

    void y(a aVar, m2 m2Var);

    void y0(a aVar);

    void z(a aVar, @Nullable PlaybackException playbackException);

    @Deprecated
    void z0(a aVar);
}
