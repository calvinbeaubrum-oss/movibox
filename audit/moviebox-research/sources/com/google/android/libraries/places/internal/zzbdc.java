package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzbdc extends zzayo {
    public final String toString() {
        zzmm zzmmVarZzb = zzmn.zzb(this);
        zzmmVarZzb.zzd("delegate", zzf());
        return zzmmVarZzb.toString();
    }

    @Override // com.google.android.libraries.places.internal.zzayo
    public void zza(String str, Throwable th2) {
        zzf().zza(str, th2);
    }

    @Override // com.google.android.libraries.places.internal.zzayo
    public final void zzb() {
        zzf().zzb();
    }

    @Override // com.google.android.libraries.places.internal.zzayo
    public void zzc(int i11) {
        throw null;
    }

    public abstract zzayo zzf();
}
