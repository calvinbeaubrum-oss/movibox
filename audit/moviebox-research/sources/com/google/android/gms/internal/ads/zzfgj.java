package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfgj extends zzbzw {
    private final zzffz zza;
    private final zzffp zzb;
    private final zzfgz zzc;

    @Nullable
    private zzdso zzd;
    private boolean zze = false;

    public zzfgj(zzffz zzffzVar, zzffp zzffpVar, zzfgz zzfgzVar) {
        this.zza = zzffzVar;
        this.zzb = zzffpVar;
        this.zzc = zzfgzVar;
    }

    private final synchronized boolean zzy() {
        zzdso zzdsoVar = this.zzd;
        return (zzdsoVar == null || zzdsoVar.zze()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzbzx
    public final Bundle zzb() {
        Preconditions.checkMainThread("getAdMetadata can only be called from the UI thread.");
        zzdso zzdsoVar = this.zzd;
        return zzdsoVar != null ? zzdsoVar.zza() : new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzbzx
    @Nullable
    public final synchronized com.google.android.gms.ads.internal.client.zzdn zzc() throws RemoteException {
        zzdso zzdsoVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgN)).booleanValue() && (zzdsoVar = this.zzd) != null) {
            return zzdsoVar.zzl();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbzx
    @Nullable
    public final synchronized String zzd() throws RemoteException {
        zzdso zzdsoVar = this.zzd;
        if (zzdsoVar == null || zzdsoVar.zzl() == null) {
            return null;
        }
        return zzdsoVar.zzl().zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzbzx
    public final void zze() throws RemoteException {
        zzf(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbzx
    public final synchronized void zzf(IObjectWrapper iObjectWrapper) {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        Context context = null;
        this.zzb.zzg(null);
        if (this.zzd != null) {
            if (iObjectWrapper != null) {
                context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            }
            this.zzd.zzm().zza(context);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0042, code lost:
    
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbgc.zzfr)).booleanValue() == false) goto L18;
     */
    @Override // com.google.android.gms.internal.ads.zzbzx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void zzg(zzcab zzcabVar) throws RemoteException {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        String str = zzcabVar.zzb;
        String str2 = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfp);
        if (str2 != null && str != null) {
            try {
                if (!Pattern.matches(str2, str)) {
                }
            } catch (RuntimeException e11) {
                com.google.android.gms.ads.internal.zzt.zzo().zzw(e11, "NonagonUtil.isPatternMatched");
            }
            return;
        }
        if (zzy()) {
        }
        zzffr zzffrVar = new zzffr(null);
        this.zzd = null;
        this.zza.zzj(1);
        this.zza.zzb(zzcabVar.zza, zzcabVar.zzb, zzffrVar, new zzfgh(this));
    }

    @Override // com.google.android.gms.internal.ads.zzbzx
    public final void zzh() {
        zzi(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbzx
    public final synchronized void zzi(IObjectWrapper iObjectWrapper) {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        if (this.zzd != null) {
            this.zzd.zzm().zzb(iObjectWrapper == null ? null : (Context) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzx
    public final void zzj() {
        zzk(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbzx
    public final synchronized void zzk(IObjectWrapper iObjectWrapper) {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        if (this.zzd != null) {
            this.zzd.zzm().zzc(iObjectWrapper == null ? null : (Context) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzx
    public final void zzl(com.google.android.gms.ads.internal.client.zzby zzbyVar) {
        Preconditions.checkMainThread("setAdMetadataListener can only be called from the UI thread.");
        if (zzbyVar == null) {
            this.zzb.zzg(null);
        } else {
            this.zzb.zzg(new zzfgi(this, zzbyVar));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzx
    public final synchronized void zzm(String str) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setCustomData");
        this.zzc.zzb = str;
    }

    @Override // com.google.android.gms.internal.ads.zzbzx
    public final synchronized void zzn(boolean z11) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zze = z11;
    }

    @Override // com.google.android.gms.internal.ads.zzbzx
    public final void zzo(zzcaa zzcaaVar) throws RemoteException {
        Preconditions.checkMainThread("setRewardedVideoAdListener can only be called from the UI thread.");
        this.zzb.zzm(zzcaaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbzx
    public final synchronized void zzp(String str) throws RemoteException {
        Preconditions.checkMainThread("setUserId must be called on the main UI thread.");
        this.zzc.zza = str;
    }

    @Override // com.google.android.gms.internal.ads.zzbzx
    public final synchronized void zzq() throws RemoteException {
        zzr(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbzx
    public final synchronized void zzr(@Nullable IObjectWrapper iObjectWrapper) throws RemoteException {
        try {
            Preconditions.checkMainThread("showAd must be called on the main UI thread.");
            if (this.zzd != null) {
                Activity activity = null;
                if (iObjectWrapper != null) {
                    Object objUnwrap = ObjectWrapper.unwrap(iObjectWrapper);
                    if (objUnwrap instanceof Activity) {
                        activity = (Activity) objUnwrap;
                    }
                }
                this.zzd.zzh(this.zze, activity);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzx
    public final boolean zzs() throws RemoteException {
        Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
        return zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzbzx
    public final boolean zzt() {
        zzdso zzdsoVar = this.zzd;
        return zzdsoVar != null && zzdsoVar.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzbzx
    public final void zzu(zzbzv zzbzvVar) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setRewardedAdSkuListener");
        this.zzb.zzn(zzbzvVar);
    }
}
