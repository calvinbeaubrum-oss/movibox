package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbav implements BaseGmsClient.BaseConnectionCallbacks {
    final /* synthetic */ zzbax zza;

    public zzbav(zzbax zzbaxVar) {
        this.zza = zzbaxVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(@Nullable Bundle bundle) {
        synchronized (this.zza.zzc) {
            try {
                zzbax zzbaxVar = this.zza;
                if (zzbaxVar.zzd != null) {
                    zzbaxVar.zzf = zzbaxVar.zzd.zzq();
                }
            } catch (DeadObjectException e11) {
                zzcec.zzh("Unable to obtain a cache service instance.", e11);
                zzbax.zzh(this.zza);
            }
            this.zza.zzc.notifyAll();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i11) {
        synchronized (this.zza.zzc) {
            this.zza.zzf = null;
            this.zza.zzc.notifyAll();
        }
    }
}
