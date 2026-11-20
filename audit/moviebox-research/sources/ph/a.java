package ph;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a extends n {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f73779k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f73780l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public c f73781m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int[] f73782n;

    public a(com.google.android.exoplayer2.upstream.k kVar, com.google.android.exoplayer2.upstream.n nVar, m1 m1Var, int i11, @Nullable Object obj, long j11, long j12, long j13, long j14, long j15) {
        super(kVar, nVar, m1Var, i11, obj, j11, j12, j15);
        this.f73779k = j13;
        this.f73780l = j14;
    }

    public final int g(int i11) {
        return ((int[]) com.google.android.exoplayer2.util.a.i(this.f73782n))[i11];
    }

    public final c h() {
        return (c) com.google.android.exoplayer2.util.a.i(this.f73781m);
    }

    public void i(c cVar) {
        this.f73781m = cVar;
        this.f73782n = cVar.a();
    }
}
