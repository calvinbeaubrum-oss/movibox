package com.google.android.gms.internal.ads;

import okhttp3.internal.http2.Settings;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgze {
    private final Object zza;
    private final int zzb;

    public zzgze(Object obj, int i11) {
        this.zza = obj;
        this.zzb = i11;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgze)) {
            return false;
        }
        zzgze zzgzeVar = (zzgze) obj;
        return this.zza == zzgzeVar.zza && this.zzb == zzgzeVar.zzb;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * Settings.DEFAULT_INITIAL_WINDOW_SIZE) + this.zzb;
    }
}
