package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.VideoController;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdsj extends VideoController.VideoLifecycleCallbacks {
    private final zzdna zza;

    public zzdsj(zzdna zzdnaVar) {
        this.zza = zzdnaVar;
    }

    @Nullable
    private static com.google.android.gms.ads.internal.client.zzdt zza(zzdna zzdnaVar) {
        com.google.android.gms.ads.internal.client.zzdq zzdqVarZzj = zzdnaVar.zzj();
        if (zzdqVarZzj == null) {
            return null;
        }
        try {
            return zzdqVarZzj.zzi();
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
    public final void onVideoEnd() {
        com.google.android.gms.ads.internal.client.zzdt zzdtVarZza = zza(this.zza);
        if (zzdtVarZza == null) {
            return;
        }
        try {
            zzdtVarZza.zze();
        } catch (RemoteException e11) {
            zzcec.zzk("Unable to call onVideoEnd()", e11);
        }
    }

    @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
    public final void onVideoPause() {
        com.google.android.gms.ads.internal.client.zzdt zzdtVarZza = zza(this.zza);
        if (zzdtVarZza == null) {
            return;
        }
        try {
            zzdtVarZza.zzg();
        } catch (RemoteException e11) {
            zzcec.zzk("Unable to call onVideoEnd()", e11);
        }
    }

    @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
    public final void onVideoStart() {
        com.google.android.gms.ads.internal.client.zzdt zzdtVarZza = zza(this.zza);
        if (zzdtVarZza == null) {
            return;
        }
        try {
            zzdtVarZza.zzi();
        } catch (RemoteException e11) {
            zzcec.zzk("Unable to call onVideoEnd()", e11);
        }
    }
}
