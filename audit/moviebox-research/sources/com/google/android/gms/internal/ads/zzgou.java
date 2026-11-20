package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgou {
    private final Class zza;
    private final Class zzb;

    public /* synthetic */ zzgou(Class cls, Class cls2, zzgot zzgotVar) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgou)) {
            return false;
        }
        zzgou zzgouVar = (zzgou) obj;
        return zzgouVar.zza.equals(this.zza) && zzgouVar.zzb.equals(this.zzb);
    }

    public final int hashCode() {
        return Objects.hash(this.zza, this.zzb);
    }

    public final String toString() {
        Class cls = this.zzb;
        return this.zza.getSimpleName() + " with primitive type: " + cls.getSimpleName();
    }
}
