package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzqt {
    private final zzdt[] zza;
    private final zzrl zzb;
    private final zzdw zzc;

    public zzqt(zzdt... zzdtVarArr) {
        zzrl zzrlVar = new zzrl();
        zzdw zzdwVar = new zzdw();
        zzdt[] zzdtVarArr2 = {zzrlVar, zzdwVar};
        this.zza = zzdtVarArr2;
        System.arraycopy(zzdtVarArr, 0, zzdtVarArr2, 0, 0);
        this.zzb = zzrlVar;
        this.zzc = zzdwVar;
    }

    public final long zza(long j11) {
        return this.zzc.zzi(j11);
    }

    public final long zzb() {
        return this.zzb.zzo();
    }

    public final zzcg zzc(zzcg zzcgVar) {
        this.zzc.zzk(zzcgVar.zzc);
        this.zzc.zzj(zzcgVar.zzd);
        return zzcgVar;
    }

    public final boolean zzd(boolean z11) {
        this.zzb.zzp(z11);
        return z11;
    }

    public final zzdt[] zze() {
        return this.zza;
    }
}
