package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbvp implements View.OnClickListener {
    final /* synthetic */ zzbvq zza;

    public zzbvp(zzbvq zzbvqVar) {
        this.zza = zzbvqVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.zza.zza(true);
    }
}
