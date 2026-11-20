package com.applovin.impl;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.transsion.gslb.Worker;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: com.applovin.impl.if, reason: invalid class name */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Cif {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ArrayList f19688a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f19689b = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");

    /* JADX INFO: renamed from: com.applovin.impl.if$a */
    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f19690a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f19691b;

        public a(int i11, int i12) {
            this.f19690a = i11;
            this.f19691b = i12;
        }

        public int a() {
            int i11 = this.f19691b;
            if (i11 == 2) {
                return 10;
            }
            if (i11 == 5) {
                return 11;
            }
            if (i11 == 29) {
                return 12;
            }
            if (i11 == 42) {
                return 16;
            }
            if (i11 != 22) {
                return i11 != 23 ? 0 : 15;
            }
            return 1073741824;
        }
    }

    public static String a(int i11) {
        if (i11 == 32) {
            return MimeTypes.VIDEO_MP4V;
        }
        if (i11 == 33) {
            return MimeTypes.VIDEO_H264;
        }
        if (i11 == 35) {
            return MimeTypes.VIDEO_H265;
        }
        if (i11 == 64) {
            return MimeTypes.AUDIO_AAC;
        }
        if (i11 == 163) {
            return MimeTypes.VIDEO_VC1;
        }
        if (i11 == 177) {
            return MimeTypes.VIDEO_VP9;
        }
        if (i11 == 165) {
            return MimeTypes.AUDIO_AC3;
        }
        if (i11 == 166) {
            return MimeTypes.AUDIO_E_AC3;
        }
        switch (i11) {
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
                return MimeTypes.VIDEO_MPEG2;
            case 102:
            case Worker.WHAT_SYNC_DATA /* 103 */:
            case 104:
                return MimeTypes.AUDIO_AAC;
            case 105:
            case 107:
                return MimeTypes.AUDIO_MPEG;
            case 106:
                return MimeTypes.VIDEO_MPEG;
            default:
                switch (i11) {
                    case 169:
                    case 172:
                        return MimeTypes.AUDIO_DTS;
                    case 170:
                    case 171:
                        return MimeTypes.AUDIO_DTS_HD;
                    case 173:
                        return MimeTypes.AUDIO_OPUS;
                    case 174:
                        return "audio/ac4";
                    default:
                        return null;
                }
        }
    }

    private static String a(String str) {
        ArrayList arrayList = f19688a;
        if (arrayList.size() <= 0) {
            return null;
        }
        d8.a(arrayList.get(0));
        throw null;
    }

    public static boolean a(String str, String str2) {
        a aVarC;
        int iA;
        if (str == null) {
            return false;
        }
        switch (str) {
            case "audio/eac3-joc":
            case "audio/mpeg-L1":
            case "audio/mpeg-L2":
            case "audio/ac3":
            case "audio/raw":
            case "audio/eac3":
            case "audio/flac":
            case "audio/mpeg":
            case "audio/g711-alaw":
            case "audio/g711-mlaw":
                return true;
            case "audio/mp4a-latm":
                return (str2 == null || (aVarC = c(str2)) == null || (iA = aVarC.a()) == 0 || iA == 16) ? false : true;
            default:
                return false;
        }
    }

    public static int b(String str, String str2) {
        a aVarC;
        str.hashCode();
        switch (str) {
            case "audio/eac3-joc":
                return 18;
            case "audio/vnd.dts":
                return 7;
            case "audio/mp4a-latm":
                if (str2 == null || (aVarC = c(str2)) == null) {
                    return 0;
                }
                return aVarC.a();
            case "audio/ac3":
                return 5;
            case "audio/ac4":
                return 17;
            case "audio/eac3":
                return 6;
            case "audio/mpeg":
                return 9;
            case "audio/vnd.dts.hd":
                return 8;
            case "audio/true-hd":
                return 14;
            default:
                return 0;
        }
    }

    public static String b(String str) {
        a aVarC;
        String strA = null;
        if (str == null) {
            return null;
        }
        String lowerCase = Ascii.toLowerCase(str.trim());
        if (lowerCase.startsWith("avc1") || lowerCase.startsWith("avc3")) {
            return MimeTypes.VIDEO_H264;
        }
        if (lowerCase.startsWith("hev1") || lowerCase.startsWith("hvc1")) {
            return MimeTypes.VIDEO_H265;
        }
        if (lowerCase.startsWith("dvav") || lowerCase.startsWith("dva1") || lowerCase.startsWith("dvhe") || lowerCase.startsWith("dvh1")) {
            return "video/dolby-vision";
        }
        if (lowerCase.startsWith("av01")) {
            return "video/av01";
        }
        if (lowerCase.startsWith("vp9") || lowerCase.startsWith("vp09")) {
            return MimeTypes.VIDEO_VP9;
        }
        if (lowerCase.startsWith("vp8") || lowerCase.startsWith("vp08")) {
            return MimeTypes.VIDEO_VP8;
        }
        if (lowerCase.startsWith("mp4a")) {
            if (lowerCase.startsWith("mp4a.") && (aVarC = c(lowerCase)) != null) {
                strA = a(aVarC.f19690a);
            }
            return strA == null ? MimeTypes.AUDIO_AAC : strA;
        }
        if (lowerCase.startsWith("mha1")) {
            return "audio/mha1";
        }
        if (lowerCase.startsWith("mhm1")) {
            return "audio/mhm1";
        }
        if (lowerCase.startsWith("ac-3") || lowerCase.startsWith("dac3")) {
            return MimeTypes.AUDIO_AC3;
        }
        if (lowerCase.startsWith("ec-3") || lowerCase.startsWith("dec3")) {
            return MimeTypes.AUDIO_E_AC3;
        }
        if (lowerCase.startsWith("ec+3")) {
            return MimeTypes.AUDIO_E_AC3_JOC;
        }
        if (lowerCase.startsWith("ac-4") || lowerCase.startsWith("dac4")) {
            return "audio/ac4";
        }
        if (lowerCase.startsWith("dtsc")) {
            return MimeTypes.AUDIO_DTS;
        }
        if (lowerCase.startsWith("dtse")) {
            return MimeTypes.AUDIO_DTS_EXPRESS;
        }
        if (lowerCase.startsWith("dtsh") || lowerCase.startsWith("dtsl")) {
            return MimeTypes.AUDIO_DTS_HD;
        }
        if (lowerCase.startsWith("dtsx")) {
            return "audio/vnd.dts.uhd;profile=p2";
        }
        if (lowerCase.startsWith("opus")) {
            return MimeTypes.AUDIO_OPUS;
        }
        if (lowerCase.startsWith("vorbis")) {
            return MimeTypes.AUDIO_VORBIS;
        }
        if (lowerCase.startsWith("flac")) {
            return MimeTypes.AUDIO_FLAC;
        }
        if (lowerCase.startsWith("stpp")) {
            return MimeTypes.APPLICATION_TTML;
        }
        if (lowerCase.startsWith("wvtt")) {
            return MimeTypes.TEXT_VTT;
        }
        if (lowerCase.contains("cea708")) {
            return MimeTypes.APPLICATION_CEA708;
        }
        return (lowerCase.contains("eia608") || lowerCase.contains("cea608")) ? MimeTypes.APPLICATION_CEA608 : a(lowerCase);
    }

    public static a c(String str) {
        Matcher matcher = f19689b.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String str2 = (String) b1.a((Object) matcher.group(1));
        String strGroup = matcher.group(2);
        try {
            return new a(Integer.parseInt(str2, 16), strGroup != null ? Integer.parseInt(strGroup) : 0);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static String d(String str) {
        int iIndexOf;
        if (str == null || (iIndexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, iIndexOf);
    }

    public static int e(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (g(str)) {
            return 1;
        }
        if (i(str)) {
            return 2;
        }
        if (h(str)) {
            return 3;
        }
        if (MimeTypes.APPLICATION_ID3.equals(str) || MimeTypes.APPLICATION_EMSG.equals(str) || MimeTypes.APPLICATION_SCTE35.equals(str)) {
            return 5;
        }
        if (MimeTypes.APPLICATION_CAMERA_MOTION.equals(str)) {
            return 6;
        }
        return f(str);
    }

    private static int f(String str) {
        ArrayList arrayList = f19688a;
        if (arrayList.size() <= 0) {
            return -1;
        }
        d8.a(arrayList.get(0));
        throw null;
    }

    public static boolean g(String str) {
        return MimeTypes.BASE_TYPE_AUDIO.equals(d(str));
    }

    public static boolean h(String str) {
        return MimeTypes.BASE_TYPE_TEXT.equals(d(str)) || MimeTypes.APPLICATION_CEA608.equals(str) || MimeTypes.APPLICATION_CEA708.equals(str) || MimeTypes.APPLICATION_MP4CEA608.equals(str) || MimeTypes.APPLICATION_SUBRIP.equals(str) || MimeTypes.APPLICATION_TTML.equals(str) || MimeTypes.APPLICATION_TX3G.equals(str) || MimeTypes.APPLICATION_MP4VTT.equals(str) || MimeTypes.APPLICATION_RAWCC.equals(str) || MimeTypes.APPLICATION_VOBSUB.equals(str) || MimeTypes.APPLICATION_PGS.equals(str) || MimeTypes.APPLICATION_DVBSUBS.equals(str);
    }

    public static boolean i(String str) {
        return "video".equals(d(str));
    }

    public static String j(String str) {
        str.hashCode();
        switch (str) {
            case "audio/x-flac":
                return MimeTypes.AUDIO_FLAC;
            case "audio/x-wav":
                return "audio/wav";
            case "audio/mp3":
                return MimeTypes.AUDIO_MPEG;
            default:
                return str;
        }
    }
}
