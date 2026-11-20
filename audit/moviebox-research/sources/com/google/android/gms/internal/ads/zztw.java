package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zztw implements zzup, zzuo {
    public final zzup zza;
    long zzb;

    @Nullable
    private zzuo zzc;
    private zztv[] zzd = new zztv[0];
    private long zze = 0;

    public zztw(zzup zzupVar, boolean z11, long j11, long j12) {
        this.zza = zzupVar;
        this.zzb = j12;
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final long zza(long j11, zzmj zzmjVar) {
        if (j11 == 0) {
            return 0L;
        }
        long jMax = Math.max(0L, Math.min(zzmjVar.zzf, j11));
        long j12 = zzmjVar.zzg;
        long j13 = this.zzb;
        long jMax2 = Math.max(0L, Math.min(j12, j13 == Long.MIN_VALUE ? Long.MAX_VALUE : j13 - j11));
        if (jMax != zzmjVar.zzf || jMax2 != zzmjVar.zzg) {
            zzmjVar = new zzmj(jMax, jMax2);
        }
        return this.zza.zza(j11, zzmjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzwj
    public final long zzb() {
        long jZzb = this.zza.zzb();
        if (jZzb != Long.MIN_VALUE) {
            long j11 = this.zzb;
            if (j11 == Long.MIN_VALUE || jZzb < j11) {
                return jZzb;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzwj
    public final long zzc() {
        long jZzc = this.zza.zzc();
        if (jZzc != Long.MIN_VALUE) {
            long j11 = this.zzb;
            if (j11 == Long.MIN_VALUE || jZzc < j11) {
                return jZzc;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final long zzd() {
        if (zzq()) {
            long j11 = this.zze;
            this.zze = C.TIME_UNSET;
            long jZzd = zzd();
            return jZzd != C.TIME_UNSET ? jZzd : j11;
        }
        long jZzd2 = this.zza.zzd();
        if (jZzd2 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        zzek.zzf(jZzd2 >= 0);
        long j12 = this.zzb;
        zzek.zzf(j12 == Long.MIN_VALUE || jZzd2 <= j12);
        return jZzd2;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0035  */
    @Override // com.google.android.gms.internal.ads.zzup
    public final long zze(long j11) {
        this.zze = C.TIME_UNSET;
        boolean z11 = false;
        for (zztv zztvVar : this.zzd) {
            if (zztvVar != null) {
                zztvVar.zzc();
            }
        }
        long jZze = this.zza.zze(j11);
        if (jZze == j11) {
            z11 = true;
        } else if (jZze >= 0) {
            long j12 = this.zzb;
            if (j12 == Long.MIN_VALUE || jZze <= j12) {
                z11 = true;
            }
        }
        zzek.zzf(z11);
        return jZze;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x005c  */
    @Override // com.google.android.gms.internal.ads.zzup
    public final long zzf(zzyi[] zzyiVarArr, boolean[] zArr, zzwh[] zzwhVarArr, boolean[] zArr2, long j11) {
        int length = zzwhVarArr.length;
        this.zzd = new zztv[length];
        zzwh[] zzwhVarArr2 = new zzwh[length];
        int i11 = 0;
        while (true) {
            zzwh zzwhVar = null;
            if (i11 >= zzwhVarArr.length) {
                break;
            }
            zztv[] zztvVarArr = this.zzd;
            zztv zztvVar = (zztv) zzwhVarArr[i11];
            zztvVarArr[i11] = zztvVar;
            if (zztvVar != null) {
                zzwhVar = zztvVar.zza;
            }
            zzwhVarArr2[i11] = zzwhVar;
            i11++;
        }
        long jZzf = this.zza.zzf(zzyiVarArr, zArr, zzwhVarArr2, zArr2, j11);
        long j12 = (zzq() && j11 == 0) ? 0L : j11;
        this.zze = C.TIME_UNSET;
        boolean z11 = true;
        if (jZzf != j12) {
            if (jZzf >= 0) {
                long j13 = this.zzb;
                if (j13 != Long.MIN_VALUE && jZzf > j13) {
                    z11 = false;
                }
            } else {
                z11 = false;
            }
        }
        zzek.zzf(z11);
        for (int i12 = 0; i12 < zzwhVarArr.length; i12++) {
            zzwh zzwhVar2 = zzwhVarArr2[i12];
            if (zzwhVar2 == null) {
                this.zzd[i12] = null;
            } else {
                zztv[] zztvVarArr2 = this.zzd;
                zztv zztvVar2 = zztvVarArr2[i12];
                if (zztvVar2 == null || zztvVar2.zza != zzwhVar2) {
                    zztvVarArr2[i12] = new zztv(this, zzwhVar2);
                }
            }
            zzwhVarArr[i12] = this.zzd[i12];
        }
        return jZzf;
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
        this.zza.zzj(j11, false);
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final void zzk() throws IOException {
        this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final void zzl(zzuo zzuoVar, long j11) {
        this.zzc = zzuoVar;
        this.zza.zzl(this, j11);
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzwj
    public final void zzm(long j11) {
        this.zza.zzm(j11);
    }

    public final void zzn(long j11, long j12) {
        this.zzb = j12;
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzwj
    public final boolean zzo(zzlg zzlgVar) {
        return this.zza.zzo(zzlgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzwj
    public final boolean zzp() {
        return this.zza.zzp();
    }

    public final boolean zzq() {
        return this.zze != C.TIME_UNSET;
    }
}
