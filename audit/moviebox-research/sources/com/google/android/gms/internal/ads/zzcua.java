package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcua extends zzbai {
    private final zzctz zza;
    private final com.google.android.gms.ads.internal.client.zzbu zzb;
    private final zzfck zzc;
    private boolean zzd = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzaG)).booleanValue();
    private final zzdwf zze;

    public zzcua(zzctz zzctzVar, com.google.android.gms.ads.internal.client.zzbu zzbuVar, zzfck zzfckVar, zzdwf zzdwfVar) {
        this.zza = zzctzVar;
        this.zzb = zzbuVar;
        this.zzc = zzfckVar;
        this.zze = zzdwfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbaj
    public final com.google.android.gms.ads.internal.client.zzbu zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbaj
    @Nullable
    public final com.google.android.gms.ads.internal.client.zzdn zzf() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgN)).booleanValue()) {
            return this.zza.zzl();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbaj
    public final void zzg(boolean z11) {
        this.zzd = z11;
    }

    @Override // com.google.android.gms.internal.ads.zzbaj
    public final void zzh(com.google.android.gms.ads.internal.client.zzdg zzdgVar) {
        Preconditions.checkMainThread("setOnPaidEventListener must be called on the main UI thread.");
        if (this.zzc != null) {
            try {
                if (!zzdgVar.zzf()) {
                    this.zze.zze();
                }
            } catch (RemoteException e11) {
                zzcec.zzf("Error in making CSI ping for reporting paid event callback", e11);
            }
            this.zzc.zzn(zzdgVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbaj
    public final void zzi(IObjectWrapper iObjectWrapper, zzbaq zzbaqVar) {
        try {
            this.zzc.zzq(zzbaqVar);
            this.zza.zzd((Activity) ObjectWrapper.unwrap(iObjectWrapper), zzbaqVar, this.zzd);
        } catch (RemoteException e11) {
            zzcec.zzl("#007 Could not call remote method.", e11);
        }
    }
}
