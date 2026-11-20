package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzaoe implements zzanx {
    final /* synthetic */ zzaog zza;
    private final zzfo zzb = new zzfo(new byte[4], 4);

    public zzaoe(zzaog zzaogVar) {
        this.zza = zzaogVar;
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final void zza(zzfp zzfpVar) {
        if (zzfpVar.zzm() == 0 && (zzfpVar.zzm() & 128) != 0) {
            zzfpVar.zzL(6);
            int iZzb = zzfpVar.zzb() / 4;
            for (int i11 = 0; i11 < iZzb; i11++) {
                zzfpVar.zzF(this.zzb, 4);
                zzfo zzfoVar = this.zzb;
                int iZzd = zzfoVar.zzd(16);
                zzfoVar.zzm(3);
                if (iZzd == 0) {
                    this.zzb.zzm(13);
                } else {
                    int iZzd2 = this.zzb.zzd(13);
                    if (this.zza.zzg.get(iZzd2) == null) {
                        zzaog zzaogVar = this.zza;
                        zzaogVar.zzg.put(iZzd2, new zzany(new zzaof(zzaogVar, iZzd2)));
                        this.zza.zzm++;
                    }
                }
            }
            this.zza.zzg.remove(0);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final void zzb(zzfw zzfwVar, zzacx zzacxVar, zzaok zzaokVar) {
    }
}
