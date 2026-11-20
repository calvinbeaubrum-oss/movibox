package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzvz implements zzyr {
    public long zza;
    public long zzb;

    @Nullable
    public zzyq zzc;

    @Nullable
    public zzvz zzd;

    public zzvz(long j11, int i11) {
        zze(j11, 65536);
    }

    public final int zza(long j11) {
        long j12 = j11 - this.zza;
        int i11 = this.zzc.zzb;
        return (int) j12;
    }

    public final zzvz zzb() {
        this.zzc = null;
        zzvz zzvzVar = this.zzd;
        this.zzd = null;
        return zzvzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzyr
    public final zzyq zzc() {
        zzyq zzyqVar = this.zzc;
        zzyqVar.getClass();
        return zzyqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzyr
    @Nullable
    public final zzyr zzd() {
        zzvz zzvzVar = this.zzd;
        if (zzvzVar == null || zzvzVar.zzc == null) {
            return null;
        }
        return zzvzVar;
    }

    public final void zze(long j11, int i11) {
        zzek.zzf(this.zzc == null);
        this.zza = j11;
        this.zzb = j11 + PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
    }
}
