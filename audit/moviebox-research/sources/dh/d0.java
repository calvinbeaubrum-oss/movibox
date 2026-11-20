package dh;

import com.google.android.exoplayer2.m1;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<m1> f63092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final tg.e0[] f63093b;

    public d0(List<m1> list) {
        this.f63092a = list;
        this.f63093b = new tg.e0[list.size()];
    }

    public void a(long j11, com.google.android.exoplayer2.util.c0 c0Var) {
        tg.c.a(j11, c0Var, this.f63093b);
    }

    public void b(tg.n nVar, i0.d dVar) {
        for (int i11 = 0; i11 < this.f63093b.length; i11++) {
            dVar.a();
            tg.e0 e0VarTrack = nVar.track(dVar.c(), 3);
            m1 m1Var = this.f63092a.get(i11);
            String str = m1Var.f33445m;
            com.google.android.exoplayer2.util.a.b(MimeTypes.APPLICATION_CEA608.equals(str) || MimeTypes.APPLICATION_CEA708.equals(str), "Invalid closed caption mime type provided: " + str);
            String strB = m1Var.f33434a;
            if (strB == null) {
                strB = dVar.b();
            }
            e0VarTrack.e(new m1.b().S(strB).e0(str).g0(m1Var.f33437d).V(m1Var.f33436c).F(m1Var.E).T(m1Var.f33447o).E());
            this.f63093b[i11] = e0VarTrack;
        }
    }
}
