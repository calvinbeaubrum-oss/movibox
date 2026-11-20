package dh;

import com.google.android.exoplayer2.m1;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<m1> f63211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final tg.e0[] f63212b;

    public k0(List<m1> list) {
        this.f63211a = list;
        this.f63212b = new tg.e0[list.size()];
    }

    public void a(long j11, com.google.android.exoplayer2.util.c0 c0Var) {
        if (c0Var.a() < 9) {
            return;
        }
        int iN = c0Var.n();
        int iN2 = c0Var.n();
        int iD = c0Var.D();
        if (iN == 434 && iN2 == 1195456820 && iD == 3) {
            tg.c.b(j11, c0Var, this.f63212b);
        }
    }

    public void b(tg.n nVar, i0.d dVar) {
        for (int i11 = 0; i11 < this.f63212b.length; i11++) {
            dVar.a();
            tg.e0 e0VarTrack = nVar.track(dVar.c(), 3);
            m1 m1Var = this.f63211a.get(i11);
            String str = m1Var.f33445m;
            com.google.android.exoplayer2.util.a.b(MimeTypes.APPLICATION_CEA608.equals(str) || MimeTypes.APPLICATION_CEA708.equals(str), "Invalid closed caption mime type provided: " + str);
            e0VarTrack.e(new m1.b().S(dVar.b()).e0(str).g0(m1Var.f33437d).V(m1Var.f33436c).F(m1Var.E).T(m1Var.f33447o).E());
            this.f63212b[i11] = e0VarTrack;
        }
    }
}
