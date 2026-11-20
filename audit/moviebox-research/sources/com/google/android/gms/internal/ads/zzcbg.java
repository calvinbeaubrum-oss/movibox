package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcbg extends zzcat {
    private final RewardedInterstitialAdLoadCallback zza;
    private final zzcbh zzb;

    public zzcbg(RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback, zzcbh zzcbhVar) {
        this.zza = rewardedInterstitialAdLoadCallback;
        this.zzb = zzcbhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcau
    public final void zze(int i11) {
    }

    @Override // com.google.android.gms.internal.ads.zzcau
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) {
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zza;
        if (rewardedInterstitialAdLoadCallback != null) {
            rewardedInterstitialAdLoadCallback.onAdFailedToLoad(zzeVar.zzb());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcau
    public final void zzg() {
        zzcbh zzcbhVar;
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zza;
        if (rewardedInterstitialAdLoadCallback == null || (zzcbhVar = this.zzb) == null) {
            return;
        }
        rewardedInterstitialAdLoadCallback.onAdLoaded(zzcbhVar);
    }
}
