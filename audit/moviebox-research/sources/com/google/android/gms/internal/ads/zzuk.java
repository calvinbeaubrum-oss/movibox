package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzuk extends zzuf {
    public static final Object zzd = new Object();

    @Nullable
    private final Object zze;

    @Nullable
    private final Object zzf;

    private zzuk(zzcx zzcxVar, @Nullable Object obj, @Nullable Object obj2) {
        super(zzcxVar);
        this.zze = obj;
        this.zzf = obj2;
    }

    public static zzuk zzq(zzbp zzbpVar) {
        return new zzuk(new zzul(zzbpVar), zzcw.zza, zzd);
    }

    public static zzuk zzr(zzcx zzcxVar, @Nullable Object obj, @Nullable Object obj2) {
        return new zzuk(zzcxVar, obj, obj2);
    }

    @Override // com.google.android.gms.internal.ads.zzuf, com.google.android.gms.internal.ads.zzcx
    public final int zza(Object obj) {
        Object obj2;
        if (zzd.equals(obj) && (obj2 = this.zzf) != null) {
            obj = obj2;
        }
        return this.zzc.zza(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzuf, com.google.android.gms.internal.ads.zzcx
    public final zzcu zzd(int i11, zzcu zzcuVar, boolean z11) {
        this.zzc.zzd(i11, zzcuVar, z11);
        if (zzfy.zzF(zzcuVar.zzc, this.zzf) && z11) {
            zzcuVar.zzc = zzd;
        }
        return zzcuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzuf, com.google.android.gms.internal.ads.zzcx
    public final zzcw zze(int i11, zzcw zzcwVar, long j11) {
        this.zzc.zze(i11, zzcwVar, j11);
        if (zzfy.zzF(zzcwVar.zzc, this.zze)) {
            zzcwVar.zzc = zzcw.zza;
        }
        return zzcwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzuf, com.google.android.gms.internal.ads.zzcx
    public final Object zzf(int i11) {
        Object objZzf = this.zzc.zzf(i11);
        return zzfy.zzF(objZzf, this.zzf) ? zzd : objZzf;
    }

    public final zzuk zzp(zzcx zzcxVar) {
        return new zzuk(zzcxVar, this.zze, this.zzf);
    }
}
