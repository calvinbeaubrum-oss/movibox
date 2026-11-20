package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zznz;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzz extends zzy {
    final /* synthetic */ zzaa zza;
    private final com.google.android.gms.internal.measurement.zzet zzh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzz(zzaa zzaaVar, String str, int i11, com.google.android.gms.internal.measurement.zzet zzetVar) {
        super(str, i11);
        this.zza = zzaaVar;
        this.zzh = zzetVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public final int zza() {
        return this.zzh.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public final boolean zzb() {
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public final boolean zzc() {
        return true;
    }

    public final boolean zzd(Long l11, Long l12, com.google.android.gms.internal.measurement.zzgm zzgmVar, boolean z11) {
        zznz.zzc();
        boolean zZzs = this.zza.zzt.zzf().zzs(this.zzb, zzdu.zzU);
        boolean zZzg = this.zzh.zzg();
        boolean zZzh = this.zzh.zzh();
        boolean zZzi = this.zzh.zzi();
        boolean z12 = zZzg || zZzh || zZzi;
        Boolean boolZzj = null;
        boolZzj = null;
        boolZzj = null;
        boolZzj = null;
        boolZzj = null;
        if (z11 && !z12) {
            this.zza.zzt.zzay().zzj().zzc("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.zzc), this.zzh.zzj() ? Integer.valueOf(this.zzh.zza()) : null);
            return true;
        }
        com.google.android.gms.internal.measurement.zzem zzemVarZzb = this.zzh.zzb();
        boolean zZzg2 = zzemVarZzb.zzg();
        if (zzgmVar.zzr()) {
            if (zzemVarZzb.zzi()) {
                boolZzj = zzy.zzj(zzy.zzh(zzgmVar.zzb(), zzemVarZzb.zzc()), zZzg2);
            } else {
                this.zza.zzt.zzay().zzk().zzb("No number filter for long property. property", this.zza.zzt.zzj().zzf(zzgmVar.zzf()));
            }
        } else if (zzgmVar.zzq()) {
            if (zzemVarZzb.zzi()) {
                boolZzj = zzy.zzj(zzy.zzg(zzgmVar.zza(), zzemVarZzb.zzc()), zZzg2);
            } else {
                this.zza.zzt.zzay().zzk().zzb("No number filter for double property. property", this.zza.zzt.zzj().zzf(zzgmVar.zzf()));
            }
        } else if (!zzgmVar.zzt()) {
            this.zza.zzt.zzay().zzk().zzb("User property has no value, property", this.zza.zzt.zzj().zzf(zzgmVar.zzf()));
        } else if (zzemVarZzb.zzk()) {
            boolZzj = zzy.zzj(zzy.zzf(zzgmVar.zzg(), zzemVarZzb.zzd(), this.zza.zzt.zzay()), zZzg2);
        } else if (!zzemVarZzb.zzi()) {
            this.zza.zzt.zzay().zzk().zzb("No string or number filter defined. property", this.zza.zzt.zzj().zzf(zzgmVar.zzf()));
        } else if (zzkv.zzx(zzgmVar.zzg())) {
            boolZzj = zzy.zzj(zzy.zzi(zzgmVar.zzg(), zzemVarZzb.zzc()), zZzg2);
        } else {
            this.zza.zzt.zzay().zzk().zzc("Invalid user property value for Numeric number filter. property, value", this.zza.zzt.zzj().zzf(zzgmVar.zzf()), zzgmVar.zzg());
        }
        this.zza.zzt.zzay().zzj().zzb("Property filter result", boolZzj == null ? "null" : boolZzj);
        if (boolZzj == null) {
            return false;
        }
        this.zzd = Boolean.TRUE;
        if (zZzi && !boolZzj.booleanValue()) {
            return true;
        }
        if (!z11 || this.zzh.zzg()) {
            this.zze = boolZzj;
        }
        if (boolZzj.booleanValue() && z12 && zzgmVar.zzs()) {
            long jZzc = zzgmVar.zzc();
            if (l11 != null) {
                jZzc = l11.longValue();
            }
            if (zZzs && this.zzh.zzg() && !this.zzh.zzh() && l12 != null) {
                jZzc = l12.longValue();
            }
            if (this.zzh.zzh()) {
                this.zzg = Long.valueOf(jZzc);
            } else {
                this.zzf = Long.valueOf(jZzc);
            }
        }
        return true;
    }
}
