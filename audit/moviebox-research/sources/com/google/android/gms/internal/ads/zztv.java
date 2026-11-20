package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zztv implements zzwh {
    public final zzwh zza;
    final /* synthetic */ zztw zzb;
    private boolean zzc;

    public zztv(zztw zztwVar, zzwh zzwhVar) {
        this.zzb = zztwVar;
        this.zza = zzwhVar;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003b  */
    @Override // com.google.android.gms.internal.ads.zzwh
    public final int zza(zzlb zzlbVar, zzih zzihVar, int i11) {
        zztw zztwVar = this.zzb;
        if (zztwVar.zzq()) {
            return -3;
        }
        if (this.zzc) {
            zzihVar.zzc(4);
            return -4;
        }
        long jZzb = zztwVar.zzb();
        int iZza = this.zza.zza(zzlbVar, zzihVar, i11);
        if (iZza != -5) {
            long j11 = this.zzb.zzb;
            if (j11 == Long.MIN_VALUE || ((iZza != -4 || zzihVar.zze < j11) && !(iZza == -3 && jZzb == Long.MIN_VALUE && !zzihVar.zzd))) {
                return iZza;
            }
            zzihVar.zzb();
            zzihVar.zzc(4);
            this.zzc = true;
            return -4;
        }
        zzam zzamVar = zzlbVar.zza;
        zzamVar.getClass();
        int i12 = zzamVar.zzC;
        if (i12 != 0) {
            int i13 = this.zzb.zzb == Long.MIN_VALUE ? zzamVar.zzD : 0;
            zzak zzakVarZzb = zzamVar.zzb();
            zzakVarZzb.zzF(i12);
            zzakVarZzb.zzG(i13);
            zzlbVar.zza = zzakVarZzb.zzac();
        } else if (zzamVar.zzD != 0) {
            i12 = 0;
            if (this.zzb.zzb == Long.MIN_VALUE) {
            }
            zzak zzakVarZzb2 = zzamVar.zzb();
            zzakVarZzb2.zzF(i12);
            zzakVarZzb2.zzG(i13);
            zzlbVar.zza = zzakVarZzb2.zzac();
        }
        return -5;
    }

    @Override // com.google.android.gms.internal.ads.zzwh
    public final int zzb(long j11) {
        if (this.zzb.zzq()) {
            return -3;
        }
        return this.zza.zzb(j11);
    }

    public final void zzc() {
        this.zzc = false;
    }

    @Override // com.google.android.gms.internal.ads.zzwh
    public final void zzd() throws IOException {
        this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzwh
    public final boolean zze() {
        return !this.zzb.zzq() && this.zza.zze();
    }
}
