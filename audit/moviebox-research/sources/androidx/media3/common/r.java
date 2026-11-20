package androidx.media3.common;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.vungle.warren.error.VungleException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x003a  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static int a(@Nullable String str) {
        byte b11;
        if (str == null) {
            return -1;
        }
        String strT = f0.t(str);
        strT.hashCode();
        switch (strT.hashCode()) {
            case -2123537834:
                if (!strT.equals(MimeTypes.AUDIO_E_AC3_JOC)) {
                    b11 = -1;
                } else {
                    b11 = 0;
                }
                break;
            case -1662384011:
                if (!strT.equals("video/mp2p")) {
                    b11 = -1;
                } else {
                    b11 = 1;
                }
                break;
            case -1662384007:
                if (!strT.equals("video/mp2t")) {
                    b11 = -1;
                } else {
                    b11 = 2;
                }
                break;
            case -1662095187:
                if (!strT.equals(MimeTypes.VIDEO_WEBM)) {
                    b11 = -1;
                } else {
                    b11 = 3;
                }
                break;
            case -1606874997:
                if (!strT.equals(MimeTypes.AUDIO_AMR_WB)) {
                    b11 = -1;
                } else {
                    b11 = 4;
                }
                break;
            case -1487464690:
                if (!strT.equals("image/heif")) {
                    b11 = -1;
                } else {
                    b11 = 5;
                }
                break;
            case -1487394660:
                if (!strT.equals("image/jpeg")) {
                    b11 = -1;
                } else {
                    b11 = 6;
                }
                break;
            case -1487018032:
                if (!strT.equals("image/webp")) {
                    b11 = -1;
                } else {
                    b11 = 7;
                }
                break;
            case -1248337486:
                if (!strT.equals(MimeTypes.APPLICATION_MP4)) {
                    b11 = -1;
                } else {
                    b11 = 8;
                }
                break;
            case -1079884372:
                if (!strT.equals("video/x-msvideo")) {
                    b11 = -1;
                } else {
                    b11 = 9;
                }
                break;
            case -1004728940:
                if (!strT.equals(MimeTypes.TEXT_VTT)) {
                    b11 = -1;
                } else {
                    b11 = 10;
                }
                break;
            case -879272239:
                if (!strT.equals("image/bmp")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.VT;
                }
                break;
            case -879258763:
                if (!strT.equals("image/png")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.FF;
                }
                break;
            case -387023398:
                if (!strT.equals("audio/x-matroska")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.CR;
                }
                break;
            case -43467528:
                if (!strT.equals(MimeTypes.APPLICATION_WEBM)) {
                    b11 = -1;
                } else {
                    b11 = Ascii.SO;
                }
                break;
            case 13915911:
                if (!strT.equals("video/x-flv")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.SI;
                }
                break;
            case 187078296:
                if (!strT.equals(MimeTypes.AUDIO_AC3)) {
                    b11 = -1;
                } else {
                    b11 = Ascii.DLE;
                }
                break;
            case 187078297:
                if (!strT.equals("audio/ac4")) {
                    b11 = -1;
                } else {
                    b11 = 17;
                }
                break;
            case 187078669:
                if (!strT.equals("audio/amr")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.DC2;
                }
                break;
            case 187090232:
                if (!strT.equals(MimeTypes.AUDIO_MP4)) {
                    b11 = -1;
                } else {
                    b11 = 19;
                }
                break;
            case 187091926:
                if (!strT.equals("audio/ogg")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.DC4;
                }
                break;
            case 187099443:
                if (!strT.equals("audio/wav")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.NAK;
                }
                break;
            case 1331848029:
                if (!strT.equals(MimeTypes.VIDEO_MP4)) {
                    b11 = -1;
                } else {
                    b11 = Ascii.SYN;
                }
                break;
            case 1503095341:
                if (!strT.equals(MimeTypes.AUDIO_AMR_NB)) {
                    b11 = -1;
                } else {
                    b11 = Ascii.ETB;
                }
                break;
            case 1504578661:
                if (!strT.equals(MimeTypes.AUDIO_E_AC3)) {
                    b11 = -1;
                } else {
                    b11 = Ascii.CAN;
                }
                break;
            case 1504619009:
                if (!strT.equals(MimeTypes.AUDIO_FLAC)) {
                    b11 = -1;
                } else {
                    b11 = Ascii.EM;
                }
                break;
            case 1504824762:
                if (!strT.equals("audio/midi")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.SUB;
                }
                break;
            case 1504831518:
                if (!strT.equals(MimeTypes.AUDIO_MPEG)) {
                    b11 = -1;
                } else {
                    b11 = Ascii.ESC;
                }
                break;
            case 1505118770:
                if (!strT.equals(MimeTypes.AUDIO_WEBM)) {
                    b11 = -1;
                } else {
                    b11 = Ascii.FS;
                }
                break;
            case 2039520277:
                if (!strT.equals("video/x-matroska")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.GS;
                }
                break;
            default:
                b11 = -1;
                break;
        }
        switch (b11) {
            case 0:
            case 16:
            case 24:
                return 0;
            case 1:
                return 10;
            case 2:
                return 11;
            case 3:
            case 13:
            case 14:
            case 28:
            case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                return 6;
            case 4:
            case 18:
            case 23:
                return 3;
            case 5:
                return 20;
            case 6:
                return 14;
            case 7:
                return 18;
            case 8:
            case 19:
            case 22:
                return 8;
            case 9:
                return 16;
            case 10:
                return 13;
            case 11:
                return 19;
            case 12:
                return 17;
            case 15:
                return 5;
            case 17:
                return 1;
            case 20:
                return 9;
            case 21:
                return 12;
            case 25:
                return 4;
            case 26:
                return 15;
            case 27:
                return 7;
            default:
                return -1;
        }
    }

    public static int b(Map<String, List<String>> map) {
        List<String> list = map.get(HttpHeaders.CONTENT_TYPE);
        return a((list == null || list.isEmpty()) ? null : list.get(0));
    }

    public static int c(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return -1;
        }
        if (lastPathSegment.endsWith(".ac3") || lastPathSegment.endsWith(".ec3")) {
            return 0;
        }
        if (lastPathSegment.endsWith(".ac4")) {
            return 1;
        }
        if (lastPathSegment.endsWith(".adts") || lastPathSegment.endsWith(".aac")) {
            return 2;
        }
        if (lastPathSegment.endsWith(".amr")) {
            return 3;
        }
        if (lastPathSegment.endsWith(".flac")) {
            return 4;
        }
        if (lastPathSegment.endsWith(".flv")) {
            return 5;
        }
        if (lastPathSegment.endsWith(".mid") || lastPathSegment.endsWith(".midi") || lastPathSegment.endsWith(".smf")) {
            return 15;
        }
        if (lastPathSegment.startsWith(".mk", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".webm")) {
            return 6;
        }
        if (lastPathSegment.endsWith(".mp3")) {
            return 7;
        }
        if (lastPathSegment.endsWith(".mp4") || lastPathSegment.startsWith(".m4", lastPathSegment.length() - 4) || lastPathSegment.startsWith(".mp4", lastPathSegment.length() - 5) || lastPathSegment.startsWith(".cmf", lastPathSegment.length() - 5)) {
            return 8;
        }
        if (lastPathSegment.startsWith(".og", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".opus")) {
            return 9;
        }
        if (lastPathSegment.endsWith(".ps") || lastPathSegment.endsWith(".mpeg") || lastPathSegment.endsWith(".mpg") || lastPathSegment.endsWith(".m2p")) {
            return 10;
        }
        if (lastPathSegment.endsWith(".ts") || lastPathSegment.startsWith(".ts", lastPathSegment.length() - 4)) {
            return 11;
        }
        if (lastPathSegment.endsWith(".wav") || lastPathSegment.endsWith(".wave")) {
            return 12;
        }
        if (lastPathSegment.endsWith(".vtt") || lastPathSegment.endsWith(".webvtt")) {
            return 13;
        }
        if (lastPathSegment.endsWith(".jpg") || lastPathSegment.endsWith(".jpeg")) {
            return 14;
        }
        if (lastPathSegment.endsWith(".avi")) {
            return 16;
        }
        if (lastPathSegment.endsWith(".png")) {
            return 17;
        }
        if (lastPathSegment.endsWith(".webp")) {
            return 18;
        }
        if (lastPathSegment.endsWith(".bmp") || lastPathSegment.endsWith(".dib")) {
            return 19;
        }
        return lastPathSegment.endsWith(".heic") ? 20 : -1;
    }
}
