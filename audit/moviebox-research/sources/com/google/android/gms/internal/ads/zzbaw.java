package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbaw implements BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzbax zza;

    public zzbaw(zzbax zzbaxVar) {
        this.zza = zzbaxVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        synchronized (this.zza.zzc) {
            try {
                this.zza.zzf = null;
                zzbax zzbaxVar = this.zza;
                if (zzbaxVar.zzd != null) {
                    zzbaxVar.zzd = null;
                }
                this.zza.zzc.notifyAll();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
