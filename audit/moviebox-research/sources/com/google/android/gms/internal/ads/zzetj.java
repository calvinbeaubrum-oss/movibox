package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.google.common.util.concurrent.s;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzetj implements zzexq {
    private final zzgey zza;
    private final Context zzb;

    public zzetj(zzgey zzgeyVar, Context context) {
        this.zza = zzgeyVar;
        this.zzb = context;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 14;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    @SuppressLint({"UnprotectedReceiver"})
    public final s zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeti
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    public final /* synthetic */ zzetk zzc() throws Exception {
        double d11;
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        Intent intentRegisterReceiver = (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkw)).booleanValue() || Build.VERSION.SDK_INT < 33) ? this.zzb.registerReceiver(null, intentFilter) : this.zzb.registerReceiver(null, intentFilter, 4);
        boolean z11 = false;
        if (intentRegisterReceiver != null) {
            int intExtra = intentRegisterReceiver.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
            double intExtra2 = intentRegisterReceiver.getIntExtra("level", -1);
            double intExtra3 = intentRegisterReceiver.getIntExtra("scale", -1);
            z11 = intExtra == 2 || intExtra == 5;
            d11 = intExtra2 / intExtra3;
        } else {
            d11 = -1.0d;
        }
        return new zzetk(d11, z11);
    }
}
