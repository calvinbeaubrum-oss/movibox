package com.google.android.gms.ads;

import android.content.Context;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.internal.ads.zzcdv;
import com.google.android.gms.internal.ads.zzcec;
import com.google.logging.type.LogSeverity;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final int FULL_WIDTH = -1;
    private final int zzb;
    private final int zzc;
    private final String zzd;
    private boolean zze;
    private boolean zzf;
    private int zzg;
    private boolean zzh;
    private int zzi;

    @NonNull
    public static final AdSize BANNER = new AdSize(320, 50, "320x50_mb");

    @NonNull
    public static final AdSize FULL_BANNER = new AdSize(468, 60, "468x60_as");

    @NonNull
    public static final AdSize LARGE_BANNER = new AdSize(320, 100, "320x100_as");

    @NonNull
    public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90_as");

    @NonNull
    public static final AdSize MEDIUM_RECTANGLE = new AdSize(LogSeverity.NOTICE_VALUE, 250, "300x250_as");

    @NonNull
    public static final AdSize WIDE_SKYSCRAPER = new AdSize(160, LogSeverity.CRITICAL_VALUE, "160x600_as");

    @NonNull
    @Deprecated
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "smart_banner");

    @NonNull
    public static final AdSize FLUID = new AdSize(-3, -4, "fluid");

    @NonNull
    public static final AdSize INVALID = new AdSize(0, 0, "invalid");

    @NonNull
    public static final AdSize zza = new AdSize(50, 50, "50x50_mb");

    @NonNull
    public static final AdSize SEARCH = new AdSize(-3, 0, "search_v2");

    public AdSize(int i11, int i12) {
        this(i11, i12, (i11 == -1 ? "FULL" : String.valueOf(i11)) + "x" + (i12 == -2 ? "AUTO" : String.valueOf(i12)) + "_as");
    }

    public AdSize(int i11, int i12, String str) {
        if (i11 < 0 && i11 != -1 && i11 != -3) {
            throw new IllegalArgumentException("Invalid width for AdSize: " + i11);
        }
        if (i12 >= 0 || i12 == -2 || i12 == -4) {
            this.zzb = i11;
            this.zzc = i12;
            this.zzd = str;
        } else {
            throw new IllegalArgumentException("Invalid height for AdSize: " + i12);
        }
    }

    @NonNull
    public static AdSize getCurrentOrientationAnchoredAdaptiveBannerAdSize(@NonNull Context context, int i11) {
        AdSize adSizeZzc = zzcdv.zzc(context, i11, 50, 0);
        adSizeZzc.zze = true;
        return adSizeZzc;
    }

    @NonNull
    public static AdSize getCurrentOrientationInlineAdaptiveBannerAdSize(@NonNull Context context, int i11) {
        int iZza = zzcdv.zza(context, 0);
        if (iZza == -1) {
            return INVALID;
        }
        AdSize adSize = new AdSize(i11, 0);
        adSize.zzg = iZza;
        adSize.zzf = true;
        return adSize;
    }

    @NonNull
    public static AdSize getCurrentOrientationInterscrollerAdSize(@NonNull Context context, int i11) {
        return zzj(i11, zzcdv.zza(context, 0));
    }

    @NonNull
    public static AdSize getInlineAdaptiveBannerAdSize(int i11, int i12) {
        AdSize adSize = new AdSize(i11, 0);
        adSize.zzg = i12;
        adSize.zzf = true;
        if (i12 < 32) {
            zzcec.zzj("The maximum height set for the inline adaptive ad size was " + i12 + " dp, which is below the minimum recommended value of 32 dp.");
        }
        return adSize;
    }

    @NonNull
    public static AdSize getLandscapeAnchoredAdaptiveBannerAdSize(@NonNull Context context, int i11) {
        AdSize adSizeZzc = zzcdv.zzc(context, i11, 50, 2);
        adSizeZzc.zze = true;
        return adSizeZzc;
    }

    @NonNull
    public static AdSize getLandscapeInlineAdaptiveBannerAdSize(@NonNull Context context, int i11) {
        int iZza = zzcdv.zza(context, 2);
        AdSize adSize = new AdSize(i11, 0);
        if (iZza == -1) {
            return INVALID;
        }
        adSize.zzg = iZza;
        adSize.zzf = true;
        return adSize;
    }

    @NonNull
    public static AdSize getLandscapeInterscrollerAdSize(@NonNull Context context, int i11) {
        return zzj(i11, zzcdv.zza(context, 2));
    }

    @NonNull
    public static AdSize getPortraitAnchoredAdaptiveBannerAdSize(@NonNull Context context, int i11) {
        AdSize adSizeZzc = zzcdv.zzc(context, i11, 50, 1);
        adSizeZzc.zze = true;
        return adSizeZzc;
    }

    @NonNull
    public static AdSize getPortraitInlineAdaptiveBannerAdSize(@NonNull Context context, int i11) {
        int iZza = zzcdv.zza(context, 1);
        AdSize adSize = new AdSize(i11, 0);
        if (iZza == -1) {
            return INVALID;
        }
        adSize.zzg = iZza;
        adSize.zzf = true;
        return adSize;
    }

    @NonNull
    public static AdSize getPortraitInterscrollerAdSize(@NonNull Context context, int i11) {
        return zzj(i11, zzcdv.zza(context, 1));
    }

    private static AdSize zzj(int i11, int i12) {
        if (i12 == -1) {
            return INVALID;
        }
        AdSize adSize = new AdSize(i11, 0);
        adSize.zzi = i12;
        adSize.zzh = true;
        return adSize;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) obj;
        return this.zzb == adSize.zzb && this.zzc == adSize.zzc && this.zzd.equals(adSize.zzd);
    }

    public int getHeight() {
        return this.zzc;
    }

    public int getHeightInPixels(@NonNull Context context) {
        int i11 = this.zzc;
        if (i11 == -4 || i11 == -3) {
            return -1;
        }
        if (i11 == -2) {
            return zzq.zza(context.getResources().getDisplayMetrics());
        }
        zzay.zzb();
        return zzcdv.zzx(context, i11);
    }

    public int getWidth() {
        return this.zzb;
    }

    public int getWidthInPixels(@NonNull Context context) {
        int i11 = this.zzb;
        if (i11 == -3) {
            return -1;
        }
        if (i11 != -1) {
            zzay.zzb();
            return zzcdv.zzx(context, i11);
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Parcelable.Creator<zzq> creator = zzq.CREATOR;
        return displayMetrics.widthPixels;
    }

    public int hashCode() {
        return this.zzd.hashCode();
    }

    public boolean isAutoHeight() {
        return this.zzc == -2;
    }

    public boolean isFluid() {
        return this.zzb == -3 && this.zzc == -4;
    }

    public boolean isFullWidth() {
        return this.zzb == -1;
    }

    @NonNull
    public String toString() {
        return this.zzd;
    }

    public final int zza() {
        return this.zzi;
    }

    public final int zzb() {
        return this.zzg;
    }

    public final void zzc(int i11) {
        this.zzg = i11;
    }

    public final void zzd(int i11) {
        this.zzi = i11;
    }

    public final void zze(boolean z11) {
        this.zzf = true;
    }

    public final void zzf(boolean z11) {
        this.zzh = true;
    }

    public final boolean zzg() {
        return this.zze;
    }

    public final boolean zzh() {
        return this.zzf;
    }

    public final boolean zzi() {
        return this.zzh;
    }
}
