package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzcec;
import com.google.android.gms.internal.ads.zzgej;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class zzz implements zzgej {
    final /* synthetic */ zzaa zza;

    public zzz(zzaa zzaaVar) {
        this.zza = zzaaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th2) {
        com.google.android.gms.ads.internal.zzt.zzo().zzw(th2, "SignalGeneratorImpl.initializeWebViewForSignalCollection");
        zzaa zzaaVar = this.zza;
        zzf.zzc(zzaaVar.zzs, zzaaVar.zzk, "sgf", new Pair("sgf_reason", th2.getMessage()), new Pair("sgi_rn", Integer.toString(this.zza.zzK.get())));
        zzcec.zzh("Failed to initialize webview for loading SDKCore. ", th2);
        if (!((Boolean) zzba.zzc().zza(zzbgc.zzjw)).booleanValue() || this.zza.zzJ.get() || this.zza.zzK.getAndIncrement() >= ((Integer) zzba.zzc().zza(zzbgc.zzjx)).intValue()) {
            return;
        }
        this.zza.zzW();
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* bridge */ /* synthetic */ void zzb(@Nullable Object obj) {
        zzcec.zze("Initialized webview successfully for SDKCore.");
        if (((Boolean) zzba.zzc().zza(zzbgc.zzjw)).booleanValue()) {
            zzaa zzaaVar = this.zza;
            zzf.zzc(zzaaVar.zzs, zzaaVar.zzk, "sgs", new Pair("sgi_rn", Integer.toString(zzaaVar.zzK.get())));
            this.zza.zzJ.set(true);
        }
    }
}
