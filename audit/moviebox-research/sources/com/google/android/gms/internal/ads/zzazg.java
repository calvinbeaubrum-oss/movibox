package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzazg {
    int zza;
    private final Object zzb = new Object();
    private final List zzc = new LinkedList();

    @Nullable
    public final zzazf zza(boolean z11) {
        synchronized (this.zzb) {
            try {
                zzazf zzazfVar = null;
                if (this.zzc.isEmpty()) {
                    zzcec.zze("Queue empty");
                    return null;
                }
                int i11 = 0;
                if (this.zzc.size() < 2) {
                    zzazf zzazfVar2 = (zzazf) this.zzc.get(0);
                    if (z11) {
                        this.zzc.remove(0);
                    } else {
                        zzazfVar2.zzi();
                    }
                    return zzazfVar2;
                }
                int i12 = Integer.MIN_VALUE;
                int i13 = 0;
                for (zzazf zzazfVar3 : this.zzc) {
                    int iZzb = zzazfVar3.zzb();
                    if (iZzb > i12) {
                        i11 = i13;
                    }
                    int i14 = iZzb > i12 ? iZzb : i12;
                    if (iZzb > i12) {
                        zzazfVar = zzazfVar3;
                    }
                    i13++;
                    i12 = i14;
                }
                this.zzc.remove(i11);
                return zzazfVar;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void zzb(zzazf zzazfVar) {
        synchronized (this.zzb) {
            try {
                if (this.zzc.size() >= 10) {
                    zzcec.zze("Queue is full, current size = " + this.zzc.size());
                    this.zzc.remove(0);
                }
                int i11 = this.zza;
                this.zza = i11 + 1;
                zzazfVar.zzj(i11);
                zzazfVar.zzn();
                this.zzc.add(zzazfVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean zzc(zzazf zzazfVar) {
        synchronized (this.zzb) {
            try {
                Iterator it = this.zzc.iterator();
                while (it.hasNext()) {
                    zzazf zzazfVar2 = (zzazf) it.next();
                    if (com.google.android.gms.ads.internal.zzt.zzo().zzi().zzN()) {
                        if (!com.google.android.gms.ads.internal.zzt.zzo().zzi().zzO() && !zzazfVar.equals(zzazfVar2) && zzazfVar2.zzf().equals(zzazfVar.zzf())) {
                            it.remove();
                            return true;
                        }
                    } else if (!zzazfVar.equals(zzazfVar2) && zzazfVar2.zzd().equals(zzazfVar.zzd())) {
                        it.remove();
                        return true;
                    }
                }
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean zzd(zzazf zzazfVar) {
        synchronized (this.zzb) {
            try {
                return this.zzc.contains(zzazfVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
