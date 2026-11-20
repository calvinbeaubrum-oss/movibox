package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import androidx.browser.customtabs.CustomTabsClient;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhhw extends androidx.browser.customtabs.f {
    private final WeakReference zza;

    public zzhhw(zzbhd zzbhdVar) {
        this.zza = new WeakReference(zzbhdVar);
    }

    @Override // androidx.browser.customtabs.f
    public final void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        zzbhd zzbhdVar = (zzbhd) this.zza.get();
        if (zzbhdVar != null) {
            zzbhdVar.zzc(customTabsClient);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzbhd zzbhdVar = (zzbhd) this.zza.get();
        if (zzbhdVar != null) {
            zzbhdVar.zzd();
        }
    }
}
