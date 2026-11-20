package com.google.android.gms.internal.ads;

import android.media.MediaPlayer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzcfh implements Runnable {
    final /* synthetic */ MediaPlayer zza;
    final /* synthetic */ zzcfp zzb;

    public zzcfh(zzcfp zzcfpVar, MediaPlayer mediaPlayer) {
        this.zza = mediaPlayer;
        this.zzb = zzcfpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcfp.zzl(this.zzb, this.zza);
        zzcfp zzcfpVar = this.zzb;
        if (zzcfpVar.zzq != null) {
            zzcfpVar.zzq.zzf();
        }
    }
}
