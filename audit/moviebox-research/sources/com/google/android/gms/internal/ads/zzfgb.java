package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzfgb implements OnAdMetadataChangedListener {
    final /* synthetic */ com.google.android.gms.ads.internal.client.zzdd zza;
    final /* synthetic */ zzfgd zzb;

    public zzfgb(zzfgd zzfgdVar, com.google.android.gms.ads.internal.client.zzdd zzddVar) {
        this.zza = zzddVar;
        this.zzb = zzfgdVar;
    }

    @Override // com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener
    public final void onAdMetadataChanged() {
        if (this.zzb.zzi != null) {
            try {
                this.zza.zze();
            } catch (RemoteException e11) {
                zzcec.zzl("#007 Could not call remote method.", e11);
            }
        }
    }
}
