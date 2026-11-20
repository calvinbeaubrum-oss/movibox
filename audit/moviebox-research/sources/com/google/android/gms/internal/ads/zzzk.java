package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzzk {
    public static final zzze zza = new zzze(0, C.TIME_UNSET, null);
    public static final zzze zzb = new zzze(1, C.TIME_UNSET, null);
    public static final zzze zzc = new zzze(2, C.TIME_UNSET, null);
    public static final zzze zzd = new zzze(3, C.TIME_UNSET, null);
    private final ExecutorService zze = zzfy.zzD("ExoPlayer:Loader:ProgressiveMediaPeriod");

    @Nullable
    private zzzf zzf;

    @Nullable
    private IOException zzg;

    public zzzk(String str) {
    }

    public static zzze zzb(boolean z11, long j11) {
        return new zzze(z11 ? 1 : 0, j11, null);
    }

    public final long zza(zzzg zzzgVar, zzzc zzzcVar, int i11) {
        Looper looperMyLooper = Looper.myLooper();
        zzek.zzb(looperMyLooper);
        this.zzg = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        new zzzf(this, looperMyLooper, zzzgVar, zzzcVar, i11, jElapsedRealtime).zzc(0L);
        return jElapsedRealtime;
    }

    public final void zzg() {
        zzzf zzzfVar = this.zzf;
        zzek.zzb(zzzfVar);
        zzzfVar.zza(false);
    }

    public final void zzh() {
        this.zzg = null;
    }

    public final void zzi(int i11) throws IOException {
        IOException iOException = this.zzg;
        if (iOException != null) {
            throw iOException;
        }
        zzzf zzzfVar = this.zzf;
        if (zzzfVar != null) {
            zzzfVar.zzb(i11);
        }
    }

    public final void zzj(@Nullable zzzh zzzhVar) {
        zzzf zzzfVar = this.zzf;
        if (zzzfVar != null) {
            zzzfVar.zza(true);
        }
        this.zze.execute(new zzzi(zzzhVar));
        this.zze.shutdown();
    }

    public final boolean zzk() {
        return this.zzg != null;
    }

    public final boolean zzl() {
        return this.zzf != null;
    }
}
