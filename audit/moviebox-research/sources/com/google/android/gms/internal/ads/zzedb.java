package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.s;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzedb {
    private final zzgey zza;
    private final zzgey zzb;
    private final zzedt zzc;

    public zzedb(zzgey zzgeyVar, zzgey zzgeyVar2, zzedt zzedtVar) {
        this.zza = zzgeyVar;
        this.zzb = zzgeyVar2;
        this.zzc = zzedtVar;
    }

    public final /* synthetic */ s zza(zzbyi zzbyiVar) throws Exception {
        return this.zzc.zza(zzbyiVar, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkW)).longValue());
    }

    public final s zzb(final zzbyi zzbyiVar) {
        s sVarZzf;
        String str = zzbyiVar.zzb;
        com.google.android.gms.ads.internal.zzt.zzp();
        if (com.google.android.gms.ads.internal.util.zzt.zzB(str)) {
            sVarZzf = zzgen.zzg(new zzecf(1, "Ads signal service force local"));
        } else {
            sVarZzf = zzgen.zzf(zzgen.zzk(new zzgdt() { // from class: com.google.android.gms.internal.ads.zzecx
                @Override // com.google.android.gms.internal.ads.zzgdt
                public final s zza() {
                    return this.zza.zza(zzbyiVar);
                }
            }, this.zza), ExecutionException.class, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzecy
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
        return zzgen.zzn(zzgen.zzf(zzgee.zzu(sVarZzf), zzecf.class, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzecz
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final s zza(Object obj) {
                return zzgen.zzh(null);
            }
        }, this.zzb), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzeda
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final s zza(Object obj) {
                InputStream inputStream = (InputStream) obj;
                JSONObject jSONObject = new JSONObject();
                if (inputStream == null) {
                    return zzgen.zzh(jSONObject);
                }
                try {
                    com.google.android.gms.ads.internal.zzt.zzp();
                    jSONObject = new JSONObject(com.google.android.gms.ads.internal.util.zzt.zzM(new InputStreamReader(inputStream)));
                } catch (IOException | JSONException e11) {
                    com.google.android.gms.ads.internal.zzt.zzo().zzw(e11, "AdsServiceSignalTask.startAdsServiceSignalTask");
                }
                return zzgen.zzh(jSONObject);
            }
        }, this.zzb);
    }
}
