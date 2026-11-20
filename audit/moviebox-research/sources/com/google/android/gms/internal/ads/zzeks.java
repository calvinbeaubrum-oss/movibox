package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzeks implements zzdkw {
    private final zzfgm zza;
    private final zzbus zzb;
    private final AdFormat zzc;

    @Nullable
    private zzdbp zzd = null;

    public zzeks(zzfgm zzfgmVar, zzbus zzbusVar, AdFormat adFormat) {
        this.zza = zzfgmVar;
        this.zzb = zzbusVar;
        this.zzc = adFormat;
    }

    @Override // com.google.android.gms.internal.ads.zzdkw
    public final void zza(boolean z11, Context context, zzdbk zzdbkVar) throws zzdkv {
        boolean zZzs;
        try {
            AdFormat adFormat = AdFormat.BANNER;
            int iOrdinal = this.zzc.ordinal();
            if (iOrdinal == 1) {
                zZzs = this.zzb.zzs(ObjectWrapper.wrap(context));
            } else {
                if (iOrdinal != 2) {
                    if (iOrdinal == 5) {
                        zZzs = this.zzb.zzr(ObjectWrapper.wrap(context));
                    }
                    throw new zzdkv("Adapter failed to show.");
                }
                zZzs = this.zzb.zzt(ObjectWrapper.wrap(context));
            }
            if (zZzs) {
                if (this.zzd == null) {
                    return;
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbw)).booleanValue() || this.zza.zzZ != 2) {
                    return;
                }
                this.zzd.zza();
                return;
            }
            throw new zzdkv("Adapter failed to show.");
        } catch (Throwable th2) {
            throw new zzdkv(th2);
        }
    }

    public final void zzb(zzdbp zzdbpVar) {
        this.zzd = zzdbpVar;
    }
}
