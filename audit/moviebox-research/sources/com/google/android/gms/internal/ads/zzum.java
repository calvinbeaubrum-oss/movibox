package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzum extends zzwu {
    private final boolean zzb;
    private final zzcw zzc;
    private final zzcu zzd;
    private zzuk zze;

    @Nullable
    private zzuj zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;

    public zzum(zzut zzutVar, boolean z11) {
        boolean z12;
        super(zzutVar);
        if (z11) {
            zzutVar.zzv();
            z12 = true;
        } else {
            z12 = false;
        }
        this.zzb = z12;
        this.zzc = new zzcw();
        this.zzd = new zzcu();
        zzutVar.zzM();
        this.zze = zzuk.zzq(zzutVar.zzJ());
    }

    private final Object zzK(Object obj) {
        return (this.zze.zzf == null || !obj.equals(zzuk.zzd)) ? obj : this.zze.zzf;
    }

    private final void zzL(long j11) {
        zzuj zzujVar = this.zzf;
        int iZza = this.zze.zza(zzujVar.zza.zza);
        if (iZza == -1) {
            return;
        }
        zzuk zzukVar = this.zze;
        zzcu zzcuVar = this.zzd;
        zzukVar.zzd(iZza, zzcuVar, false);
        long j12 = zzcuVar.zze;
        if (j12 != C.TIME_UNSET && j11 >= j12) {
            j11 = Math.max(0L, j12 - 1);
        }
        zzujVar.zzs(j11);
    }

    public final zzcx zzC() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    @Nullable
    public final zzur zzD(zzur zzurVar) {
        Object obj = this.zze.zzf;
        Object obj2 = zzurVar.zza;
        if (obj != null && this.zze.zzf.equals(obj2)) {
            obj2 = zzuk.zzd;
        }
        return zzurVar.zza(obj2);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0062  */
    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zzE(zzcx zzcxVar) {
        long j11;
        zzur zzurVarZza = null;
        if (this.zzh) {
            this.zze = this.zze.zzp(zzcxVar);
            zzuj zzujVar = this.zzf;
            if (zzujVar != null) {
                zzL(zzujVar.zzn());
            }
        } else if (zzcxVar.zzo()) {
            this.zze = this.zzi ? this.zze.zzp(zzcxVar) : zzuk.zzr(zzcxVar, zzcw.zza, zzuk.zzd);
        } else {
            zzcxVar.zze(0, this.zzc, 0L);
            Object obj = this.zzc.zzc;
            zzuj zzujVar2 = this.zzf;
            if (zzujVar2 != null) {
                long jZzq = zzujVar2.zzq();
                this.zze.zzn(zzujVar2.zza.zza, this.zzd);
                this.zze.zze(0, this.zzc, 0L);
                if (jZzq != 0) {
                    j11 = jZzq;
                } else {
                    j11 = 0;
                }
            } else {
                j11 = 0;
            }
            Pair pairZzl = zzcxVar.zzl(this.zzc, this.zzd, 0, j11);
            Object obj2 = pairZzl.first;
            long jLongValue = ((Long) pairZzl.second).longValue();
            this.zze = this.zzi ? this.zze.zzp(zzcxVar) : zzuk.zzr(zzcxVar, obj, obj2);
            zzuj zzujVar3 = this.zzf;
            if (zzujVar3 != null) {
                zzL(jLongValue);
                zzur zzurVar = zzujVar3.zza;
                zzurVarZza = zzurVar.zza(zzK(zzurVar.zza));
            }
        }
        this.zzi = true;
        this.zzh = true;
        zzo(this.zze);
        if (zzurVarZza != null) {
            zzuj zzujVar4 = this.zzf;
            zzujVar4.getClass();
            zzujVar4.zzr(zzurVarZza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zzF() {
        if (this.zzb) {
            return;
        }
        this.zzg = true;
        zzB(null, ((zzwu) this).zza);
    }

    @Override // com.google.android.gms.internal.ads.zzwu, com.google.android.gms.internal.ads.zzut
    public final void zzG(zzup zzupVar) {
        ((zzuj) zzupVar).zzt();
        if (zzupVar == this.zzf) {
            this.zzf = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwu, com.google.android.gms.internal.ads.zzut
    /* JADX INFO: renamed from: zzH, reason: merged with bridge method [inline-methods] */
    public final zzuj zzI(zzur zzurVar, zzyx zzyxVar, long j11) {
        zzuj zzujVar = new zzuj(zzurVar, zzyxVar, j11);
        zzujVar.zzu(((zzwu) this).zza);
        if (this.zzh) {
            zzujVar.zzr(zzurVar.zza(zzK(zzurVar.zza)));
        } else {
            this.zzf = zzujVar;
            if (!this.zzg) {
                this.zzg = true;
                zzB(null, ((zzwu) this).zza);
            }
        }
        return zzujVar;
    }

    @Override // com.google.android.gms.internal.ads.zzua, com.google.android.gms.internal.ads.zzts
    public final void zzq() {
        this.zzh = false;
        this.zzg = false;
        super.zzq();
    }

    @Override // com.google.android.gms.internal.ads.zzts, com.google.android.gms.internal.ads.zzut
    public final void zzt(zzbp zzbpVar) {
        if (this.zzi) {
            this.zze = this.zze.zzp(new zzwq(this.zze.zzc, zzbpVar));
        } else {
            this.zze = zzuk.zzq(zzbpVar);
        }
        ((zzwu) this).zza.zzt(zzbpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzua, com.google.android.gms.internal.ads.zzut
    public final void zzz() {
    }
}
