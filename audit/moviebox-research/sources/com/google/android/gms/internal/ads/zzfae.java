package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.s;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfae implements zzexq {
    final zzgey zza;
    final String zzb;
    final zzccz zzc;

    public zzfae(zzccz zzcczVar, zzgey zzgeyVar, String str) {
        this.zzc = zzcczVar;
        this.zza = zzgeyVar;
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 47;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final s zzb() {
        final s sVarZzh = zzgen.zzh(null);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfP)).booleanValue()) {
            sVarZzh = zzgen.zzh(null);
        }
        final s sVarZzh2 = zzgen.zzh(null);
        return zzgen.zzc(sVarZzh, sVarZzh2).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzfad
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzfaf((String) sVarZzh.get(), (String) sVarZzh2.get());
            }
        }, zzcep.zza);
    }
}
