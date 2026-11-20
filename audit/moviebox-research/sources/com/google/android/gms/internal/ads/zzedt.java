package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.common.util.concurrent.s;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzedt extends zzedw {
    private zzbyi zzh;

    public zzedt(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.zze = context;
        this.zzf = com.google.android.gms.ads.internal.zzt.zzt().zzb();
        this.zzg = scheduledExecutorService;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final synchronized void onConnected(@Nullable Bundle bundle) {
        if (this.zzc) {
            return;
        }
        this.zzc = true;
        try {
            this.zzd.zzp().zzf(this.zzh, new zzedv(this));
        } catch (RemoteException unused) {
            this.zza.zzd(new zzecf(1));
        } catch (Throwable th2) {
            com.google.android.gms.ads.internal.zzt.zzo().zzw(th2, "RemoteAdsServiceSignalClientTask.onConnected");
            this.zza.zzd(th2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzedw, com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i11) {
        String str = String.format(Locale.US, "Remote ad service connection suspended, cause: %d.", Integer.valueOf(i11));
        zzcec.zze(str);
        this.zza.zzd(new zzecf(1, str));
    }

    public final synchronized s zza(zzbyi zzbyiVar, long j11) {
        if (this.zzb) {
            return zzgen.zzo(this.zza, j11, TimeUnit.MILLISECONDS, this.zzg);
        }
        this.zzb = true;
        this.zzh = zzbyiVar;
        zzb();
        s sVarZzo = zzgen.zzo(this.zza, j11, TimeUnit.MILLISECONDS, this.zzg);
        sVarZzo.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeds
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzc();
            }
        }, zzcep.zzf);
        return sVarZzo;
    }
}
