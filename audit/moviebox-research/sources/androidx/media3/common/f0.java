package androidx.media3.common;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.transsion.gslb.Worker;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<a> f9209a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f9210b = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f9211a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f9212b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f9213c;
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f9214a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f9215b;

        public b(int i11, int i12) {
            this.f9214a = i11;
            this.f9215b = i12;
        }

        public int a() {
            int i11 = this.f9215b;
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

    public static boolean a(@Nullable String str, @Nullable String str2) {
        b bVarI;
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
                return (str2 == null || (bVarI = i(str2)) == null || (iA = bVarI.a()) == 0 || iA == 16) ? false : true;
            default:
                return false;
        }
    }

    public static boolean b(@Nullable String str, String str2) {
        return d(str, str2) != null;
    }

    @Nullable
    public static String c(@Nullable String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : u0.q1(str)) {
            String strG = g(str2);
            if (strG != null && o(strG)) {
                return strG;
            }
        }
        return null;
    }

    @Nullable
    public static String d(@Nullable String str, @Nullable String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        String[] strArrQ1 = u0.q1(str);
        StringBuilder sb2 = new StringBuilder();
        for (String str3 : strArrQ1) {
            if (str2.equals(g(str3))) {
                if (sb2.length() > 0) {
                    sb2.append(",");
                }
                sb2.append(str3);
            }
        }
        if (sb2.length() > 0) {
            return sb2.toString();
        }
        return null;
    }

    @Nullable
    public static String e(String str) {
        int size = f9209a.size();
        for (int i11 = 0; i11 < size; i11++) {
            a aVar = f9209a.get(i11);
            if (str.startsWith(aVar.f9212b)) {
                return aVar.f9211a;
            }
        }
        return null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static int f(String str, @Nullable String str2) {
        b bVarI;
        str.hashCode();
        byte b11 = -1;
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals(MimeTypes.AUDIO_E_AC3_JOC)) {
                    b11 = 0;
                }
                break;
            case -1365340241:
                if (str.equals(MimeTypes.AUDIO_DTS_EXPRESS)) {
                    b11 = 1;
                }
                break;
            case -1095064472:
                if (str.equals(MimeTypes.AUDIO_DTS)) {
                    b11 = 2;
                }
                break;
            case -53558318:
                if (str.equals(MimeTypes.AUDIO_AAC)) {
                    b11 = 3;
                }
                break;
            case 187078296:
                if (str.equals(MimeTypes.AUDIO_AC3)) {
                    b11 = 4;
                }
                break;
            case 187078297:
                if (str.equals("audio/ac4")) {
                    b11 = 5;
                }
                break;
            case 550520934:
                if (str.equals("audio/vnd.dts.uhd;profile=p2")) {
                    b11 = 6;
                }
                break;
            case 1504578661:
                if (str.equals(MimeTypes.AUDIO_E_AC3)) {
                    b11 = 7;
                }
                break;
            case 1504831518:
                if (str.equals(MimeTypes.AUDIO_MPEG)) {
                    b11 = 8;
                }
                break;
            case 1504891608:
                if (str.equals(MimeTypes.AUDIO_OPUS)) {
                    b11 = 9;
                }
                break;
            case 1505942594:
                if (str.equals(MimeTypes.AUDIO_DTS_HD)) {
                    b11 = 10;
                }
                break;
            case 1556697186:
                if (str.equals(MimeTypes.AUDIO_TRUEHD)) {
                    b11 = Ascii.VT;
                }
                break;
        }
        switch (b11) {
            case 0:
                return 18;
            case 1:
                return 8;
            case 2:
                return 7;
            case 3:
                if (str2 == null || (bVarI = i(str2)) == null) {
                    return 0;
                }
                return bVarI.a();
            case 4:
                return 5;
            case 5:
                return 17;
            case 6:
                return 30;
            case 7:
                return 6;
            case 8:
                return 9;
            case 9:
                return 20;
            case 10:
                return 8;
            case 11:
                return 14;
            default:
                return 0;
        }
    }

    @Nullable
    public static String g(@Nullable String str) {
        b bVarI;
        String strH = null;
        if (str == null) {
            return null;
        }
        String strE = com.google.common.base.a.e(str.trim());
        if (strE.startsWith("avc1") || strE.startsWith("avc3")) {
            return MimeTypes.VIDEO_H264;
        }
        if (strE.startsWith("hev1") || strE.startsWith("hvc1")) {
            return MimeTypes.VIDEO_H265;
        }
        if (strE.startsWith("dvav") || strE.startsWith("dva1") || strE.startsWith("dvhe") || strE.startsWith("dvh1")) {
            return "video/dolby-vision";
        }
        if (strE.startsWith("av01")) {
            return "video/av01";
        }
        if (strE.startsWith("vp9") || strE.startsWith("vp09")) {
            return MimeTypes.VIDEO_VP9;
        }
        if (strE.startsWith("vp8") || strE.startsWith("vp08")) {
            return MimeTypes.VIDEO_VP8;
        }
        if (strE.startsWith("mp4a")) {
            if (strE.startsWith("mp4a.") && (bVarI = i(strE)) != null) {
                strH = h(bVarI.f9214a);
            }
            return strH == null ? MimeTypes.AUDIO_AAC : strH;
        }
        if (strE.startsWith("mha1")) {
            return "audio/mha1";
        }
        if (strE.startsWith("mhm1")) {
            return "audio/mhm1";
        }
        if (strE.startsWith("ac-3") || strE.startsWith("dac3")) {
            return MimeTypes.AUDIO_AC3;
        }
        if (strE.startsWith("ec-3") || strE.startsWith("dec3")) {
            return MimeTypes.AUDIO_E_AC3;
        }
        if (strE.startsWith("ec+3")) {
            return MimeTypes.AUDIO_E_AC3_JOC;
        }
        if (strE.startsWith("ac-4") || strE.startsWith("dac4")) {
            return "audio/ac4";
        }
        if (strE.startsWith("dtsc")) {
            return MimeTypes.AUDIO_DTS;
        }
        if (strE.startsWith("dtse")) {
            return MimeTypes.AUDIO_DTS_EXPRESS;
        }
        if (strE.startsWith("dtsh") || strE.startsWith("dtsl")) {
            return MimeTypes.AUDIO_DTS_HD;
        }
        if (strE.startsWith("dtsx")) {
            return "audio/vnd.dts.uhd;profile=p2";
        }
        if (strE.startsWith("opus")) {
            return MimeTypes.AUDIO_OPUS;
        }
        if (strE.startsWith("vorbis")) {
            return MimeTypes.AUDIO_VORBIS;
        }
        if (strE.startsWith("flac")) {
            return MimeTypes.AUDIO_FLAC;
        }
        if (strE.startsWith("stpp")) {
            return MimeTypes.APPLICATION_TTML;
        }
        if (strE.startsWith("wvtt")) {
            return MimeTypes.TEXT_VTT;
        }
        if (strE.contains("cea708")) {
            return MimeTypes.APPLICATION_CEA708;
        }
        return (strE.contains("eia608") || strE.contains("cea608")) ? MimeTypes.APPLICATION_CEA608 : e(strE);
    }

    @Nullable
    public static String h(int i11) {
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
        if (i11 == 221) {
            return MimeTypes.AUDIO_VORBIS;
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

    @Nullable
    public static b i(String str) {
        Matcher matcher = f9210b.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String str2 = (String) z3.a.e(matcher.group(1));
        String strGroup = matcher.group(2);
        try {
            return new b(Integer.parseInt(str2, 16), strGroup != null ? Integer.parseInt(strGroup) : 0);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @Nullable
    public static String j(@Nullable String str) {
        int iIndexOf;
        if (str == null || (iIndexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, iIndexOf);
    }

    public static int k(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (o(str)) {
            return 1;
        }
        if (s(str)) {
            return 2;
        }
        if (r(str)) {
            return 3;
        }
        if (p(str)) {
            return 4;
        }
        if (MimeTypes.APPLICATION_ID3.equals(str) || MimeTypes.APPLICATION_EMSG.equals(str) || MimeTypes.APPLICATION_SCTE35.equals(str)) {
            return 5;
        }
        if (MimeTypes.APPLICATION_CAMERA_MOTION.equals(str)) {
            return 6;
        }
        return l(str);
    }

    public static int l(String str) {
        int size = f9209a.size();
        for (int i11 = 0; i11 < size; i11++) {
            a aVar = f9209a.get(i11);
            if (str.equals(aVar.f9211a)) {
                return aVar.f9213c;
            }
        }
        return -1;
    }

    public static int m(String str) {
        return k(g(str));
    }

    @Nullable
    public static String n(@Nullable String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : u0.q1(str)) {
            String strG = g(str2);
            if (strG != null && s(strG)) {
                return strG;
            }
        }
        return null;
    }

    public static boolean o(@Nullable String str) {
        return MimeTypes.BASE_TYPE_AUDIO.equals(j(str));
    }

    public static boolean p(@Nullable String str) {
        return "image".equals(j(str)) || "application/x-image-uri".equals(str);
    }

    public static boolean q(@Nullable String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith(MimeTypes.VIDEO_WEBM) || str.startsWith(MimeTypes.AUDIO_WEBM) || str.startsWith(MimeTypes.APPLICATION_WEBM) || str.startsWith("video/x-matroska") || str.startsWith("audio/x-matroska") || str.startsWith("application/x-matroska");
    }

    public static boolean r(@Nullable String str) {
        return MimeTypes.BASE_TYPE_TEXT.equals(j(str)) || "application/x-media3-cues".equals(str) || MimeTypes.APPLICATION_CEA608.equals(str) || MimeTypes.APPLICATION_CEA708.equals(str) || MimeTypes.APPLICATION_MP4CEA608.equals(str) || MimeTypes.APPLICATION_SUBRIP.equals(str) || MimeTypes.APPLICATION_TTML.equals(str) || MimeTypes.APPLICATION_TX3G.equals(str) || MimeTypes.APPLICATION_MP4VTT.equals(str) || MimeTypes.APPLICATION_RAWCC.equals(str) || MimeTypes.APPLICATION_VOBSUB.equals(str) || MimeTypes.APPLICATION_PGS.equals(str) || MimeTypes.APPLICATION_DVBSUBS.equals(str);
    }

    public static boolean s(@Nullable String str) {
        return "video".equals(j(str));
    }

    public static String t(String str) {
        if (str == null) {
            return null;
        }
        String strE = com.google.common.base.a.e(str);
        strE.hashCode();
        switch (strE) {
            case "audio/x-flac":
                return MimeTypes.AUDIO_FLAC;
            case "application/x-mpegurl":
                return MimeTypes.APPLICATION_M3U8;
            case "audio/x-wav":
                return "audio/wav";
            case "audio/mpeg-l1":
                return MimeTypes.AUDIO_MPEG_L1;
            case "audio/mpeg-l2":
                return MimeTypes.AUDIO_MPEG_L2;
            case "audio/mp3":
                return MimeTypes.AUDIO_MPEG;
            default:
                return strE;
        }
    }
}
