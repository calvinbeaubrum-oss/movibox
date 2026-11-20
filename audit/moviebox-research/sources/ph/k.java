package ph;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.upstream.i0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class k extends a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f73845o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final long f73846p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final g f73847q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f73848r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile boolean f73849s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f73850t;

    public k(com.google.android.exoplayer2.upstream.k kVar, com.google.android.exoplayer2.upstream.n nVar, m1 m1Var, int i11, @Nullable Object obj, long j11, long j12, long j13, long j14, long j15, int i12, long j16, g gVar) {
        super(kVar, nVar, m1Var, i11, obj, j11, j12, j13, j14, j15);
        this.f73845o = i12;
        this.f73846p = j16;
        this.f73847q = gVar;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public final void cancelLoad() {
        this.f73849s = true;
    }

    @Override // ph.n
    public long e() {
        return this.f73857j + ((long) this.f73845o);
    }

    @Override // ph.n
    public boolean f() {
        return this.f73850t;
    }

    public g.b j(c cVar) {
        return cVar;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public final void load() throws IOException {
        if (this.f73848r == 0) {
            c cVarH = h();
            cVarH.b(this.f73846p);
            g gVar = this.f73847q;
            g.b bVarJ = j(cVarH);
            long j11 = this.f73779k;
            long j12 = j11 == C.TIME_UNSET ? -9223372036854775807L : j11 - this.f73846p;
            long j13 = this.f73780l;
            gVar.d(bVarJ, j12, j13 == C.TIME_UNSET ? -9223372036854775807L : j13 - this.f73846p);
        }
        try {
            com.google.android.exoplayer2.upstream.n nVarE = this.f73807b.e(this.f73848r);
            i0 i0Var = this.f73814i;
            tg.f fVar = new tg.f(i0Var, nVarE.f35428g, i0Var.a(nVarE));
            do {
                try {
                    if (this.f73849s) {
                        break;
                    }
                } catch (Throwable th2) {
                    this.f73848r = fVar.getPosition() - this.f73807b.f35428g;
                    throw th2;
                }
            } while (this.f73847q.a(fVar));
            this.f73848r = fVar.getPosition() - this.f73807b.f35428g;
            com.google.android.exoplayer2.upstream.m.a(this.f73814i);
            this.f73850t = !this.f73849s;
        } catch (Throwable th3) {
            com.google.android.exoplayer2.upstream.m.a(this.f73814i);
            throw th3;
        }
    }
}
