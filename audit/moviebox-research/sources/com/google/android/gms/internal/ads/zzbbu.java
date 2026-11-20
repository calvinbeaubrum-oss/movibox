package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbbu {
    final /* synthetic */ zzbbv zza;
    private final byte[] zzb;
    private int zzc;

    public /* synthetic */ zzbbu(zzbbv zzbbvVar, byte[] bArr, zzbbt zzbbtVar) {
        this.zza = zzbbvVar;
        this.zzb = bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzd() {
        try {
            zzbbv zzbbvVar = this.zza;
            if (zzbbvVar.zzb) {
                zzbbvVar.zza.zzj(this.zzb);
                this.zza.zza.zzi(0);
                this.zza.zza.zzg(this.zzc);
                this.zza.zza.zzh(null);
                this.zza.zza.zzf();
            }
        } catch (RemoteException e11) {
            zzcec.zzf("Clearcut log failed", e11);
        }
    }

    public final zzbbu zza(int i11) {
        this.zzc = i11;
        return this;
    }

    public final synchronized void zzc() {
        this.zza.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbbs
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzd();
            }
        });
    }
}
