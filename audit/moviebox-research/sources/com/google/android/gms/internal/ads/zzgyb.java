package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgyb extends zzgyd {
    final /* synthetic */ zzgyl zza;
    private int zzb = 0;
    private final int zzc;

    public zzgyb(zzgyl zzgylVar) {
        this.zza = zzgylVar;
        this.zzc = zzgylVar.zzd();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final byte zza() {
        int i11 = this.zzb;
        if (i11 >= this.zzc) {
            throw new NoSuchElementException();
        }
        this.zzb = i11 + 1;
        return this.zza.zzb(i11);
    }
}
