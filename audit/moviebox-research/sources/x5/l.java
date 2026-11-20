package x5;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Collections;
import java.util.List;
import u4.r0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<i0.a> f80066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r0[] f80067b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f80068c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f80069d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f80070e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f80071f = C.TIME_UNSET;

    public l(List<i0.a> list) {
        this.f80066a = list;
        this.f80067b = new r0[list.size()];
    }

    public final boolean a(z3.c0 c0Var, int i11) {
        if (c0Var.a() == 0) {
            return false;
        }
        if (c0Var.H() != i11) {
            this.f80068c = false;
        }
        this.f80069d--;
        return this.f80068c;
    }

    @Override // x5.m
    public void b(z3.c0 c0Var) {
        if (this.f80068c) {
            if (this.f80069d != 2 || a(c0Var, 32)) {
                if (this.f80069d != 1 || a(c0Var, 0)) {
                    int iF = c0Var.f();
                    int iA = c0Var.a();
                    for (r0 r0Var : this.f80067b) {
                        c0Var.U(iF);
                        r0Var.c(c0Var, iA);
                    }
                    this.f80070e += iA;
                }
            }
        }
    }

    @Override // x5.m
    public void c(long j11, int i11) {
        if ((i11 & 4) == 0) {
            return;
        }
        this.f80068c = true;
        this.f80071f = j11;
        this.f80070e = 0;
        this.f80069d = 2;
    }

    @Override // x5.m
    public void d(u4.u uVar, i0.d dVar) {
        for (int i11 = 0; i11 < this.f80067b.length; i11++) {
            i0.a aVar = this.f80066a.get(i11);
            dVar.a();
            r0 r0VarTrack = uVar.track(dVar.c(), 3);
            r0VarTrack.b(new androidx.media3.common.y.b().X(dVar.b()).k0(MimeTypes.APPLICATION_DVBSUBS).Y(Collections.singletonList(aVar.f80035c)).b0(aVar.f80033a).I());
            this.f80067b[i11] = r0VarTrack;
        }
    }

    @Override // x5.m
    public void packetFinished() {
        if (this.f80068c) {
            z3.a.g(this.f80071f != C.TIME_UNSET);
            for (r0 r0Var : this.f80067b) {
                r0Var.f(this.f80071f, 1, this.f80070e, 0, null);
            }
            this.f80068c = false;
        }
    }

    @Override // x5.m
    public void seek() {
        this.f80068c = false;
        this.f80071f = C.TIME_UNSET;
    }
}
