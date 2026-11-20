package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzaip {
    public final int zza;
    public int zzb;
    public int zzc;
    public long zzd;
    private final boolean zze;
    private final zzfp zzf;
    private final zzfp zzg;
    private int zzh;
    private int zzi;

    public zzaip(zzfp zzfpVar, zzfp zzfpVar2, boolean z11) throws zzcc {
        this.zzg = zzfpVar;
        this.zzf = zzfpVar2;
        this.zze = z11;
        zzfpVar2.zzK(12);
        this.zza = zzfpVar2.zzp();
        zzfpVar.zzK(12);
        this.zzi = zzfpVar.zzp();
        zzacy.zzb(zzfpVar.zzg() == 1, "first_chunk must be 1");
        this.zzb = -1;
    }

    public final boolean zza() {
        int i11 = this.zzb + 1;
        this.zzb = i11;
        if (i11 == this.zza) {
            return false;
        }
        this.zzd = this.zze ? this.zzf.zzv() : this.zzf.zzu();
        if (this.zzb == this.zzh) {
            this.zzc = this.zzg.zzp();
            this.zzg.zzL(4);
            int i12 = this.zzi - 1;
            this.zzi = i12;
            this.zzh = i12 > 0 ? (-1) + this.zzg.zzp() : -1;
        }
        return true;
    }
}
