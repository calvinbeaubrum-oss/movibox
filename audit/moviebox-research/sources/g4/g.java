package g4;

import androidx.annotation.Nullable;
import androidx.media3.common.y;
import com.google.common.collect.ImmutableMap;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import h4.j;
import java.io.IOException;
import java.util.Map;
import o5.s;
import q4.l;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g {
    public static c4.g a(j jVar, String str, h4.i iVar, int i11, Map<String, String> map) {
        return new c4.g.b().i(iVar.b(str)).h(iVar.f66297a).g(iVar.f66298b).f(g(jVar, iVar)).b(i11).e(map).a();
    }

    @Nullable
    public static u4.h b(androidx.media3.datasource.a aVar, int i11, j jVar) throws IOException {
        return c(aVar, i11, jVar, 0);
    }

    @Nullable
    public static u4.h c(androidx.media3.datasource.a aVar, int i11, j jVar, int i12) throws IOException {
        if (jVar.m() == null) {
            return null;
        }
        q4.f fVarF = f(i11, jVar.f66302b);
        try {
            e(fVarF, aVar, jVar, i12, true);
            return fVarF.b();
        } finally {
            fVarF.release();
        }
    }

    public static void d(androidx.media3.datasource.a aVar, j jVar, int i11, q4.f fVar, h4.i iVar) throws IOException {
        new l(aVar, a(jVar, jVar.f66303c.get(i11).f66248a, iVar, 0, ImmutableMap.of()), jVar.f66302b, 0, null, fVar).load();
    }

    public static void e(q4.f fVar, androidx.media3.datasource.a aVar, j jVar, int i11, boolean z11) throws IOException {
        h4.i iVar = (h4.i) z3.a.e(jVar.m());
        if (z11) {
            h4.i iVarL = jVar.l();
            if (iVarL == null) {
                return;
            }
            h4.i iVarA = iVar.a(iVarL, jVar.f66303c.get(i11).f66248a);
            if (iVarA == null) {
                d(aVar, jVar, i11, fVar, iVar);
                iVar = iVarL;
            } else {
                iVar = iVarA;
            }
        }
        d(aVar, jVar, i11, fVar, iVar);
    }

    public static q4.f f(int i11, y yVar) {
        String str = yVar.f9500l;
        return new q4.d((str == null || !(str.startsWith(MimeTypes.VIDEO_WEBM) || str.startsWith(MimeTypes.AUDIO_WEBM))) ? new l5.g(s.a.f72352a, 32) : new j5.e(s.a.f72352a, 2), i11, yVar);
    }

    public static String g(j jVar, h4.i iVar) {
        String strJ = jVar.j();
        return strJ != null ? strJ : iVar.b(jVar.f66303c.get(0).f66248a).toString();
    }
}
