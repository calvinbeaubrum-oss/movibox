package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.s;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzevu implements zzexq {
    private final zzgey zza;
    private final Context zzb;
    private final Set zzc;

    public zzevu(zzgey zzgeyVar, Context context, Set set) {
        this.zza = zzgeyVar;
        this.zzb = context;
        this.zzc = set;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 27;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final s zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzevt
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0044, code lost:
    
        if (r0.contains("banner") == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ zzevv zzc() throws Exception {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeU)).booleanValue()) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfc)).booleanValue()) {
                Set set = this.zzc;
                if (!set.contains("rewarded")) {
                    if (!set.contains("interstitial")) {
                        if (!set.contains("native")) {
                        }
                    }
                }
            }
            return new zzevv(com.google.android.gms.ads.internal.zzt.zzA().zze(this.zzb));
        }
        return new zzevv(null);
    }
}
