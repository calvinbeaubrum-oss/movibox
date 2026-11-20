package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbrw implements zzbec {
    final /* synthetic */ zzbry zza;

    public zzbrw(zzbry zzbryVar) {
        this.zza = zzbryVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbec
    public final void zza(zzbdo zzbdoVar) {
        int i11 = zzbvr.zza;
        synchronized (this.zza.zzf.zzc) {
            this.zza.zzf.zzQ(zzbdoVar, true, null);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbec
    public final void zzb(zzbra zzbraVar, boolean z11, boolean z12, int i11) {
        zzbwb zzbwbVarZze;
        int i12 = zzbvr.zza;
        if (zzbraVar == null) {
            zzbwbVarZze = zzbry.zza;
        } else {
            zzbwbVarZze = ((zzbsn) zzbraVar).zze();
            int iZzg = (int) zzbwbVarZze.zzg();
            if (iZzg > 0) {
                this.zza.zzs(iZzg);
            }
        }
        synchronized (this.zza.zzf.zzc) {
            zzbrx.zzL(this.zza.zzf, zzbwbVarZze, z11, z12);
            this.zza.zze().zzd(i11);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbec
    public final void zzc(zzbcf zzbcfVar, byte[] bArr) {
        int i11 = zzbvr.zza;
        String str = "/" + this.zza.zzb.zzf();
        synchronized (this.zza.zzf.zzc) {
            zzbrx.zzM(this.zza.zzf, zzbcfVar, str);
        }
    }
}
