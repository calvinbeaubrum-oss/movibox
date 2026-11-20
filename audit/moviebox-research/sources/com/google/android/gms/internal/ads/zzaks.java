package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaks implements zzacx {
    private final zzacx zzb;
    private final zzakp zzc;
    private final SparseArray zzd = new SparseArray();

    public zzaks(zzacx zzacxVar, zzakp zzakpVar) {
        this.zzb = zzacxVar;
        this.zzc = zzakpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzacx
    public final void zzD() {
        this.zzb.zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzacx
    public final void zzO(zzadu zzaduVar) {
        this.zzb.zzO(zzaduVar);
    }

    @Override // com.google.android.gms.internal.ads.zzacx
    public final zzaea zzw(int i11, int i12) {
        if (i12 != 3) {
            return this.zzb.zzw(i11, i12);
        }
        zzaku zzakuVar = (zzaku) this.zzd.get(i11);
        if (zzakuVar != null) {
            return zzakuVar;
        }
        zzaku zzakuVar2 = new zzaku(this.zzb.zzw(i11, 3), this.zzc);
        this.zzd.put(i11, zzakuVar2);
        return zzakuVar2;
    }
}
