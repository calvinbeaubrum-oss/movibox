package com.applovin.impl;

import android.net.Uri;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class gk extends fo {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final Object f19232q = new Object();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final td f19233r = new td.c().b("SinglePeriodTimeline").a(Uri.EMPTY).a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f19234c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f19235d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f19236f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f19237g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f19238h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f19239i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f19240j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f19241k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f19242l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f19243m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Object f19244n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final td f19245o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final td.f f19246p;

    public gk(long j11, long j12, long j13, long j14, long j15, long j16, long j17, boolean z11, boolean z12, boolean z13, Object obj, td tdVar, td.f fVar) {
        this.f19234c = j11;
        this.f19235d = j12;
        this.f19236f = j13;
        this.f19237g = j14;
        this.f19238h = j15;
        this.f19239i = j16;
        this.f19240j = j17;
        this.f19241k = z11;
        this.f19242l = z12;
        this.f19243m = z13;
        this.f19244n = obj;
        this.f19245o = (td) b1.a(tdVar);
        this.f19246p = fVar;
    }

    public gk(long j11, long j12, long j13, long j14, boolean z11, boolean z12, boolean z13, Object obj, td tdVar) {
        this(C.TIME_UNSET, C.TIME_UNSET, C.TIME_UNSET, j11, j12, j13, j14, z11, z12, false, obj, tdVar, z13 ? tdVar.f23248c : null);
    }

    public gk(long j11, boolean z11, boolean z12, boolean z13, Object obj, td tdVar) {
        this(j11, j11, 0L, 0L, z11, z12, z13, obj, tdVar);
    }

    @Override // com.applovin.impl.fo
    public int a() {
        return 1;
    }

    @Override // com.applovin.impl.fo
    public int a(Object obj) {
        return f19232q.equals(obj) ? 0 : -1;
    }

    @Override // com.applovin.impl.fo
    public fo.b a(int i11, fo.b bVar, boolean z11) {
        b1.a(i11, 0, 1);
        return bVar.a(null, z11 ? f19232q : null, 0, this.f19237g, -this.f19239i);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002e A[PHI: r1
  0x002e: PHI (r1v2 long) = (r1v1 long), (r1v1 long), (r1v1 long), (r1v6 long) binds: [B:3:0x000d, B:5:0x0011, B:7:0x0017, B:12:0x0029] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.applovin.impl.fo
    public fo.d a(int i11, fo.d dVar, long j11) {
        long j12;
        b1.a(i11, 0, 1);
        long j13 = this.f19240j;
        boolean z11 = this.f19242l;
        if (!z11 || this.f19243m || j11 == 0) {
            j12 = j13;
        } else {
            long j14 = this.f19238h;
            if (j14 != C.TIME_UNSET) {
                j13 += j11;
                if (j13 <= j14) {
                    j12 = j13;
                }
            }
            j12 = -9223372036854775807L;
        }
        return dVar.a(fo.d.f19042s, this.f19245o, this.f19244n, this.f19234c, this.f19235d, this.f19236f, this.f19241k, z11, this.f19246p, j12, this.f19238h, 0, 0, this.f19239i);
    }

    @Override // com.applovin.impl.fo
    public int b() {
        return 1;
    }

    @Override // com.applovin.impl.fo
    public Object b(int i11) {
        b1.a(i11, 0, 1);
        return f19232q;
    }
}
