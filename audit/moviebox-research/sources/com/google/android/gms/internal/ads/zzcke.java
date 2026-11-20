package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzcke implements Runnable {
    final /* synthetic */ zzckf zza;

    public zzcke(zzckf zzckfVar) {
        this.zza = zzckfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        super/*android.webkit.WebView*/.destroy();
    }
}
