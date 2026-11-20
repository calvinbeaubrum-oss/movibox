package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.Trace;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@SuppressLint({"HandlerLeak"})
final class zzzf extends Handler implements Runnable {
    final /* synthetic */ zzzk zza;
    private final zzzg zzb;
    private final long zzc;

    @Nullable
    private zzzc zzd;

    @Nullable
    private IOException zze;
    private int zzf;

    @Nullable
    private Thread zzg;
    private boolean zzh;
    private volatile boolean zzi;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzzf(zzzk zzzkVar, Looper looper, zzzg zzzgVar, zzzc zzzcVar, int i11, long j11) {
        super(looper);
        this.zza = zzzkVar;
        this.zzb = zzzgVar;
        this.zzd = zzzcVar;
        this.zzc = j11;
    }

    private final void zzd() {
        this.zze = null;
        zzzk zzzkVar = this.zza;
        ExecutorService executorService = zzzkVar.zze;
        zzzf zzzfVar = zzzkVar.zzf;
        zzzfVar.getClass();
        executorService.execute(zzzfVar);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.zzi) {
            return;
        }
        int i11 = message.what;
        if (i11 == 0) {
            zzd();
            return;
        }
        if (i11 == 3) {
            throw ((Error) message.obj);
        }
        this.zza.zzf = null;
        long j11 = this.zzc;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j12 = jElapsedRealtime - j11;
        zzzc zzzcVar = this.zzd;
        zzzcVar.getClass();
        if (this.zzh) {
            zzzcVar.zzJ(this.zzb, jElapsedRealtime, j12, false);
            return;
        }
        int i12 = message.what;
        if (i12 == 1) {
            try {
                zzzcVar.zzK(this.zzb, jElapsedRealtime, j12);
                return;
            } catch (RuntimeException e11) {
                zzff.zzd("LoadTask", "Unexpected exception handling load completed", e11);
                this.zza.zzg = new zzzj(e11);
                return;
            }
        }
        if (i12 != 2) {
            return;
        }
        IOException iOException = (IOException) message.obj;
        this.zze = iOException;
        int i13 = this.zzf + 1;
        this.zzf = i13;
        zzze zzzeVarZzu = zzzcVar.zzu(this.zzb, jElapsedRealtime, j12, iOException, i13);
        if (zzzeVarZzu.zza == 3) {
            this.zza.zzg = this.zze;
        } else if (zzzeVarZzu.zza != 2) {
            if (zzzeVarZzu.zza == 1) {
                this.zzf = 1;
            }
            zzc(zzzeVarZzu.zzb != C.TIME_UNSET ? zzzeVarZzu.zzb : Math.min((this.zzf - 1) * 1000, 5000));
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z11;
        try {
            synchronized (this) {
                z11 = !this.zzh;
                this.zzg = Thread.currentThread();
            }
            if (z11) {
                String str = "load:" + this.zzb.getClass().getSimpleName();
                int i11 = zzfy.zza;
                Trace.beginSection(str);
                try {
                    this.zzb.zzh();
                    Trace.endSection();
                } catch (Throwable th2) {
                    Trace.endSection();
                    throw th2;
                }
            }
            synchronized (this) {
                this.zzg = null;
                Thread.interrupted();
            }
            if (this.zzi) {
                return;
            }
            sendEmptyMessage(1);
        } catch (IOException e11) {
            if (this.zzi) {
                return;
            }
            obtainMessage(2, e11).sendToTarget();
        } catch (Exception e12) {
            if (this.zzi) {
                return;
            }
            zzff.zzd("LoadTask", "Unexpected exception loading stream", e12);
            obtainMessage(2, new zzzj(e12)).sendToTarget();
        } catch (OutOfMemoryError e13) {
            if (this.zzi) {
                return;
            }
            zzff.zzd("LoadTask", "OutOfMemory error loading stream", e13);
            obtainMessage(2, new zzzj(e13)).sendToTarget();
        } catch (Error e14) {
            if (!this.zzi) {
                zzff.zzd("LoadTask", "Unexpected error loading stream", e14);
                obtainMessage(3, e14).sendToTarget();
            }
            throw e14;
        }
    }

    public final void zza(boolean z11) {
        this.zzi = z11;
        this.zze = null;
        if (hasMessages(0)) {
            this.zzh = true;
            removeMessages(0);
            if (!z11) {
                sendEmptyMessage(1);
            }
        } else {
            synchronized (this) {
                try {
                    this.zzh = true;
                    this.zzb.zzg();
                    Thread thread = this.zzg;
                    if (thread != null) {
                        thread.interrupt();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (z11) {
            this.zza.zzf = null;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            zzzc zzzcVar = this.zzd;
            zzzcVar.getClass();
            zzzcVar.zzJ(this.zzb, jElapsedRealtime, jElapsedRealtime - this.zzc, true);
            this.zzd = null;
        }
    }

    public final void zzb(int i11) throws IOException {
        IOException iOException = this.zze;
        if (iOException != null && this.zzf > i11) {
            throw iOException;
        }
    }

    public final void zzc(long j11) {
        zzek.zzf(this.zza.zzf == null);
        this.zza.zzf = this;
        if (j11 > 0) {
            sendEmptyMessageDelayed(0, j11);
        } else {
            zzd();
        }
    }
}
