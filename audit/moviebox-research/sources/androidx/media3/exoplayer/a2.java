package androidx.media3.exoplayer;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.media3.exoplayer.source.l.b f9824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f9825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f9826c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f9827d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f9828e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f9829f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f9830g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f9831h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f9832i;

    public a2(androidx.media3.exoplayer.source.l.b bVar, long j11, long j12, long j13, long j14, boolean z11, boolean z12, boolean z13, boolean z14) {
        boolean z15 = false;
        z3.a.a(!z14 || z12);
        z3.a.a(!z13 || z12);
        if (!z11 || (!z12 && !z13 && !z14)) {
            z15 = true;
        }
        z3.a.a(z15);
        this.f9824a = bVar;
        this.f9825b = j11;
        this.f9826c = j12;
        this.f9827d = j13;
        this.f9828e = j14;
        this.f9829f = z11;
        this.f9830g = z12;
        this.f9831h = z13;
        this.f9832i = z14;
    }

    public a2 a(long j11) {
        return j11 == this.f9826c ? this : new a2(this.f9824a, this.f9825b, j11, this.f9827d, this.f9828e, this.f9829f, this.f9830g, this.f9831h, this.f9832i);
    }

    public a2 b(long j11) {
        return j11 == this.f9825b ? this : new a2(this.f9824a, j11, this.f9826c, this.f9827d, this.f9828e, this.f9829f, this.f9830g, this.f9831h, this.f9832i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a2.class != obj.getClass()) {
            return false;
        }
        a2 a2Var = (a2) obj;
        return this.f9825b == a2Var.f9825b && this.f9826c == a2Var.f9826c && this.f9827d == a2Var.f9827d && this.f9828e == a2Var.f9828e && this.f9829f == a2Var.f9829f && this.f9830g == a2Var.f9830g && this.f9831h == a2Var.f9831h && this.f9832i == a2Var.f9832i && z3.u0.c(this.f9824a, a2Var.f9824a);
    }

    public int hashCode() {
        return ((((((((((((((((527 + this.f9824a.hashCode()) * 31) + ((int) this.f9825b)) * 31) + ((int) this.f9826c)) * 31) + ((int) this.f9827d)) * 31) + ((int) this.f9828e)) * 31) + (this.f9829f ? 1 : 0)) * 31) + (this.f9830g ? 1 : 0)) * 31) + (this.f9831h ? 1 : 0)) * 31) + (this.f9832i ? 1 : 0);
    }
}
