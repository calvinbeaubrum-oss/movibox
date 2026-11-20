package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzajm {
    public final int zza;
    public final int zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;
    public final zzam zzf;
    public final int zzg;

    @Nullable
    public final long[] zzh;

    @Nullable
    public final long[] zzi;
    public final int zzj;

    @Nullable
    private final zzajn[] zzk;

    public zzajm(int i11, int i12, long j11, long j12, long j13, zzam zzamVar, int i13, @Nullable zzajn[] zzajnVarArr, int i14, @Nullable long[] jArr, @Nullable long[] jArr2) {
        this.zza = i11;
        this.zzb = i12;
        this.zzc = j11;
        this.zzd = j12;
        this.zze = j13;
        this.zzf = zzamVar;
        this.zzg = i13;
        this.zzk = zzajnVarArr;
        this.zzj = i14;
        this.zzh = jArr;
        this.zzi = jArr2;
    }

    @Nullable
    public final zzajn zza(int i11) {
        return this.zzk[i11];
    }
}
