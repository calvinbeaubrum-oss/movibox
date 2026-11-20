package p4;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.m0;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g0 extends m0 {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Object f73545s = new Object();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final androidx.media3.common.b0 f73546t = new androidx.media3.common.b0.c().d("SinglePeriodTimeline").i(Uri.EMPTY).a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f73547f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f73548g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f73549h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f73550i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f73551j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f73552k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f73553l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f73554m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f73555n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f73556o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public final Object f73557p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public final androidx.media3.common.b0 f73558q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    public final androidx.media3.common.b0.g f73559r;

    public g0(long j11, long j12, long j13, long j14, long j15, long j16, long j17, boolean z11, boolean z12, boolean z13, @Nullable Object obj, androidx.media3.common.b0 b0Var, @Nullable androidx.media3.common.b0.g gVar) {
        this.f73547f = j11;
        this.f73548g = j12;
        this.f73549h = j13;
        this.f73550i = j14;
        this.f73551j = j15;
        this.f73552k = j16;
        this.f73553l = j17;
        this.f73554m = z11;
        this.f73555n = z12;
        this.f73556o = z13;
        this.f73557p = obj;
        this.f73558q = (androidx.media3.common.b0) z3.a.e(b0Var);
        this.f73559r = gVar;
    }

    public g0(long j11, long j12, long j13, long j14, boolean z11, boolean z12, boolean z13, @Nullable Object obj, androidx.media3.common.b0 b0Var) {
        this(C.TIME_UNSET, C.TIME_UNSET, C.TIME_UNSET, j11, j12, j13, j14, z11, z12, false, obj, b0Var, z13 ? b0Var.f8953d : null);
    }

    public g0(long j11, boolean z11, boolean z12, boolean z13, @Nullable Object obj, androidx.media3.common.b0 b0Var) {
        this(j11, j11, 0L, 0L, z11, z12, z13, obj, b0Var);
    }

    @Override // androidx.media3.common.m0
    public int b(Object obj) {
        return f73545s.equals(obj) ? 0 : -1;
    }

    @Override // androidx.media3.common.m0
    public m0.b g(int i11, m0.b bVar, boolean z11) {
        z3.a.c(i11, 0, 1);
        return bVar.t(null, z11 ? f73545s : null, 0, this.f73550i, -this.f73552k);
    }

    @Override // androidx.media3.common.m0
    public int i() {
        return 1;
    }

    @Override // androidx.media3.common.m0
    public Object m(int i11) {
        z3.a.c(i11, 0, 1);
        return f73545s;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002e A[PHI: r1
  0x002e: PHI (r1v2 long) = (r1v1 long), (r1v1 long), (r1v1 long), (r1v6 long) binds: [B:3:0x000d, B:5:0x0011, B:7:0x0017, B:12:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.media3.common.m0
    public m0.c o(int i11, m0.c cVar, long j11) {
        long j12;
        z3.a.c(i11, 0, 1);
        long j13 = this.f73553l;
        boolean z11 = this.f73555n;
        if (!z11 || this.f73556o || j11 == 0) {
            j12 = j13;
        } else {
            long j14 = this.f73551j;
            if (j14 != C.TIME_UNSET) {
                j13 += j11;
                if (j13 <= j14) {
                    j12 = j13;
                }
            }
            j12 = -9223372036854775807L;
        }
        return cVar.g(m0.c.f9300r, this.f73558q, this.f73557p, this.f73547f, this.f73548g, this.f73549h, this.f73554m, z11, this.f73559r, j12, this.f73551j, 0, 0, this.f73552k);
    }

    @Override // androidx.media3.common.m0
    public int p() {
        return 1;
    }
}
