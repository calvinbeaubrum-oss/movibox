package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdxv implements zzdxf {
    private final long zza;
    private final zzdxk zzb;
    private final zzfgd zzc;

    public zzdxv(long j11, Context context, zzdxk zzdxkVar, zzclg zzclgVar, String str) {
        this.zza = j11;
        this.zzb = zzdxkVar;
        zzfgf zzfgfVarZzv = zzclgVar.zzv();
        zzfgfVarZzv.zzb(context);
        zzfgfVarZzv.zza(str);
        this.zzc = zzfgfVarZzv.zzc().zza();
    }

    @Override // com.google.android.gms.internal.ads.zzdxf
    public final void zza() {
    }

    @Override // com.google.android.gms.internal.ads.zzdxf
    public final void zzb(com.google.android.gms.ads.internal.client.zzl zzlVar) {
        try {
            this.zzc.zzf(zzlVar, new zzdxt(this));
        } catch (RemoteException e11) {
            zzcec.zzl("#007 Could not call remote method.", e11);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdxf
    public final void zzc() {
        try {
            this.zzc.zzk(new zzdxu(this));
            this.zzc.zzm(ObjectWrapper.wrap(null));
        } catch (RemoteException e11) {
            zzcec.zzl("#007 Could not call remote method.", e11);
        }
    }
}
