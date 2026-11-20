package com.google.android.gms.ads;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbgc;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class MediationUtils {
    protected static final double MIN_HEIGHT_RATIO = 0.7d;
    protected static final double MIN_WIDTH_RATIO = 0.5d;

    /* JADX WARN: Code duplicated, block: B:38:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:50:0x00cb A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    @Nullable
    public static AdSize findClosestSize(@NonNull Context context, @NonNull AdSize adSize, @NonNull List<AdSize> list) {
        AdSize adSize2 = null;
        if (list != null && adSize != null) {
            if (!adSize.zzh() && !adSize.zzi()) {
                float f11 = context.getResources().getDisplayMetrics().density;
                adSize = new AdSize(Math.round(adSize.getWidthInPixels(context) / f11), Math.round(adSize.getHeightInPixels(context) / f11));
            }
            for (AdSize adSize3 : list) {
                if (adSize3 != null) {
                    int width = adSize.getWidth();
                    int width2 = adSize3.getWidth();
                    int height = adSize.getHeight();
                    double d11 = ((double) width) * MIN_WIDTH_RATIO;
                    double d12 = width2;
                    int height2 = adSize3.getHeight();
                    if (d11 <= d12 && width >= width2) {
                        if (adSize.zzi()) {
                            int iZza = adSize.zza();
                            if (((Integer) zzba.zzc().zza(zzbgc.zzhK)).intValue() <= width2) {
                                if (((Integer) zzba.zzc().zza(zzbgc.zzhL)).intValue() <= height2 && iZza >= height2) {
                                    if (adSize2 != null || adSize2.getWidth() * adSize2.getHeight() <= adSize3.getWidth() * adSize3.getHeight()) {
                                        adSize2 = adSize3;
                                    }
                                }
                            }
                        } else if (adSize.zzh()) {
                            if (adSize.zzb() >= height2) {
                                if (adSize2 != null) {
                                }
                                adSize2 = adSize3;
                            }
                        } else if (((double) height) * MIN_HEIGHT_RATIO <= height2 && height >= height2) {
                            if (adSize2 != null) {
                            }
                            adSize2 = adSize3;
                        }
                    }
                }
            }
        }
        return adSize2;
    }
}
