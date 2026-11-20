package com.google.android.gms.internal.ads;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzfzf implements Iterator {
    int zzb;
    int zzc;
    int zzd = -1;
    final /* synthetic */ zzfzj zze;

    public /* synthetic */ zzfzf(zzfzj zzfzjVar, zzfze zzfzeVar) {
        this.zze = zzfzjVar;
        this.zzb = zzfzjVar.zzf;
        this.zzc = zzfzjVar.zze();
    }

    private final void zzb() {
        if (this.zze.zzf != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzc >= 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        zzb();
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i11 = this.zzc;
        this.zzd = i11;
        Object objZza = zza(i11);
        this.zzc = this.zze.zzf(this.zzc);
        return objZza;
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzb();
        zzfxe.zzj(this.zzd >= 0, "no calls to next() since the last call to remove()");
        this.zzb += 32;
        int i11 = this.zzd;
        zzfzj zzfzjVar = this.zze;
        zzfzjVar.remove(zzfzj.zzg(zzfzjVar, i11));
        this.zzc--;
        this.zzd = -1;
    }

    public abstract Object zza(int i11);
}
