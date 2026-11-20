package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeqi implements com.google.android.gms.ads.internal.client.zza, zzdiu {
    private com.google.android.gms.ads.internal.client.zzbe zza;

    @Override // com.google.android.gms.ads.internal.client.zza
    public final synchronized void onAdClicked() {
        com.google.android.gms.ads.internal.client.zzbe zzbeVar = this.zza;
        if (zzbeVar != null) {
            try {
                zzbeVar.zzb();
            } catch (RemoteException e11) {
                zzcec.zzk("Remote Exception at onAdClicked.", e11);
            }
        }
    }

    public final synchronized void zza(com.google.android.gms.ads.internal.client.zzbe zzbeVar) {
        this.zza = zzbeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdiu
    public final synchronized void zzbo() {
    }

    @Override // com.google.android.gms.internal.ads.zzdiu
    public final synchronized void zzs() {
        com.google.android.gms.ads.internal.client.zzbe zzbeVar = this.zza;
        if (zzbeVar != null) {
            try {
                zzbeVar.zzb();
            } catch (RemoteException e11) {
                zzcec.zzk("Remote Exception at onPhysicalClick.", e11);
            }
        }
    }
}
