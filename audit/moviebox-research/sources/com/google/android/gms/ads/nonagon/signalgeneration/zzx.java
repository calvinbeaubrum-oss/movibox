package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzbxi;
import com.google.android.gms.internal.ads.zzcec;
import com.google.android.gms.internal.ads.zzgej;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class zzx implements zzgej {
    final /* synthetic */ zzbxi zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzaa zzc;

    public zzx(zzaa zzaaVar, zzbxi zzbxiVar, boolean z11) {
        this.zza = zzbxiVar;
        this.zzb = z11;
        this.zzc = zzaaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th2) {
        try {
            this.zza.zze("Internal error: " + th2.getMessage());
        } catch (RemoteException e11) {
            zzcec.zzh("", e11);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        ArrayList<Uri> arrayList = (ArrayList) obj;
        try {
            this.zza.zzf(arrayList);
            if (!this.zzc.zzu && !this.zzb) {
                return;
            }
            for (Uri uri : arrayList) {
                if (this.zzc.zzS(uri)) {
                    this.zzc.zzt.zzc(zzaa.zzac(uri, this.zzc.zzD, "1").toString(), null);
                } else {
                    if (((Boolean) zzba.zzc().zza(zzbgc.zzhx)).booleanValue()) {
                        this.zzc.zzt.zzc(uri.toString(), null);
                    }
                }
            }
        } catch (RemoteException e11) {
            zzcec.zzh("", e11);
        }
    }
}
