package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzcfy implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzcfz zzb;

    public zzcfy(zzcfz zzcfzVar, boolean z11) {
        this.zza = z11;
        this.zzb = zzcfzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzK("windowVisibilityChanged", "isVisible", String.valueOf(this.zza));
    }
}
