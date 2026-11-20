package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.Intent;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbvl implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbvn zza;

    public zzbvl(zzbvn zzbvnVar) {
        this.zza = zzbvnVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i11) {
        zzbvn zzbvnVar = this.zza;
        Intent intentZzb = zzbvnVar.zzb();
        com.google.android.gms.ads.internal.zzt.zzp();
        com.google.android.gms.ads.internal.util.zzt.zzS(zzbvnVar.zzb, intentZzb);
    }
}
