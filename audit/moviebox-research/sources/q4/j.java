package q4;

import androidx.annotation.Nullable;
import androidx.media3.common.f0;
import androidx.media3.common.y;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import u4.r0;
import z3.c0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class j extends a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f74361o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final long f74362p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final f f74363q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f74364r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile boolean f74365s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f74366t;

    public j(androidx.media3.datasource.a aVar, c4.g gVar, y yVar, int i11, @Nullable Object obj, long j11, long j12, long j13, long j14, long j15, int i12, long j16, f fVar) {
        super(aVar, gVar, yVar, i11, obj, j11, j12, j13, j14, j15);
        this.f74361o = i12;
        this.f74362p = j16;
        this.f74363q = fVar;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.d
    public final void cancelLoad() {
        this.f74365s = true;
    }

    @Override // q4.m
    public long e() {
        return this.f74373j + ((long) this.f74361o);
    }

    @Override // q4.m
    public boolean f() {
        return this.f74366t;
    }

    public f.b j(c cVar) {
        return cVar;
    }

    public final void k(c cVar) {
        if (f0.p(this.f74325d.f9500l)) {
            y yVar = this.f74325d;
            int i11 = yVar.G;
            if ((i11 <= 1 && yVar.H <= 1) || i11 == -1 || yVar.H == -1) {
                return;
            }
            r0 r0VarTrack = cVar.track(0, 4);
            y yVar2 = this.f74325d;
            int i12 = yVar2.H * yVar2.G;
            long j11 = (this.f74329h - this.f74328g) / ((long) i12);
            for (int i13 = 1; i13 < i12; i13++) {
                r0VarTrack.c(new c0(), 0);
                r0VarTrack.f(((long) i13) * j11, 0, 0, 0, null);
            }
        }
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.d
    public final void load() throws IOException {
        c cVarH = h();
        if (this.f74364r == 0) {
            cVarH.b(this.f74362p);
            f fVar = this.f74363q;
            f.b bVarJ = j(cVarH);
            long j11 = this.f74293k;
            long j12 = j11 == C.TIME_UNSET ? -9223372036854775807L : j11 - this.f74362p;
            long j13 = this.f74294l;
            fVar.d(bVarJ, j12, j13 == C.TIME_UNSET ? -9223372036854775807L : j13 - this.f74362p);
        }
        try {
            c4.g gVarE = this.f74323b.e(this.f74364r);
            c4.m mVar = this.f74330i;
            u4.j jVar = new u4.j(mVar, gVarE.f14604g, mVar.a(gVarE));
            do {
                try {
                    if (this.f74365s) {
                        break;
                    }
                } catch (Throwable th2) {
                    this.f74364r = jVar.getPosition() - this.f74323b.f14604g;
                    throw th2;
                }
            } while (this.f74363q.a(jVar));
            k(cVarH);
            this.f74364r = jVar.getPosition() - this.f74323b.f14604g;
            c4.f.a(this.f74330i);
            this.f74366t = !this.f74365s;
        } catch (Throwable th3) {
            c4.f.a(this.f74330i);
            throw th3;
        }
    }
}
