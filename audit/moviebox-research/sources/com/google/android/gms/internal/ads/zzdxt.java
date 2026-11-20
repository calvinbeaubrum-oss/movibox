package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzdxt extends zzcat {
    final /* synthetic */ zzdxv zza;

    public zzdxt(zzdxv zzdxvVar) {
        this.zza = zzdxvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcau
    public final void zze(int i11) throws RemoteException {
        zzdxv zzdxvVar = this.zza;
        zzdxvVar.zzb.zzm(zzdxvVar.zza, i11);
    }

    @Override // com.google.android.gms.internal.ads.zzcau
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        zzdxv zzdxvVar = this.zza;
        zzdxvVar.zzb.zzm(zzdxvVar.zza, zzeVar.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzcau
    public final void zzg() throws RemoteException {
        zzdxv zzdxvVar = this.zza;
        zzdxvVar.zzb.zzp(zzdxvVar.zza);
    }
}
