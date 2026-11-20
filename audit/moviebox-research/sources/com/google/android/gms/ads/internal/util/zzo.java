package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.google.android.gms.internal.ads.zzbhb;
import com.google.android.gms.internal.ads.zzbhd;
import com.google.android.gms.internal.ads.zzhhv;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class zzo implements zzbhb {
    final /* synthetic */ zzbhd zza;
    final /* synthetic */ Context zzb;
    final /* synthetic */ Uri zzc;

    public zzo(zzt zztVar, zzbhd zzbhdVar, Context context, Uri uri) {
        this.zza = zzbhdVar;
        this.zzb = context;
        this.zzc = uri;
    }

    @Override // com.google.android.gms.internal.ads.zzbhb
    public final void zza() {
        androidx.browser.customtabs.d dVarA = new androidx.browser.customtabs.d.b(this.zza.zza()).a();
        dVarA.f1830a.setPackage(zzhhv.zza(this.zzb));
        dVarA.a(this.zzb, this.zzc);
        this.zza.zzf((Activity) this.zzb);
    }
}
