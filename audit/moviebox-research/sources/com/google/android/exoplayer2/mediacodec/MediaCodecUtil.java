package com.google.android.exoplayer2.mediacodec;

import android.annotation.SuppressLint;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.MotionEventCompat;
import com.applovin.exoplayer2.common.base.Ascii;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.util.w;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.vungle.warren.error.VungleException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"InlinedApi"})
public final class MediaCodecUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f33528a = Pattern.compile("^\\D?(\\d+)$");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<b, List<com.google.android.exoplayer2.mediacodec.d>> f33529b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f33530c = -1;

    /* JADX INFO: compiled from: source.java */
    public static class DecoderQueryException extends Exception {
        private DecoderQueryException(Throwable th2) {
            super("Failed to query underlying media codecs", th2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f33531a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f33532b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f33533c;

        public b(String str, boolean z11, boolean z12) {
            this.f33531a = str;
            this.f33532b = z11;
            this.f33533c = z12;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != b.class) {
                return false;
            }
            b bVar = (b) obj;
            return TextUtils.equals(this.f33531a, bVar.f33531a) && this.f33532b == bVar.f33532b && this.f33533c == bVar.f33533c;
        }

        public int hashCode() {
            return ((((this.f33531a.hashCode() + 31) * 31) + (this.f33532b ? 1231 : 1237)) * 31) + (this.f33533c ? 1231 : 1237);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        boolean a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        int getCodecCount();

        MediaCodecInfo getCodecInfoAt(int i11);

        boolean secureDecodersExplicit();
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d implements c {
        public d() {
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "secure-playback".equals(str) && MimeTypes.VIDEO_H264.equals(str2);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return false;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public int getCodecCount() {
            return MediaCodecList.getCodecCount();
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public MediaCodecInfo getCodecInfoAt(int i11) {
            return MediaCodecList.getCodecInfoAt(i11);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean secureDecodersExplicit() {
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(21)
    public static final class e implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f33534a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public MediaCodecInfo[] f33535b;

        public e(boolean z11, boolean z12) {
            this.f33534a = (z11 || z12) ? 1 : 0;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported(str);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureRequired(str);
        }

        public final void c() {
            if (this.f33535b == null) {
                this.f33535b = new MediaCodecList(this.f33534a).getCodecInfos();
            }
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public int getCodecCount() {
            c();
            return this.f33535b.length;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public MediaCodecInfo getCodecInfoAt(int i11) {
            c();
            return this.f33535b[i11];
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean secureDecodersExplicit() {
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface f<T> {
        int a(T t11);
    }

    public static boolean A(MediaCodecInfo mediaCodecInfo) {
        return o0.f35608a >= 29 && B(mediaCodecInfo);
    }

    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static boolean B(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isAlias();
    }

    public static boolean C(MediaCodecInfo mediaCodecInfo, String str, boolean z11, String str2) {
        if (mediaCodecInfo.isEncoder() || (!z11 && str.endsWith(".secure"))) {
            return false;
        }
        int i11 = o0.f35608a;
        if (i11 < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (i11 < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str)) {
            String str3 = o0.f35609b;
            if ("a70".equals(str3) || ("Xiaomi".equals(o0.f35610c) && str3.startsWith("HM"))) {
                return false;
            }
        }
        if (i11 == 16 && "OMX.qcom.audio.decoder.mp3".equals(str)) {
            String str4 = o0.f35609b;
            if ("dlxu".equals(str4) || "protou".equals(str4) || "ville".equals(str4) || "villeplus".equals(str4) || "villec2".equals(str4) || str4.startsWith("gee") || "C6602".equals(str4) || "C6603".equals(str4) || "C6606".equals(str4) || "C6616".equals(str4) || "L36h".equals(str4) || "SO-02E".equals(str4)) {
                return false;
            }
        }
        if (i11 == 16 && "OMX.qcom.audio.decoder.aac".equals(str)) {
            String str5 = o0.f35609b;
            if ("C1504".equals(str5) || "C1505".equals(str5) || "C1604".equals(str5) || "C1605".equals(str5)) {
                return false;
            }
        }
        if (i11 < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && "samsung".equals(o0.f35610c))) {
            String str6 = o0.f35609b;
            if (str6.startsWith("zeroflte") || str6.startsWith("zerolte") || str6.startsWith("zenlte") || "SC-05G".equals(str6) || "marinelteatt".equals(str6) || "404SC".equals(str6) || "SC-04G".equals(str6) || "SCV31".equals(str6)) {
                return false;
            }
        }
        if (i11 <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(o0.f35610c)) {
            String str7 = o0.f35609b;
            if (str7.startsWith("d2") || str7.startsWith("serrano") || str7.startsWith("jflte") || str7.startsWith("santos") || str7.startsWith("t0")) {
                return false;
            }
        }
        if (i11 <= 19 && o0.f35609b.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
            return false;
        }
        return (i11 <= 23 && MimeTypes.AUDIO_E_AC3_JOC.equals(str2) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) ? false : true;
    }

    public static boolean D(MediaCodecInfo mediaCodecInfo, String str) {
        return o0.f35608a >= 29 ? E(mediaCodecInfo) : !F(mediaCodecInfo, str);
    }

    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static boolean E(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isHardwareAccelerated();
    }

    public static boolean F(MediaCodecInfo mediaCodecInfo, String str) {
        if (o0.f35608a >= 29) {
            return G(mediaCodecInfo);
        }
        if (w.o(str)) {
            return true;
        }
        String strE = com.google.common.base.a.e(mediaCodecInfo.getName());
        if (strE.startsWith("arc.")) {
            return false;
        }
        if (strE.startsWith("omx.google.") || strE.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((strE.startsWith("omx.sec.") && strE.contains(".sw.")) || strE.equals("omx.qcom.video.decoder.hevcswvdec") || strE.startsWith("c2.android.") || strE.startsWith("c2.google.")) {
            return true;
        }
        return (strE.startsWith("omx.") || strE.startsWith("c2.")) ? false : true;
    }

    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static boolean G(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isSoftwareOnly();
    }

    public static boolean H(MediaCodecInfo mediaCodecInfo) {
        if (o0.f35608a >= 29) {
            return I(mediaCodecInfo);
        }
        String strE = com.google.common.base.a.e(mediaCodecInfo.getName());
        return (strE.startsWith("omx.google.") || strE.startsWith("c2.android.") || strE.startsWith("c2.google.")) ? false : true;
    }

    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static boolean I(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isVendor();
    }

    public static /* synthetic */ int J(com.google.android.exoplayer2.mediacodec.d dVar) {
        String str = dVar.f33553a;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        return (o0.f35608a >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
    }

    public static /* synthetic */ int K(com.google.android.exoplayer2.mediacodec.d dVar) {
        return dVar.f33553a.startsWith("OMX.google") ? 1 : 0;
    }

    public static /* synthetic */ int L(m1 m1Var, com.google.android.exoplayer2.mediacodec.d dVar) {
        try {
            return dVar.m(m1Var) ? 1 : 0;
        } catch (DecoderQueryException unused) {
            return -1;
        }
    }

    public static /* synthetic */ int M(f fVar, Object obj, Object obj2) {
        return fVar.a(obj2) - fVar.a(obj);
    }

    public static int N() throws DecoderQueryException {
        if (f33530c == -1) {
            int iMax = 0;
            com.google.android.exoplayer2.mediacodec.d dVarR = r(MimeTypes.VIDEO_H264, false, false);
            if (dVarR != null) {
                MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrG = dVarR.g();
                int length = codecProfileLevelArrG.length;
                int iMax2 = 0;
                while (iMax < length) {
                    iMax2 = Math.max(h(codecProfileLevelArrG[iMax].level), iMax2);
                    iMax++;
                }
                iMax = Math.max(iMax2, o0.f35608a >= 21 ? 345600 : 172800);
            }
            f33530c = iMax;
        }
        return f33530c;
    }

    public static int O(int i11) {
        int i12 = 17;
        if (i11 != 17) {
            i12 = 20;
            if (i11 != 20) {
                i12 = 23;
                if (i11 != 23) {
                    i12 = 29;
                    if (i11 != 29) {
                        i12 = 39;
                        if (i11 != 39) {
                            i12 = 42;
                            if (i11 != 42) {
                                switch (i11) {
                                    case 1:
                                        return 1;
                                    case 2:
                                        return 2;
                                    case 3:
                                        return 3;
                                    case 4:
                                        return 4;
                                    case 5:
                                        return 5;
                                    case 6:
                                        return 6;
                                    default:
                                        return -1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return i12;
    }

    public static <T> void P(List<T> list, final f<T> fVar) {
        Collections.sort(list, new Comparator() { // from class: fh.n
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return MediaCodecUtil.M(fVar, obj, obj2);
            }
        });
    }

    public static int Q(int i11) {
        if (i11 == 10) {
            return 1;
        }
        if (i11 == 11) {
            return 2;
        }
        if (i11 == 20) {
            return 4;
        }
        if (i11 == 21) {
            return 8;
        }
        if (i11 == 30) {
            return 16;
        }
        if (i11 == 31) {
            return 32;
        }
        if (i11 == 40) {
            return 64;
        }
        if (i11 == 41) {
            return 128;
        }
        if (i11 == 50) {
            return 256;
        }
        if (i11 == 51) {
            return 512;
        }
        switch (i11) {
            case 60:
                return 2048;
            case 61:
                return 4096;
            case 62:
                return 8192;
            default:
                return -1;
        }
    }

    public static int R(int i11) {
        if (i11 == 0) {
            return 1;
        }
        if (i11 == 1) {
            return 2;
        }
        if (i11 != 2) {
            return i11 != 3 ? -1 : 8;
        }
        return 4;
    }

    public static void e(String str, List<com.google.android.exoplayer2.mediacodec.d> list) {
        if (MimeTypes.AUDIO_RAW.equals(str)) {
            if (o0.f35608a < 26 && o0.f35609b.equals("R9") && list.size() == 1 && list.get(0).f33553a.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                list.add(com.google.android.exoplayer2.mediacodec.d.C("OMX.google.raw.decoder", MimeTypes.AUDIO_RAW, MimeTypes.AUDIO_RAW, null, false, true, false, false, false));
            }
            P(list, new f() { // from class: fh.k
                @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.f
                public final int a(Object obj) {
                    return MediaCodecUtil.J((com.google.android.exoplayer2.mediacodec.d) obj);
                }
            });
        }
        int i11 = o0.f35608a;
        if (i11 < 21 && list.size() > 1) {
            String str2 = list.get(0).f33553a;
            if ("OMX.SEC.mp3.dec".equals(str2) || "OMX.SEC.MP3.Decoder".equals(str2) || "OMX.brcm.audio.mp3.decoder".equals(str2)) {
                P(list, new f() { // from class: fh.l
                    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.f
                    public final int a(Object obj) {
                        return MediaCodecUtil.K((com.google.android.exoplayer2.mediacodec.d) obj);
                    }
                });
            }
        }
        if (i11 >= 32 || list.size() <= 1 || !"OMX.qti.audio.decoder.flac".equals(list.get(0).f33553a)) {
            return;
        }
        list.add(list.remove(0));
    }

    public static int f(int i11) {
        switch (i11) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case 8:
                return 256;
            case 9:
                return 512;
            case 10:
                return 1024;
            case 11:
                return 2048;
            case 12:
                return 4096;
            case 13:
                return 8192;
            case 14:
                return 16384;
            case 15:
                return 32768;
            case 16:
                return 65536;
            case 17:
                return 131072;
            case 18:
                return 262144;
            case 19:
                return 524288;
            case 20:
                return 1048576;
            case 21:
                return 2097152;
            case 22:
                return 4194304;
            case 23:
                return 8388608;
            default:
                return -1;
        }
    }

    public static int g(int i11) {
        switch (i11) {
            case 10:
                return 1;
            case 11:
                return 4;
            case 12:
                return 8;
            case 13:
                return 16;
            default:
                switch (i11) {
                    case 20:
                        return 32;
                    case 21:
                        return 64;
                    case 22:
                        return 128;
                    default:
                        switch (i11) {
                            case 30:
                                return 256;
                            case VungleException.WEB_CRASH /* 31 */:
                                return 512;
                            case 32:
                                return 1024;
                            default:
                                switch (i11) {
                                    case 40:
                                        return 2048;
                                    case 41:
                                        return 4096;
                                    case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                                        return 8192;
                                    default:
                                        switch (i11) {
                                            case 50:
                                                return 16384;
                                            case 51:
                                                return 32768;
                                            case 52:
                                                return 65536;
                                            default:
                                                return -1;
                                        }
                                }
                        }
                }
        }
    }

    public static int h(int i11) {
        if (i11 == 1 || i11 == 2) {
            return 25344;
        }
        switch (i11) {
            case 8:
            case 16:
            case 32:
                return 101376;
            case 64:
                return 202752;
            case 128:
            case 256:
                return 414720;
            case 512:
                return 921600;
            case 1024:
                return 1310720;
            case 2048:
            case 4096:
                return 2097152;
            case 8192:
                return 2228224;
            case 16384:
                return 5652480;
            case 32768:
            case 65536:
                return 9437184;
            case 131072:
            case 262144:
            case 524288:
                return 35651584;
            default:
                return -1;
        }
    }

    public static int i(int i11) {
        if (i11 == 66) {
            return 1;
        }
        if (i11 == 77) {
            return 2;
        }
        if (i11 == 88) {
            return 4;
        }
        if (i11 == 100) {
            return 8;
        }
        if (i11 == 110) {
            return 16;
        }
        if (i11 != 122) {
            return i11 != 244 ? -1 : 64;
        }
        return 32;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Nullable
    public static Integer j(@Nullable String str) {
        if (str == null) {
            return null;
        }
        byte b11 = -1;
        switch (str.hashCode()) {
            case 1537:
                if (str.equals("01")) {
                    b11 = 0;
                }
                break;
            case 1538:
                if (str.equals("02")) {
                    b11 = 1;
                }
                break;
            case 1539:
                if (str.equals("03")) {
                    b11 = 2;
                }
                break;
            case 1540:
                if (str.equals("04")) {
                    b11 = 3;
                }
                break;
            case 1541:
                if (str.equals("05")) {
                    b11 = 4;
                }
                break;
            case 1542:
                if (str.equals("06")) {
                    b11 = 5;
                }
                break;
            case 1543:
                if (str.equals("07")) {
                    b11 = 6;
                }
                break;
            case 1544:
                if (str.equals("08")) {
                    b11 = 7;
                }
                break;
            case 1545:
                if (str.equals("09")) {
                    b11 = 8;
                }
                break;
            case 1567:
                if (str.equals(PrepareException.ERROR_MINI_APPID)) {
                    b11 = 9;
                }
                break;
            case 1568:
                if (str.equals(PrepareException.ERROR_DOWNLOAD_PACKAGE_URL_EMPTY)) {
                    b11 = 10;
                }
                break;
            case 1569:
                if (str.equals(PrepareException.ERROR_LOCAL_DATA_FILE_SCAN)) {
                    b11 = Ascii.VT;
                }
                break;
            case 1570:
                if (str.equals(PrepareException.ERROR_WARMUP_DOWNLOAD_EXCEPTION)) {
                    b11 = Ascii.FF;
                }
                break;
        }
        switch (b11) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case 8:
                return 256;
            case 9:
                return 512;
            case 10:
                return 1024;
            case 11:
                return 2048;
            case 12:
                return 4096;
            default:
                return null;
        }
    }

    @Nullable
    public static Integer k(@Nullable String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
            case "00":
                return 1;
            case "01":
                return 2;
            case "02":
                return 4;
            case "03":
                return 8;
            case "04":
                return 16;
            case "05":
                return 32;
            case "06":
                return 64;
            case "07":
                return 128;
            case "08":
                return 256;
            case "09":
                return 512;
            default:
                return null;
        }
    }

    @Nullable
    public static Pair<Integer, Integer> l(String str, String[] strArr) {
        int iO;
        if (strArr.length != 3) {
            s.i("MediaCodecUtil", "Ignoring malformed MP4A codec string: " + str);
            return null;
        }
        try {
            if (MimeTypes.AUDIO_AAC.equals(w.h(Integer.parseInt(strArr[1], 16))) && (iO = O(Integer.parseInt(strArr[2]))) != -1) {
                return new Pair<>(Integer.valueOf(iO), 0);
            }
        } catch (NumberFormatException unused) {
            s.i("MediaCodecUtil", "Ignoring malformed MP4A codec string: " + str);
        }
        return null;
    }

    @Nullable
    public static String m(m1 m1Var) {
        Pair<Integer, Integer> pairQ;
        if (MimeTypes.AUDIO_E_AC3_JOC.equals(m1Var.f33445m)) {
            return MimeTypes.AUDIO_E_AC3;
        }
        if (!"video/dolby-vision".equals(m1Var.f33445m) || (pairQ = q(m1Var)) == null) {
            return null;
        }
        int iIntValue = ((Integer) pairQ.first).intValue();
        if (iIntValue == 16 || iIntValue == 256) {
            return MimeTypes.VIDEO_H265;
        }
        if (iIntValue == 512) {
            return MimeTypes.VIDEO_H264;
        }
        return null;
    }

    @Nullable
    public static Pair<Integer, Integer> n(String str, String[] strArr, @Nullable com.google.android.exoplayer2.video.c cVar) {
        int i11;
        if (strArr.length < 4) {
            s.i("MediaCodecUtil", "Ignoring malformed AV1 codec string: " + str);
            return null;
        }
        int i12 = 1;
        try {
            int i13 = Integer.parseInt(strArr[1]);
            int i14 = Integer.parseInt(strArr[2].substring(0, 2));
            int i15 = Integer.parseInt(strArr[3]);
            if (i13 != 0) {
                s.i("MediaCodecUtil", "Unknown AV1 profile: " + i13);
                return null;
            }
            if (i15 != 8 && i15 != 10) {
                s.i("MediaCodecUtil", "Unknown AV1 bit depth: " + i15);
                return null;
            }
            if (i15 != 8) {
                i12 = (cVar == null || !(cVar.f35720d != null || (i11 = cVar.f35719c) == 7 || i11 == 6)) ? 2 : 4096;
            }
            int iF = f(i14);
            if (iF != -1) {
                return new Pair<>(Integer.valueOf(i12), Integer.valueOf(iF));
            }
            s.i("MediaCodecUtil", "Unknown AV1 level: " + i14);
            return null;
        } catch (NumberFormatException unused) {
            s.i("MediaCodecUtil", "Ignoring malformed AV1 codec string: " + str);
            return null;
        }
    }

    @Nullable
    public static Pair<Integer, Integer> o(String str, String[] strArr) {
        int i11;
        int i12;
        if (strArr.length < 2) {
            s.i("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                i12 = Integer.parseInt(strArr[1].substring(0, 2), 16);
                i11 = Integer.parseInt(strArr[1].substring(4), 16);
            } else {
                if (strArr.length < 3) {
                    s.i("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
                    return null;
                }
                int i13 = Integer.parseInt(strArr[1]);
                i11 = Integer.parseInt(strArr[2]);
                i12 = i13;
            }
            int i14 = i(i12);
            if (i14 == -1) {
                s.i("MediaCodecUtil", "Unknown AVC profile: " + i12);
                return null;
            }
            int iG = g(i11);
            if (iG != -1) {
                return new Pair<>(Integer.valueOf(i14), Integer.valueOf(iG));
            }
            s.i("MediaCodecUtil", "Unknown AVC level: " + i11);
            return null;
        } catch (NumberFormatException unused) {
            s.i("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
    }

    @Nullable
    public static String p(MediaCodecInfo mediaCodecInfo, String str, String str2) {
        for (String str3 : mediaCodecInfo.getSupportedTypes()) {
            if (str3.equalsIgnoreCase(str2)) {
                return str3;
            }
        }
        if (str2.equals("video/dolby-vision")) {
            if ("OMX.MS.HEVCDV.Decoder".equals(str)) {
                return "video/hevcdv";
            }
            if ("OMX.RTK.video.decoder".equals(str) || "OMX.realtek.video.decoder.tunneled".equals(str)) {
                return "video/dv_hevc";
            }
            return null;
        }
        if (str2.equals(MimeTypes.AUDIO_ALAC) && "OMX.lge.alac.decoder".equals(str)) {
            return "audio/x-lg-alac";
        }
        if (str2.equals(MimeTypes.AUDIO_FLAC) && "OMX.lge.flac.decoder".equals(str)) {
            return "audio/x-lg-flac";
        }
        if (str2.equals(MimeTypes.AUDIO_AC3) && "OMX.lge.ac3.decoder".equals(str)) {
            return "audio/lg-ac3";
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:11:0x002b  */
    @Nullable
    public static Pair<Integer, Integer> q(m1 m1Var) {
        String str = m1Var.f33442j;
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split("\\.");
        if ("video/dolby-vision".equals(m1Var.f33445m)) {
            return w(m1Var.f33442j, strArrSplit);
        }
        byte b11 = 0;
        String str2 = strArrSplit[0];
        str2.hashCode();
        switch (str2.hashCode()) {
            case 3004662:
                if (!str2.equals("av01")) {
                    b11 = -1;
                }
                break;
            case 3006243:
                if (!str2.equals("avc1")) {
                    b11 = -1;
                } else {
                    b11 = 1;
                }
                break;
            case 3006244:
                if (!str2.equals("avc2")) {
                    b11 = -1;
                } else {
                    b11 = 2;
                }
                break;
            case 3199032:
                if (!str2.equals("hev1")) {
                    b11 = -1;
                } else {
                    b11 = 3;
                }
                break;
            case 3214780:
                if (!str2.equals("hvc1")) {
                    b11 = -1;
                } else {
                    b11 = 4;
                }
                break;
            case 3356560:
                if (!str2.equals("mp4a")) {
                    b11 = -1;
                } else {
                    b11 = 5;
                }
                break;
            case 3624515:
                if (!str2.equals("vp09")) {
                    b11 = -1;
                } else {
                    b11 = 6;
                }
                break;
            default:
                b11 = -1;
                break;
        }
        switch (b11) {
            case 0:
                return n(m1Var.f33442j, strArrSplit, m1Var.f33457y);
            case 1:
            case 2:
                return o(m1Var.f33442j, strArrSplit);
            case 3:
            case 4:
                return x(m1Var.f33442j, strArrSplit);
            case 5:
                return l(m1Var.f33442j, strArrSplit);
            case 6:
                return y(m1Var.f33442j, strArrSplit);
            default:
                return null;
        }
    }

    @Nullable
    public static com.google.android.exoplayer2.mediacodec.d r(String str, boolean z11, boolean z12) throws DecoderQueryException {
        List<com.google.android.exoplayer2.mediacodec.d> listS = s(str, z11, z12);
        if (listS.isEmpty()) {
            return null;
        }
        return listS.get(0);
    }

    public static synchronized List<com.google.android.exoplayer2.mediacodec.d> s(String str, boolean z11, boolean z12) throws DecoderQueryException {
        try {
            b bVar = new b(str, z11, z12);
            HashMap<b, List<com.google.android.exoplayer2.mediacodec.d>> map = f33529b;
            List<com.google.android.exoplayer2.mediacodec.d> list = map.get(bVar);
            if (list != null) {
                return list;
            }
            int i11 = o0.f35608a;
            ArrayList<com.google.android.exoplayer2.mediacodec.d> arrayListT = t(bVar, i11 >= 21 ? new e(z11, z12) : new d());
            if (z11 && arrayListT.isEmpty() && 21 <= i11 && i11 <= 23) {
                arrayListT = t(bVar, new d());
                if (!arrayListT.isEmpty()) {
                    s.i("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + arrayListT.get(0).f33553a);
                }
            }
            e(str, arrayListT);
            ImmutableList immutableListCopyOf = ImmutableList.copyOf((Collection) arrayListT);
            map.put(bVar, immutableListCopyOf);
            return immutableListCopyOf;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x008e  */
    /* JADX WARN: Code duplicated, block: B:58:0x0105 A[Catch: Exception -> 0x012e, TRY_ENTER, TryCatch #1 {Exception -> 0x012e, blocks: (B:3:0x0008, B:5:0x001b, B:61:0x0124, B:8:0x002d, B:11:0x0038, B:55:0x00fd, B:58:0x0105, B:60:0x010b, B:64:0x0130, B:65:0x0153), top: B:71:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0025  */
    /* JADX WARN: Code duplicated, block: B:83:0x0130 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    public static ArrayList<com.google.android.exoplayer2.mediacodec.d> t(b bVar, c cVar) throws DecoderQueryException {
        String strP;
        String str;
        int i11;
        boolean z11;
        int i12;
        b bVar2 = bVar;
        try {
            ArrayList<com.google.android.exoplayer2.mediacodec.d> arrayList = new ArrayList<>();
            String str2 = bVar2.f33531a;
            int codecCount = cVar.getCodecCount();
            boolean zSecureDecodersExplicit = cVar.secureDecodersExplicit();
            int i13 = 0;
            while (i13 < codecCount) {
                MediaCodecInfo codecInfoAt = cVar.getCodecInfoAt(i13);
                if (A(codecInfoAt)) {
                    i11 = i13;
                    z11 = zSecureDecodersExplicit;
                    i12 = codecCount;
                } else {
                    String name = codecInfoAt.getName();
                    if (C(codecInfoAt, name, zSecureDecodersExplicit, str2) && (strP = p(codecInfoAt, name, str2)) != null) {
                        try {
                            MediaCodecInfo.CodecCapabilities capabilitiesForType = codecInfoAt.getCapabilitiesForType(strP);
                            boolean zA = cVar.a("tunneled-playback", strP, capabilitiesForType);
                            boolean zB = cVar.b("tunneled-playback", strP, capabilitiesForType);
                            boolean z12 = bVar2.f33533c;
                            if ((z12 || !zB) && (!z12 || zA)) {
                                boolean zA2 = cVar.a("secure-playback", strP, capabilitiesForType);
                                boolean zB2 = cVar.b("secure-playback", strP, capabilitiesForType);
                                boolean z13 = bVar2.f33532b;
                                if ((z13 || !zB2) && (!z13 || zA2)) {
                                    boolean zD = D(codecInfoAt, str2);
                                    boolean zF = F(codecInfoAt, str2);
                                    boolean zH = H(codecInfoAt);
                                    if (zSecureDecodersExplicit && bVar2.f33532b == zA2) {
                                        i11 = i13;
                                        z11 = zSecureDecodersExplicit;
                                        i12 = codecCount;
                                        arrayList.add(com.google.android.exoplayer2.mediacodec.d.C(name, str2, strP, capabilitiesForType, zD, zF, zH, false, false));
                                    } else {
                                        if (!zSecureDecodersExplicit) {
                                            try {
                                                if (!bVar2.f33532b) {
                                                    i11 = i13;
                                                    z11 = zSecureDecodersExplicit;
                                                    i12 = codecCount;
                                                    try {
                                                        arrayList.add(com.google.android.exoplayer2.mediacodec.d.C(name, str2, strP, capabilitiesForType, zD, zF, zH, false, false));
                                                    } catch (Exception e11) {
                                                        e = e11;
                                                        str = name;
                                                        if (o0.f35608a <= 23) {
                                                        }
                                                        s.c("MediaCodecUtil", "Failed to query codec " + str + " (" + strP + ")");
                                                        throw e;
                                                    }
                                                }
                                            } catch (Exception e12) {
                                                e = e12;
                                                i11 = i13;
                                                z11 = zSecureDecodersExplicit;
                                                i12 = codecCount;
                                                str = name;
                                                if (o0.f35608a <= 23 || arrayList.isEmpty()) {
                                                    s.c("MediaCodecUtil", "Failed to query codec " + str + " (" + strP + ")");
                                                    throw e;
                                                }
                                                s.c("MediaCodecUtil", "Skipping codec " + str + " (failed to query capabilities)");
                                                i13 = i11 + 1;
                                                bVar2 = bVar;
                                                codecCount = i12;
                                                zSecureDecodersExplicit = z11;
                                            }
                                        }
                                        strP = strP;
                                        i11 = i13;
                                        z11 = zSecureDecodersExplicit;
                                        i12 = codecCount;
                                        if (!z11 && zA2) {
                                            StringBuilder sb2 = new StringBuilder();
                                            try {
                                                sb2.append(name);
                                                sb2.append(".secure");
                                                str = name;
                                                try {
                                                    arrayList.add(com.google.android.exoplayer2.mediacodec.d.C(sb2.toString(), str2, strP, capabilitiesForType, zD, zF, zH, false, true));
                                                    return arrayList;
                                                } catch (Exception e13) {
                                                    e = e13;
                                                    if (o0.f35608a <= 23) {
                                                    }
                                                    s.c("MediaCodecUtil", "Failed to query codec " + str + " (" + strP + ")");
                                                    throw e;
                                                }
                                            } catch (Exception e14) {
                                                e = e14;
                                                str = name;
                                            }
                                        }
                                    }
                                } else {
                                    i11 = i13;
                                    z11 = zSecureDecodersExplicit;
                                    i12 = codecCount;
                                }
                            } else {
                                i11 = i13;
                                z11 = zSecureDecodersExplicit;
                                i12 = codecCount;
                            }
                        } catch (Exception e15) {
                            e = e15;
                            strP = strP;
                            str = name;
                            i11 = i13;
                            z11 = zSecureDecodersExplicit;
                            i12 = codecCount;
                        }
                    } else {
                        i11 = i13;
                        z11 = zSecureDecodersExplicit;
                        i12 = codecCount;
                    }
                }
                i13 = i11 + 1;
                bVar2 = bVar;
                codecCount = i12;
                zSecureDecodersExplicit = z11;
            }
            return arrayList;
        } catch (Exception e16) {
            throw new DecoderQueryException(e16);
        }
    }

    @CheckResult
    public static List<com.google.android.exoplayer2.mediacodec.d> u(List<com.google.android.exoplayer2.mediacodec.d> list, final m1 m1Var) {
        ArrayList arrayList = new ArrayList(list);
        P(arrayList, new f() { // from class: fh.m
            @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.f
            public final int a(Object obj) {
                return MediaCodecUtil.L(m1Var, (com.google.android.exoplayer2.mediacodec.d) obj);
            }
        });
        return arrayList;
    }

    @Nullable
    public static com.google.android.exoplayer2.mediacodec.d v() throws DecoderQueryException {
        return r(MimeTypes.AUDIO_RAW, false, false);
    }

    @Nullable
    public static Pair<Integer, Integer> w(String str, String[] strArr) {
        if (strArr.length < 3) {
            s.i("MediaCodecUtil", "Ignoring malformed Dolby Vision codec string: " + str);
            return null;
        }
        Matcher matcher = f33528a.matcher(strArr[1]);
        if (!matcher.matches()) {
            s.i("MediaCodecUtil", "Ignoring malformed Dolby Vision codec string: " + str);
            return null;
        }
        String strGroup = matcher.group(1);
        Integer numK = k(strGroup);
        if (numK == null) {
            s.i("MediaCodecUtil", "Unknown Dolby Vision profile string: " + strGroup);
            return null;
        }
        String str2 = strArr[2];
        Integer numJ = j(str2);
        if (numJ != null) {
            return new Pair<>(numK, numJ);
        }
        s.i("MediaCodecUtil", "Unknown Dolby Vision level string: " + str2);
        return null;
    }

    @Nullable
    public static Pair<Integer, Integer> x(String str, String[] strArr) {
        if (strArr.length < 4) {
            s.i("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        int i11 = 1;
        Matcher matcher = f33528a.matcher(strArr[1]);
        if (!matcher.matches()) {
            s.i("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        String strGroup = matcher.group(1);
        if (!"1".equals(strGroup)) {
            if (!"2".equals(strGroup)) {
                s.i("MediaCodecUtil", "Unknown HEVC profile string: " + strGroup);
                return null;
            }
            i11 = 2;
        }
        String str2 = strArr[3];
        Integer numZ = z(str2);
        if (numZ != null) {
            return new Pair<>(Integer.valueOf(i11), numZ);
        }
        s.i("MediaCodecUtil", "Unknown HEVC level string: " + str2);
        return null;
    }

    @Nullable
    public static Pair<Integer, Integer> y(String str, String[] strArr) {
        if (strArr.length < 3) {
            s.i("MediaCodecUtil", "Ignoring malformed VP9 codec string: " + str);
            return null;
        }
        try {
            int i11 = Integer.parseInt(strArr[1]);
            int i12 = Integer.parseInt(strArr[2]);
            int iR = R(i11);
            if (iR == -1) {
                s.i("MediaCodecUtil", "Unknown VP9 profile: " + i11);
                return null;
            }
            int iQ = Q(i12);
            if (iQ != -1) {
                return new Pair<>(Integer.valueOf(iR), Integer.valueOf(iQ));
            }
            s.i("MediaCodecUtil", "Unknown VP9 level: " + i12);
            return null;
        } catch (NumberFormatException unused) {
            s.i("MediaCodecUtil", "Ignoring malformed VP9 codec string: " + str);
            return null;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Nullable
    public static Integer z(@Nullable String str) {
        if (str == null) {
            return null;
        }
        byte b11 = -1;
        switch (str.hashCode()) {
            case 70821:
                if (str.equals("H30")) {
                    b11 = 0;
                }
                break;
            case 70914:
                if (str.equals("H60")) {
                    b11 = 1;
                }
                break;
            case 70917:
                if (str.equals("H63")) {
                    b11 = 2;
                }
                break;
            case 71007:
                if (str.equals("H90")) {
                    b11 = 3;
                }
                break;
            case 71010:
                if (str.equals("H93")) {
                    b11 = 4;
                }
                break;
            case 74665:
                if (str.equals("L30")) {
                    b11 = 5;
                }
                break;
            case 74758:
                if (str.equals("L60")) {
                    b11 = 6;
                }
                break;
            case 74761:
                if (str.equals("L63")) {
                    b11 = 7;
                }
                break;
            case 74851:
                if (str.equals("L90")) {
                    b11 = 8;
                }
                break;
            case 74854:
                if (str.equals("L93")) {
                    b11 = 9;
                }
                break;
            case 2193639:
                if (str.equals("H120")) {
                    b11 = 10;
                }
                break;
            case 2193642:
                if (str.equals("H123")) {
                    b11 = Ascii.VT;
                }
                break;
            case 2193732:
                if (str.equals("H150")) {
                    b11 = Ascii.FF;
                }
                break;
            case 2193735:
                if (str.equals("H153")) {
                    b11 = Ascii.CR;
                }
                break;
            case 2193738:
                if (str.equals("H156")) {
                    b11 = Ascii.SO;
                }
                break;
            case 2193825:
                if (str.equals("H180")) {
                    b11 = Ascii.SI;
                }
                break;
            case 2193828:
                if (str.equals("H183")) {
                    b11 = Ascii.DLE;
                }
                break;
            case 2193831:
                if (str.equals("H186")) {
                    b11 = 17;
                }
                break;
            case 2312803:
                if (str.equals("L120")) {
                    b11 = Ascii.DC2;
                }
                break;
            case 2312806:
                if (str.equals("L123")) {
                    b11 = 19;
                }
                break;
            case 2312896:
                if (str.equals("L150")) {
                    b11 = Ascii.DC4;
                }
                break;
            case 2312899:
                if (str.equals("L153")) {
                    b11 = Ascii.NAK;
                }
                break;
            case 2312902:
                if (str.equals("L156")) {
                    b11 = Ascii.SYN;
                }
                break;
            case 2312989:
                if (str.equals("L180")) {
                    b11 = Ascii.ETB;
                }
                break;
            case 2312992:
                if (str.equals("L183")) {
                    b11 = Ascii.CAN;
                }
                break;
            case 2312995:
                if (str.equals("L186")) {
                    b11 = Ascii.EM;
                }
                break;
        }
        switch (b11) {
            case 0:
                return 2;
            case 1:
                return 8;
            case 2:
                return 32;
            case 3:
                return 128;
            case 4:
                return 512;
            case 5:
                return 1;
            case 6:
                return 4;
            case 7:
                return 16;
            case 8:
                return 64;
            case 9:
                return 256;
            case 10:
                return 2048;
            case 11:
                return 8192;
            case 12:
                return 32768;
            case 13:
                return 131072;
            case 14:
                return 524288;
            case 15:
                return 2097152;
            case 16:
                return 8388608;
            case 17:
                return Integer.valueOf(ASTNode.PCTX_STORED);
            case 18:
                return 1024;
            case 19:
                return 4096;
            case 20:
                return 16384;
            case 21:
                return 65536;
            case 22:
                return 262144;
            case 23:
                return 1048576;
            case 24:
                return 4194304;
            case 25:
                return 16777216;
            default:
                return null;
        }
    }
}
