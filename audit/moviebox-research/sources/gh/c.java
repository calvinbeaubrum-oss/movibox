package gh;

import com.google.android.exoplayer2.m1;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f65500a = new a();

    /* JADX INFO: compiled from: source.java */
    public class a implements c {
        @Override // gh.c
        public boolean a(m1 m1Var) {
            String str = m1Var.f33445m;
            return MimeTypes.APPLICATION_ID3.equals(str) || MimeTypes.APPLICATION_EMSG.equals(str) || MimeTypes.APPLICATION_SCTE35.equals(str) || "application/x-icy".equals(str) || "application/vnd.dvb.ait".equals(str);
        }

        @Override // gh.c
        public b b(m1 m1Var) {
            String str = m1Var.f33445m;
            if (str != null) {
                switch (str) {
                    case "application/vnd.dvb.ait":
                        return new hh.a();
                    case "application/x-icy":
                        return new jh.a();
                    case "application/id3":
                        return new kh.b();
                    case "application/x-emsg":
                        return new ih.a();
                    case "application/x-scte35":
                        return new mh.a();
                }
            }
            throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + str);
        }
    }

    boolean a(m1 m1Var);

    b b(m1 m1Var);
}
