package com.google.android.gms.internal.ads;

import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzrs {
    public final int zza;

    @Nullable
    public final zzur zzb;
    private final CopyOnWriteArrayList zzc;

    public zzrs() {
        this(new CopyOnWriteArrayList(), 0, null);
    }

    private zzrs(CopyOnWriteArrayList copyOnWriteArrayList, int i11, @Nullable zzur zzurVar) {
        this.zzc = copyOnWriteArrayList;
        this.zza = 0;
        this.zzb = zzurVar;
    }

    @CheckResult
    public final zzrs zza(int i11, @Nullable zzur zzurVar) {
        return new zzrs(this.zzc, 0, zzurVar);
    }

    public final void zzb(Handler handler, zzrt zzrtVar) {
        this.zzc.add(new zzrr(handler, zzrtVar));
    }

    public final void zzc(zzrt zzrtVar) {
        for (zzrr zzrrVar : this.zzc) {
            if (zzrrVar.zzb == zzrtVar) {
                this.zzc.remove(zzrrVar);
            }
        }
    }
}
