package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzcdv;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@TargetApi(24)
public class zzv extends zzu {
    public static final boolean zze(int i11, int i12, int i13) {
        return Math.abs(i11 - i12) <= i13;
    }

    @Override // com.google.android.gms.ads.internal.util.zzab
    public final boolean zzd(Activity activity, Configuration configuration) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeJ)).booleanValue()) {
            return false;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeL)).booleanValue()) {
            return activity.isInMultiWindowMode();
        }
        com.google.android.gms.ads.internal.client.zzay.zzb();
        int iZzx = zzcdv.zzx(activity, configuration.screenHeightDp);
        int iZzx2 = zzcdv.zzx(activity, configuration.screenWidthDp);
        WindowManager windowManager = (WindowManager) activity.getApplicationContext().getSystemService("window");
        com.google.android.gms.ads.internal.zzt.zzp();
        DisplayMetrics displayMetricsZzs = zzt.zzs(windowManager);
        int i11 = displayMetricsZzs.heightPixels;
        int i12 = displayMetricsZzs.widthPixels;
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : 0;
        int iRound = ((int) Math.round(((double) activity.getResources().getDisplayMetrics().density) + 0.5d)) * ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeH)).intValue();
        return (zze(i11, iZzx + dimensionPixelSize, iRound) && zze(i12, iZzx2, iRound)) ? false : true;
    }
}
