package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzdoy implements zzgej {
    final /* synthetic */ zzdoz zza;

    public zzdoy(zzdoz zzdozVar) {
        this.zza = zzdozVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th2) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfb)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.zzo().zzw(th2, "omid native display exp");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final void zzb(List list) {
        try {
            zzcjk zzcjkVar = (zzcjk) list.get(0);
            if (zzcjkVar != null) {
                this.zza.zzb(zzcjkVar);
            }
        } catch (ClassCastException | IndexOutOfBoundsException e11) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfb)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.zzo().zzw(e11, "omid native display exp");
            }
        }
    }
}
