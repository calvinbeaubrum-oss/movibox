package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzacr {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] zzc = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
    private static final int[] zzd = {64, 112, 128, PsExtractor.AUDIO_STREAM, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    public static zzam zza(byte[] bArr, @Nullable String str, @Nullable String str2, @Nullable zzae zzaeVar) {
        zzfo zzfoVar;
        if (bArr[0] == 127) {
            zzfoVar = new zzfo(bArr, bArr.length);
        } else {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
            byte b11 = bArrCopyOf[0];
            if (b11 == -2 || b11 == -1) {
                for (int i11 = 0; i11 < bArrCopyOf.length - 1; i11 += 2) {
                    byte b12 = bArrCopyOf[i11];
                    int i12 = i11 + 1;
                    bArrCopyOf[i11] = bArrCopyOf[i12];
                    bArrCopyOf[i12] = b12;
                }
            }
            int length = bArrCopyOf.length;
            zzfoVar = new zzfo(bArrCopyOf, length);
            if (bArrCopyOf[0] == 31) {
                zzfo zzfoVar2 = new zzfo(bArrCopyOf, length);
                while (zzfoVar2.zza() >= 16) {
                    zzfoVar2.zzm(2);
                    zzfoVar.zzf(zzfoVar2.zzd(14), 14);
                }
            }
            zzfoVar.zzj(bArrCopyOf, bArrCopyOf.length);
        }
        zzfoVar.zzm(60);
        int i13 = zzb[zzfoVar.zzd(6)];
        int i14 = zzc[zzfoVar.zzd(4)];
        int iZzd = zzfoVar.zzd(5);
        int i15 = iZzd < 29 ? (zzd[iZzd] * 1000) / 2 : -1;
        zzfoVar.zzm(10);
        int i16 = i13 + (zzfoVar.zzd(2) > 0 ? 1 : 0);
        zzak zzakVar = new zzak();
        zzakVar.zzK(str);
        zzakVar.zzW(MimeTypes.AUDIO_DTS);
        zzakVar.zzx(i15);
        zzakVar.zzy(i16);
        zzakVar.zzX(i14);
        zzakVar.zzE(null);
        zzakVar.zzN(str2);
        return zzakVar.zzac();
    }
}
