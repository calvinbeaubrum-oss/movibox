package com.google.android.gms.measurement.internal;

import android.os.Process;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzfn extends Thread {
    final /* synthetic */ zzfo zza;
    private final Object zzb;
    private final BlockingQueue zzc;
    private boolean zzd = false;

    public zzfn(zzfo zzfoVar, String str, BlockingQueue blockingQueue) {
        this.zza = zzfoVar;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(blockingQueue);
        this.zzb = new Object();
        this.zzc = blockingQueue;
        setName(str);
    }

    private final void zzb() {
        synchronized (this.zza.zzh) {
            try {
                if (!this.zzd) {
                    this.zza.zzi.release();
                    this.zza.zzh.notifyAll();
                    zzfo zzfoVar = this.zza;
                    if (this == zzfoVar.zzb) {
                        zzfoVar.zzb = null;
                    } else if (this == zzfoVar.zzc) {
                        zzfoVar.zzc = null;
                    } else {
                        zzfoVar.zzt.zzay().zzd().zza("Current scheduler thread is neither worker nor network");
                    }
                    this.zzd = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private final void zzc(InterruptedException interruptedException) {
        this.zza.zzt.zzay().zzk().zzb(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        boolean z11 = false;
        while (!z11) {
            try {
                this.zza.zzi.acquire();
                z11 = true;
            } catch (InterruptedException e11) {
                zzc(e11);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                zzfm zzfmVar = (zzfm) this.zzc.poll();
                if (zzfmVar != null) {
                    Process.setThreadPriority(true != zzfmVar.zza ? 10 : threadPriority);
                    zzfmVar.run();
                } else {
                    synchronized (this.zzb) {
                        if (this.zzc.peek() == null) {
                            zzfo.zzr(this.zza);
                            try {
                                this.zzb.wait(30000L);
                            } catch (InterruptedException e12) {
                                zzc(e12);
                            }
                        }
                    }
                    synchronized (this.zza.zzh) {
                        if (this.zzc.peek() == null) {
                            zzb();
                            zzb();
                            return;
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            zzb();
            throw th2;
        }
    }

    public final void zza() {
        synchronized (this.zzb) {
            this.zzb.notifyAll();
        }
    }
}
