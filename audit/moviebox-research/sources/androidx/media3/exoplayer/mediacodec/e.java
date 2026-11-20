package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodecInfo;
import androidx.annotation.RequiresApi;
import androidx.media3.common.y;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.vungle.warren.error.VungleException;
import java.util.List;
import m4.m;
import m4.n;
import m4.p;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f10767a;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static final class a {
        public static int a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i11, int i12, double d11) {
            List supportedPerformancePoints = videoCapabilities.getSupportedPerformancePoints();
            if (supportedPerformancePoints == null || supportedPerformancePoints.isEmpty()) {
                return 0;
            }
            n.a();
            int iB = b(supportedPerformancePoints, m.a(i11, i12, (int) d11));
            if (iB == 1 && e.f10767a == null) {
                Boolean unused = e.f10767a = Boolean.valueOf(c());
                if (e.f10767a.booleanValue()) {
                    return 0;
                }
            }
            return iB;
        }

        public static int b(List<MediaCodecInfo.VideoCapabilities.PerformancePoint> list, MediaCodecInfo.VideoCapabilities.PerformancePoint performancePoint) {
            for (int i11 = 0; i11 < list.size(); i11++) {
                if (p.a(list.get(i11)).covers(performancePoint)) {
                    return 2;
                }
            }
            return 1;
        }

        public static boolean c() {
            List supportedPerformancePoints;
            if (u0.f81838a >= 35) {
                return false;
            }
            try {
                y yVarI = new y.b().k0(MimeTypes.VIDEO_H264).I();
                if (yVarI.f9501m != null) {
                    List<d> listV = MediaCodecUtil.v(f.f10768a, yVarI, false, false);
                    for (int i11 = 0; i11 < listV.size(); i11++) {
                        if (listV.get(i11).f10759d != null && listV.get(i11).f10759d.getVideoCapabilities() != null && (supportedPerformancePoints = listV.get(i11).f10759d.getVideoCapabilities().getSupportedPerformancePoints()) != null && !supportedPerformancePoints.isEmpty()) {
                            n.a();
                            return b(supportedPerformancePoints, m.a(1280, 720, 60)) == 1;
                        }
                    }
                }
            } catch (MediaCodecUtil.DecoderQueryException unused) {
            }
            return true;
        }
    }

    public static int c(MediaCodecInfo.VideoCapabilities videoCapabilities, int i11, int i12, double d11) {
        if (u0.f81838a < 29) {
            return 0;
        }
        Boolean bool = f10767a;
        if (bool == null || !bool.booleanValue()) {
            return a.a(videoCapabilities, i11, i12, d11);
        }
        return 0;
    }
}
