package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.transsion.gslb.Worker;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcb {
    public static final /* synthetic */ int zza = 0;
    private static final ArrayList zzb = new ArrayList();
    private static final Pattern zzc = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:41:0x008f  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static int zza(String str, @Nullable String str2) {
        byte b11;
        zzca zzcaVarZzc;
        switch (str.hashCode()) {
            case -2123537834:
                if (!str.equals(MimeTypes.AUDIO_E_AC3_JOC)) {
                    b11 = -1;
                } else {
                    b11 = 4;
                }
                break;
            case -1365340241:
                if (!str.equals(MimeTypes.AUDIO_DTS_EXPRESS)) {
                    b11 = -1;
                } else {
                    b11 = 8;
                }
                break;
            case -1095064472:
                if (!str.equals(MimeTypes.AUDIO_DTS)) {
                    b11 = -1;
                } else {
                    b11 = 6;
                }
                break;
            case -53558318:
                if (!str.equals(MimeTypes.AUDIO_AAC)) {
                    b11 = -1;
                } else {
                    b11 = 1;
                }
                break;
            case 187078296:
                if (!str.equals(MimeTypes.AUDIO_AC3)) {
                    b11 = -1;
                } else {
                    b11 = 2;
                }
                break;
            case 187078297:
                if (!str.equals("audio/ac4")) {
                    b11 = -1;
                } else {
                    b11 = 5;
                }
                break;
            case 550520934:
                if (!str.equals("audio/vnd.dts.uhd;profile=p2")) {
                    b11 = -1;
                } else {
                    b11 = 9;
                }
                break;
            case 1504578661:
                if (!str.equals(MimeTypes.AUDIO_E_AC3)) {
                    b11 = -1;
                } else {
                    b11 = 3;
                }
                break;
            case 1504831518:
                if (!str.equals(MimeTypes.AUDIO_MPEG)) {
                    b11 = -1;
                } else {
                    b11 = 0;
                }
                break;
            case 1504891608:
                if (!str.equals(MimeTypes.AUDIO_OPUS)) {
                    b11 = -1;
                } else {
                    b11 = Ascii.VT;
                }
                break;
            case 1505942594:
                if (!str.equals(MimeTypes.AUDIO_DTS_HD)) {
                    b11 = -1;
                } else {
                    b11 = 7;
                }
                break;
            case 1556697186:
                if (!str.equals(MimeTypes.AUDIO_TRUEHD)) {
                    b11 = -1;
                } else {
                    b11 = 10;
                }
                break;
            default:
                b11 = -1;
                break;
        }
        switch (b11) {
            case 0:
                return 9;
            case 1:
                if (str2 == null || (zzcaVarZzc = zzc(str2)) == null) {
                    return 0;
                }
                return zzcaVarZzc.zza();
            case 2:
                return 5;
            case 3:
                return 6;
            case 4:
                return 18;
            case 5:
                return 17;
            case 6:
                return 7;
            case 7:
            case 8:
                return 8;
            case 9:
                return 30;
            case 10:
                return 14;
            case 11:
                return 20;
            default:
                return 0;
        }
    }

    public static int zzb(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (zzg(str)) {
            return 1;
        }
        if (zzh(str)) {
            return 2;
        }
        if (MimeTypes.BASE_TYPE_TEXT.equals(zzi(str)) || "application/x-media3-cues".equals(str) || MimeTypes.APPLICATION_CEA608.equals(str) || MimeTypes.APPLICATION_CEA708.equals(str) || MimeTypes.APPLICATION_MP4CEA608.equals(str) || MimeTypes.APPLICATION_SUBRIP.equals(str) || MimeTypes.APPLICATION_TTML.equals(str) || MimeTypes.APPLICATION_TX3G.equals(str) || MimeTypes.APPLICATION_MP4VTT.equals(str) || MimeTypes.APPLICATION_RAWCC.equals(str) || MimeTypes.APPLICATION_VOBSUB.equals(str) || MimeTypes.APPLICATION_PGS.equals(str) || MimeTypes.APPLICATION_DVBSUBS.equals(str)) {
            return 3;
        }
        if ("image".equals(zzi(str)) || "application/x-image-uri".equals(str)) {
            return 4;
        }
        if (MimeTypes.APPLICATION_ID3.equals(str) || MimeTypes.APPLICATION_EMSG.equals(str) || MimeTypes.APPLICATION_SCTE35.equals(str)) {
            return 5;
        }
        if (MimeTypes.APPLICATION_CAMERA_MOTION.equals(str)) {
            return 6;
        }
        int size = zzb.size();
        for (int i11 = 0; i11 < size; i11++) {
            String str2 = ((zzbz) zzb.get(i11)).zza;
            if (str.equals(null)) {
                return 0;
            }
        }
        return -1;
    }

    @Nullable
    public static zzca zzc(String str) {
        Matcher matcher = zzc.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String strGroup = matcher.group(1);
        strGroup.getClass();
        String strGroup2 = matcher.group(2);
        try {
            return new zzca(Integer.parseInt(strGroup, 16), strGroup2 != null ? Integer.parseInt(strGroup2) : 0);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @Nullable
    public static String zzd(int i11) {
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:26:0x0051  */
    public static String zze(String str) {
        byte b11;
        if (str == null) {
            return null;
        }
        String strZza = zzfwk.zza(str);
        switch (strZza) {
            case "audio/x-flac":
                b11 = 0;
                break;
            case "application/x-mpegurl":
                b11 = 3;
                break;
            case "audio/x-wav":
                b11 = 2;
                break;
            case "audio/mpeg-l1":
                b11 = 4;
                break;
            case "audio/mpeg-l2":
                b11 = 5;
                break;
            case "audio/mp3":
                b11 = 1;
                break;
            default:
                b11 = -1;
                break;
        }
        if (b11 == 0) {
            return MimeTypes.AUDIO_FLAC;
        }
        if (b11 == 1) {
            return MimeTypes.AUDIO_MPEG;
        }
        if (b11 == 2) {
            return "audio/wav";
        }
        if (b11 == 3) {
            return MimeTypes.APPLICATION_M3U8;
        }
        if (b11 != 4) {
            return b11 != 5 ? strZza : MimeTypes.AUDIO_MPEG_L2;
        }
        return MimeTypes.AUDIO_MPEG_L1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:41:0x0080  */
    public static boolean zzf(@Nullable String str, @Nullable String str2) {
        zzca zzcaVarZzc;
        int iZza;
        if (str == null) {
            return false;
        }
        switch (str) {
            case "audio/mpeg":
            case "audio/mpeg-L1":
            case "audio/mpeg-L2":
            case "audio/raw":
            case "audio/g711-alaw":
            case "audio/g711-mlaw":
            case "audio/flac":
            case "audio/ac3":
            case "audio/eac3":
            case "audio/eac3-joc":
                return true;
            case "audio/mp4a-latm":
                return (str2 == null || (zzcaVarZzc = zzc(str2)) == null || (iZza = zzcaVarZzc.zza()) == 0 || iZza == 16) ? false : true;
            default:
                return false;
        }
    }

    public static boolean zzg(@Nullable String str) {
        return MimeTypes.BASE_TYPE_AUDIO.equals(zzi(str));
    }

    public static boolean zzh(@Nullable String str) {
        return "video".equals(zzi(str));
    }

    @Nullable
    private static String zzi(@Nullable String str) {
        int iIndexOf;
        if (str == null || (iIndexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, iIndexOf);
    }
}
