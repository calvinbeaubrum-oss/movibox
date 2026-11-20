package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzafp implements zzacx {
    private final long zzb;
    private final zzacx zzc;

    public zzafp(long j11, zzacx zzacxVar) {
        this.zzb = j11;
        this.zzc = zzacxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzacx
    public final void zzD() {
        this.zzc.zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzacx
    public final void zzO(zzadu zzaduVar) {
        this.zzc.zzO(new zzafo(this, zzaduVar, zzaduVar));
    }

    @Override // com.google.android.gms.internal.ads.zzacx
    public final zzaea zzw(int i11, int i12) {
        return this.zzc.zzw(i11, i12);
    }
}
