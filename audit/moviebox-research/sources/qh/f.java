package qh;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.upstream.n;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.IOException;
import ph.m;
import rh.i;
import rh.j;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class f {
    public static n a(j jVar, String str, i iVar, int i11) {
        return new n.b().i(iVar.b(str)).h(iVar.f75439a).g(iVar.f75440b).f(g(jVar, iVar)).b(i11).a();
    }

    @Nullable
    public static tg.d b(k kVar, int i11, j jVar) throws IOException {
        return c(kVar, i11, jVar, 0);
    }

    @Nullable
    public static tg.d c(k kVar, int i11, j jVar, int i12) throws IOException {
        if (jVar.m() == null) {
            return null;
        }
        ph.g gVarF = f(i11, jVar.f75444b);
        try {
            e(gVarF, kVar, jVar, i12, true);
            return gVarF.b();
        } finally {
            gVarF.release();
        }
    }

    public static void d(k kVar, j jVar, int i11, ph.g gVar, i iVar) throws IOException {
        new m(kVar, a(jVar, jVar.f75445c.get(i11).f75390a, iVar, 0), jVar.f75444b, 0, null, gVar).load();
    }

    public static void e(ph.g gVar, k kVar, j jVar, int i11, boolean z11) throws IOException {
        i iVar = (i) com.google.android.exoplayer2.util.a.e(jVar.m());
        if (z11) {
            i iVarL = jVar.l();
            if (iVarL == null) {
                return;
            }
            i iVarA = iVar.a(iVarL, jVar.f75445c.get(i11).f75390a);
            if (iVarA == null) {
                d(kVar, jVar, i11, gVar, iVar);
                iVar = iVarL;
            } else {
                iVar = iVarA;
            }
        }
        d(kVar, jVar, i11, gVar, iVar);
    }

    public static ph.g f(int i11, m1 m1Var) {
        String str = m1Var.f33444l;
        return new ph.e((str == null || !(str.startsWith(MimeTypes.VIDEO_WEBM) || str.startsWith(MimeTypes.AUDIO_WEBM))) ? new bh.g() : new zg.e(), i11, m1Var);
    }

    public static String g(j jVar, i iVar) {
        String strJ = jVar.j();
        return strJ != null ? strJ : iVar.b(jVar.f75445c.get(0).f75390a).toString();
    }
}
