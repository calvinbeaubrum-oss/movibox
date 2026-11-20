package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdxk {
    private final zzboe zza;

    public zzdxk(zzboe zzboeVar) {
        this.zza = zzboeVar;
    }

    private final void zzs(zzdxj zzdxjVar) throws RemoteException {
        String strZza = zzdxj.zza(zzdxjVar);
        zzcec.zzi("Dispatching AFMA event on publisher webview: ".concat(strZza));
        this.zza.zzb(strZza);
    }

    public final void zza() throws RemoteException {
        zzs(new zzdxj("initialize", null));
    }

    public final void zzb(long j11) throws RemoteException {
        zzdxj zzdxjVar = new zzdxj("interstitial", null);
        zzdxjVar.zza = Long.valueOf(j11);
        zzdxjVar.zzc = "onAdClicked";
        this.zza.zzb(zzdxj.zza(zzdxjVar));
    }

    public final void zzc(long j11) throws RemoteException {
        zzdxj zzdxjVar = new zzdxj("interstitial", null);
        zzdxjVar.zza = Long.valueOf(j11);
        zzdxjVar.zzc = "onAdClosed";
        zzs(zzdxjVar);
    }

    public final void zzd(long j11, int i11) throws RemoteException {
        zzdxj zzdxjVar = new zzdxj("interstitial", null);
        zzdxjVar.zza = Long.valueOf(j11);
        zzdxjVar.zzc = "onAdFailedToLoad";
        zzdxjVar.zzd = Integer.valueOf(i11);
        zzs(zzdxjVar);
    }

    public final void zze(long j11) throws RemoteException {
        zzdxj zzdxjVar = new zzdxj("interstitial", null);
        zzdxjVar.zza = Long.valueOf(j11);
        zzdxjVar.zzc = "onAdLoaded";
        zzs(zzdxjVar);
    }

    public final void zzf(long j11) throws RemoteException {
        zzdxj zzdxjVar = new zzdxj("interstitial", null);
        zzdxjVar.zza = Long.valueOf(j11);
        zzdxjVar.zzc = "onNativeAdObjectNotAvailable";
        zzs(zzdxjVar);
    }

    public final void zzg(long j11) throws RemoteException {
        zzdxj zzdxjVar = new zzdxj("interstitial", null);
        zzdxjVar.zza = Long.valueOf(j11);
        zzdxjVar.zzc = "onAdOpened";
        zzs(zzdxjVar);
    }

    public final void zzh(long j11) throws RemoteException {
        zzdxj zzdxjVar = new zzdxj("creation", null);
        zzdxjVar.zza = Long.valueOf(j11);
        zzdxjVar.zzc = "nativeObjectCreated";
        zzs(zzdxjVar);
    }

    public final void zzi(long j11) throws RemoteException {
        zzdxj zzdxjVar = new zzdxj("creation", null);
        zzdxjVar.zza = Long.valueOf(j11);
        zzdxjVar.zzc = "nativeObjectNotCreated";
        zzs(zzdxjVar);
    }

    public final void zzj(long j11) throws RemoteException {
        zzdxj zzdxjVar = new zzdxj("rewarded", null);
        zzdxjVar.zza = Long.valueOf(j11);
        zzdxjVar.zzc = "onAdClicked";
        zzs(zzdxjVar);
    }

    public final void zzk(long j11) throws RemoteException {
        zzdxj zzdxjVar = new zzdxj("rewarded", null);
        zzdxjVar.zza = Long.valueOf(j11);
        zzdxjVar.zzc = "onRewardedAdClosed";
        zzs(zzdxjVar);
    }

    public final void zzl(long j11, zzcak zzcakVar) throws RemoteException {
        zzdxj zzdxjVar = new zzdxj("rewarded", null);
        zzdxjVar.zza = Long.valueOf(j11);
        zzdxjVar.zzc = "onUserEarnedReward";
        zzdxjVar.zze = zzcakVar.zzf();
        zzdxjVar.zzf = Integer.valueOf(zzcakVar.zze());
        zzs(zzdxjVar);
    }

    public final void zzm(long j11, int i11) throws RemoteException {
        zzdxj zzdxjVar = new zzdxj("rewarded", null);
        zzdxjVar.zza = Long.valueOf(j11);
        zzdxjVar.zzc = "onRewardedAdFailedToLoad";
        zzdxjVar.zzd = Integer.valueOf(i11);
        zzs(zzdxjVar);
    }

    public final void zzn(long j11, int i11) throws RemoteException {
        zzdxj zzdxjVar = new zzdxj("rewarded", null);
        zzdxjVar.zza = Long.valueOf(j11);
        zzdxjVar.zzc = "onRewardedAdFailedToShow";
        zzdxjVar.zzd = Integer.valueOf(i11);
        zzs(zzdxjVar);
    }

    public final void zzo(long j11) throws RemoteException {
        zzdxj zzdxjVar = new zzdxj("rewarded", null);
        zzdxjVar.zza = Long.valueOf(j11);
        zzdxjVar.zzc = "onAdImpression";
        zzs(zzdxjVar);
    }

    public final void zzp(long j11) throws RemoteException {
        zzdxj zzdxjVar = new zzdxj("rewarded", null);
        zzdxjVar.zza = Long.valueOf(j11);
        zzdxjVar.zzc = "onRewardedAdLoaded";
        zzs(zzdxjVar);
    }

    public final void zzq(long j11) throws RemoteException {
        zzdxj zzdxjVar = new zzdxj("rewarded", null);
        zzdxjVar.zza = Long.valueOf(j11);
        zzdxjVar.zzc = "onNativeAdObjectNotAvailable";
        zzs(zzdxjVar);
    }

    public final void zzr(long j11) throws RemoteException {
        zzdxj zzdxjVar = new zzdxj("rewarded", null);
        zzdxjVar.zza = Long.valueOf(j11);
        zzdxjVar.zzc = "onRewardedAdOpened";
        zzs(zzdxjVar);
    }
}
