package o5;

import androidx.media3.common.y;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h implements s.a {
    @Override // o5.s.a
    public boolean a(y yVar) {
        String str = yVar.f9501m;
        return Objects.equals(str, MimeTypes.TEXT_SSA) || Objects.equals(str, MimeTypes.TEXT_VTT) || Objects.equals(str, MimeTypes.APPLICATION_MP4VTT) || Objects.equals(str, MimeTypes.APPLICATION_SUBRIP) || Objects.equals(str, MimeTypes.APPLICATION_TX3G) || Objects.equals(str, MimeTypes.APPLICATION_PGS) || Objects.equals(str, MimeTypes.APPLICATION_DVBSUBS) || Objects.equals(str, MimeTypes.APPLICATION_TTML);
    }

    @Override // o5.s.a
    public int b(y yVar) {
        String str = yVar.f9501m;
        if (str != null) {
            switch (str) {
                case "application/dvbsubs":
                case "application/pgs":
                case "application/x-mp4-vtt":
                    return 2;
                case "text/vtt":
                    return 1;
                case "application/x-quicktime-tx3g":
                    return 2;
                case "text/x-ssa":
                case "application/x-subrip":
                case "application/ttml+xml":
                    return 1;
            }
        }
        throw new IllegalArgumentException("Unsupported MIME type: " + str);
    }

    @Override // o5.s.a
    public s c(y yVar) {
        String str = yVar.f9501m;
        if (str != null) {
            switch (str) {
                case "application/dvbsubs":
                    return new q5.a(yVar.f9503o);
                case "application/pgs":
                    return new r5.a();
                case "application/x-mp4-vtt":
                    return new w5.a();
                case "text/vtt":
                    return new w5.g();
                case "application/x-quicktime-tx3g":
                    return new v5.a(yVar.f9503o);
                case "text/x-ssa":
                    return new s5.b(yVar.f9503o);
                case "application/x-subrip":
                    return new t5.a();
                case "application/ttml+xml":
                    return new u5.d();
            }
        }
        throw new IllegalArgumentException("Unsupported MIME type: " + str);
    }
}
