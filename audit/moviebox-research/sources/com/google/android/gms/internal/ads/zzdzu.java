package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzdzu extends AdListener {
    final /* synthetic */ String zza;
    final /* synthetic */ zzdzx zzb;

    public zzdzu(zzdzx zzdzxVar, String str) {
        this.zza = str;
        this.zzb = zzdzxVar;
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.zzb.zzm(zzdzx.zzl(loadAdError), this.zza);
    }
}
