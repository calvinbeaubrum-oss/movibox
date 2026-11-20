package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbvm implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbvn zza;

    public zzbvm(zzbvn zzbvnVar) {
        this.zza = zzbvnVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i11) {
        this.zza.zzh("Operation denied by user.");
    }
}
