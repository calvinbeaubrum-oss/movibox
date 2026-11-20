package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzaai extends HandlerThread implements Handler.Callback {
    private zzer zza;
    private Handler zzb;

    @Nullable
    private Error zzc;

    @Nullable
    private RuntimeException zzd;

    @Nullable
    private zzaak zze;

    public zzaai() {
        super("ExoPlayer:PlaceholderSurface");
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i11 = message.what;
        try {
            if (i11 == 1) {
                try {
                    int i12 = message.arg1;
                    zzer zzerVar = this.zza;
                    zzerVar.getClass();
                    zzerVar.zzb(i12);
                    this.zze = new zzaak(this, this.zza.zza(), i12 != 0, null);
                    synchronized (this) {
                        notify();
                    }
                } catch (zzet e11) {
                    zzff.zzd("PlaceholderSurface", "Failed to initialize placeholder surface", e11);
                    this.zzd = new IllegalStateException(e11);
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e12) {
                    zzff.zzd("PlaceholderSurface", "Failed to initialize placeholder surface", e12);
                    this.zzc = e12;
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e13) {
                    zzff.zzd("PlaceholderSurface", "Failed to initialize placeholder surface", e13);
                    this.zzd = e13;
                    synchronized (this) {
                        notify();
                    }
                }
            } else if (i11 == 2) {
                try {
                    zzer zzerVar2 = this.zza;
                    zzerVar2.getClass();
                    zzerVar2.zzc();
                } catch (Throwable th2) {
                    try {
                        zzff.zzd("PlaceholderSurface", "Failed to release placeholder surface", th2);
                    } finally {
                        quit();
                    }
                }
                return true;
            }
            return true;
        } catch (Throwable th3) {
            synchronized (this) {
                notify();
                throw th3;
            }
        }
    }

    public final zzaak zza(int i11) {
        boolean z11;
        start();
        this.zzb = new Handler(getLooper(), this);
        this.zza = new zzer(this.zzb, null);
        synchronized (this) {
            z11 = false;
            this.zzb.obtainMessage(1, i11, 0).sendToTarget();
            while (this.zze == null && this.zzd == null && this.zzc == null) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    z11 = true;
                }
            }
        }
        if (z11) {
            Thread.currentThread().interrupt();
        }
        RuntimeException runtimeException = this.zzd;
        if (runtimeException != null) {
            throw runtimeException;
        }
        Error error = this.zzc;
        if (error != null) {
            throw error;
        }
        zzaak zzaakVar = this.zze;
        zzaakVar.getClass();
        return zzaakVar;
    }

    public final void zzb() {
        Handler handler = this.zzb;
        handler.getClass();
        handler.sendEmptyMessage(2);
    }
}
