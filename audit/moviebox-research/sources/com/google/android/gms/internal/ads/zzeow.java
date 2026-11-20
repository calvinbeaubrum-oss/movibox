package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeow {
    private final ConcurrentHashMap zza = new ConcurrentHashMap();
    private final zzdua zzb;

    public zzeow(zzdua zzduaVar) {
        this.zzb = zzduaVar;
    }

    public final zzbus zza(String str) {
        if (this.zza.containsKey(str)) {
            return (zzbus) this.zza.get(str);
        }
        return null;
    }

    public final void zzb(String str) {
        try {
            this.zza.put(str, this.zzb.zzb(str));
        } catch (RemoteException e11) {
            zzcec.zzh("Couldn't create RTB adapter : ", e11);
        }
    }
}
