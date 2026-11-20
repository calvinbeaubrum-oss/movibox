package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzyu {
    private final CopyOnWriteArrayList zza = new CopyOnWriteArrayList();

    public final void zza(Handler handler, zzyv zzyvVar) {
        zzc(zzyvVar);
        this.zza.add(new zzyt(handler, zzyvVar));
    }

    public final void zzb(final int i11, final long j11, final long j12) {
        for (final zzyt zzytVar : this.zza) {
            if (!zzytVar.zzc) {
                zzytVar.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzys
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzytVar.zzb.zzX(i11, j11, j12);
                    }
                });
            }
        }
    }

    public final void zzc(zzyv zzyvVar) {
        for (zzyt zzytVar : this.zza) {
            if (zzytVar.zzb == zzyvVar) {
                zzytVar.zzc();
                this.zza.remove(zzytVar);
            }
        }
    }
}
