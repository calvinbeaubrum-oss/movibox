package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzwl extends zzcx {
    private static final Object zzc = new Object();
    private static final zzbp zzd;
    private final long zze;
    private final long zzf;
    private final boolean zzg;

    @Nullable
    private final zzbp zzh;

    @Nullable
    private final zzbf zzi;

    static {
        zzar zzarVar = new zzar();
        zzarVar.zza("SinglePeriodTimeline");
        zzarVar.zzb(Uri.EMPTY);
        zzd = zzarVar.zzc();
    }

    public zzwl(long j11, long j12, long j13, long j14, long j15, long j16, long j17, boolean z11, boolean z12, boolean z13, @Nullable Object obj, zzbp zzbpVar, @Nullable zzbf zzbfVar) {
        this.zze = j14;
        this.zzf = j15;
        this.zzg = z11;
        zzbpVar.getClass();
        this.zzh = zzbpVar;
        this.zzi = zzbfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcx
    public final int zza(Object obj) {
        return zzc.equals(obj) ? 0 : -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcx
    public final int zzb() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzcx
    public final int zzc() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzcx
    public final zzcu zzd(int i11, zzcu zzcuVar, boolean z11) {
        zzek.zza(i11, 0, 1);
        zzcuVar.zzl(null, z11 ? zzc : null, 0, this.zze, 0L, zzd.zza, false);
        return zzcuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcx
    public final zzcw zze(int i11, zzcw zzcwVar, long j11) {
        zzek.zza(i11, 0, 1);
        Object obj = zzcw.zza;
        zzbp zzbpVar = this.zzh;
        long j12 = this.zzf;
        zzcwVar.zza(obj, zzbpVar, null, C.TIME_UNSET, C.TIME_UNSET, C.TIME_UNSET, this.zzg, false, this.zzi, 0L, j12, 0, 0, 0L);
        return zzcwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcx
    public final Object zzf(int i11) {
        zzek.zza(i11, 0, 1);
        return zzc;
    }
}
