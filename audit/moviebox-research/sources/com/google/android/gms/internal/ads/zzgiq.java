package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgiq extends zzghi {
    private final int zza;
    private final int zzb;
    private final int zzc = 16;
    private final zzgio zzd;

    public /* synthetic */ zzgiq(int i11, int i12, int i13, zzgio zzgioVar, zzgip zzgipVar) {
        this.zza = i11;
        this.zzb = i12;
        this.zzd = zzgioVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgiq)) {
            return false;
        }
        zzgiq zzgiqVar = (zzgiq) obj;
        return zzgiqVar.zza == this.zza && zzgiqVar.zzb == this.zzb && zzgiqVar.zzd == this.zzd;
    }

    public final int hashCode() {
        return Objects.hash(zzgiq.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), 16, this.zzd);
    }

    public final String toString() {
        return "AesEax Parameters (variant: " + String.valueOf(this.zzd) + ", " + this.zzb + "-byte IV, 16-byte tag, and " + this.zza + "-byte key)";
    }

    @Override // com.google.android.gms.internal.ads.zzggq
    public final boolean zza() {
        return this.zzd != zzgio.zzc;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zza;
    }

    public final zzgio zzd() {
        return this.zzd;
    }
}
