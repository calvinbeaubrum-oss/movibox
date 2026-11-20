package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeqp {
    private final zzequ zza;
    private final String zzb;

    @Nullable
    private com.google.android.gms.ads.internal.client.zzdn zzc;

    public zzeqp(zzequ zzequVar, String str) {
        this.zza = zzequVar;
        this.zzb = str;
    }

    @Nullable
    public final synchronized String zza() {
        com.google.android.gms.ads.internal.client.zzdn zzdnVar;
        try {
            zzdnVar = this.zzc;
        } catch (RemoteException e11) {
            zzcec.zzl("#007 Could not call remote method.", e11);
            return null;
        }
        return zzdnVar != null ? zzdnVar.zzg() : null;
    }

    @Nullable
    public final synchronized String zzb() {
        com.google.android.gms.ads.internal.client.zzdn zzdnVar;
        try {
            zzdnVar = this.zzc;
        } catch (RemoteException e11) {
            zzcec.zzl("#007 Could not call remote method.", e11);
            return null;
        }
        return zzdnVar != null ? zzdnVar.zzg() : null;
    }

    public final synchronized void zzd(com.google.android.gms.ads.internal.client.zzl zzlVar, int i11) throws RemoteException {
        this.zzc = null;
        zzeqv zzeqvVar = new zzeqv(i11);
        zzeqo zzeqoVar = new zzeqo(this);
        this.zza.zzb(zzlVar, this.zzb, zzeqvVar, zzeqoVar);
    }

    public final synchronized boolean zze() throws RemoteException {
        return this.zza.zza();
    }
}
