package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzin implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzq zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcf zze;
    final /* synthetic */ zzjm zzf;

    public zzin(zzjm zzjmVar, String str, String str2, zzq zzqVar, boolean z11, com.google.android.gms.internal.measurement.zzcf zzcfVar) {
        this.zzf = zzjmVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzqVar;
        this.zzd = z11;
        this.zze = zzcfVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        Bundle bundle;
        RemoteException e11;
        Bundle bundle2 = new Bundle();
        try {
            try {
                zzjm zzjmVar = this.zzf;
                zzdx zzdxVar = zzjmVar.zzb;
                if (zzdxVar == null) {
                    zzjmVar.zzt.zzay().zzd().zzc("Failed to get user properties; not connected to service", this.zza, this.zzb);
                    this.zzf.zzt.zzv().zzR(this.zze, bundle2);
                    return;
                }
                Preconditions.checkNotNull(this.zzc);
                List<zzkw> listZzh = zzdxVar.zzh(this.zza, this.zzb, this.zzd, this.zzc);
                bundle = new Bundle();
                if (listZzh != null) {
                    for (zzkw zzkwVar : listZzh) {
                        String str = zzkwVar.zze;
                        if (str != null) {
                            bundle.putString(zzkwVar.zzb, str);
                        } else {
                            Long l11 = zzkwVar.zzd;
                            if (l11 != null) {
                                bundle.putLong(zzkwVar.zzb, l11.longValue());
                            } else {
                                Double d11 = zzkwVar.zzg;
                                if (d11 != null) {
                                    bundle.putDouble(zzkwVar.zzb, d11.doubleValue());
                                }
                            }
                        }
                    }
                }
                try {
                    this.zzf.zzQ();
                    this.zzf.zzt.zzv().zzR(this.zze, bundle);
                } catch (RemoteException e12) {
                    e11 = e12;
                    this.zzf.zzt.zzay().zzd().zzc("Failed to get user properties; remote exception", this.zza, e11);
                    this.zzf.zzt.zzv().zzR(this.zze, bundle);
                }
            } catch (Throwable th2) {
                th = th2;
                bundle2 = bundle;
                this.zzf.zzt.zzv().zzR(this.zze, bundle2);
                throw th;
            }
        } catch (RemoteException e13) {
            bundle = bundle2;
            e11 = e13;
        } catch (Throwable th3) {
            th = th3;
            this.zzf.zzt.zzv().zzR(this.zze, bundle2);
            throw th;
        }
    }
}
