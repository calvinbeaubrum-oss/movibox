package x5;

import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.List;
import u4.r0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<androidx.media3.common.y> f79935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r0[] f79936b;

    public d0(List<androidx.media3.common.y> list) {
        this.f79935a = list;
        this.f79936b = new r0[list.size()];
    }

    public void a(long j11, z3.c0 c0Var) {
        u4.g.a(j11, c0Var, this.f79936b);
    }

    public void b(u4.u uVar, i0.d dVar) {
        for (int i11 = 0; i11 < this.f79936b.length; i11++) {
            dVar.a();
            r0 r0VarTrack = uVar.track(dVar.c(), 3);
            androidx.media3.common.y yVar = this.f79935a.get(i11);
            String str = yVar.f9501m;
            z3.a.b(MimeTypes.APPLICATION_CEA608.equals(str) || MimeTypes.APPLICATION_CEA708.equals(str), "Invalid closed caption MIME type provided: " + str);
            String strB = yVar.f9489a;
            if (strB == null) {
                strB = dVar.b();
            }
            r0VarTrack.b(new androidx.media3.common.y.b().X(strB).k0(str).m0(yVar.f9493e).b0(yVar.f9492d).J(yVar.E).Y(yVar.f9503o).I());
            this.f79936b[i11] = r0VarTrack;
        }
    }
}
