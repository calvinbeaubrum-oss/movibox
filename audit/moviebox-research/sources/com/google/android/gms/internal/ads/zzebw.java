package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.common.util.concurrent.s;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzebw extends zzebq {
    private String zzg;
    private int zzh = 1;

    public zzebw(Context context) {
        this.zzf = new zzbye(context, com.google.android.gms.ads.internal.zzt.zzt().zzb(), this, this);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(@Nullable Bundle bundle) {
        synchronized (this.zzb) {
            try {
                if (!this.zzd) {
                    this.zzd = true;
                    try {
                        int i11 = this.zzh;
                        if (i11 == 2) {
                            this.zzf.zzp().zze(this.zze, new zzebp(this));
                        } else if (i11 == 3) {
                            this.zzf.zzp().zzh(this.zzg, new zzebp(this));
                        } else {
                            this.zza.zzd(new zzecf(1));
                        }
                    } catch (RemoteException | IllegalArgumentException unused) {
                        this.zza.zzd(new zzecf(1));
                    } catch (Throwable th2) {
                        com.google.android.gms.ads.internal.zzt.zzo().zzw(th2, "RemoteUrlAndCacheKeyClientTask.onConnected");
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

    public final s zzb(zzbze zzbzeVar) {
        synchronized (this.zzb) {
            try {
                int i11 = this.zzh;
                if (i11 != 1 && i11 != 2) {
                    return zzgen.zzg(new zzecf(2));
                }
                if (this.zzc) {
                    return this.zza;
                }
                this.zzh = 2;
                this.zzc = true;
                this.zze = zzbzeVar;
                this.zzf.checkAvailabilityAndConnect();
                this.zza.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzebu
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

    public final s zzc(String str) {
        synchronized (this.zzb) {
            try {
                int i11 = this.zzh;
                if (i11 != 1 && i11 != 3) {
                    return zzgen.zzg(new zzecf(2));
                }
                if (this.zzc) {
                    return this.zza;
                }
                this.zzh = 3;
                this.zzc = true;
                this.zzg = str;
                this.zzf.checkAvailabilityAndConnect();
                this.zza.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzebv
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
