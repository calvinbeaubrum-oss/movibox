package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdError;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzeny implements zzdcg {
    boolean zza = false;
    final /* synthetic */ zzeiq zzb;
    final /* synthetic */ zzceu zzc;
    final /* synthetic */ zzenz zzd;

    public zzeny(zzenz zzenzVar, zzeiq zzeiqVar, zzceu zzceuVar) {
        this.zzb = zzeiqVar;
        this.zzc = zzceuVar;
        this.zzd = zzenzVar;
    }

    private final synchronized void zze(com.google.android.gms.ads.internal.client.zze zzeVar) {
        int i11 = 1;
        if (true == ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfs)).booleanValue()) {
            i11 = 3;
        }
        this.zzc.zzd(new zzeir(i11, zzeVar));
    }

    @Override // com.google.android.gms.internal.ads.zzdcg
    public final synchronized void zza(int i11) {
        if (this.zza) {
            return;
        }
        this.zza = true;
        zze(new com.google.android.gms.ads.internal.client.zze(i11, zzenz.zze(this.zzb.zza, i11), AdError.UNDEFINED_DOMAIN, null, null));
    }

    @Override // com.google.android.gms.internal.ads.zzdcg
    public final synchronized void zzb(com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (this.zza) {
            return;
        }
        this.zza = true;
        zze(zzeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdcg
    public final synchronized void zzc(int i11, @Nullable String str) {
        try {
            if (this.zza) {
                return;
            }
            this.zza = true;
            if (str == null) {
                str = zzenz.zze(this.zzb.zza, i11);
            }
            zze(new com.google.android.gms.ads.internal.client.zze(i11, str, AdError.UNDEFINED_DOMAIN, null, null));
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcg
    public final synchronized void zzd() {
        this.zzc.zzc(null);
    }
}
