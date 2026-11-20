package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzfxo implements Iterable {
    final /* synthetic */ CharSequence zza;
    final /* synthetic */ zzfxr zzb;

    public zzfxo(zzfxr zzfxrVar, CharSequence charSequence) {
        this.zza = charSequence;
        this.zzb = zzfxrVar;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.zzb.zzg(this.zza);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        zzfwt.zzb(sb2, this, ", ");
        sb2.append(']');
        return sb2.toString();
    }
}
