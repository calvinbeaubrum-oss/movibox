package w4;

import androidx.annotation.Nullable;
import androidx.media3.common.y;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import z3.c0;
import z3.o;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f79286a;

    public g(y yVar) {
        this.f79286a = yVar;
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
        c0Var.V(4);
        int iU = c0Var.u();
        int iU2 = c0Var.u();
        c0Var.V(4);
        int iU3 = c0Var.u();
        String strA = a(iU3);
        if (strA != null) {
            y.b bVar = new y.b();
            bVar.r0(iU).V(iU2).k0(strA);
            return new g(bVar.I());
        }
        o.h("StreamFormatChunk", "Ignoring track with unsupported compression " + iU3);
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
        o.h("StreamFormatChunk", "Ignoring strf box for unsupported track type: " + u0.v0(i11));
        return null;
    }

    @Nullable
    public static a e(c0 c0Var) {
        int iZ = c0Var.z();
        String strB = b(iZ);
        if (strB == null) {
            o.h("StreamFormatChunk", "Ignoring track with unsupported format tag " + iZ);
            return null;
        }
        int iZ2 = c0Var.z();
        int iU = c0Var.u();
        c0Var.V(6);
        int iJ0 = u0.j0(c0Var.N());
        int iZ3 = c0Var.z();
        byte[] bArr = new byte[iZ3];
        c0Var.l(bArr, 0, iZ3);
        y.b bVar = new y.b();
        bVar.k0(strB).L(iZ2).l0(iU);
        if (MimeTypes.AUDIO_RAW.equals(strB) && iJ0 != 0) {
            bVar.e0(iJ0);
        }
        if (MimeTypes.AUDIO_AAC.equals(strB) && iZ3 > 0) {
            bVar.Y(ImmutableList.of(bArr));
        }
        return new g(bVar.I());
    }

    @Override // w4.a
    public int getType() {
        return 1718776947;
    }
}
