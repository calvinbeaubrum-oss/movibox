package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.facebook.ads.AdError;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzfra implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    protected final zzfry zza;
    private final String zzb;
    private final String zzc;
    private final LinkedBlockingQueue zzd;
    private final HandlerThread zze;
    private final zzfqr zzf;
    private final long zzg;
    private final int zzh;

    public zzfra(Context context, int i11, int i12, String str, String str2, String str3, zzfqr zzfqrVar) {
        this.zzb = str;
        this.zzh = i12;
        this.zzc = str2;
        this.zzf = zzfqrVar;
        HandlerThread handlerThread = new HandlerThread("GassDGClient");
        this.zze = handlerThread;
        handlerThread.start();
        this.zzg = System.currentTimeMillis();
        zzfry zzfryVar = new zzfry(context, handlerThread.getLooper(), this, this, 19621000);
        this.zza = zzfryVar;
        this.zzd = new LinkedBlockingQueue();
        zzfryVar.checkAvailabilityAndConnect();
    }

    public static zzfsk zza() {
        return new zzfsk(null, 1);
    }

    private final void zze(int i11, long j11, Exception exc) {
        this.zzf.zzc(i11, System.currentTimeMillis() - j11, exc);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzfsd zzfsdVarZzd = zzd();
        if (zzfsdVarZzd != null) {
            try {
                zzfsk zzfskVarZzf = zzfsdVarZzd.zzf(new zzfsi(1, this.zzh, this.zzb, this.zzc));
                zze(5011, this.zzg, null);
                this.zzd.put(zzfskVarZzf);
            } catch (Throwable th2) {
                try {
                    zze(2010, this.zzg, new Exception(th2));
                } finally {
                    zzc();
                    this.zze.quit();
                }
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            zze(TaErrorCode.CODE_LOAD_FAILED_CAUSE_DESTROY, this.zzg, null);
            this.zzd.put(zza());
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i11) {
        try {
            zze(TaErrorCode.CODE_AD_UNIT_CONFIG_IS_EMPTY, this.zzg, null);
            this.zzd.put(zza());
        } catch (InterruptedException unused) {
        }
    }

    public final zzfsk zzb(int i11) {
        zzfsk zzfskVar;
        try {
            zzfskVar = (zzfsk) this.zzd.poll(50000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e11) {
            zze(AdError.INTERSTITIAL_AD_TIMEOUT, this.zzg, e11);
            zzfskVar = null;
        }
        zze(3004, this.zzg, null);
        if (zzfskVar != null) {
            if (zzfskVar.zzc == 7) {
                zzfqr.zzg(3);
            } else {
                zzfqr.zzg(2);
            }
        }
        return zzfskVar == null ? zza() : zzfskVar;
    }

    public final void zzc() {
        zzfry zzfryVar = this.zza;
        if (zzfryVar != null) {
            if (zzfryVar.isConnected() || this.zza.isConnecting()) {
                this.zza.disconnect();
            }
        }
    }

    public final zzfsd zzd() {
        try {
            return this.zza.zzp();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }
}
