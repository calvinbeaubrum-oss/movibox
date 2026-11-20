package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzedw implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    protected final zzceu zza = new zzceu();
    protected boolean zzb = false;
    protected boolean zzc = false;
    protected zzbyh zzd;
    protected Context zze;
    protected Looper zzf;
    protected ScheduledExecutorService zzg;

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        String str = String.format(Locale.US, "Remote ad service connection failed, cause: %d.", Integer.valueOf(connectionResult.getErrorCode()));
        zzcec.zze(str);
        this.zza.zzd(new zzecf(1, str));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public void onConnectionSuspended(int i11) {
        String str = String.format(Locale.US, "Remote ad service connection suspended, cause: %d.", Integer.valueOf(i11));
        zzcec.zze(str);
        this.zza.zzd(new zzecf(1, str));
    }

    public final synchronized void zzb() {
        try {
            if (this.zzd == null) {
                this.zzd = new zzbyh(this.zze, this.zzf, this, this);
            }
            this.zzd.checkAvailabilityAndConnect();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void zzc() {
        try {
            this.zzc = true;
            zzbyh zzbyhVar = this.zzd;
            if (zzbyhVar == null) {
                return;
            }
            if (zzbyhVar.isConnected() || this.zzd.isConnecting()) {
                this.zzd.disconnect();
            }
            Binder.flushPendingCommands();
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
