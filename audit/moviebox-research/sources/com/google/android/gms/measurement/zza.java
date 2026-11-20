package com.google.android.gms.measurement;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.collection.a;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzfr;
import com.google.android.gms.measurement.internal.zzgr;
import com.google.android.gms.measurement.internal.zzgs;
import com.google.android.gms.measurement.internal.zzhx;
import com.google.android.gms.measurement.internal.zzkw;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zza extends zzd {
    private final zzfr zza;
    private final zzhx zzb;

    public zza(@NonNull zzfr zzfrVar) {
        super(null);
        Preconditions.checkNotNull(zzfrVar);
        this.zza = zzfrVar;
        this.zzb = zzfrVar.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final int zza(String str) {
        this.zzb.zzh(str);
        return 25;
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final long zzb() {
        return this.zza.zzv().zzq();
    }

    @Override // com.google.android.gms.measurement.zzd
    public final Boolean zzc() {
        return this.zzb.zzi();
    }

    @Override // com.google.android.gms.measurement.zzd
    public final Double zzd() {
        return this.zzb.zzj();
    }

    @Override // com.google.android.gms.measurement.zzd
    public final Integer zze() {
        return this.zzb.zzl();
    }

    @Override // com.google.android.gms.measurement.zzd
    public final Long zzf() {
        return this.zzb.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final Object zzg(int i11) {
        if (i11 == 0) {
            return this.zzb.zzr();
        }
        if (i11 == 1) {
            return this.zzb.zzm();
        }
        if (i11 != 2) {
            return i11 != 3 ? this.zzb.zzi() : this.zzb.zzl();
        }
        return this.zzb.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final String zzh() {
        return this.zzb.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final String zzi() {
        return this.zzb.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final String zzj() {
        return this.zzb.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final String zzk() {
        return this.zzb.zzo();
    }

    @Override // com.google.android.gms.measurement.zzd
    public final String zzl() {
        return this.zzb.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final List zzm(String str, String str2) {
        return this.zzb.zzs(str, str2);
    }

    @Override // com.google.android.gms.measurement.zzd
    public final Map zzn(boolean z11) {
        List<zzkw> listZzt = this.zzb.zzt(z11);
        a aVar = new a(listZzt.size());
        for (zzkw zzkwVar : listZzt) {
            Object objZza = zzkwVar.zza();
            if (objZza != null) {
                aVar.put(zzkwVar.zzb, objZza);
            }
        }
        return aVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final Map zzo(String str, String str2, boolean z11) {
        return this.zzb.zzu(str, str2, z11);
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final void zzp(String str) {
        this.zza.zzd().zzd(str, this.zza.zzav().elapsedRealtime());
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final void zzq(String str, String str2, Bundle bundle) {
        this.zza.zzq().zzA(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final void zzr(String str) {
        this.zza.zzd().zze(str, this.zza.zzav().elapsedRealtime());
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final void zzs(String str, String str2, Bundle bundle) {
        this.zzb.zzD(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final void zzt(String str, String str2, Bundle bundle, long j11) {
        this.zzb.zzE(str, str2, bundle, true, false, j11);
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final void zzu(zzgs zzgsVar) {
        this.zzb.zzJ(zzgsVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final void zzv(Bundle bundle) {
        this.zzb.zzP(bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final void zzw(zzgr zzgrVar) {
        this.zzb.zzT(zzgrVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final void zzx(zzgs zzgsVar) {
        this.zzb.zzZ(zzgsVar);
    }
}
