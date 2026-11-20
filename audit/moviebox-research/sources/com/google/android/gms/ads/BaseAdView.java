package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzea;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.internal.ads.zzbxw;
import com.google.android.gms.internal.ads.zzcdr;
import com.google.android.gms.internal.ads.zzcec;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseAdView extends ViewGroup {
    protected final zzea zza;

    public BaseAdView(@NonNull Context context, int i11) {
        super(context);
        this.zza = new zzea(this, i11);
    }

    public BaseAdView(@NonNull Context context, @NonNull AttributeSet attributeSet, int i11) {
        super(context, attributeSet);
        this.zza = new zzea(this, attributeSet, false, i11);
    }

    public BaseAdView(@NonNull Context context, @NonNull AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11);
        this.zza = new zzea(this, attributeSet, false, i12);
    }

    public BaseAdView(@NonNull Context context, @NonNull AttributeSet attributeSet, int i11, int i12, boolean z11) {
        super(context, attributeSet, i11);
        this.zza = new zzea(this, attributeSet, z11, i12);
    }

    public BaseAdView(@NonNull Context context, @NonNull AttributeSet attributeSet, boolean z11) {
        super(context, attributeSet);
        this.zza = new zzea(this, attributeSet, z11);
    }

    public void destroy() {
        zzbgc.zza(getContext());
        if (((Boolean) zzbhy.zze.zze()).booleanValue()) {
            if (((Boolean) zzba.zzc().zza(zzbgc.zzkD)).booleanValue()) {
                zzcdr.zzb.execute(new Runnable() { // from class: com.google.android.gms.ads.zzd
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseAdView baseAdView = this.zza;
                        try {
                            baseAdView.zza.zzk();
                        } catch (IllegalStateException e11) {
                            zzbxw.zza(baseAdView.getContext()).zzg(e11, "BaseAdView.destroy");
                        }
                    }
                });
                return;
            }
        }
        this.zza.zzk();
    }

    @NonNull
    public AdListener getAdListener() {
        return this.zza.zza();
    }

    @Nullable
    public AdSize getAdSize() {
        return this.zza.zzb();
    }

    @NonNull
    public String getAdUnitId() {
        return this.zza.zzj();
    }

    @Nullable
    public OnPaidEventListener getOnPaidEventListener() {
        return this.zza.zzc();
    }

    @Nullable
    public ResponseInfo getResponseInfo() {
        return this.zza.zzd();
    }

    public boolean isLoading() {
        return this.zza.zzA();
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(@NonNull final AdRequest adRequest) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbgc.zza(getContext());
        if (((Boolean) zzbhy.zzf.zze()).booleanValue()) {
            if (((Boolean) zzba.zzc().zza(zzbgc.zzkG)).booleanValue()) {
                zzcdr.zzb.execute(new Runnable() { // from class: com.google.android.gms.ads.zzf
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseAdView baseAdView = this.zza;
                        try {
                            baseAdView.zza.zzm(adRequest.zza);
                        } catch (IllegalStateException e11) {
                            zzbxw.zza(baseAdView.getContext()).zzg(e11, "BaseAdView.loadAd");
                        }
                    }
                });
                return;
            }
        }
        this.zza.zzm(adRequest.zza);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            return;
        }
        int measuredWidth = childAt.getMeasuredWidth();
        int measuredHeight = childAt.getMeasuredHeight();
        int i15 = ((i13 - i11) - measuredWidth) / 2;
        int i16 = ((i14 - i12) - measuredHeight) / 2;
        childAt.layout(i15, i16, measuredWidth + i15, measuredHeight + i16);
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        AdSize adSize;
        int heightInPixels;
        int measuredWidth = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            try {
                adSize = getAdSize();
            } catch (NullPointerException e11) {
                zzcec.zzh("Unable to retrieve ad size.", e11);
                adSize = null;
            }
            if (adSize != null) {
                Context context = getContext();
                int widthInPixels = adSize.getWidthInPixels(context);
                heightInPixels = adSize.getHeightInPixels(context);
                measuredWidth = widthInPixels;
            } else {
                heightInPixels = 0;
            }
        } else {
            measureChild(childAt, i11, i12);
            measuredWidth = childAt.getMeasuredWidth();
            heightInPixels = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(measuredWidth, getSuggestedMinimumWidth()), i11), View.resolveSize(Math.max(heightInPixels, getSuggestedMinimumHeight()), i12));
    }

    public void pause() {
        zzbgc.zza(getContext());
        if (((Boolean) zzbhy.zzg.zze()).booleanValue()) {
            if (((Boolean) zzba.zzc().zza(zzbgc.zzkE)).booleanValue()) {
                zzcdr.zzb.execute(new Runnable() { // from class: com.google.android.gms.ads.zze
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseAdView baseAdView = this.zza;
                        try {
                            baseAdView.zza.zzn();
                        } catch (IllegalStateException e11) {
                            zzbxw.zza(baseAdView.getContext()).zzg(e11, "BaseAdView.pause");
                        }
                    }
                });
                return;
            }
        }
        this.zza.zzn();
    }

    public void resume() {
        zzbgc.zza(getContext());
        if (((Boolean) zzbhy.zzh.zze()).booleanValue()) {
            if (((Boolean) zzba.zzc().zza(zzbgc.zzkC)).booleanValue()) {
                zzcdr.zzb.execute(new Runnable() { // from class: com.google.android.gms.ads.zzc
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseAdView baseAdView = this.zza;
                        try {
                            baseAdView.zza.zzp();
                        } catch (IllegalStateException e11) {
                            zzbxw.zza(baseAdView.getContext()).zzg(e11, "BaseAdView.resume");
                        }
                    }
                });
                return;
            }
        }
        this.zza.zzp();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setAdListener(@NonNull AdListener adListener) {
        this.zza.zzr(adListener);
        if (adListener == 0) {
            this.zza.zzq(null);
            return;
        }
        if (adListener instanceof com.google.android.gms.ads.internal.client.zza) {
            this.zza.zzq((com.google.android.gms.ads.internal.client.zza) adListener);
        }
        if (adListener instanceof AppEventListener) {
            this.zza.zzv((AppEventListener) adListener);
        }
    }

    public void setAdSize(@NonNull AdSize adSize) {
        this.zza.zzs(adSize);
    }

    public void setAdUnitId(@NonNull String str) {
        this.zza.zzu(str);
    }

    public void setOnPaidEventListener(@Nullable OnPaidEventListener onPaidEventListener) {
        this.zza.zzx(onPaidEventListener);
    }
}
