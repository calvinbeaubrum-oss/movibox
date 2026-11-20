package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzadh {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final long zzj;

    @Nullable
    public final zzadg zzk;

    @Nullable
    private final zzby zzl;

    private zzadh(int i11, int i12, int i13, int i14, int i15, int i16, int i17, long j11, @Nullable zzadg zzadgVar, @Nullable zzby zzbyVar) {
        this.zza = i11;
        this.zzb = i12;
        this.zzc = i13;
        this.zzd = i14;
        this.zze = i15;
        this.zzf = zzi(i15);
        this.zzg = i16;
        this.zzh = i17;
        this.zzi = zzh(i17);
        this.zzj = j11;
        this.zzk = zzadgVar;
        this.zzl = zzbyVar;
    }

    public zzadh(byte[] bArr, int i11) {
        zzfo zzfoVar = new zzfo(bArr, bArr.length);
        zzfoVar.zzk(i11 * 8);
        this.zza = zzfoVar.zzd(16);
        this.zzb = zzfoVar.zzd(16);
        this.zzc = zzfoVar.zzd(24);
        this.zzd = zzfoVar.zzd(24);
        int iZzd = zzfoVar.zzd(20);
        this.zze = iZzd;
        this.zzf = zzi(iZzd);
        this.zzg = zzfoVar.zzd(3) + 1;
        int iZzd2 = zzfoVar.zzd(5) + 1;
        this.zzh = iZzd2;
        this.zzi = zzh(iZzd2);
        int iZzd3 = zzfoVar.zzd(4);
        int iZzd4 = zzfoVar.zzd(32);
        int i12 = zzfy.zza;
        this.zzj = ((((long) iZzd3) & 4294967295L) << 32) | (((long) iZzd4) & 4294967295L);
        this.zzk = null;
        this.zzl = null;
    }

    private static int zzh(int i11) {
        if (i11 == 8) {
            return 1;
        }
        if (i11 == 12) {
            return 2;
        }
        if (i11 == 16) {
            return 4;
        }
        if (i11 != 20) {
            return i11 != 24 ? -1 : 6;
        }
        return 5;
    }

    private static int zzi(int i11) {
        switch (i11) {
            case 8000:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case 192000:
                return 3;
            default:
                return -1;
        }
    }

    public final long zza() {
        long j11 = this.zzj;
        return j11 == 0 ? C.TIME_UNSET : (j11 * 1000000) / ((long) this.zze);
    }

    public final long zzb(long j11) {
        return Math.max(0L, Math.min((j11 * ((long) this.zze)) / 1000000, this.zzj - 1));
    }

    public final zzam zzc(byte[] bArr, @Nullable zzby zzbyVar) {
        bArr[4] = -128;
        zzby zzbyVarZzd = zzd(zzbyVar);
        zzak zzakVar = new zzak();
        zzakVar.zzW(MimeTypes.AUDIO_FLAC);
        int i11 = this.zzd;
        if (i11 <= 0) {
            i11 = -1;
        }
        zzakVar.zzO(i11);
        zzakVar.zzy(this.zzg);
        zzakVar.zzX(this.zze);
        zzakVar.zzQ(zzfy.zzk(this.zzh));
        zzakVar.zzL(Collections.singletonList(bArr));
        zzakVar.zzP(zzbyVarZzd);
        return zzakVar.zzac();
    }

    @Nullable
    public final zzby zzd(@Nullable zzby zzbyVar) {
        zzby zzbyVar2 = this.zzl;
        return zzbyVar2 == null ? zzbyVar : zzbyVar2.zzd(zzbyVar);
    }

    public final zzadh zze(List list) {
        return new zzadh(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzg, this.zzh, this.zzj, this.zzk, zzd(new zzby(list)));
    }

    public final zzadh zzf(@Nullable zzadg zzadgVar) {
        return new zzadh(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzg, this.zzh, this.zzj, zzadgVar, this.zzl);
    }

    public final zzadh zzg(List list) {
        return new zzadh(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzg, this.zzh, this.zzj, this.zzk, zzd(zzaeg.zzb(list)));
    }
}
