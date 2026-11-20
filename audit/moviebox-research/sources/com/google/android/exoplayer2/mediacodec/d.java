package com.google.android.exoplayer2.mediacodec;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.decoder.g;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.util.w;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f33553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f33554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f33555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final MediaCodecInfo.CodecCapabilities f33556d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f33557e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f33558f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f33559g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f33560h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f33561i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f33562j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f33563k;

    public d(String str, String str2, String str3, @Nullable MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        this.f33553a = (String) com.google.android.exoplayer2.util.a.e(str);
        this.f33554b = str2;
        this.f33555c = str3;
        this.f33556d = codecCapabilities;
        this.f33560h = z11;
        this.f33561i = z12;
        this.f33562j = z13;
        this.f33557e = z14;
        this.f33558f = z15;
        this.f33559g = z16;
        this.f33563k = w.s(str2);
    }

    public static boolean A(String str, int i11) {
        if (MimeTypes.VIDEO_H265.equals(str) && 2 == i11) {
            String str2 = o0.f35609b;
            if ("sailfish".equals(str2) || "marlin".equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean B(String str) {
        return ("OMX.MTK.VIDEO.DECODER.HEVC".equals(str) && "mcv5a".equals(o0.f35609b)) ? false : true;
    }

    public static d C(String str, String str2, String str3, @Nullable MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        return new d(str, str2, str3, codecCapabilities, z11, z12, z13, (z14 || codecCapabilities == null || !h(codecCapabilities) || z(str)) ? false : true, codecCapabilities != null && s(codecCapabilities), z15 || (codecCapabilities != null && q(codecCapabilities)));
    }

    public static int a(String str, String str2, int i11) {
        int i12;
        if (i11 > 1 || ((o0.f35608a >= 26 && i11 > 0) || MimeTypes.AUDIO_MPEG.equals(str2) || MimeTypes.AUDIO_AMR_NB.equals(str2) || MimeTypes.AUDIO_AMR_WB.equals(str2) || MimeTypes.AUDIO_AAC.equals(str2) || MimeTypes.AUDIO_VORBIS.equals(str2) || MimeTypes.AUDIO_OPUS.equals(str2) || MimeTypes.AUDIO_RAW.equals(str2) || MimeTypes.AUDIO_FLAC.equals(str2) || MimeTypes.AUDIO_ALAW.equals(str2) || MimeTypes.AUDIO_MLAW.equals(str2) || MimeTypes.AUDIO_MSGSM.equals(str2))) {
            return i11;
        }
        if (MimeTypes.AUDIO_AC3.equals(str2)) {
            i12 = 6;
        } else {
            i12 = MimeTypes.AUDIO_E_AC3.equals(str2) ? 16 : 30;
        }
        s.i(com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecInfo.TAG, "AssumedMaxChannelAdjustment: " + str + ", [" + i11 + " to " + i12 + "]");
        return i12;
    }

    @RequiresApi(21)
    public static Point c(MediaCodecInfo.VideoCapabilities videoCapabilities, int i11, int i12) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(o0.l(i11, widthAlignment) * widthAlignment, o0.l(i12, heightAlignment) * heightAlignment);
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
        return o0.f35608a >= 19 && i(codecCapabilities);
    }

    @RequiresApi(19)
    public static boolean i(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    public static boolean q(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return o0.f35608a >= 21 && r(codecCapabilities);
    }

    @RequiresApi(21)
    public static boolean r(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    public static boolean s(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return o0.f35608a >= 21 && t(codecCapabilities);
    }

    @RequiresApi(21)
    public static boolean t(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    public static boolean x(String str) {
        return MimeTypes.AUDIO_OPUS.equals(str);
    }

    public static boolean y(String str) {
        return o0.f35611d.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str);
    }

    public static boolean z(String str) {
        if (o0.f35608a <= 22) {
            String str2 = o0.f35611d;
            if (("ODROID-XU3".equals(str2) || "Nexus 10".equals(str2)) && ("OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str))) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    @RequiresApi(21)
    public Point b(int i11, int i12) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f33556d;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return c(videoCapabilities, i11, i12);
    }

    public g e(m1 m1Var, m1 m1Var2) {
        int i11 = !o0.c(m1Var.f33445m, m1Var2.f33445m) ? 8 : 0;
        if (this.f33563k) {
            if (m1Var.f33453u != m1Var2.f33453u) {
                i11 |= 1024;
            }
            if (!this.f33557e && (m1Var.f33450r != m1Var2.f33450r || m1Var.f33451s != m1Var2.f33451s)) {
                i11 |= 512;
            }
            if (!o0.c(m1Var.f33457y, m1Var2.f33457y)) {
                i11 |= 2048;
            }
            if (y(this.f33553a) && !m1Var.g(m1Var2)) {
                i11 |= 2;
            }
            if (i11 == 0) {
                return new g(this.f33553a, m1Var, m1Var2, m1Var.g(m1Var2) ? 3 : 2, 0);
            }
        } else {
            if (m1Var.f33458z != m1Var2.f33458z) {
                i11 |= 4096;
            }
            if (m1Var.A != m1Var2.A) {
                i11 |= 8192;
            }
            if (m1Var.B != m1Var2.B) {
                i11 |= 16384;
            }
            if (i11 == 0 && MimeTypes.AUDIO_AAC.equals(this.f33554b)) {
                Pair<Integer, Integer> pairQ = MediaCodecUtil.q(m1Var);
                Pair<Integer, Integer> pairQ2 = MediaCodecUtil.q(m1Var2);
                if (pairQ != null && pairQ2 != null) {
                    int iIntValue = ((Integer) pairQ.first).intValue();
                    int iIntValue2 = ((Integer) pairQ2.first).intValue();
                    if (iIntValue == 42 && iIntValue2 == 42) {
                        return new g(this.f33553a, m1Var, m1Var2, 3, 0);
                    }
                }
            }
            if (!m1Var.g(m1Var2)) {
                i11 |= 32;
            }
            if (x(this.f33554b)) {
                i11 |= 2;
            }
            if (i11 == 0) {
                return new g(this.f33553a, m1Var, m1Var2, 1, 0);
            }
        }
        return new g(this.f33553a, m1Var, m1Var2, 0, i11);
    }

    public MediaCodecInfo.CodecProfileLevel[] g() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f33556d;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }

    @RequiresApi(21)
    public boolean j(int i11) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f33556d;
        if (codecCapabilities == null) {
            w("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            w("channelCount.aCaps");
            return false;
        }
        if (a(this.f33553a, this.f33554b, audioCapabilities.getMaxInputChannelCount()) >= i11) {
            return true;
        }
        w("channelCount.support, " + i11);
        return false;
    }

    @RequiresApi(21)
    public boolean k(int i11) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f33556d;
        if (codecCapabilities == null) {
            w("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            w("sampleRate.aCaps");
            return false;
        }
        if (audioCapabilities.isSampleRateSupported(i11)) {
            return true;
        }
        w("sampleRate.support, " + i11);
        return false;
    }

    public final boolean l(m1 m1Var) {
        Pair<Integer, Integer> pairQ;
        if (m1Var.f33442j == null || (pairQ = MediaCodecUtil.q(m1Var)) == null) {
            return true;
        }
        int iIntValue = ((Integer) pairQ.first).intValue();
        int iIntValue2 = ((Integer) pairQ.second).intValue();
        if ("video/dolby-vision".equals(m1Var.f33445m)) {
            if (!MimeTypes.VIDEO_H264.equals(this.f33554b)) {
                iIntValue = MimeTypes.VIDEO_H265.equals(this.f33554b) ? 2 : 8;
            }
            iIntValue2 = 0;
        }
        if (!this.f33563k && iIntValue != 42) {
            return true;
        }
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrG = g();
        if (o0.f35608a <= 23 && MimeTypes.VIDEO_VP9.equals(this.f33554b) && codecProfileLevelArrG.length == 0) {
            codecProfileLevelArrG = f(this.f33556d);
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArrG) {
            if (codecProfileLevel.profile == iIntValue && codecProfileLevel.level >= iIntValue2 && !A(this.f33554b, iIntValue)) {
                return true;
            }
        }
        w("codec.profileLevel, " + m1Var.f33442j + ", " + this.f33555c);
        return false;
    }

    public boolean m(m1 m1Var) throws MediaCodecUtil.DecoderQueryException {
        int i11;
        if (!o(m1Var) || !l(m1Var)) {
            return false;
        }
        if (!this.f33563k) {
            if (o0.f35608a >= 21) {
                int i12 = m1Var.A;
                if (i12 != -1 && !k(i12)) {
                    return false;
                }
                int i13 = m1Var.f33458z;
                if (i13 != -1 && !j(i13)) {
                    return false;
                }
            }
            return true;
        }
        int i14 = m1Var.f33450r;
        if (i14 <= 0 || (i11 = m1Var.f33451s) <= 0) {
            return true;
        }
        if (o0.f35608a >= 21) {
            return u(i14, i11, m1Var.f33452t);
        }
        boolean z11 = i14 * i11 <= MediaCodecUtil.N();
        if (!z11) {
            w("legacyFrameSize, " + m1Var.f33450r + "x" + m1Var.f33451s);
        }
        return z11;
    }

    public boolean n() {
        if (o0.f35608a >= 29 && MimeTypes.VIDEO_VP9.equals(this.f33554b)) {
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : g()) {
                if (codecProfileLevel.profile == 16384) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean o(m1 m1Var) {
        return this.f33554b.equals(m1Var.f33445m) || this.f33554b.equals(MediaCodecUtil.m(m1Var));
    }

    public boolean p(m1 m1Var) {
        if (this.f33563k) {
            return this.f33557e;
        }
        Pair<Integer, Integer> pairQ = MediaCodecUtil.q(m1Var);
        return pairQ != null && ((Integer) pairQ.first).intValue() == 42;
    }

    public String toString() {
        return this.f33553a;
    }

    @RequiresApi(21)
    public boolean u(int i11, int i12, double d11) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f33556d;
        if (codecCapabilities == null) {
            w("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            w("sizeAndRate.vCaps");
            return false;
        }
        if (d(videoCapabilities, i11, i12, d11)) {
            return true;
        }
        if (i11 < i12 && B(this.f33553a) && d(videoCapabilities, i12, i11, d11)) {
            v("sizeAndRate.rotated, " + i11 + "x" + i12 + "x" + d11);
            return true;
        }
        w("sizeAndRate.support, " + i11 + "x" + i12 + "x" + d11);
        return false;
    }

    public final void v(String str) {
        s.b(com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecInfo.TAG, "AssumedSupport [" + str + "] [" + this.f33553a + ", " + this.f33554b + "] [" + o0.f35612e + "]");
    }

    public final void w(String str) {
        s.b(com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecInfo.TAG, "NoSupport [" + str + "] [" + this.f33553a + ", " + this.f33554b + "] [" + o0.f35612e + "]");
    }
}
