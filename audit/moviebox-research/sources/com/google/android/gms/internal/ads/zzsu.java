package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import androidx.annotation.RequiresApi;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.vungle.warren.error.VungleException;
import java.util.List;
import m4.m;
import m4.n;
import m4.p;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
final class zzsu {
    public static int zza(MediaCodecInfo.VideoCapabilities videoCapabilities, String str, int i11, int i12, double d11) {
        List supportedPerformancePoints = videoCapabilities.getSupportedPerformancePoints();
        if (supportedPerformancePoints == null || supportedPerformancePoints.isEmpty()) {
            return 0;
        }
        int iZzb = zzb(supportedPerformancePoints, m.a(i11, i12, (int) d11));
        if (iZzb == 1 && str.equals(MimeTypes.VIDEO_H264)) {
            n.a();
            if (zzb(supportedPerformancePoints, m.a(1280, 720, 60)) != 2) {
                return 0;
            }
        }
        return iZzb;
    }

    private static int zzb(List list, MediaCodecInfo.VideoCapabilities.PerformancePoint performancePoint) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (p.a(list.get(i11)).covers(performancePoint)) {
                return 2;
            }
        }
        return 1;
    }
}
