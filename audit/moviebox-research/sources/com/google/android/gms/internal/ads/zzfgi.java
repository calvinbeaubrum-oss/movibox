package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzfgi implements OnAdMetadataChangedListener {
    final /* synthetic */ com.google.android.gms.ads.internal.client.zzby zza;
    final /* synthetic */ zzfgj zzb;

    public zzfgi(zzfgj zzfgjVar, com.google.android.gms.ads.internal.client.zzby zzbyVar) {
        this.zza = zzbyVar;
        this.zzb = zzfgjVar;
    }

    @Override // com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener
    public final void onAdMetadataChanged() {
        if (this.zzb.zzd != null) {
            try {
                this.zza.zze();
            } catch (RemoteException e11) {
                zzcec.zzl("#007 Could not call remote method.", e11);
            }
        }
    }
}
