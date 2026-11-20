package x5;

import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.List;
import u4.r0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<androidx.media3.common.y> f80064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r0[] f80065b;

    public k0(List<androidx.media3.common.y> list) {
        this.f80064a = list;
        this.f80065b = new r0[list.size()];
    }

    public void a(long j11, z3.c0 c0Var) {
        if (c0Var.a() < 9) {
            return;
        }
        int iQ = c0Var.q();
        int iQ2 = c0Var.q();
        int iH = c0Var.H();
        if (iQ == 434 && iQ2 == 1195456820 && iH == 3) {
            u4.g.b(j11, c0Var, this.f80065b);
        }
    }

    public void b(u4.u uVar, i0.d dVar) {
        for (int i11 = 0; i11 < this.f80065b.length; i11++) {
            dVar.a();
            r0 r0VarTrack = uVar.track(dVar.c(), 3);
            androidx.media3.common.y yVar = this.f80064a.get(i11);
            String str = yVar.f9501m;
            z3.a.b(MimeTypes.APPLICATION_CEA608.equals(str) || MimeTypes.APPLICATION_CEA708.equals(str), "Invalid closed caption MIME type provided: " + str);
            r0VarTrack.b(new androidx.media3.common.y.b().X(dVar.b()).k0(str).m0(yVar.f9493e).b0(yVar.f9492d).J(yVar.E).Y(yVar.f9503o).I());
            this.f80065b[i11] = r0VarTrack;
        }
    }
}
