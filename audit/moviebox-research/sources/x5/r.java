package x5;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import u4.r0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r implements m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public r0 f80198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f80199c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f80201e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f80202f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z3.c0 f80197a = new z3.c0(10);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f80200d = C.TIME_UNSET;

    @Override // x5.m
    public void b(z3.c0 c0Var) {
        z3.a.i(this.f80198b);
        if (this.f80199c) {
            int iA = c0Var.a();
            int i11 = this.f80202f;
            if (i11 < 10) {
                int iMin = Math.min(iA, 10 - i11);
                System.arraycopy(c0Var.e(), c0Var.f(), this.f80197a.e(), this.f80202f, iMin);
                if (this.f80202f + iMin == 10) {
                    this.f80197a.U(0);
                    if (73 != this.f80197a.H() || 68 != this.f80197a.H() || 51 != this.f80197a.H()) {
                        z3.o.h("Id3Reader", "Discarding invalid ID3 tag");
                        this.f80199c = false;
                        return;
                    } else {
                        this.f80197a.V(3);
                        this.f80201e = this.f80197a.G() + 10;
                    }
                }
            }
            int iMin2 = Math.min(iA, this.f80201e - this.f80202f);
            this.f80198b.c(c0Var, iMin2);
            this.f80202f += iMin2;
        }
    }

    @Override // x5.m
    public void c(long j11, int i11) {
        if ((i11 & 4) == 0) {
            return;
        }
        this.f80199c = true;
        this.f80200d = j11;
        this.f80201e = 0;
        this.f80202f = 0;
    }

    @Override // x5.m
    public void d(u4.u uVar, i0.d dVar) {
        dVar.a();
        r0 r0VarTrack = uVar.track(dVar.c(), 5);
        this.f80198b = r0VarTrack;
        r0VarTrack.b(new androidx.media3.common.y.b().X(dVar.b()).k0(MimeTypes.APPLICATION_ID3).I());
    }

    @Override // x5.m
    public void packetFinished() {
        int i11;
        z3.a.i(this.f80198b);
        if (this.f80199c && (i11 = this.f80201e) != 0 && this.f80202f == i11) {
            z3.a.g(this.f80200d != C.TIME_UNSET);
            this.f80198b.f(this.f80200d, 1, this.f80201e, 0, null);
            this.f80199c = false;
        }
    }

    @Override // x5.m
    public void seek() {
        this.f80199c = false;
        this.f80200d = C.TIME_UNSET;
    }
}
