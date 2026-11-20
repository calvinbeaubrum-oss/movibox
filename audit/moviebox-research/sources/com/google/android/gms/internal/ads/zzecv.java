package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.common.util.concurrent.s;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzecv {
    private final zzgey zza;
    private final zzgey zzb;
    private final zzedq zzc;
    private final zzhgx zzd;

    public zzecv(zzgey zzgeyVar, zzgey zzgeyVar2, zzedq zzedqVar, zzhgx zzhgxVar) {
        this.zza = zzgeyVar;
        this.zzb = zzgeyVar2;
        this.zzc = zzedqVar;
        this.zzd = zzhgxVar;
    }

    public final /* synthetic */ s zza(zzbym zzbymVar) throws Exception {
        return this.zzc.zza(zzbymVar, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkX)).longValue());
    }

    public final /* synthetic */ s zzb(zzbym zzbymVar, int i11, zzecf zzecfVar) throws Exception {
        return ((zzeew) this.zzd.zzb()).zzb(zzbymVar, i11);
    }

    public final s zzc(final zzbym zzbymVar) {
        s sVarZzf;
        String str = zzbymVar.zzf;
        com.google.android.gms.ads.internal.zzt.zzp();
        if (com.google.android.gms.ads.internal.util.zzt.zzB(str)) {
            sVarZzf = zzgen.zzg(new zzecf(1, "Ads service proxy force local"));
        } else {
            sVarZzf = zzgen.zzf(zzgen.zzk(new zzgdt() { // from class: com.google.android.gms.internal.ads.zzecs
                @Override // com.google.android.gms.internal.ads.zzgdt
                public final s zza() {
                    return this.zza.zza(zzbymVar);
                }
            }, this.zza), ExecutionException.class, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzect
                @Override // com.google.android.gms.internal.ads.zzgdu
                public final s zza(Object obj) {
                    Throwable cause = (ExecutionException) obj;
                    if (cause.getCause() != null) {
                        cause = cause.getCause();
                    }
                    return zzgen.zzg(cause);
                }
            }, this.zzb);
        }
        final int callingUid = Binder.getCallingUid();
        return zzgen.zzf(sVarZzf, zzecf.class, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzecu
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final s zza(Object obj) {
                return this.zza.zzb(zzbymVar, callingUid, (zzecf) obj);
            }
        }, this.zzb);
    }
}
