package androidx.media3.exoplayer.mediacodec;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.f0;
import androidx.media3.common.k;
import androidx.media3.common.y;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import z3.o;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f10758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final MediaCodecInfo.CodecCapabilities f10759d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f10760e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f10761f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f10762g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f10763h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f10764i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f10765j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f10766k;

    public d(String str, String str2, String str3, @Nullable MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        this.f10756a = (String) z3.a.e(str);
        this.f10757b = str2;
        this.f10758c = str3;
        this.f10759d = codecCapabilities;
        this.f10763h = z11;
        this.f10764i = z12;
        this.f10765j = z13;
        this.f10760e = z14;
        this.f10761f = z15;
        this.f10762g = z16;
        this.f10766k = f0.s(str2);
    }

    public static boolean A(String str) {
        if (u0.f81838a <= 22) {
            String str2 = u0.f81841d;
            if (("ODROID-XU3".equals(str2) || "Nexus 10".equals(str2)) && ("OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str))) {
                return true;
            }
        }
        return false;
    }

    public static boolean B(String str, int i11) {
        if (MimeTypes.VIDEO_H265.equals(str) && 2 == i11) {
            String str2 = u0.f81839b;
            if ("sailfish".equals(str2) || "marlin".equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean C(String str) {
        return ("OMX.MTK.VIDEO.DECODER.HEVC".equals(str) && "mcv5a".equals(u0.f81839b)) ? false : true;
    }

    public static d D(String str, String str2, String str3, @Nullable MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        return new d(str, str2, str3, codecCapabilities, z11, z12, z13, (z14 || codecCapabilities == null || !h(codecCapabilities) || A(str)) ? false : true, codecCapabilities != null && t(codecCapabilities), z15 || (codecCapabilities != null && r(codecCapabilities)));
    }

    public static int a(String str, String str2, int i11) {
        int i12;
        if (i11 > 1 || ((u0.f81838a >= 26 && i11 > 0) || MimeTypes.AUDIO_MPEG.equals(str2) || MimeTypes.AUDIO_AMR_NB.equals(str2) || MimeTypes.AUDIO_AMR_WB.equals(str2) || MimeTypes.AUDIO_AAC.equals(str2) || MimeTypes.AUDIO_VORBIS.equals(str2) || MimeTypes.AUDIO_OPUS.equals(str2) || MimeTypes.AUDIO_RAW.equals(str2) || MimeTypes.AUDIO_FLAC.equals(str2) || MimeTypes.AUDIO_ALAW.equals(str2) || MimeTypes.AUDIO_MLAW.equals(str2) || MimeTypes.AUDIO_MSGSM.equals(str2))) {
            return i11;
        }
        if (MimeTypes.AUDIO_AC3.equals(str2)) {
            i12 = 6;
        } else {
            i12 = MimeTypes.AUDIO_E_AC3.equals(str2) ? 16 : 30;
        }
        o.h(com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecInfo.TAG, "AssumedMaxChannelAdjustment: " + str + ", [" + i11 + " to " + i12 + "]");
        return i12;
    }

    @RequiresApi(21)
    public static Point c(MediaCodecInfo.VideoCapabilities videoCapabilities, int i11, int i12) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(u0.k(i11, widthAlignment) * widthAlignment, u0.k(i12, heightAlignment) * heightAlignment);
    }

    @RequiresApi(21)
    public static boolean d(MediaCodecInfo.VideoCapabilities videoCapabilities, int i11, int i12, double d11) {
        Point pointC = c(videoCapabilities, i11, i12);
        int i13 = pointC.x;
        int i14 = pointC.y;
        return (d11 == -1.0d || d11 < 1.0d) ? videoCapabilities.isSizeSupported(i13, i14) : videoCapabilities.areSizeAndRateSupported(i13, i14, Math.floor(d11));
    }

    public static MediaCodecInfo.CodecProfileLevel[] f(@Nullable MediaCodecInfo.CodecCapabilities codecCapabilities) {
        int i11;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        int iIntValue = (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) ? 0 : ((Integer) videoCapabilities.getBitrateRange().getUpper()).intValue();
        if (iIntValue >= 180000000) {
            i11 = 1024;
        } else if (iIntValue >= 120000000) {
            i11 = 512;
        } else if (iIntValue >= 60000000) {
            i11 = 256;
        } else if (iIntValue >= 30000000) {
            i11 = 128;
        } else if (iIntValue >= 18000000) {
            i11 = 64;
        } else if (iIntValue >= 12000000) {
            i11 = 32;
        } else if (iIntValue >= 7200000) {
            i11 = 16;
        } else if (iIntValue >= 3600000) {
            i11 = 8;
        } else if (iIntValue >= 1800000) {
            i11 = 4;
        } else {
            i11 = iIntValue >= 800000 ? 2 : 1;
        }
        MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
        codecProfileLevel.profile = 1;
        codecProfileLevel.level = i11;
        return new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel};
    }

    public static boolean h(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return u0.f81838a >= 19 && i(codecCapabilities);
    }

    @RequiresApi(19)
    public static boolean i(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    public static boolean r(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return u0.f81838a >= 21 && s(codecCapabilities);
    }

    @RequiresApi(21)
    public static boolean s(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    public static boolean t(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return u0.f81838a >= 21 && u(codecCapabilities);
    }

    @RequiresApi(21)
    public static boolean u(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    public static boolean y(String str) {
        return MimeTypes.AUDIO_OPUS.equals(str);
    }

    public static boolean z(String str) {
        return u0.f81841d.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str);
    }

    @Nullable
    @RequiresApi(21)
    public Point b(int i11, int i12) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f10759d;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return c(videoCapabilities, i11, i12);
    }

    public androidx.media3.exoplayer.o e(y yVar, y yVar2) {
        int i11 = !u0.c(yVar.f9501m, yVar2.f9501m) ? 8 : 0;
        if (this.f10766k) {
            if (yVar.f9509u != yVar2.f9509u) {
                i11 |= 1024;
            }
            if (!this.f10760e && (yVar.f9506r != yVar2.f9506r || yVar.f9507s != yVar2.f9507s)) {
                i11 |= 512;
            }
            if ((!k.i(yVar.f9513y) || !k.i(yVar2.f9513y)) && !u0.c(yVar.f9513y, yVar2.f9513y)) {
                i11 |= 2048;
            }
            if (z(this.f10756a) && !yVar.h(yVar2)) {
                i11 |= 2;
            }
            if (i11 == 0) {
                return new androidx.media3.exoplayer.o(this.f10756a, yVar, yVar2, yVar.h(yVar2) ? 3 : 2, 0);
            }
        } else {
            if (yVar.f9514z != yVar2.f9514z) {
                i11 |= 4096;
            }
            if (yVar.A != yVar2.A) {
                i11 |= 8192;
            }
            if (yVar.B != yVar2.B) {
                i11 |= 16384;
            }
            if (i11 == 0 && MimeTypes.AUDIO_AAC.equals(this.f10757b)) {
                Pair<Integer, Integer> pairR = MediaCodecUtil.r(yVar);
                Pair<Integer, Integer> pairR2 = MediaCodecUtil.r(yVar2);
                if (pairR != null && pairR2 != null) {
                    int iIntValue = ((Integer) pairR.first).intValue();
                    int iIntValue2 = ((Integer) pairR2.first).intValue();
                    if (iIntValue == 42 && iIntValue2 == 42) {
                        return new androidx.media3.exoplayer.o(this.f10756a, yVar, yVar2, 3, 0);
                    }
                }
            }
            if (!yVar.h(yVar2)) {
                i11 |= 32;
            }
            if (y(this.f10757b)) {
                i11 |= 2;
            }
            if (i11 == 0) {
                return new androidx.media3.exoplayer.o(this.f10756a, yVar, yVar2, 1, 0);
            }
        }
        return new androidx.media3.exoplayer.o(this.f10756a, yVar, yVar2, 0, i11);
    }

    public MediaCodecInfo.CodecProfileLevel[] g() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f10759d;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }

    @RequiresApi(21)
    public boolean j(int i11) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f10759d;
        if (codecCapabilities == null) {
            x("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            x("channelCount.aCaps");
            return false;
        }
        if (a(this.f10756a, this.f10757b, audioCapabilities.getMaxInputChannelCount()) >= i11) {
            return true;
        }
        x("channelCount.support, " + i11);
        return false;
    }

    @RequiresApi(21)
    public boolean k(int i11) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f10759d;
        if (codecCapabilities == null) {
            x("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            x("sampleRate.aCaps");
            return false;
        }
        if (audioCapabilities.isSampleRateSupported(i11)) {
            return true;
        }
        x("sampleRate.support, " + i11);
        return false;
    }

    public final boolean l(y yVar, boolean z11) {
        Pair<Integer, Integer> pairR = MediaCodecUtil.r(yVar);
        if (pairR == null) {
            return true;
        }
        int iIntValue = ((Integer) pairR.first).intValue();
        int iIntValue2 = ((Integer) pairR.second).intValue();
        if ("video/dolby-vision".equals(yVar.f9501m)) {
            if (!MimeTypes.VIDEO_H264.equals(this.f10757b)) {
                iIntValue = MimeTypes.VIDEO_H265.equals(this.f10757b) ? 2 : 8;
            }
            iIntValue2 = 0;
        }
        if (!this.f10766k && iIntValue != 42) {
            return true;
        }
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrG = g();
        if (u0.f81838a <= 23 && MimeTypes.VIDEO_VP9.equals(this.f10757b) && codecProfileLevelArrG.length == 0) {
            codecProfileLevelArrG = f(this.f10759d);
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArrG) {
            if (codecProfileLevel.profile == iIntValue && ((codecProfileLevel.level >= iIntValue2 || !z11) && !B(this.f10757b, iIntValue))) {
                return true;
            }
        }
        x("codec.profileLevel, " + yVar.f9498j + ", " + this.f10758c);
        return false;
    }

    public boolean m(y yVar) {
        return p(yVar) && l(yVar, false);
    }

    public boolean n(y yVar) throws MediaCodecUtil.DecoderQueryException {
        int i11;
        if (!p(yVar) || !l(yVar, true)) {
            return false;
        }
        if (!this.f10766k) {
            if (u0.f81838a >= 21) {
                int i12 = yVar.A;
                if (i12 != -1 && !k(i12)) {
                    return false;
                }
                int i13 = yVar.f9514z;
                if (i13 != -1 && !j(i13)) {
                    return false;
                }
            }
            return true;
        }
        int i14 = yVar.f9506r;
        if (i14 <= 0 || (i11 = yVar.f9507s) <= 0) {
            return true;
        }
        if (u0.f81838a >= 21) {
            return v(i14, i11, yVar.f9508t);
        }
        boolean z11 = i14 * i11 <= MediaCodecUtil.P();
        if (!z11) {
            x("legacyFrameSize, " + yVar.f9506r + "x" + yVar.f9507s);
        }
        return z11;
    }

    public boolean o() {
        if (u0.f81838a >= 29 && MimeTypes.VIDEO_VP9.equals(this.f10757b)) {
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : g()) {
                if (codecProfileLevel.profile == 16384) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean p(y yVar) {
        return this.f10757b.equals(yVar.f9501m) || this.f10757b.equals(MediaCodecUtil.m(yVar));
    }

    public boolean q(y yVar) {
        if (this.f10766k) {
            return this.f10760e;
        }
        Pair<Integer, Integer> pairR = MediaCodecUtil.r(yVar);
        return pairR != null && ((Integer) pairR.first).intValue() == 42;
    }

    public String toString() {
        return this.f10756a;
    }

    @RequiresApi(21)
    public boolean v(int i11, int i12, double d11) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f10759d;
        if (codecCapabilities == null) {
            x("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            x("sizeAndRate.vCaps");
            return false;
        }
        if (u0.f81838a >= 29) {
            int iC = e.c(videoCapabilities, i11, i12, d11);
            if (iC == 2) {
                return true;
            }
            if (iC == 1) {
                x("sizeAndRate.cover, " + i11 + "x" + i12 + "@" + d11);
                return false;
            }
        }
        if (!d(videoCapabilities, i11, i12, d11)) {
            if (i11 >= i12 || !C(this.f10756a) || !d(videoCapabilities, i12, i11, d11)) {
                x("sizeAndRate.support, " + i11 + "x" + i12 + "@" + d11);
                return false;
            }
            w("sizeAndRate.rotated, " + i11 + "x" + i12 + "@" + d11);
        }
        return true;
    }

    public final void w(String str) {
        o.b(com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecInfo.TAG, "AssumedSupport [" + str + "] [" + this.f10756a + ", " + this.f10757b + "] [" + u0.f81842e + "]");
    }

    public final void x(String str) {
        o.b(com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecInfo.TAG, "NoSupport [" + str + "] [" + this.f10756a + ", " + this.f10757b + "] [" + u0.f81842e + "]");
    }
}
