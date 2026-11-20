package com.google.android.gms.ads.query;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzdx;
import com.google.android.gms.ads.internal.client.zzem;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.internal.ads.zzbxk;
import com.google.android.gms.internal.ads.zzcdr;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class QueryInfo {
    private final zzem zza;

    public QueryInfo(zzem zzemVar) {
        this.zza = zzemVar;
    }

    public static void generate(@NonNull Context context, @NonNull AdFormat adFormat, @Nullable AdRequest adRequest, @NonNull QueryInfoGenerationCallback queryInfoGenerationCallback) {
        zza(context, adFormat, adRequest, null, queryInfoGenerationCallback);
    }

    public static void generate(@NonNull Context context, @NonNull AdFormat adFormat, @Nullable AdRequest adRequest, @NonNull String str, @NonNull QueryInfoGenerationCallback queryInfoGenerationCallback) {
        Preconditions.checkNotNull(str, "AdUnitId cannot be null.");
        zza(context, adFormat, adRequest, str, queryInfoGenerationCallback);
    }

    private static void zza(final Context context, final AdFormat adFormat, @Nullable final AdRequest adRequest, @Nullable final String str, final QueryInfoGenerationCallback queryInfoGenerationCallback) {
        zzbgc.zza(context);
        if (((Boolean) zzbhy.zzk.zze()).booleanValue()) {
            if (((Boolean) zzba.zzc().zza(zzbgc.zzkG)).booleanValue()) {
                zzcdr.zzb.execute(new Runnable() { // from class: com.google.android.gms.ads.query.zza
                    @Override // java.lang.Runnable
                    public final void run() {
                        AdRequest adRequest2 = adRequest;
                        zzdx zzdxVarZza = adRequest2 == null ? null : adRequest2.zza();
                        new zzbxk(context, adFormat, zzdxVarZza, str).zzb(queryInfoGenerationCallback);
                    }
                });
                return;
            }
        }
        new zzbxk(context, adFormat, adRequest == null ? null : adRequest.zza(), str).zzb(queryInfoGenerationCallback);
    }

    @NonNull
    public String getQuery() {
        return this.zza.zzb();
    }

    @NonNull
    @KeepForSdk
    public Bundle getQueryBundle() {
        return this.zza.zza();
    }

    @NonNull
    @KeepForSdk
    public String getRequestId() {
        return this.zza.zzc();
    }
}
