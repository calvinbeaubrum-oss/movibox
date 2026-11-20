package com.google.android.exoplayer2;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class k2 {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final com.google.android.exoplayer2.source.i.b f33403s = new com.google.android.exoplayer2.source.i.b(new Object());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j3 f33404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.i.b f33405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f33406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f33407d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f33408e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final ExoPlaybackException f33409f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f33410g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final nh.k0 f33411h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final fi.c0 f33412i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<Metadata> f33413j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.i.b f33414k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f33415l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f33416m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final m2 f33417n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f33418o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile long f33419p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile long f33420q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile long f33421r;

    public k2(j3 j3Var, com.google.android.exoplayer2.source.i.b bVar, long j11, long j12, int i11, @Nullable ExoPlaybackException exoPlaybackException, boolean z11, nh.k0 k0Var, fi.c0 c0Var, List<Metadata> list, com.google.android.exoplayer2.source.i.b bVar2, boolean z12, int i12, m2 m2Var, long j13, long j14, long j15, boolean z13) {
        this.f33404a = j3Var;
        this.f33405b = bVar;
        this.f33406c = j11;
        this.f33407d = j12;
        this.f33408e = i11;
        this.f33409f = exoPlaybackException;
        this.f33410g = z11;
        this.f33411h = k0Var;
        this.f33412i = c0Var;
        this.f33413j = list;
        this.f33414k = bVar2;
        this.f33415l = z12;
        this.f33416m = i12;
        this.f33417n = m2Var;
        this.f33419p = j13;
        this.f33420q = j14;
        this.f33421r = j15;
        this.f33418o = z13;
    }

    public static k2 j(fi.c0 c0Var) {
        j3 j3Var = j3.f33359a;
        com.google.android.exoplayer2.source.i.b bVar = f33403s;
        return new k2(j3Var, bVar, C.TIME_UNSET, 0L, 1, null, false, nh.k0.f71939d, c0Var, ImmutableList.of(), bVar, false, 0, m2.f33485d, 0L, 0L, 0L, false);
    }

    public static com.google.android.exoplayer2.source.i.b k() {
        return f33403s;
    }

    @CheckResult
    public k2 a(boolean z11) {
        return new k2(this.f33404a, this.f33405b, this.f33406c, this.f33407d, this.f33408e, this.f33409f, z11, this.f33411h, this.f33412i, this.f33413j, this.f33414k, this.f33415l, this.f33416m, this.f33417n, this.f33419p, this.f33420q, this.f33421r, this.f33418o);
    }

    @CheckResult
    public k2 b(com.google.android.exoplayer2.source.i.b bVar) {
        return new k2(this.f33404a, this.f33405b, this.f33406c, this.f33407d, this.f33408e, this.f33409f, this.f33410g, this.f33411h, this.f33412i, this.f33413j, bVar, this.f33415l, this.f33416m, this.f33417n, this.f33419p, this.f33420q, this.f33421r, this.f33418o);
    }

    @CheckResult
    public k2 c(com.google.android.exoplayer2.source.i.b bVar, long j11, long j12, long j13, long j14, nh.k0 k0Var, fi.c0 c0Var, List<Metadata> list) {
        return new k2(this.f33404a, bVar, j12, j13, this.f33408e, this.f33409f, this.f33410g, k0Var, c0Var, list, this.f33414k, this.f33415l, this.f33416m, this.f33417n, this.f33419p, j14, j11, this.f33418o);
    }

    @CheckResult
    public k2 d(boolean z11, int i11) {
        return new k2(this.f33404a, this.f33405b, this.f33406c, this.f33407d, this.f33408e, this.f33409f, this.f33410g, this.f33411h, this.f33412i, this.f33413j, this.f33414k, z11, i11, this.f33417n, this.f33419p, this.f33420q, this.f33421r, this.f33418o);
    }

    @CheckResult
    public k2 e(@Nullable ExoPlaybackException exoPlaybackException) {
        return new k2(this.f33404a, this.f33405b, this.f33406c, this.f33407d, this.f33408e, exoPlaybackException, this.f33410g, this.f33411h, this.f33412i, this.f33413j, this.f33414k, this.f33415l, this.f33416m, this.f33417n, this.f33419p, this.f33420q, this.f33421r, this.f33418o);
    }

    @CheckResult
    public k2 f(m2 m2Var) {
        return new k2(this.f33404a, this.f33405b, this.f33406c, this.f33407d, this.f33408e, this.f33409f, this.f33410g, this.f33411h, this.f33412i, this.f33413j, this.f33414k, this.f33415l, this.f33416m, m2Var, this.f33419p, this.f33420q, this.f33421r, this.f33418o);
    }

    @CheckResult
    public k2 g(int i11) {
        return new k2(this.f33404a, this.f33405b, this.f33406c, this.f33407d, i11, this.f33409f, this.f33410g, this.f33411h, this.f33412i, this.f33413j, this.f33414k, this.f33415l, this.f33416m, this.f33417n, this.f33419p, this.f33420q, this.f33421r, this.f33418o);
    }

    @CheckResult
    public k2 h(boolean z11) {
        return new k2(this.f33404a, this.f33405b, this.f33406c, this.f33407d, this.f33408e, this.f33409f, this.f33410g, this.f33411h, this.f33412i, this.f33413j, this.f33414k, this.f33415l, this.f33416m, this.f33417n, this.f33419p, this.f33420q, this.f33421r, z11);
    }

    @CheckResult
    public k2 i(j3 j3Var) {
        return new k2(j3Var, this.f33405b, this.f33406c, this.f33407d, this.f33408e, this.f33409f, this.f33410g, this.f33411h, this.f33412i, this.f33413j, this.f33414k, this.f33415l, this.f33416m, this.f33417n, this.f33419p, this.f33420q, this.f33421r, this.f33418o);
    }
}
