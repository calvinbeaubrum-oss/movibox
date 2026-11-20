package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.common.util.concurrent.s;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzebs extends zzebq {
    public zzebs(Context context) {
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
                            this.zzf.zzp().zzf(this.zze, new zzebp(this));
                        } catch (RemoteException | IllegalArgumentException unused) {
                            this.zza.zzd(new zzecf(1));
                        }
                    } catch (Throwable th2) {
                        com.google.android.gms.ads.internal.zzt.zzo().zzw(th2, "RemoteSignalsClientTask.onConnected");
                        this.zza.zzd(new zzecf(1));
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public final s zzb(zzbze zzbzeVar) {
        synchronized (this.zzb) {
            try {
                if (this.zzc) {
                    return this.zza;
                }
                this.zzc = true;
                this.zze = zzbzeVar;
                this.zzf.checkAvailabilityAndConnect();
                this.zza.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzebr
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zza();
                    }
                }, zzcep.zzf);
                return this.zza;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
