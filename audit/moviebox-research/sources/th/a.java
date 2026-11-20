package th;

import androidx.annotation.Nullable;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Nullable
    public j a(com.google.android.exoplayer2.source.rtsp.j jVar) {
        String str = (String) com.google.android.exoplayer2.util.a.e(jVar.f34552c.f33445m);
        str.hashCode();
        byte b11 = -1;
        switch (str.hashCode()) {
            case -1664118616:
                if (str.equals(MimeTypes.VIDEO_H263)) {
                    b11 = 0;
                }
                break;
            case -1662541442:
                if (str.equals(MimeTypes.VIDEO_H265)) {
                    b11 = 1;
                }
                break;
            case -1606874997:
                if (str.equals(MimeTypes.AUDIO_AMR_WB)) {
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
            case 187094639:
                if (str.equals(MimeTypes.AUDIO_RAW)) {
                    b11 = 5;
                }
                break;
            case 1187890754:
                if (str.equals(MimeTypes.VIDEO_MP4V)) {
                    b11 = 6;
                }
                break;
            case 1331836730:
                if (str.equals(MimeTypes.VIDEO_H264)) {
                    b11 = 7;
                }
                break;
            case 1503095341:
                if (str.equals(MimeTypes.AUDIO_AMR_NB)) {
                    b11 = 8;
                }
                break;
            case 1504891608:
                if (str.equals(MimeTypes.AUDIO_OPUS)) {
                    b11 = 9;
                }
                break;
            case 1599127256:
                if (str.equals(MimeTypes.VIDEO_VP8)) {
                    b11 = 10;
                }
                break;
            case 1599127257:
                if (str.equals(MimeTypes.VIDEO_VP9)) {
                    b11 = Ascii.VT;
                }
                break;
            case 1903231877:
                if (str.equals(MimeTypes.AUDIO_ALAW)) {
                    b11 = Ascii.FF;
                }
                break;
            case 1903589369:
                if (str.equals(MimeTypes.AUDIO_MLAW)) {
                    b11 = Ascii.CR;
                }
                break;
        }
        switch (b11) {
            case 0:
                return new e(jVar);
            case 1:
                return new g(jVar);
            case 2:
            case 8:
                return new d(jVar);
            case 3:
                return new b(jVar);
            case 4:
                return new c(jVar);
            case 5:
            case 12:
            case 13:
                return new k(jVar);
            case 6:
                return new h(jVar);
            case 7:
                return new f(jVar);
            case 9:
                return new i(jVar);
            case 10:
                return new l(jVar);
            case 11:
                return new m(jVar);
            default:
                return null;
        }
    }
}
