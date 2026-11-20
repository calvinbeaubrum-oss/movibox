package ph;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.upstream.i0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class m extends f {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final g f73853j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public g.b f73854k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f73855l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile boolean f73856m;

    public m(com.google.android.exoplayer2.upstream.k kVar, com.google.android.exoplayer2.upstream.n nVar, m1 m1Var, int i11, @Nullable Object obj, g gVar) {
        super(kVar, nVar, 2, m1Var, i11, obj, C.TIME_UNSET, C.TIME_UNSET);
        this.f73853j = gVar;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public void cancelLoad() {
        this.f73856m = true;
    }

    public void e(g.b bVar) {
        this.f73854k = bVar;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public void load() throws IOException {
        if (this.f73855l == 0) {
            this.f73853j.d(this.f73854k, C.TIME_UNSET, C.TIME_UNSET);
        }
        try {
            com.google.android.exoplayer2.upstream.n nVarE = this.f73807b.e(this.f73855l);
            i0 i0Var = this.f73814i;
            tg.f fVar = new tg.f(i0Var, nVarE.f35428g, i0Var.a(nVarE));
            while (!this.f73856m && this.f73853j.a(fVar)) {
                try {
                } catch (Throwable th2) {
                    this.f73855l = fVar.getPosition() - this.f73807b.f35428g;
                    throw th2;
                }
            }
            this.f73855l = fVar.getPosition() - this.f73807b.f35428g;
            com.google.android.exoplayer2.upstream.m.a(this.f73814i);
        } catch (Throwable th3) {
            com.google.android.exoplayer2.upstream.m.a(this.f73814i);
            throw th3;
        }
    }
}
