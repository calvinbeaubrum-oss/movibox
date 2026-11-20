package com.google.android.exoplayer2;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.i.b f32977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f32978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f32979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f32980d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f32981e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f32982f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f32983g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f32984h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f32985i;

    public b2(com.google.android.exoplayer2.source.i.b bVar, long j11, long j12, long j13, long j14, boolean z11, boolean z12, boolean z13, boolean z14) {
        boolean z15 = false;
        com.google.android.exoplayer2.util.a.a(!z14 || z12);
        com.google.android.exoplayer2.util.a.a(!z13 || z12);
        if (!z11 || (!z12 && !z13 && !z14)) {
            z15 = true;
        }
        com.google.android.exoplayer2.util.a.a(z15);
        this.f32977a = bVar;
        this.f32978b = j11;
        this.f32979c = j12;
        this.f32980d = j13;
        this.f32981e = j14;
        this.f32982f = z11;
        this.f32983g = z12;
        this.f32984h = z13;
        this.f32985i = z14;
    }

    public b2 a(long j11) {
        return j11 == this.f32979c ? this : new b2(this.f32977a, this.f32978b, j11, this.f32980d, this.f32981e, this.f32982f, this.f32983g, this.f32984h, this.f32985i);
    }

    public b2 b(long j11) {
        return j11 == this.f32978b ? this : new b2(this.f32977a, j11, this.f32979c, this.f32980d, this.f32981e, this.f32982f, this.f32983g, this.f32984h, this.f32985i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b2.class != obj.getClass()) {
            return false;
        }
        b2 b2Var = (b2) obj;
        return this.f32978b == b2Var.f32978b && this.f32979c == b2Var.f32979c && this.f32980d == b2Var.f32980d && this.f32981e == b2Var.f32981e && this.f32982f == b2Var.f32982f && this.f32983g == b2Var.f32983g && this.f32984h == b2Var.f32984h && this.f32985i == b2Var.f32985i && com.google.android.exoplayer2.util.o0.c(this.f32977a, b2Var.f32977a);
    }

    public int hashCode() {
        return ((((((((((((((((527 + this.f32977a.hashCode()) * 31) + ((int) this.f32978b)) * 31) + ((int) this.f32979c)) * 31) + ((int) this.f32980d)) * 31) + ((int) this.f32981e)) * 31) + (this.f32982f ? 1 : 0)) * 31) + (this.f32983g ? 1 : 0)) * 31) + (this.f32984h ? 1 : 0)) * 31) + (this.f32985i ? 1 : 0);
    }
}
