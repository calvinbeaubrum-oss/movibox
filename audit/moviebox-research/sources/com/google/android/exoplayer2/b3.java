package com.google.android.exoplayer2;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b3 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b3 f32986c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b3 f32987d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b3 f32988e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b3 f32989f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b3 f32990g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f32991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f32992b;

    static {
        b3 b3Var = new b3(0L, 0L);
        f32986c = b3Var;
        f32987d = new b3(Long.MAX_VALUE, Long.MAX_VALUE);
        f32988e = new b3(Long.MAX_VALUE, 0L);
        f32989f = new b3(0L, Long.MAX_VALUE);
        f32990g = b3Var;
    }

    public b3(long j11, long j12) {
        com.google.android.exoplayer2.util.a.a(j11 >= 0);
        com.google.android.exoplayer2.util.a.a(j12 >= 0);
        this.f32991a = j11;
        this.f32992b = j12;
    }

    public long a(long j11, long j12, long j13) {
        long j14 = this.f32991a;
        if (j14 == 0 && this.f32992b == 0) {
            return j11;
        }
        long jX0 = com.google.android.exoplayer2.util.o0.X0(j11, j14, Long.MIN_VALUE);
        long jB = com.google.android.exoplayer2.util.o0.b(j11, this.f32992b, Long.MAX_VALUE);
        boolean z11 = false;
        boolean z12 = jX0 <= j12 && j12 <= jB;
        if (jX0 <= j13 && j13 <= jB) {
            z11 = true;
        }
        if (z12 && z11) {
            return Math.abs(j12 - j11) <= Math.abs(j13 - j11) ? j12 : j13;
        }
        if (z12) {
            return j12;
        }
        return z11 ? j13 : jX0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b3.class != obj.getClass()) {
            return false;
        }
        b3 b3Var = (b3) obj;
        return this.f32991a == b3Var.f32991a && this.f32992b == b3Var.f32992b;
    }

    public int hashCode() {
        return (((int) this.f32991a) * 31) + ((int) this.f32992b);
    }
}
