package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.s;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzcre implements zzcqv {
    private final zzeil zza;

    public zzcre(zzeil zzeilVar) {
        this.zza = zzeilVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcqv
    public final void zza(Map map) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjU)).booleanValue()) {
            zzgen.zzf(zzgee.zzu(this.zza.zza(true)), Throwable.class, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzcrd
                @Override // com.google.android.gms.internal.ads.zzgdu
                public final s zza(Object obj) {
                    com.google.android.gms.ads.internal.zzt.zzo().zzw((Throwable) obj, "GetTopicsApiWithRecordObservationActionHandler");
                    return zzgen.zzh(new androidx.privacysandbox.ads.adservices.topics.b(zzgaa.zzl()));
                }
            }, zzcep.zza);
        }
    }
}
