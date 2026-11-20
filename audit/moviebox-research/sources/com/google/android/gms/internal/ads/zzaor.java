package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.math.RoundingMode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzaor implements zzaoq {
    private final zzacx zza;
    private final zzaea zzb;
    private final zzaot zzc;
    private final zzam zzd;
    private final int zze;
    private long zzf;
    private int zzg;
    private long zzh;

    public zzaor(zzacx zzacxVar, zzaea zzaeaVar, zzaot zzaotVar, String str, int i11) throws zzcc {
        this.zza = zzacxVar;
        this.zzb = zzaeaVar;
        this.zzc = zzaotVar;
        int i12 = zzaotVar.zzb * zzaotVar.zze;
        int i13 = zzaotVar.zzd;
        int i14 = i12 / 8;
        if (i13 != i14) {
            throw zzcc.zza("Expected block size: " + i14 + "; got: " + i13, null);
        }
        int i15 = zzaotVar.zzc * i14;
        int i16 = i15 * 8;
        int iMax = Math.max(i14, i15 / 10);
        this.zze = iMax;
        zzak zzakVar = new zzak();
        zzakVar.zzW(str);
        zzakVar.zzx(i16);
        zzakVar.zzR(i16);
        zzakVar.zzO(iMax);
        zzakVar.zzy(zzaotVar.zzb);
        zzakVar.zzX(zzaotVar.zzc);
        zzakVar.zzQ(i11);
        this.zzd = zzakVar.zzac();
    }

    @Override // com.google.android.gms.internal.ads.zzaoq
    public final void zza(int i11, long j11) {
        this.zza.zzO(new zzaow(this.zzc, 1, i11, j11));
        this.zzb.zzl(this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzaoq
    public final void zzb(long j11) {
        this.zzf = j11;
        this.zzg = 0;
        this.zzh = 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzaoq
    public final boolean zzc(zzacv zzacvVar, long j11) throws IOException {
        int i11;
        int i12;
        long j12 = j11;
        while (j12 > 0 && (i11 = this.zzg) < (i12 = this.zze)) {
            int iZza = zzady.zza(this.zzb, zzacvVar, (int) Math.min(i12 - i11, j12), true);
            if (iZza == -1) {
                j12 = 0;
            } else {
                this.zzg += iZza;
                j12 -= (long) iZza;
            }
        }
        zzaot zzaotVar = this.zzc;
        int i13 = this.zzg;
        int i14 = zzaotVar.zzd;
        int i15 = i13 / i14;
        if (i15 > 0) {
            long jZzs = this.zzf + zzfy.zzs(this.zzh, 1000000L, zzaotVar.zzc, RoundingMode.FLOOR);
            int i16 = i15 * i14;
            int i17 = this.zzg - i16;
            this.zzb.zzt(jZzs, 1, i16, i17, null);
            this.zzh += (long) i15;
            this.zzg = i17;
        }
        return j12 <= 0;
    }
}
