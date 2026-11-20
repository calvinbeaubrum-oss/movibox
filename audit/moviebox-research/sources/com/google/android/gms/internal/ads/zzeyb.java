package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.google.common.util.concurrent.s;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeyb implements zzexq {
    private final zzgey zza;
    private final Context zzb;

    public zzeyb(zzgey zzgeyVar, Context context) {
        this.zza = zzgeyVar;
        this.zzb = context;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 39;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final s zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeya
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    public final /* synthetic */ zzexz zzc() throws Exception {
        int i11;
        boolean zIsActiveNetworkMetered;
        int i12;
        TelephonyManager telephonyManager = (TelephonyManager) this.zzb.getSystemService("phone");
        String networkOperator = telephonyManager.getNetworkOperator();
        int phoneType = telephonyManager.getPhoneType();
        com.google.android.gms.ads.internal.zzt.zzp();
        int i13 = -1;
        if (com.google.android.gms.ads.internal.util.zzt.zzz(this.zzb, "android.permission.ACCESS_NETWORK_STATE")) {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.zzb.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                int type = activeNetworkInfo.getType();
                int iOrdinal = activeNetworkInfo.getDetailedState().ordinal();
                i11 = type;
                i13 = iOrdinal;
            } else {
                i11 = -1;
            }
            zIsActiveNetworkMetered = connectivityManager.isActiveNetworkMetered();
            i12 = i13;
        } else {
            i11 = -2;
            zIsActiveNetworkMetered = false;
            i12 = -1;
        }
        return new zzexz(networkOperator, i11, com.google.android.gms.ads.internal.zzt.zzq().zzm(this.zzb), phoneType, zIsActiveNetworkMetered, i12);
    }
}
