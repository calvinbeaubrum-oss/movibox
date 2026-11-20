package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbvs implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbvt zza;

    public zzbvs(zzbvt zzbvtVar) {
        this.zza = zzbvtVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i11) {
        this.zza.zzh("User canceled the download.");
    }
}
