package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.internal.ads.zzcec;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcx implements MuteThisAdReason {
    private final String zza;
    private final zzcw zzb;

    public zzcx(zzcw zzcwVar) {
        String strZze;
        this.zzb = zzcwVar;
        try {
            strZze = zzcwVar.zze();
        } catch (RemoteException e11) {
            zzcec.zzh("", e11);
            strZze = null;
        }
        this.zza = strZze;
    }

    @Override // com.google.android.gms.ads.MuteThisAdReason
    public final String getDescription() {
        return this.zza;
    }

    public final String toString() {
        return this.zza;
    }

    public final zzcw zza() {
        return this.zzb;
    }
}
