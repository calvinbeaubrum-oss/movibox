package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzebo extends zzebq {
    public zzebo(Context context) {
        this.zzf = new zzbye(context, com.google.android.gms.ads.internal.zzt.zzt().zzb(), this, this);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        synchronized (this.zzb) {
            try {
                if (!this.zzd) {
                    this.zzd = true;
                    try {
                        try {
                            this.zzf.zzp().zzg(this.zze, new zzebp(this));
                        } catch (RemoteException | IllegalArgumentException unused) {
                            this.zza.zzd(new zzecf(1));
                        }
                    } catch (Throwable th2) {
                        com.google.android.gms.ads.internal.zzt.zzo().zzw(th2, "RemoteAdRequestClientTask.onConnected");
                        this.zza.zzd(new zzecf(1));
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzebq, com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        zzcec.zze("Cannot connect to remote service, fallback to local instance.");
        this.zza.zzd(new zzecf(1));
    }
}
