package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.s;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzgdm extends zzgds {
    private static final zzgex zza = new zzgex(zzgdm.class);
    private zzfzv zzb;
    private final boolean zzc;
    private final boolean zzf;

    public zzgdm(zzfzv zzfzvVar, boolean z11, boolean z12) {
        super(zzfzvVar.size());
        this.zzb = zzfzvVar;
        this.zzc = z11;
        this.zzf = z12;
    }

    private final void zzG(int i11, Future future) {
        try {
            zzf(i11, zzgen.zzp(future));
        } catch (ExecutionException e11) {
            zzI(e11.getCause());
        } catch (Throwable th2) {
            zzI(th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzH, reason: merged with bridge method [inline-methods] */
    public final void zzx(zzfzv zzfzvVar) {
        int iZzA = zzA();
        int i11 = 0;
        zzfxe.zzj(iZzA >= 0, "Less than 0 remaining futures");
        if (iZzA == 0) {
            if (zzfzvVar != null) {
                zzgce it = zzfzvVar.iterator();
                while (it.hasNext()) {
                    Future future = (Future) it.next();
                    if (!future.isCancelled()) {
                        zzG(i11, future);
                    }
                    i11++;
                }
            }
            zzF();
            zzu();
            zzy(2);
        }
    }

    private final void zzI(Throwable th2) {
        th2.getClass();
        if (this.zzc && !zzd(th2) && zzK(zzC(), th2)) {
            zzJ(th2);
        } else if (th2 instanceof Error) {
            zzJ(th2);
        }
    }

    private static void zzJ(Throwable th2) {
        zza.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFuture", "log", true != (th2 instanceof Error) ? "Got more than one input Future failure. Logging failures after the first" : "Input Future failed with Error", th2);
    }

    private static boolean zzK(Set set, Throwable th2) {
        while (th2 != null) {
            if (!set.add(th2)) {
                return false;
            }
            th2 = th2.getCause();
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzgdb
    public final String zza() {
        zzfzv zzfzvVar = this.zzb;
        return zzfzvVar != null ? "futures=".concat(zzfzvVar.toString()) : super.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzgdb
    public final void zzb() {
        zzfzv zzfzvVar = this.zzb;
        zzy(1);
        if ((zzfzvVar != null) && isCancelled()) {
            boolean zZzt = zzt();
            zzgce it = zzfzvVar.iterator();
            while (it.hasNext()) {
                ((Future) it.next()).cancel(zZzt);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgds
    public final void zze(Set set) {
        set.getClass();
        if (isCancelled()) {
            return;
        }
        Throwable thZzl = zzl();
        Objects.requireNonNull(thZzl);
        zzK(set, thZzl);
    }

    public abstract void zzf(int i11, Object obj);

    public abstract void zzu();

    public final void zzv() {
        Objects.requireNonNull(this.zzb);
        if (this.zzb.isEmpty()) {
            zzu();
            return;
        }
        if (!this.zzc) {
            final zzfzv zzfzvVar = this.zzf ? this.zzb : null;
            Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzgdl
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzx(zzfzvVar);
                }
            };
            zzgce it = this.zzb.iterator();
            while (it.hasNext()) {
                ((s) it.next()).addListener(runnable, zzgeb.INSTANCE);
            }
            return;
        }
        zzgce it2 = this.zzb.iterator();
        final int i11 = 0;
        while (it2.hasNext()) {
            final s sVar = (s) it2.next();
            sVar.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzgdk
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzw(sVar, i11);
                }
            }, zzgeb.INSTANCE);
            i11++;
        }
    }

    public final /* synthetic */ void zzw(s sVar, int i11) {
        try {
            if (sVar.isCancelled()) {
                this.zzb = null;
                cancel(false);
            } else {
                zzG(i11, sVar);
            }
        } finally {
            zzx(null);
        }
    }

    public void zzy(int i11) {
        this.zzb = null;
    }
}
