package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbax {
    private ScheduledFuture zza = null;
    private final Runnable zzb = new zzbat(this);
    private final Object zzc = new Object();

    @Nullable
    private zzbba zzd;

    @Nullable
    private Context zze;

    @Nullable
    private zzbbd zzf;

    public static /* bridge */ /* synthetic */ void zzh(zzbax zzbaxVar) {
        synchronized (zzbaxVar.zzc) {
            try {
                zzbba zzbbaVar = zzbaxVar.zzd;
                if (zzbbaVar == null) {
                    return;
                }
                if (zzbbaVar.isConnected() || zzbaxVar.zzd.isConnecting()) {
                    zzbaxVar.zzd.disconnect();
                }
                zzbaxVar.zzd = null;
                zzbaxVar.zzf = null;
                Binder.flushPendingCommands();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzl() {
        synchronized (this.zzc) {
            try {
                if (this.zze != null && this.zzd == null) {
                    zzbba zzbbaVarZzd = zzd(new zzbav(this), new zzbaw(this));
                    this.zzd = zzbbaVarZzd;
                    zzbbaVarZzd.checkAvailabilityAndConnect();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final long zza(zzbbb zzbbbVar) {
        synchronized (this.zzc) {
            try {
                if (this.zzf == null) {
                    return -2L;
                }
                if (this.zzd.zzp()) {
                    try {
                        return this.zzf.zze(zzbbbVar);
                    } catch (RemoteException e11) {
                        zzcec.zzh("Unable to call into cache service.", e11);
                    }
                }
                return -2L;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final zzbay zzb(zzbbb zzbbbVar) {
        synchronized (this.zzc) {
            if (this.zzf == null) {
                return new zzbay();
            }
            try {
                if (this.zzd.zzp()) {
                    return this.zzf.zzg(zzbbbVar);
                }
                return this.zzf.zzf(zzbbbVar);
            } catch (RemoteException e11) {
                zzcec.zzh("Unable to call into cache service.", e11);
                return new zzbay();
            }
        }
    }

    public final synchronized zzbba zzd(BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        return new zzbba(this.zze, com.google.android.gms.ads.internal.zzt.zzt().zzb(), baseConnectionCallbacks, baseOnConnectionFailedListener);
    }

    public final void zzi(Context context) {
        if (context == null) {
            return;
        }
        synchronized (this.zzc) {
            try {
                if (this.zze != null) {
                    return;
                }
                this.zze = context.getApplicationContext();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzef)).booleanValue()) {
                    zzl();
                } else {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzee)).booleanValue()) {
                        com.google.android.gms.ads.internal.zzt.zzb().zzc(new zzbau(this));
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void zzj() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeg)).booleanValue()) {
            synchronized (this.zzc) {
                try {
                    zzl();
                    ScheduledFuture scheduledFuture = this.zza;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(false);
                    }
                    this.zza = zzcep.zzd.schedule(this.zzb, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeh)).longValue(), TimeUnit.MILLISECONDS);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }
}
