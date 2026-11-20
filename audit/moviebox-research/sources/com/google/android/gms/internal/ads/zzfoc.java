package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfoc {
    private boolean zza;

    public final void zza(Context context) {
        zzfpt.zzb(context, "Application Context cannot be null");
        if (this.zza) {
            return;
        }
        this.zza = true;
        zzfpc.zzb().zzd(context);
        zzfou.zza().zzd(context);
        zzfpn.zzb(context);
        zzfpo.zzd(context);
        zzfpr.zza(context);
        zzfoz.zzb().zzc(context);
        zzfot.zza().zzd(context);
    }

    public final boolean zzb() {
        return this.zza;
    }
}
