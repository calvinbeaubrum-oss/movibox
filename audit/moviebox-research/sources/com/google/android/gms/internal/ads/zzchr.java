package com.google.android.gms.internal.ads;

import androidx.core.app.NotificationCompat;
import java.util.HashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzchr implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ long zze;
    final /* synthetic */ long zzf;
    final /* synthetic */ long zzg;
    final /* synthetic */ boolean zzh;
    final /* synthetic */ int zzi;
    final /* synthetic */ int zzj;
    final /* synthetic */ zzchw zzk;

    public zzchr(zzchw zzchwVar, String str, String str2, long j11, long j12, long j13, long j14, long j15, boolean z11, int i11, int i12) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = j11;
        this.zzd = j12;
        this.zze = j13;
        this.zzf = j14;
        this.zzg = j15;
        this.zzh = z11;
        this.zzi = i11;
        this.zzj = i12;
        this.zzk = zzchwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap map = new HashMap();
        map.put(NotificationCompat.CATEGORY_EVENT, "precacheProgress");
        map.put("src", this.zza);
        map.put("cachedSrc", this.zzb);
        map.put("bufferedDuration", Long.toString(this.zzc));
        map.put("totalDuration", Long.toString(this.zzd));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbQ)).booleanValue()) {
            map.put("qoeLoadedBytes", Long.toString(this.zze));
            map.put("qoeCachedBytes", Long.toString(this.zzf));
            map.put("totalBytes", Long.toString(this.zzg));
            map.put("reportTime", Long.toString(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis()));
        }
        map.put("cacheReady", true != this.zzh ? "0" : "1");
        map.put("playerCount", Integer.toString(this.zzi));
        map.put("playerPreparedCount", Integer.toString(this.zzj));
        zzchw.zze(this.zzk, "onPrecacheEvent", map);
    }
}
