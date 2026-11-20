package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.common.util.concurrent.s;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzexn implements zzexq {
    private final zzgey zza;
    private final Context zzb;

    public zzexn(zzgey zzgeyVar, Context context) {
        this.zza = zzgeyVar;
        this.zzb = context;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 37;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final s zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzexl
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    public final /* synthetic */ zzexp zzc() throws Exception {
        final Bundle bundleZzb = com.google.android.gms.ads.internal.util.zzad.zzb(this.zzb, (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgf));
        if (bundleZzb.isEmpty()) {
            return null;
        }
        return new zzexp() { // from class: com.google.android.gms.internal.ads.zzexm
            @Override // com.google.android.gms.internal.ads.zzexp
            public final void zzj(Object obj) {
                ((Bundle) obj).putBundle("shared_pref", bundleZzb);
            }
        };
    }
}
