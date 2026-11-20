package ph;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class n extends f {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f73857j;

    public n(com.google.android.exoplayer2.upstream.k kVar, com.google.android.exoplayer2.upstream.n nVar, m1 m1Var, int i11, @Nullable Object obj, long j11, long j12, long j13) {
        super(kVar, nVar, 1, m1Var, i11, obj, j11, j12);
        com.google.android.exoplayer2.util.a.e(m1Var);
        this.f73857j = j13;
    }

    public long e() {
        long j11 = this.f73857j;
        if (j11 != -1) {
            return 1 + j11;
        }
        return -1L;
    }

    public abstract boolean f();
}
