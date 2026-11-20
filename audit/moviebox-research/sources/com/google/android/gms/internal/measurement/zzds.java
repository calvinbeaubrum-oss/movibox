package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
final class zzds extends zzdu {
    final /* synthetic */ Long zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ Bundle zzd;
    final /* synthetic */ boolean zze;
    final /* synthetic */ boolean zzf;
    final /* synthetic */ zzef zzg;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzds(zzef zzefVar, Long l11, String str, String str2, Bundle bundle, boolean z11, boolean z12) {
        super(zzefVar, true);
        this.zzg = zzefVar;
        this.zza = l11;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bundle;
        this.zze = z11;
        this.zzf = z12;
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public final void zza() throws RemoteException {
        Long l11 = this.zza;
        ((zzcc) Preconditions.checkNotNull(this.zzg.zzj)).logEvent(this.zzb, this.zzc, this.zzd, this.zze, this.zzf, l11 == null ? this.zzh : l11.longValue());
    }
}
