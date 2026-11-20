package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsClient;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbhd {

    @Nullable
    private androidx.browser.customtabs.j zza;

    @Nullable
    private CustomTabsClient zzb;

    @Nullable
    private androidx.browser.customtabs.f zzc;

    @Nullable
    private zzbhb zzd;

    public static boolean zzg(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
            ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(intent, 0);
            List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            if (listQueryIntentActivities != null && resolveInfoResolveActivity != null) {
                for (int i11 = 0; i11 < listQueryIntentActivities.size(); i11++) {
                    if (resolveInfoResolveActivity.activityInfo.name.equals(listQueryIntentActivities.get(i11).activityInfo.name)) {
                        return resolveInfoResolveActivity.activityInfo.packageName.equals(zzhhv.zza(context));
                    }
                }
            }
        }
        return false;
    }

    @Nullable
    public final androidx.browser.customtabs.j zza() {
        CustomTabsClient customTabsClient = this.zzb;
        if (customTabsClient == null) {
            this.zza = null;
        } else if (this.zza == null) {
            this.zza = customTabsClient.e(null);
        }
        return this.zza;
    }

    public final void zzb(Activity activity) {
        String strZza;
        if (this.zzb == null && (strZza = zzhhv.zza(activity)) != null) {
            zzhhw zzhhwVar = new zzhhw(this);
            this.zzc = zzhhwVar;
            CustomTabsClient.a(activity, strZza, zzhhwVar);
        }
    }

    public final void zzc(CustomTabsClient customTabsClient) {
        this.zzb = customTabsClient;
        customTabsClient.g(0L);
        zzbhb zzbhbVar = this.zzd;
        if (zzbhbVar != null) {
            zzbhbVar.zza();
        }
    }

    public final void zzd() {
        this.zzb = null;
        this.zza = null;
    }

    public final void zze(zzbhb zzbhbVar) {
        this.zzd = zzbhbVar;
    }

    public final void zzf(Activity activity) {
        androidx.browser.customtabs.f fVar = this.zzc;
        if (fVar == null) {
            return;
        }
        activity.unbindService(fVar);
        this.zzb = null;
        this.zza = null;
        this.zzc = null;
    }
}
