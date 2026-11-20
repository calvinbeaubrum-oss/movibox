package vg;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.s;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class g implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m1 f78814a;

    public g(m1 m1Var) {
        this.f78814a = m1Var;
    }

    @Nullable
    public static String a(int i11) {
        switch (i11) {
            case 808802372:
            case 877677894:
            case 1145656883:
            case 1145656920:
            case 1482049860:
            case 1684633208:
            case 2021026148:
                return MimeTypes.VIDEO_MP4V;
            case 826496577:
            case 828601953:
            case 875967048:
                return MimeTypes.VIDEO_H264;
            case 842289229:
                return "video/mp42";
            case 859066445:
                return "video/mp43";
            case 1196444237:
            case 1735420525:
                return "video/mjpeg";
            default:
                return null;
        }
    }

    @Nullable
    public static String b(int i11) {
        if (i11 == 1) {
            return MimeTypes.AUDIO_RAW;
        }
        if (i11 == 85) {
            return MimeTypes.AUDIO_MPEG;
        }
        if (i11 == 255) {
            return MimeTypes.AUDIO_AAC;
        }
        if (i11 == 8192) {
            return MimeTypes.AUDIO_AC3;
        }
        if (i11 != 8193) {
            return null;
        }
        return MimeTypes.AUDIO_DTS;
    }

    @Nullable
    public static a c(c0 c0Var) {
        c0Var.Q(4);
        int iQ = c0Var.q();
        int iQ2 = c0Var.q();
        c0Var.Q(4);
        int iQ3 = c0Var.q();
        String strA = a(iQ3);
        if (strA != null) {
            m1.b bVar = new m1.b();
            bVar.j0(iQ).Q(iQ2).e0(strA);
            return new g(bVar.E());
        }
        s.i("StreamFormatChunk", "Ignoring track with unsupported compression " + iQ3);
        return null;
    }

    @Nullable
    public static a d(int i11, c0 c0Var) {
        if (i11 == 2) {
            return c(c0Var);
        }
        if (i11 == 1) {
            return e(c0Var);
        }
        s.i("StreamFormatChunk", "Ignoring strf box for unsupported track type: " + o0.m0(i11));
        return null;
    }

    @Nullable
    public static a e(c0 c0Var) {
        int iV = c0Var.v();
        String strB = b(iV);
        if (strB == null) {
            s.i("StreamFormatChunk", "Ignoring track with unsupported format tag " + iV);
            return null;
        }
        int iV2 = c0Var.v();
        int iQ = c0Var.q();
        c0Var.Q(6);
        int iC0 = o0.c0(c0Var.J());
        int iV3 = c0Var.v();
        byte[] bArr = new byte[iV3];
        c0Var.j(bArr, 0, iV3);
        m1.b bVar = new m1.b();
        bVar.e0(strB).H(iV2).f0(iQ);
        if (MimeTypes.AUDIO_RAW.equals(strB) && iC0 != 0) {
            bVar.Y(iC0);
        }
        if (MimeTypes.AUDIO_AAC.equals(strB) && iV3 > 0) {
            bVar.T(ImmutableList.of(bArr));
        }
        return new g(bVar.E());
    }

    @Override // vg.a
    public int getType() {
        return 1718776947;
    }
}
