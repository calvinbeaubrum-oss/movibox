package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterscrollerAd;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbuy implements MediationAdLoadCallback {
    final /* synthetic */ zzbug zza;
    final /* synthetic */ zzbtb zzb;

    public zzbuy(zzbve zzbveVar, zzbug zzbugVar, zzbtb zzbtbVar) {
        this.zza = zzbugVar;
        this.zzb = zzbtbVar;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(AdError adError) {
        try {
            this.zza.zzf(adError.zza());
        } catch (RemoteException e11) {
            zzcec.zzh("", e11);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(String str) {
        onFailure(new AdError(0, str, AdError.UNDEFINED_DOMAIN));
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    @Nullable
    public final /* bridge */ /* synthetic */ Object onSuccess(Object obj) {
        MediationInterscrollerAd mediationInterscrollerAd = (MediationInterscrollerAd) obj;
        if (mediationInterscrollerAd != null) {
            try {
                this.zza.zzh(new zzbtw(mediationInterscrollerAd));
            } catch (RemoteException e11) {
                zzcec.zzh("", e11);
            }
            return new zzbvf(this.zzb);
        }
        zzcec.zzj("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
        try {
            this.zza.zze("Adapter returned null.");
            return null;
        } catch (RemoteException e12) {
            zzcec.zzh("", e12);
            return null;
        }
    }
}
