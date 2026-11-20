package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzub implements zzwj {
    protected final zzwj[] zza;

    public zzub(zzwj[] zzwjVarArr) {
        this.zza = zzwjVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zzwj
    public final long zzb() {
        long jMin = Long.MAX_VALUE;
        for (zzwj zzwjVar : this.zza) {
            long jZzb = zzwjVar.zzb();
            if (jZzb != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jZzb);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // com.google.android.gms.internal.ads.zzwj
    public final long zzc() {
        long jMin = Long.MAX_VALUE;
        for (zzwj zzwjVar : this.zza) {
            long jZzc = zzwjVar.zzc();
            if (jZzc != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jZzc);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // com.google.android.gms.internal.ads.zzwj
    public final void zzm(long j11) {
        for (zzwj zzwjVar : this.zza) {
            zzwjVar.zzm(j11);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwj
    public final boolean zzo(zzlg zzlgVar) {
        boolean zZzo;
        boolean z11 = false;
        do {
            long jZzc = zzc();
            long j11 = Long.MIN_VALUE;
            if (jZzc == Long.MIN_VALUE) {
                break;
            }
            zzwj[] zzwjVarArr = this.zza;
            int length = zzwjVarArr.length;
            int i11 = 0;
            zZzo = false;
            while (i11 < length) {
                zzwj zzwjVar = zzwjVarArr[i11];
                long jZzc2 = zzwjVar.zzc();
                boolean z12 = jZzc2 != j11 && jZzc2 <= zzlgVar.zza;
                if (jZzc2 == jZzc || z12) {
                    zZzo |= zzwjVar.zzo(zzlgVar);
                }
                i11++;
                j11 = Long.MIN_VALUE;
            }
            z11 |= zZzo;
        } while (zZzo);
        return z11;
    }

    @Override // com.google.android.gms.internal.ads.zzwj
    public final boolean zzp() {
        for (zzwj zzwjVar : this.zza) {
            if (zzwjVar.zzp()) {
                return true;
            }
        }
        return false;
    }
}
