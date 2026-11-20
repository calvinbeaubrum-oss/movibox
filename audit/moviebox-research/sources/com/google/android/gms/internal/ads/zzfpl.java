package com.google.android.gms.internal.ads;

import android.webkit.WebView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzfpl implements Runnable {
    final /* synthetic */ zzfpm zza;
    private final WebView zzb;

    public zzfpl(zzfpm zzfpmVar) {
        this.zza = zzfpmVar;
        this.zzb = zzfpmVar.zza;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.destroy();
    }
}
