package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;
import android.net.Uri;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class zzaw implements DialogInterface.OnClickListener {
    final /* synthetic */ zzax zza;

    public zzaw(zzax zzaxVar) {
        this.zza = zzaxVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i11) {
        com.google.android.gms.ads.internal.zzt.zzp();
        zzt.zzT(this.zza.zza, Uri.parse("https://support.google.com/dfp_premium/answer/7160685#push"));
    }
}
