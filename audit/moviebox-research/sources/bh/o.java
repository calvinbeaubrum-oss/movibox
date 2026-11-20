package bh;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f14231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f14232d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f14233e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final m1 f14234f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f14235g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public final long[] f14236h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final long[] f14237i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f14238j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public final p[] f14239k;

    public o(int i11, int i12, long j11, long j12, long j13, m1 m1Var, int i13, @Nullable p[] pVarArr, int i14, @Nullable long[] jArr, @Nullable long[] jArr2) {
        this.f14229a = i11;
        this.f14230b = i12;
        this.f14231c = j11;
        this.f14232d = j12;
        this.f14233e = j13;
        this.f14234f = m1Var;
        this.f14235g = i13;
        this.f14239k = pVarArr;
        this.f14238j = i14;
        this.f14236h = jArr;
        this.f14237i = jArr2;
    }

    @Nullable
    public p a(int i11) {
        p[] pVarArr = this.f14239k;
        if (pVarArr == null) {
            return null;
        }
        return pVarArr[i11];
    }
}
