package com.applovin.impl;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class kd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f20201c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MediaCodecInfo.CodecCapabilities f20202d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f20203e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f20204f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f20205g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f20206h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f20207i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f20208j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f20209k;

    public kd(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        this.f20199a = (String) b1.a((Object) str);
        this.f20200b = str2;
        this.f20201c = str3;
        this.f20202d = codecCapabilities;
        this.f20206h = z11;
        this.f20207i = z12;
        this.f20208j = z13;
        this.f20203e = z14;
        this.f20204f = z15;
        this.f20205g = z16;
        this.f20209k = Cif.i(str2);
    }

    private static int a(String str, String str2, int i11) {
        int i12;
        if (i11 > 1 || ((xp.f24372a >= 26 && i11 > 0) || MimeTypes.AUDIO_MPEG.equals(str2) || MimeTypes.AUDIO_AMR_NB.equals(str2) || MimeTypes.AUDIO_AMR_WB.equals(str2) || MimeTypes.AUDIO_AAC.equals(str2) || MimeTypes.AUDIO_VORBIS.equals(str2) || MimeTypes.AUDIO_OPUS.equals(str2) || MimeTypes.AUDIO_RAW.equals(str2) || MimeTypes.AUDIO_FLAC.equals(str2) || MimeTypes.AUDIO_ALAW.equals(str2) || MimeTypes.AUDIO_MLAW.equals(str2) || MimeTypes.AUDIO_MSGSM.equals(str2))) {
            return i11;
        }
        if (MimeTypes.AUDIO_AC3.equals(str2)) {
            i12 = 6;
        } else {
            i12 = MimeTypes.AUDIO_E_AC3.equals(str2) ? 16 : 30;
        }
        pc.d(com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecInfo.TAG, "AssumedMaxChannelAdjustment: " + str + ", [" + i11 + " to " + i12 + "]");
        return i12;
    }

    private static Point a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i11, int i12) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(xp.a(i11, widthAlignment) * widthAlignment, xp.a(i12, heightAlignment) * heightAlignment);
    }

    public static kd a(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        return new kd(str, str2, str3, codecCapabilities, z11, z12, z13, (z14 || codecCapabilities == null || !b(codecCapabilities) || e(str)) ? false : true, codecCapabilities != null && f(codecCapabilities), z15 || (codecCapabilities != null && d(codecCapabilities)));
    }

    private void a(String str) {
        pc.a(com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecInfo.TAG, "AssumedSupport [" + str + "] [" + this.f20199a + ", " + this.f20200b + "] [" + xp.f24376e + "]");
    }

    private static boolean a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i11, int i12, double d11) {
        Point pointA = a(videoCapabilities, i11, i12);
        int i13 = pointA.x;
        int i14 = pointA.y;
        return (d11 == -1.0d || d11 < 1.0d) ? videoCapabilities.isSizeSupported(i13, i14) : videoCapabilities.areSizeAndRateSupported(i13, i14, Math.floor(d11));
    }

    private static MediaCodecInfo.CodecProfileLevel[] a(MediaCodecInfo.CodecCapabilities codecCapabilities) {
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

    private void b(String str) {
        pc.a(com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecInfo.TAG, "NoSupport [" + str + "] [" + this.f20199a + ", " + this.f20200b + "] [" + xp.f24376e + "]");
    }

    private static boolean b(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return xp.f24372a >= 19 && c(codecCapabilities);
    }

    private static boolean c(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    private static boolean c(String str) {
        return MimeTypes.AUDIO_OPUS.equals(str);
    }

    private static boolean d(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return xp.f24372a >= 21 && e(codecCapabilities);
    }

    private static boolean d(String str) {
        return xp.f24375d.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str);
    }

    private static boolean e(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    private static boolean e(String str) {
        if (xp.f24372a <= 22) {
            String str2 = xp.f24375d;
            if (("ODROID-XU3".equals(str2) || "Nexus 10".equals(str2)) && ("OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str))) {
                return true;
            }
        }
        return false;
    }

    private static boolean f(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return xp.f24372a >= 21 && g(codecCapabilities);
    }

    private static final boolean f(String str) {
        return ("OMX.MTK.VIDEO.DECODER.HEVC".equals(str) && "mcv5a".equals(xp.f24373b)) ? false : true;
    }

    private static boolean g(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    public Point a(int i11, int i12) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f20202d;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return a(videoCapabilities, i11, i12);
    }

    public q5 a(f9 f9Var, f9 f9Var2) {
        int i11 = !xp.a((Object) f9Var.f18900m, (Object) f9Var2.f18900m) ? 8 : 0;
        if (this.f20209k) {
            if (f9Var.f18908u != f9Var2.f18908u) {
                i11 |= 1024;
            }
            if (!this.f20203e && (f9Var.f18905r != f9Var2.f18905r || f9Var.f18906s != f9Var2.f18906s)) {
                i11 |= 512;
            }
            if (!xp.a(f9Var.f18912y, f9Var2.f18912y)) {
                i11 |= 2048;
            }
            if (d(this.f20199a) && !f9Var.a(f9Var2)) {
                i11 |= 2;
            }
            if (i11 == 0) {
                return new q5(this.f20199a, f9Var, f9Var2, f9Var.a(f9Var2) ? 3 : 2, 0);
            }
        } else {
            if (f9Var.f18913z != f9Var2.f18913z) {
                i11 |= 4096;
            }
            if (f9Var.A != f9Var2.A) {
                i11 |= 8192;
            }
            if (f9Var.B != f9Var2.B) {
                i11 |= 16384;
            }
            if (i11 == 0 && MimeTypes.AUDIO_AAC.equals(this.f20200b)) {
                Pair pairA = nd.a(f9Var);
                Pair pairA2 = nd.a(f9Var2);
                if (pairA != null && pairA2 != null) {
                    int iIntValue = ((Integer) pairA.first).intValue();
                    int iIntValue2 = ((Integer) pairA2.first).intValue();
                    if (iIntValue == 42 && iIntValue2 == 42) {
                        return new q5(this.f20199a, f9Var, f9Var2, 3, 0);
                    }
                }
            }
            if (!f9Var.a(f9Var2)) {
                i11 |= 32;
            }
            if (c(this.f20200b)) {
                i11 |= 2;
            }
            if (i11 == 0) {
                return new q5(this.f20199a, f9Var, f9Var2, 1, 0);
            }
        }
        return new q5(this.f20199a, f9Var, f9Var2, 0, i11);
    }

    public boolean a(int i11) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f20202d;
        if (codecCapabilities == null) {
            b("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            b("channelCount.aCaps");
            return false;
        }
        if (a(this.f20199a, this.f20200b, audioCapabilities.getMaxInputChannelCount()) >= i11) {
            return true;
        }
        b("channelCount.support, " + i11);
        return false;
    }

    public boolean a(int i11, int i12, double d11) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f20202d;
        if (codecCapabilities == null) {
            b("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            b("sizeAndRate.vCaps");
            return false;
        }
        if (a(videoCapabilities, i11, i12, d11)) {
            return true;
        }
        if (i11 < i12 && f(this.f20199a) && a(videoCapabilities, i12, i11, d11)) {
            a("sizeAndRate.rotated, " + i11 + "x" + i12 + "x" + d11);
            return true;
        }
        b("sizeAndRate.support, " + i11 + "x" + i12 + "x" + d11);
        return false;
    }

    public boolean a(f9 f9Var) {
        String strB;
        String str = f9Var.f18897j;
        if (str == null || this.f20200b == null || (strB = Cif.b(str)) == null) {
            return true;
        }
        if (!this.f20200b.equals(strB)) {
            b("codec.mime " + f9Var.f18897j + ", " + strB);
            return false;
        }
        Pair pairA = nd.a(f9Var);
        if (pairA == null) {
            return true;
        }
        int iIntValue = ((Integer) pairA.first).intValue();
        int iIntValue2 = ((Integer) pairA.second).intValue();
        if (!this.f20209k && iIntValue != 42) {
            return true;
        }
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrA = a();
        if (xp.f24372a <= 23 && MimeTypes.VIDEO_VP9.equals(this.f20200b) && codecProfileLevelArrA.length == 0) {
            codecProfileLevelArrA = a(this.f20202d);
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArrA) {
            if (codecProfileLevel.profile == iIntValue && codecProfileLevel.level >= iIntValue2) {
                return true;
            }
        }
        b("codec.profileLevel, " + f9Var.f18897j + ", " + strB);
        return false;
    }

    public MediaCodecInfo.CodecProfileLevel[] a() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f20202d;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }

    public boolean b() {
        if (xp.f24372a >= 29 && MimeTypes.VIDEO_VP9.equals(this.f20200b)) {
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : a()) {
                if (codecProfileLevel.profile == 16384) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean b(int i11) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f20202d;
        if (codecCapabilities == null) {
            b("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            b("sampleRate.aCaps");
            return false;
        }
        if (audioCapabilities.isSampleRateSupported(i11)) {
            return true;
        }
        b("sampleRate.support, " + i11);
        return false;
    }

    public boolean b(f9 f9Var) {
        int i11;
        if (!a(f9Var)) {
            return false;
        }
        if (!this.f20209k) {
            if (xp.f24372a >= 21) {
                int i12 = f9Var.A;
                if (i12 != -1 && !b(i12)) {
                    return false;
                }
                int i13 = f9Var.f18913z;
                if (i13 != -1 && !a(i13)) {
                    return false;
                }
            }
            return true;
        }
        int i14 = f9Var.f18905r;
        if (i14 <= 0 || (i11 = f9Var.f18906s) <= 0) {
            return true;
        }
        if (xp.f24372a >= 21) {
            return a(i14, i11, f9Var.f18907t);
        }
        boolean z11 = i14 * i11 <= nd.b();
        if (!z11) {
            b("legacyFrameSize, " + f9Var.f18905r + "x" + f9Var.f18906s);
        }
        return z11;
    }

    public boolean c(f9 f9Var) {
        if (this.f20209k) {
            return this.f20203e;
        }
        Pair pairA = nd.a(f9Var);
        return pairA != null && ((Integer) pairA.first).intValue() == 42;
    }

    public String toString() {
        return this.f20199a;
    }
}
