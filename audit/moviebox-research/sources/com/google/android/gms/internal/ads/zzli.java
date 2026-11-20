package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzli {
    public final zzup zza;
    public final Object zzb;
    public final zzwh[] zzc;
    public boolean zzd;
    public boolean zze;
    public zzlj zzf;
    public boolean zzg;
    private final boolean[] zzh;
    private final zzmh[] zzi;
    private final zzyo zzj;
    private final zzlx zzk;

    @Nullable
    private zzli zzl;
    private zzws zzm;
    private zzyp zzn;
    private long zzo;

    public zzli(zzmh[] zzmhVarArr, long j11, zzyo zzyoVar, zzyx zzyxVar, zzlx zzlxVar, zzlj zzljVar, zzyp zzypVar) {
        this.zzi = zzmhVarArr;
        this.zzo = j11;
        this.zzj = zzyoVar;
        this.zzk = zzlxVar;
        zzur zzurVar = zzljVar.zza;
        this.zzb = zzurVar.zza;
        this.zzf = zzljVar;
        this.zzm = zzws.zza;
        this.zzn = zzypVar;
        this.zzc = new zzwh[2];
        this.zzh = new boolean[2];
        long j12 = zzljVar.zzb;
        long j13 = zzljVar.zzd;
        zzup zzupVarZzp = zzlxVar.zzp(zzurVar, zzyxVar, j12);
        this.zza = j13 != C.TIME_UNSET ? new zztw(zzupVarZzp, true, 0L, j13) : zzupVarZzp;
    }

    private final void zzs() {
        if (!zzu()) {
            return;
        }
        int i11 = 0;
        while (true) {
            zzyp zzypVar = this.zzn;
            if (i11 >= zzypVar.zza) {
                return;
            }
            zzypVar.zzb(i11);
            zzyi zzyiVar = this.zzn.zzc[i11];
            i11++;
        }
    }

    private final void zzt() {
        if (!zzu()) {
            return;
        }
        int i11 = 0;
        while (true) {
            zzyp zzypVar = this.zzn;
            if (i11 >= zzypVar.zza) {
                return;
            }
            zzypVar.zzb(i11);
            zzyi zzyiVar = this.zzn.zzc[i11];
            i11++;
        }
    }

    private final boolean zzu() {
        return this.zzl == null;
    }

    public final long zza(zzyp zzypVar, long j11, boolean z11) {
        return zzb(zzypVar, j11, false, new boolean[2]);
    }

    public final long zzb(zzyp zzypVar, long j11, boolean z11, boolean[] zArr) {
        int i11 = 0;
        while (true) {
            boolean z12 = true;
            if (i11 >= zzypVar.zza) {
                break;
            }
            boolean[] zArr2 = this.zzh;
            if (z11 || !zzypVar.zza(this.zzn, i11)) {
                z12 = false;
            }
            zArr2[i11] = z12;
            i11++;
        }
        int i12 = 0;
        while (true) {
            zzmh[] zzmhVarArr = this.zzi;
            if (i12 >= 2) {
                break;
            }
            zzmhVarArr[i12].zzbj();
            i12++;
        }
        zzs();
        this.zzn = zzypVar;
        zzt();
        long jZzf = this.zza.zzf(zzypVar.zzc, this.zzh, this.zzc, zArr, j11);
        int i13 = 0;
        while (true) {
            zzmh[] zzmhVarArr2 = this.zzi;
            if (i13 >= 2) {
                break;
            }
            zzmhVarArr2[i13].zzbj();
            i13++;
        }
        this.zze = false;
        int i14 = 0;
        while (true) {
            zzwh[] zzwhVarArr = this.zzc;
            if (i14 >= 2) {
                return jZzf;
            }
            if (zzwhVarArr[i14] != null) {
                zzek.zzf(zzypVar.zzb(i14));
                this.zzi[i14].zzbj();
                this.zze = true;
            } else {
                zzek.zzf(zzypVar.zzc[i14] == null);
            }
            i14++;
        }
    }

    public final long zzc() {
        if (!this.zzd) {
            return this.zzf.zzb;
        }
        long jZzb = this.zze ? this.zza.zzb() : Long.MIN_VALUE;
        return jZzb == Long.MIN_VALUE ? this.zzf.zze : jZzb;
    }

    public final long zzd() {
        if (this.zzd) {
            return this.zza.zzc();
        }
        return 0L;
    }

    public final long zze() {
        return this.zzo;
    }

    public final long zzf() {
        return this.zzf.zzb + this.zzo;
    }

    @Nullable
    public final zzli zzg() {
        return this.zzl;
    }

    public final zzws zzh() {
        return this.zzm;
    }

    public final zzyp zzi() {
        return this.zzn;
    }

    public final zzyp zzj(float f11, zzcx zzcxVar) throws zziz {
        zzyp zzypVarZzp = this.zzj.zzp(this.zzi, this.zzm, this.zzf.zza, zzcxVar);
        for (zzyi zzyiVar : zzypVarZzp.zzc) {
        }
        return zzypVarZzp;
    }

    public final void zzk(long j11, float f11, long j12) {
        zzek.zzf(zzu());
        long j13 = j11 - this.zzo;
        zzle zzleVar = new zzle();
        zzleVar.zze(j13);
        zzleVar.zzf(f11);
        zzleVar.zzd(j12);
        this.zza.zzo(new zzlg(zzleVar, null));
    }

    public final void zzl(float f11, zzcx zzcxVar) throws zziz {
        this.zzd = true;
        this.zzm = this.zza.zzh();
        zzyp zzypVarZzj = zzj(f11, zzcxVar);
        zzlj zzljVar = this.zzf;
        long jMax = zzljVar.zzb;
        long j11 = zzljVar.zze;
        if (j11 != C.TIME_UNSET && jMax >= j11) {
            jMax = Math.max(0L, j11 - 1);
        }
        long jZza = zza(zzypVarZzj, jMax, false);
        long j12 = this.zzo;
        zzlj zzljVar2 = this.zzf;
        this.zzo = j12 + (zzljVar2.zzb - jZza);
        this.zzf = zzljVar2.zzb(jZza);
    }

    public final void zzm(long j11) {
        zzek.zzf(zzu());
        if (this.zzd) {
            this.zza.zzm(j11 - this.zzo);
        }
    }

    public final void zzn() {
        zzs();
        zzup zzupVar = this.zza;
        try {
            boolean z11 = zzupVar instanceof zztw;
            zzlx zzlxVar = this.zzk;
            if (z11) {
                zzlxVar.zzi(((zztw) zzupVar).zza);
            } else {
                zzlxVar.zzi(zzupVar);
            }
        } catch (RuntimeException e11) {
            zzff.zzd("MediaPeriodHolder", "Period release failed.", e11);
        }
    }

    public final void zzo(@Nullable zzli zzliVar) {
        if (zzliVar == this.zzl) {
            return;
        }
        zzs();
        this.zzl = zzliVar;
        zzt();
    }

    public final void zzp(long j11) {
        this.zzo = 1000000000000L;
    }

    public final void zzq() {
        zzup zzupVar = this.zza;
        if (zzupVar instanceof zztw) {
            long j11 = this.zzf.zzd;
            if (j11 == C.TIME_UNSET) {
                j11 = Long.MIN_VALUE;
            }
            ((zztw) zzupVar).zzn(0L, j11);
        }
    }

    public final boolean zzr() {
        if (this.zzd) {
            return !this.zze || this.zza.zzb() == Long.MIN_VALUE;
        }
        return false;
    }
}
