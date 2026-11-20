package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhe implements zzgv {

    @Nullable
    private zzhy zzb;

    @Nullable
    private String zzc;
    private boolean zzf;
    private final zzhs zza = new zzhs();
    private int zzd = 8000;
    private int zze = 8000;

    public final zzhe zzb(boolean z11) {
        this.zzf = true;
        return this;
    }

    public final zzhe zzc(int i11) {
        this.zzd = i11;
        return this;
    }

    public final zzhe zzd(int i11) {
        this.zze = i11;
        return this;
    }

    public final zzhe zze(@Nullable zzhy zzhyVar) {
        this.zzb = zzhyVar;
        return this;
    }

    public final zzhe zzf(@Nullable String str) {
        this.zzc = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgv
    /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final zzhj zza() {
        zzhj zzhjVar = new zzhj(this.zzc, this.zzd, this.zze, this.zzf, this.zza);
        zzhy zzhyVar = this.zzb;
        if (zzhyVar != null) {
            zzhjVar.zzf(zzhyVar);
        }
        return zzhjVar;
    }
}
