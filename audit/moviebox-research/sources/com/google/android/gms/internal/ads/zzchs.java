package com.google.android.gms.internal.ads;

import androidx.core.app.NotificationCompat;
import java.util.HashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzchs implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ int zzc;
    final /* synthetic */ int zzd;
    final /* synthetic */ long zze;
    final /* synthetic */ long zzf;
    final /* synthetic */ boolean zzg;
    final /* synthetic */ int zzh;
    final /* synthetic */ int zzi;
    final /* synthetic */ zzchw zzj;

    public zzchs(zzchw zzchwVar, String str, String str2, int i11, int i12, long j11, long j12, boolean z11, int i13, int i14) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = i11;
        this.zzd = i12;
        this.zze = j11;
        this.zzf = j12;
        this.zzg = z11;
        this.zzh = i13;
        this.zzi = i14;
        this.zzj = zzchwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap map = new HashMap();
        map.put(NotificationCompat.CATEGORY_EVENT, "precacheProgress");
        map.put("src", this.zza);
        map.put("cachedSrc", this.zzb);
        map.put("bytesLoaded", Integer.toString(this.zzc));
        map.put("totalBytes", Integer.toString(this.zzd));
        map.put("bufferedDuration", Long.toString(this.zze));
        map.put("totalDuration", Long.toString(this.zzf));
        map.put("cacheReady", true != this.zzg ? "0" : "1");
        map.put("playerCount", Integer.toString(this.zzh));
        map.put("playerPreparedCount", Integer.toString(this.zzi));
        zzchw.zze(this.zzj, "onPrecacheEvent", map);
    }
}
