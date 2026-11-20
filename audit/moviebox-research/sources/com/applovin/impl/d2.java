package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d2 implements qh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final fo.d f18341a = new fo.d();

    private int J() {
        int iM = m();
        if (iM == 1) {
            return 0;
        }
        return iM;
    }

    private void b(long j11) {
        long currentPosition = getCurrentPosition() + j11;
        long duration = getDuration();
        if (duration != C.TIME_UNSET) {
            currentPosition = Math.min(currentPosition, duration);
        }
        a(Math.max(currentPosition, 0L));
    }

    @Override // com.applovin.impl.qh
    public final void B() {
        b(-F());
    }

    @Override // com.applovin.impl.qh
    public final void D() {
        if (n().c() || d()) {
            return;
        }
        boolean zL = L();
        if (N() && !y()) {
            if (zL) {
                Q();
            }
        } else if (!zL || getCurrentPosition() > q()) {
            a(0L);
        } else {
            Q();
        }
    }

    public final long G() {
        fo foVarN = n();
        return foVarN.c() ? C.TIME_UNSET : foVarN.a(t(), this.f18341a).d();
    }

    public final int H() {
        fo foVarN = n();
        if (foVarN.c()) {
            return -1;
        }
        return foVarN.a(t(), J(), r());
    }

    public final int I() {
        fo foVarN = n();
        if (foVarN.c()) {
            return -1;
        }
        return foVarN.b(t(), J(), r());
    }

    public final boolean K() {
        return H() != -1;
    }

    public final boolean L() {
        return I() != -1;
    }

    public final boolean M() {
        fo foVarN = n();
        return !foVarN.c() && foVarN.a(t(), this.f18341a).f19054j;
    }

    public final boolean N() {
        fo foVarN = n();
        return !foVarN.c() && foVarN.a(t(), this.f18341a).e();
    }

    public final void O() {
        c(t());
    }

    public final void P() {
        int iH = H();
        if (iH != -1) {
            c(iH);
        }
    }

    public final void Q() {
        int I = I();
        if (I != -1) {
            c(I);
        }
    }

    public qh.b a(qh.b bVar) {
        return new qh.b.a().a(bVar).a(3, !d()).a(4, y() && !d()).a(5, L() && !d()).a(6, !n().c() && (L() || !N() || y()) && !d()).a(7, K() && !d()).a(8, !n().c() && (K() || (N() && M())) && !d()).a(9, !d()).a(10, y() && !d()).a(11, y() && !d()).a();
    }

    @Override // com.applovin.impl.qh
    public final void a(long j11) {
        a(t(), j11);
    }

    @Override // com.applovin.impl.qh
    public final boolean b(int i11) {
        return i().a(i11);
    }

    public final void c(int i11) {
        a(i11, C.TIME_UNSET);
    }

    @Override // com.applovin.impl.qh
    public final boolean isPlaying() {
        return o() == 3 && l() && j() == 0;
    }

    @Override // com.applovin.impl.qh
    public final void u() {
        if (n().c() || d()) {
            return;
        }
        if (K()) {
            P();
        } else if (N() && M()) {
            O();
        }
    }

    @Override // com.applovin.impl.qh
    public final void w() {
        b(e());
    }

    @Override // com.applovin.impl.qh
    public final boolean y() {
        fo foVarN = n();
        return !foVarN.c() && foVarN.a(t(), this.f18341a).f19053i;
    }
}
