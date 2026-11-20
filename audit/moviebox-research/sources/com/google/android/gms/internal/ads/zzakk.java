package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzakk implements zzakp {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:31:0x005e  */
    @Override // com.google.android.gms.internal.ads.zzakp
    public final int zza(zzam zzamVar) {
        String str = zzamVar.zzm;
        if (str != null) {
            switch (str) {
                case "text/x-ssa":
                case "text/vtt":
                    return 1;
                case "application/x-mp4-vtt":
                    return 2;
                case "application/x-subrip":
                    return 1;
                case "application/x-quicktime-tx3g":
                case "application/pgs":
                case "application/dvbsubs":
                    return 2;
                case "application/ttml+xml":
                    return 1;
            }
        }
        throw new IllegalArgumentException("Unsupported MIME type: ".concat(String.valueOf(str)));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:31:0x005c  */
    @Override // com.google.android.gms.internal.ads.zzakp
    public final zzakr zzb(zzam zzamVar) {
        String str = zzamVar.zzm;
        if (str != null) {
            switch (str) {
                case "text/x-ssa":
                    return new zzalh(zzamVar.zzo);
                case "text/vtt":
                    return new zzami();
                case "application/x-mp4-vtt":
                    return new zzalx();
                case "application/x-subrip":
                    return new zzall();
                case "application/x-quicktime-tx3g":
                    return new zzalw(zzamVar.zzo);
                case "application/pgs":
                    return new zzalf();
                case "application/dvbsubs":
                    return new zzald(zzamVar.zzo);
                case "application/ttml+xml":
                    return new zzalr();
            }
        }
        throw new IllegalArgumentException("Unsupported MIME type: ".concat(String.valueOf(str)));
    }

    @Override // com.google.android.gms.internal.ads.zzakp
    public final boolean zzc(zzam zzamVar) {
        String str = zzamVar.zzm;
        return Objects.equals(str, MimeTypes.TEXT_SSA) || Objects.equals(str, MimeTypes.TEXT_VTT) || Objects.equals(str, MimeTypes.APPLICATION_MP4VTT) || Objects.equals(str, MimeTypes.APPLICATION_SUBRIP) || Objects.equals(str, MimeTypes.APPLICATION_TX3G) || Objects.equals(str, MimeTypes.APPLICATION_PGS) || Objects.equals(str, MimeTypes.APPLICATION_DVBSUBS) || Objects.equals(str, MimeTypes.APPLICATION_TTML);
    }
}
