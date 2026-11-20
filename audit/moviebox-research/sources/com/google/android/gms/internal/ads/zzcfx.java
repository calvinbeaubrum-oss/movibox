package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzcfx implements Runnable {
    final /* synthetic */ zzcfz zza;

    public zzcfx(zzcfz zzcfzVar) {
        this.zza = zzcfzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzK("surfaceDestroyed", new String[0]);
    }
}
