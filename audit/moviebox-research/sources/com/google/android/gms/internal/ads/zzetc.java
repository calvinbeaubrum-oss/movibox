package com.google.android.gms.internal.ads;

import android.os.Build;
import android.os.Bundle;
import android.os.ext.SdkExtensions;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzetc implements zzexp {
    private final Integer zza;

    private zzetc(Integer num) {
        this.zza = num;
    }

    public static /* bridge */ /* synthetic */ zzetc zzb() {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjL)).booleanValue()) {
            return new zzetc(null);
        }
        com.google.android.gms.ads.internal.zzt.zzp();
        int extensionVersion = 0;
        if (Build.VERSION.SDK_INT >= 30 && SdkExtensions.getExtensionVersion(30) > 3) {
            extensionVersion = SdkExtensions.getExtensionVersion(1000000);
        }
        return new zzetc(Integer.valueOf(extensionVersion));
    }

    @Override // com.google.android.gms.internal.ads.zzexp
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Integer num = this.zza;
        Bundle bundle = (Bundle) obj;
        if (num != null) {
            bundle.putInt("aos", num.intValue());
        }
    }
}
