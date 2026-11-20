package io.github.anilbeesetti.nextlib.media3ext.ffdecoder;

import androidx.annotation.Nullable;
import androidx.media3.common.c0;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import z3.k;
import z3.o;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class FfmpegLibrary {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f67276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f67277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f67278c;

    /* JADX INFO: compiled from: source.java */
    public class a extends k {
        public a(String... strArr) {
            super(strArr);
        }

        @Override // z3.k
        public void b(String str) {
            System.loadLibrary(str);
        }
    }

    static {
        c0.a("media3.decoder.ffmpeg");
        f67276a = new a("media3ext");
        f67278c = -1;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Nullable
    public static String a(String str) {
        str.hashCode();
        byte b11 = -1;
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals(MimeTypes.AUDIO_E_AC3_JOC)) {
                    b11 = 0;
                }
                break;
            case -1662541442:
                if (str.equals(MimeTypes.VIDEO_H265)) {
                    b11 = 1;
                }
                break;
            case -1662382439:
                if (str.equals(MimeTypes.VIDEO_MPEG)) {
                    b11 = 2;
                }
                break;
            case -1606874997:
                if (str.equals(MimeTypes.AUDIO_AMR_WB)) {
                    b11 = 3;
                }
                break;
            case -1095064472:
                if (str.equals(MimeTypes.AUDIO_DTS)) {
                    b11 = 4;
                }
                break;
            case -1003765268:
                if (str.equals(MimeTypes.AUDIO_VORBIS)) {
                    b11 = 5;
                }
                break;
            case -432837260:
                if (str.equals(MimeTypes.AUDIO_MPEG_L1)) {
                    b11 = 6;
                }
                break;
            case -432837259:
                if (str.equals(MimeTypes.AUDIO_MPEG_L2)) {
                    b11 = 7;
                }
                break;
            case -53558318:
                if (str.equals(MimeTypes.AUDIO_AAC)) {
                    b11 = 8;
                }
                break;
            case 5751993:
                if (str.equals(MimeTypes.VIDEO_MPEG2)) {
                    b11 = 9;
                }
                break;
            case 187078296:
                if (str.equals(MimeTypes.AUDIO_AC3)) {
                    b11 = 10;
                }
                break;
            case 1331836730:
                if (str.equals(MimeTypes.VIDEO_H264)) {
                    b11 = Ascii.VT;
                }
                break;
            case 1503095341:
                if (str.equals(MimeTypes.AUDIO_AMR_NB)) {
                    b11 = Ascii.FF;
                }
                break;
            case 1504470054:
                if (str.equals(MimeTypes.AUDIO_ALAC)) {
                    b11 = Ascii.CR;
                }
                break;
            case 1504578661:
                if (str.equals(MimeTypes.AUDIO_E_AC3)) {
                    b11 = Ascii.SO;
                }
                break;
            case 1504619009:
                if (str.equals(MimeTypes.AUDIO_FLAC)) {
                    b11 = Ascii.SI;
                }
                break;
            case 1504831518:
                if (str.equals(MimeTypes.AUDIO_MPEG)) {
                    b11 = Ascii.DLE;
                }
                break;
            case 1504891608:
                if (str.equals(MimeTypes.AUDIO_OPUS)) {
                    b11 = 17;
                }
                break;
            case 1505942594:
                if (str.equals(MimeTypes.AUDIO_DTS_HD)) {
                    b11 = Ascii.DC2;
                }
                break;
            case 1556697186:
                if (str.equals(MimeTypes.AUDIO_TRUEHD)) {
                    b11 = 19;
                }
                break;
            case 1599127256:
                if (str.equals(MimeTypes.VIDEO_VP8)) {
                    b11 = Ascii.DC4;
                }
                break;
            case 1599127257:
                if (str.equals(MimeTypes.VIDEO_VP9)) {
                    b11 = Ascii.NAK;
                }
                break;
            case 1903231877:
                if (str.equals(MimeTypes.AUDIO_ALAW)) {
                    b11 = Ascii.SYN;
                }
                break;
            case 1903589369:
                if (str.equals(MimeTypes.AUDIO_MLAW)) {
                    b11 = Ascii.ETB;
                }
                break;
        }
        switch (b11) {
            case 0:
            case 14:
                return "eac3";
            case 1:
                return "hevc";
            case 2:
                return "mpegvideo";
            case 3:
                return "amrwb";
            case 4:
            case 18:
                return "dca";
            case 5:
                return "vorbis";
            case 6:
            case 7:
            case 16:
                return "mp3";
            case 8:
                return "aac";
            case 9:
                return "mpeg2video";
            case 10:
                return "ac3";
            case 11:
                return "h264";
            case 12:
                return "amrnb";
            case 13:
                return "alac";
            case 15:
                return "flac";
            case 17:
                return "opus";
            case 19:
                return "truehd";
            case 20:
                return "libvpx";
            case 21:
                return "libvpx-vp9";
            case 22:
                return "pcm_alaw";
            case 23:
                return "pcm_mulaw";
            default:
                return null;
        }
    }

    public static int b() {
        if (!d()) {
            return -1;
        }
        if (f67278c == -1) {
            f67278c = ffmpegGetInputBufferPaddingSize();
        }
        return f67278c;
    }

    @Nullable
    public static String c() {
        if (!d()) {
            return null;
        }
        if (f67277b == null) {
            f67277b = ffmpegGetVersion();
        }
        return f67277b;
    }

    public static boolean d() {
        return f67276a.a();
    }

    public static boolean e(String str) {
        String strA;
        if (!d() || (strA = a(str)) == null) {
            return false;
        }
        if (ffmpegHasDecoder(strA)) {
            return true;
        }
        o.h("FfmpegLibrary", "No " + strA + " decoder available. Check the FFmpeg build configuration.");
        return false;
    }

    private static native int ffmpegGetInputBufferPaddingSize();

    private static native String ffmpegGetVersion();

    private static native boolean ffmpegHasDecoder(String str);
}
