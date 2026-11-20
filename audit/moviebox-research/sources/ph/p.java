package ph;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1;
import com.google.android.gms.common.api.Api;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import tg.e0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class p extends a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f73859o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final m1 f73860p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f73861q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f73862r;

    public p(com.google.android.exoplayer2.upstream.k kVar, com.google.android.exoplayer2.upstream.n nVar, m1 m1Var, int i11, @Nullable Object obj, long j11, long j12, long j13, int i12, m1 m1Var2) {
        super(kVar, nVar, m1Var, i11, obj, j11, j12, C.TIME_UNSET, C.TIME_UNSET, j13);
        this.f73859o = i12;
        this.f73860p = m1Var2;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public void cancelLoad() {
    }

    @Override // ph.n
    public boolean f() {
        return this.f73862r;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public void load() throws IOException {
        c cVarH = h();
        cVarH.b(0L);
        e0 e0VarTrack = cVarH.track(0, this.f73859o);
        e0VarTrack.e(this.f73860p);
        try {
            long jA = this.f73814i.a(this.f73807b.e(this.f73861q));
            if (jA != -1) {
                jA += this.f73861q;
            }
            tg.f fVar = new tg.f(this.f73814i, this.f73861q, jA);
            for (int iB = 0; iB != -1; iB = e0VarTrack.b(fVar, Api.BaseClientBuilder.API_PRIORITY_OTHER, true)) {
                this.f73861q += (long) iB;
            }
            e0VarTrack.d(this.f73812g, 1, (int) this.f73861q, 0, null);
            com.google.android.exoplayer2.upstream.m.a(this.f73814i);
            this.f73862r = true;
        } catch (Throwable th2) {
            com.google.android.exoplayer2.upstream.m.a(this.f73814i);
            throw th2;
        }
    }
}
