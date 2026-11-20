package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzbxi;
import com.google.android.gms.internal.ads.zzcec;
import com.google.android.gms.internal.ads.zzgej;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class zzy implements zzgej {
    final /* synthetic */ zzbxi zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzaa zzc;

    public zzy(zzaa zzaaVar, zzbxi zzbxiVar, boolean z11) {
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
        List<Uri> list = (List) obj;
        try {
            zzaa.zzI(this.zzc, list);
            this.zza.zzf(list);
            if (!this.zzc.zzv && !this.zzb) {
                return;
            }
            for (Uri uri : list) {
                if (this.zzc.zzR(uri)) {
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
