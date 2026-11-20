package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdwe {
    final /* synthetic */ zzdwf zza;
    private final Map zzb = new ConcurrentHashMap();

    public zzdwe(zzdwf zzdwfVar) {
        this.zza = zzdwfVar;
    }

    public static /* bridge */ /* synthetic */ zzdwe zza(zzdwe zzdweVar) {
        zzdweVar.zzb.putAll(zzdweVar.zza.zzc);
        return zzdweVar;
    }

    public final zzdwe zzb(String str, String str2) {
        this.zzb.put(str, str2);
        return this;
    }

    public final zzdwe zzc(String str, @Nullable String str2) {
        if (!TextUtils.isEmpty(str2)) {
            this.zzb.put(str, str2);
        }
        return this;
    }

    public final zzdwe zzd(zzfgm zzfgmVar) {
        this.zzb.put("aai", zzfgmVar.zzx);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzha)).booleanValue()) {
            zzc("rid", zzfgmVar.zzao);
        }
        return this;
    }

    public final zzdwe zze(zzfgp zzfgpVar) {
        this.zzb.put("gqi", zzfgpVar.zzb);
        return this;
    }

    public final String zzf() {
        return this.zza.zza.zzb(this.zzb);
    }

    public final void zzg() {
        this.zza.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdwc
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzi();
            }
        });
    }

    public final void zzh() {
        this.zza.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdwd
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzj();
            }
        });
    }

    public final /* synthetic */ void zzi() {
        this.zza.zza.zzf(this.zzb);
    }

    public final /* synthetic */ void zzj() {
        this.zza.zza.zze(this.zzb);
    }
}
