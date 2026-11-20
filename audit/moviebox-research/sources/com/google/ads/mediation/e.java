package com.google.ads.mediation;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.zzf;
import com.google.android.gms.ads.formats.zzg;
import com.google.android.gms.ads.formats.zzi;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.internal.ads.zzbkh;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class e extends AdListener implements zzi, zzg, zzf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractAdViewAdapter f32510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediationNativeListener f32511b;

    public e(AbstractAdViewAdapter abstractAdViewAdapter, MediationNativeListener mediationNativeListener) {
        this.f32510a = abstractAdViewAdapter;
        this.f32511b = mediationNativeListener;
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdClicked() {
        this.f32511b.onAdClicked(this.f32510a);
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdClosed() {
        this.f32511b.onAdClosed(this.f32510a);
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.f32511b.onAdFailedToLoad(this.f32510a, loadAdError);
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdImpression() {
        this.f32511b.onAdImpression(this.f32510a);
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdLoaded() {
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdOpened() {
        this.f32511b.onAdOpened(this.f32510a);
    }

    @Override // com.google.android.gms.ads.formats.zzi
    public final void zza(UnifiedNativeAd unifiedNativeAd) {
        this.f32511b.onAdLoaded(this.f32510a, new a(unifiedNativeAd));
    }

    @Override // com.google.android.gms.ads.formats.zzf
    public final void zzb(zzbkh zzbkhVar, String str) {
        this.f32511b.zze(this.f32510a, zzbkhVar, str);
    }

    @Override // com.google.android.gms.ads.formats.zzg
    public final void zzc(zzbkh zzbkhVar) {
        this.f32511b.zzd(this.f32510a, zzbkhVar);
    }
}
