package com.google.android.gms.internal.ads;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.math.RoundingMode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzaop implements zzaoq {
    private static final int[] zza = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
    private static final int[] zzb = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 143, 157, 173, 190, 209, 230, 253, 279, 307, 337, 371, TTAdConstant.DOWNLOAD_URL_CODE, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};
    private final zzacx zzc;
    private final zzaea zzd;
    private final zzaot zze;
    private final int zzf;
    private final byte[] zzg;
    private final zzfp zzh;
    private final int zzi;
    private final zzam zzj;
    private int zzk;
    private long zzl;
    private int zzm;
    private long zzn;

    public zzaop(zzacx zzacxVar, zzaea zzaeaVar, zzaot zzaotVar) throws zzcc {
        this.zzc = zzacxVar;
        this.zzd = zzaeaVar;
        this.zze = zzaotVar;
        int iMax = Math.max(1, zzaotVar.zzc / 10);
        this.zzi = iMax;
        zzfp zzfpVar = new zzfp(zzaotVar.zzf);
        zzfpVar.zzk();
        int iZzk = zzfpVar.zzk();
        this.zzf = iZzk;
        int i11 = zzaotVar.zzb;
        int i12 = zzaotVar.zzd;
        int i13 = (((i12 - (i11 * 4)) * 8) / (zzaotVar.zze * i11)) + 1;
        if (iZzk != i13) {
            throw zzcc.zza("Expected frames per block: " + i13 + "; got: " + iZzk, null);
        }
        int i14 = zzfy.zza;
        int i15 = ((iMax + iZzk) - 1) / iZzk;
        this.zzg = new byte[i12 * i15];
        this.zzh = new zzfp(i15 * (iZzk + iZzk) * i11);
        int i16 = ((zzaotVar.zzc * zzaotVar.zzd) * 8) / iZzk;
        zzak zzakVar = new zzak();
        zzakVar.zzW(MimeTypes.AUDIO_RAW);
        zzakVar.zzx(i16);
        zzakVar.zzR(i16);
        zzakVar.zzO((iMax + iMax) * i11);
        zzakVar.zzy(zzaotVar.zzb);
        zzakVar.zzX(zzaotVar.zzc);
        zzakVar.zzQ(2);
        this.zzj = zzakVar.zzac();
    }

    private final int zzd(int i11) {
        int i12 = this.zze.zzb;
        return i11 / (i12 + i12);
    }

    private final int zze(int i11) {
        return (i11 + i11) * this.zze.zzb;
    }

    private final void zzf(int i11) {
        long jZzs = this.zzl + zzfy.zzs(this.zzn, 1000000L, this.zze.zzc, RoundingMode.FLOOR);
        int iZze = zze(i11);
        this.zzd.zzt(jZzs, 1, iZze, this.zzm - iZze, null);
        this.zzn += (long) i11;
        this.zzm -= iZze;
    }

    @Override // com.google.android.gms.internal.ads.zzaoq
    public final void zza(int i11, long j11) {
        this.zzc.zzO(new zzaow(this.zze, this.zzf, i11, j11));
        this.zzd.zzl(this.zzj);
    }

    @Override // com.google.android.gms.internal.ads.zzaoq
    public final void zzb(long j11) {
        this.zzk = 0;
        this.zzl = j11;
        this.zzm = 0;
        this.zzn = 0L;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x003f A[LOOP:0: B:6:0x0024->B:12:0x003f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:41:0x0045 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x0021 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0026  */
    /* JADX WARN: Code duplicated, block: B:9:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x003c -> B:4:0x0021). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.google.android.gms.internal.ads.zzaoq
    public final boolean zzc(com.google.android.gms.internal.ads.zzacv r21, long r22) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaop.zzc(com.google.android.gms.internal.ads.zzacv, long):boolean");
    }
}
