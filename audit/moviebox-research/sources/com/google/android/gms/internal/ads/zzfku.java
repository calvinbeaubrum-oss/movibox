package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.s;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfku {
    final /* synthetic */ zzfle zza;
    private final Object zzb;
    private final List zzc;

    public /* synthetic */ zzfku(zzfle zzfleVar, Object obj, List list, zzfkt zzfktVar) {
        this.zza = zzfleVar;
        this.zzb = obj;
        this.zzc = list;
    }

    public final zzfld zza(Callable callable) {
        zzgem zzgemVarZzb = zzgen.zzb(this.zzc);
        s sVarZza = zzgemVarZzb.zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzfks
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return null;
            }
        }, zzcep.zzf);
        s sVarZza2 = zzgemVarZzb.zza(callable, this.zza.zzb);
        return new zzfld(this.zza, this.zzb, sVarZza, this.zzc, sVarZza2);
    }
}
