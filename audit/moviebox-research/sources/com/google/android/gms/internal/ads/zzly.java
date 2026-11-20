package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzly {
    private static final zzur zzt = new zzur(new Object(), -1);
    public final zzcx zza;
    public final zzur zzb;
    public final long zzc;
    public final long zzd;
    public final int zze;

    @Nullable
    public final zziz zzf;
    public final boolean zzg;
    public final zzws zzh;
    public final zzyp zzi;
    public final List zzj;
    public final zzur zzk;
    public final boolean zzl;
    public final int zzm;
    public final zzcg zzn;
    public final boolean zzo = false;
    public volatile long zzp;
    public volatile long zzq;
    public volatile long zzr;
    public volatile long zzs;

    public zzly(zzcx zzcxVar, zzur zzurVar, long j11, long j12, int i11, @Nullable zziz zzizVar, boolean z11, zzws zzwsVar, zzyp zzypVar, List list, zzur zzurVar2, boolean z12, int i12, zzcg zzcgVar, long j13, long j14, long j15, long j16, boolean z13) {
        this.zza = zzcxVar;
        this.zzb = zzurVar;
        this.zzc = j11;
        this.zzd = j12;
        this.zze = i11;
        this.zzf = zzizVar;
        this.zzg = z11;
        this.zzh = zzwsVar;
        this.zzi = zzypVar;
        this.zzj = list;
        this.zzk = zzurVar2;
        this.zzl = z12;
        this.zzm = i12;
        this.zzn = zzcgVar;
        this.zzp = j13;
        this.zzq = j14;
        this.zzr = j15;
        this.zzs = j16;
    }

    public static zzly zzg(zzyp zzypVar) {
        zzcx zzcxVar = zzcx.zza;
        zzur zzurVar = zzt;
        return new zzly(zzcxVar, zzurVar, C.TIME_UNSET, 0L, 1, null, false, zzws.zza, zzypVar, zzgaa.zzl(), zzurVar, false, 0, zzcg.zza, 0L, 0L, 0L, 0L, false);
    }

    public static zzur zzh() {
        return zzt;
    }

    @CheckResult
    public final zzly zza(zzur zzurVar) {
        return new zzly(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, zzurVar, this.zzl, this.zzm, this.zzn, this.zzp, this.zzq, this.zzr, this.zzs, false);
    }

    @CheckResult
    public final zzly zzb(zzur zzurVar, long j11, long j12, long j13, long j14, zzws zzwsVar, zzyp zzypVar, List list) {
        zzur zzurVar2 = this.zzk;
        boolean z11 = this.zzl;
        int i11 = this.zzm;
        zzcg zzcgVar = this.zzn;
        long j15 = this.zzp;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        return new zzly(this.zza, zzurVar, j12, j13, this.zze, this.zzf, this.zzg, zzwsVar, zzypVar, list, zzurVar2, z11, i11, zzcgVar, j15, j14, j11, jElapsedRealtime, false);
    }

    @CheckResult
    public final zzly zzc(boolean z11, int i11) {
        return new zzly(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, z11, i11, this.zzn, this.zzp, this.zzq, this.zzr, this.zzs, false);
    }

    @CheckResult
    public final zzly zzd(@Nullable zziz zzizVar) {
        return new zzly(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzizVar, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzp, this.zzq, this.zzr, this.zzs, false);
    }

    @CheckResult
    public final zzly zze(int i11) {
        return new zzly(this.zza, this.zzb, this.zzc, this.zzd, i11, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzp, this.zzq, this.zzr, this.zzs, false);
    }

    @CheckResult
    public final zzly zzf(zzcx zzcxVar) {
        return new zzly(zzcxVar, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzp, this.zzq, this.zzr, this.zzs, false);
    }

    public final boolean zzi() {
        return this.zze == 3 && this.zzl && this.zzm == 0;
    }
}
