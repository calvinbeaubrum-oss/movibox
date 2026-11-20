package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbwg {
    private final NativeCustomFormatAd.OnCustomFormatAdLoadedListener zza;

    @Nullable
    private final NativeCustomFormatAd.OnCustomClickListener zzb;

    @Nullable
    private NativeCustomFormatAd zzc;

    public zzbwg(NativeCustomFormatAd.OnCustomFormatAdLoadedListener onCustomFormatAdLoadedListener, @Nullable NativeCustomFormatAd.OnCustomClickListener onCustomClickListener) {
        this.zza = onCustomFormatAdLoadedListener;
        this.zzb = onCustomClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized NativeCustomFormatAd zzf(zzbkg zzbkgVar) {
        NativeCustomFormatAd nativeCustomFormatAd = this.zzc;
        if (nativeCustomFormatAd != null) {
            return nativeCustomFormatAd;
        }
        zzbwh zzbwhVar = new zzbwh(zzbkgVar);
        this.zzc = zzbwhVar;
        return zzbwhVar;
    }

    @Nullable
    public final zzbkq zza() {
        zzbwc zzbwcVar = null;
        if (this.zzb == null) {
            return null;
        }
        return new zzbwd(this, zzbwcVar);
    }

    public final zzbkt zzb() {
        return new zzbwf(this, null);
    }
}
