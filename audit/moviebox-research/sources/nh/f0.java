package nh;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.j3;
import com.google.android.exoplayer2.u1;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class f0 extends j3 {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Object f71906q = new Object();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final u1 f71907r = new u1.c().d("SinglePeriodTimeline").i(Uri.EMPTY).a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f71908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f71909d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f71910f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f71911g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f71912h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f71913i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f71914j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f71915k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f71916l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f71917m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public final Object f71918n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    public final u1 f71919o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public final u1.g f71920p;

    public f0(long j11, long j12, long j13, long j14, long j15, long j16, long j17, boolean z11, boolean z12, boolean z13, @Nullable Object obj, u1 u1Var, @Nullable u1.g gVar) {
        this.f71908c = j11;
        this.f71909d = j12;
        this.f71910f = j13;
        this.f71911g = j14;
        this.f71912h = j15;
        this.f71913i = j16;
        this.f71914j = j17;
        this.f71915k = z11;
        this.f71916l = z12;
        this.f71917m = z13;
        this.f71918n = obj;
        this.f71919o = (u1) com.google.android.exoplayer2.util.a.e(u1Var);
        this.f71920p = gVar;
    }

    public f0(long j11, long j12, long j13, long j14, boolean z11, boolean z12, boolean z13, @Nullable Object obj, u1 u1Var) {
        this(C.TIME_UNSET, C.TIME_UNSET, C.TIME_UNSET, j11, j12, j13, j14, z11, z12, false, obj, u1Var, z13 ? u1Var.f34778d : null);
    }

    public f0(long j11, boolean z11, boolean z12, boolean z13, @Nullable Object obj, u1 u1Var) {
        this(j11, j11, 0L, 0L, z11, z12, z13, obj, u1Var);
    }

    @Override // com.google.android.exoplayer2.j3
    public int f(Object obj) {
        return f71906q.equals(obj) ? 0 : -1;
    }

    @Override // com.google.android.exoplayer2.j3
    public j3.b k(int i11, j3.b bVar, boolean z11) {
        com.google.android.exoplayer2.util.a.c(i11, 0, 1);
        return bVar.v(null, z11 ? f71906q : null, 0, this.f71911g, -this.f71913i);
    }

    @Override // com.google.android.exoplayer2.j3
    public int m() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.j3
    public Object q(int i11) {
        com.google.android.exoplayer2.util.a.c(i11, 0, 1);
        return f71906q;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002e A[PHI: r1
  0x002e: PHI (r1v2 long) = (r1v1 long), (r1v1 long), (r1v1 long), (r1v6 long) binds: [B:3:0x000d, B:5:0x0011, B:7:0x0017, B:12:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.exoplayer2.j3
    public j3.d s(int i11, j3.d dVar, long j11) {
        long j12;
        com.google.android.exoplayer2.util.a.c(i11, 0, 1);
        long j13 = this.f71914j;
        boolean z11 = this.f71916l;
        if (!z11 || this.f71917m || j11 == 0) {
            j12 = j13;
        } else {
            long j14 = this.f71912h;
            if (j14 != C.TIME_UNSET) {
                j13 += j11;
                if (j13 <= j14) {
                    j12 = j13;
                }
            }
            j12 = -9223372036854775807L;
        }
        return dVar.k(j3.d.f33373s, this.f71919o, this.f71918n, this.f71908c, this.f71909d, this.f71910f, this.f71915k, z11, this.f71920p, j12, this.f71912h, 0, 0, this.f71913i);
    }

    @Override // com.google.android.exoplayer2.j3
    public int t() {
        return 1;
    }
}
