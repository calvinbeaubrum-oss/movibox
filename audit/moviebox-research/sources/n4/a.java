package n4;

import androidx.media3.common.y;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f71561a = new C0768a();

    /* JADX INFO: renamed from: n4.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0768a implements a {
        @Override // n4.a
        public boolean a(y yVar) {
            String str = yVar.f9501m;
            return MimeTypes.APPLICATION_ID3.equals(str) || MimeTypes.APPLICATION_EMSG.equals(str) || MimeTypes.APPLICATION_SCTE35.equals(str) || "application/x-icy".equals(str) || "application/vnd.dvb.ait".equals(str);
        }

        @Override // n4.a
        public c5.a b(y yVar) {
            String str = yVar.f9501m;
            if (str != null) {
                switch (str) {
                    case "application/vnd.dvb.ait":
                        return new d5.a();
                    case "application/x-icy":
                        return new f5.a();
                    case "application/id3":
                        return new g5.b();
                    case "application/x-emsg":
                        return new e5.a();
                    case "application/x-scte35":
                        return new i5.a();
                }
            }
            throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + str);
        }
    }

    boolean a(y yVar);

    c5.a b(y yVar);
}
