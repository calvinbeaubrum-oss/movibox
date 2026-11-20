package dh;

import com.google.android.exoplayer2.m1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class l implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<i0.a> f63213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final tg.e0[] f63214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f63215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f63216d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f63217e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f63218f = C.TIME_UNSET;

    public l(List<i0.a> list) {
        this.f63213a = list;
        this.f63214b = new tg.e0[list.size()];
    }

    public final boolean a(com.google.android.exoplayer2.util.c0 c0Var, int i11) {
        if (c0Var.a() == 0) {
            return false;
        }
        if (c0Var.D() != i11) {
            this.f63215c = false;
        }
        this.f63216d--;
        return this.f63215c;
    }

    @Override // dh.m
    public void b(com.google.android.exoplayer2.util.c0 c0Var) {
        if (this.f63215c) {
            if (this.f63216d != 2 || a(c0Var, 32)) {
                if (this.f63216d != 1 || a(c0Var, 0)) {
                    int iE = c0Var.e();
                    int iA = c0Var.a();
                    for (tg.e0 e0Var : this.f63214b) {
                        c0Var.P(iE);
                        e0Var.c(c0Var, iA);
                    }
                    this.f63217e += iA;
                }
            }
        }
    }

    @Override // dh.m
    public void c(long j11, int i11) {
        if ((i11 & 4) == 0) {
            return;
        }
        this.f63215c = true;
        if (j11 != C.TIME_UNSET) {
            this.f63218f = j11;
        }
        this.f63217e = 0;
        this.f63216d = 2;
    }

    @Override // dh.m
    public void d(tg.n nVar, i0.d dVar) {
        for (int i11 = 0; i11 < this.f63214b.length; i11++) {
            i0.a aVar = this.f63213a.get(i11);
            dVar.a();
            tg.e0 e0VarTrack = nVar.track(dVar.c(), 3);
            e0VarTrack.e(new m1.b().S(dVar.b()).e0(MimeTypes.APPLICATION_DVBSUBS).T(Collections.singletonList(aVar.f63188c)).V(aVar.f63186a).E());
            this.f63214b[i11] = e0VarTrack;
        }
    }

    @Override // dh.m
    public void packetFinished() {
        if (this.f63215c) {
            if (this.f63218f != C.TIME_UNSET) {
                for (tg.e0 e0Var : this.f63214b) {
                    e0Var.d(this.f63218f, 1, this.f63217e, 0, null);
                }
            }
            this.f63215c = false;
        }
    }

    @Override // dh.m
    public void seek() {
        this.f63215c = false;
        this.f63218f = C.TIME_UNSET;
    }
}
