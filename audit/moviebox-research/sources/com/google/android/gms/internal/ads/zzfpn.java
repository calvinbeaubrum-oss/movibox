package com.google.android.gms.internal.ads;

import android.app.UiModeManager;
import android.content.Context;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfpn {
    private static UiModeManager zza;

    public static zzfoj zza() {
        UiModeManager uiModeManager = zza;
        if (uiModeManager == null) {
            return zzfoj.OTHER;
        }
        int currentModeType = uiModeManager.getCurrentModeType();
        if (currentModeType != 1) {
            return currentModeType != 4 ? zzfoj.OTHER : zzfoj.CTV;
        }
        return zzfoj.MOBILE;
    }

    public static void zzb(Context context) {
        if (context != null) {
            zza = (UiModeManager) context.getSystemService("uimode");
        }
    }
}
