package com.google.android.gms.internal.ads;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzvy extends zzts implements zzvp {
    private final zzgv zza;
    private final zzry zzb;
    private final int zzc;
    private boolean zzd = true;
    private long zze = C.TIME_UNSET;
    private boolean zzf;
    private boolean zzg;

    @Nullable
    private zzhy zzh;
    private zzbp zzi;
    private final zzvv zzj;
    private final zzzb zzk;

    public /* synthetic */ zzvy(zzbp zzbpVar, zzgv zzgvVar, zzvv zzvvVar, zzry zzryVar, zzzb zzzbVar, int i11, zzvx zzvxVar) {
        this.zzi = zzbpVar;
        this.zza = zzgvVar;
        this.zzj = zzvvVar;
        this.zzb = zzryVar;
        this.zzk = zzzbVar;
        this.zzc = i11;
    }

    private final void zzw() {
        long j11 = this.zze;
        boolean z11 = this.zzf;
        boolean z12 = this.zzg;
        zzbp zzbpVarZzJ = zzJ();
        zzwl zzwlVar = new zzwl(C.TIME_UNSET, C.TIME_UNSET, C.TIME_UNSET, j11, j11, 0L, 0L, z11, false, false, null, zzbpVarZzJ, z12 ? zzbpVarZzJ.zzf : null);
        zzo(this.zzd ? new zzvu(this, zzwlVar) : zzwlVar);
    }

    @Override // com.google.android.gms.internal.ads.zzut
    public final void zzG(zzup zzupVar) {
        ((zzvt) zzupVar).zzN();
    }

    @Override // com.google.android.gms.internal.ads.zzut
    public final zzup zzI(zzur zzurVar, zzyx zzyxVar, long j11) {
        zzgw zzgwVarZza = this.zza.zza();
        zzhy zzhyVar = this.zzh;
        if (zzhyVar != null) {
            zzgwVarZza.zzf(zzhyVar);
        }
        zzbi zzbiVar = zzJ().zzd;
        zzbiVar.getClass();
        zzvv zzvvVar = this.zzj;
        zzb();
        return new zzvt(zzbiVar.zzb, zzgwVarZza, new zztu(zzvvVar.zza), this.zzb, zzc(zzurVar), this.zzk, zze(zzurVar), this, zzyxVar, null, this.zzc, zzfy.zzq(C.TIME_UNSET));
    }

    @Override // com.google.android.gms.internal.ads.zzut
    public final synchronized zzbp zzJ() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzvp
    public final void zza(long j11, boolean z11, boolean z12) {
        if (j11 == C.TIME_UNSET) {
            j11 = this.zze;
        }
        if (!this.zzd && this.zze == j11 && this.zzf == z11 && this.zzg == z12) {
            return;
        }
        this.zze = j11;
        this.zzf = z11;
        this.zzg = z12;
        this.zzd = false;
        zzw();
    }

    @Override // com.google.android.gms.internal.ads.zzts
    public final void zzn(@Nullable zzhy zzhyVar) {
        this.zzh = zzhyVar;
        Looper.myLooper().getClass();
        zzb();
        zzw();
    }

    @Override // com.google.android.gms.internal.ads.zzts
    public final void zzq() {
    }

    @Override // com.google.android.gms.internal.ads.zzts, com.google.android.gms.internal.ads.zzut
    public final synchronized void zzt(zzbp zzbpVar) {
        this.zzi = zzbpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzut
    public final void zzz() {
    }
}
