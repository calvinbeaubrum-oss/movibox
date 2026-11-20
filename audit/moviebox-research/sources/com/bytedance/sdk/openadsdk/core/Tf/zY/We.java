package com.bytedance.sdk.openadsdk.core.Tf.zY;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class We {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static final List<String> f28243sc = Arrays.asList(MimeTypes.VIDEO_MP4, MimeTypes.VIDEO_H263);

    private static double sc(int i11) {
        int iMax = Math.max(i11, 0);
        if (700 > iMax || iMax > 1500) {
            return Math.min(Math.abs(700 - iMax) / 700.0f, Math.abs(1500 - iMax) / 1500.0f);
        }
        return 0.0d;
    }

    private static double sc(int i11, double d11, int i12, int i13) {
        return (d11 > 0.0d ? Math.abs(d11 - (i13 > 0 ? ((double) i12) / ((double) i13) : 0.0d)) : 0.0d) + (i11 > 0 ? Math.abs((i11 - i12) / i11) : 0.0d);
    }

    public static double sc(int i11, double d11, int i12, int i13, int i14, @Nullable String str) {
        double dSc = sc(i11, d11, i12, i13);
        return sc(str) * (1.0d / ((dSc + 1.0d) + sc(i14)));
    }

    private static double sc(String str) {
        if (str == null) {
            str = "";
        }
        int iHashCode = str.hashCode();
        if (iHashCode != -1664118616) {
            return (iHashCode == 1331848029 && str.equals(MimeTypes.VIDEO_MP4)) ? 1.5d : 1.0d;
        }
        str.equals(MimeTypes.VIDEO_H263);
        return 1.0d;
    }
}
