package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzfqa implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        if (zzfqd.zzc != null) {
            zzfqd.zzc.post(zzfqd.zzd);
            zzfqd.zzc.postDelayed(zzfqd.zze, 200L);
        }
    }
}
