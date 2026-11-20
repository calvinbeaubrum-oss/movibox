package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzaql {
    public static final boolean zza = zzaqm.zzb;
    private final List zzb = new ArrayList();
    private boolean zzc = false;

    public final void finalize() throws Throwable {
        if (this.zzc) {
            return;
        }
        zzb("Request on the loose");
        zzaqm.zzb("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
    }

    public final synchronized void zza(String str, long j11) {
        if (this.zzc) {
            throw new IllegalStateException("Marker added to finished log");
        }
        this.zzb.add(new zzaqk(str, j11, SystemClock.elapsedRealtime()));
    }

    public final synchronized void zzb(String str) {
        long j11;
        this.zzc = true;
        if (this.zzb.size() == 0) {
            j11 = 0;
        } else {
            long j12 = ((zzaqk) this.zzb.get(0)).zzc;
            List list = this.zzb;
            j11 = ((zzaqk) list.get(list.size() - 1)).zzc - j12;
        }
        if (j11 > 0) {
            long j13 = ((zzaqk) this.zzb.get(0)).zzc;
            zzaqm.zza("(%-4d ms) %s", Long.valueOf(j11), str);
            for (zzaqk zzaqkVar : this.zzb) {
                long j14 = zzaqkVar.zzc;
                zzaqm.zza("(+%-4d) [%2d] %s", Long.valueOf(j14 - j13), Long.valueOf(zzaqkVar.zzb), zzaqkVar.zza);
                j13 = j14;
            }
        }
    }
}
