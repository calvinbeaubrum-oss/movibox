package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzwp implements zzup, zzuo {
    private final zzup zza;
    private final long zzb;
    private zzuo zzc;

    public zzwp(zzup zzupVar, long j11) {
        this.zza = zzupVar;
        this.zzb = j11;
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final long zza(long j11, zzmj zzmjVar) {
        long j12 = this.zzb;
        return this.zza.zza(j11 - j12, zzmjVar) + j12;
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzwj
    public final long zzb() {
        long jZzb = this.zza.zzb();
        if (jZzb == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return jZzb + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzwj
    public final long zzc() {
        long jZzc = this.zza.zzc();
        if (jZzc == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return jZzc + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final long zzd() {
        long jZzd = this.zza.zzd();
        return jZzd == C.TIME_UNSET ? C.TIME_UNSET : jZzd + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final long zze(long j11) {
        long j12 = this.zzb;
        return this.zza.zze(j11 - j12) + j12;
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final long zzf(zzyi[] zzyiVarArr, boolean[] zArr, zzwh[] zzwhVarArr, boolean[] zArr2, long j11) {
        zzwh[] zzwhVarArr2 = new zzwh[zzwhVarArr.length];
        int i11 = 0;
        while (true) {
            zzwh zzwhVarZzc = null;
            if (i11 >= zzwhVarArr.length) {
                break;
            }
            zzwo zzwoVar = (zzwo) zzwhVarArr[i11];
            if (zzwoVar != null) {
                zzwhVarZzc = zzwoVar.zzc();
            }
            zzwhVarArr2[i11] = zzwhVarZzc;
            i11++;
        }
        long jZzf = this.zza.zzf(zzyiVarArr, zArr, zzwhVarArr2, zArr2, j11 - this.zzb);
        for (int i12 = 0; i12 < zzwhVarArr.length; i12++) {
            zzwh zzwhVar = zzwhVarArr2[i12];
            if (zzwhVar == null) {
                zzwhVarArr[i12] = null;
            } else {
                zzwh zzwhVar2 = zzwhVarArr[i12];
                if (zzwhVar2 == null || ((zzwo) zzwhVar2).zzc() != zzwhVar) {
                    zzwhVarArr[i12] = new zzwo(zzwhVar, this.zzb);
                }
            }
        }
        return jZzf + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzwi
    public final /* bridge */ /* synthetic */ void zzg(zzwj zzwjVar) {
        zzuo zzuoVar = this.zzc;
        zzuoVar.getClass();
        zzuoVar.zzg(this);
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final zzws zzh() {
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzuo
    public final void zzi(zzup zzupVar) {
        zzuo zzuoVar = this.zzc;
        zzuoVar.getClass();
        zzuoVar.zzi(this);
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final void zzj(long j11, boolean z11) {
        this.zza.zzj(j11 - this.zzb, false);
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final void zzk() throws IOException {
        this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final void zzl(zzuo zzuoVar, long j11) {
        this.zzc = zzuoVar;
        this.zza.zzl(this, j11 - this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzwj
    public final void zzm(long j11) {
        this.zza.zzm(j11 - this.zzb);
    }

    public final zzup zzn() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzwj
    public final boolean zzo(zzlg zzlgVar) {
        long j11 = zzlgVar.zza;
        long j12 = this.zzb;
        zzle zzleVarZza = zzlgVar.zza();
        zzleVarZza.zze(j11 - j12);
        return this.zza.zzo(zzleVarZza.zzg());
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzwj
    public final boolean zzp() {
        return this.zza.zzp();
    }
}
