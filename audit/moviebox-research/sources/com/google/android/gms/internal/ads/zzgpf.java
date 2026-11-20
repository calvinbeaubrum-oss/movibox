package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgpf {
    private final Class zza;
    private final zzgxq zzb;

    public /* synthetic */ zzgpf(Class cls, zzgxq zzgxqVar, zzgpe zzgpeVar) {
        this.zza = cls;
        this.zzb = zzgxqVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgpf)) {
            return false;
        }
        zzgpf zzgpfVar = (zzgpf) obj;
        return zzgpfVar.zza.equals(this.zza) && zzgpfVar.zzb.equals(this.zzb);
    }

    public final int hashCode() {
        return Objects.hash(this.zza, this.zzb);
    }

    public final String toString() {
        zzgxq zzgxqVar = this.zzb;
        return this.zza.getSimpleName() + ", object identifier: " + String.valueOf(zzgxqVar);
    }
}
