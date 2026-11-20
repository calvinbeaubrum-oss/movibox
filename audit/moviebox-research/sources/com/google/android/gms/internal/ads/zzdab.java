package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.common.util.concurrent.s;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdab {
    private final zzflm zza;
    private final zzcei zzb;
    private final ApplicationInfo zzc;
    private final String zzd;
    private final List zze;
    private final PackageInfo zzf;
    private final zzhgx zzg;
    private final String zzh;
    private final zzext zzi;
    private final com.google.android.gms.ads.internal.util.zzg zzj;
    private final zzfhh zzk;
    private final zzdgg zzl;

    public zzdab(zzflm zzflmVar, zzcei zzceiVar, ApplicationInfo applicationInfo, String str, List list, @Nullable PackageInfo packageInfo, zzhgx zzhgxVar, com.google.android.gms.ads.internal.util.zzg zzgVar, String str2, zzext zzextVar, zzfhh zzfhhVar, zzdgg zzdggVar) {
        this.zza = zzflmVar;
        this.zzb = zzceiVar;
        this.zzc = applicationInfo;
        this.zzd = str;
        this.zze = list;
        this.zzf = packageInfo;
        this.zzg = zzhgxVar;
        this.zzh = str2;
        this.zzi = zzextVar;
        this.zzj = zzgVar;
        this.zzk = zzfhhVar;
        this.zzl = zzdggVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ zzbze zza(s sVar) throws Exception {
        Bundle bundle = (Bundle) sVar.get();
        String str = (String) ((s) this.zzg.zzb()).get();
        boolean z11 = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzhh)).booleanValue() && this.zzj.zzQ();
        String str2 = this.zzh;
        PackageInfo packageInfo = this.zzf;
        List list = this.zze;
        return new zzbze(bundle, this.zzb, this.zzc, this.zzd, list, packageInfo, str, str2, null, null, z11, this.zzk.zzb());
    }

    public final s zzb() {
        this.zzl.zza();
        return zzfkw.zzc(this.zzi.zza(new Bundle()), zzflg.SIGNALS, this.zza).zza();
    }

    public final s zzc() {
        final s sVarZzb = zzb();
        return this.zza.zza(zzflg.REQUEST_PARCEL, sVarZzb, (s) this.zzg.zzb()).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzdaa
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zza(sVarZzb);
            }
        }).zza();
    }
}
